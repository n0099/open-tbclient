package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class ac {
    private List<Info> qkr = Collections.synchronizedList(new ArrayList());

    public final void he(List<Info> list) {
        synchronized (this.qkr) {
            this.qkr.clear();
            this.qkr.addAll(list);
        }
    }

    public final Info eJi() {
        Info info = null;
        synchronized (this.qkr) {
            while (this.qkr.size() > 0 && ((info = this.qkr.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public final boolean java() {
        boolean isEmpty;
        synchronized (this.qkr) {
            isEmpty = this.qkr.isEmpty();
        }
        return isEmpty;
    }

    public final void eIX() {
        try {
            this.qkr.clear();
        } catch (Exception e) {
        }
    }
}
