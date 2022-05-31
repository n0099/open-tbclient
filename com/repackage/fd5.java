package com.repackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class fd5 extends ImageSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Drawable> a;
    public int b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd5(Drawable drawable, int i) {
        super(drawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 1;
        this.c = i;
    }

    public final Drawable a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Drawable> weakReference = this.a;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable == null) {
                Drawable drawable2 = getDrawable();
                this.a = new WeakReference<>(drawable2);
                return drawable2;
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) || (a = a()) == null) {
            return;
        }
        int i6 = this.c;
        float f2 = i6 != 0 ? i6 != 1 ? i6 != 2 ? 0.0f : 0.2f : 0.15f : 0.1f;
        float height = f2 != 0.0f ? ((i4 - i5) + (a.getBounds().height() * f2)) - this.b : 0.0f;
        canvas.save();
        canvas.translate(a.getBounds().width() * 0.15f, height);
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            Drawable a = a();
            if (a == null) {
                return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
            }
            Rect bounds = a.getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = (bounds.bottom - bounds.top) / 2;
                int i5 = i3 / 4;
                int i6 = i4 - i5;
                int i7 = -(i4 + i5);
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
                fontMetricsInt.bottom = i6;
                fontMetricsInt.descent = i6;
            }
            return bounds.right;
        }
        return invokeCommon.intValue;
    }
}
