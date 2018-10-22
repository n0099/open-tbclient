package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final com.facebook.imagepipeline.d.g hYC;
    private final Set<com.facebook.drawee.controller.c> hYE;
    private final g hYr;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.bVG(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.hYC = jVar.bSw();
        com.facebook.imagepipeline.a.a.b bVH = jVar.bVH();
        com.facebook.imagepipeline.a.a.a dt = bVH != null ? bVH.dt(context) : null;
        if (bVar != null && bVar.bSs() != null) {
            this.hYr = bVar.bSs();
        } else {
            this.hYr = new g();
        }
        this.hYr.a(context.getResources(), com.facebook.drawee.components.a.bSG(), dt, com.facebook.common.b.f.bRz(), this.hYC.bUY(), bVar != null ? bVar.bSr() : null, bVar != null ? bVar.bSt() : null);
        this.hYE = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bSF */
    public e get() {
        return new e(this.mContext, this.hYr, this.hYC, this.hYE);
    }
}
