package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class ac {
    private List<Info> qjR = Collections.synchronizedList(new ArrayList());

    public final void he(List<Info> list) {
        synchronized (this.qjR) {
            this.qjR.clear();
            this.qjR.addAll(list);
        }
    }

    public final Info eJa() {
        Info info = null;
        synchronized (this.qjR) {
            while (this.qjR.size() > 0 && ((info = this.qjR.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public final boolean java() {
        boolean isEmpty;
        synchronized (this.qjR) {
            isEmpty = this.qjR.isEmpty();
        }
        return isEmpty;
    }

    public final void eIP() {
        try {
            this.qjR.clear();
        } catch (Exception e) {
        }
    }
}
