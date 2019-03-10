package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jBC;
    private static final Class<?> jyO = c.class;
    private static volatile boolean jBD = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jBD) {
            com.facebook.common.c.a.f(jyO, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jBD = true;
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
        jBC = new f(context, bVar);
        SimpleDraweeView.b(jBC);
    }

    public static e cuA() {
        return jBC.get();
    }

    public static j cuB() {
        return j.cxQ();
    }

    public static com.facebook.imagepipeline.d.g cuC() {
        return cuB().cuC();
    }
}
