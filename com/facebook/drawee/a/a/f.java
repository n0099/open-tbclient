package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g jBA;
    private final com.facebook.imagepipeline.d.g jBL;
    private final Set<com.facebook.drawee.controller.c> jBN;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cxQ(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jBL = jVar.cuC();
        com.facebook.imagepipeline.a.a.b cxR = jVar.cxR();
        com.facebook.imagepipeline.a.a.a eN = cxR != null ? cxR.eN(context) : null;
        if (bVar != null && bVar.cuy() != null) {
            this.jBA = bVar.cuy();
        } else {
            this.jBA = new g();
        }
        this.jBA.a(context.getResources(), com.facebook.drawee.components.a.cuM(), eN, com.facebook.common.b.f.ctG(), this.jBL.cxi(), bVar != null ? bVar.cux() : null, bVar != null ? bVar.cuz() : null);
        this.jBN = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuL */
    public e get() {
        return new e(this.mContext, this.jBA, this.jBL, this.jBN);
    }
}
