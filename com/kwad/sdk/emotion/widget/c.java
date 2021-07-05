package com.kwad.sdk.emotion.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class c extends ImageSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint.FontMetricsInt f37221a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Drawable> f37222b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Drawable drawable, String str, View view) {
        super(drawable, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, str, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37221a = new Paint.FontMetricsInt();
        drawable.setCallback(view);
    }

    private Drawable a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            WeakReference<Drawable> weakReference = this.f37222b;
            if (weakReference == null || weakReference.get() == null) {
                this.f37222b = new WeakReference<>(getDrawable());
            }
            return this.f37222b.get();
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            Drawable a2 = a();
            if (paint instanceof TextPaint) {
                a2.setState(((TextPaint) paint).drawableState);
            }
            int fontMetricsInt = paint.getFontMetricsInt(this.f37221a);
            canvas.save();
            canvas.translate(f2, i5 + this.f37221a.ascent + ((fontMetricsInt - (a2.getBounds().bottom - a2.getBounds().top)) / 2));
            a2.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            Rect bounds = a().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i5 = (bounds.bottom - bounds.top) / 2;
                int i6 = i4 / 4;
                int i7 = i5 - i6;
                int i8 = -(i5 + i6);
                fontMetricsInt.ascent = i8;
                fontMetricsInt.top = i8;
                fontMetricsInt.bottom = i7;
                fontMetricsInt.descent = i7;
            }
            return (int) (bounds.right * 1.1d);
        }
        return invokeCommon.intValue;
    }
}
