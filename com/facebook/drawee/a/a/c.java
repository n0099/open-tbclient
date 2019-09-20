package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f kep;
    private static final Class<?> kbD = c.class;
    private static volatile boolean keq = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (keq) {
            com.facebook.common.c.a.f(kbD, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            keq = true;
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
        kep = new f(context, bVar);
        SimpleDraweeView.b(kep);
    }

    public static e cGD() {
        return kep.get();
    }

    public static j cGE() {
        return j.cJV();
    }

    public static com.facebook.imagepipeline.d.g cGF() {
        return cGE().cGF();
    }
}
