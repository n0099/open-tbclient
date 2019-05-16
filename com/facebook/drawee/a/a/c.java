package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jTE;
    private static final Class<?> jQR = c.class;
    private static volatile boolean jTF = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jTF) {
            com.facebook.common.c.a.f(jQR, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jTF = true;
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
        jTE = new f(context, bVar);
        SimpleDraweeView.b(jTE);
    }

    public static e cCs() {
        return jTE.get();
    }

    public static j cCt() {
        return j.cFI();
    }

    public static com.facebook.imagepipeline.d.g cCu() {
        return cCt().cCu();
    }
}
