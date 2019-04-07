package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jAO;
    private static final Class<?> jya = c.class;
    private static volatile boolean jAP = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jAP) {
            com.facebook.common.c.a.f(jya, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jAP = true;
        }
        Context applicationContext = context.getApplicationContext();
        if (hVar == null) {
            j.initialize(applicationContext);
        } else {
            j.a(hVar);
        }
        a(applicationContext, bVar);
    }

    private static void a(Context context, @Nullable b bVar) {
        jAO = new f(context, bVar);
        SimpleDraweeView.b(jAO);
    }

    public static e cuw() {
        return jAO.get();
    }

    public static j cux() {
        return j.cxM();
    }

    public static com.facebook.imagepipeline.d.g cuy() {
        return cux().cuy();
    }
}
