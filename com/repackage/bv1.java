package com.repackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class bv1 extends nt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;

    public bv1() {
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
        this.d = -1.0f;
        this.e = 0.0f;
        this.f = 1.0f;
    }

    @Override // com.repackage.nt1
    public void a(ot1 ot1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, ot1Var, canvas) == null) || TextUtils.isEmpty(this.a)) {
            return;
        }
        TextPaint textPaint = ot1Var.e;
        int i = ot1Var.k;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f = fontMetrics.top;
        int i2 = this.c;
        float f2 = i2 + f;
        float f3 = fontMetrics.ascent + i2;
        float f4 = fontMetrics.bottom;
        float f5 = i != 1 ? i != 2 ? i != 3 ? i2 : i2 - (f3 - f2) : (i2 + ((f4 - f) / 2.0f)) - f4 : i2 + (((i2 + f4) - f2) / 2.0f) + (f3 - f2);
        if (this.e == 0.0d) {
            Rect rect = new Rect();
            String str = this.a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.d != -1.0f) {
                float f6 = this.d;
                if (rect.width() > f6) {
                    this.e = f6 / rect.width();
                }
            }
            this.e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f);
        textPaint.setColor(ot1Var.m);
        ot1Var.c(textPaint);
        canvas.scale(this.e, 1.0f);
        canvas.drawText(this.a, this.b, f5, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // com.repackage.nt1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.b = yd3.g((float) jSONArray.optDouble(1));
                    this.c = yd3.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.d = yd3.g((float) jSONArray.optDouble(3));
                    }
                    this.f = yd3.g(1.0f);
                }
            } catch (Exception e) {
                if (rg1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
