package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40212a;

    /* renamed from: b  reason: collision with root package name */
    public String f40213b;

    /* renamed from: c  reason: collision with root package name */
    public long f40214c;

    /* renamed from: d  reason: collision with root package name */
    public int f40215d;

    /* renamed from: e  reason: collision with root package name */
    public int f40216e;

    /* renamed from: f  reason: collision with root package name */
    public String f40217f;

    public c(int i2, String str, String str2) {
        super(i2);
        this.f40214c = -1L;
        this.f40215d = -1;
        this.f40212a = str;
        this.f40213b = str2;
    }

    public final void a(int i2) {
        this.f40216e = i2;
    }

    public final void b(String str) {
        this.f40212a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f40212a);
        aVar.a("package_name", this.f40213b);
        aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
        aVar.a("PUSH_APP_STATUS", this.f40215d);
        if (TextUtils.isEmpty(this.f40217f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f40217f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f40212a = aVar.a(IAdRequestParam.REQ_ID);
        this.f40213b = aVar.a("package_name");
        this.f40214c = aVar.b(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 0L);
        this.f40215d = aVar.b("PUSH_APP_STATUS", 0);
        this.f40217f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f40216e;
    }

    public final void g() {
        this.f40217f = null;
    }

    public final String h() {
        return this.f40212a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
