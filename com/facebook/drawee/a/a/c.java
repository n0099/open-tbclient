package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f ikA;
    private static final Class<?> ihJ = c.class;
    private static volatile boolean ikB = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (ikB) {
            com.facebook.common.c.a.f(ihJ, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            ikB = true;
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
        ikA = new f(context, bVar);
        SimpleDraweeView.initialize(ikA);
    }

    public static e bUL() {
        return ikA.get();
    }

    public static j bUM() {
        return j.bXX();
    }

    public static com.facebook.imagepipeline.d.g bUN() {
        return bUM().bUN();
    }
}
