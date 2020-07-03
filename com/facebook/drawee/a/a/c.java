package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a mKf;
    private static final Class<?> mHo = c.class;
    private static volatile boolean mKg = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (mKg) {
            com.facebook.common.c.a.g(mHo, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            mKg = true;
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
        mKf = new a(context, bVar);
        SimpleDraweeView.b(mKf);
    }

    public static e dzW() {
        return mKf.get().get();
    }

    public static j dzX() {
        return j.dDY();
    }

    public static com.facebook.imagepipeline.d.g dzY() {
        return dzX().dzY();
    }

    public static boolean dzZ() {
        return mKg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b mKh;
        private volatile f mKi = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.mKh = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dAa */
        public com.facebook.common.internal.j<e> get() {
            if (this.mKi == null) {
                synchronized (this) {
                    if (this.mKi == null) {
                        this.mKi = new f(this.mContext, this.mKh);
                    }
                }
            }
            return this.mKi;
        }
    }
}
