package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes7.dex */
public class d extends i {
    private i[] lGN;

    public d(int i) {
        this.lGN = new i[i];
    }

    public d(i... iVarArr) {
        this.lGN = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lGN[i] = i.aO(obj);
    }

    public i[] djC() {
        return this.lGN;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).djC(), this.lGN);
        }
        i aO = i.aO(obj);
        if (aO.getClass().equals(d.class)) {
            return Arrays.equals(((d) aO).djC(), this.lGN);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lGN) + 623;
    }
}
