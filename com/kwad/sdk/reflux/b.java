package com.kwad.sdk.reflux;

import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public int f40727b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f40728c;

    /* renamed from: d  reason: collision with root package name */
    public int f40729d;

    /* renamed from: e  reason: collision with root package name */
    public String f40730e;

    /* renamed from: f  reason: collision with root package name */
    public String f40731f;

    /* renamed from: g  reason: collision with root package name */
    public String f40732g;

    /* renamed from: h  reason: collision with root package name */
    public String f40733h;
    public String i;
    public String j;
    public boolean k = false;
    public int l = -1;
    public com.kwad.sdk.core.download.a.b m;
    public int n;
    public int o;
    public a p;

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    public static b a(AdTemplate adTemplate) {
        String h2;
        AdInfo j = d.j(adTemplate);
        b bVar = new b();
        bVar.b(0);
        bVar.k = com.kwad.sdk.core.response.a.a.B(j);
        bVar.f40729d = adTemplate.type;
        bVar.f40728c = adTemplate;
        bVar.f40730e = com.kwad.sdk.core.response.a.a.s(j);
        List<String> O = com.kwad.sdk.core.response.a.a.O(j);
        if (O.size() <= 0) {
            if (com.kwad.sdk.core.response.a.a.P(j)) {
                h2 = com.kwad.sdk.core.response.a.a.h(j);
            }
            bVar.j = com.kwad.sdk.core.response.a.a.A(j);
            bVar.i = com.kwad.sdk.core.response.a.a.s(j);
            bVar.f40733h = com.kwad.sdk.core.response.a.a.at(j);
            bVar.f40731f = com.kwad.sdk.core.response.a.a.au(j);
            return bVar;
        }
        h2 = O.get(0);
        bVar.f40732g = h2;
        bVar.j = com.kwad.sdk.core.response.a.a.A(j);
        bVar.i = com.kwad.sdk.core.response.a.a.s(j);
        bVar.f40733h = com.kwad.sdk.core.response.a.a.at(j);
        bVar.f40731f = com.kwad.sdk.core.response.a.a.au(j);
        return bVar;
    }

    public static List<b> a(List<AdTemplate> list, List<com.kwad.sdk.core.download.a.b> list2) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0 && list2.size() != 0) {
            if (list.size() != list2.size()) {
                return null;
            }
            arrayList = new ArrayList();
            int i = 0;
            for (AdTemplate adTemplate : list) {
                b a2 = a(adTemplate);
                a2.a(list2.get(i));
                a2.l = i;
                arrayList.add(a2);
                i++;
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

    public void b(int i) {
        this.f40727b = i;
    }

    public AdTemplate c() {
        return this.f40728c;
    }

    public String d() {
        return this.f40730e;
    }

    public String e() {
        return this.f40731f;
    }

    public String f() {
        return this.f40733h;
    }

    public String g() {
        return this.i;
    }

    public String h() {
        return this.f40732g;
    }

    public boolean i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }

    public int k() {
        int i = this.f40727b;
        return i == 0 ? this.f40729d : i;
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
    public void onProgressUpdate(int i) {
        this.n = 2;
        this.o = i;
        o();
    }
}
