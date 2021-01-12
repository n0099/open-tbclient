package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c {
    private static a pqd;
    private static final Class<?> pnm = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.h(pnm, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        pqd = new a(context, bVar);
        SimpleDraweeView.b(pqd);
    }

    public static e eqV() {
        return pqd.get().get();
    }

    public static j eqW() {
        return j.euS();
    }

    public static com.facebook.imagepipeline.c.g eqX() {
        return eqW().eqX();
    }

    public static boolean eqY() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b pqe;
        private volatile f pqf = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.pqe = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: eqZ */
        public com.facebook.common.internal.j<e> get() {
            if (this.pqf == null) {
                synchronized (this) {
                    if (this.pqf == null) {
                        this.pqf = new f(this.mContext, this.pqe);
                    }
                }
            }
            return this.pqf;
        }
    }
}
