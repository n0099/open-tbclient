package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jBj;
    private static final Class<?> jyv = c.class;
    private static volatile boolean jBk = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jBk) {
            com.facebook.common.c.a.f(jyv, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jBk = true;
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
        jBj = new f(context, bVar);
        SimpleDraweeView.b(jBj);
    }

    public static e cuq() {
        return jBj.get();
    }

    public static j cur() {
        return j.cxG();
    }

    public static com.facebook.imagepipeline.d.g cus() {
        return cur().cus();
    }
}
