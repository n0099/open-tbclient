package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a mmV;
    private static final Class<?> mki = c.class;
    private static volatile boolean mmW = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (mmW) {
            com.facebook.common.c.a.g(mki, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            mmW = true;
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
        mmV = new a(context, bVar);
        SimpleDraweeView.b(mmV);
    }

    public static e dvf() {
        return mmV.get().get();
    }

    public static j dvg() {
        return j.dzi();
    }

    public static com.facebook.imagepipeline.d.g dvh() {
        return dvg().dvh();
    }

    public static boolean dvi() {
        return mmW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b mmX;
        private volatile f mmY = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.mmX = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dvj */
        public com.facebook.common.internal.j<e> get() {
            if (this.mmY == null) {
                synchronized (this) {
                    if (this.mmY == null) {
                        this.mmY = new f(this.mContext, this.mmX);
                    }
                }
            }
            return this.mmY;
        }
    }
}
