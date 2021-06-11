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
    public Handler f35000a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f35001b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35002c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f35003d;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f35007a;

        /* renamed from: b  reason: collision with root package name */
        public int f35008b;

        /* renamed from: c  reason: collision with root package name */
        public int f35009c;

        /* renamed from: d  reason: collision with root package name */
        public int f35010d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f35007a = jSONObject.optInt("height");
            this.f35008b = jSONObject.optInt("leftMargin");
            this.f35009c = jSONObject.optInt("rightMargin");
            this.f35010d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f35007a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f35008b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f35009c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f35010d);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f35001b = aVar.f34933f;
        this.f35003d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f35002c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f35000a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f35001b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f35007a;
                    marginLayoutParams.leftMargin = aVar2.f35008b;
                    marginLayoutParams.rightMargin = aVar2.f35009c;
                    marginLayoutParams.bottomMargin = aVar2.f35010d;
                    i.this.f35001b.setLayoutParams(marginLayoutParams);
                    if (i.this.f35003d != null) {
                        i.this.f35003d.a(aVar);
                    }
                }
            });
            this.f35000a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f35002c != null) {
                        i.this.f35002c.a(null);
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
        this.f35002c = null;
        this.f35003d = null;
        this.f35000a.removeCallbacksAndMessages(null);
    }
}
