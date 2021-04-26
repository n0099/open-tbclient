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
    public Handler f33700a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f33701b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f33702c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f33703d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33707a;

        /* renamed from: b  reason: collision with root package name */
        public int f33708b;

        /* renamed from: c  reason: collision with root package name */
        public int f33709c;

        /* renamed from: d  reason: collision with root package name */
        public int f33710d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f33707a = jSONObject.optInt("height");
            this.f33708b = jSONObject.optInt("leftMargin");
            this.f33709c = jSONObject.optInt("rightMargin");
            this.f33710d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f33707a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f33708b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f33709c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f33710d);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f33701b = aVar.f33626f;
        this.f33703d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f33702c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f33700a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f33701b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f33707a;
                    marginLayoutParams.leftMargin = aVar2.f33708b;
                    marginLayoutParams.rightMargin = aVar2.f33709c;
                    marginLayoutParams.bottomMargin = aVar2.f33710d;
                    i.this.f33701b.setLayoutParams(marginLayoutParams);
                    if (i.this.f33703d != null) {
                        i.this.f33703d.a(aVar);
                    }
                }
            });
            this.f33700a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f33702c != null) {
                        i.this.f33702c.a(null);
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
        this.f33702c = null;
        this.f33703d = null;
        this.f33700a.removeCallbacksAndMessages(null);
    }
}
