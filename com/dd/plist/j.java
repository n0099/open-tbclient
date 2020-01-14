package com.dd.plist;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public class j extends i {
    private Set<i> Ju;
    private boolean lGb;

    public j() {
        this.lGb = false;
        this.Ju = new LinkedHashSet();
    }

    public j(boolean z) {
        this.lGb = false;
        this.lGb = z;
        if (!z) {
            this.Ju = new LinkedHashSet();
        } else {
            this.Ju = new TreeSet();
        }
    }

    public synchronized void a(i iVar) {
        this.Ju.add(iVar);
    }

    public int hashCode() {
        return (this.Ju != null ? this.Ju.hashCode() : 0) + 203;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            j jVar = (j) obj;
            return this.Ju == jVar.Ju || (this.Ju != null && this.Ju.equals(jVar.Ju));
        }
        return false;
    }
}
