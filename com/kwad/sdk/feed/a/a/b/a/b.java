package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35475b;

    /* renamed from: c  reason: collision with root package name */
    public String f35476c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, e.a> f35477d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35478e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35479f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35480g = false;

    /* renamed from: h  reason: collision with root package name */
    public e.a f35481h = new e.a() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.recycler.e.a
        public void a(AdTemplate adTemplate, float f2) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36713a).f36711h + "--visiblePercent=" + f2);
            if (f2 < 0.3f || b.this.f35480g) {
                return;
            }
            b.this.f35479f.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f35475b.mPvReported || !b.this.f35478e.e()) {
                        return;
                    }
                    com.kwad.sdk.core.report.b.a(b.this.f35475b, (JSONObject) null);
                    if (b.this.f35477d != null && b.this.f35481h != null) {
                        b.this.f35477d.remove(b.this.f35476c);
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36713a).f36711h);
                }
            }, 1000L);
            b.this.f35480g = true;
        }
    };

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36712i;
        this.f35475b = adTemplate;
        String str = adTemplate.mUniqueId;
        this.f35476c = str;
        this.f35478e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35453a.f35518b;
        if (adTemplate.mPvReported) {
            return;
        }
        Map<String, e.a> map = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35453a.f35519c;
        this.f35477d = map;
        map.put(str, this.f35481h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Map<String, e.a> map = this.f35477d;
        if (map != null && this.f35481h != null) {
            map.remove(this.f35476c);
        }
        this.f35480g = false;
        this.f35479f.removeCallbacksAndMessages(null);
    }
}
