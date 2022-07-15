package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k20;
import com.repackage.n10;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m20 implements p20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m20() {
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

    @Override // com.repackage.p20
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? o10.b().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p20
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            k20 k20Var = new k20();
            n10.e(context).j(k20Var);
            if (k20Var.b(10000)) {
                k20.b c = k20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                k20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.p20
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? n10.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.repackage.p20
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? n10.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.repackage.p20
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        n10.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            k20 k20Var = new k20();
            n10.e(context).n(k20Var);
            boolean b = k20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                k20.b c = k20Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (n10.e) t) != null && eVar.b() != null) {
                    for (n10.f fVar : eVar.b()) {
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
                k20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.p20
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            k20 k20Var = new k20();
            n10.e(context).l(k20Var);
            if (k20Var.b(10000)) {
                k20.b c = k20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                k20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.p20
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<f40> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            k20 k20Var = new k20();
            o10.b().e(context, k20Var);
            boolean b = k20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                k20.b c = k20Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (f40 f40Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", f40Var.a);
                            jSONObject.put("sigs", Arrays.toString(f40Var.b));
                            jSONObject.put("vc", f40Var.c);
                            jSONObject.put("va", f40Var.d);
                            jSONObject.put("installts", f40Var.e);
                            jSONObject.put("lstupdatets", f40Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                k20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.p20
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            k20 k20Var = new k20();
            o10.b().c(context, k20Var);
            boolean b = k20Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                k20.b c = k20Var.c();
                if (c != null && (t = c.a) != 0) {
                    e40 e40Var = (e40) t;
                }
            } else {
                k20Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
