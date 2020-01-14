package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class i {
    public final u mCF;
    public final boolean[] mCG;
    public final g mCH;
    public final Object mCI;
    public final com.google.android.exoplayer2.u[] mCJ;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.mCF = uVar;
        this.mCG = zArr;
        this.mCH = gVar;
        this.mCI = obj;
        this.mCJ = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.mCH.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.mCG[i] == iVar.mCG[i] && v.h(this.mCH.LD(i), iVar.mCH.LD(i)) && v.h(this.mCJ[i], iVar.mCJ[i]);
    }
}
