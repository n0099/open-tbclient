package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35573b;

    /* renamed from: c  reason: collision with root package name */
    public String f35574c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, e.a> f35575d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35576e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35577f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35578g = false;

    /* renamed from: h  reason: collision with root package name */
    public e.a f35579h = new e.a() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.recycler.e.a
        public void a(AdTemplate adTemplate, float f2) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36811a).f36809h + "--visiblePercent=" + f2);
            if (f2 < 0.3f || b.this.f35578g) {
                return;
            }
            b.this.f35577f.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f35573b.mPvReported || !b.this.f35576e.e()) {
                        return;
                    }
                    com.kwad.sdk.core.report.b.a(b.this.f35573b, (JSONObject) null);
                    if (b.this.f35575d != null && b.this.f35579h != null) {
                        b.this.f35575d.remove(b.this.f35574c);
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36811a).f36809h);
                }
            }, 1000L);
            b.this.f35578g = true;
        }
    };

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36810i;
        this.f35573b = adTemplate;
        String str = adTemplate.mUniqueId;
        this.f35574c = str;
        this.f35576e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35551a.f35616b;
        if (adTemplate.mPvReported) {
            return;
        }
        Map<String, e.a> map = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35551a.f35617c;
        this.f35575d = map;
        map.put(str, this.f35579h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Map<String, e.a> map = this.f35575d;
        if (map != null && this.f35579h != null) {
            map.remove(this.f35574c);
        }
        this.f35578g = false;
        this.f35577f.removeCallbacksAndMessages(null);
    }
}
