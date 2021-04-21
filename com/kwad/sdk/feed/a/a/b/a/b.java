package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35198b;

    /* renamed from: c  reason: collision with root package name */
    public String f35199c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, e.a> f35200d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35201e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35202f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35203g = false;

    /* renamed from: h  reason: collision with root package name */
    public e.a f35204h = new e.a() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.recycler.e.a
        public void a(AdTemplate adTemplate, float f2) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36392a).f36391h + "--visiblePercent=" + f2);
            if (f2 < 0.3f || b.this.f35203g) {
                return;
            }
            b.this.f35202f.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f35198b.mPvReported || !b.this.f35201e.e()) {
                        return;
                    }
                    com.kwad.sdk.core.report.b.a(b.this.f35198b, (JSONObject) null);
                    if (b.this.f35200d != null && b.this.f35204h != null) {
                        b.this.f35200d.remove(b.this.f35199c);
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36392a).f36391h);
                }
            }, 1000L);
            b.this.f35203g = true;
        }
    };

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        this.f35198b = adTemplate;
        String str = adTemplate.mUniqueId;
        this.f35199c = str;
        this.f35201e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35177a.f35240b;
        if (adTemplate.mPvReported) {
            return;
        }
        Map<String, e.a> map = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35177a.f35241c;
        this.f35200d = map;
        map.put(str, this.f35204h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Map<String, e.a> map = this.f35200d;
        if (map != null && this.f35204h != null) {
            map.remove(this.f35199c);
        }
        this.f35203g = false;
        this.f35202f.removeCallbacksAndMessages(null);
    }
}
