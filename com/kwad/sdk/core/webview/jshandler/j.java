package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9587a;

    /* loaded from: classes4.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        private int f9588a;

        /* renamed from: b  reason: collision with root package name */
        private String f9589b;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f9588a = jSONObject.optInt("actionType");
            this.f9589b = jSONObject.optString("payload");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "actionType", this.f9588a);
            com.kwad.sdk.utils.o.a(jSONObject, "payload", this.f9589b);
            return jSONObject;
        }
    }

    public j(com.kwad.sdk.core.webview.a aVar) {
        this.f9587a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        if (aVar.f9588a == 1) {
            com.kwad.sdk.core.d.a.b("WebCardLogHandler", "handleH5Log actionType is AD_ITEM_IMPRESSION");
        } else if (aVar.f9588a != 2) {
            com.kwad.sdk.core.report.b.a(this.f9587a.f9537b, aVar.f9588a, this.f9587a.d, aVar.f9589b);
        } else {
            AdBaseFrameLayout adBaseFrameLayout = this.f9587a.c;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.b.a(this.f9587a.f9537b, this.f9587a.d, adBaseFrameLayout.getTouchCoords(), aVar.f9589b);
            } else {
                com.kwad.sdk.core.report.b.a(this.f9587a.f9537b, this.f9587a.d, aVar.f9589b);
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
        if (this.f9587a.f9537b == null) {
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
