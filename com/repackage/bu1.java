package com.repackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class bu1 extends ot1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;

    public bu1() {
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

    @Override // com.repackage.ot1
    public void a(pt1 pt1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, pt1Var, canvas) == null) || TextUtils.isEmpty(this.a)) {
            return;
        }
        TextPaint textPaint = pt1Var.e;
        int i = pt1Var.k;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f = fontMetrics.top;
        int i2 = this.c;
        float f2 = i2 + f;
        float f3 = fontMetrics.ascent + i2;
        float f4 = fontMetrics.bottom;
        float f5 = i != 1 ? i != 2 ? i != 3 ? i2 : i2 - (f3 - f2) : (i2 + ((f4 - f) / 2.0f)) - f4 : i2 + (((i2 + f4) - f2) / 2.0f) + (f3 - f2);
        int alpha = textPaint.getAlpha();
        pt1Var.c(textPaint);
        canvas.drawText(this.a, this.b, f5, textPaint);
        textPaint.setAlpha(alpha);
    }

    @Override // com.repackage.ot1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.b = zd3.g((float) jSONArray.optDouble(1));
                    this.c = zd3.g((float) jSONArray.optDouble(2));
                }
            } catch (Exception e) {
                if (sg1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
