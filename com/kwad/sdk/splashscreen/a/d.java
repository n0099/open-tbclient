package com.kwad.sdk.splashscreen.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends Presenter {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57987b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f57988c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f57989d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            d.this.a(j3);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            d.this.f();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f57988c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f57988c.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.f57987b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.a.i(this.f57987b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.a.j(this.f57987b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.a = gVar;
        AdTemplate adTemplate = gVar.f58087d;
        this.f57987b = adTemplate;
        this.f57988c = com.kwad.sdk.core.response.a.a.S(com.kwad.sdk.core.response.a.d.j(adTemplate));
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f58089f;
        if (aVar != null) {
            aVar.a(this.f57989d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f58089f;
        if (aVar != null) {
            aVar.b(this.f57989d);
        }
    }
}
