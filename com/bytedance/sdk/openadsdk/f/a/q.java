package com.bytedance.sdk.openadsdk.f.a;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bytedance.sdk.openadsdk.f.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    static v f7434a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f7435b;
    @Nullable
    private final WebView c;
    @NonNull
    private final j d;
    private o f;
    private final List<n> e = new ArrayList();
    private volatile boolean g = false;

    public static j a(@NonNull WebView webView) {
        return new j(webView);
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        a();
        this.f7435b.g.a(str, eVar);
        if (this.f != null) {
            this.f.a(str);
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
        this.f7435b.g.a(str, bVar);
        if (this.f != null) {
            this.f.a(str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(j jVar) {
        this.d = jVar;
        u uVar = null;
        if (jVar.h && f7434a != null) {
            uVar = f7434a.a(jVar.k);
        }
        if (jVar.f7428a != null) {
            this.f7435b = new y();
            this.f7435b.a(jVar, uVar);
        } else {
            this.f7435b = jVar.f7429b;
            this.f7435b.a(jVar, uVar);
        }
        this.c = jVar.f7428a;
        this.e.add(jVar.j);
        i.a(jVar.f);
        x.a(jVar.g);
    }

    private void a() {
        if (this.g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
