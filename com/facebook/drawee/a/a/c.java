package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jTI;
    private static final Class<?> jQV = c.class;
    private static volatile boolean jTJ = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jTJ) {
            com.facebook.common.c.a.f(jQV, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jTJ = true;
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
        jTI = new f(context, bVar);
        SimpleDraweeView.b(jTI);
    }

    public static e cCt() {
        return jTI.get();
    }

    public static j cCu() {
        return j.cFJ();
    }

    public static com.facebook.imagepipeline.d.g cCv() {
        return cCu().cCv();
    }
}
