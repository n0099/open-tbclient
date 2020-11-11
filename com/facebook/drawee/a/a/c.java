package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c {
    private static a oME;
    private static final Class<?> oJR = c.class;
    private static volatile boolean oMF = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (oMF) {
            com.facebook.common.c.a.g(oJR, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            oMF = true;
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
        oME = new a(context, bVar);
        SimpleDraweeView.b(oME);
    }

    public static e ekS() {
        return oME.get().get();
    }

    public static j ekT() {
        return j.eoV();
    }

    public static com.facebook.imagepipeline.d.g ekU() {
        return ekT().ekU();
    }

    public static boolean ekV() {
        return oMF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b oMG;
        private volatile f oMH = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.oMG = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: ekW */
        public com.facebook.common.internal.j<e> get() {
            if (this.oMH == null) {
                synchronized (this) {
                    if (this.oMH == null) {
                        this.oMH = new f(this.mContext, this.oMG);
                    }
                }
            }
            return this.oMH;
        }
    }
}
