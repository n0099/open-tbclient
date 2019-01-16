package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g ilF;
    private final com.facebook.imagepipeline.d.g ilQ;
    private final Set<com.facebook.drawee.controller.c> ilS;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.bYF(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.ilQ = jVar.bVv();
        com.facebook.imagepipeline.a.a.b bYG = jVar.bYG();
        com.facebook.imagepipeline.a.a.a ds = bYG != null ? bYG.ds(context) : null;
        if (bVar != null && bVar.bVr() != null) {
            this.ilF = bVar.bVr();
        } else {
            this.ilF = new g();
        }
        this.ilF.a(context.getResources(), com.facebook.drawee.components.a.bVF(), ds, com.facebook.common.b.f.bUy(), this.ilQ.bXX(), bVar != null ? bVar.bVq() : null, bVar != null ? bVar.bVs() : null);
        this.ilS = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bVE */
    public e get() {
        return new e(this.mContext, this.ilF, this.ilQ, this.ilS);
    }
}
