package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g oMC;
    private final com.facebook.imagepipeline.d.g oMQ;
    private final Set<com.facebook.drawee.controller.c> oMT;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.eoV(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.oMQ = jVar.ekU();
        if (bVar != null && bVar.ekQ() != null) {
            this.oMC = bVar.ekQ();
        } else {
            this.oMC = new g();
        }
        this.oMC.a(context.getResources(), com.facebook.drawee.components.a.elm(), jVar.ha(context), i.eka(), this.oMQ.eoj(), bVar != null ? bVar.ekP() : null, bVar != null ? bVar.ekR() : null);
        this.oMT = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: elf */
    public e get() {
        return new e(this.mContext, this.oMC, this.oMQ, this.oMT);
    }
}
