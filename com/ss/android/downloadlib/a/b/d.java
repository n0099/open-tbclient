package com.ss.android.downloadlib.a.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.f.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f13236a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.c> f13237b;
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.b> c;
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.a> d;
    private final ConcurrentHashMap<Long, com.ss.android.b.a.b.a> e;

    /* loaded from: classes4.dex */
    private static class b {
        private static d pVv = new d();
    }

    public static d eFT() {
        return b.pVv;
    }

    private d() {
        this.f13236a = new AtomicBoolean(false);
        this.f13237b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
    }

    public void b() {
        com.ss.android.downloadlib.f.eGz().c(new Runnable() { // from class: com.ss.android.downloadlib.a.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f13236a.compareAndSet(false, true)) {
                    d.this.e.putAll(g.eFW().b());
                }
            }
        }, true);
    }

    public void a(com.ss.android.a.a.b.c cVar) {
        if (cVar != null) {
            this.f13237b.put(Long.valueOf(cVar.d()), cVar);
            if (cVar.eFv() != null) {
                cVar.eFv().a(cVar.d());
                cVar.eFv().d(cVar.v());
            }
        }
    }

    public void a(long j, com.ss.android.a.a.b.b bVar) {
        if (bVar != null) {
            this.c.put(Long.valueOf(j), bVar);
        }
    }

    public void a(long j, com.ss.android.a.a.b.a aVar) {
        if (aVar != null) {
            this.d.put(Long.valueOf(j), aVar);
        }
    }

    public synchronized void d(com.ss.android.b.a.b.a aVar) {
        if (aVar != null) {
            this.e.put(Long.valueOf(aVar.j()), aVar);
            g.eFW().d(aVar);
        }
    }

    public com.ss.android.a.a.b.c iY(long j) {
        return this.f13237b.get(Long.valueOf(j));
    }

    public com.ss.android.a.a.b.b iZ(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public com.ss.android.a.a.b.a ja(long j) {
        return this.d.get(Long.valueOf(j));
    }

    public com.ss.android.b.a.b.a jb(long j) {
        return this.e.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.ss.android.b.a.b.a> eFU() {
        return this.e;
    }

    public com.ss.android.b.a.b.a aaM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.b.a.b.a aVar : this.e.values()) {
            if (aVar != null && str.equals(aVar.m())) {
                return aVar;
            }
        }
        return null;
    }

    public com.ss.android.b.a.b.a aaN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.b.a.b.a aVar : this.e.values()) {
            if (aVar != null && str.equals(aVar.z())) {
                return aVar;
            }
        }
        return null;
    }

    public com.ss.android.b.a.b.a j(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(cVar.C())) {
            try {
                long C = i.C(new JSONObject(cVar.C()), "extra");
                if (C > 0) {
                    for (com.ss.android.b.a.b.a aVar : this.e.values()) {
                        if (aVar != null && aVar.j() == C) {
                            return aVar;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (com.ss.android.b.a.b.a aVar2 : this.e.values()) {
            if (aVar2 != null && aVar2.t() == cVar.g()) {
                return aVar2;
            }
        }
        for (com.ss.android.b.a.b.a aVar3 : this.e.values()) {
            if (aVar3 != null && TextUtils.equals(aVar3.z(), cVar.j())) {
                return aVar3;
            }
        }
        return null;
    }

    public com.ss.android.b.a.b.a Sg(int i) {
        for (com.ss.android.b.a.b.a aVar : this.e.values()) {
            if (aVar != null && aVar.t() == i) {
                return aVar;
            }
        }
        return null;
    }

    @NonNull
    public a jc(long j) {
        a aVar = new a();
        aVar.f13238a = j;
        aVar.pVw = iY(j);
        aVar.pVx = iZ(j);
        aVar.pVy = ja(j);
        if (aVar.pVy == null) {
            aVar.pVy = new com.ss.android.b.a.a.a();
        }
        return aVar;
    }

    public void f(long j) {
        this.f13237b.remove(Long.valueOf(j));
        this.c.remove(Long.valueOf(j));
        this.d.remove(Long.valueOf(j));
    }

    @NonNull
    public Map<Long, com.ss.android.b.a.b.a> N(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        for (com.ss.android.b.a.b.a aVar : this.e.values()) {
            if (aVar != null && TextUtils.equals(aVar.z(), str)) {
                aVar.b(str2);
                hashMap.put(Long.valueOf(aVar.j()), aVar);
            }
        }
        return hashMap;
    }

    public void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.a.a.b.c cVar : this.f13237b.values()) {
                if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.equals(cVar.a(), str)) {
                    ((com.ss.android.b.a.a.c) cVar).aaC(str2);
                }
            }
        }
    }

    public synchronized void a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l : list) {
            long longValue = l.longValue();
            arrayList.add(String.valueOf(longValue));
            this.e.remove(Long.valueOf(longValue));
        }
        g.eFW().a((List<String>) arrayList);
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f13238a;
        public com.ss.android.a.a.b.c pVw;
        public com.ss.android.a.a.b.b pVx;
        public com.ss.android.a.a.b.a pVy;

        public a() {
        }

        public a(long j, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
            this.f13238a = j;
            this.pVw = cVar;
            this.pVx = bVar;
            this.pVy = aVar;
        }

        public boolean a() {
            return this.f13238a <= 0 || this.pVw == null || this.pVx == null || this.pVy == null;
        }
    }
}
