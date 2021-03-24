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
    public WebView f29319a;

    /* renamed from: b  reason: collision with root package name */
    public a f29320b;

    /* renamed from: d  reason: collision with root package name */
    public h f29322d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29323e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29324f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29325g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29326h;
    public m i;
    public n j;
    public boolean n;
    public boolean o;
    public k.b p;

    /* renamed from: c  reason: collision with root package name */
    public String f29321c = "IESJSBridge";
    public String k = "host";
    public final Set<String> l = new LinkedHashSet();
    public final Set<String> m = new LinkedHashSet();

    public j(@NonNull WebView webView) {
        this.f29319a = webView;
    }

    private void c() {
        if ((this.f29319a == null && !this.n && this.f29320b == null) || ((TextUtils.isEmpty(this.f29321c) && this.f29319a != null) || this.f29322d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public j a(@NonNull String str) {
        this.f29321c = str;
        return this;
    }

    public j b(boolean z) {
        this.f29325g = z;
        return this;
    }

    public j a(@NonNull l lVar) {
        this.f29322d = h.a(lVar);
        return this;
    }

    public q b() {
        c();
        return new q(this);
    }

    public j a(boolean z) {
        this.f29324f = z;
        return this;
    }

    public j a() {
        this.o = true;
        return this;
    }

    public j() {
    }
}
