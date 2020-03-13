package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class i {
    public final u mDB;
    public final boolean[] mDC;
    public final g mDD;
    public final Object mDE;
    public final com.google.android.exoplayer2.u[] mDF;

    public i(u uVar, boolean[] zArr, g gVar, Object obj, com.google.android.exoplayer2.u[] uVarArr) {
        this.mDB = uVar;
        this.mDC = zArr;
        this.mDD = gVar;
        this.mDE = obj;
        this.mDF = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.mDD.length; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.mDC[i] == iVar.mDC[i] && v.h(this.mDD.LI(i), iVar.mDD.LI(i)) && v.h(this.mDF[i], iVar.mDF[i]);
    }
}
