package d.a.m0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f43593a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43594b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43595c;

    /* renamed from: d  reason: collision with root package name */
    public static String f43596d;

    /* renamed from: e  reason: collision with root package name */
    public static String f43597e;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f43593a)) {
                    f43593a = d.a.m0.l.c.e(context);
                }
                return TextUtils.isEmpty(f43593a) ? "" : f43593a;
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", b(context));
                jSONObject.put("3", d(context));
                jSONObject.put("2", f(context));
                jSONObject.put("4", g(context));
                jSONObject.put("5", str);
                jSONObject.put("6", System.currentTimeMillis());
                jSONObject.put("7", "0");
                jSONObject.put("8", d.a.m0.a.f43422b);
                jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("10", "1.0.7");
                jSONObject.put("14", d.a.m0.l.c.j(context));
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, e(context));
                jSONObject.put("26", d.a.m0.g.a.a(context));
                jSONObject.put(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, d.a.m0.b.a.h(context).J());
                return jSONObject;
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f43594b)) {
                    f43594b = d.a.m0.l.c.h(context);
                }
                return TextUtils.isEmpty(f43594b) ? "" : f43594b;
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(f43597e)) {
                    return f43597e;
                }
                String b2 = d.a.m0.g.a.b(context, true, false);
                f43597e = b2;
                return b2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f43595c)) {
                    f43595c = context.getPackageName();
                }
                return TextUtils.isEmpty(f43595c) ? "" : f43595c;
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(f43596d)) {
                    return f43596d;
                }
                String j = d.a.m0.l.d.j(context);
                f43596d = j;
                return j;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public d.a.m0.j.a a(Context context, String str, String str2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(str);
                JSONObject c2 = c(context, str2);
                c2.put("module_section", jSONArray);
                d.a.m0.j.a aVar = new d.a.m0.j.a();
                aVar.e(i2);
                aVar.c(c2.toString());
                aVar.g(i3);
                return aVar;
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return null;
            }
        }
        return (d.a.m0.j.a) invokeCommon.objValue;
    }
}
