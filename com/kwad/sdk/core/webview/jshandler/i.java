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
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f32945a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f32946b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f32947c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f32948d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f32952a;

        /* renamed from: b  reason: collision with root package name */
        public int f32953b;

        /* renamed from: c  reason: collision with root package name */
        public int f32954c;

        /* renamed from: d  reason: collision with root package name */
        public int f32955d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32952a = jSONObject.optInt("height");
            this.f32953b = jSONObject.optInt("leftMargin");
            this.f32954c = jSONObject.optInt("rightMargin");
            this.f32955d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f32952a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f32953b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f32954c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f32955d);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f32946b = aVar.f32871f;
        this.f32948d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f32947c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f32945a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f32946b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f32952a;
                    marginLayoutParams.leftMargin = aVar2.f32953b;
                    marginLayoutParams.rightMargin = aVar2.f32954c;
                    marginLayoutParams.bottomMargin = aVar2.f32955d;
                    i.this.f32946b.setLayoutParams(marginLayoutParams);
                    if (i.this.f32948d != null) {
                        i.this.f32948d.a(aVar);
                    }
                }
            });
            this.f32945a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f32947c != null) {
                        i.this.f32947c.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f32947c = null;
        this.f32948d = null;
        this.f32945a.removeCallbacksAndMessages(null);
    }
}
