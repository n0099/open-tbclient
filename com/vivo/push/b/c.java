package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes7.dex */
public class c extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39756a;

    /* renamed from: b  reason: collision with root package name */
    public String f39757b;

    /* renamed from: c  reason: collision with root package name */
    public long f39758c;

    /* renamed from: d  reason: collision with root package name */
    public int f39759d;

    /* renamed from: e  reason: collision with root package name */
    public int f39760e;

    /* renamed from: f  reason: collision with root package name */
    public String f39761f;

    public c(int i, String str, String str2) {
        super(i);
        this.f39758c = -1L;
        this.f39759d = -1;
        this.f39756a = str;
        this.f39757b = str2;
    }

    public final void a(int i) {
        this.f39760e = i;
    }

    public final void b(String str) {
        this.f39756a = str;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f39756a);
        aVar.a("package_name", this.f39757b);
        aVar.a("sdk_version", 293L);
        aVar.a("PUSH_APP_STATUS", this.f39759d);
        if (TextUtils.isEmpty(this.f39761f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f39761f);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f39756a = aVar.a(IAdRequestParam.REQ_ID);
        this.f39757b = aVar.a("package_name");
        this.f39758c = aVar.b("sdk_version", 0L);
        this.f39759d = aVar.b("PUSH_APP_STATUS", 0);
        this.f39761f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f39760e;
    }

    public final void g() {
        this.f39761f = null;
    }

    public final String h() {
        return this.f39756a;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
