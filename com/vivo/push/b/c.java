package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
/* loaded from: classes8.dex */
public class c extends com.vivo.push.y {
    private String a;
    private String b;
    private long c;
    private int d;
    private int e;
    private String f;

    public c(int i, String str, String str2) {
        super(i);
        this.c = -1L;
        this.d = -1;
        this.a = str;
        this.b = str2;
    }

    public final int f() {
        return this.e;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void g() {
        this.f = null;
    }

    public final String h() {
        return this.a;
    }

    public final void b(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.a);
        aVar.a("package_name", this.b);
        aVar.a(SapiContext.KEY_SDK_VERSION, 293L);
        aVar.a("PUSH_APP_STATUS", this.d);
        if (!TextUtils.isEmpty(this.f)) {
            aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a("req_id");
        this.b = aVar.a("package_name");
        this.c = aVar.b(SapiContext.KEY_SDK_VERSION, 0L);
        this.d = aVar.b("PUSH_APP_STATUS", 0);
        this.f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "BaseAppCommand";
    }
}
