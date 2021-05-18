package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class E0 {

    /* renamed from: a  reason: collision with root package name */
    public List f36886a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f36886a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f36886a) {
            this.f36886a.clear();
            this.f36886a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f36886a) {
            info = null;
            while (this.f36886a.size() > 0 && ((info = (Info) this.f36886a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f36886a) {
            isEmpty = this.f36886a.isEmpty();
        }
        return isEmpty;
    }
}
