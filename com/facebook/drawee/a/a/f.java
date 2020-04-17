package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final g lSX;
    private final com.facebook.imagepipeline.d.g lTl;
    private final Set<com.facebook.drawee.controller.c> lTo;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.drS(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lTl = jVar.dnR();
        if (bVar != null && bVar.dnN() != null) {
            this.lSX = bVar.dnN();
        } else {
            this.lSX = new g();
        }
        this.lSX.a(context.getResources(), com.facebook.drawee.components.a.doj(), jVar.fP(context), i.dmW(), this.lTl.drg(), bVar != null ? bVar.dnM() : null, bVar != null ? bVar.dnO() : null);
        this.lTo = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: doc */
    public e get() {
        return new e(this.mContext, this.lSX, this.lTl, this.lTo);
    }
}
