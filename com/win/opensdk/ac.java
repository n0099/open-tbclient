package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class ac {
    private List<Info> pZM = Collections.synchronizedList(new ArrayList());

    public final void hg(List<Info> list) {
        synchronized (this.pZM) {
            this.pZM.clear();
            this.pZM.addAll(list);
        }
    }

    public final Info eGK() {
        Info info = null;
        synchronized (this.pZM) {
            while (this.pZM.size() > 0 && ((info = this.pZM.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public final boolean java() {
        boolean isEmpty;
        synchronized (this.pZM) {
            isEmpty = this.pZM.isEmpty();
        }
        return isEmpty;
    }

    public final void eGz() {
        try {
            this.pZM.clear();
        } catch (Exception e) {
        }
    }
}
