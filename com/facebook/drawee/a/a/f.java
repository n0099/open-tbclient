package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final com.facebook.imagepipeline.d.g jBD;
    private final Set<com.facebook.drawee.controller.c> jBF;
    private final g jBs;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cxT(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jBD = jVar.cuF();
        com.facebook.imagepipeline.a.a.b cxU = jVar.cxU();
        com.facebook.imagepipeline.a.a.a eM = cxU != null ? cxU.eM(context) : null;
        if (bVar != null && bVar.cuB() != null) {
            this.jBs = bVar.cuB();
        } else {
            this.jBs = new g();
        }
        this.jBs.a(context.getResources(), com.facebook.drawee.components.a.cuP(), eM, com.facebook.common.b.f.ctJ(), this.jBD.cxl(), bVar != null ? bVar.cuA() : null, bVar != null ? bVar.cuC() : null);
        this.jBF = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuO */
    public e get() {
        return new e(this.mContext, this.jBs, this.jBD, this.jBF);
    }
}
