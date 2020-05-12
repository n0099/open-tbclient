package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final g lTb;
    private final com.facebook.imagepipeline.d.g lTp;
    private final Set<com.facebook.drawee.controller.c> lTs;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.drQ(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lTp = jVar.dnP();
        if (bVar != null && bVar.dnL() != null) {
            this.lTb = bVar.dnL();
        } else {
            this.lTb = new g();
        }
        this.lTb.a(context.getResources(), com.facebook.drawee.components.a.doh(), jVar.fD(context), i.dmU(), this.lTp.dre(), bVar != null ? bVar.dnK() : null, bVar != null ? bVar.dnM() : null);
        this.lTs = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: doa */
    public e get() {
        return new e(this.mContext, this.lTb, this.lTp, this.lTs);
    }
}
