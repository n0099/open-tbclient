package com.vivo.push.b;

import android.content.Intent;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.SapiContext;
/* loaded from: classes3.dex */
public final class b extends c {
    private String a;
    private String b;
    private String c;

    public b(boolean z, String str) {
        super(z ? UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND : UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE, null, str);
    }

    public final void d() {
        this.c = null;
    }

    public final void e() {
        this.b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra("sdk_clients", this.a);
        intent.putExtra(SapiContext.KEY_SDK_VERSION, 225L);
        intent.putExtra("BaseAppCommand.EXTRA_APPID", this.c);
        intent.putExtra("BaseAppCommand.EXTRA_APPKEY", this.b);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringExtra("sdk_clients");
        this.c = intent.getStringExtra("BaseAppCommand.EXTRA_APPID");
        this.b = intent.getStringExtra("BaseAppCommand.EXTRA_APPKEY");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
