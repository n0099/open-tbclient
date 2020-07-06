package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a mKi;
    private static final Class<?> mHr = c.class;
    private static volatile boolean mKj = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (mKj) {
            com.facebook.common.c.a.g(mHr, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            mKj = true;
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
        mKi = new a(context, bVar);
        SimpleDraweeView.b(mKi);
    }

    public static e dAa() {
        return mKi.get().get();
    }

    public static j dAb() {
        return j.dEc();
    }

    public static com.facebook.imagepipeline.d.g dAc() {
        return dAb().dAc();
    }

    public static boolean dAd() {
        return mKj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b mKk;
        private volatile f mKl = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.mKk = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dAe */
        public com.facebook.common.internal.j<e> get() {
            if (this.mKl == null) {
                synchronized (this) {
                    if (this.mKl == null) {
                        this.mKl = new f(this.mContext, this.mKk);
                    }
                }
            }
            return this.mKl;
        }
    }
}
