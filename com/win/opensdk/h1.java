package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public List f39941a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f39941a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f39941a) {
            this.f39941a.clear();
            this.f39941a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f39941a) {
            info = null;
            while (this.f39941a.size() > 0 && ((info = (Info) this.f39941a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f39941a) {
            isEmpty = this.f39941a.isEmpty();
        }
        return isEmpty;
    }
}
