package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g jAM;
    private final com.facebook.imagepipeline.d.g jAX;
    private final Set<com.facebook.drawee.controller.c> jAZ;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cxM(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jAX = jVar.cuy();
        com.facebook.imagepipeline.a.a.b cxN = jVar.cxN();
        com.facebook.imagepipeline.a.a.a eL = cxN != null ? cxN.eL(context) : null;
        if (bVar != null && bVar.cuu() != null) {
            this.jAM = bVar.cuu();
        } else {
            this.jAM = new g();
        }
        this.jAM.a(context.getResources(), com.facebook.drawee.components.a.cuI(), eL, com.facebook.common.b.f.ctC(), this.jAX.cxe(), bVar != null ? bVar.cut() : null, bVar != null ? bVar.cuv() : null);
        this.jAZ = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuH */
    public e get() {
        return new e(this.mContext, this.jAM, this.jAX, this.jAZ);
    }
}
