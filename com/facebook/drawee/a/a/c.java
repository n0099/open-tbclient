package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f kcy;
    private static final Class<?> jZN = c.class;
    private static volatile boolean kcz = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (kcz) {
            com.facebook.common.c.a.e(jZN, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            kcz = true;
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
        kcy = new f(context, bVar);
        SimpleDraweeView.b(kcy);
    }

    public static e cDB() {
        return kcy.get();
    }

    public static j cDC() {
        return j.cGS();
    }

    public static com.facebook.imagepipeline.d.g cDD() {
        return cDC().cDD();
    }
}
