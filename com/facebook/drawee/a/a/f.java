package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final com.facebook.imagepipeline.d.g ikJ;
    private final Set<com.facebook.drawee.controller.c> ikL;
    private final g iky;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.bXX(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.ikJ = jVar.bUN();
        com.facebook.imagepipeline.a.a.b bXY = jVar.bXY();
        com.facebook.imagepipeline.a.a.a ds = bXY != null ? bXY.ds(context) : null;
        if (bVar != null && bVar.bUJ() != null) {
            this.iky = bVar.bUJ();
        } else {
            this.iky = new g();
        }
        this.iky.a(context.getResources(), com.facebook.drawee.components.a.bUX(), ds, com.facebook.common.b.f.bTQ(), this.ikJ.bXp(), bVar != null ? bVar.bUI() : null, bVar != null ? bVar.bUK() : null);
        this.ikL = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bUW */
    public e get() {
        return new e(this.mContext, this.iky, this.ikJ, this.ikL);
    }
}
