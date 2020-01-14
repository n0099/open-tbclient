package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class f implements j<e> {
    private final g lJc;
    private final com.facebook.imagepipeline.d.g lJr;
    private final Set<com.facebook.drawee.controller.c> lJu;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.doi(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lJr = jVar.dkl();
        if (bVar != null && bVar.dkf() != null) {
            this.lJc = bVar.dkf();
        } else {
            this.lJc = new g();
        }
        this.lJc.a(context.getResources(), com.facebook.drawee.components.a.dkD(), jVar.gn(context), i.djq(), this.lJr.dnw(), bVar != null ? bVar.dke() : null, bVar != null ? bVar.dkh() : null);
        this.lJu = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dkw */
    public e get() {
        return new e(this.mContext, this.lJc, this.lJr, this.lJu);
    }
}
