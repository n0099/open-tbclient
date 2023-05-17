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
/* loaded from: classes9.dex */
public final class r implements com.kwad.sdk.core.webview.kwai.a {
    public final WebView Fv;
    public Handler Ll;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c Lu;
    public boolean Mi;
    @Nullable
    public b bK;

    /* loaded from: classes9.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

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

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.r.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.r.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.r.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public r(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    public r(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z) {
        this.Mi = true;
        this.Ll = new Handler(Looper.getMainLooper());
        this.Fv = bVar.Fv;
        this.bK = bVar2;
        this.Mi = true;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lu = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.r.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (r.this.Fv != null && r.this.Mi) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) r.this.Fv.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        r.this.Fv.setLayoutParams(marginLayoutParams);
                    }
                    if (r.this.bK != null) {
                        r.this.bK.a(aVar);
                    }
                }
            });
            this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.r.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (r.this.Lu != null) {
                        r.this.Lu.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Lu = null;
        this.bK = null;
        this.Ll.removeCallbacksAndMessages(null);
    }
}
