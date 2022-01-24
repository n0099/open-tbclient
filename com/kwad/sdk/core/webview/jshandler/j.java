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
/* loaded from: classes3.dex */
public class j implements com.kwad.sdk.core.webview.kwai.a {
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public final WebView f56441b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f56442c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f56443d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56444e;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f56446b;

        /* renamed from: c  reason: collision with root package name */
        public int f56447c;

        /* renamed from: d  reason: collision with root package name */
        public int f56448d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("height");
            this.f56446b = jSONObject.optInt("leftMargin");
            this.f56447c = jSONObject.optInt("rightMargin");
            this.f56448d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "height", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "leftMargin", this.f56446b);
            com.kwad.sdk.utils.t.a(jSONObject, "rightMargin", this.f56447c);
            com.kwad.sdk.utils.t.a(jSONObject, "bottomMargin", this.f56448d);
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public j(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this(aVar, bVar, true);
    }

    public j(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar, boolean z) {
        this.f56444e = true;
        this.a = new Handler(Looper.getMainLooper());
        this.f56441b = aVar.f56375e;
        this.f56443d = bVar;
        this.f56444e = z;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f56442c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f56441b != null && j.this.f56444e) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) j.this.f56441b.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.a;
                        marginLayoutParams.leftMargin = aVar2.f56446b;
                        marginLayoutParams.rightMargin = aVar2.f56447c;
                        marginLayoutParams.bottomMargin = aVar2.f56448d;
                        j.this.f56441b.setLayoutParams(marginLayoutParams);
                    }
                    if (j.this.f56443d != null) {
                        j.this.f56443d.a(aVar);
                    }
                }
            });
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f56442c != null) {
                        j.this.f56442c.a(null);
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
        this.f56442c = null;
        this.f56443d = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
