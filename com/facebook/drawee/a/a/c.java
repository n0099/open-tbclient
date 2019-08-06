package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f kbS;
    private static final Class<?> jZg = c.class;
    private static volatile boolean kbT = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (kbT) {
            com.facebook.common.c.a.f(jZg, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            kbT = true;
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
        kbS = new f(context, bVar);
        SimpleDraweeView.b(kbS);
    }

    public static e cFP() {
        return kbS.get();
    }

    public static j cFQ() {
        return j.cJh();
    }

    public static com.facebook.imagepipeline.d.g cFR() {
        return cFQ().cFR();
    }
}
