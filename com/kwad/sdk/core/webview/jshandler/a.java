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
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f39995b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39996c;

    /* renamed from: d  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f39997d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b.c f39998e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b.d f39999f;

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar, boolean z) {
        this.f39996c = false;
        this.f39997d = new ArrayList();
        this.f39996c = z;
        this.f39995b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        if (bVar != null) {
            bVar.a(1);
            this.f39997d.add(bVar);
        }
        this.f39998e = cVar;
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable List<com.kwad.sdk.core.download.a.b> list, @Nullable b.c cVar) {
        this(aVar, null, cVar, false);
        if (list != null) {
            this.f39997d.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        return aVar.f40012c == 1;
    }

    @Nullable
    public com.kwad.sdk.core.download.a.b a(long j) {
        List<com.kwad.sdk.core.download.a.b> list = this.f39997d;
        if (list == null) {
            return null;
        }
        if (j >= 0 || list.size() != 1) {
            for (com.kwad.sdk.core.download.a.b bVar : this.f39997d) {
                if (com.kwad.sdk.core.response.a.d.y(bVar.e()) == j) {
                    return bVar;
                }
            }
            return null;
        }
        return this.f39997d.get(0);
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
        if (!this.a.f39987h) {
            if (this.f39998e != null) {
                handler = this.f39995b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f39998e != null) {
                            a.this.f39998e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f39995b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a.i) {
                    p.a aVar2 = new p.a();
                    b.C1973b c1973b = aVar.f40013d;
                    if (c1973b != null && !TextUtils.isEmpty(c1973b.a)) {
                        aVar2.f39738h = aVar.f40013d.a;
                    }
                    AdBaseFrameLayout adBaseFrameLayout = a.this.a.f39981b;
                    if (adBaseFrameLayout != null) {
                        aVar2.f39737g = adBaseFrameLayout.getTouchCoords();
                    }
                    int i = (aVar.f40014e > 0L ? 1 : (aVar.f40014e == 0L ? 0 : -1));
                    com.kwad.sdk.core.webview.a aVar3 = a.this.a;
                    int a = com.kwad.sdk.core.download.a.a.a(new a.C1956a(a.this.a.f39983d.getContext()).a(i >= 0 ? aVar3.a(aVar.f40014e) : aVar3.a()).a(a.this.a(aVar.f40014e)).a(a.this.a(aVar)).b(a.this.f39996c).a(a.this.a.f39982c).a(aVar.f40012c).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (a.this.f39998e != null) {
                                a.this.f39998e.a(aVar);
                            }
                        }
                    }));
                    if (a.this.f39999f != null) {
                        a.this.f39999f.a(a);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f39995b.removeCallbacksAndMessages(null);
        this.f39998e = null;
    }
}
