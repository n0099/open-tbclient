package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class ac {
    private List<Info> pZN = Collections.synchronizedList(new ArrayList());

    public final void hg(List<Info> list) {
        synchronized (this.pZN) {
            this.pZN.clear();
            this.pZN.addAll(list);
        }
    }

    public final Info eGK() {
        Info info = null;
        synchronized (this.pZN) {
            while (this.pZN.size() > 0 && ((info = this.pZN.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public final boolean java() {
        boolean isEmpty;
        synchronized (this.pZN) {
            isEmpty = this.pZN.isEmpty();
        }
        return isEmpty;
    }

    public final void eGz() {
        try {
            this.pZN.clear();
        } catch (Exception e) {
        }
    }
}
