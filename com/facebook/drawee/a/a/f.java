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
        this(context, j.bXg(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.ihz = jVar.bTW();
        com.facebook.imagepipeline.a.a.b bXh = jVar.bXh();
        com.facebook.imagepipeline.a.a.a ds = bXh != null ? bXh.ds(context) : null;
        if (bVar != null && bVar.bTS() != null) {
            this.iho = bVar.bTS();
        } else {
            this.iho = new g();
        }
        this.iho.a(context.getResources(), com.facebook.drawee.components.a.bUg(), ds, com.facebook.common.b.f.bSZ(), this.ihz.bWy(), bVar != null ? bVar.bTR() : null, bVar != null ? bVar.bTT() : null);
        this.ihB = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bUf */
    public e get() {
        return new e(this.mContext, this.iho, this.ihz, this.ihB);
    }
}
