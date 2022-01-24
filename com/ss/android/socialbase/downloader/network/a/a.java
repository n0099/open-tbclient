package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, c> f60280b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d> f60281c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C2229a {
        public static final a a = new a();
    }

    public void a(String str, c cVar) {
        synchronized (this.f60280b) {
            this.f60280b.put(str, cVar);
        }
    }

    public d b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        d remove;
        synchronized (this.f60281c) {
            remove = this.f60281c.remove(str);
        }
        if (remove != null) {
            if (f.a(remove.f(), list)) {
                try {
                    remove.e();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (remove.h() && remove.g()) {
                    return remove;
                }
            }
            try {
                remove.d();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public a() {
        this.f60280b = new HashMap();
        this.f60281c = new LinkedHashMap(3);
        this.a = 3;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public c a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c remove;
        synchronized (this.f60280b) {
            remove = this.f60280b.remove(str);
        }
        if (remove != null) {
            if (f.a(remove.h(), list)) {
                try {
                    remove.d();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (remove.f() && remove.e()) {
                    return remove;
                }
            }
            try {
                remove.c();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public boolean a(String str) {
        c cVar = this.f60280b.get(str);
        if (cVar != null) {
            if (cVar.g()) {
                return true;
            }
            return cVar.f() && cVar.e();
        }
        return false;
    }

    public static a a() {
        return C2229a.a;
    }
}
