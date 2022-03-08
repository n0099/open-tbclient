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
/* loaded from: classes8.dex */
public class j implements com.kwad.sdk.core.webview.kwai.a {
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public final WebView f54958b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f54959c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f54960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54961e;

    /* loaded from: classes8.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f54963b;

        /* renamed from: c  reason: collision with root package name */
        public int f54964c;

        /* renamed from: d  reason: collision with root package name */
        public int f54965d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("height");
            this.f54963b = jSONObject.optInt("leftMargin");
            this.f54964c = jSONObject.optInt("rightMargin");
            this.f54965d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "height", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "leftMargin", this.f54963b);
            com.kwad.sdk.utils.t.a(jSONObject, "rightMargin", this.f54964c);
            com.kwad.sdk.utils.t.a(jSONObject, "bottomMargin", this.f54965d);
            return jSONObject;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public j(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this(aVar, bVar, true);
    }

    public j(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar, boolean z) {
        this.f54961e = true;
        this.a = new Handler(Looper.getMainLooper());
        this.f54958b = aVar.f54892e;
        this.f54960d = bVar;
        this.f54961e = z;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f54959c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f54958b != null && j.this.f54961e) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) j.this.f54958b.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.a;
                        marginLayoutParams.leftMargin = aVar2.f54963b;
                        marginLayoutParams.rightMargin = aVar2.f54964c;
                        marginLayoutParams.bottomMargin = aVar2.f54965d;
                        j.this.f54958b.setLayoutParams(marginLayoutParams);
                    }
                    if (j.this.f54960d != null) {
                        j.this.f54960d.a(aVar);
                    }
                }
            });
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f54959c != null) {
                        j.this.f54959c.a(null);
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
        this.f54959c = null;
        this.f54960d = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
