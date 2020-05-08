package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private static a lTd;
    private static final Class<?> lQq = c.class;
    private static volatile boolean lTe = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (lTe) {
            com.facebook.common.c.a.g(lQq, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            lTe = true;
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
        lTd = new a(context, bVar);
        SimpleDraweeView.b(lTd);
    }

    public static e dnM() {
        return lTd.get().get();
    }

    public static j dnN() {
        return j.drP();
    }

    public static com.facebook.imagepipeline.d.g dnO() {
        return dnN().dnO();
    }

    public static boolean dnP() {
        return lTe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private b lTf;
        private volatile f lTg = null;
        private Context mContext;

        a(Context context, b bVar) {
            this.mContext = context;
            this.lTf = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dnQ */
        public com.facebook.common.internal.j<e> get() {
            if (this.lTg == null) {
                synchronized (this) {
                    if (this.lTg == null) {
                        this.lTg = new f(this.mContext, this.lTf);
                    }
                }
            }
            return this.lTg;
        }
    }
}
