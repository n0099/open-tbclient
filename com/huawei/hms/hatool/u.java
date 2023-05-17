package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public List<q> d;
    public String e;

    public u(String str, String str2, String str3, List<q> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, list, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = str4;
    }

    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String f = c.f(str, str2);
            if (TextUtils.isEmpty(f)) {
                y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
                return "";
            }
            if ("oper".equals(str2)) {
                str3 = "{url}/common/hmshioperqrt";
            } else if ("maint".equals(str2)) {
                str3 = "{url}/common/hmshimaintqrt";
            } else if (!"diffprivacy".equals(str2)) {
                return "";
            } else {
                str3 = "{url}/common/common2";
            }
            return str3.replace("{url}", f);
        }
        return (String) invokeLL.objValue;
    }

    public void a() {
        n0 l0Var;
        o0 c;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String a = a(this.a, this.b);
            if (!TextUtils.isEmpty(a) || "preins".equals(this.b)) {
                if (!"_hms_config_tag".equals(this.a) && !"_openness_config_tag".equals(this.a)) {
                    b();
                }
                r d = d();
                if (d != null) {
                    byte[] a2 = a(d);
                    if (a2.length == 0) {
                        str = "request body is empty";
                    } else {
                        l0Var = new i0(a2, a, this.a, this.b, this.e, this.d);
                        c = o0.b();
                    }
                } else {
                    l0Var = new l0(this.d, this.a, this.e, this.b);
                    c = o0.c();
                }
                c.a(l0Var);
                return;
            }
            str = "collectUrl is empty";
            y.e("hmsSdk", str);
        }
    }

    public final byte[] a(r rVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rVar)) == null) {
            try {
                JSONObject a = rVar.a();
                if (a == null) {
                    y.e("hmsSdk", "uploadEvents is null");
                    return new byte[0];
                }
                return t0.a(a.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                str = "sendData(): getBytes - Unsupported coding format!!";
                y.e("hmsSdk", str);
                return new byte[0];
            } catch (JSONException unused2) {
                str = "uploadEvents to json error";
                y.e("hmsSdk", str);
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (q0.a(b.i(), "backup_event", 5242880)) {
                y.d("hmsSdk", "backup file reach max limited size, discard new event ");
                return;
            }
            JSONArray c = c();
            String a = u0.a(this.a, this.b, this.e);
            y.c("hmsSdk", "Update data cached into backup,spKey: " + a);
            g0.b(b.i(), "backup_event", a, c.toString());
        }
    }

    public final JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (q qVar : this.d) {
                try {
                    jSONArray.put(qVar.d());
                } catch (JSONException unused) {
                    y.c("hmsSdk", "handleEvents: json error,Abandon this data");
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final r d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? d1.a(this.d, this.a, this.b, this.e, this.c) : (r) invokeV.objValue;
    }
}
