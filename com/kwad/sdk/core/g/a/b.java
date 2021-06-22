package com.kwad.sdk.core.g.a;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34356a;

    /* renamed from: b  reason: collision with root package name */
    public String f34357b;

    /* renamed from: c  reason: collision with root package name */
    public String f34358c;

    /* renamed from: d  reason: collision with root package name */
    public String f34359d;

    public static b a() {
        b bVar = new b();
        bVar.f34356a = KsAdSDKImpl.get().getAppId();
        bVar.f34357b = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f34358c = context.getPackageName();
            bVar.f34359d = ah.l(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f34356a);
        o.a(jSONObject, "name", this.f34357b);
        o.a(jSONObject, "packageName", this.f34358c);
        o.a(jSONObject, "version", this.f34359d);
        return jSONObject;
    }
}
