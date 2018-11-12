package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g iab;
    private final com.facebook.imagepipeline.d.g iam;
    private final Set<com.facebook.drawee.controller.c> iao;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.bVb(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.iam = jVar.bRR();
        com.facebook.imagepipeline.a.a.b bVc = jVar.bVc();
        com.facebook.imagepipeline.a.a.a m23do = bVc != null ? bVc.m23do(context) : null;
        if (bVar != null && bVar.bRN() != null) {
            this.iab = bVar.bRN();
        } else {
            this.iab = new g();
        }
        this.iab.a(context.getResources(), com.facebook.drawee.components.a.bSb(), m23do, com.facebook.common.b.f.bQU(), this.iam.bUt(), bVar != null ? bVar.bRM() : null, bVar != null ? bVar.bRO() : null);
        this.iao = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bSa */
    public e get() {
        return new e(this.mContext, this.iab, this.iam, this.iao);
    }
}
