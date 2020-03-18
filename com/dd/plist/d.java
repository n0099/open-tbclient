package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes7.dex */
public class d extends i {
    private i[] lIt;

    public d(int i) {
        this.lIt = new i[i];
    }

    public d(i... iVarArr) {
        this.lIt = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lIt[i] = i.aO(obj);
    }

    public i[] djZ() {
        return this.lIt;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).djZ(), this.lIt);
        }
        i aO = i.aO(obj);
        if (aO.getClass().equals(d.class)) {
            return Arrays.equals(((d) aO).djZ(), this.lIt);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lIt) + 623;
    }
}
