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
    public Handler f32874a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f32875b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f32876c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f32877d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f32881a;

        /* renamed from: b  reason: collision with root package name */
        public int f32882b;

        /* renamed from: c  reason: collision with root package name */
        public int f32883c;

        /* renamed from: d  reason: collision with root package name */
        public int f32884d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32881a = jSONObject.optInt("height");
            this.f32882b = jSONObject.optInt("leftMargin");
            this.f32883c = jSONObject.optInt("rightMargin");
            this.f32884d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f32881a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f32882b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f32883c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f32884d);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f32875b = aVar.f32800f;
        this.f32877d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f32876c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f32874a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f32875b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f32881a;
                    marginLayoutParams.leftMargin = aVar2.f32882b;
                    marginLayoutParams.rightMargin = aVar2.f32883c;
                    marginLayoutParams.bottomMargin = aVar2.f32884d;
                    i.this.f32875b.setLayoutParams(marginLayoutParams);
                    if (i.this.f32877d != null) {
                        i.this.f32877d.a(aVar);
                    }
                }
            });
            this.f32874a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f32876c != null) {
                        i.this.f32876c.a(null);
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
        this.f32876c = null;
        this.f32877d = null;
        this.f32874a.removeCallbacksAndMessages(null);
    }
}
