package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private AdTemplate f10117b;
    private String c;
    private Map<String, e.a> d;
    private com.kwad.sdk.core.i.a e;
    private Handler f = new Handler();
    private boolean g = false;
    private e.a h = new e.a() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.recycler.e.a
        public void a(AdTemplate adTemplate, float f) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) b.this.f10751a).h + "--visiblePercent=" + f);
            if (f < 0.3f || b.this.g) {
                return;
            }
            b.this.f.postDelayed(new Runnable() { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f10117b.mPvReported || !b.this.e.e()) {
                        return;
                    }
                    com.kwad.sdk.core.report.b.a(b.this.f10117b, (JSONObject) null);
                    if (b.this.d != null && b.this.h != null) {
                        b.this.d.remove(b.this.c);
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) b.this.f10751a).h);
                }
            }, 1000L);
            b.this.g = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10117b = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10751a).i;
        this.c = this.f10117b.mUniqueId;
        this.e = ((com.kwad.sdk.feed.a.a.a.b) this.f10751a).f10108a.f10135b;
        if (this.f10117b.mPvReported) {
            return;
        }
        this.d = ((com.kwad.sdk.feed.a.a.a.b) this.f10751a).f10108a.c;
        this.d.put(this.c, this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.d != null && this.h != null) {
            this.d.remove(this.c);
        }
        this.g = false;
        this.f.removeCallbacksAndMessages(null);
    }
}
