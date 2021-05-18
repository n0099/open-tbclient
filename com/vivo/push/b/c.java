package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f36604a;

    /* renamed from: b  reason: collision with root package name */
    public String f36605b;

    /* renamed from: c  reason: collision with root package name */
    public long f36606c;

    /* renamed from: d  reason: collision with root package name */
    public int f36607d;

    /* renamed from: e  reason: collision with root package name */
    public int f36608e;

    /* renamed from: f  reason: collision with root package name */
    public String f36609f;

    public c(int i2, String str, String str2) {
        super(i2);
        this.f36606c = -1L;
        this.f36607d = -1;
        this.f36604a = str;
        this.f36605b = str2;
    }

    public final void a(int i2) {
        this.f36608e = i2;
    }

    public final void b(String str) {
        this.f36604a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f36604a);
        aVar.a("package_name", this.f36605b);
        aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
        aVar.a("PUSH_APP_STATUS", this.f36607d);
        if (TextUtils.isEmpty(this.f36609f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f36609f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f36604a = aVar.a(IAdRequestParam.REQ_ID);
        this.f36605b = aVar.a("package_name");
        this.f36606c = aVar.b(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 0L);
        this.f36607d = aVar.b("PUSH_APP_STATUS", 0);
        this.f36609f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f36608e;
    }

    public final void g() {
        this.f36609f = null;
    }

    public final String h() {
        return this.f36604a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
