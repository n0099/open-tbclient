package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class i {
    public final u mCA;
    public final boolean[] mCB;
    public final g mCC;
    public final Object mCD;
    public final com.google.android.exoplayer2.u[] mCE;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.mCA = uVar;
        this.mCB = zArr;
        this.mCC = gVar;
        this.mCD = obj;
        this.mCE = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.mCC.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.mCB[i] == iVar.mCB[i] && v.h(this.mCC.LD(i), iVar.mCC.LD(i)) && v.h(this.mCE[i], iVar.mCE[i]);
    }
}
