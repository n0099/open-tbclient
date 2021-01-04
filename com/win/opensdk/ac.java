package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class ac {
    private List<Info> qcF = Collections.synchronizedList(new ArrayList());

    public final void hf(List<Info> list) {
        synchronized (this.qcF) {
            this.qcF.clear();
            this.qcF.addAll(list);
        }
    }

    public final Info eJW() {
        Info info = null;
        synchronized (this.qcF) {
            while (this.qcF.size() > 0 && ((info = this.qcF.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public final boolean java() {
        boolean isEmpty;
        synchronized (this.qcF) {
            isEmpty = this.qcF.isEmpty();
        }
        return isEmpty;
    }

    public final void eJL() {
        try {
            this.qcF.clear();
        } catch (Exception e) {
        }
    }
}
