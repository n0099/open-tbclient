package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class i {
    public final u mDm;
    public final boolean[] mDn;
    public final g mDo;
    public final Object mDp;
    public final com.google.android.exoplayer2.u[] mDq;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.mDm = uVar;
        this.mDn = zArr;
        this.mDo = gVar;
        this.mDp = obj;
        this.mDq = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.mDo.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.mDn[i] == iVar.mDn[i] && v.h(this.mDo.LI(i), iVar.mDo.LI(i)) && v.h(this.mDq[i], iVar.mDq[i]);
    }
}
