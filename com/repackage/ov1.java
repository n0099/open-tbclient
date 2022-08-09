package com.repackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class ov1 extends fu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;

    public ov1() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, gu1Var, canvas) == null) {
            if (gu1Var.a() == 0) {
                gu1Var.b(canvas.save());
            } else {
                canvas.restoreToCount(gu1Var.a());
                gu1Var.b(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.a, this.c, this.e, this.b, this.d, this.f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // com.repackage.fu1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.a = (float) jSONArray.optDouble(0);
                    this.b = (float) jSONArray.optDouble(1);
                    this.c = (float) jSONArray.optDouble(2);
                    this.d = (float) jSONArray.optDouble(3);
                    this.e = qe3.g((float) jSONArray.optDouble(4));
                    this.f = qe3.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e) {
                if (jh1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
