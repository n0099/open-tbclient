package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g mKd;
    private final com.facebook.imagepipeline.d.g mKr;
    private final Set<com.facebook.drawee.controller.c> mKu;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dDY(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.mKr = jVar.dzY();
        if (bVar != null && bVar.dzU() != null) {
            this.mKd = bVar.dzU();
        } else {
            this.mKd = new g();
        }
        this.mKd.a(context.getResources(), com.facebook.drawee.components.a.dAq(), jVar.fW(context), i.dze(), this.mKr.dDm(), bVar != null ? bVar.dzT() : null, bVar != null ? bVar.dzV() : null);
        this.mKu = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dAj */
    public e get() {
        return new e(this.mContext, this.mKd, this.mKr, this.mKu);
    }
}
