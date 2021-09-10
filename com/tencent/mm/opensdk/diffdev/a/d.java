package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends AsyncTask<Void, Void, a> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f76252h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;

    /* renamed from: i  reason: collision with root package name */
    public String f76253i;

    /* renamed from: j  reason: collision with root package name */
    public String f76254j;
    public OAuthListener k;
    public f l;
    public String scope;
    public String signature;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OAuthErrCode m;
        public String n;
        public String o;
        public String p;
        public int q;
        public String r;
        public byte[] s;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(byte[] bArr) {
            InterceptResult invokeL;
            OAuthErrCode oAuthErrCode;
            String format;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                a aVar = new a();
                if (bArr == null || bArr.length == 0) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
                } else {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                            int i2 = jSONObject.getInt("errcode");
                            if (i2 != 0) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i2)));
                                aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                                aVar.q = i2;
                                aVar.r = jSONObject.optString("errmsg");
                                return aVar;
                            }
                            String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                            if (string != null && string.length() != 0) {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode != null && decode.length != 0) {
                                    aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.s = decode;
                                    aVar.n = jSONObject.getString("uuid");
                                    String string2 = jSONObject.getString("appname");
                                    aVar.o = string2;
                                    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.n, string2, Integer.valueOf(aVar.s.length)));
                                    return aVar;
                                }
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                aVar.m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                return aVar;
                            }
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                            aVar.m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        } catch (Exception e2) {
                            format = String.format("parse json fail, ex = %s", e2.getMessage());
                            Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.m = oAuthErrCode;
                            return aVar;
                        }
                    } catch (Exception e3) {
                        format = String.format("parse fail, build String fail, ex = %s", e3.getMessage());
                    }
                }
                aVar.m = oAuthErrCode;
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1184333970, "Lcom/tencent/mm/opensdk/diffdev/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1184333970, "Lcom/tencent/mm/opensdk/diffdev/a/d;");
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, oAuthListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appId = str;
        this.scope = str2;
        this.f76253i = str3;
        this.f76254j = str4;
        this.signature = str5;
        this.k = oAuthListener;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
            f fVar = this.l;
            return fVar == null ? cancel(true) : fVar.cancel(true);
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format(f76252h, this.appId, this.f76253i, this.f76254j, this.scope, this.signature);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a2 = e.a(format);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.m;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.k.onAuthFinish(aVar2.m, null);
            return;
        }
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.s.length);
        this.k.onAuthGotQrcode(aVar2.p, aVar2.s);
        f fVar = new f(aVar2.n, this.k);
        this.l = fVar;
        if (Build.VERSION.SDK_INT >= 11) {
            fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            fVar.execute(new Void[0]);
        }
    }
}
