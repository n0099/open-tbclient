package com.kwad.sdk.live.a;

import android.text.TextUtils;
import com.kuaishou.live.audience.api.KSLiveRequest;
import com.kuaishou.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.utils.aa;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    private KSLiveRequest f10479b;

    public a() {
        this.f10479b = KSLiveRequestHelper.buildGetFeedListRequest();
    }

    public a(String str) {
        this.f10479b = KSLiveRequestHelper.buildGetFeedMoreRequest(str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return aa.a(this.f10479b.mUrl, this.f10479b.mUrlParam);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> b() {
        if (this.f10479b == null || this.f10479b.mHeaderParam == null || this.f10479b.mHeaderParam.size() <= 0) {
            return super.b();
        }
        for (String str : this.f10479b.mHeaderParam.keySet()) {
            if (!TextUtils.isEmpty((CharSequence) this.f10479b.mHeaderParam.get(str))) {
                a(str, (String) this.f10479b.mHeaderParam.get(str));
            }
        }
        return super.b();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        if (this.f10479b != null) {
            return this.f10479b.mBodyParam;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b
    protected void e() {
    }

    @Override // com.kwad.sdk.core.network.b
    protected void f() {
    }
}
