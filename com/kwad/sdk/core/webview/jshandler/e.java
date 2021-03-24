package com.kwad.sdk.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34332a;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public List<AdTemplate> f34333a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.f34333a) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                jSONArray.put(adTemplate.toJson());
            }
            com.kwad.sdk.utils.o.a(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public e(com.kwad.sdk.core.webview.a aVar) {
        this.f34332a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f34332a.f34285b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        aVar.f34333a = Collections.singletonList(this.f34332a.f34285b);
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
