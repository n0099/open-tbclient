package com.bytedance.sdk.openadsdk.f.a;

import android.webkit.WebView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bytedance.sdk.openadsdk.f.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static v f29036a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f29037b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f29038c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f29039d;

    /* renamed from: f  reason: collision with root package name */
    public o f29041f;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f29040e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f29042g = false;

    public q(j jVar) {
        v vVar;
        this.f29039d = jVar;
        u a2 = (!jVar.f29020h || (vVar = f29036a) == null) ? null : vVar.a(jVar.k);
        if (jVar.f29013a != null) {
            y yVar = new y();
            this.f29037b = yVar;
            yVar.a(jVar, a2);
        } else {
            a aVar = jVar.f29014b;
            this.f29037b = aVar;
            aVar.a(jVar, a2);
        }
        this.f29038c = jVar.f29013a;
        this.f29040e.add(jVar.j);
        i.a(jVar.f29018f);
        x.a(jVar.f29019g);
    }

    public static j a(@NonNull WebView webView) {
        return new j(webView);
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        a();
        this.f29037b.a(str, (String) t);
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        a();
        this.f29037b.f28983g.a(str, eVar);
        o oVar = this.f29041f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public q a(String str, @NonNull d.b bVar) {
        return a(str, (String) null, bVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull d.b bVar) {
        a();
        this.f29037b.f28983g.a(str, bVar);
        o oVar = this.f29041f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    private void a() {
        if (this.f29042g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
