package com.facebook.common.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
/* loaded from: classes13.dex */
public interface b {

    /* loaded from: classes13.dex */
    public interface a {
        void fJ(String str, String str2);
    }

    Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);

    void a(com.facebook.common.g.a aVar);

    void a(a aVar);
}
