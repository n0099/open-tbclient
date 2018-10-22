package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f hYt;
    private static final Class<?> hVC = c.class;
    private static volatile boolean hYu = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (hYu) {
            com.facebook.common.c.a.f(hVC, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            hYu = true;
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
        hYt = new f(context, bVar);
        SimpleDraweeView.initialize(hYt);
    }

    public static e bSu() {
        return hYt.get();
    }

    public static j bSv() {
        return j.bVG();
    }

    public static com.facebook.imagepipeline.d.g bSw() {
        return bSv().bSw();
    }
}
