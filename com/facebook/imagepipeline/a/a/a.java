package com.facebook.imagepipeline.a.a;

import android.content.Context;
import com.facebook.imagepipeline.d.h;
import okhttp3.OkHttpClient;
/* loaded from: classes10.dex */
public class a {
    public static h.a go(Context context) {
        return h.go(context).a(new b(context));
    }

    public static h.a a(Context context, OkHttpClient okHttpClient) {
        return h.go(context).a(new b(okHttpClient));
    }
}
