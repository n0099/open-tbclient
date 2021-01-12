package com.qq.e.comm.plugin.ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.qq.e.comm.plugin.ab.h;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class g implements h {

    /* renamed from: a  reason: collision with root package name */
    private d f11814a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.b.a f11815b = new com.qq.e.comm.plugin.ab.b.a(this);
    private a c;

    public g(Context context, c cVar) {
        this.f11814a = new d(context, cVar);
        this.f11814a.a(this.f11815b);
        this.c = new a();
    }

    @SuppressLint({"NewApi"})
    private boolean d(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f11814a.evaluateJavascript(str, null);
            return true;
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public View a() {
        return this.f11814a;
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(int i) {
        this.f11814a.setVisibility(i);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(com.qq.e.comm.plugin.ab.a.a aVar) {
        this.f11814a.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(com.qq.e.comm.plugin.ab.a.b bVar) {
        this.f11814a.a(bVar);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(h.a aVar) {
        this.f11814a.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(String str) {
        this.f11814a.loadUrl(str);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f11814a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(Collection<com.qq.e.comm.plugin.ab.c.e> collection) {
        this.f11814a.a(collection);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(Set<String> set) {
        this.c.a(set);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(JSONObject jSONObject) {
        this.c.a(jSONObject);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(boolean z) {
        this.f11814a.setVerticalScrollBarEnabled(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public com.qq.e.comm.plugin.ab.b.a b() {
        return this.f11814a.a();
    }

    @Override // com.qq.e.comm.plugin.ab.k
    public void b(String str) {
        if (this.f11814a.g()) {
            return;
        }
        try {
            if (d(str)) {
                return;
            }
            this.f11814a.loadUrl("javascript:" + str);
        } catch (Exception e) {
        }
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void b(boolean z) {
        this.f11814a.setHorizontalScrollBarEnabled(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void c() {
        this.f11814a.f();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void c(boolean z) {
        this.f11814a.setClickable(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public boolean c(String str) {
        return this.c.a(str);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public List<com.qq.e.comm.plugin.ab.a.b> d() {
        return this.f11814a.c();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void d(boolean z) {
        this.f11814a.setFocusable(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public c e() {
        return this.f11814a.d();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void e(boolean z) {
        this.f11814a.setFocusableInTouchMode(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public int f() {
        return this.f11814a.getWidth();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public int f(boolean z) {
        return this.f11814a.a(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public int g() {
        return this.f11814a.getHeight();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public JSONObject h() {
        return this.c.a();
    }
}
