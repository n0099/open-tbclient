package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c {
    private static a puy;
    private static final Class<?> prQ = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.h(prQ, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        puy = new a(context, bVar);
        SimpleDraweeView.b(puy);
    }

    public static e euI() {
        return puy.get().get();
    }

    public static j euJ() {
        return j.eyi();
    }

    public static com.facebook.imagepipeline.c.g euK() {
        return euJ().euK();
    }

    public static boolean euL() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private volatile f puA = null;
        private b puz;

        a(Context context, b bVar) {
            this.mContext = context;
            this.puz = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: euM */
        public com.facebook.common.internal.j<e> get() {
            if (this.puA == null) {
                synchronized (this) {
                    if (this.puA == null) {
                        this.puA = new f(this.mContext, this.puz);
                    }
                }
            }
            return this.puA;
        }
    }
}
