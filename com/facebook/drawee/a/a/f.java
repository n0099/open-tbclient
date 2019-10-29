package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final com.facebook.imagepipeline.d.g kcH;
    private final Set<com.facebook.drawee.controller.c> kcJ;
    private final g kcw;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cGS(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.kcH = jVar.cDD();
        com.facebook.imagepipeline.a.a.b cGT = jVar.cGT();
        com.facebook.imagepipeline.a.a.a et = cGT != null ? cGT.et(context) : null;
        if (bVar != null && bVar.cDz() != null) {
            this.kcw = bVar.cDz();
        } else {
            this.kcw = new g();
        }
        this.kcw.a(context.getResources(), com.facebook.drawee.components.a.cDN(), et, com.facebook.common.b.f.cCI(), this.kcH.cGk(), bVar != null ? bVar.cDy() : null, bVar != null ? bVar.cDA() : null);
        this.kcJ = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cDM */
    public e get() {
        return new e(this.mContext, this.kcw, this.kcH, this.kcJ);
    }
}
