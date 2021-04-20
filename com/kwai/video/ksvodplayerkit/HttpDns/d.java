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
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public g<a> f37491a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f37492b;

    /* renamed from: c  reason: collision with root package name */
    public String f37493c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37494d;

    /* renamed from: e  reason: collision with root package name */
    public l f37495e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, j> f37496f;

    /* renamed from: g  reason: collision with root package name */
    public String f37497g;

    /* renamed from: h  reason: collision with root package name */
    public h f37498h;
    public com.kwai.video.ksvodplayerkit.b.c i;
    public Map<String, com.kwai.video.ksvodplayerkit.b.f> j;
    public int k;

    public d(h hVar) {
        this.f37496f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f37494d = false;
        this.k = 1;
        this.f37498h = hVar;
        a(hVar);
    }

    public d(String str) {
        this.f37496f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f37494d = false;
        this.f37493c = str;
        this.k = 2;
        b(str);
    }

    public d(List<String> list) {
        this.f37496f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f37494d = false;
        this.f37491a = new g<>();
        this.f37492b = list;
        a(list);
    }

    private void a(com.kwai.video.ksvodplayerkit.b.f fVar, a aVar, a aVar2) {
        fVar.f37527a = aVar.f37486b;
        String str = aVar.f37485a;
        fVar.m = str;
        String str2 = fVar.f37530d;
        f fVar2 = aVar.f37487c;
        fVar.f37530d = str2.replace(str, fVar2 != null ? fVar2.f37502b : str);
        if (aVar2 != null) {
            fVar.f37532f = "";
        }
        this.i.f37525d = aVar.f37485a;
    }

    private void a(h hVar) {
        if (this.f37495e == null) {
            l lVar = new l();
            this.f37495e = lVar;
            lVar.f37551a = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.a aVar = new com.kwai.video.ksvodplayerkit.b.a();
            this.f37495e.f37551a.add(aVar);
            aVar.f37519a = 1L;
            aVar.f37520b = String.valueOf(hVar.f37535a);
            aVar.f37521c = new ArrayList();
            for (i iVar : hVar.f37536b) {
                if (iVar != null) {
                    j jVar = new j();
                    aVar.f37521c.add(jVar);
                    jVar.f37543a = iVar.f37538b;
                    jVar.f37546d = iVar.f37540d;
                    jVar.f37547e = iVar.f37542f;
                    jVar.f37548f = iVar.f37541e;
                    jVar.f37550h = iVar.f37539c;
                    ArrayList arrayList = new ArrayList();
                    for (String str : iVar.f37537a) {
                        try {
                            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
                            int i = 0;
                            for (f fVar : e.a().a(b2)) {
                                this.f37494d = true;
                                a aVar2 = new a(b2, str.replace(b2, fVar.f37502b), fVar);
                                arrayList.add(aVar2);
                                if (iVar.f37537a.size() > 1 && (i = i + 1) >= 2) {
                                    break;
                                }
                                this.f37496f.put(aVar2.f37486b, jVar);
                            }
                            this.f37496f.put(str, jVar);
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
                        jVar.i = gVar;
                        gVar.a(arrayList);
                        a(jVar, jVar.i.c());
                    } else {
                        com.kwai.video.ksvodplayerkit.a.b.e("HostSwitcher", "MultiRateSourceSwitcher. Init failed");
                    }
                }
            }
        }
    }

    private void a(j jVar, a aVar) {
        String str = aVar.f37486b;
        jVar.f37549g = str;
        jVar.f37544b = aVar.f37485a;
        jVar.f37545c = com.kwai.video.ksvodplayerkit.c.c.c(str);
    }

    private void a(List<String> list) {
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
            int i = 0;
            for (f fVar : e.a().a(b2)) {
                arrayList.add(new a(b2, str, str.replace(b2, fVar.f37502b), fVar));
                this.f37494d = true;
                if (list.size() > 1 && (i = i + 1) >= 2) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new a(b2, str, str, (f) null));
            }
            this.f37491a.a(arrayList);
        }
        if (com.kwai.video.ksvodplayerkit.i.a().j()) {
            Collections.sort(this.f37491a.f37506a);
        }
    }

    private void b(String str) {
        c.a aVar;
        com.kwai.video.ksvodplayerkit.b.c a2 = com.kwai.video.ksvodplayerkit.b.d.a(str);
        this.i = a2;
        if (a2 == null || (aVar = a2.f37524c) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.f37526a.size(); i++) {
            ArrayList<a> arrayList2 = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.f fVar = aVar.f37526a.get(i);
            String str2 = fVar.f37527a;
            try {
                arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str2), str2, str2, (f) null));
                for (String str3 : fVar.f37528b) {
                    arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str3), str3, str3, (f) null));
                }
                for (a aVar2 : arrayList2) {
                    for (f fVar2 : e.a().a(aVar2.f37485a)) {
                        this.f37494d = true;
                        String str4 = aVar2.f37485a;
                        a aVar3 = new a(str4, aVar2.f37489e.replace(str4, fVar2.f37502b), fVar2);
                        arrayList.add(aVar3);
                        this.j.put(aVar3.f37486b, fVar);
                    }
                    this.j.put(aVar2.f37489e, fVar);
                    if (!TextUtils.isEmpty(aVar2.f37485a)) {
                        arrayList.add(new a(aVar2.f37485a, aVar2.f37489e, null));
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
        int i = this.k;
        if (i == 1) {
            j jVar = this.f37496f.get(this.f37497g);
            if (jVar != null) {
                return jVar.i;
            }
            return null;
        } else if (i == 2) {
            com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f37497g);
            if (fVar != null) {
                return fVar.n;
            }
            return null;
        } else {
            return this.f37491a;
        }
    }

    public void a(String str) {
        this.f37497g = str;
    }

    public void a(boolean z) {
        h hVar;
        String str;
        if (this.f37494d) {
            return;
        }
        if (this.k == 0) {
            a(this.f37492b);
        }
        if (this.k == 2 && (str = this.f37493c) != null) {
            b(str);
        } else if (this.k != 1 || (hVar = this.f37498h) == null) {
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
            j jVar = this.f37496f.get(this.f37497g);
            if (jVar == null || (gVar2 = jVar.i) == null) {
                return false;
            }
            a b2 = b();
            String str3 = b2 != null ? b2.f37486b : null;
            if (!e()) {
                jVar.i.a();
            }
            a(jVar, jVar.i.c());
            a c2 = gVar2.c();
            if ((c2 == null || TextUtils.equals(str3, c2.f37486b)) ? false : true) {
                str2 = "URL_TYPE_MULTIRATE_MANIFEST switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
        }
        if (this.k != 2) {
            a b3 = b();
            str = b3 != null ? b3.f37486b : null;
            if (!e()) {
                this.f37491a.a();
            }
            a b4 = b();
            if ((b4 == null || TextUtils.equals(str, b4.f37486b)) ? false : true) {
                str2 = "switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
            com.kwai.video.ksvodplayerkit.a.b.d("HostSwitcher", "switchHost play url failed! url type:" + this.k);
            return false;
        }
        com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f37497g);
        if (fVar == null || (gVar = fVar.n) == null) {
            return false;
        }
        a b5 = b();
        str = b5 != null ? b5.f37486b : null;
        if (!e()) {
            fVar.n.a();
        }
        a c3 = gVar.c();
        if ((c3 == null || TextUtils.equals(str, c3.f37486b)) ? false : true) {
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
        return b2 != null ? b2.f37485a : "";
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
        return this.f37495e;
    }

    public com.kwai.video.ksvodplayerkit.b.c h() {
        return this.i;
    }

    public String i() {
        String str;
        a b2;
        int i = this.k;
        if ((i == 2 || i == 1) && (str = this.f37497g) != null) {
            return str;
        }
        if (this.k != 0 || (b2 = b()) == null) {
            return null;
        }
        return b2.f37486b;
    }
}
