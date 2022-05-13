package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ax1 extends dw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax1() {
        super("coverImage", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
    }

    @Override // com.repackage.dw1, com.repackage.iw1, com.repackage.kw1, com.repackage.tq2
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.u = jSONObject.optBoolean("loadState", false);
        ar2 ar2Var = this.h;
        if (ar2Var == null || (jSONObject2 = this.j) == null) {
            return;
        }
        ar2Var.i(jSONObject2.optBoolean("fixed", false));
    }
}
