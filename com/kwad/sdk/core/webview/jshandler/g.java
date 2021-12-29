package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.af;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "screenOrientation", this.a);
            return jSONObject;
        }
    }

    public g(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.a.c()) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        aVar.a = !af.e(KsAdSDKImpl.get().getContext()) ? 1 : 0;
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
