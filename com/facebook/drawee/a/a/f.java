package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final g lJW;
    private final com.facebook.imagepipeline.d.g lKl;
    private final Set<com.facebook.drawee.controller.c> lKo;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dpx(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lKl = jVar.dlB();
        if (bVar != null && bVar.dlv() != null) {
            this.lJW = bVar.dlv();
        } else {
            this.lJW = new g();
        }
        this.lJW.a(context.getResources(), com.facebook.drawee.components.a.dlT(), jVar.gm(context), i.dkG(), this.lKl.doL(), bVar != null ? bVar.dlu() : null, bVar != null ? bVar.dlx() : null);
        this.lKo = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlM */
    public e get() {
        return new e(this.mContext, this.lJW, this.lKl, this.lKo);
    }
}
