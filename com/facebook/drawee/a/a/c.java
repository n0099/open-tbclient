package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a mof;
    private static final Class<?> mls = c.class;
    private static volatile boolean mog = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (mog) {
            com.facebook.common.c.a.g(mls, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            mog = true;
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
        mof = new a(context, bVar);
        SimpleDraweeView.b(mof);
    }

    public static e dvt() {
        return mof.get().get();
    }

    public static j dvu() {
        return j.dzw();
    }

    public static com.facebook.imagepipeline.d.g dvv() {
        return dvu().dvv();
    }

    public static boolean dvw() {
        return mog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b moh;
        private volatile f moi = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.moh = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dvx */
        public com.facebook.common.internal.j<e> get() {
            if (this.moi == null) {
                synchronized (this) {
                    if (this.moi == null) {
                        this.moi = new f(this.mContext, this.moh);
                    }
                }
            }
            return this.moi;
        }
    }
}
