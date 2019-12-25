package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes4.dex */
public class d extends i {
    private i[] lCq;

    public d(int i) {
        this.lCq = new i[i];
    }

    public d(i... iVarArr) {
        this.lCq = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lCq[i] = i.aM(obj);
    }

    public i[] dhj() {
        return this.lCq;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).dhj(), this.lCq);
        }
        i aM = i.aM(obj);
        if (aM.getClass().equals(d.class)) {
            return Arrays.equals(((d) aM).dhj(), this.lCq);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lCq) + 623;
    }
}
