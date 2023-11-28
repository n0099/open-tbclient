package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    public final WebView NP;
    public boolean WY;
    public Handler Wk;
    @Nullable
    public com.kwad.sdk.core.webview.c.c Wl;
    @Nullable
    public b cS;

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }
    }

    public aj(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Wl = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aj.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (aj.this.NP != null && aj.this.WY) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) aj.this.NP.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        aj.this.NP.setLayoutParams(marginLayoutParams);
                    }
                    if (aj.this.cS != null) {
                        aj.this.cS.a(aVar);
                    }
                }
            });
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aj.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (aj.this.Wl != null) {
                        aj.this.Wl.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    public aj(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z) {
        this.WY = true;
        this.Wk = new Handler(Looper.getMainLooper());
        this.NP = bVar.NP;
        this.cS = bVar2;
        this.WY = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Wl = null;
        this.cS = null;
        this.Wk.removeCallbacksAndMessages(null);
    }
}
