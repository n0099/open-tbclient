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
/* loaded from: classes7.dex */
public class j implements com.kwad.sdk.core.webview.kwai.a {
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public final WebView f40044b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f40045c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f40046d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40047e;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f40049b;

        /* renamed from: c  reason: collision with root package name */
        public int f40050c;

        /* renamed from: d  reason: collision with root package name */
        public int f40051d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("height");
            this.f40049b = jSONObject.optInt("leftMargin");
            this.f40050c = jSONObject.optInt("rightMargin");
            this.f40051d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "height", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "leftMargin", this.f40049b);
            com.kwad.sdk.utils.t.a(jSONObject, "rightMargin", this.f40050c);
            com.kwad.sdk.utils.t.a(jSONObject, "bottomMargin", this.f40051d);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public j(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this(aVar, bVar, true);
    }

    public j(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar, boolean z) {
        this.f40047e = true;
        this.a = new Handler(Looper.getMainLooper());
        this.f40044b = aVar.f39984e;
        this.f40046d = bVar;
        this.f40047e = z;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f40045c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f40044b != null && j.this.f40047e) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) j.this.f40044b.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.a;
                        marginLayoutParams.leftMargin = aVar2.f40049b;
                        marginLayoutParams.rightMargin = aVar2.f40050c;
                        marginLayoutParams.bottomMargin = aVar2.f40051d;
                        j.this.f40044b.setLayoutParams(marginLayoutParams);
                    }
                    if (j.this.f40046d != null) {
                        j.this.f40046d.a(aVar);
                    }
                }
            });
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f40045c != null) {
                        j.this.f40045c.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f40045c = null;
        this.f40046d = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
