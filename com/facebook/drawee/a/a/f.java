package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class f implements j<e> {
    private final Context mContext;
    private final com.facebook.imagepipeline.d.g mSA;
    private final Set<com.facebook.drawee.controller.c> mSE;
    private final g mSl;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dHp(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.mSA = jVar.dDp();
        if (bVar != null && bVar.dDl() != null) {
            this.mSl = bVar.dDl();
        } else {
            this.mSl = new g();
        }
        this.mSl.a(context.getResources(), com.facebook.drawee.components.a.dDH(), jVar.fZ(context), i.dCv(), this.mSA.dGD(), bVar != null ? bVar.dDk() : null, bVar != null ? bVar.dDm() : null);
        this.mSE = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dDA */
    public e get() {
        return new e(this.mContext, this.mSl, this.mSA, this.mSE);
    }
}
