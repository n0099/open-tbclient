package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class i {
    public final u mDo;
    public final boolean[] mDp;
    public final g mDq;
    public final Object mDr;
    public final com.google.android.exoplayer2.u[] mDs;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.mDo = uVar;
        this.mDp = zArr;
        this.mDq = gVar;
        this.mDr = obj;
        this.mDs = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.mDq.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.mDp[i] == iVar.mDp[i] && v.h(this.mDq.LI(i), iVar.mDq.LI(i)) && v.h(this.mDs[i], iVar.mDs[i]);
    }
}
