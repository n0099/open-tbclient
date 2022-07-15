package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
/* loaded from: classes6.dex */
public interface po2 {
    Point a(Context context, Bitmap bitmap) throws Exception;

    Bitmap decodeRegion(Rect rect, int i);

    Point init(Context context, Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
