package com.vivo.push.b;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39372a;

    /* renamed from: b  reason: collision with root package name */
    public String f39373b;

    /* renamed from: c  reason: collision with root package name */
    public long f39374c;

    /* renamed from: d  reason: collision with root package name */
    public int f39375d;

    /* renamed from: e  reason: collision with root package name */
    public int f39376e;

    /* renamed from: f  reason: collision with root package name */
    public String f39377f;

    public c(int i, String str, String str2) {
        super(i);
        this.f39374c = -1L;
        this.f39375d = -1;
        this.f39372a = str;
        this.f39373b = str2;
    }

    public final void a(int i) {
        this.f39376e = i;
    }

    public final void b(String str) {
        this.f39372a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f39372a);
        aVar.a("package_name", this.f39373b);
        aVar.a("sdk_version", 293L);
        aVar.a("PUSH_APP_STATUS", this.f39375d);
        if (TextUtils.isEmpty(this.f39377f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f39377f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f39372a = aVar.a("req_id");
        this.f39373b = aVar.a("package_name");
        this.f39374c = aVar.b("sdk_version", 0L);
        this.f39375d = aVar.b("PUSH_APP_STATUS", 0);
        this.f39377f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f39376e;
    }

    public final void g() {
        this.f39377f = null;
    }

    public final String h() {
        return this.f39372a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
