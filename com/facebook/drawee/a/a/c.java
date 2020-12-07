package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c {
    private static a pdq;
    private static final Class<?> paD = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.g(paD, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            sIsInitialized = true;
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
        pdq = new a(context, bVar);
        SimpleDraweeView.b(pdq);
    }

    public static e eqF() {
        return pdq.get().get();
    }

    public static j eqG() {
        return j.euy();
    }

    public static com.facebook.imagepipeline.c.g eqH() {
        return eqG().eqH();
    }

    public static boolean eqI() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b pdr;
        private volatile f pds = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.pdr = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: eqJ */
        public com.facebook.common.internal.j<e> get() {
            if (this.pds == null) {
                synchronized (this) {
                    if (this.pds == null) {
                        this.pds = new f(this.mContext, this.pdr);
                    }
                }
            }
            return this.pds;
        }
    }
}
