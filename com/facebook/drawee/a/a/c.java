package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f ilI;
    private static final Class<?> iiR = c.class;
    private static volatile boolean ilJ = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (ilJ) {
            com.facebook.common.c.a.f(iiR, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            ilJ = true;
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
        ilI = new f(context, bVar);
        SimpleDraweeView.initialize(ilI);
    }

    public static e bVt() {
        return ilI.get();
    }

    public static j bVu() {
        return j.bYF();
    }

    public static com.facebook.imagepipeline.d.g bVv() {
        return bVu().bVv();
    }
}
