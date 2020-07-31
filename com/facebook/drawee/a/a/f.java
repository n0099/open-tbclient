package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class f implements j<e> {
    private final Context mContext;
    private final Set<com.facebook.drawee.controller.c> mSB;
    private final g mSj;
    private final com.facebook.imagepipeline.d.g mSy;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dHo(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.mSy = jVar.dDo();
        if (bVar != null && bVar.dDk() != null) {
            this.mSj = bVar.dDk();
        } else {
            this.mSj = new g();
        }
        this.mSj.a(context.getResources(), com.facebook.drawee.components.a.dDG(), jVar.fZ(context), i.dCu(), this.mSy.dGC(), bVar != null ? bVar.dDj() : null, bVar != null ? bVar.dDl() : null);
        this.mSB = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dDz */
    public e get() {
        return new e(this.mContext, this.mSj, this.mSy, this.mSB);
    }
}
