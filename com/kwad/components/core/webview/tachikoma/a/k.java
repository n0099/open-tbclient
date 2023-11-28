package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class k extends w {
    public b Zw = new b() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1
        @Override // com.kwad.components.core.webview.tachikoma.a.k.b
        public final void H(final long j) {
            if (k.this.nr != null) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j;
                        k.this.nr.a(aVar);
                    }
                });
            }
        }
    };
    public com.kwad.sdk.core.webview.c.c nr;

    /* loaded from: classes10.dex */
    public interface b {
        void H(long j);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        public a() {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.Zw);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nr = cVar;
        com.kwad.components.core.e.d.a.a(this.Zw);
    }
}
