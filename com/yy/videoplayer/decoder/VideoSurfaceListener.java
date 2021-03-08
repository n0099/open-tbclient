package com.yy.videoplayer.decoder;

import android.view.Surface;
import android.view.View;
import com.yy.videoplayer.decoder.VideoConstant;
/* loaded from: classes6.dex */
public interface VideoSurfaceListener {
    void OnSurfaceChanged(View view, Surface surface, int i, int i2, int i3, int i4, int i5, VideoConstant.OrientationType orientationType, VideoConstant.ScaleMode scaleMode);

    void OnSurfaceCreated();

    void OnSurfaceDestroyed(Surface surface);

    void OnSurfaceRedraw();
}
