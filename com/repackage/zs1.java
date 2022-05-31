package com.repackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class zs1 extends ns1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public zs1() {
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

    @Override // com.repackage.ns1
    public void a(os1 os1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, os1Var, canvas) == null) || this.a == null) {
            return;
        }
        int alpha = os1Var.b.getAlpha();
        os1Var.c(os1Var.b);
        canvas.drawRect(this.a, os1Var.b);
        os1Var.b.setAlpha(alpha);
    }

    @Override // com.repackage.ns1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = yc3.g((float) jSONArray.optDouble(0));
                    int g2 = yc3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, yc3.g((float) jSONArray.optDouble(2)) + g, yc3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (rf1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
