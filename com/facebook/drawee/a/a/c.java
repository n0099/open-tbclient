package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c {
    private static a nmh;
    private static final Class<?> nju = c.class;
    private static volatile boolean nmi = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (nmi) {
            com.facebook.common.c.a.g(nju, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            nmi = true;
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
        nmh = new a(context, bVar);
        SimpleDraweeView.b(nmh);
    }

    public static e dPn() {
        return nmh.get().get();
    }

    public static j dPo() {
        return j.dTo();
    }

    public static com.facebook.imagepipeline.d.g dPp() {
        return dPo().dPp();
    }

    public static boolean dPq() {
        return nmi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b nmj;
        private volatile f nmk = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.nmj = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dPr */
        public com.facebook.common.internal.j<e> get() {
            if (this.nmk == null) {
                synchronized (this) {
                    if (this.nmk == null) {
                        this.nmk = new f(this.mContext, this.nmj);
                    }
                }
            }
            return this.nmk;
        }
    }
}
