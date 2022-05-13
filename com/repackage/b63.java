package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b63 extends f63<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    public b63(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.r53
    /* renamed from: P */
    public JSONObject m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) ? s53.c(jSONObject) : (JSONObject) invokeL.objValue;
    }

    @Override // com.repackage.r53
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            u03 L = u03.L();
            if (L != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", L.N());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                v("data", jSONObject.toString());
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.f63
    public HttpRequest w(f63 f63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f63Var)) == null) ? bk2.o().M(this.m, f63Var.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // com.repackage.f63
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SwanInterfaceType.OPEN_ID : (SwanInterfaceType) invokeV.objValue;
    }
}
