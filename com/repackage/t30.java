package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r30;
import com.repackage.u20;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t30 implements w30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t30() {
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

    @Override // com.repackage.w30
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? v20.b().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.w30
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            r30 r30Var = new r30();
            u20.e(context).j(r30Var);
            if (r30Var.b(10000)) {
                r30.b c = r30Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                r30Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.w30
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? u20.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // com.repackage.w30
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? u20.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // com.repackage.w30
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        u20.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            r30 r30Var = new r30();
            u20.e(context).n(r30Var);
            boolean b = r30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                r30.b c = r30Var.c();
                if (c != null && (t = c.a) != 0 && (eVar = (u20.e) t) != null && eVar.b() != null) {
                    for (u20.f fVar : eVar.b()) {
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
                r30Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.w30
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            r30 r30Var = new r30();
            u20.e(context).l(r30Var);
            if (r30Var.b(10000)) {
                r30.b c = r30Var.c();
                if (c != null && !TextUtils.isEmpty((CharSequence) c.a)) {
                    return (String) c.a;
                }
            } else {
                r30Var.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.w30
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<m50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            r30 r30Var = new r30();
            v20.b().e(context, r30Var);
            boolean b = r30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                r30.b c = r30Var.c();
                if (c != null && (t = c.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (m50 m50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", m50Var.a);
                            jSONObject.put("sigs", Arrays.toString(m50Var.b));
                            jSONObject.put("vc", m50Var.c);
                            jSONObject.put("va", m50Var.d);
                            jSONObject.put("installts", m50Var.e);
                            jSONObject.put("lstupdatets", m50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                r30Var.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.w30
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            r30 r30Var = new r30();
            v20.b().c(context, r30Var);
            boolean b = r30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                r30.b c = r30Var.c();
                if (c != null && (t = c.a) != 0) {
                    l50 l50Var = (l50) t;
                }
            } else {
                r30Var.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
