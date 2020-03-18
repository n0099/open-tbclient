package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class i {
    public final u mFi;
    public final boolean[] mFj;
    public final g mFk;
    public final Object mFl;
    public final com.google.android.exoplayer2.u[] mFm;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.mFi = uVar;
        this.mFj = zArr;
        this.mFk = gVar;
        this.mFl = obj;
        this.mFm = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.mFk.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.mFj[i] == iVar.mFj[i] && v.h(this.mFk.LO(i), iVar.mFk.LO(i)) && v.h(this.mFm[i], iVar.mFm[i]);
    }
}
