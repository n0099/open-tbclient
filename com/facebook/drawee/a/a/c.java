package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f kaM;
    private static final Class<?> jYa = c.class;
    private static volatile boolean kaN = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (kaN) {
            com.facebook.common.c.a.f(jYa, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            kaN = true;
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
        kaM = new f(context, bVar);
        SimpleDraweeView.b(kaM);
    }

    public static e cFu() {
        return kaM.get();
    }

    public static j cFv() {
        return j.cIM();
    }

    public static com.facebook.imagepipeline.d.g cFw() {
        return cFv().cFw();
    }
}
