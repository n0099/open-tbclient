package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g jBh;
    private final com.facebook.imagepipeline.d.g jBs;
    private final Set<com.facebook.drawee.controller.c> jBu;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cxG(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.jBs = jVar.cus();
        com.facebook.imagepipeline.a.a.b cxH = jVar.cxH();
        com.facebook.imagepipeline.a.a.a eN = cxH != null ? cxH.eN(context) : null;
        if (bVar != null && bVar.cuo() != null) {
            this.jBh = bVar.cuo();
        } else {
            this.jBh = new g();
        }
        this.jBh.a(context.getResources(), com.facebook.drawee.components.a.cuC(), eN, com.facebook.common.b.f.ctw(), this.jBs.cwY(), bVar != null ? bVar.cun() : null, bVar != null ? bVar.cup() : null);
        this.jBu = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuB */
    public e get() {
        return new e(this.mContext, this.jBh, this.jBs, this.jBu);
    }
}
