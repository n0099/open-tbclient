package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʿʿ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0397 extends C0375 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f376;

    public C0397(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(C0331.f78).intValue();
                String m520 = m520(context);
                if (TextUtils.isEmpty(m520)) {
                    return;
                }
                String eopq = engine.eopq(intValue, 0, i, m520);
                if (TextUtils.isEmpty(eopq)) {
                    return;
                }
                this.f376 = new JSONObject(eopq);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private String m520(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                C0374 m389 = C0374.m389(context);
                sb.append(m389.m392(C0374.f225, 1));
                sb.append(m389.m392(C0374.f222, 1));
                sb.append(m389.m392(C0374.f314, 1));
                sb.append(m389.m392(C0374.f224, 1));
                sb.append(m389.m392(C0374.f226, 1));
                sb.append(m389.m392(C0374.f228, 1));
                sb.append(m389.m392(C0374.f223, 1));
                sb.append(m389.m392(C0374.f328, 1));
                sb.append(m389.m392(C0374.f231, 1));
                sb.append(m389.m392(C0374.f229, 1));
                sb.append(m389.m392(C0374.f230, 1));
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m521(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.f376;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    String replaceAll = string.replaceAll("\\n", "");
                    if (!TextUtils.isEmpty(replaceAll)) {
                        string = replaceAll;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 1) {
                        return jSONArray;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m522() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f376 : (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject m523(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            JSONObject jSONObject = this.f376;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string) || string.length() <= 2) {
                        return null;
                    }
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2.length() > 1) {
                        return jSONObject2;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m524(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            JSONObject jSONObject = this.f376;
            if (jSONObject != null) {
                try {
                    return jSONObject.getString(str);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public String m525(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONObject jSONObject = this.f376;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    return !TextUtils.isEmpty(string) ? string.replace("\n", "").replace("\t", " ") : string;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public String m526(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            JSONObject jSONObject = this.f376;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    if (string.length() > 2) {
                        return string;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
