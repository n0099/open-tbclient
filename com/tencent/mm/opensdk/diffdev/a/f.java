package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class f extends AsyncTask<Void, Void, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OAuthListener k;
    public String n;
    public int t;
    public String url;

    /* loaded from: classes7.dex */
    public static class a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                            JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                            int i2 = jSONObject.getInt("wx_errcode");
                            aVar.v = i2;
                            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                            int i3 = aVar.v;
                            if (i3 == 408) {
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                            } else if (i3 != 500) {
                                switch (i3) {
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
                        } catch (Exception e2) {
                            format = String.format("parse json fail, ex = %s", e2.getMessage());
                            Log.e("MicroMsg.SDK.NoopingResult", format);
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

    public f(String str, OAuthListener oAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, oAuthListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = str;
        this.k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) {
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
                a b2 = a.b(a2);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, b2.m.toString(), Integer.valueOf(b2.v), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = b2.m;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(b2.v)));
                    return b2;
                }
                int i2 = b2.v;
                this.t = i2;
                if (i2 == g.y.getCode()) {
                    this.k.onQrcodeScanned();
                } else if (b2.v != g.A.getCode() && b2.v == g.z.getCode()) {
                    String str3 = b2.u;
                    if (str3 == null || str3.length() == 0) {
                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        b2.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return b2;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.m = oAuthErrCode;
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.k.onAuthFinish(aVar2.m, aVar2.u);
    }
}
