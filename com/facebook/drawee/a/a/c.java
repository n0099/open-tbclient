package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a lJZ;
    private static final Class<?> lHl = c.class;
    private static volatile boolean lKa = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lKa) {
            com.facebook.common.c.a.g(lHl, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lKa = true;
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
        lJZ = new a(context, bVar);
        SimpleDraweeView.initialize(lJZ);
    }

    public static e dlz() {
        return lJZ.get().get();
    }

    public static j dlA() {
        return j.dpx();
    }

    public static com.facebook.imagepipeline.d.g dlB() {
        return dlA().dlB();
    }

    public static boolean dlC() {
        return lKa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lKb;
        private volatile f lKc = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lKb = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dlD */
        public com.facebook.common.internal.j<e> get() {
            if (this.lKc == null) {
                synchronized (this) {
                    if (this.lKc == null) {
                        this.lKc = new f(this.mContext, this.lKb);
                    }
                }
            }
            return this.lKc;
        }
    }
}
