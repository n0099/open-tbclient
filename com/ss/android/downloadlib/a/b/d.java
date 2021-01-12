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
    private final AtomicBoolean f12936a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.c> f12937b;
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.b> c;
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.a> d;
    private final ConcurrentHashMap<Long, com.ss.android.b.a.b.a> e;

    /* loaded from: classes4.dex */
    private static class b {
        private static d pQU = new d();
    }

    public static d eCc() {
        return b.pQU;
    }

    private d() {
        this.f12936a = new AtomicBoolean(false);
        this.f12937b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
    }

    public void b() {
        com.ss.android.downloadlib.f.eCI().c(new Runnable() { // from class: com.ss.android.downloadlib.a.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f12936a.compareAndSet(false, true)) {
                    d.this.e.putAll(g.eCf().b());
                }
            }
        }, true);
    }

    public void a(com.ss.android.a.a.b.c cVar) {
        if (cVar != null) {
            this.f12937b.put(Long.valueOf(cVar.d()), cVar);
            if (cVar.eBE() != null) {
                cVar.eBE().a(cVar.d());
                cVar.eBE().d(cVar.v());
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
            g.eCf().d(aVar);
        }
    }

    public com.ss.android.a.a.b.c iY(long j) {
        return this.f12937b.get(Long.valueOf(j));
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

    public ConcurrentHashMap<Long, com.ss.android.b.a.b.a> eCd() {
        return this.e;
    }

    public com.ss.android.b.a.b.a ZE(String str) {
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

    public com.ss.android.b.a.b.a ZF(String str) {
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

    public com.ss.android.b.a.b.a Qz(int i) {
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
        aVar.f12938a = j;
        aVar.pQV = iY(j);
        aVar.pQW = iZ(j);
        aVar.pQX = ja(j);
        if (aVar.pQX == null) {
            aVar.pQX = new com.ss.android.b.a.a.a();
        }
        return aVar;
    }

    public void f(long j) {
        this.f12937b.remove(Long.valueOf(j));
        this.c.remove(Long.valueOf(j));
        this.d.remove(Long.valueOf(j));
    }

    @NonNull
    public Map<Long, com.ss.android.b.a.b.a> M(String str, String str2) {
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
            for (com.ss.android.a.a.b.c cVar : this.f12937b.values()) {
                if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.equals(cVar.a(), str)) {
                    ((com.ss.android.b.a.a.c) cVar).Zu(str2);
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
        g.eCf().a((List<String>) arrayList);
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f12938a;
        public com.ss.android.a.a.b.c pQV;
        public com.ss.android.a.a.b.b pQW;
        public com.ss.android.a.a.b.a pQX;

        public a() {
        }

        public a(long j, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
            this.f12938a = j;
            this.pQV = cVar;
            this.pQW = bVar;
            this.pQX = aVar;
        }

        public boolean a() {
            return this.f12938a <= 0 || this.pQV == null || this.pQW == null || this.pQX == null;
        }
    }
}
