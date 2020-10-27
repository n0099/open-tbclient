package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class f implements j<e> {
    private final Context mContext;
    private final Set<com.facebook.drawee.controller.c> oDA;
    private final g oDj;
    private final com.facebook.imagepipeline.d.g oDx;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.ele(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.oDx = jVar.ehf();
        if (bVar != null && bVar.ehb() != null) {
            this.oDj = bVar.ehb();
        } else {
            this.oDj = new g();
        }
        this.oDj.a(context.getResources(), com.facebook.drawee.components.a.ehx(), jVar.ha(context), i.egl(), this.oDx.eks(), bVar != null ? bVar.eha() : null, bVar != null ? bVar.ehc() : null);
        this.oDA = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: ehq */
    public e get() {
        return new e(this.mContext, this.oDj, this.oDx, this.oDA);
    }
}
