package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes5.dex */
public class d extends i {
    private i[] lFT;

    public d(int i) {
        this.lFT = new i[i];
    }

    public d(i... iVarArr) {
        this.lFT = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lFT[i] = i.aM(obj);
    }

    public i[] dim() {
        return this.lFT;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).dim(), this.lFT);
        }
        i aM = i.aM(obj);
        if (aM.getClass().equals(d.class)) {
            return Arrays.equals(((d) aM).dim(), this.lFT);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lFT) + 623;
    }
}
