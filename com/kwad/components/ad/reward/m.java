package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class m extends com.kwad.components.ad.i.b {
    @Nullable
    public com.kwad.components.ad.reward.b.d nr;
    public WeakReference<k> ns;

    public m(k kVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.ns = new WeakReference<>(kVar);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.b.d dVar) {
        this.nr = dVar;
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.f.b(this.bF.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.m.1
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar) {
                if (m.this.nr != null) {
                    m.this.nr.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.ad.reward.m.2
            @Override // com.kwad.components.core.webview.jshandler.b
            public final void a(com.kwad.components.core.webview.jshandler.a aVar2, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    aVar2.a(com.kwad.components.ad.reward.b.a.gp().gq());
                }
            }
        }));
        WeakReference<k> weakReference = this.ns;
        aVar.b(new com.kwad.components.ad.reward.h.k(weakReference != null ? weakReference.get() : null, -1L, this.mJsBridgeContext));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fk() {
        WeakReference<k> weakReference = this.ns;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.i.b
    public final void fl() {
        WeakReference<k> weakReference = this.ns;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card", l(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fm() {
        WeakReference<k> weakReference = this.ns;
        com.kwad.components.ad.reward.monitor.a.b((weakReference != null ? weakReference.get() : null) != null, "end_card", l(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }
}
