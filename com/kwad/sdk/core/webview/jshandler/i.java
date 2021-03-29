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
    public Handler f34355a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f34356b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34357c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34358d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34362a;

        /* renamed from: b  reason: collision with root package name */
        public int f34363b;

        /* renamed from: c  reason: collision with root package name */
        public int f34364c;

        /* renamed from: d  reason: collision with root package name */
        public int f34365d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f34362a = jSONObject.optInt("height");
            this.f34363b = jSONObject.optInt("leftMargin");
            this.f34364c = jSONObject.optInt("rightMargin");
            this.f34365d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f34362a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f34363b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f34364c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f34365d);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f34356b = aVar.f34290f;
        this.f34358d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34357c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f34355a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f34356b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f34362a;
                    marginLayoutParams.leftMargin = aVar2.f34363b;
                    marginLayoutParams.rightMargin = aVar2.f34364c;
                    marginLayoutParams.bottomMargin = aVar2.f34365d;
                    i.this.f34356b.setLayoutParams(marginLayoutParams);
                    if (i.this.f34358d != null) {
                        i.this.f34358d.a(aVar);
                    }
                }
            });
            this.f34355a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f34357c != null) {
                        i.this.f34357c.a(null);
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
        this.f34357c = null;
        this.f34358d = null;
        this.f34355a.removeCallbacksAndMessages(null);
    }
}
