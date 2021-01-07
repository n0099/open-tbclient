package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c {
    private static a puF;
    private static final Class<?> prR = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.h(prR, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        puF = new a(context, bVar);
        SimpleDraweeView.b(puF);
    }

    public static e euP() {
        return puF.get().get();
    }

    public static j euQ() {
        return j.eyK();
    }

    public static com.facebook.imagepipeline.c.g euR() {
        return euQ().euR();
    }

    public static boolean euS() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b puG;
        private volatile f puH = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.puG = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: euT */
        public com.facebook.common.internal.j<e> get() {
            if (this.puH == null) {
                synchronized (this) {
                    if (this.puH == null) {
                        this.puH = new f(this.mContext, this.puG);
                    }
                }
            }
            return this.puH;
        }
    }
}
