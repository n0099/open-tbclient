package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class E0 {

    /* renamed from: a  reason: collision with root package name */
    public List f40597a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f40597a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f40597a) {
            this.f40597a.clear();
            this.f40597a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f40597a) {
            info = null;
            while (this.f40597a.size() > 0 && ((info = (Info) this.f40597a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f40597a) {
            isEmpty = this.f40597a.isEmpty();
        }
        return isEmpty;
    }
}
