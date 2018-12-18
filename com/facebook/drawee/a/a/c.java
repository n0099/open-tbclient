package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f ihq;
    private static final Class<?> iez = c.class;
    private static volatile boolean ihr = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (ihr) {
            com.facebook.common.c.a.f(iez, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            ihr = true;
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
        ihq = new f(context, bVar);
        SimpleDraweeView.initialize(ihq);
    }

    public static e bTU() {
        return ihq.get();
    }

    public static j bTV() {
        return j.bXg();
    }

    public static com.facebook.imagepipeline.d.g bTW() {
        return bTV().bTW();
    }
}
