package com.tencent.mm.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.a.a;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
/* loaded from: classes7.dex */
public final class WXApiImplV10 implements IWXAPI {
    public static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    public static String wxappPayEntryClassname;
    public String appId;
    public boolean checkSignature;
    public Context context;
    public boolean detached = false;

    public WXApiImplV10(Context context, String str, boolean z) {
        this.checkSignature = false;
        a.c("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length == bArr2.length) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        } else {
            str = "checkSumConsistent fail, length is different";
        }
        a.a("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new com.tencent.mm.sdk.a(context).getString("_wxapp_pay_entry_classname_", null);
            a.c("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        a.C0529a c0529a = new a.C0529a();
        c0529a.k = bundle;
        c0529a.f39540h = "com.tencent.mm";
        c0529a.i = wxappPayEntryClassname;
        return com.tencent.mm.sdk.a.a.a(context, c0529a);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void detach() {
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "detach");
        this.detached = true;
        this.context = null;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (isWXAppInstalled()) {
            return new com.tencent.mm.sdk.a(this.context).getInt("_build_info_sdk_int_", 0);
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        return 0;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token")) {
            com.tencent.mm.sdk.b.a.b("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
            return false;
        } else if (this.detached) {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        } else {
            String stringExtra = intent.getStringExtra("_mmessage_content");
            int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
            String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
                return false;
            } else if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), b.a(stringExtra, intExtra, stringExtra2))) {
                com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                return false;
            } else {
                int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                switch (intExtra2) {
                    case 1:
                        iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                        return true;
                    case 2:
                        iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                        return true;
                    case 3:
                        iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                        return true;
                    case 4:
                        iWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(intent.getExtras()));
                        return true;
                    case 5:
                        iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                        return true;
                    case 6:
                        iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                        return true;
                    default:
                        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + intExtra2);
                        return false;
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean isWXAppInstalled() {
        if (this.detached) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
            if (packageInfo == null) {
                return false;
            }
            return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean isWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        return getWXAppSupportAPI() >= 570490883;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean openWXApp() {
        String str;
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (isWXAppInstalled()) {
            try {
                this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                return true;
            } catch (Exception e2) {
                str = "startActivity fail, exception = " + e2.getMessage();
            }
        } else {
            str = "open wx app failed, not installed or signature check failed";
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean registerApp(String str) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
        a.C0530a c0530a = new a.C0530a();
        c0530a.l = "com.tencent.mm";
        c0530a.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        c0530a.j = "weixin://registerapp?appid=" + this.appId;
        return com.tencent.mm.sdk.a.a.a.a(this.context, c0530a);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendReq(BaseReq baseReq) {
        String str;
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            str = "sendReq failed for wechat app signature check failed";
        } else if (baseReq.checkArgs()) {
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            a.C0529a c0529a = new a.C0529a();
            c0529a.k = bundle;
            c0529a.j = "weixin://sendreq?appid=" + this.appId;
            c0529a.f39540h = "com.tencent.mm";
            c0529a.i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return com.tencent.mm.sdk.a.a.a(this.context, c0529a);
        } else {
            str = "sendReq checkArgs fail";
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendResp(BaseResp baseResp) {
        String str;
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            str = "sendResp failed for wechat app signature check failed";
        } else if (baseResp.checkArgs()) {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            a.C0529a c0529a = new a.C0529a();
            c0529a.k = bundle;
            c0529a.j = "weixin://sendresp?appid=" + this.appId;
            c0529a.f39540h = "com.tencent.mm";
            c0529a.i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return com.tencent.mm.sdk.a.a.a(this.context, c0529a);
        } else {
            str = "sendResp checkArgs fail";
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
            return;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
        String str = this.appId;
        if (str == null || str.length() == 0) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
            return;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
        a.C0530a c0530a = new a.C0530a();
        c0530a.l = "com.tencent.mm";
        c0530a.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
        c0530a.j = "weixin://unregisterapp?appid=" + this.appId;
        com.tencent.mm.sdk.a.a.a.a(this.context, c0530a);
    }
}
