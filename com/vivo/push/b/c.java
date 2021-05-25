package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f36533a;

    /* renamed from: b  reason: collision with root package name */
    public String f36534b;

    /* renamed from: c  reason: collision with root package name */
    public long f36535c;

    /* renamed from: d  reason: collision with root package name */
    public int f36536d;

    /* renamed from: e  reason: collision with root package name */
    public int f36537e;

    /* renamed from: f  reason: collision with root package name */
    public String f36538f;

    public c(int i2, String str, String str2) {
        super(i2);
        this.f36535c = -1L;
        this.f36536d = -1;
        this.f36533a = str;
        this.f36534b = str2;
    }

    public final void a(int i2) {
        this.f36537e = i2;
    }

    public final void b(String str) {
        this.f36533a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f36533a);
        aVar.a("package_name", this.f36534b);
        aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
        aVar.a("PUSH_APP_STATUS", this.f36536d);
        if (TextUtils.isEmpty(this.f36538f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f36538f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f36533a = aVar.a(IAdRequestParam.REQ_ID);
        this.f36534b = aVar.a("package_name");
        this.f36535c = aVar.b(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 0L);
        this.f36536d = aVar.b("PUSH_APP_STATUS", 0);
        this.f36538f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f36537e;
    }

    public final void g() {
        this.f36538f = null;
    }

    public final String h() {
        return this.f36533a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
