package com.qq.e.comm.services;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
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
import com.qq.e.comm.services.RetCodeService;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f38073a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile Boolean f38074b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(134419623, "Lcom/qq/e/comm/services/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(134419623, "Lcom/qq/e/comm/services/a;");
                return;
            }
        }
        f38073a = new a();
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
        this.f38074b = Boolean.FALSE;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f38073a : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0009 */
    public static String a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{sm, pm, deviceStatus, aPPStatus, Long.valueOf(j)})) == null) {
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
                    jSONObject4.putOpt(Config.DEVICE_ID_SEC, Integer.valueOf(deviceStatus.getDeviceDensity()));
                    jSONObject4.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                    jSONObject4.putOpt(IAdRequestParam.OS, "android");
                    jSONObject4.putOpt("op", deviceStatus.getOperator());
                    jSONObject4.putOpt("mf", Build.MANUFACTURER);
                }
                jSONObject2.put(BdZeusUtil.URL_KEY_MACHINE, jSONObject4);
                jSONObject2.put("app", com.qq.e.comm.net.a.a(aPPStatus));
                jSONObject2.put("c", com.qq.e.comm.net.a.a(deviceStatus));
                jSONObject2.put("sdk", com.qq.e.comm.net.a.a(pm));
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
                jSONObject5.put("performance", jSONObject6);
                jSONObject2.put("biz", jSONObject5);
                jSONObject = jSONObject2;
            } catch (JSONException e2) {
                GDTLogger.e("JSONException while build init req", e2);
                jSONObject = jSONObject2;
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, th) == null) {
            if (GDTADManager.getInstance() == null || !GDTADManager.getInstance().isInitialized()) {
                GDTLogger.w("Report Not Work while  ADManager  not Inited");
                return;
            }
            try {
                JSONObject a2 = com.qq.e.comm.net.a.a(GDTADManager.getInstance().getSM());
                a2.put("c", com.qq.e.comm.net.a.a(GDTADManager.getInstance().getDeviceStatus()));
                a2.put("app", com.qq.e.comm.net.a.a(GDTADManager.getInstance().getAppStatus()));
                HashMap hashMap = new HashMap();
                if (th != null) {
                    hashMap.put("extype", th.getClass().getName());
                    hashMap.put("ext", str + "\r" + th.getMessage() + "\r" + Arrays.toString(th.getStackTrace()));
                } else {
                    hashMap.put("extype", "");
                    hashMap.put(Config.EXCEPTION_PART, str);
                }
                a2.put("biz", new JSONObject(hashMap));
                NetworkClientImpl.getInstance().submit(new S2SSRequest("http://sdk.e.qq.com/err", a2.toString().getBytes(Charset.forName("UTF-8"))));
            } catch (Throwable th2) {
                GDTLogger.w("Exception While build s2ss error report req", th2);
            }
        }
    }

    public final void a(Context context, SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, sm, pm, deviceStatus, aPPStatus, Long.valueOf(j)}) == null) || this.f38074b.booleanValue()) {
            return;
        }
        synchronized (a.class) {
            if (this.f38074b.booleanValue()) {
                return;
            }
            String a2 = a(sm, pm, deviceStatus, aPPStatus, j);
            GDTLogger.d("launch request: " + a2);
            NetworkClientImpl.getInstance().submit(new S2SSRequest(StringUtil.isEmpty(sm.getSuid()) ? "http://sdk.e.qq.com/activate" : "http://sdk.e.qq.com/launch", a2.getBytes(Charset.forName("UTF-8"))), NetworkClient.Priority.High, new NetworkCallBack(this, pm, System.currentTimeMillis()) { // from class: com.qq.e.comm.services.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ PM f38075a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ long f38076b;

                /* renamed from: c  reason: collision with root package name */
                public /* synthetic */ a f38077c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pm, Long.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38077c = this;
                    this.f38075a = pm;
                    this.f38076b = r8;
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public final void onException(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        GDTLogger.e("ActivateError", exc);
                        RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", -1, (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1));
                    }
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public final void onResponse(Request request, Response response) {
                    RetCodeService retCodeService;
                    RetCodeService.RetCodeInfo retCodeInfo;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
                        try {
                            try {
                                try {
                                } catch (JSONException e2) {
                                    GDTLogger.e("Parse Active or launch response exception", e2);
                                    retCodeService = RetCodeService.getInstance();
                                    retCodeInfo = new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1);
                                }
                            } catch (IOException e3) {
                                GDTLogger.e("ActivateError", e3);
                                retCodeService = RetCodeService.getInstance();
                                retCodeInfo = new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1);
                            }
                            if (response.getStatusCode() == 200) {
                                String stringContent = response.getStringContent();
                                GDTLogger.d("ACTIVERESPONSE:" + stringContent);
                                if (StringUtil.isEmpty(stringContent)) {
                                    GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                                    retCodeService = RetCodeService.getInstance();
                                    retCodeInfo = new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1);
                                    retCodeService.send(retCodeInfo);
                                }
                                JSONObject jSONObject = new JSONObject(stringContent);
                                int i2 = jSONObject.has(Constants.KEYS.RET) ? jSONObject.getInt(Constants.KEYS.RET) : -1;
                                if (i2 == 0) {
                                    if (this.f38075a != null) {
                                        try {
                                            this.f38075a.getPOFactory().config(1, stringContent);
                                        } catch (c e4) {
                                            e4.printStackTrace();
                                        }
                                        if (jSONObject.has("sig")) {
                                            JSONObject jSONObject2 = jSONObject.getJSONObject("sig");
                                            if (jSONObject2.has("jar") && jSONObject2.has("url")) {
                                                this.f38075a.update(jSONObject2.getString("jar"), jSONObject2.getString("url"));
                                            }
                                        }
                                    }
                                    retCodeService = RetCodeService.getInstance();
                                    retCodeInfo = new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1);
                                    retCodeService.send(retCodeInfo);
                                }
                                str = "Response Error,retCode=" + i2;
                            } else {
                                str = "SDK server response code error while launch or activate,code:" + response.getStatusCode();
                            }
                            GDTLogger.e(str);
                            retCodeService = RetCodeService.getInstance();
                            retCodeInfo = new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1);
                            retCodeService.send(retCodeInfo);
                        } catch (Throwable th) {
                            RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - this.f38076b), 0, 0, 1));
                            throw th;
                        }
                    }
                }
            });
            this.f38074b = Boolean.TRUE;
        }
    }
}
