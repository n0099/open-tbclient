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
    public Handler f34644a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final WebView f34645b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34646c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34647d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34651a;

        /* renamed from: b  reason: collision with root package name */
        public int f34652b;

        /* renamed from: c  reason: collision with root package name */
        public int f34653c;

        /* renamed from: d  reason: collision with root package name */
        public int f34654d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f34651a = jSONObject.optInt("height");
            this.f34652b = jSONObject.optInt("leftMargin");
            this.f34653c = jSONObject.optInt("rightMargin");
            this.f34654d = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f34651a);
            com.kwad.sdk.utils.o.a(jSONObject, "leftMargin", this.f34652b);
            com.kwad.sdk.utils.o.a(jSONObject, "rightMargin", this.f34653c);
            com.kwad.sdk.utils.o.a(jSONObject, "bottomMargin", this.f34654d);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public i(com.kwad.sdk.core.webview.a aVar, @Nullable b bVar) {
        this.f34645b = aVar.f34579f;
        this.f34647d = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34646c = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.a(jSONObject);
            this.f34644a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f34645b.getLayoutParams();
                    marginLayoutParams.width = -1;
                    a aVar2 = aVar;
                    marginLayoutParams.height = aVar2.f34651a;
                    marginLayoutParams.leftMargin = aVar2.f34652b;
                    marginLayoutParams.rightMargin = aVar2.f34653c;
                    marginLayoutParams.bottomMargin = aVar2.f34654d;
                    i.this.f34645b.setLayoutParams(marginLayoutParams);
                    if (i.this.f34647d != null) {
                        i.this.f34647d.a(aVar);
                    }
                }
            });
            this.f34644a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f34646c != null) {
                        i.this.f34646c.a(null);
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
        this.f34646c = null;
        this.f34647d = null;
        this.f34644a.removeCallbacksAndMessages(null);
    }
}
