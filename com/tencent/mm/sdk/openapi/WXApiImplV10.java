package com.tencent.mm.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public final class WXApiImplV10 implements IWXAPI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    public static String wxappPayEntryClassname;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public boolean checkSignature;
    public Context context;
    public boolean detached;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1392363840, "Lcom/tencent/mm/sdk/openapi/WXApiImplV10;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1392363840, "Lcom/tencent/mm/sdk/openapi/WXApiImplV10;");
        }
    }

    public WXApiImplV10(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.checkSignature = false;
        this.detached = false;
        a.c("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, bArr, bArr2)) == null) {
            if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
                str = "checkSumConsistent fail, invalid arguments";
            } else if (bArr.length == bArr2.length) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    if (bArr[i2] != bArr2[i2]) {
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
        return invokeLL.booleanValue;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, bundle)) == null) {
            if (wxappPayEntryClassname == null) {
                wxappPayEntryClassname = new com.tencent.mm.sdk.a(context).getString("_wxapp_pay_entry_classname_", null);
                a.c("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
                if (wxappPayEntryClassname == null) {
                    a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                    return false;
                }
            }
            a.C2020a c2020a = new a.C2020a();
            c2020a.k = bundle;
            c2020a.f69973h = "com.tencent.mm";
            c2020a.f69974i = wxappPayEntryClassname;
            return com.tencent.mm.sdk.a.a.a(context, c2020a);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "detach");
            this.detached = true;
            this.context = null;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final int getWXAppSupportAPI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.detached) {
                throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
            }
            if (isWXAppInstalled()) {
                return new com.tencent.mm.sdk.a(this.context).getInt("_build_info_sdk_int_", 0);
            }
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, intent, iWXAPIEventHandler)) == null) {
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
        return invokeLL.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean isWXAppInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean isWXAppSupportAPI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.detached) {
                throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
            }
            return getWXAppSupportAPI() >= 570490883;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean openWXApp() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean registerApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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
            a.C2021a c2021a = new a.C2021a();
            c2021a.l = "com.tencent.mm";
            c2021a.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
            c2021a.j = "weixin://registerapp?appid=" + this.appId;
            return com.tencent.mm.sdk.a.a.a.a(this.context, c2021a);
        }
        return invokeL.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendReq(BaseReq baseReq) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, baseReq)) == null) {
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
                a.C2020a c2020a = new a.C2020a();
                c2020a.k = bundle;
                c2020a.j = "weixin://sendreq?appid=" + this.appId;
                c2020a.f69973h = "com.tencent.mm";
                c2020a.f69974i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return com.tencent.mm.sdk.a.a.a(this.context, c2020a);
            } else {
                str = "sendReq checkArgs fail";
            }
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final boolean sendResp(BaseResp baseResp) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseResp)) == null) {
            if (this.detached) {
                throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
            }
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (baseResp.checkArgs()) {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                a.C2020a c2020a = new a.C2020a();
                c2020a.k = bundle;
                c2020a.j = "weixin://sendresp?appid=" + this.appId;
                c2020a.f69973h = "com.tencent.mm";
                c2020a.f69974i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return com.tencent.mm.sdk.a.a.a(this.context, c2020a);
            } else {
                str = "sendResp checkArgs fail";
            }
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPI
    public final void unregisterApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
            a.C2021a c2021a = new a.C2021a();
            c2021a.l = "com.tencent.mm";
            c2021a.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
            c2021a.j = "weixin://unregisterapp?appid=" + this.appId;
            com.tencent.mm.sdk.a.a.a.a(this.context, c2021a);
        }
    }
}
