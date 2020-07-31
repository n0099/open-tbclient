package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c {
    private static a mSl;
    private static final Class<?> mPx = c.class;
    private static volatile boolean mSm = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (mSm) {
            com.facebook.common.c.a.g(mPx, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            mSm = true;
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
        mSl = new a(context, bVar);
        SimpleDraweeView.b(mSl);
    }

    public static e dDm() {
        return mSl.get().get();
    }

    public static j dDn() {
        return j.dHo();
    }

    public static com.facebook.imagepipeline.d.g dDo() {
        return dDn().dDo();
    }

    public static boolean dDp() {
        return mSm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b mSn;
        private volatile f mSo = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.mSn = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dDq */
        public com.facebook.common.internal.j<e> get() {
            if (this.mSo == null) {
                synchronized (this) {
                    if (this.mSo == null) {
                        this.mSo = new f(this.mContext, this.mSn);
                    }
                }
            }
            return this.mSo;
        }
    }
}
