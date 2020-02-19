package mx.omarmartinez.frametest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.Flash;

public class MainActivity extends AppCompatActivity {

    private CameraView camera;
    FrameAnalysis frameAnalysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = findViewById(R.id.surfaceView);
        camera.setAudio(Audio.OFF);


    }

    @Override
    protected void onResume() {

        camera.open();
        camera.setFlash(Flash.TORCH);

        frameAnalysis = new FrameAnalysis();

        camera.addFrameProcessor(frameAnalysis.frameProcessor);

        super.onResume();
    }

    @Override
    protected void onPause() {
        camera.close();
        camera.setFlash(Flash.OFF);
        if(frameAnalysis != null){
            camera.removeFrameProcessor(frameAnalysis.frameProcessor);
        }
        super.onPause();
    }
}
