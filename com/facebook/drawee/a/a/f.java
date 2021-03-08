package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g pCQ;
    private final com.facebook.imagepipeline.c.g pDd;
    private final Set<com.facebook.drawee.controller.c> pDg;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.exC(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.pDd = jVar.etH();
        if (bVar != null && bVar.etD() != null) {
            this.pCQ = bVar.etD();
        } else {
            this.pCQ = new g();
        }
        this.pCQ.a(context.getResources(), com.facebook.drawee.components.a.etZ(), jVar.ij(context), i.esN(), this.pDd.ewQ(), bVar != null ? bVar.etC() : null, bVar != null ? bVar.etE() : null);
        this.pDg = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etS */
    public e get() {
        return new e(this.mContext, this.pCQ, this.pDd, this.pDg);
    }
}
