package com.tencent.mm.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.algorithm.b;
import com.tencent.mm.sdk.MMSharedPreferences;
import com.tencent.mm.sdk.channel.ConstantsMMessage;
import com.tencent.mm.sdk.channel.MMessage;
import com.tencent.mm.sdk.channel.MMessageAct;
import com.tencent.mm.sdk.openapi.GetMessageFromWX;
import com.tencent.mm.sdk.openapi.SendAuth;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.ShowMessageFromWX;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
/* loaded from: classes.dex */
final class WXApiImplV10 implements IWXAPI {
    private Context R;
    private String S;
    private boolean T;

    /* JADX INFO: Access modifiers changed from: protected */
    public WXApiImplV10(Context context, String str) {
        this(context, str, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WXApiImplV10(Context context, String str, boolean z) {
        this.T = false;
        this.R = context;
        this.S = str;
        this.T = z;
    }

    private boolean a(String str) {
        if (this.T) {
            try {
                return a(this.R.getPackageManager().getPackageInfo(str, 64).signatures);
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "ignore wechat app signature validation");
        return true;
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
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

    private boolean a(Signature[] signatureArr) {
        if (!this.T) {
            Log.d("MicroMsg.SDK.WXApiImplV10", "ignore wechat app signature validation");
            return true;
        }
        for (Signature signature : signatureArr) {
            String charsString = signature.toCharsString();
            Log.d("MicroMsg.SDK.WXApiImplV10", "check signature:" + charsString);
            if (charsString.equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                Log.d("MicroMsg.SDK.WXApiImplV10", "pass");
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final int getWXAppSupportAPI() {
        if (isWXAppInstalled()) {
            return new MMSharedPreferences(this.R).getInt("_build_info_sdk_int_", 0);
        }
        Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        return 0;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        boolean z;
        if (intent == null) {
            z = false;
        } else {
            String stringExtra = intent.getStringExtra(ConstantsAPI.WX_TOKEN_KEY);
            z = stringExtra != null && stringExtra.equals(ConstantsAPI.WX_TOKEN_VALUE);
        }
        if (z) {
            String stringExtra2 = intent.getStringExtra(ConstantsMMessage.CONTENT);
            int intExtra = intent.getIntExtra(ConstantsMMessage.SDK_VERSION, 0);
            String stringExtra3 = intent.getStringExtra(ConstantsMMessage.APP_PACKAGE);
            if (stringExtra3 == null || stringExtra3.length() == 0) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
                return false;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra(ConstantsMMessage.CHECK_SUM);
            StringBuffer stringBuffer = new StringBuffer();
            if (stringExtra2 != null) {
                stringBuffer.append(stringExtra2);
            }
            stringBuffer.append(intExtra);
            stringBuffer.append(stringExtra3);
            stringBuffer.append("mMcShCsTr");
            if (!a(byteArrayExtra, b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes())) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                return false;
            }
            switch (intent.getIntExtra("_wxapi_command_type", 0)) {
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
                default:
                    return false;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean isWXAppInstalled() {
        try {
            PackageInfo packageInfo = this.R.getPackageManager().getPackageInfo(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, 64);
            if (packageInfo == null) {
                return false;
            }
            return a(packageInfo.signatures);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean isWXAppSupportAPI() {
        return getWXAppSupportAPI() >= 553844737;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean openWXApp() {
        if (!isWXAppInstalled()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return false;
        }
        try {
            this.R.startActivity(this.R.getPackageManager().getLaunchIntentForPackage(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN));
            return true;
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + e.getMessage());
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean registerApp(String str) {
        if (!a(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        if (str != null) {
            this.S = str;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.R.getPackageName());
        MMessage.send(this.R, MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, ConstantsAPI.ACTION_HANDLE_APP_REGISTER, "weixin://registerapp?appid=" + this.S);
        return true;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendReq(BaseReq baseReq) {
        if (!a(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
            return false;
        } else if (!baseReq.checkArgs()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            return MMessageAct.sendToWx(this.R, "weixin://sendreq?appid=" + this.S, bundle);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendResp(BaseResp baseResp) {
        if (!a(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
            return false;
        } else if (!baseResp.checkArgs()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            return MMessageAct.sendToWx(this.R, "weixin://sendresp?appid=" + this.S, bundle);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void unregisterApp() {
        if (!a(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
        } else if (this.S == null || this.S.length() == 0) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
        } else {
            Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.R.getPackageName());
            MMessage.send(this.R, MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER, "weixin://unregisterapp?appid=" + this.S);
        }
    }
}
