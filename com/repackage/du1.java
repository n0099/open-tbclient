package com.repackage;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class du1 extends nt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public du1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Integer.MAX_VALUE;
        this.b = Integer.MAX_VALUE;
    }

    @Override // com.repackage.nt1
    public void a(ot1 ot1Var, Canvas canvas) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, ot1Var, canvas) == null) || (i = this.a) == Integer.MAX_VALUE || (i2 = this.b) == Integer.MAX_VALUE) {
            return;
        }
        ot1Var.f.moveTo(i, i2);
    }

    @Override // com.repackage.nt1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 1) {
            return;
        }
        this.a = yd3.g((float) jSONArray.optDouble(0));
        this.b = yd3.g((float) jSONArray.optDouble(1));
    }
}
