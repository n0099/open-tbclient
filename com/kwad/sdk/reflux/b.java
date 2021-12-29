package com.kwad.sdk.reflux;

import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public int f59428b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59429c;

    /* renamed from: d  reason: collision with root package name */
    public int f59430d;

    /* renamed from: e  reason: collision with root package name */
    public String f59431e;

    /* renamed from: f  reason: collision with root package name */
    public String f59432f;

    /* renamed from: g  reason: collision with root package name */
    public String f59433g;

    /* renamed from: h  reason: collision with root package name */
    public String f59434h;

    /* renamed from: i  reason: collision with root package name */
    public String f59435i;

    /* renamed from: j  reason: collision with root package name */
    public String f59436j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59437k = false;
    public int l = -1;
    public com.kwad.sdk.core.download.a.b m;
    public int n;
    public int o;
    public a p;

    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public static b a(AdTemplate adTemplate) {
        String h2;
        AdInfo j2 = d.j(adTemplate);
        b bVar = new b();
        bVar.b(0);
        bVar.f59437k = com.kwad.sdk.core.response.a.a.B(j2);
        bVar.f59430d = adTemplate.type;
        bVar.f59429c = adTemplate;
        bVar.f59431e = com.kwad.sdk.core.response.a.a.s(j2);
        List<String> O = com.kwad.sdk.core.response.a.a.O(j2);
        if (O.size() <= 0) {
            if (com.kwad.sdk.core.response.a.a.P(j2)) {
                h2 = com.kwad.sdk.core.response.a.a.h(j2);
            }
            bVar.f59436j = com.kwad.sdk.core.response.a.a.A(j2);
            bVar.f59435i = com.kwad.sdk.core.response.a.a.s(j2);
            bVar.f59434h = com.kwad.sdk.core.response.a.a.at(j2);
            bVar.f59432f = com.kwad.sdk.core.response.a.a.au(j2);
            return bVar;
        }
        h2 = O.get(0);
        bVar.f59433g = h2;
        bVar.f59436j = com.kwad.sdk.core.response.a.a.A(j2);
        bVar.f59435i = com.kwad.sdk.core.response.a.a.s(j2);
        bVar.f59434h = com.kwad.sdk.core.response.a.a.at(j2);
        bVar.f59432f = com.kwad.sdk.core.response.a.a.au(j2);
        return bVar;
    }

    public static List<b> a(List<AdTemplate> list, List<com.kwad.sdk.core.download.a.b> list2) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0 && list2.size() != 0) {
            if (list.size() != list2.size()) {
                return null;
            }
            arrayList = new ArrayList();
            int i2 = 0;
            for (AdTemplate adTemplate : list) {
                b a2 = a(adTemplate);
                a2.a(list2.get(i2));
                a2.l = i2;
                arrayList.add(a2);
                i2++;
            }
        }
        return arrayList;
    }

    private void o() {
        a aVar = this.p;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(com.kwad.sdk.core.download.a.b bVar) {
        this.m = bVar;
    }

    public void a(a aVar) {
        this.p = aVar;
    }

    public void b() {
        com.kwad.sdk.core.download.a.b bVar;
        if (!i() || (bVar = this.m) == null) {
            return;
        }
        bVar.a(this);
    }

    public void b(int i2) {
        this.f59428b = i2;
    }

    public AdTemplate c() {
        return this.f59429c;
    }

    public String d() {
        return this.f59431e;
    }

    public String e() {
        return this.f59432f;
    }

    public String f() {
        return this.f59434h;
    }

    public String g() {
        return this.f59435i;
    }

    public String h() {
        return this.f59433g;
    }

    public boolean i() {
        return this.f59437k;
    }

    public int j() {
        return this.l;
    }

    public int k() {
        int i2 = this.f59428b;
        return i2 == 0 ? this.f59430d : i2;
    }

    public int l() {
        return this.n;
    }

    public int m() {
        return this.o;
    }

    public com.kwad.sdk.core.download.a.b n() {
        return this.m;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        this.n = 11;
        o();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        this.n = 8;
        o();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        this.n = 0;
        this.o = 0;
        o();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        this.n = 12;
        o();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i2) {
        this.n = 2;
        this.o = i2;
        o();
    }
}
