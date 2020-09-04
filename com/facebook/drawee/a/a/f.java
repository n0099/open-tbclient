package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class f implements j<e> {
    private final Context mContext;
    private final com.facebook.imagepipeline.d.g nmL;
    private final Set<com.facebook.drawee.controller.c> nmO;
    private final g nmx;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dTx(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.nmL = jVar.dPy();
        if (bVar != null && bVar.dPu() != null) {
            this.nmx = bVar.dPu();
        } else {
            this.nmx = new g();
        }
        this.nmx.a(context.getResources(), com.facebook.drawee.components.a.dPQ(), jVar.gs(context), i.dOE(), this.nmL.dSL(), bVar != null ? bVar.dPt() : null, bVar != null ? bVar.dPv() : null);
        this.nmO = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dPJ */
    public e get() {
        return new e(this.mContext, this.nmx, this.nmL, this.nmO);
    }
}
