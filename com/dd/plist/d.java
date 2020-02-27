package com.dd.plist;

import java.util.Arrays;
/* loaded from: classes7.dex */
public class d extends i {
    private i[] lGA;

    public d(int i) {
        this.lGA = new i[i];
    }

    public d(i... iVarArr) {
        this.lGA = iVarArr;
    }

    public void j(int i, Object obj) {
        this.lGA[i] = i.aO(obj);
    }

    public i[] djz() {
        return this.lGA;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).djz(), this.lGA);
        }
        i aO = i.aO(obj);
        if (aO.getClass().equals(d.class)) {
            return Arrays.equals(((d) aO).djz(), this.lGA);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this.lGA) + 623;
    }
}
