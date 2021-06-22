package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40315a;

    /* renamed from: b  reason: collision with root package name */
    public String f40316b;

    /* renamed from: c  reason: collision with root package name */
    public long f40317c;

    /* renamed from: d  reason: collision with root package name */
    public int f40318d;

    /* renamed from: e  reason: collision with root package name */
    public int f40319e;

    /* renamed from: f  reason: collision with root package name */
    public String f40320f;

    public c(int i2, String str, String str2) {
        super(i2);
        this.f40317c = -1L;
        this.f40318d = -1;
        this.f40315a = str;
        this.f40316b = str2;
    }

    public final void a(int i2) {
        this.f40319e = i2;
    }

    public final void b(String str) {
        this.f40315a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f40315a);
        aVar.a("package_name", this.f40316b);
        aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
        aVar.a("PUSH_APP_STATUS", this.f40318d);
        if (TextUtils.isEmpty(this.f40320f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f40320f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f40315a = aVar.a(IAdRequestParam.REQ_ID);
        this.f40316b = aVar.a("package_name");
        this.f40317c = aVar.b(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 0L);
        this.f40318d = aVar.b("PUSH_APP_STATUS", 0);
        this.f40320f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f40319e;
    }

    public final void g() {
        this.f40320f = null;
    }

    public final String h() {
        return this.f40315a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
