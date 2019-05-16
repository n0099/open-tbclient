package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g jTC;
    private final com.facebook.imagepipeline.d.g jTN;
    private final Set<com.facebook.drawee.controller.c> jTP;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cFI(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jTN = jVar.cCu();
        com.facebook.imagepipeline.a.a.b cFJ = jVar.cFJ();
        com.facebook.imagepipeline.a.a.a eB = cFJ != null ? cFJ.eB(context) : null;
        if (bVar != null && bVar.cCq() != null) {
            this.jTC = bVar.cCq();
        } else {
            this.jTC = new g();
        }
        this.jTC.a(context.getResources(), com.facebook.drawee.components.a.cCE(), eB, com.facebook.common.b.f.cBz(), this.jTN.cFa(), bVar != null ? bVar.cCp() : null, bVar != null ? bVar.cCr() : null);
        this.jTP = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cCD */
    public e get() {
        return new e(this.mContext, this.jTC, this.jTN, this.jTP);
    }
}
