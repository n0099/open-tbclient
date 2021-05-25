package com.bytedance.sdk.openadsdk.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.f.a.k;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public WebView f29078a;

    /* renamed from: b  reason: collision with root package name */
    public a f29079b;

    /* renamed from: d  reason: collision with root package name */
    public h f29081d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29082e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29083f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29084g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29085h;

    /* renamed from: i  reason: collision with root package name */
    public m f29086i;
    public n j;
    public boolean n;
    public boolean o;
    public k.b p;

    /* renamed from: c  reason: collision with root package name */
    public String f29080c = "IESJSBridge";
    public String k = "host";
    public final Set<String> l = new LinkedHashSet();
    public final Set<String> m = new LinkedHashSet();

    public j(@NonNull WebView webView) {
        this.f29078a = webView;
    }

    private void c() {
        if ((this.f29078a == null && !this.n && this.f29079b == null) || ((TextUtils.isEmpty(this.f29080c) && this.f29078a != null) || this.f29081d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public j a(@NonNull String str) {
        this.f29080c = str;
        return this;
    }

    public j b(boolean z) {
        this.f29084g = z;
        return this;
    }

    public j a(@NonNull l lVar) {
        this.f29081d = h.a(lVar);
        return this;
    }

    public q b() {
        c();
        return new q(this);
    }

    public j a(boolean z) {
        this.f29083f = z;
        return this;
    }

    public j a() {
        this.o = true;
        return this;
    }

    public j() {
    }
}
