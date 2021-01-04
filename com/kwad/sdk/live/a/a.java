package com.kwad.sdk.live.a;

import android.text.TextUtils;
import com.kuaishou.live.audience.api.KSLiveRequest;
import com.kuaishou.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.utils.aa;
import java.util.Map;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    private KSLiveRequest f10776b;

    public a() {
        this.f10776b = KSLiveRequestHelper.buildGetFeedListRequest();
    }

    public a(String str) {
        this.f10776b = KSLiveRequestHelper.buildGetFeedMoreRequest(str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return aa.a(this.f10776b.mUrl, this.f10776b.mUrlParam);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> b() {
        if (this.f10776b == null || this.f10776b.mHeaderParam == null || this.f10776b.mHeaderParam.size() <= 0) {
            return super.b();
        }
        for (String str : this.f10776b.mHeaderParam.keySet()) {
            if (!TextUtils.isEmpty((CharSequence) this.f10776b.mHeaderParam.get(str))) {
                a(str, (String) this.f10776b.mHeaderParam.get(str));
            }
        }
        return super.b();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        if (this.f10776b != null) {
            return this.f10776b.mBodyParam;
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
