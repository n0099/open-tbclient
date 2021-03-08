package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.j;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c {
    private static a pCS;
    private static final Class<?> pAh = c.class;
    private static volatile boolean sIsInitialized = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (sIsInitialized) {
            com.facebook.common.c.a.h(pAh, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
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
        pCS = new a(context, bVar);
        SimpleDraweeView.b(pCS);
    }

    public static e etF() {
        return pCS.get().get();
    }

    public static j etG() {
        return j.exC();
    }

    public static com.facebook.imagepipeline.c.g etH() {
        return etG().etH();
    }

    public static boolean etI() {
        return sIsInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b pCT;
        private volatile f pCU = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.pCT = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: etJ */
        public com.facebook.common.internal.j<e> get() {
            if (this.pCU == null) {
                synchronized (this) {
                    if (this.pCU == null) {
                        this.pCU = new f(this.mContext, this.pCT);
                    }
                }
            }
            return this.pCU;
        }
    }
}
