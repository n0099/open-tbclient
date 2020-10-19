package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g nLQ;
    private final com.facebook.imagepipeline.d.g nMe;
    private final Set<com.facebook.drawee.controller.c> nMh;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.ebg(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.nMe = jVar.dXh();
        if (bVar != null && bVar.dXd() != null) {
            this.nLQ = bVar.dXd();
        } else {
            this.nLQ = new g();
        }
        this.nLQ.a(context.getResources(), com.facebook.drawee.components.a.dXz(), jVar.gG(context), i.dWn(), this.nMe.eau(), bVar != null ? bVar.dXc() : null, bVar != null ? bVar.dXe() : null);
        this.nMh = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dXs */
    public e get() {
        return new e(this.mContext, this.nLQ, this.nMe, this.nMh);
    }
}
