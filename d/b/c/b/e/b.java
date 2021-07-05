package d.b.c.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.kwai.video.player.KsMediaMeta;
import com.yy.hiidostatis.inner.BaseStatisContent;
import d.b.c.b.l;
import d.b.c.b.m;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f71846c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71847a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f71848b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1867392672, "Ld/b/c/b/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1867392672, "Ld/b/c/b/e/b;");
                return;
            }
        }
        f71846c = new String[]{"version_code", "manifest_version_code", "aid", "update_version_code"};
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71848b = new JSONObject();
        this.f71847a = context;
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            b bVar = new b(context);
            JSONObject b2 = bVar.b();
            bVar.e(b2);
            bVar.j(b2);
            bVar.k(b2);
            bVar.l(b2);
            bVar.m(b2);
            bVar.n(b2);
            bVar.h(b2);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71848b : (JSONObject) invokeV.objValue;
    }

    public JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                this.f71848b.put("device_id", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return this.f71848b;
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject d(@Nullable Map<String, Object> map) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (map == null) {
                return this.f71848b;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.f71848b.has(entry.getKey())) {
                    this.f71848b.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str : f71846c) {
                if (map.containsKey(str)) {
                    try {
                        this.f71848b.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception unused) {
                        this.f71848b.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                this.f71848b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey(CommonUrlParamManager.PARAM_IID)) {
                this.f71848b.put("udid", map.get(CommonUrlParamManager.PARAM_IID));
                this.f71848b.remove(CommonUrlParamManager.PARAM_IID);
            }
            return this.f71848b;
        }
        return (JSONObject) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public final void e(JSONObject jSONObject) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            try {
                PackageInfo packageInfo = this.f71847a.getPackageManager().getPackageInfo(this.f71847a.getPackageName(), 0);
                if (packageInfo.applicationInfo != null && (i2 = packageInfo.applicationInfo.labelRes) > 0) {
                    jSONObject.put("display_name", this.f71847a.getString(i2));
                }
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 120);
                jSONObject.put(HttpConstants.SDK_VERSION_NAME, "0.0.1-alpha.0");
                jSONObject.put(IAdRequestParam.OS, "Android");
                jSONObject.put(HttpConstants.OS_VERSION, i());
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put("device_brand", Build.BRAND);
                jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, f());
            } catch (Exception unused) {
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                    for (int i2 = 0; i2 < Build.SUPPORTED_ABIS.length; i2++) {
                        sb.append(Build.SUPPORTED_ABIS[i2]);
                        if (i2 != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        }
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
            } catch (Exception e2) {
                l.k.c(e2);
                return "unknown";
            }
        }
        return (String) invokeV.objValue;
    }

    public JSONObject g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.f71848b.put("user_id", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return this.f71848b;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void h(JSONObject jSONObject) {
        d.b.c.b.h.b a2;
        Map<String, Object> c2;
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (a2 = m.a()) == null || jSONObject == null || (c2 = a2.c()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : c2.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = c2.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(SchedulerSupport.CUSTOM, jSONObject2);
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = Build.VERSION.RELEASE;
            if (str.contains(".")) {
                return str;
            }
            return str + ".0";
        }
        return (String) invokeV.objValue;
    }

    public final void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            try {
                DisplayMetrics displayMetrics = this.f71847a.getResources().getDisplayMetrics();
                int i2 = displayMetrics.densityDpi;
                String str = i2 != 120 ? i2 != 240 ? i2 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
                jSONObject.put("density_dpi", i2);
                jSONObject.put("display_density", str);
                jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
            } catch (Exception unused) {
            }
        }
    }

    public final void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            try {
                String language = this.f71847a.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, language);
                }
                String country = Locale.getDefault().getCountry();
                if (!TextUtils.isEmpty(country)) {
                    jSONObject.put("region", country);
                }
                int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
                if (rawOffset < -12) {
                    rawOffset = -12;
                }
                if (rawOffset > 12) {
                    rawOffset = 12;
                }
                jSONObject.put(BaseStatisContent.TIMEZONE, rawOffset);
            } catch (Exception unused) {
            }
        }
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                if (l.d.e()) {
                    sb.append("MIUI-");
                } else if (l.d.f()) {
                    sb.append("FLYME-");
                } else {
                    String a2 = l.d.a();
                    if (l.d.b(a2)) {
                        sb.append("EMUI-");
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        sb.append(a2);
                        sb.append("-");
                    }
                }
                sb.append(Build.VERSION.INCREMENTAL);
                if (sb.length() > 0) {
                    jSONObject.put(Config.ROM, sb.toString());
                }
                jSONObject.put("rom_version", l.m.a());
            } catch (Throwable unused) {
            }
        }
    }

    public final void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            try {
                jSONObject.put("access", l.j.a(this.f71847a));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.f71847a.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (!TextUtils.isEmpty(networkOperatorName)) {
                        jSONObject.put("carrier", networkOperatorName);
                    }
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (TextUtils.isEmpty(networkOperator)) {
                        return;
                    }
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
