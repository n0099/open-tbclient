package com.kwad.sdk.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9567a;

    /* loaded from: classes4.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        private List<AdTemplate> f9568a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.f9568a) {
                if (TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    jSONArray.put(adTemplate.toJson());
                } else {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.a.a(e);
                        jSONArray.put(adTemplate.toJson());
                    }
                }
            }
            com.kwad.sdk.utils.o.a(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public e(com.kwad.sdk.core.webview.a aVar) {
        this.f9567a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f9567a.f9537b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        aVar.f9568a = Collections.singletonList(this.f9567a.f9537b);
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
