package com.repackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class zt4 extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public int b;
    public RectF c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Paint i;
    public String j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public boolean o;
    public int p;

    public zt4(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new float[8];
        this.c = new RectF();
        this.n = 255;
        this.o = false;
        this.p = 0;
        if (i2 > 0) {
            c(i2);
        }
        this.b = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.h = i7;
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setTextSize(this.d);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.n = (int) (f * 255.0f);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            Arrays.fill(this.a, i);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            float[] y = ur4.y(i);
            if (Arrays.equals(this.a, y)) {
                return;
            }
            this.a = y;
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.p = i;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int i6;
        int color;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            this.i.setColor(SkinManager.getColor(this.b));
            this.i.setAlpha(this.n);
            if (this.m) {
                this.i.setStyle(Paint.Style.FILL);
            } else {
                this.i.setStyle(Paint.Style.STROKE);
            }
            if (this.o) {
                RectF rectF = this.c;
                int i7 = this.k;
                rectF.left = f + i7;
                int i8 = this.p;
                rectF.top = (i4 - this.h) + i8;
                rectF.right = f + this.g + i7;
                rectF.bottom = i4 + i8;
            } else {
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                if (yr4.b(charSequence)) {
                    yr4.a(fontMetricsInt, (int) paint.getTextSize());
                    i6 = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                } else {
                    i6 = (((fontMetricsInt.descent - fontMetricsInt.ascent) - this.h) / 2) + 0;
                }
                int i9 = i6 + i4 + fontMetricsInt.ascent;
                RectF rectF2 = this.c;
                rectF2.left = f + this.k;
                rectF2.top = Math.max(i9, i4 + fontMetricsInt.top);
                RectF rectF3 = this.c;
                rectF3.right = f + this.g + this.k;
                rectF3.bottom = Math.min(i9 + this.h, i4 + fontMetricsInt.bottom);
            }
            String str = this.j;
            if (str != null) {
                if (" 吧主".equals(str)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else if (" 小吧主".equals(this.j)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else if (" 楼主".equals(this.j)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                }
                int i10 = color;
                int i11 = color2;
                RectF rectF4 = this.c;
                this.i.setShader(new LinearGradient(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, i10, i11, Shader.TileMode.CLAMP));
            }
            Path path = new Path();
            path.addRoundRect(this.c, this.a, Path.Direction.CW);
            canvas.drawPath(path, this.i);
            this.i.setShader(null);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if ((skinType == 1 || skinType == 4) && this.j != null) {
                this.i.setColor(SelectorHelper.getResources().getColor(R.color.obfuscated_res_0x7f060787));
                if (this.m) {
                    this.i.setStyle(Paint.Style.FILL);
                } else {
                    this.i.setStyle(Paint.Style.STROKE);
                }
                Path path2 = new Path();
                path2.addRoundRect(this.c, this.a, Path.Direction.CW);
                canvas.drawPath(path2, this.i);
            }
            Paint.FontMetricsInt fontMetricsInt2 = this.i.getFontMetricsInt();
            int i12 = this.e;
            if (i12 != 0) {
                this.i.setColor(SkinManager.getColor(i12));
            } else {
                this.i.setColor(SelectorHelper.getResources().getColor(R.color.CAM_X0201));
            }
            this.i.setStyle(Paint.Style.FILL);
            float centerY = this.c.centerY();
            int i13 = fontMetricsInt2.bottom;
            canvas.drawText(charSequence, i, i2, f + this.f + this.k, (int) ((centerY + ((i13 - fontMetricsInt2.top) / 2)) - i13), this.i);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.j = str;
        }
    }

    public void f(boolean z) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (paint = this.i) == null) {
            return;
        }
        this.m = z;
        if (z) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.o = z;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            int measureText = ((int) this.i.measureText(charSequence, i, i2)) + (this.f * 2);
            this.g = measureText;
            return measureText + this.k + this.l;
        }
        return invokeCommon.intValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.k = i;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.l = i;
        }
    }
}
