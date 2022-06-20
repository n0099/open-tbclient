package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i20;
import com.repackage.l10;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k20 implements n20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k20() {
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

    @Override // com.repackage.n20
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m10.b().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.n20
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            i20 i20Var = new i20();
            l10.e(context).j(i20Var);
            if (i20Var.b(10000)) {
                i20.b c = i20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                i20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.n20
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? l10.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.repackage.n20
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? l10.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.repackage.n20
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        l10.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            i20 i20Var = new i20();
            l10.e(context).n(i20Var);
            boolean b = i20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                i20.b c = i20Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (l10.e) t) != null && eVar.b() != null) {
                    for (l10.f fVar : eVar.b()) {
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
                i20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.n20
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            i20 i20Var = new i20();
            l10.e(context).l(i20Var);
            if (i20Var.b(10000)) {
                i20.b c = i20Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                i20Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.n20
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<d40> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            i20 i20Var = new i20();
            m10.b().e(context, i20Var);
            boolean b = i20Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                i20.b c = i20Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (d40 d40Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", d40Var.a);
                            jSONObject.put("sigs", Arrays.toString(d40Var.b));
                            jSONObject.put("vc", d40Var.c);
                            jSONObject.put("va", d40Var.d);
                            jSONObject.put("installts", d40Var.e);
                            jSONObject.put("lstupdatets", d40Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                i20Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.n20
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            i20 i20Var = new i20();
            m10.b().c(context, i20Var);
            boolean b = i20Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                i20.b c = i20Var.c();
                if (c != null && (t = c.a) != 0) {
                    c40 c40Var = (c40) t;
                }
            } else {
                i20Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
