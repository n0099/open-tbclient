package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
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
    public boolean f36759a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f36760b;

    /* renamed from: c  reason: collision with root package name */
    public Paint.FontMetricsInt f36761c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Drawable> f36762d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Drawable drawable, String str) {
        super(drawable, str, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36759a = true;
        this.f36761c = new Paint.FontMetricsInt();
    }

    private Drawable a(Paint paint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, paint)) == null) {
            WeakReference<Drawable> weakReference = this.f36762d;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable == null) {
                drawable = getDrawable();
                if (this.f36759a) {
                    int fontMetricsInt = paint.getFontMetricsInt(null);
                    drawable.setBounds(0, 0, fontMetricsInt, fontMetricsInt);
                } else {
                    Rect rect = this.f36760b;
                    if (rect != null) {
                        drawable.setBounds(rect);
                    }
                }
                this.f36762d = new WeakReference<>(drawable);
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public c a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            this.f36759a = false;
            this.f36760b = new Rect(0, 0, i2, i3);
            return this;
        }
        return (c) invokeII.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            Drawable a2 = a(paint);
            if (paint instanceof TextPaint) {
                a2.setState(((TextPaint) paint).drawableState);
            }
            int fontMetricsInt = paint.getFontMetricsInt(this.f36761c);
            canvas.save();
            canvas.translate(f2, i5 + this.f36761c.ascent + ((fontMetricsInt - (a2.getBounds().bottom - a2.getBounds().top)) / 2));
            a2.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            Rect bounds = a(paint).getBounds();
            if (fontMetricsInt != null) {
                paint.getFontMetricsInt(fontMetricsInt);
                fontMetricsInt.ascent = fontMetricsInt.ascent;
                fontMetricsInt.descent = fontMetricsInt.descent;
                fontMetricsInt.top = fontMetricsInt.top;
                fontMetricsInt.bottom = fontMetricsInt.bottom;
            }
            return bounds.right;
        }
        return invokeCommon.intValue;
    }
}
