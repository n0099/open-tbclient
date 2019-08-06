package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g kbQ;
    private final com.facebook.imagepipeline.d.g kcb;
    private final Set<com.facebook.drawee.controller.c> kcd;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cJh(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.kcb = jVar.cFR();
        com.facebook.imagepipeline.a.a.b cJi = jVar.cJi();
        com.facebook.imagepipeline.a.a.a eD = cJi != null ? cJi.eD(context) : null;
        if (bVar != null && bVar.cFN() != null) {
            this.kbQ = bVar.cFN();
        } else {
            this.kbQ = new g();
        }
        this.kbQ.a(context.getResources(), com.facebook.drawee.components.a.cGb(), eD, com.facebook.common.b.f.cEW(), this.kcb.cIz(), bVar != null ? bVar.cFM() : null, bVar != null ? bVar.cFO() : null);
        this.kcd = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cGa */
    public e get() {
        return new e(this.mContext, this.kbQ, this.kcb, this.kcd);
    }
}
