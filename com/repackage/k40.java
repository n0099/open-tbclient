package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i40;
import com.repackage.l30;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k40 implements n40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k40() {
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

    @Override // com.repackage.n40
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m30.b().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.n40
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            i40 i40Var = new i40();
            l30.e(context).j(i40Var);
            if (i40Var.b(10000)) {
                i40.b c = i40Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                i40Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.n40
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? l30.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.repackage.n40
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? l30.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.repackage.n40
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        l30.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            i40 i40Var = new i40();
            l30.e(context).n(i40Var);
            boolean b = i40Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                i40.b c = i40Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (l30.e) t) != null && eVar.b() != null) {
                    for (l30.f fVar : eVar.b()) {
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
                i40Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.n40
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            i40 i40Var = new i40();
            l30.e(context).l(i40Var);
            if (i40Var.b(10000)) {
                i40.b c = i40Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                i40Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.n40
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<d60> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            i40 i40Var = new i40();
            m30.b().e(context, i40Var);
            boolean b = i40Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                i40.b c = i40Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (d60 d60Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", d60Var.a);
                            jSONObject.put("sigs", Arrays.toString(d60Var.b));
                            jSONObject.put("vc", d60Var.c);
                            jSONObject.put("va", d60Var.d);
                            jSONObject.put("installts", d60Var.e);
                            jSONObject.put("lstupdatets", d60Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                i40Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.n40
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            i40 i40Var = new i40();
            m30.b().c(context, i40Var);
            boolean b = i40Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                i40.b c = i40Var.c();
                if (c != null && (t = c.a) != 0) {
                    c60 c60Var = (c60) t;
                }
            } else {
                i40Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
