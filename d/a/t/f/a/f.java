package d.a.t.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.b;
import d.a.t.f.a.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // d.a.t.f.a.i
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? d.a.t.b.d(context.getApplicationContext()).a() : (String) invokeL.objValue;
    }

    @Override // d.a.t.f.a.i
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        b.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d dVar2 = new d();
            d.a.t.b.d(context).k(dVar2);
            boolean d2 = dVar2.d(10000);
            JSONArray jSONArray = new JSONArray();
            if (d2) {
                d.b c2 = dVar2.c();
                if (c2 != null && (t = c2.f70295a) != 0 && (dVar = (b.d) t) != null && dVar.b() != null) {
                    for (b.e eVar : dVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", eVar.f70177b);
                            jSONObject.put("pkg", eVar.f70176a);
                            jSONObject.put("priority", eVar.f70178c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                dVar2.e();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // d.a.t.f.a.i
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            d dVar = new d();
            d.a.t.b.d(context).j(dVar);
            if (!dVar.d(10000)) {
                dVar.e();
                return null;
            }
            d.b c2 = dVar.c();
            if (c2 == null || TextUtils.isEmpty((CharSequence) c2.f70295a)) {
                return null;
            }
            return (String) c2.f70295a;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.t.f.a.i
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            d dVar = new d();
            d.a.t.b.d(context).h(dVar);
            if (!dVar.d(10000)) {
                dVar.e();
                return null;
            }
            d.b c2 = dVar.c();
            if (c2 == null || TextUtils.isEmpty((CharSequence) c2.f70295a)) {
                return null;
            }
            return (String) c2.f70295a;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.t.f.a.i
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? d.a.t.b.d(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }
}
