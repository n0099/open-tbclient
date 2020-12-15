package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c {
    private static a pds;
    private static final Class<?> paF = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.g(paF, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        pds = new a(context, bVar);
        SimpleDraweeView.b(pds);
    }

    public static e eqG() {
        return pds.get().get();
    }

    public static j eqH() {
        return j.euz();
    }

    public static com.facebook.imagepipeline.c.g eqI() {
        return eqH().eqI();
    }

    public static boolean eqJ() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b pdt;
        private volatile f pdu = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.pdt = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: eqK */
        public com.facebook.common.internal.j<e> get() {
            if (this.pdu == null) {
                synchronized (this) {
                    if (this.pdu == null) {
                        this.pdu = new f(this.mContext, this.pdt);
                    }
                }
            }
            return this.pdu;
        }
    }
}
