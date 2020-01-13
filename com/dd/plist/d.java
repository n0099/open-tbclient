package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes5.dex */
public class d extends i {
    private i[] lFO;

    public d(int i) {
        this.lFO = new i[i];
    }

    public d(i... iVarArr) {
        this.lFO = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lFO[i] = i.aM(obj);
    }

    public i[] dik() {
        return this.lFO;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).dik(), this.lFO);
        }
        i aM = i.aM(obj);
        if (aM.getClass().equals(d.class)) {
            return Arrays.equals(((d) aM).dik(), this.lFO);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lFO) + 623;
    }
}
