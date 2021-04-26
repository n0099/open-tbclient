package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class E0 {

    /* renamed from: a  reason: collision with root package name */
    public List f37641a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f37641a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f37641a) {
            this.f37641a.clear();
            this.f37641a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f37641a) {
            info = null;
            while (this.f37641a.size() > 0 && ((info = (Info) this.f37641a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f37641a) {
            isEmpty = this.f37641a.isEmpty();
        }
        return isEmpty;
    }
}
