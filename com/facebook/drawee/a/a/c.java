package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jTF;
    private static final Class<?> jQS = c.class;
    private static volatile boolean jTG = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jTG) {
            com.facebook.common.c.a.f(jQS, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jTG = true;
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
        jTF = new f(context, bVar);
        SimpleDraweeView.b(jTF);
    }

    public static e cCu() {
        return jTF.get();
    }

    public static j cCv() {
        return j.cFK();
    }

    public static com.facebook.imagepipeline.d.g cCw() {
        return cCv().cCw();
    }
}
