package com.dd.plist;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class j extends i {
    private Set<i> Jo;
    private boolean lCy;

    public j() {
        this.lCy = false;
        this.Jo = new LinkedHashSet();
    }

    public j(boolean z) {
        this.lCy = false;
        this.lCy = z;
        if (!z) {
            this.Jo = new LinkedHashSet();
        } else {
            this.Jo = new TreeSet();
        }
    }

    public synchronized void a(i iVar) {
        this.Jo.add(iVar);
    }

    public int hashCode() {
        return (this.Jo != null ? this.Jo.hashCode() : 0) + 203;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            j jVar = (j) obj;
            return this.Jo == jVar.Jo || (this.Jo != null && this.Jo.equals(jVar.Jo));
        }
        return false;
    }
}
