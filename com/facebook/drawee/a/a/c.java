package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c {
    private static a pqe;
    private static final Class<?> pnn = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.h(pnn, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        pqe = new a(context, bVar);
        SimpleDraweeView.b(pqe);
    }

    public static e eqV() {
        return pqe.get().get();
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
        private b pqf;
        private volatile f pqg = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.pqf = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: eqZ */
        public com.facebook.common.internal.j<e> get() {
            if (this.pqg == null) {
                synchronized (this) {
                    if (this.pqg == null) {
                        this.pqg = new f(this.mContext, this.pqf);
                    }
                }
            }
            return this.pqg;
        }
    }
}
