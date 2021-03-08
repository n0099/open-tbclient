package com.kwad.sdk.live.a;

import android.text.TextUtils;
import com.kuaishou.live.audience.api.KSLiveRequest;
import com.kuaishou.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.utils.aa;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.b {
    private KSLiveRequest b;

    public a() {
        this.b = KSLiveRequestHelper.buildGetFeedListRequest();
    }

    public a(String str) {
        this.b = KSLiveRequestHelper.buildGetFeedMoreRequest(str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return aa.a(this.b.mUrl, this.b.mUrlParam);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> b() {
        if (this.b == null || this.b.mHeaderParam == null || this.b.mHeaderParam.size() <= 0) {
            return super.b();
        }
        for (String str : this.b.mHeaderParam.keySet()) {
            if (!TextUtils.isEmpty((CharSequence) this.b.mHeaderParam.get(str))) {
                a(str, (String) this.b.mHeaderParam.get(str));
            }
        }
        return super.b();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        if (this.b != null) {
            return this.b.mBodyParam;
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
