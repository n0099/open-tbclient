package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public int a;
    public final Map b;
    public final Map c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0692a {
        public static final a a = new a();
    }

    public a() {
        this.b = new HashMap();
        this.c = new LinkedHashMap(3);
        this.a = 3;
    }

    public static a a() {
        return C0692a.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public c a(String str, List list) {
        c cVar;
        synchronized (this.b) {
            cVar = (c) this.b.remove(str);
        }
        if (cVar != null) {
            if (f.a(cVar.h(), list)) {
                try {
                    cVar.d();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (cVar.f() && cVar.e()) {
                    return cVar;
                }
            }
            try {
                cVar.c();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public d b(String str, List list) {
        d dVar;
        synchronized (this.c) {
            dVar = (d) this.c.remove(str);
        }
        if (dVar != null) {
            if (f.a(dVar.f(), list)) {
                try {
                    dVar.e();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (dVar.h() && dVar.g()) {
                    return dVar;
                }
            }
            try {
                dVar.d();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public void a(String str, c cVar) {
        synchronized (this.b) {
            this.b.put(str, cVar);
        }
    }

    public boolean a(String str) {
        c cVar = (c) this.b.get(str);
        if (cVar == null) {
            return false;
        }
        if (cVar.g()) {
            return true;
        }
        if (!cVar.f() || !cVar.e()) {
            return false;
        }
        return true;
    }
}
