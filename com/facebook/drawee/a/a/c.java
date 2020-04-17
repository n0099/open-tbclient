package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a lSZ;
    private static final Class<?> lQm = c.class;
    private static volatile boolean lTa = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lTa) {
            com.facebook.common.c.a.g(lQm, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lTa = true;
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
        lSZ = new a(context, bVar);
        SimpleDraweeView.b(lSZ);
    }

    public static e dnP() {
        return lSZ.get().get();
    }

    public static j dnQ() {
        return j.drS();
    }

    public static com.facebook.imagepipeline.d.g dnR() {
        return dnQ().dnR();
    }

    public static boolean dnS() {
        return lTa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lTb;
        private volatile f lTc = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lTb = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dnT */
        public com.facebook.common.internal.j<e> get() {
            if (this.lTc == null) {
                synchronized (this) {
                    if (this.lTc == null) {
                        this.lTc = new f(this.mContext, this.lTb);
                    }
                }
            }
            return this.lTc;
        }
    }
}
