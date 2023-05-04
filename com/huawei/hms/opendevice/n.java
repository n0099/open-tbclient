package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.jza;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import com.qq.e.comm.constants.Constants;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final /* synthetic */ a[] n;
        public transient /* synthetic */ FieldHolder $fh;
        public String o;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(245286896, "Lcom/huawei/hms/opendevice/n$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(245286896, "Lcom/huawei/hms/opendevice/n$a;");
                    return;
                }
            }
            a = new a("MOBILE", 0, "1");
            b = new a("PC", 1, "2");
            c = new a("TABLET", 2, "3");
            d = new a("TV", 3, "4");
            e = new a("SOUNDBOX", 4, "5");
            f = new a("GLASS", 5, "6");
            g = new a("WATCH", 6, "7");
            h = new a("VEHICLE", 7, "8");
            i = new a("OFFICE_DEVICE", 8, "9");
            j = new a("IOT_DEVICES", 9, "10");
            k = new a("HEALTHY", 10, "11");
            l = new a("ENTERTAINMENT", 11, "12");
            a aVar = new a("TRANSPORT_DEVICES", 12, "13");
            m = aVar;
            n = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, aVar};
        }

        public a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.o = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) n.clone();
            }
            return (a[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.o;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final /* synthetic */ b[] g;
        public transient /* synthetic */ FieldHolder $fh;
        public String h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(245286927, "Lcom/huawei/hms/opendevice/n$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(245286927, "Lcom/huawei/hms/opendevice/n$b;");
                    return;
                }
            }
            a = new b("IOS", 0, "ios");
            b = new b("ANDROID", 1, "android");
            c = new b("HARMONY", 2, "harmony");
            d = new b("WINDOWS", 3, "windows");
            e = new b("EMBED", 4, "embed");
            b bVar = new b("OTHERS", 5, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
            f = bVar;
            g = new b[]{a, b, c, d, e, bVar};
        }

        public b(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.h = str2;
        }

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (b) Enum.valueOf(b.class, str);
            }
            return (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (b[]) g.clone();
            }
            return (b[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.h;
            }
            return (String) invokeV.objValue;
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            new m(context, str).start();
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                HMSLog.e("ReportAaidToken", "Https response is empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(Constants.KEYS.RET, 256);
                if (optInt == 0) {
                    boolean saveString = i.a(context).saveString("reportAaidAndToken", r.a(str3 + str2, "SHA-256"));
                    StringBuilder sb = new StringBuilder();
                    sb.append("Report success ");
                    if (saveString) {
                        str4 = "and save success.";
                    } else {
                        str4 = "but save failure.";
                    }
                    sb.append(str4);
                    HMSLog.d("ReportAaidToken", sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Https response body's ret code: ");
                sb2.append(optInt);
                sb2.append(", error message: ");
                sb2.append(jSONObject.optString("msg"));
                HMSLog.e("ReportAaidToken", sb2.toString());
            } catch (JSONException unused) {
                HMSLog.e("ReportAaidToken", "Has JSONException.");
            } catch (Exception unused2) {
                HMSLog.e("ReportAaidToken", "Exception occur.");
            }
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
            HMSLog.d("ReportAaidToken", "NC version code: " + packageVersionCode);
            if ((90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(BaseStatisContent.TIMEZONE, TimeZone.getDefault().getID());
                jSONObject2.put("country", SystemUtils.getLocalCountry());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("agent_version", new PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
                jSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(context)));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("dev_type", a.a.a());
                jSONObject4.put("dev_sub_type", "phone");
                jSONObject4.put("os_type", b.b.a());
                jSONObject4.put(HttpConstants.OS_VERSION, String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
                jSONObject.put("id", UUID.randomUUID().toString());
                jSONObject.put("global", jSONObject2);
                jSONObject.put("push_agent", jSONObject3);
                jSONObject.put(HttpConstants.HTTP_HARDWARE, jSONObject4);
                jSONObject.put("aaid", str);
                jSONObject.put("token", str2);
                jSONObject.put("app_id", jza.c(context).a("client/app_id"));
                jSONObject.put("region", jza.c(context).a("region"));
                return jSONObject.toString();
            } catch (JSONException unused) {
                HMSLog.e("ReportAaidToken", "Catch JSONException.");
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, str2)) == null) {
            i a2 = i.a(context);
            if (!a2.containsKey("reportAaidAndToken")) {
                HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
                return true;
            }
            String string = a2.getString("reportAaidAndToken");
            if (TextUtils.isEmpty(string)) {
                HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
                return true;
            }
            return !string.equals(r.a(str2 + str, "SHA-256"));
        }
        return invokeLLL.booleanValue;
    }
}
