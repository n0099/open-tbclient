package com.qq.e.comm.plugin.ab.d;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
/* loaded from: classes3.dex */
public interface f {
    void a(int i);

    void a(int i, String str, String str2);

    void a(ValueCallback<Uri> valueCallback, Intent intent);

    void a(String str);

    void a(String str, Bitmap bitmap);

    void b(String str);

    boolean b(ValueCallback<Uri[]> valueCallback, Intent intent);

    void c(String str);

    void d_();
}
