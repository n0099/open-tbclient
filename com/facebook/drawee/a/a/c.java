package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f hYs;
    private static final Class<?> hVB = c.class;
    private static volatile boolean hYt = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (hYt) {
            com.facebook.common.c.a.f(hVB, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            hYt = true;
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
        hYs = new f(context, bVar);
        SimpleDraweeView.initialize(hYs);
    }

    public static e bSu() {
        return hYs.get();
    }

    public static j bSv() {
        return j.bVG();
    }

    public static com.facebook.imagepipeline.d.g bSw() {
        return bSv().bSw();
    }
}
