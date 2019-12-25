package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
public final class i {
    public final u myK;
    public final boolean[] myL;
    public final g myM;
    public final Object myN;
    public final com.google.android.exoplayer2.u[] myO;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.myK = uVar;
        this.myL = zArr;
        this.myM = gVar;
        this.myN = obj;
        this.myO = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.myM.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.myL[i] == iVar.myL[i] && v.h(this.myM.Lu(i), iVar.myM.Lu(i)) && v.h(this.myO[i], iVar.myO[i]);
    }
}
