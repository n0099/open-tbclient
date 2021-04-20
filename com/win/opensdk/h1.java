package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public List f40230a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f40230a.clear();
        } catch (Exception unused) {
        }
    }

    public void a(List list) {
        synchronized (this.f40230a) {
            this.f40230a.clear();
            this.f40230a.addAll(list);
        }
    }

    public Info b() {
        Info info;
        synchronized (this.f40230a) {
            info = null;
            while (this.f40230a.size() > 0 && ((info = (Info) this.f40230a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f40230a) {
            isEmpty = this.f40230a.isEmpty();
        }
        return isEmpty;
    }
}
