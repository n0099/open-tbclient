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
    public final WebView f58607b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f58608c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f58609d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58610e;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58612b;

        /* renamed from: c  reason: collision with root package name */
        public int f58613c;

        /* renamed from: d  reason: collision with root package name */
        public int f58614d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("height");
            this.f58612b = jSONObject.optInt("leftMargin");
            this.f58613c = jSONObject.optInt("rightMargin");
            this.f58614d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "height", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "leftMargin", this.f58612b);
            com.kwad.sdk.utils.t.a(jSONObject, "rightMargin", this.f58613c);
            com.kwad.sdk.utils.t.a(jSONObject, "bottomMargin", this.f58614d);
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
        this.f58610e = true;
        this.a = new Handler(Looper.getMainLooper());
        this.f58607b = aVar.f58539e;
        this.f58609d = bVar;
        this.f58610e = z;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f58608c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f58607b != null && j.this.f58610e) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) j.this.f58607b.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.a;
                        marginLayoutParams.leftMargin = aVar2.f58612b;
                        marginLayoutParams.rightMargin = aVar2.f58613c;
                        marginLayoutParams.bottomMargin = aVar2.f58614d;
                        j.this.f58607b.setLayoutParams(marginLayoutParams);
                    }
                    if (j.this.f58609d != null) {
                        j.this.f58609d.a(aVar);
                    }
                }
            });
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f58608c != null) {
                        j.this.f58608c.a(null);
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
        this.f58608c = null;
        this.f58609d = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
