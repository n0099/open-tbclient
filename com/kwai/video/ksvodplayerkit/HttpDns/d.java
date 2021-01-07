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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private g<a> f11328a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f11329b;
    private String c;
    private boolean d;
    private l e;
    private Map<String, j> f;
    private String g;
    private h h;
    private com.kwai.video.ksvodplayerkit.b.c i;
    private Map<String, com.kwai.video.ksvodplayerkit.b.f> j;
    private int k;

    public d(h hVar) {
        this.f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.d = false;
        this.k = 1;
        this.h = hVar;
        a(this.h);
    }

    public d(String str) {
        this.f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.d = false;
        this.c = str;
        this.k = 2;
        b(str);
    }

    public d(List<String> list) {
        this.f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.d = false;
        this.f11328a = new g<>();
        this.f11329b = list;
        a(this.f11329b);
    }

    private void a(com.kwai.video.ksvodplayerkit.b.f fVar, a aVar, a aVar2) {
        fVar.f11346a = aVar.f11326b;
        fVar.m = aVar.f11325a;
        fVar.d = fVar.d.replace(aVar.f11325a, aVar.c != null ? aVar.c.f11333b : aVar.f11325a);
        if (aVar2 != null) {
            fVar.f = "";
        }
        this.i.d = aVar.f11325a;
    }

    private void a(h hVar) {
        if (this.e == null) {
            this.e = new l();
            this.e.f11354a = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.a aVar = new com.kwai.video.ksvodplayerkit.b.a();
            this.e.f11354a.add(aVar);
            aVar.f11341a = 1L;
            aVar.f11342b = String.valueOf(hVar.f11348a);
            aVar.c = new ArrayList();
            for (i iVar : hVar.f11349b) {
                if (iVar != null) {
                    j jVar = new j();
                    aVar.c.add(jVar);
                    jVar.f11352a = iVar.f11351b;
                    jVar.d = iVar.d;
                    jVar.e = iVar.f;
                    jVar.f = iVar.e;
                    jVar.h = iVar.c;
                    ArrayList arrayList = new ArrayList();
                    for (String str : iVar.f11350a) {
                        try {
                            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
                            int i = 0;
                            Iterator<f> it = e.a().a(b2).iterator();
                            while (true) {
                                int i2 = i;
                                if (!it.hasNext()) {
                                    break;
                                }
                                f next = it.next();
                                this.d = true;
                                a aVar2 = new a(b2, str.replace(b2, next.f11333b), next);
                                arrayList.add(aVar2);
                                if (iVar.f11350a.size() > 1) {
                                    i = i2 + 1;
                                    if (i >= 2) {
                                        break;
                                    }
                                } else {
                                    i = i2;
                                }
                                this.f.put(aVar2.f11326b, jVar);
                            }
                            this.f.put(str, jVar);
                            if (!TextUtils.isEmpty(b2)) {
                                arrayList.add(new a(b2, str, null));
                            }
                        } catch (Exception e) {
                            com.kwai.video.ksvodplayerkit.a.b.e("MultiRateSourceSwitcher", e.getMessage());
                            return;
                        }
                    }
                    if (arrayList.size() > 0) {
                        jVar.i = new g<>();
                        jVar.i.a(arrayList);
                        a(jVar, jVar.i.c());
                    } else {
                        com.kwai.video.ksvodplayerkit.a.b.e("HostSwitcher", "MultiRateSourceSwitcher. Init failed");
                    }
                }
            }
        }
    }

    private void a(j jVar, a aVar) {
        jVar.g = aVar.f11326b;
        jVar.f11353b = aVar.f11325a;
        jVar.c = com.kwai.video.ksvodplayerkit.c.c.c(aVar.f11326b);
    }

    private void a(List<String> list) {
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
            int i = 0;
            Iterator<f> it = e.a().a(b2).iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                arrayList.add(new a(b2, str, str.replace(b2, next.f11333b), next));
                this.d = true;
                if (list.size() > 1) {
                    i = i2 + 1;
                    if (i >= 2) {
                        break;
                    }
                } else {
                    i = i2;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new a(b2, str, str, (f) null));
            }
            this.f11328a.a(arrayList);
        }
        if (com.kwai.video.ksvodplayerkit.i.a().j()) {
            Collections.sort(this.f11328a.f11334a);
        }
    }

    private void b(String str) {
        c.a aVar;
        this.i = com.kwai.video.ksvodplayerkit.b.d.a(str);
        if (this.i == null || (aVar = this.i.c) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aVar.f11345a.size()) {
                return;
            }
            ArrayList<a> arrayList2 = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.f fVar = aVar.f11345a.get(i2);
            String str2 = fVar.f11346a;
            try {
                arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str2), str2, str2, (f) null));
                for (String str3 : fVar.f11347b) {
                    arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str3), str3, str3, (f) null));
                }
                for (a aVar2 : arrayList2) {
                    for (f fVar2 : e.a().a(aVar2.f11325a)) {
                        this.d = true;
                        a aVar3 = new a(aVar2.f11325a, aVar2.e.replace(aVar2.f11325a, fVar2.f11333b), fVar2);
                        arrayList.add(aVar3);
                        this.j.put(aVar3.f11326b, fVar);
                    }
                    this.j.put(aVar2.e, fVar);
                    if (!TextUtils.isEmpty(aVar2.f11325a)) {
                        arrayList.add(new a(aVar2.f11325a, aVar2.e, null));
                    }
                }
                if (arrayList.size() > 0) {
                    fVar.n = new g<>();
                    fVar.n.a(arrayList);
                    a(fVar, fVar.n.c(), null);
                }
            } catch (Exception e) {
                com.kwai.video.ksvodplayerkit.a.b.e("initHlsAdaptationSet host parse failed", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    private g<a> j() {
        if (this.k == 1) {
            j jVar = this.f.get(this.g);
            if (jVar != null) {
                return jVar.i;
            }
        } else if (this.k != 2) {
            return this.f11328a;
        } else {
            com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.g);
            if (fVar != null) {
                return fVar.n;
            }
        }
        return null;
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(boolean z) {
        if (this.d) {
            return;
        }
        if (this.k == 0) {
            a(this.f11329b);
        }
        if (this.k == 2 && this.c != null) {
            b(this.c);
        } else if (this.k != 1 || this.h == null) {
        } else {
            a(this.h);
        }
    }

    public boolean a() {
        String str;
        g<a> gVar;
        g<a> gVar2;
        if (this.k == 1) {
            j jVar = this.f.get(this.g);
            if (jVar != null && (gVar2 = jVar.i) != null) {
                a b2 = b();
                String str2 = b2 != null ? b2.f11326b : null;
                if (!e()) {
                    jVar.i.a();
                }
                a(jVar, jVar.i.c());
                a c = gVar2.c();
                if ((c == null || TextUtils.equals(str2, c.f11326b)) ? false : true) {
                    com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", "URL_TYPE_MULTIRATE_MANIFEST switch PlayUrls");
                    return true;
                }
            }
            return false;
        }
        if (this.k == 2) {
            com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.g);
            if (fVar != null && (gVar = fVar.n) != null) {
                a b3 = b();
                str = b3 != null ? b3.f11326b : null;
                if (!e()) {
                    fVar.n.a();
                }
                a c2 = gVar.c();
                if ((c2 == null || TextUtils.equals(str, c2.f11326b)) ? false : true) {
                    a(fVar, fVar.n.c(), b3);
                    com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", "URL_TYPE_HLS_MANIFEST switch PlayUrls");
                    return true;
                }
            }
            return false;
        }
        a b4 = b();
        str = b4 != null ? b4.f11326b : null;
        if (!e()) {
            this.f11328a.a();
        }
        a b5 = b();
        if ((b5 == null || TextUtils.equals(str, b5.f11326b)) ? false : true) {
            com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", "switch PlayUrls");
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
        return b2 != null ? b2.f11325a : "";
    }

    public boolean e() {
        g<a> j = j();
        return j != null && j.d() == j.b() + (-1);
    }

    public int f() {
        g<a> j = j();
        if (j != null) {
            return j.b();
        }
        return 0;
    }

    public l g() {
        return this.e;
    }

    public com.kwai.video.ksvodplayerkit.b.c h() {
        return this.i;
    }

    public String i() {
        a b2;
        if ((this.k == 2 || this.k == 1) && this.g != null) {
            return this.g;
        }
        if (this.k != 0 || (b2 = b()) == null) {
            return null;
        }
        return b2.f11326b;
    }
}
