package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Handler f9880a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final WebView f9881b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;
    @Nullable
    private b d;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f9885a;

        /* renamed from: b  reason: collision with root package name */
        public int f9886b;
        public int c;
        public int d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f9885a = jSONObject.optInt("height");
            this.f9886b = jSONObject.optInt("leftMargin");
            this.c = jSONObject.optInt("rightMargin");
            this.d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f9885a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f9886b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.d);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f9881b = aVar.f;
        this.d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f9880a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f9881b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    marginLayoutParams.height = aVar.f9885a;
                    marginLayoutParams.leftMargin = aVar.f9886b;
                    marginLayoutParams.rightMargin = aVar.c;
                    marginLayoutParams.bottomMargin = aVar.d;
                    i.this.f9881b.setLayoutParams(marginLayoutParams);
                    if (i.this.d != null) {
                        i.this.d.a(aVar);
                    }
                }
            });
            this.f9880a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.c != null) {
                        i.this.c.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
            cVar.a(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.c = null;
        this.d = null;
        this.f9880a.removeCallbacksAndMessages(null);
    }
}
