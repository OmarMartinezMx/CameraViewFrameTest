package mx.omarmartinez.frametest;

import android.util.Log;

import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;

public class FrameAnalysis {

    String TAG = "FrameAnalysis";

    public FrameProcessor frameProcessor = new FrameProcessor(){
        @Override
        public void process(Frame frame){
            Log.i(TAG, "process:");
        }
    };
}
