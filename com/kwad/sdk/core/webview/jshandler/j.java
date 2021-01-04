package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9886a;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        private int f9887a;

        /* renamed from: b  reason: collision with root package name */
        private String f9888b;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f9887a = jSONObject.optInt("actionType");
            this.f9888b = jSONObject.optString("payload");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "actionType", this.f9887a);
            com.kwad.sdk.utils.o.a(jSONObject, "payload", this.f9888b);
            return jSONObject;
        }
    }

    public j(com.kwad.sdk.core.webview.a aVar) {
        this.f9886a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        if (aVar.f9887a == 1) {
            com.kwad.sdk.core.d.a.b("WebCardLogHandler", "handleH5Log actionType is AD_ITEM_IMPRESSION");
        } else if (aVar.f9887a != 2) {
            com.kwad.sdk.core.report.b.a(this.f9886a.f9836b, aVar.f9887a, this.f9886a.d, aVar.f9888b);
        } else {
            AdBaseFrameLayout adBaseFrameLayout = this.f9886a.c;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.b.a(this.f9886a.f9836b, this.f9886a.d, adBaseFrameLayout.getTouchCoords(), aVar.f9888b);
            } else {
                com.kwad.sdk.core.report.b.a(this.f9886a.f9836b, this.f9886a.d, aVar.f9888b);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return TbConfig.TMP_LOG_DIR_NAME;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f9886a.f9836b == null) {
            cVar.a(-1, "native adTemplate is null");
        }
        try {
            a aVar = new a();
            aVar.a(new JSONObject(str));
            a(aVar);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
            cVar.a(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
