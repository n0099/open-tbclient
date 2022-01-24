package com.qq.e.comm.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.d;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final a f59093b;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;

    /* renamed from: com.qq.e.comm.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C2181a implements NetworkCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PM a;

        public C2181a(a aVar, PM pm) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pm};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm;
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public void onException(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                GDTLogger.d("ActivateError");
            }
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public void onResponse(Request request, Response response) {
            String str;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
                try {
                    if (response.getStatusCode() == 200) {
                        String stringContent = response.getStringContent();
                        GDTLogger.d("ACTIVERESPONSE:" + stringContent);
                        if (StringUtil.isEmpty(stringContent)) {
                            GDTLogger.d("SDK Server response empty string,maybe zip or tea format error");
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(stringContent);
                        int i2 = jSONObject.has(Constants.KEYS.RET) ? jSONObject.getInt(Constants.KEYS.RET) : -1;
                        if (i2 == 0) {
                            if (this.a != null) {
                                try {
                                    this.a.getPOFactory().config(1, stringContent);
                                } catch (d e2) {
                                    e2.printStackTrace();
                                }
                                if (jSONObject.has(FunAdSdk.PLATFORM_SIG)) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject(FunAdSdk.PLATFORM_SIG);
                                    if (jSONObject2.has("jar") && jSONObject2.has("url")) {
                                        this.a.update(jSONObject2.getString("jar"), jSONObject2.getString("url"));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        sb = new StringBuilder();
                        sb.append("Response Error,retCode=");
                        sb.append(i2);
                    } else {
                        sb = new StringBuilder();
                        sb.append("SDK server response code error while launch or activate,code:");
                        sb.append(response.getStatusCode());
                    }
                    GDTLogger.d(sb.toString());
                } catch (IOException unused) {
                    str = "ActivateError";
                    GDTLogger.d(str);
                } catch (JSONException unused2) {
                    str = "Parse Active or launch response exception";
                    GDTLogger.d(str);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922659563, "Lcom/qq/e/comm/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922659563, "Lcom/qq/e/comm/b/a;");
                return;
            }
        }
        f59093b = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Boolean.FALSE;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f59093b : (a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context, long j2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{sm, pm, deviceStatus, aPPStatus, context, Long.valueOf(j2)}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = new JSONObject();
                if (sm != null) {
                    jSONObject.putOpt("suid", sm.getSuid());
                    jSONObject.putOpt("sid", sm.getSid());
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    if (sm != null) {
                        jSONObject3.putOpt("app", sm.getDevCloudSettingSig());
                        jSONObject3.putOpt("sdk", sm.getSdkCloudSettingSig());
                    }
                    if (pm != null) {
                        jSONObject3.putOpt("jar", pm.getLocalSig());
                        jSONObject3.putOpt("plugin_version", Integer.valueOf(pm.getPluginVersion()));
                    }
                    jSONObject.put(FunAdSdk.PLATFORM_SIG, jSONObject3);
                    jSONObject.put(BdZeusUtil.URL_KEY_MACHINE, com.qq.e.comm.net.a.b(deviceStatus));
                    jSONObject.put("app", com.qq.e.comm.net.a.a(aPPStatus));
                    jSONObject.put("c", com.qq.e.comm.net.a.a(deviceStatus));
                    jSONObject.put("sdk", com.qq.e.comm.net.a.a(pm));
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("sdk_init_time", (System.nanoTime() - j2) / 1000000);
                    jSONObject4.put("performance", jSONObject5);
                    jSONObject.put("biz", jSONObject4);
                } catch (JSONException unused) {
                    jSONObject2 = jSONObject;
                    GDTLogger.d("JSONException while build init req");
                    jSONObject = jSONObject2;
                    String jSONObject6 = jSONObject.toString();
                    GDTLogger.d("launch request: " + jSONObject6);
                    if (StringUtil.isEmpty(sm.getSuid())) {
                    }
                    System.currentTimeMillis();
                    NetworkClientImpl.getInstance().submit(new S2SSRequest(r7, jSONObject6.getBytes(Charset.forName("UTF-8"))), NetworkClient.Priority.High, new C2181a(this, pm));
                }
            } catch (JSONException unused2) {
            }
            String jSONObject62 = jSONObject.toString();
            GDTLogger.d("launch request: " + jSONObject62);
            String str = StringUtil.isEmpty(sm.getSuid()) ? "http://sdk.e.qq.com/launch" : "http://sdk.e.qq.com/activate";
            System.currentTimeMillis();
            NetworkClientImpl.getInstance().submit(new S2SSRequest(str, jSONObject62.getBytes(Charset.forName("UTF-8"))), NetworkClient.Priority.High, new C2181a(this, pm));
        }
    }

    public void a(Context context, SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, sm, pm, deviceStatus, aPPStatus, Long.valueOf(j2)}) == null) || this.a.booleanValue()) {
            return;
        }
        synchronized (a.class) {
            if (this.a.booleanValue()) {
                return;
            }
            a(sm, pm, deviceStatus, aPPStatus, context, j2);
            this.a = Boolean.TRUE;
        }
    }
}
