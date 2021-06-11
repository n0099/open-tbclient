package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class E0 {

    /* renamed from: a  reason: collision with root package name */
    public List f40494a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f40494a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f40494a) {
            this.f40494a.clear();
            this.f40494a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f40494a) {
            info = null;
            while (this.f40494a.size() > 0 && ((info = (Info) this.f40494a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f40494a) {
            isEmpty = this.f40494a.isEmpty();
        }
        return isEmpty;
    }
}
