package com.duxiaoman.dxmpay.statistics.internal;

import android.os.Build;
import android.text.TextUtils;
import c.d.a.a.a.h;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f69585a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1059505316, "Lcom/duxiaoman/dxmpay/statistics/internal/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1059505316, "Lcom/duxiaoman/dxmpay/statistics/internal/f;");
                return;
            }
        }
        f69585a = new ArrayList<String>() { // from class: com.duxiaoman.dxmpay.statistics.internal.DataConvertUtils$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("HUAWEI");
                add("OPPO");
                add(RomUtils.MANUFACTURER_VIVO);
            }
        };
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.MANUFACTURER;
            String trim = str == null ? RomUtils.UNKNOWN : str.trim();
            try {
                if (!TextUtils.isEmpty(trim)) {
                    for (String str2 : f69585a) {
                        if (str2.equalsIgnoreCase(trim)) {
                            return str2;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return trim;
        }
        return (String) invokeV.objValue;
    }

    public static String b(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9) {
        InterceptResult invokeCommon;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z), str5, str6, str7, str8, str9})) == null) {
            String str10 = "et";
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject(str);
                jSONObject.put("distinct_id", str3);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("distinct_id_key", str4);
                }
                jSONObject.put("is_login_id", z);
                jSONObject.put("source", 1);
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = null;
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals("array")) {
                        jSONObject3.put(next, jSONObject2.optString(next));
                    } else {
                        jSONArray = jSONObject2.optJSONArray("array");
                    }
                }
                jSONObject3.put("product", str5);
                jSONObject3.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, str6);
                jSONObject3.put("channel_id", str7);
                jSONObject3.put("$os", "Android");
                jSONObject3.put("$os_version", Build.VERSION.RELEASE == null ? RomUtils.UNKNOWN : Build.VERSION.RELEASE);
                jSONObject3.put("$screen_width", h.b(StatApi.getAppContext()));
                jSONObject3.put("$screen_height", h.a(StatApi.getAppContext()));
                String replace = (Build.MODEL + SignatureImpl.SEP + Build.DEVICE).replace(' ', SignatureImpl.SEP).replace('_', SignatureImpl.SEP);
                jSONObject3.put("$manufacturer", a());
                jSONObject3.put("$model", replace);
                jSONObject3.put("$app_version", str8);
                jSONObject3.put(Constants.EXTRA_KEY_APP_VERSION_CODE, str9);
                jSONObject.put("pub", jSONObject3);
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = (JSONObject) jSONArray.opt(i2);
                        jSONObject4.put("event", str2);
                        jSONObject4.put("type", ARPScriptEnvironment.KEY_DATA_PIP_TRACK);
                        if (jSONObject5.has(str10)) {
                            jSONObject4.put("time", ((Long) jSONObject5.remove(str10)).longValue());
                        }
                        String str11 = (String) jSONObject5.remove(com.baidu.fsg.base.statistics.h.f39560a);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("event_key", str11);
                        Iterator<String> keys2 = jSONObject5.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            int hashCode = next2.hashCode();
                            String str12 = str10;
                            JSONArray jSONArray3 = jSONArray;
                            if (hashCode == 3123) {
                                if (next2.equals("at")) {
                                    c2 = 3;
                                }
                                c2 = 65535;
                            } else if (hashCode == 3234) {
                                if (next2.equals(com.baidu.fsg.base.statistics.h.f39563d)) {
                                    c2 = 0;
                                }
                                c2 = 65535;
                            } else if (hashCode == 3249) {
                                if (next2.equals("ev")) {
                                    c2 = 4;
                                }
                                c2 = 65535;
                            } else if (hashCode != 3455) {
                                if (hashCode == 3527 && next2.equals(com.baidu.fsg.base.statistics.h.f39565f)) {
                                    c2 = 1;
                                }
                                c2 = 65535;
                            } else {
                                if (next2.equals(com.baidu.fsg.base.statistics.h.f39564e)) {
                                    c2 = 2;
                                }
                                c2 = 65535;
                            }
                            if (c2 == 0) {
                                jSONObject6.put("event_tag", jSONObject5.optString(com.baidu.fsg.base.statistics.h.f39563d));
                            } else if (c2 == 1) {
                                jSONObject6.put("event_number", jSONObject5.optInt(com.baidu.fsg.base.statistics.h.f39565f));
                            } else if (c2 != 2) {
                                if (c2 == 3) {
                                    jSONObject6.put("abtype", jSONObject5.optString("at"));
                                } else if (c2 != 4) {
                                    jSONObject6.put(next2, jSONObject5.opt(next2));
                                } else {
                                    JSONArray jSONArray4 = new JSONArray(jSONObject5.optString("ev"));
                                    int i3 = 0;
                                    int i4 = 1;
                                    while (i3 < jSONArray4.length()) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("value");
                                        sb.append(i4);
                                        jSONObject6.put(sb.toString(), jSONArray4.optString(i3));
                                        i3++;
                                        i4++;
                                    }
                                }
                                str10 = str12;
                                jSONArray = jSONArray3;
                            } else if (jSONObject5.optString(com.baidu.fsg.base.statistics.h.f39564e).equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING)) {
                                jSONObject6.put("$wifi", true);
                            } else {
                                jSONObject6.put("$wifi", false);
                            }
                            str10 = str12;
                            jSONArray = jSONArray3;
                        }
                        String str13 = str10;
                        JSONArray jSONArray5 = jSONArray;
                        jSONObject4.put("properties", jSONObject6);
                        jSONArray2.put(jSONObject4);
                        i2++;
                        str10 = str13;
                        jSONArray = jSONArray5;
                    }
                }
                jSONObject.put("events", jSONArray2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }
}
