package com.vivo.push.b;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class c extends com.vivo.push.v {
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
    @Override // com.vivo.push.v
    public void d(Intent intent) {
        intent.putExtra("req_id", this.a);
        intent.putExtra(Constants.PACKAGE_NAME, this.b);
        intent.putExtra(SapiContext.KEY_SDK_VERSION, 225L);
        intent.putExtra("PUSH_APP_STATUS", this.d);
        if (!TextUtils.isEmpty(this.f)) {
            intent.putExtra("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void e(Intent intent) {
        this.a = intent.getStringExtra("req_id");
        this.b = intent.getStringExtra(Constants.PACKAGE_NAME);
        this.c = intent.getLongExtra(SapiContext.KEY_SDK_VERSION, 0L);
        this.d = intent.getIntExtra("PUSH_APP_STATUS", 0);
        this.f = intent.getStringExtra("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }
}
