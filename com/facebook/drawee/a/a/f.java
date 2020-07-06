package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g mKg;
    private final com.facebook.imagepipeline.d.g mKu;
    private final Set<com.facebook.drawee.controller.c> mKx;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dEc(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.mKu = jVar.dAc();
        if (bVar != null && bVar.dzY() != null) {
            this.mKg = bVar.dzY();
        } else {
            this.mKg = new g();
        }
        this.mKg.a(context.getResources(), com.facebook.drawee.components.a.dAu(), jVar.fW(context), i.dzi(), this.mKu.dDq(), bVar != null ? bVar.dzX() : null, bVar != null ? bVar.dzZ() : null);
        this.mKx = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dAn */
    public e get() {
        return new e(this.mContext, this.mKg, this.mKu, this.mKx);
    }
}
