package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f13162a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f13163b;
    private final Map<String, d> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, c cVar) {
        synchronized (this.f13163b) {
            this.f13163b.put(str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f13162a = i;
    }

    public c w(String str, List<e> list) {
        c remove;
        synchronized (this.f13163b) {
            remove = this.f13163b.remove(str);
        }
        if (remove != null) {
            if (com.ss.android.socialbase.downloader.m.d.a(remove.h(), list)) {
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
        c cVar = this.f13163b.get(str);
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
            if (com.ss.android.socialbase.downloader.m.d.a(remove.f(), list)) {
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
    /* loaded from: classes4.dex */
    private static final class C1249a {
        private static final a pWd = new a();
    }

    public static a eFV() {
        return C1249a.pWd;
    }

    private a() {
        this.f13163b = new HashMap();
        this.c = new LinkedHashMap(3);
        this.f13162a = 3;
    }
}
