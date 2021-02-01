package com.yy.mediaframework.screenshot;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
public interface ScreenShotCallback {
    void onError(Throwable th);

    void onTaked(Bitmap bitmap);
}
