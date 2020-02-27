package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a lJM;
    private static final Class<?> lGY = c.class;
    private static volatile boolean lJN = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lJN) {
            com.facebook.common.c.a.g(lGY, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lJN = true;
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
        lJM = new a(context, bVar);
        SimpleDraweeView.initialize(lJM);
    }

    public static e dlw() {
        return lJM.get().get();
    }

    public static j dlx() {
        return j.dpu();
    }

    public static com.facebook.imagepipeline.d.g dly() {
        return dlx().dly();
    }

    public static boolean dlz() {
        return lJN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lJO;
        private volatile f lJP = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lJO = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dlA */
        public com.facebook.common.internal.j<e> get() {
            if (this.lJP == null) {
                synchronized (this) {
                    if (this.lJP == null) {
                        this.lJP = new f(this.mContext, this.lJO);
                    }
                }
            }
            return this.lJP;
        }
    }
}
