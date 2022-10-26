package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class f extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OAuthListener k;
    public String n;
    public int t;
    public String url;

    /* loaded from: classes8.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OAuthErrCode m;
        public String u;
        public int v;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a b(byte[] bArr) {
            InterceptResult invokeL;
            OAuthErrCode oAuthErrCode;
            String format;
            OAuthErrCode oAuthErrCode2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                a aVar = new a();
                Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (bArr == null || bArr.length == 0) {
                    Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
                } else {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bArr, IMAudioTransRequest.CHARSET));
                            int i = jSONObject.getInt("wx_errcode");
                            aVar.v = i;
                            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i)));
                            int i2 = aVar.v;
                            if (i2 == 408) {
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                            } else if (i2 != 500) {
                                switch (i2) {
                                    case 402:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                        break;
                                    case 403:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                        break;
                                    case 404:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                        break;
                                    case 405:
                                        aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.u = jSONObject.getString("wx_code");
                                        break;
                                    default:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                        break;
                                }
                                return aVar;
                            } else {
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                            }
                            aVar.m = oAuthErrCode2;
                            return aVar;
                        } catch (Exception e) {
                            format = String.format("parse json fail, ex = %s", e.getMessage());
                            Log.e("MicroMsg.SDK.NoopingResult", format);
                            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.m = oAuthErrCode;
                            return aVar;
                        }
                    } catch (Exception e2) {
                        format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    }
                }
                aVar.m = oAuthErrCode;
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, oAuthListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = str;
        this.k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str2 = this.n;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.url);
                if (this.t == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.t;
                }
                sb.append(str);
                String sb2 = sb.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a2 = e.a(sb2);
                long currentTimeMillis2 = System.currentTimeMillis();
                a b = a.b(a2);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, b.m.toString(), Integer.valueOf(b.v), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = b.m;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(b.v)));
                    return b;
                }
                int i = b.v;
                this.t = i;
                if (i == g.y.getCode()) {
                    this.k.onQrcodeScanned();
                } else if (b.v != g.A.getCode() && b.v == g.z.getCode()) {
                    String str3 = b.u;
                    if (str3 == null || str3.length() == 0) {
                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        b.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return b;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.m = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.k.onAuthFinish(aVar.m, aVar.u);
    }
}
