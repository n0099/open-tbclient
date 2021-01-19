package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g pqc;
    private final com.facebook.imagepipeline.c.g pqp;
    private final Set<com.facebook.drawee.controller.c> pqs;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.euS(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.pqp = jVar.eqX();
        if (bVar != null && bVar.eqT() != null) {
            this.pqc = bVar.eqT();
        } else {
            this.pqc = new g();
        }
        this.pqc.a(context.getResources(), com.facebook.drawee.components.a.erp(), jVar.ih(context), i.eqd(), this.pqp.eug(), bVar != null ? bVar.eqS() : null, bVar != null ? bVar.eqU() : null);
        this.pqs = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eri */
    public e get() {
        return new e(this.mContext, this.pqc, this.pqp, this.pqs);
    }
}
