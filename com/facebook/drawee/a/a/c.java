package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c {
    private static a mSn;
    private static final Class<?> mPz = c.class;
    private static volatile boolean mSo = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (mSo) {
            com.facebook.common.c.a.g(mPz, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            mSo = true;
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
        mSn = new a(context, bVar);
        SimpleDraweeView.b(mSn);
    }

    public static e dDn() {
        return mSn.get().get();
    }

    public static j dDo() {
        return j.dHp();
    }

    public static com.facebook.imagepipeline.d.g dDp() {
        return dDo().dDp();
    }

    public static boolean dDq() {
        return mSo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b mSq;
        private volatile f mSr = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.mSq = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dDr */
        public com.facebook.common.internal.j<e> get() {
            if (this.mSr == null) {
                synchronized (this) {
                    if (this.mSr == null) {
                        this.mSr = new f(this.mContext, this.mSq);
                    }
                }
            }
            return this.mSr;
        }
    }
}
