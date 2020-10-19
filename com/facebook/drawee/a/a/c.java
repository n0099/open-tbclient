package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c {
    private static a nLS;
    private static final Class<?> nJf = c.class;
    private static volatile boolean nLT = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (nLT) {
            com.facebook.common.c.a.g(nJf, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            nLT = true;
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
        nLS = new a(context, bVar);
        SimpleDraweeView.b(nLS);
    }

    public static e dXf() {
        return nLS.get().get();
    }

    public static j dXg() {
        return j.ebg();
    }

    public static com.facebook.imagepipeline.d.g dXh() {
        return dXg().dXh();
    }

    public static boolean dXi() {
        return nLT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b nLU;
        private volatile f nLV = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.nLU = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dXj */
        public com.facebook.common.internal.j<e> get() {
            if (this.nLV == null) {
                synchronized (this) {
                    if (this.nLV == null) {
                        this.nLV = new f(this.mContext, this.nLU);
                    }
                }
            }
            return this.nLV;
        }
    }
}
