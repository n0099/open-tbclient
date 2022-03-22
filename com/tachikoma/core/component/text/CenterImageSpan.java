package com.tachikoma.core.component.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CenterImageSpan extends ImageSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Drawable> mDrawableRef;
    public boolean mFitTextLine;
    public Paint.FontMetricsInt mFm;
    public Rect mImageRect;
    public float mMarginLeft;
    public float mMarginRight;
    public float mOffsetY;
    public Object mTag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterImageSpan(Drawable drawable, String str) {
        super(drawable, str, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFitTextLine = true;
        this.mFm = new Paint.FontMetricsInt();
    }

    private Drawable getCachedDrawable(Paint paint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, paint)) == null) {
            WeakReference<Drawable> weakReference = this.mDrawableRef;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable == null) {
                drawable = getDrawable();
                if (this.mFitTextLine) {
                    int fontMetricsInt = paint.getFontMetricsInt(null);
                    drawable.setBounds(0, 0, fontMetricsInt, fontMetricsInt);
                } else {
                    Rect rect = this.mImageRect;
                    if (rect != null) {
                        drawable.setBounds(rect);
                    }
                }
                this.mDrawableRef = new WeakReference<>(drawable);
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable cachedDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) || (cachedDrawable = getCachedDrawable(paint)) == null) {
            return;
        }
        if (paint instanceof TextPaint) {
            cachedDrawable.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = paint.getFontMetricsInt(this.mFm);
        canvas.save();
        canvas.translate(f2 + this.mMarginLeft, i4 + this.mFm.ascent + ((fontMetricsInt - (cachedDrawable.getBounds().bottom - cachedDrawable.getBounds().top)) / 2) + this.mOffsetY);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            Drawable cachedDrawable = getCachedDrawable(paint);
            if (cachedDrawable == null) {
                return 0;
            }
            Rect bounds = cachedDrawable.getBounds();
            if (fontMetricsInt != null) {
                paint.getFontMetricsInt(fontMetricsInt);
                fontMetricsInt.ascent = fontMetricsInt.ascent;
                fontMetricsInt.descent = fontMetricsInt.descent;
                fontMetricsInt.top = fontMetricsInt.top;
                fontMetricsInt.bottom = fontMetricsInt.bottom;
            }
            return (int) (bounds.right + this.mMarginRight + this.mMarginLeft);
        }
        return invokeCommon.intValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTag : invokeV.objValue;
    }

    public CenterImageSpan setFitTextLine(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.mFitTextLine = z;
            return this;
        }
        return (CenterImageSpan) invokeZ.objValue;
    }

    public CenterImageSpan setImageRect(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            this.mFitTextLine = false;
            this.mImageRect = new Rect(0, 0, i, i2);
            return this;
        }
        return (CenterImageSpan) invokeII.objValue;
    }

    public CenterImageSpan setImageRect(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rect)) == null) {
            this.mFitTextLine = false;
            this.mImageRect = rect;
            return this;
        }
        return (CenterImageSpan) invokeL.objValue;
    }

    public CenterImageSpan setMarginLeft(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            this.mMarginLeft = f2;
            return this;
        }
        return (CenterImageSpan) invokeF.objValue;
    }

    public CenterImageSpan setMarginRight(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f2)) == null) {
            this.mMarginRight = f2;
            return this;
        }
        return (CenterImageSpan) invokeF.objValue;
    }

    public CenterImageSpan setOffsetY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2)) == null) {
            this.mOffsetY = f2;
            return this;
        }
        return (CenterImageSpan) invokeF.objValue;
    }

    public CenterImageSpan setTag(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            this.mTag = obj;
            return this;
        }
        return (CenterImageSpan) invokeL.objValue;
    }
}
