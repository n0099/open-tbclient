package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes6.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f37359a;

    /* renamed from: b  reason: collision with root package name */
    public String f37360b;

    /* renamed from: c  reason: collision with root package name */
    public long f37361c;

    /* renamed from: d  reason: collision with root package name */
    public int f37362d;

    /* renamed from: e  reason: collision with root package name */
    public int f37363e;

    /* renamed from: f  reason: collision with root package name */
    public String f37364f;

    public c(int i2, String str, String str2) {
        super(i2);
        this.f37361c = -1L;
        this.f37362d = -1;
        this.f37359a = str;
        this.f37360b = str2;
    }

    public final void a(int i2) {
        this.f37363e = i2;
    }

    public final void b(String str) {
        this.f37359a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f37359a);
        aVar.a("package_name", this.f37360b);
        aVar.a("sdk_version", 293L);
        aVar.a("PUSH_APP_STATUS", this.f37362d);
        if (TextUtils.isEmpty(this.f37364f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f37364f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f37359a = aVar.a(IAdRequestParam.REQ_ID);
        this.f37360b = aVar.a("package_name");
        this.f37361c = aVar.b("sdk_version", 0L);
        this.f37362d = aVar.b("PUSH_APP_STATUS", 0);
        this.f37364f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f37363e;
    }

    public final void g() {
        this.f37364f = null;
    }

    public final String h() {
        return this.f37359a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
