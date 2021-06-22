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
public class i implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f35098a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f35099b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35100c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f35101d;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f35105a;

        /* renamed from: b  reason: collision with root package name */
        public int f35106b;

        /* renamed from: c  reason: collision with root package name */
        public int f35107c;

        /* renamed from: d  reason: collision with root package name */
        public int f35108d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f35105a = jSONObject.optInt("height");
            this.f35106b = jSONObject.optInt("leftMargin");
            this.f35107c = jSONObject.optInt("rightMargin");
            this.f35108d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f35105a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f35106b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f35107c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f35108d);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f35099b = aVar.f35031f;
        this.f35101d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f35100c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f35098a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f35099b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f35105a;
                    marginLayoutParams.leftMargin = aVar2.f35106b;
                    marginLayoutParams.rightMargin = aVar2.f35107c;
                    marginLayoutParams.bottomMargin = aVar2.f35108d;
                    i.this.f35099b.setLayoutParams(marginLayoutParams);
                    if (i.this.f35101d != null) {
                        i.this.f35101d.a(aVar);
                    }
                }
            });
            this.f35098a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f35100c != null) {
                        i.this.f35100c.a(null);
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
        this.f35100c = null;
        this.f35101d = null;
        this.f35098a.removeCallbacksAndMessages(null);
    }
}
