package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes7.dex */
public class d extends i {
    private i[] lGC;

    public d(int i) {
        this.lGC = new i[i];
    }

    public d(i... iVarArr) {
        this.lGC = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lGC[i] = i.aO(obj);
    }

    public i[] djB() {
        return this.lGC;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).djB(), this.lGC);
        }
        i aO = i.aO(obj);
        if (aO.getClass().equals(d.class)) {
            return Arrays.equals(((d) aO).djB(), this.lGC);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lGC) + 623;
    }
}
