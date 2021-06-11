package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.b.c;
import com.kwai.video.ksvodplayerkit.b.h;
import com.kwai.video.ksvodplayerkit.b.i;
import com.kwai.video.ksvodplayerkit.b.j;
import com.kwai.video.ksvodplayerkit.b.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public g<a> f37970a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f37971b;

    /* renamed from: c  reason: collision with root package name */
    public String f37972c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37973d;

    /* renamed from: e  reason: collision with root package name */
    public l f37974e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, j> f37975f;

    /* renamed from: g  reason: collision with root package name */
    public String f37976g;

    /* renamed from: h  reason: collision with root package name */
    public h f37977h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.b.c f37978i;
    public Map<String, com.kwai.video.ksvodplayerkit.b.f> j;
    public int k;

    public d(h hVar) {
        this.f37975f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f37973d = false;
        this.k = 1;
        this.f37977h = hVar;
        a(hVar);
    }

    public d(String str) {
        this.f37975f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f37973d = false;
        this.f37972c = str;
        this.k = 2;
        b(str);
    }

    public d(List<String> list) {
        this.f37975f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f37973d = false;
        this.f37970a = new g<>();
        this.f37971b = list;
        a(list);
    }

    private void a(com.kwai.video.ksvodplayerkit.b.f fVar, a aVar, a aVar2) {
        fVar.f38008a = aVar.f37965b;
        String str = aVar.f37964a;
        fVar.m = str;
        String str2 = fVar.f38011d;
        f fVar2 = aVar.f37966c;
        fVar.f38011d = str2.replace(str, fVar2 != null ? fVar2.f37982b : str);
        if (aVar2 != null) {
            fVar.f38013f = "";
        }
        this.f37978i.f38006d = aVar.f37964a;
    }

    private void a(h hVar) {
        if (this.f37974e == null) {
            l lVar = new l();
            this.f37974e = lVar;
            lVar.f38034a = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.a aVar = new com.kwai.video.ksvodplayerkit.b.a();
            this.f37974e.f38034a.add(aVar);
            aVar.f38000a = 1L;
            aVar.f38001b = String.valueOf(hVar.f38017a);
            aVar.f38002c = new ArrayList();
            for (i iVar : hVar.f38018b) {
                if (iVar != null) {
                    j jVar = new j();
                    aVar.f38002c.add(jVar);
                    jVar.f38025a = iVar.f38020b;
                    jVar.f38028d = iVar.f38022d;
                    jVar.f38029e = iVar.f38024f;
                    jVar.f38030f = iVar.f38023e;
                    jVar.f38032h = iVar.f38021c;
                    ArrayList arrayList = new ArrayList();
                    for (String str : iVar.f38019a) {
                        try {
                            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
                            int i2 = 0;
                            for (f fVar : e.a().a(b2)) {
                                this.f37973d = true;
                                a aVar2 = new a(b2, str.replace(b2, fVar.f37982b), fVar);
                                arrayList.add(aVar2);
                                if (iVar.f38019a.size() > 1 && (i2 = i2 + 1) >= 2) {
                                    break;
                                }
                                this.f37975f.put(aVar2.f37965b, jVar);
                            }
                            this.f37975f.put(str, jVar);
                            if (!TextUtils.isEmpty(b2)) {
                                arrayList.add(new a(b2, str, null));
                            }
                        } catch (Exception e2) {
                            com.kwai.video.ksvodplayerkit.a.b.e("MultiRateSourceSwitcher", e2.getMessage());
                            return;
                        }
                    }
                    if (arrayList.size() > 0) {
                        g<a> gVar = new g<>();
                        jVar.f38033i = gVar;
                        gVar.a(arrayList);
                        a(jVar, jVar.f38033i.c());
                    } else {
                        com.kwai.video.ksvodplayerkit.a.b.e("HostSwitcher", "MultiRateSourceSwitcher. Init failed");
                    }
                }
            }
        }
    }

    private void a(j jVar, a aVar) {
        String str = aVar.f37965b;
        jVar.f38031g = str;
        jVar.f38026b = aVar.f37964a;
        jVar.f38027c = com.kwai.video.ksvodplayerkit.c.c.c(str);
    }

    private void a(List<String> list) {
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
            int i2 = 0;
            for (f fVar : e.a().a(b2)) {
                arrayList.add(new a(b2, str, str.replace(b2, fVar.f37982b), fVar));
                this.f37973d = true;
                if (list.size() > 1 && (i2 = i2 + 1) >= 2) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new a(b2, str, str, (f) null));
            }
            this.f37970a.a(arrayList);
        }
        if (com.kwai.video.ksvodplayerkit.i.a().j()) {
            Collections.sort(this.f37970a.f37986a);
        }
    }

    private void b(String str) {
        c.a aVar;
        com.kwai.video.ksvodplayerkit.b.c a2 = com.kwai.video.ksvodplayerkit.b.d.a(str);
        this.f37978i = a2;
        if (a2 == null || (aVar = a2.f38005c) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.f38007a.size(); i2++) {
            ArrayList<a> arrayList2 = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.f fVar = aVar.f38007a.get(i2);
            String str2 = fVar.f38008a;
            try {
                arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str2), str2, str2, (f) null));
                for (String str3 : fVar.f38009b) {
                    arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str3), str3, str3, (f) null));
                }
                for (a aVar2 : arrayList2) {
                    for (f fVar2 : e.a().a(aVar2.f37964a)) {
                        this.f37973d = true;
                        String str4 = aVar2.f37964a;
                        a aVar3 = new a(str4, aVar2.f37968e.replace(str4, fVar2.f37982b), fVar2);
                        arrayList.add(aVar3);
                        this.j.put(aVar3.f37965b, fVar);
                    }
                    this.j.put(aVar2.f37968e, fVar);
                    if (!TextUtils.isEmpty(aVar2.f37964a)) {
                        arrayList.add(new a(aVar2.f37964a, aVar2.f37968e, null));
                    }
                }
                if (arrayList.size() > 0) {
                    g<a> gVar = new g<>();
                    fVar.n = gVar;
                    gVar.a(arrayList);
                    a(fVar, fVar.n.c(), null);
                }
            } catch (Exception e2) {
                com.kwai.video.ksvodplayerkit.a.b.e("initHlsAdaptationSet host parse failed", e2.getMessage());
            }
        }
    }

    private g<a> j() {
        int i2 = this.k;
        if (i2 == 1) {
            j jVar = this.f37975f.get(this.f37976g);
            if (jVar != null) {
                return jVar.f38033i;
            }
            return null;
        } else if (i2 == 2) {
            com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f37976g);
            if (fVar != null) {
                return fVar.n;
            }
            return null;
        } else {
            return this.f37970a;
        }
    }

    public void a(String str) {
        this.f37976g = str;
    }

    public void a(boolean z) {
        h hVar;
        String str;
        if (this.f37973d) {
            return;
        }
        if (this.k == 0) {
            a(this.f37971b);
        }
        if (this.k == 2 && (str = this.f37972c) != null) {
            b(str);
        } else if (this.k != 1 || (hVar = this.f37977h) == null) {
        } else {
            a(hVar);
        }
    }

    public boolean a() {
        String str;
        String str2;
        g<a> gVar;
        g<a> gVar2;
        if (this.k == 1) {
            j jVar = this.f37975f.get(this.f37976g);
            if (jVar == null || (gVar2 = jVar.f38033i) == null) {
                return false;
            }
            a b2 = b();
            String str3 = b2 != null ? b2.f37965b : null;
            if (!e()) {
                jVar.f38033i.a();
            }
            a(jVar, jVar.f38033i.c());
            a c2 = gVar2.c();
            if ((c2 == null || TextUtils.equals(str3, c2.f37965b)) ? false : true) {
                str2 = "URL_TYPE_MULTIRATE_MANIFEST switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
        }
        if (this.k != 2) {
            a b3 = b();
            str = b3 != null ? b3.f37965b : null;
            if (!e()) {
                this.f37970a.a();
            }
            a b4 = b();
            if ((b4 == null || TextUtils.equals(str, b4.f37965b)) ? false : true) {
                str2 = "switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
            com.kwai.video.ksvodplayerkit.a.b.d("HostSwitcher", "switchHost play url failed! url type:" + this.k);
            return false;
        }
        com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f37976g);
        if (fVar == null || (gVar = fVar.n) == null) {
            return false;
        }
        a b5 = b();
        str = b5 != null ? b5.f37965b : null;
        if (!e()) {
            fVar.n.a();
        }
        a c3 = gVar.c();
        if ((c3 == null || TextUtils.equals(str, c3.f37965b)) ? false : true) {
            a(fVar, fVar.n.c(), b5);
            str2 = "URL_TYPE_HLS_MANIFEST switch PlayUrls";
            com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
            return true;
        }
        com.kwai.video.ksvodplayerkit.a.b.d("HostSwitcher", "switchHost play url failed! url type:" + this.k);
        return false;
    }

    public a b() {
        g<a> j = j();
        if (j == null || j.b() <= 0) {
            return null;
        }
        return j.c();
    }

    public int c() {
        g<a> j = j();
        if (j != null) {
            return j.d();
        }
        return 0;
    }

    public String d() {
        a b2 = b();
        return b2 != null ? b2.f37964a : "";
    }

    public boolean e() {
        g<a> j = j();
        return j != null && j.d() == j.b() - 1;
    }

    public int f() {
        g<a> j = j();
        if (j != null) {
            return j.b();
        }
        return 0;
    }

    public l g() {
        return this.f37974e;
    }

    public com.kwai.video.ksvodplayerkit.b.c h() {
        return this.f37978i;
    }

    public String i() {
        String str;
        a b2;
        int i2 = this.k;
        if ((i2 == 2 || i2 == 1) && (str = this.f37976g) != null) {
            return str;
        }
        if (this.k != 0 || (b2 = b()) == null) {
            return null;
        }
        return b2.f37965b;
    }
}
