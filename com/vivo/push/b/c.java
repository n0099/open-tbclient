package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39661a;

    /* renamed from: b  reason: collision with root package name */
    public String f39662b;

    /* renamed from: c  reason: collision with root package name */
    public long f39663c;

    /* renamed from: d  reason: collision with root package name */
    public int f39664d;

    /* renamed from: e  reason: collision with root package name */
    public int f39665e;

    /* renamed from: f  reason: collision with root package name */
    public String f39666f;

    public c(int i, String str, String str2) {
        super(i);
        this.f39663c = -1L;
        this.f39664d = -1;
        this.f39661a = str;
        this.f39662b = str2;
    }

    public final void a(int i) {
        this.f39665e = i;
    }

    public final void b(String str) {
        this.f39661a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f39661a);
        aVar.a("package_name", this.f39662b);
        aVar.a("sdk_version", 293L);
        aVar.a("PUSH_APP_STATUS", this.f39664d);
        if (TextUtils.isEmpty(this.f39666f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f39666f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f39661a = aVar.a(IAdRequestParam.REQ_ID);
        this.f39662b = aVar.a("package_name");
        this.f39663c = aVar.b("sdk_version", 0L);
        this.f39664d = aVar.b("PUSH_APP_STATUS", 0);
        this.f39666f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f39665e;
    }

    public final void g() {
        this.f39666f = null;
    }

    public final String h() {
        return this.f39661a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
