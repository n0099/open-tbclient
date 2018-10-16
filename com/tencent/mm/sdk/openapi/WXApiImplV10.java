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
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
/* loaded from: classes6.dex */
final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname = null;
    private String appId;
    private boolean checkSignature;
    private Context context;
    private boolean detached = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WXApiImplV10(Context context, String str, boolean z) {
        this.checkSignature = false;
        a.c(TAG, "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            a.a(TAG, "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            a.a(TAG, "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new com.tencent.mm.sdk.a(context).getString("_wxapp_pay_entry_classname_", null);
            a.c(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                a.a(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        a.C0336a c0336a = new a.C0336a();
        c0336a.k = bundle;
        c0336a.h = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        c0336a.i = wxappPayEntryClassname;
        return com.tencent.mm.sdk.a.a.a(context, c0336a);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void detach() {
        com.tencent.mm.sdk.b.a.c(TAG, "detach");
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
        com.tencent.mm.sdk.b.a.a(TAG, "open wx app failed, not installed or signature check failed");
        return 0;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        if (!WXApiImplComm.isIntentFromWx(intent, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
            com.tencent.mm.sdk.b.a.b(TAG, "handleIntent fail, intent not from weixin msg");
            return false;
        } else if (this.detached) {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        } else {
            String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
            int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
            String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                com.tencent.mm.sdk.b.a.a(TAG, "invalid argument");
                return false;
            } else if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), b.a(stringExtra, intExtra, stringExtra2))) {
                com.tencent.mm.sdk.b.a.a(TAG, "checksum fail");
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
                        com.tencent.mm.sdk.b.a.a(TAG, "unknown cmd = " + intExtra2);
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
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, 64);
            if (packageInfo == null) {
                return false;
            }
            return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
        } catch (PackageManager.NameNotFoundException e) {
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
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            com.tencent.mm.sdk.b.a.a(TAG, "open wx app failed, not installed or signature check failed");
            return false;
        }
        try {
            this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME));
            return true;
        } catch (Exception e) {
            com.tencent.mm.sdk.b.a.a(TAG, "startActivity fail, exception = " + e.getMessage());
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean registerApp(String str) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a(TAG, "register app failed for wechat app signature check failed");
            return false;
        }
        com.tencent.mm.sdk.b.a.c(TAG, "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        com.tencent.mm.sdk.b.a.c(TAG, "register app " + this.context.getPackageName());
        a.C0337a c0337a = new a.C0337a();
        c0337a.l = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        c0337a.m = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
        c0337a.j = "weixin://registerapp?appid=" + this.appId;
        return com.tencent.mm.sdk.a.a.a.a(this.context, c0337a);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendReq(BaseReq baseReq) {
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a(TAG, "sendReq failed for wechat app signature check failed");
            return false;
        } else if (!baseReq.checkArgs()) {
            com.tencent.mm.sdk.b.a.a(TAG, "sendReq checkArgs fail");
            return false;
        } else {
            com.tencent.mm.sdk.b.a.c(TAG, "sendReq, req type = " + baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            a.C0336a c0336a = new a.C0336a();
            c0336a.k = bundle;
            c0336a.j = "weixin://sendreq?appid=" + this.appId;
            c0336a.h = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
            c0336a.i = ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
            return com.tencent.mm.sdk.a.a.a(this.context, c0336a);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendResp(BaseResp baseResp) {
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a(TAG, "sendResp failed for wechat app signature check failed");
            return false;
        } else if (!baseResp.checkArgs()) {
            com.tencent.mm.sdk.b.a.a(TAG, "sendResp checkArgs fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            a.C0336a c0336a = new a.C0336a();
            c0336a.k = bundle;
            c0336a.j = "weixin://sendresp?appid=" + this.appId;
            c0336a.h = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
            c0336a.i = ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
            return com.tencent.mm.sdk.a.a.a(this.context, c0336a);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a(TAG, "unregister app failed for wechat app signature check failed");
            return;
        }
        com.tencent.mm.sdk.b.a.c(TAG, "unregisterApp, appId = " + this.appId);
        if (this.appId == null || this.appId.length() == 0) {
            com.tencent.mm.sdk.b.a.a(TAG, "unregisterApp fail, appId is empty");
            return;
        }
        com.tencent.mm.sdk.b.a.c(TAG, "unregister app " + this.context.getPackageName());
        a.C0337a c0337a = new a.C0337a();
        c0337a.l = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        c0337a.m = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
        c0337a.j = "weixin://unregisterapp?appid=" + this.appId;
        com.tencent.mm.sdk.a.a.a.a(this.context, c0337a);
    }
}
