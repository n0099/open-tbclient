package com.vivo.push.b;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39371a;

    /* renamed from: b  reason: collision with root package name */
    public String f39372b;

    /* renamed from: c  reason: collision with root package name */
    public long f39373c;

    /* renamed from: d  reason: collision with root package name */
    public int f39374d;

    /* renamed from: e  reason: collision with root package name */
    public int f39375e;

    /* renamed from: f  reason: collision with root package name */
    public String f39376f;

    public c(int i, String str, String str2) {
        super(i);
        this.f39373c = -1L;
        this.f39374d = -1;
        this.f39371a = str;
        this.f39372b = str2;
    }

    public final void a(int i) {
        this.f39375e = i;
    }

    public final void b(String str) {
        this.f39371a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f39371a);
        aVar.a("package_name", this.f39372b);
        aVar.a("sdk_version", 293L);
        aVar.a("PUSH_APP_STATUS", this.f39374d);
        if (TextUtils.isEmpty(this.f39376f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f39376f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f39371a = aVar.a("req_id");
        this.f39372b = aVar.a("package_name");
        this.f39373c = aVar.b("sdk_version", 0L);
        this.f39374d = aVar.b("PUSH_APP_STATUS", 0);
        this.f39376f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f39375e;
    }

    public final void g() {
        this.f39376f = null;
    }

    public final String h() {
        return this.f39371a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
