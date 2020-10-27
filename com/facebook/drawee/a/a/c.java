package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.d.j;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c {
    private static a oDl;
    private static final Class<?> oAy = c.class;
    private static volatile boolean oDm = false;

    private c() {
    }

    public static void initialize(Context context) {
        a(context, null, null);
    }

    public static void a(Context context, @Nullable h hVar) {
        a(context, hVar, null);
    }

    public static void a(Context context, @Nullable h hVar, @Nullable b bVar) {
        if (oDm) {
            com.facebook.common.c.a.g(oAy, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            oDm = true;
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
        oDl = new a(context, bVar);
        SimpleDraweeView.b(oDl);
    }

    public static e ehd() {
        return oDl.get().get();
    }

    public static j ehe() {
        return j.ele();
    }

    public static com.facebook.imagepipeline.d.g ehf() {
        return ehe().ehf();
    }

    public static boolean ehg() {
        return oDm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a implements com.facebook.common.internal.j<com.facebook.common.internal.j<? extends AbstractDraweeControllerBuilder>> {
        private Context mContext;
        private b oDn;
        private volatile f oDo = null;

        a(Context context, b bVar) {
            this.mContext = context;
            this.oDn = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: ehh */
        public com.facebook.common.internal.j<e> get() {
            if (this.oDo == null) {
                synchronized (this) {
                    if (this.oDo == null) {
                        this.oDo = new f(this.mContext, this.oDn);
                    }
                }
            }
            return this.oDo;
        }
    }
}
