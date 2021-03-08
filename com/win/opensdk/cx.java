package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes14.dex */
public class cx {

    /* renamed from: a  reason: collision with root package name */
    public List f8148a = Collections.synchronizedList(new ArrayList());

    public void a() {
        try {
            this.f8148a.clear();
        } catch (Exception e) {
        }
    }

    public void a(List list) {
        synchronized (this.f8148a) {
            this.f8148a.clear();
            this.f8148a.addAll(list);
        }
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f8148a) {
            isEmpty = this.f8148a.isEmpty();
        }
        return isEmpty;
    }

    public Info eJj() {
        Info info = null;
        synchronized (this.f8148a) {
            while (this.f8148a.size() > 0 && ((info = (Info) this.f8148a.remove(0)) == null || !info.isEffective())) {
            }
        }
        return info;
    }
}
