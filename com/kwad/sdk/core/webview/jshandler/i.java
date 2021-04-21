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
    public Handler f34739a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f34740b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34741c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34742d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34746a;

        /* renamed from: b  reason: collision with root package name */
        public int f34747b;

        /* renamed from: c  reason: collision with root package name */
        public int f34748c;

        /* renamed from: d  reason: collision with root package name */
        public int f34749d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f34746a = jSONObject.optInt("height");
            this.f34747b = jSONObject.optInt("leftMargin");
            this.f34748c = jSONObject.optInt("rightMargin");
            this.f34749d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f34746a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f34747b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f34748c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f34749d);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f34740b = aVar.f34674f;
        this.f34742d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34741c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f34739a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f34740b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f34746a;
                    marginLayoutParams.leftMargin = aVar2.f34747b;
                    marginLayoutParams.rightMargin = aVar2.f34748c;
                    marginLayoutParams.bottomMargin = aVar2.f34749d;
                    i.this.f34740b.setLayoutParams(marginLayoutParams);
                    if (i.this.f34742d != null) {
                        i.this.f34742d.a(aVar);
                    }
                }
            });
            this.f34739a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f34741c != null) {
                        i.this.f34741c.a(null);
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
        this.f34741c = null;
        this.f34742d = null;
        this.f34739a.removeCallbacksAndMessages(null);
    }
}
