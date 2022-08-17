package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m20;
import com.repackage.p10;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o20 implements r20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o20() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.r20
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? q10.b().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.r20
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            m20 m20Var = new m20();
            p10.e(context).j(m20Var);
            if (m20Var.b(10000)) {
                m20.b c = m20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                m20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.r20
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? p10.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.repackage.r20
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? p10.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.repackage.r20
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        p10.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            m20 m20Var = new m20();
            p10.e(context).n(m20Var);
            boolean b = m20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                m20.b c = m20Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (p10.e) t) != null && eVar.b() != null) {
                    for (p10.f fVar : eVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", fVar.b);
                            jSONObject.put("pkg", fVar.a);
                            jSONObject.put("priority", fVar.c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                m20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.r20
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            m20 m20Var = new m20();
            p10.e(context).l(m20Var);
            if (m20Var.b(10000)) {
                m20.b c = m20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                m20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.r20
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<h40> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            m20 m20Var = new m20();
            q10.b().e(context, m20Var);
            boolean b = m20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                m20.b c = m20Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (h40 h40Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", h40Var.a);
                            jSONObject.put("sigs", Arrays.toString(h40Var.b));
                            jSONObject.put("vc", h40Var.c);
                            jSONObject.put("va", h40Var.d);
                            jSONObject.put("installts", h40Var.e);
                            jSONObject.put("lstupdatets", h40Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                m20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.r20
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            m20 m20Var = new m20();
            q10.b().c(context, m20Var);
            boolean b = m20Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                m20.b c = m20Var.c();
                if (c != null && (t = c.a) != 0) {
                    g40 g40Var = (g40) t;
                }
            } else {
                m20Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
