package com.kwad.sdk.live.a;

import android.text.TextUtils;
import com.kuaishou.live.audience.api.KSLiveRequest;
import com.kuaishou.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.utils.aa;
import java.util.Map;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    public KSLiveRequest f36775b;

    public a() {
        this.f36775b = KSLiveRequestHelper.buildGetFeedListRequest();
    }

    public a(String str) {
        this.f36775b = KSLiveRequestHelper.buildGetFeedMoreRequest(str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return aa.a(this.f36775b.mUrl, this.f36775b.mUrlParam);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> b() {
        KSLiveRequest kSLiveRequest = this.f36775b;
        if (kSLiveRequest == null || kSLiveRequest.mHeaderParam == null || this.f36775b.mHeaderParam.size() <= 0) {
            return super.b();
        }
        for (String str : this.f36775b.mHeaderParam.keySet()) {
            if (!TextUtils.isEmpty((CharSequence) this.f36775b.mHeaderParam.get(str))) {
                a(str, (String) this.f36775b.mHeaderParam.get(str));
            }
        }
        return super.b();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        KSLiveRequest kSLiveRequest = this.f36775b;
        if (kSLiveRequest != null) {
            return kSLiveRequest.mBodyParam;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b
    public void e() {
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
    }
}
