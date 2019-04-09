package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jAP;
    private static final Class<?> jyb = c.class;
    private static volatile boolean jAQ = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jAQ) {
            com.facebook.common.c.a.f(jyb, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jAQ = true;
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
        jAP = new f(context, bVar);
        SimpleDraweeView.b(jAP);
    }

    public static e cuw() {
        return jAP.get();
    }

    public static j cux() {
        return j.cxM();
    }

    public static com.facebook.imagepipeline.d.g cuy() {
        return cux().cuy();
    }
}
