package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class c {
    private static final Class<?> ntL = c.class;
    private static volatile boolean nwA = false;
    private static a nwz;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (nwA) {
            com.facebook.common.c.a.g(ntL, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            nwA = true;
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
        nwz = new a(context, bVar);
        SimpleDraweeView.b(nwz);
    }

    public static e dTu() {
        return nwz.get().get();
    }

    public static j dTv() {
        return j.dXv();
    }

    public static com.facebook.imagepipeline.d.g dTw() {
        return dTv().dTw();
    }

    public static boolean dTx() {
        return nwA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b nwB;
        private volatile f nwC = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.nwB = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dTy */
        public com.facebook.common.internal.j<e> get() {
            if (this.nwC == null) {
                synchronized (this) {
                    if (this.nwC == null) {
                        this.nwC = new f(this.mContext, this.nwB);
                    }
                }
            }
            return this.nwC;
        }
    }
}
