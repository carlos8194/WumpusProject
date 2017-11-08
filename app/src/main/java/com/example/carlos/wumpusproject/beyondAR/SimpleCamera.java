package com.example.carlos.wumpusproject.beyondAR;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.util.location.BeyondarLocationManager;
import com.beyondar.android.view.BeyondarGLSurfaceView;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.World;
import com.example.carlos.wumpusproject.R;
import com.example.carlos.wumpusproject.utils.Config;

import java.util.ArrayList;
import java.util.Vector;

public class SimpleCamera extends AppCompatActivity implements OnClickBeyondarObjectListener{

    private BeyondarFragmentSupport mBeyondarFragment;
    private World mWorld;
    private CustomWorldHelper customWorldHelper;
    private Vector<Double> coordenadasIniciales;

    /** Llamado cuando se crea la actividad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String Permiso[] = {"android.permission.CAMERA", "android.permission.ACCESS_FINE_LOCATION"};
        // Start home activity
        requestPermission(Permiso, 1);
        // Hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_simple_camera);
        customWorldHelper = new CustomWorldHelper();
        coordenadasIniciales = Config.coordenadasIniciales;

        mBeyondarFragment = (BeyondarFragmentSupport) getSupportFragmentManager().findFragmentById(
                R.id.beyondarFragment);

        BeyondarLocationManager.setLocationManager((LocationManager) this.getSystemService(Context.LOCATION_SERVICE));

        // We create the world and fill it ...
        mWorld = customWorldHelper.generateObjects(this, coordenadasIniciales);

        /* Parametros para variar la distancia de los objetos TODO cambiar parametros */
        mBeyondarFragment.setMaxDistanceToRender(3000); // Asigno distancia máxima de renderización de objetos
        mBeyondarFragment.setDistanceFactor(4); // El factor de distancia de objetos (más cerca entre mayor valor)
        mBeyondarFragment.setPushAwayDistance(0); // Para alejar un poco los objetos que están muy cerca
        mBeyondarFragment.setPullCloserDistance(0); // Para acercar un poco los objetos que están muy lejos
        mBeyondarFragment.setWorld(mWorld);

        //BeyondarLocationManager.enable();


        //Permitimos que BeyondAR actualice automáticamente la posición del mundo con respecto al usuario
        BeyondarLocationManager.addWorldLocationUpdate(mWorld);

        // Le pasamos el LocationManager al BeyondarLocationManager.
        BeyondarLocationManager
                .setLocationManager((LocationManager) getSystemService(Context.LOCATION_SERVICE));

        // We also can see the Frames per seconds
        mBeyondarFragment.showFPS(true);
    }

    /**
     * Metodo para manejar si el usuario toca un geo objeto presente en la camara.
     * @param arrayList: Lista de los geo objetos presentes.
     */
    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> arrayList) {
        Toast.makeText(this, "Clicked on: " + arrayList.get(0).getName(), Toast.LENGTH_LONG).show();
    }

    /**
     * Metodo encargado de mostrar los dialogos de solicitud de permisos si es necesario.
     *
     * @param permiso               hilera de permisos por pedir
     * @param permissionRequestCode resultado de obtencion de permisos
     */
    public void requestPermission(String permiso[], int permissionRequestCode) {
        //Preguntar por permiso
        if (askPermissions()) {
            ActivityCompat.requestPermissions(this, permiso, permissionRequestCode);
        }
    }

    /**
     * Metodo encargado de cerciorarse si es o no necesaria la solicitud dinamica de permisos.
     *
     * @return verdadero si android del dispositivo es mayor a Lollipop, en caso contrario falso
     */
    private boolean askPermissions() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            return true;
        }
        return false;
    }

    /**
     * Verifica que tenga los permisos apropiados para acceder a la ubicación de usuario y cámara.
     *
     * @param requestCode  codigo del permiso
     * @param permissions  los permisos que se solicitan
     * @param grantResults indica si permiso es concedido o no
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                Boolean camera = this.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
                Boolean location = this.checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
                if (location && camera) {
                    //se crea bien
                    //startActivity(new Intent(SimpleCamera.this, SimpleCamera.class));
                    //finish();
                }
                break;
        }
    }
}