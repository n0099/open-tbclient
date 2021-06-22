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
    public g<a> f38068a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f38069b;

    /* renamed from: c  reason: collision with root package name */
    public String f38070c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38071d;

    /* renamed from: e  reason: collision with root package name */
    public l f38072e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, j> f38073f;

    /* renamed from: g  reason: collision with root package name */
    public String f38074g;

    /* renamed from: h  reason: collision with root package name */
    public h f38075h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.b.c f38076i;
    public Map<String, com.kwai.video.ksvodplayerkit.b.f> j;
    public int k;

    public d(h hVar) {
        this.f38073f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f38071d = false;
        this.k = 1;
        this.f38075h = hVar;
        a(hVar);
    }

    public d(String str) {
        this.f38073f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f38071d = false;
        this.f38070c = str;
        this.k = 2;
        b(str);
    }

    public d(List<String> list) {
        this.f38073f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f38071d = false;
        this.f38068a = new g<>();
        this.f38069b = list;
        a(list);
    }

    private void a(com.kwai.video.ksvodplayerkit.b.f fVar, a aVar, a aVar2) {
        fVar.f38106a = aVar.f38063b;
        String str = aVar.f38062a;
        fVar.m = str;
        String str2 = fVar.f38109d;
        f fVar2 = aVar.f38064c;
        fVar.f38109d = str2.replace(str, fVar2 != null ? fVar2.f38080b : str);
        if (aVar2 != null) {
            fVar.f38111f = "";
        }
        this.f38076i.f38104d = aVar.f38062a;
    }

    private void a(h hVar) {
        if (this.f38072e == null) {
            l lVar = new l();
            this.f38072e = lVar;
            lVar.f38132a = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.a aVar = new com.kwai.video.ksvodplayerkit.b.a();
            this.f38072e.f38132a.add(aVar);
            aVar.f38098a = 1L;
            aVar.f38099b = String.valueOf(hVar.f38115a);
            aVar.f38100c = new ArrayList();
            for (i iVar : hVar.f38116b) {
                if (iVar != null) {
                    j jVar = new j();
                    aVar.f38100c.add(jVar);
                    jVar.f38123a = iVar.f38118b;
                    jVar.f38126d = iVar.f38120d;
                    jVar.f38127e = iVar.f38122f;
                    jVar.f38128f = iVar.f38121e;
                    jVar.f38130h = iVar.f38119c;
                    ArrayList arrayList = new ArrayList();
                    for (String str : iVar.f38117a) {
                        try {
                            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
                            int i2 = 0;
                            for (f fVar : e.a().a(b2)) {
                                this.f38071d = true;
                                a aVar2 = new a(b2, str.replace(b2, fVar.f38080b), fVar);
                                arrayList.add(aVar2);
                                if (iVar.f38117a.size() > 1 && (i2 = i2 + 1) >= 2) {
                                    break;
                                }
                                this.f38073f.put(aVar2.f38063b, jVar);
                            }
                            this.f38073f.put(str, jVar);
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
                        jVar.f38131i = gVar;
                        gVar.a(arrayList);
                        a(jVar, jVar.f38131i.c());
                    } else {
                        com.kwai.video.ksvodplayerkit.a.b.e("HostSwitcher", "MultiRateSourceSwitcher. Init failed");
                    }
                }
            }
        }
    }

    private void a(j jVar, a aVar) {
        String str = aVar.f38063b;
        jVar.f38129g = str;
        jVar.f38124b = aVar.f38062a;
        jVar.f38125c = com.kwai.video.ksvodplayerkit.c.c.c(str);
    }

    private void a(List<String> list) {
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
            int i2 = 0;
            for (f fVar : e.a().a(b2)) {
                arrayList.add(new a(b2, str, str.replace(b2, fVar.f38080b), fVar));
                this.f38071d = true;
                if (list.size() > 1 && (i2 = i2 + 1) >= 2) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new a(b2, str, str, (f) null));
            }
            this.f38068a.a(arrayList);
        }
        if (com.kwai.video.ksvodplayerkit.i.a().j()) {
            Collections.sort(this.f38068a.f38084a);
        }
    }

    private void b(String str) {
        c.a aVar;
        com.kwai.video.ksvodplayerkit.b.c a2 = com.kwai.video.ksvodplayerkit.b.d.a(str);
        this.f38076i = a2;
        if (a2 == null || (aVar = a2.f38103c) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.f38105a.size(); i2++) {
            ArrayList<a> arrayList2 = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.f fVar = aVar.f38105a.get(i2);
            String str2 = fVar.f38106a;
            try {
                arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str2), str2, str2, (f) null));
                for (String str3 : fVar.f38107b) {
                    arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str3), str3, str3, (f) null));
                }
                for (a aVar2 : arrayList2) {
                    for (f fVar2 : e.a().a(aVar2.f38062a)) {
                        this.f38071d = true;
                        String str4 = aVar2.f38062a;
                        a aVar3 = new a(str4, aVar2.f38066e.replace(str4, fVar2.f38080b), fVar2);
                        arrayList.add(aVar3);
                        this.j.put(aVar3.f38063b, fVar);
                    }
                    this.j.put(aVar2.f38066e, fVar);
                    if (!TextUtils.isEmpty(aVar2.f38062a)) {
                        arrayList.add(new a(aVar2.f38062a, aVar2.f38066e, null));
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
            j jVar = this.f38073f.get(this.f38074g);
            if (jVar != null) {
                return jVar.f38131i;
            }
            return null;
        } else if (i2 == 2) {
            com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f38074g);
            if (fVar != null) {
                return fVar.n;
            }
            return null;
        } else {
            return this.f38068a;
        }
    }

    public void a(String str) {
        this.f38074g = str;
    }

    public void a(boolean z) {
        h hVar;
        String str;
        if (this.f38071d) {
            return;
        }
        if (this.k == 0) {
            a(this.f38069b);
        }
        if (this.k == 2 && (str = this.f38070c) != null) {
            b(str);
        } else if (this.k != 1 || (hVar = this.f38075h) == null) {
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
            j jVar = this.f38073f.get(this.f38074g);
            if (jVar == null || (gVar2 = jVar.f38131i) == null) {
                return false;
            }
            a b2 = b();
            String str3 = b2 != null ? b2.f38063b : null;
            if (!e()) {
                jVar.f38131i.a();
            }
            a(jVar, jVar.f38131i.c());
            a c2 = gVar2.c();
            if ((c2 == null || TextUtils.equals(str3, c2.f38063b)) ? false : true) {
                str2 = "URL_TYPE_MULTIRATE_MANIFEST switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
        }
        if (this.k != 2) {
            a b3 = b();
            str = b3 != null ? b3.f38063b : null;
            if (!e()) {
                this.f38068a.a();
            }
            a b4 = b();
            if ((b4 == null || TextUtils.equals(str, b4.f38063b)) ? false : true) {
                str2 = "switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
            com.kwai.video.ksvodplayerkit.a.b.d("HostSwitcher", "switchHost play url failed! url type:" + this.k);
            return false;
        }
        com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f38074g);
        if (fVar == null || (gVar = fVar.n) == null) {
            return false;
        }
        a b5 = b();
        str = b5 != null ? b5.f38063b : null;
        if (!e()) {
            fVar.n.a();
        }
        a c3 = gVar.c();
        if ((c3 == null || TextUtils.equals(str, c3.f38063b)) ? false : true) {
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
        return b2 != null ? b2.f38062a : "";
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
        return this.f38072e;
    }

    public com.kwai.video.ksvodplayerkit.b.c h() {
        return this.f38076i;
    }

    public String i() {
        String str;
        a b2;
        int i2 = this.k;
        if ((i2 == 2 || i2 == 1) && (str = this.f38074g) != null) {
            return str;
        }
        if (this.k != 0 || (b2 = b()) == null) {
            return null;
        }
        return b2.f38063b;
    }
}
