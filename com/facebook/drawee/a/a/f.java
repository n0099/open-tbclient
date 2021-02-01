package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class f implements j<e> {
    private final Context mContext;
    private final Set<com.facebook.drawee.controller.c> pAB;
    private final g pAl;
    private final com.facebook.imagepipeline.c.g pAy;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.exl(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.pAy = jVar.etq();
        if (bVar != null && bVar.etm() != null) {
            this.pAl = bVar.etm();
        } else {
            this.pAl = new g();
        }
        this.pAl.a(context.getResources(), com.facebook.drawee.components.a.etI(), jVar.ik(context), i.esw(), this.pAy.ewz(), bVar != null ? bVar.etl() : null, bVar != null ? bVar.etn() : null);
        this.pAB = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etB */
    public e get() {
        return new e(this.mContext, this.pAl, this.pAy, this.pAB);
    }
}
