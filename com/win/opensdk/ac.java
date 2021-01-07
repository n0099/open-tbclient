package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class ac {
    private List<Info> qen = Collections.synchronizedList(new ArrayList());

    public final void hg(List<Info> list) {
        synchronized (this.qen) {
            this.qen.clear();
            this.qen.addAll(list);
        }
    }

    public final Info eKA() {
        Info info = null;
        synchronized (this.qen) {
            while (this.qen.size() > 0 && ((info = this.qen.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public final boolean java() {
        boolean isEmpty;
        synchronized (this.qen) {
            isEmpty = this.qen.isEmpty();
        }
        return isEmpty;
    }

    public final void eKp() {
        try {
            this.qen.clear();
        } catch (Exception e) {
        }
    }
}
