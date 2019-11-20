package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f kbH;
    private static final Class<?> jYW = c.class;
    private static volatile boolean kbI = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (kbI) {
            com.facebook.common.c.a.e(jYW, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            kbI = true;
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
        kbH = new f(context, bVar);
        SimpleDraweeView.b(kbH);
    }

    public static e cDz() {
        return kbH.get();
    }

    public static j cDA() {
        return j.cGQ();
    }

    public static com.facebook.imagepipeline.d.g cDB() {
        return cDA().cDB();
    }
}
