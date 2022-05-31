package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e20;
import com.repackage.h10;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g20 implements j20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g20() {
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

    @Override // com.repackage.j20
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? i10.b().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.j20
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            e20 e20Var = new e20();
            h10.e(context).j(e20Var);
            if (e20Var.b(10000)) {
                e20.b c = e20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                e20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.j20
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? h10.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.repackage.j20
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? h10.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.repackage.j20
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        h10.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            e20 e20Var = new e20();
            h10.e(context).n(e20Var);
            boolean b = e20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                e20.b c = e20Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (h10.e) t) != null && eVar.b() != null) {
                    for (h10.f fVar : eVar.b()) {
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
                e20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.j20
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            e20 e20Var = new e20();
            h10.e(context).l(e20Var);
            if (e20Var.b(10000)) {
                e20.b c = e20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                e20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.j20
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<z30> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            e20 e20Var = new e20();
            i10.b().e(context, e20Var);
            boolean b = e20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                e20.b c = e20Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (z30 z30Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", z30Var.a);
                            jSONObject.put("sigs", Arrays.toString(z30Var.b));
                            jSONObject.put("vc", z30Var.c);
                            jSONObject.put("va", z30Var.d);
                            jSONObject.put("installts", z30Var.e);
                            jSONObject.put("lstupdatets", z30Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                e20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.j20
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            e20 e20Var = new e20();
            i10.b().c(context, e20Var);
            boolean b = e20Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                e20.b c = e20Var.c();
                if (c != null && (t = c.a) != 0) {
                    y30 y30Var = (y30) t;
                }
            } else {
                e20Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
