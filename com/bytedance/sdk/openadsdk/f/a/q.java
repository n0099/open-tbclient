package com.bytedance.sdk.openadsdk.f.a;

import android.webkit.WebView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bytedance.sdk.openadsdk.f.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static v f29205a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f29206b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f29207c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f29208d;

    /* renamed from: f  reason: collision with root package name */
    public o f29210f;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f29209e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f29211g = false;

    public q(j jVar) {
        v vVar;
        this.f29208d = jVar;
        u a2 = (!jVar.f29188h || (vVar = f29205a) == null) ? null : vVar.a(jVar.k);
        if (jVar.f29181a != null) {
            y yVar = new y();
            this.f29206b = yVar;
            yVar.a(jVar, a2);
        } else {
            a aVar = jVar.f29182b;
            this.f29206b = aVar;
            aVar.a(jVar, a2);
        }
        this.f29207c = jVar.f29181a;
        this.f29209e.add(jVar.j);
        i.a(jVar.f29186f);
        x.a(jVar.f29187g);
    }

    public static j a(@NonNull WebView webView) {
        return new j(webView);
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        a();
        this.f29206b.a(str, (String) t);
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        a();
        this.f29206b.f29150g.a(str, eVar);
        o oVar = this.f29210f;
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
        this.f29206b.f29150g.a(str, bVar);
        o oVar = this.f29210f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    private void a() {
        if (this.f29211g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
