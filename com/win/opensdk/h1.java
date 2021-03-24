package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public List f39940a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f39940a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f39940a) {
            this.f39940a.clear();
            this.f39940a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f39940a) {
            info = null;
            while (this.f39940a.size() > 0 && ((info = (Info) this.f39940a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f39940a) {
            isEmpty = this.f39940a.isEmpty();
        }
        return isEmpty;
    }
}
