package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g jTD;
    private final com.facebook.imagepipeline.d.g jTO;
    private final Set<com.facebook.drawee.controller.c> jTQ;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cFK(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jTO = jVar.cCw();
        com.facebook.imagepipeline.a.a.b cFL = jVar.cFL();
        com.facebook.imagepipeline.a.a.a eB = cFL != null ? cFL.eB(context) : null;
        if (bVar != null && bVar.cCs() != null) {
            this.jTD = bVar.cCs();
        } else {
            this.jTD = new g();
        }
        this.jTD.a(context.getResources(), com.facebook.drawee.components.a.cCG(), eB, com.facebook.common.b.f.cBB(), this.jTO.cFc(), bVar != null ? bVar.cCr() : null, bVar != null ? bVar.cCt() : null);
        this.jTQ = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cCF */
    public e get() {
        return new e(this.mContext, this.jTD, this.jTO, this.jTQ);
    }
}
