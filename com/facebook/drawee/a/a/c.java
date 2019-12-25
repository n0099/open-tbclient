package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c {
    private static a lFC;
    private static final Class<?> lCO = c.class;
    private static volatile boolean lFD = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lFD) {
            com.facebook.common.c.a.g(lCO, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lFD = true;
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
        lFC = new a(context, bVar);
        SimpleDraweeView.initialize(lFC);
    }

    public static e djg() {
        return lFC.get().get();
    }

    public static j djh() {
        return j.dmZ();
    }

    public static com.facebook.imagepipeline.d.g dji() {
        return djh().dji();
    }

    public static boolean djj() {
        return lFD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lFE;
        private volatile f lFF = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lFE = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: djk */
        public com.facebook.common.internal.j<e> get() {
            if (this.lFF == null) {
                synchronized (this) {
                    if (this.lFF == null) {
                        this.lFF = new f(this.mContext, this.lFE);
                    }
                }
            }
            return this.lFF;
        }
    }
}
