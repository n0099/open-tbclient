package com.yy.mediaframework.screenlive;

import android.view.Surface;
/* loaded from: classes6.dex */
public interface ScreenSurfaceCallback {
    void attachSurface(Surface surface);

    void detachSurface();

    void surfaceChange(Surface surface);

    void surfaceCreated(Surface surface);

    void surfaceDestroyed(Surface surface);
}
