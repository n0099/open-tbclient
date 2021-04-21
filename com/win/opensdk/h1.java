package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public List f40325a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f40325a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f40325a) {
            this.f40325a.clear();
            this.f40325a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f40325a) {
            info = null;
            while (this.f40325a.size() > 0 && ((info = (Info) this.f40325a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f40325a) {
            isEmpty = this.f40325a.isEmpty();
        }
        return isEmpty;
    }
}
