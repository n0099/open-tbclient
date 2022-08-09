package com.repackage;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class xu1 extends fu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;

    public xu1() {
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

    @Override // com.repackage.fu1
    public void a(gu1 gu1Var, Canvas canvas) {
        RectF rectF;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gu1Var, canvas) == null) || (rectF = this.a) == null) {
            return;
        }
        gu1Var.f.addRect(rectF, Path.Direction.CW);
    }

    @Override // com.repackage.fu1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = qe3.g((float) jSONArray.optDouble(0));
                    int g2 = qe3.g((float) jSONArray.optDouble(1));
                    this.a = new RectF(g, g2, g + qe3.g((float) jSONArray.optDouble(2)), g2 + qe3.g((float) jSONArray.optDouble(3)));
                }
            } catch (Exception e) {
                if (jh1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
