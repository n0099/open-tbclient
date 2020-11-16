package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class c {
    private static a oOi;
    private static final Class<?> oLv = c.class;
    private static volatile boolean oOj = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (oOj) {
            com.facebook.common.c.a.g(oLv, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            oOj = true;
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
        oOi = new a(context, bVar);
        SimpleDraweeView.b(oOi);
    }

    public static e ekQ() {
        return oOi.get().get();
    }

    public static j ekR() {
        return j.eoT();
    }

    public static com.facebook.imagepipeline.d.g ekS() {
        return ekR().ekS();
    }

    public static boolean ekT() {
        return oOj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b oOk;
        private volatile f oOl = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.oOk = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: ekU */
        public com.facebook.common.internal.j<e> get() {
            if (this.oOl == null) {
                synchronized (this) {
                    if (this.oOl == null) {
                        this.oOl = new f(this.mContext, this.oOk);
                    }
                }
            }
            return this.oOl;
        }
    }
}
