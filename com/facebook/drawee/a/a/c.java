package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private static a lJf;
    private static final Class<?> lGr = c.class;
    private static volatile boolean lJg = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lJg) {
            com.facebook.common.c.a.g(lGr, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lJg = true;
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
        lJf = new a(context, bVar);
        SimpleDraweeView.initialize(lJf);
    }

    public static e dkj() {
        return lJf.get().get();
    }

    public static j dkk() {
        return j.doi();
    }

    public static com.facebook.imagepipeline.d.g dkl() {
        return dkk().dkl();
    }

    public static boolean dkm() {
        return lJg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lJh;
        private volatile f lJi = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lJh = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dkn */
        public com.facebook.common.internal.j<e> get() {
            if (this.lJi == null) {
                synchronized (this) {
                    if (this.lJi == null) {
                        this.lJi = new f(this.mContext, this.lJh);
                    }
                }
            }
            return this.lJi;
        }
    }
}
