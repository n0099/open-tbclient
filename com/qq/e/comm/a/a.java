package com.qq.e.comm.a;

import android.content.Context;
import android.os.Build;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.c;
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
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f75284a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile Boolean f75285b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922629772, "Lcom/qq/e/comm/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922629772, "Lcom/qq/e/comm/a/a;");
                return;
            }
        }
        f75284a = new a();
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
        this.f75285b = Boolean.FALSE;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f75284a : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0009 */
    public static String a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j2) {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{sm, pm, deviceStatus, aPPStatus, Long.valueOf(j2)})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2 = com.qq.e.comm.net.a.a(sm);
                JSONObject jSONObject3 = new JSONObject();
                if (sm != null) {
                    jSONObject3.putOpt("app", sm.getDevCloudSettingSig());
                    jSONObject3.putOpt("sdk", sm.getSdkCloudSettingSig());
                }
                if (pm != null) {
                    jSONObject3.putOpt("jar", pm.getLocalSig());
                    jSONObject3.putOpt(Constants.KEYS.PLUGIN_VERSION, Integer.valueOf(pm.getPluginVersion()));
                }
                jSONObject2.put("sig", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                if (deviceStatus != null) {
                    jSONObject4.putOpt("did", deviceStatus.getPlainDid());
                    jSONObject4.putOpt("md", deviceStatus.model);
                    jSONObject4.putOpt("lg", deviceStatus.getLanguage());
                    jSONObject4.putOpt("w", Integer.valueOf(deviceStatus.getDeviceWidth()));
                    jSONObject4.putOpt("h", Integer.valueOf(deviceStatus.getDeviceHeight()));
                    jSONObject4.putOpt("dd", Integer.valueOf(deviceStatus.getDeviceDensity()));
                    jSONObject4.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                    jSONObject4.putOpt("os", "android");
                    jSONObject4.putOpt("op", deviceStatus.getOperator());
                    jSONObject4.putOpt("mf", Build.MANUFACTURER);
                }
                jSONObject2.put(BdZeusUtil.URL_KEY_MACHINE, jSONObject4);
                jSONObject2.put("app", com.qq.e.comm.net.a.a(aPPStatus));
                jSONObject2.put("c", com.qq.e.comm.net.a.a(deviceStatus));
                jSONObject2.put("sdk", com.qq.e.comm.net.a.a(pm));
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("sdk_init_time", (System.nanoTime() - j2) / 1000000);
                jSONObject5.put("performance", jSONObject6);
                jSONObject2.put("biz", jSONObject5);
                jSONObject = jSONObject2;
            } catch (JSONException unused) {
                GDTLogger.d("JSONException while build init req");
                jSONObject = jSONObject2;
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public final void a(Context context, SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, sm, pm, deviceStatus, aPPStatus, Long.valueOf(j2)}) == null) || this.f75285b.booleanValue()) {
            return;
        }
        synchronized (a.class) {
            if (this.f75285b.booleanValue()) {
                return;
            }
            String a2 = a(sm, pm, deviceStatus, aPPStatus, j2);
            GDTLogger.d("launch request: " + a2);
            String str = StringUtil.isEmpty(sm.getSuid()) ? "http://sdk.e.qq.com/activate" : "http://sdk.e.qq.com/launch";
            System.currentTimeMillis();
            NetworkClientImpl.getInstance().submit(new S2SSRequest(str, a2.getBytes(Charset.forName("UTF-8"))), NetworkClient.Priority.High, new NetworkCallBack(this, pm) { // from class: com.qq.e.comm.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ PM f75286a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ a f75287b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pm};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f75287b = this;
                    this.f75286a = pm;
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public final void onException(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        GDTLogger.d("ActivateError");
                    }
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public final void onResponse(Request request, Response response) {
                    StringBuilder sb;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
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
                                    if (this.f75286a != null) {
                                        try {
                                            this.f75286a.getPOFactory().config(1, stringContent);
                                        } catch (c e2) {
                                            e2.printStackTrace();
                                        }
                                        if (jSONObject.has("sig")) {
                                            JSONObject jSONObject2 = jSONObject.getJSONObject("sig");
                                            if (jSONObject2.has("jar") && jSONObject2.has("url")) {
                                                this.f75286a.update(jSONObject2.getString("jar"), jSONObject2.getString("url"));
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                sb = new StringBuilder("Response Error,retCode=");
                                sb.append(i2);
                            } else {
                                sb = new StringBuilder("SDK server response code error while launch or activate,code:");
                                sb.append(response.getStatusCode());
                            }
                            GDTLogger.d(sb.toString());
                        } catch (IOException unused) {
                            GDTLogger.d("ActivateError");
                        } catch (JSONException unused2) {
                            GDTLogger.d("Parse Active or launch response exception");
                        }
                    }
                }
            });
            this.f75285b = Boolean.TRUE;
        }
    }
}
