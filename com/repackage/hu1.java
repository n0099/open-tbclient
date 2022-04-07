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
/* loaded from: classes6.dex */
public class hu1 extends pt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;

    public hu1() {
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

    @Override // com.repackage.pt1
    public void a(qt1 qt1Var, Canvas canvas) {
        RectF rectF;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, qt1Var, canvas) == null) || (rectF = this.a) == null) {
            return;
        }
        qt1Var.f.addRect(rectF, Path.Direction.CW);
    }

    @Override // com.repackage.pt1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = ae3.g((float) jSONArray.optDouble(0));
                    int g2 = ae3.g((float) jSONArray.optDouble(1));
                    this.a = new RectF(g, g2, g + ae3.g((float) jSONArray.optDouble(2)), g2 + ae3.g((float) jSONArray.optDouble(3)));
                }
            } catch (Exception e) {
                if (tg1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
