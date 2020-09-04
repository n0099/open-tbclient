package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c {
    private static final Class<?> njM = c.class;
    private static volatile boolean nmA = false;
    private static a nmz;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (nmA) {
            com.facebook.common.c.a.g(njM, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            nmA = true;
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
        nmz = new a(context, bVar);
        SimpleDraweeView.b(nmz);
    }

    public static e dPw() {
        return nmz.get().get();
    }

    public static j dPx() {
        return j.dTx();
    }

    public static com.facebook.imagepipeline.d.g dPy() {
        return dPx().dPy();
    }

    public static boolean dPz() {
        return nmA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b nmB;
        private volatile f nmC = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.nmB = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dPA */
        public com.facebook.common.internal.j<e> get() {
            if (this.nmC == null) {
                synchronized (this) {
                    if (this.nmC == null) {
                        this.nmC = new f(this.mContext, this.nmB);
                    }
                }
            }
            return this.nmC;
        }
    }
}
