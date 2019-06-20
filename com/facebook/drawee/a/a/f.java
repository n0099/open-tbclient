package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g jTG;
    private final com.facebook.imagepipeline.d.g jTR;
    private final Set<com.facebook.drawee.controller.c> jTT;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cFJ(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jTR = jVar.cCv();
        com.facebook.imagepipeline.a.a.b cFK = jVar.cFK();
        com.facebook.imagepipeline.a.a.a eB = cFK != null ? cFK.eB(context) : null;
        if (bVar != null && bVar.cCr() != null) {
            this.jTG = bVar.cCr();
        } else {
            this.jTG = new g();
        }
        this.jTG.a(context.getResources(), com.facebook.drawee.components.a.cCF(), eB, com.facebook.common.b.f.cBA(), this.jTR.cFb(), bVar != null ? bVar.cCq() : null, bVar != null ? bVar.cCs() : null);
        this.jTT = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cCE */
    public e get() {
        return new e(this.mContext, this.jTG, this.jTR, this.jTT);
    }
}
