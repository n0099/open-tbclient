package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a lLF;
    private static final Class<?> lIR = c.class;
    private static volatile boolean lLG = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lLG) {
            com.facebook.common.c.a.g(lIR, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lLG = true;
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
        lLF = new a(context, bVar);
        SimpleDraweeView.initialize(lLF);
    }

    public static e dlW() {
        return lLF.get().get();
    }

    public static j dlX() {
        return j.dpU();
    }

    public static com.facebook.imagepipeline.d.g dlY() {
        return dlX().dlY();
    }

    public static boolean dlZ() {
        return lLG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lLH;
        private volatile f lLI = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lLH = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dma */
        public com.facebook.common.internal.j<e> get() {
            if (this.lLI == null) {
                synchronized (this) {
                    if (this.lLI == null) {
                        this.lLI = new f(this.mContext, this.lLH);
                    }
                }
            }
            return this.lLI;
        }
    }
}
