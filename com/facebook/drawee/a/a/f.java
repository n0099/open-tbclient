package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final Set<com.facebook.drawee.controller.c> ihB;
    private final g iho;
    private final com.facebook.imagepipeline.d.g ihz;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.bXh(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.ihz = jVar.bTX();
        com.facebook.imagepipeline.a.a.b bXi = jVar.bXi();
        com.facebook.imagepipeline.a.a.a ds = bXi != null ? bXi.ds(context) : null;
        if (bVar != null && bVar.bTT() != null) {
            this.iho = bVar.bTT();
        } else {
            this.iho = new g();
        }
        this.iho.a(context.getResources(), com.facebook.drawee.components.a.bUh(), ds, com.facebook.common.b.f.bTa(), this.ihz.bWz(), bVar != null ? bVar.bTS() : null, bVar != null ? bVar.bTU() : null);
        this.ihB = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bUg */
    public e get() {
        return new e(this.mContext, this.iho, this.ihz, this.ihB);
    }
}
