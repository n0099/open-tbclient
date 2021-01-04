package com.kwai.player.vr;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes5.dex */
public class SurfaceUtil {
    private static final String TAG = "SurfaceUtil";

    public static Surface create(SurfaceTexture surfaceTexture) {
        try {
            Surface surface = new Surface(surfaceTexture);
            Log.i(TAG, "create " + surface);
            return surface;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void release(Surface surface) {
        if (surface != null) {
            try {
                surface.release();
                Log.i(TAG, "release " + surface);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
