package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f58552b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58553c;

    /* renamed from: d  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f58554d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b.c f58555e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b.d f58556f;

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar, boolean z) {
        this.f58553c = false;
        this.f58554d = new ArrayList();
        this.f58553c = z;
        this.f58552b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        if (bVar != null) {
            bVar.a(1);
            this.f58554d.add(bVar);
        }
        this.f58555e = cVar;
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable List<com.kwad.sdk.core.download.a.b> list, @Nullable b.c cVar) {
        this(aVar, null, cVar, false);
        if (list != null) {
            this.f58554d.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        return aVar.f58569c == 1;
    }

    @Nullable
    public com.kwad.sdk.core.download.a.b a(long j2) {
        List<com.kwad.sdk.core.download.a.b> list = this.f58554d;
        if (list == null) {
            return null;
        }
        if (j2 >= 0 || list.size() != 1) {
            for (com.kwad.sdk.core.download.a.b bVar : this.f58554d) {
                if (com.kwad.sdk.core.response.a.d.y(bVar.e()) == j2) {
                    return bVar;
                }
            }
            return null;
        }
        return this.f58554d.get(0);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.a.c()) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final b.a aVar = new b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.a.f58542h) {
            if (this.f58555e != null) {
                handler = this.f58552b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f58555e != null) {
                            a.this.f58555e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f58552b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a.f58543i) {
                    p.a aVar2 = new p.a();
                    b.C2100b c2100b = aVar.f58570d;
                    if (c2100b != null && !TextUtils.isEmpty(c2100b.a)) {
                        aVar2.f58268h = aVar.f58570d.a;
                    }
                    AdBaseFrameLayout adBaseFrameLayout = a.this.a.f58536b;
                    if (adBaseFrameLayout != null) {
                        aVar2.f58267g = adBaseFrameLayout.getTouchCoords();
                    }
                    int i2 = (aVar.f58571e > 0L ? 1 : (aVar.f58571e == 0L ? 0 : -1));
                    com.kwad.sdk.core.webview.a aVar3 = a.this.a;
                    int a = com.kwad.sdk.core.download.a.a.a(new a.C2083a(a.this.a.f58538d.getContext()).a(i2 >= 0 ? aVar3.a(aVar.f58571e) : aVar3.a()).a(a.this.a(aVar.f58571e)).a(a.this.a(aVar)).b(a.this.f58553c).a(a.this.a.f58537c).a(aVar.f58569c).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (a.this.f58555e != null) {
                                a.this.f58555e.a(aVar);
                            }
                        }
                    }));
                    if (a.this.f58556f != null) {
                        a.this.f58556f.a(a);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f58552b.removeCallbacksAndMessages(null);
        this.f58555e = null;
    }
}
