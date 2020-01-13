package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private static a lJa;
    private static final Class<?> lGm = c.class;
    private static volatile boolean lJb = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lJb) {
            com.facebook.common.c.a.g(lGm, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lJb = true;
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
        lJa = new a(context, bVar);
        SimpleDraweeView.initialize(lJa);
    }

    public static e dkh() {
        return lJa.get().get();
    }

    public static j dki() {
        return j.dog();
    }

    public static com.facebook.imagepipeline.d.g dkj() {
        return dki().dkj();
    }

    public static boolean dkk() {
        return lJb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lJc;
        private volatile f lJd = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lJc = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dkl */
        public com.facebook.common.internal.j<e> get() {
            if (this.lJd == null) {
                synchronized (this) {
                    if (this.lJd == null) {
                        this.lJd = new f(this.mContext, this.lJc);
                    }
                }
            }
            return this.lJd;
        }
    }
}
