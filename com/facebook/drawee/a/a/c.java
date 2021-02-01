package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class c {
    private static a pAn;
    private static final Class<?> pxC = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.h(pxC, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        pAn = new a(context, bVar);
        SimpleDraweeView.b(pAn);
    }

    public static e eto() {
        return pAn.get().get();
    }

    public static j etp() {
        return j.exl();
    }

    public static com.facebook.imagepipeline.c.g etq() {
        return etp().etq();
    }

    public static boolean etr() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b pAo;
        private volatile f pAp = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.pAo = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: ets */
        public com.facebook.common.internal.j<e> get() {
            if (this.pAp == null) {
                synchronized (this) {
                    if (this.pAp == null) {
                        this.pAp = new f(this.mContext, this.pAo);
                    }
                }
            }
            return this.pAp;
        }
    }
}
