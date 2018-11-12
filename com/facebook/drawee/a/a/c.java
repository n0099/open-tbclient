package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f iad;
    private static final Class<?> hXm = c.class;
    private static volatile boolean iae = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (iae) {
            com.facebook.common.c.a.f(hXm, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            iae = true;
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
        iad = new f(context, bVar);
        SimpleDraweeView.initialize(iad);
    }

    public static e bRP() {
        return iad.get();
    }

    public static j bRQ() {
        return j.bVb();
    }

    public static com.facebook.imagepipeline.d.g bRR() {
        return bRQ().bRR();
    }
}
