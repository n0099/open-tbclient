package com.facebook.common.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
/* loaded from: classes11.dex */
public interface b {

    /* loaded from: classes11.dex */
    public interface a {
        void fb(String str, String str2);
    }

    void a(com.facebook.common.g.a aVar);

    void a(a aVar);

    Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);
}
