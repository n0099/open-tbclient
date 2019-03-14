package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    private static f jBu;
    private static final Class<?> jyG = c.class;
    private static volatile boolean jBv = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (jBv) {
            com.facebook.common.c.a.f(jyG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            jBv = true;
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
        jBu = new f(context, bVar);
        SimpleDraweeView.b(jBu);
    }

    public static e cuD() {
        return jBu.get();
    }

    public static j cuE() {
        return j.cxT();
    }

    public static com.facebook.imagepipeline.d.g cuF() {
        return cuE().cuF();
    }
}
