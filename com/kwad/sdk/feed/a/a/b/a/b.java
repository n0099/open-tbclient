package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34814b;

    /* renamed from: c  reason: collision with root package name */
    public String f34815c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, e.a> f34816d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34817e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f34818f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public boolean f34819g = false;

    /* renamed from: h  reason: collision with root package name */
    public e.a f34820h = new e.a() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.recycler.e.a
        public void a(AdTemplate adTemplate, float f2) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36008a).f36007h + "--visiblePercent=" + f2);
            if (f2 < 0.3f || b.this.f34819g) {
                return;
            }
            b.this.f34818f.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f34814b.mPvReported || !b.this.f34817e.e()) {
                        return;
                    }
                    com.kwad.sdk.core.report.b.a(b.this.f34814b, (JSONObject) null);
                    if (b.this.f34816d != null && b.this.f34820h != null) {
                        b.this.f34816d.remove(b.this.f34815c);
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) b.this).f36008a).f36007h);
                }
            }, 1000L);
            b.this.f34819g = true;
        }
    };

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        this.f34814b = adTemplate;
        String str = adTemplate.mUniqueId;
        this.f34815c = str;
        this.f34817e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f34793a.f34856b;
        if (adTemplate.mPvReported) {
            return;
        }
        Map<String, e.a> map = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f34793a.f34857c;
        this.f34816d = map;
        map.put(str, this.f34820h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Map<String, e.a> map = this.f34816d;
        if (map != null && this.f34820h != null) {
            map.remove(this.f34815c);
        }
        this.f34819g = false;
        this.f34818f.removeCallbacksAndMessages(null);
    }
}
