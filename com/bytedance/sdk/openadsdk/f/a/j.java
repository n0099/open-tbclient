package com.bytedance.sdk.openadsdk.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.f.a.k;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    WebView f7427a;

    /* renamed from: b  reason: collision with root package name */
    a f7428b;
    h d;
    Context e;
    boolean f;
    boolean g;
    boolean h;
    m i;
    n j;
    boolean n;
    boolean o;
    k.b p;
    String c = "IESJSBridge";
    String k = "host";
    final Set<String> l = new LinkedHashSet();
    final Set<String> m = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull WebView webView) {
        this.f7427a = webView;
    }

    j() {
    }

    public j a(@NonNull String str) {
        this.c = str;
        return this;
    }

    public j a(@NonNull l lVar) {
        this.d = h.a(lVar);
        return this;
    }

    public j a(boolean z) {
        this.f = z;
        return this;
    }

    public j b(boolean z) {
        this.g = z;
        return this;
    }

    public j a() {
        this.o = true;
        return this;
    }

    public q b() {
        c();
        return new q(this);
    }

    private void c() {
        if ((this.f7427a == null && !this.n && this.f7428b == null) || ((TextUtils.isEmpty(this.c) && this.f7427a != null) || this.d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
