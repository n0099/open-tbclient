package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a lJO;
    private static final Class<?> lHa = c.class;
    private static volatile boolean lJP = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lJP) {
            com.facebook.common.c.a.g(lHa, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lJP = true;
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
        lJO = new a(context, bVar);
        SimpleDraweeView.initialize(lJO);
    }

    public static e dly() {
        return lJO.get().get();
    }

    public static j dlz() {
        return j.dpw();
    }

    public static com.facebook.imagepipeline.d.g dlA() {
        return dlz().dlA();
    }

    public static boolean dlB() {
        return lJP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lJQ;
        private volatile f lJR = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lJQ = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dlC */
        public com.facebook.common.internal.j<e> get() {
            if (this.lJR == null) {
                synchronized (this) {
                    if (this.lJR == null) {
                        this.lJR = new f(this.mContext, this.lJQ);
                    }
                }
            }
            return this.lJR;
        }
    }
}
