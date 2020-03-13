package com.dd.plist;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public class j extends i {
    private Set<i> JP;
    private boolean lGV;

    public j() {
        this.lGV = false;
        this.JP = new LinkedHashSet();
    }

    public j(boolean z) {
        this.lGV = false;
        this.lGV = z;
        if (!z) {
            this.JP = new LinkedHashSet();
        } else {
            this.JP = new TreeSet();
        }
    }

    public synchronized void a(i iVar) {
        this.JP.add(iVar);
    }

    public int hashCode() {
        return (this.JP != null ? this.JP.hashCode() : 0) + 203;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            j jVar = (j) obj;
            return this.JP == jVar.JP || (this.JP != null && this.JP.equals(jVar.JP));
        }
        return false;
    }
}
