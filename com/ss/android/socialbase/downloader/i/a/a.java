package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f7838a;
    private final Map<String, c> b;
    private final Map<String, d> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, c cVar) {
        synchronized (this.b) {
            this.b.put(str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f7838a = i;
    }

    public c w(String str, List<e> list) {
        c remove;
        synchronized (this.b) {
            remove = this.b.remove(str);
        }
        if (remove != null) {
            if (com.ss.android.socialbase.downloader.m.d.H(remove.h(), list)) {
                try {
                    remove.d();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.f() && remove.e()) {
                    return remove;
                }
            }
            try {
                remove.c();
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public boolean a(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            if (cVar.g()) {
                return true;
            }
            return cVar.f() && cVar.e();
        }
        return false;
    }

    public d x(String str, List<e> list) {
        d remove;
        synchronized (this.c) {
            remove = this.c.remove(str);
        }
        if (remove != null) {
            if (com.ss.android.socialbase.downloader.m.d.H(remove.f(), list)) {
                try {
                    remove.e();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.h() && remove.g()) {
                    return remove;
                }
            }
            try {
                remove.d();
            } catch (Throwable th) {
            }
        }
        return null;
    }

    /* renamed from: com.ss.android.socialbase.downloader.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static final class C1245a {
        private static final a qhx = new a();
    }

    public static a eIw() {
        return C1245a.qhx;
    }

    private a() {
        this.b = new HashMap();
        this.c = new LinkedHashMap(3);
        this.f7838a = 3;
    }
}
