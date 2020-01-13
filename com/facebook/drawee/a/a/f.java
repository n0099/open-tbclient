package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class f implements j<e> {
    private final g lIX;
    private final com.facebook.imagepipeline.d.g lJm;
    private final Set<com.facebook.drawee.controller.c> lJp;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dog(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lJm = jVar.dkj();
        if (bVar != null && bVar.dkd() != null) {
            this.lIX = bVar.dkd();
        } else {
            this.lIX = new g();
        }
        this.lIX.a(context.getResources(), com.facebook.drawee.components.a.dkB(), jVar.gn(context), i.djo(), this.lJm.dnu(), bVar != null ? bVar.dkc() : null, bVar != null ? bVar.dkf() : null);
        this.lJp = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dku */
    public e get() {
        return new e(this.mContext, this.lIX, this.lJm, this.lJp);
    }
}
