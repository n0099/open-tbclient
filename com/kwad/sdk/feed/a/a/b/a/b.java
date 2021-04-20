package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35103b;

    /* renamed from: c  reason: collision with root package name */
    public String f35104c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, e.a> f35105d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35106e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35107f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35108g = false;

    /* renamed from: h  reason: collision with root package name */
    public e.a f35109h = new e.a() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.recycler.e.a
        public void a(AdTemplate adTemplate, float f2) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36297a).f36296h + "--visiblePercent=" + f2);
            if (f2 < 0.3f || b.this.f35108g) {
                return;
            }
            b.this.f35107f.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f35103b.mPvReported || !b.this.f35106e.e()) {
                        return;
                    }
                    com.kwad.sdk.core.report.b.a(b.this.f35103b, (JSONObject) null);
                    if (b.this.f35105d != null && b.this.f35109h != null) {
                        b.this.f35105d.remove(b.this.f35104c);
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36297a).f36296h);
                }
            }, 1000L);
            b.this.f35108g = true;
        }
    };

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        this.f35103b = adTemplate;
        String str = adTemplate.mUniqueId;
        this.f35104c = str;
        this.f35106e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35082a.f35145b;
        if (adTemplate.mPvReported) {
            return;
        }
        Map<String, e.a> map = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35082a.f35146c;
        this.f35105d = map;
        map.put(str, this.f35109h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Map<String, e.a> map = this.f35105d;
        if (map != null && this.f35109h != null) {
            map.remove(this.f35104c);
        }
        this.f35108g = false;
        this.f35107f.removeCallbacksAndMessages(null);
    }
}
