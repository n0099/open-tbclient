package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class BetterImageSpan extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mAlignment;
    public Rect mBounds;
    public final Drawable mDrawable;
    public final Paint.FontMetricsInt mFontMetricsInt;
    public int mHeight;
    public int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BetterImageSpanAlignment {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BetterImageSpan(Drawable drawable) {
        this(drawable, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getOffsetAboveBaseline(Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, fontMetricsInt)) == null) {
            int i2 = this.mAlignment;
            if (i2 != 0) {
                if (i2 != 2) {
                    return -this.mHeight;
                }
                int i3 = fontMetricsInt.descent;
                int i4 = fontMetricsInt.ascent;
                return i4 + (((i3 - i4) - this.mHeight) / 2);
            }
            return fontMetricsInt.descent - this.mHeight;
        }
        return invokeL.intValue;
    }

    public static final int normalizeAlignment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 != 0) {
                return i2 != 2 ? 1 : 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            paint.getFontMetricsInt(this.mFontMetricsInt);
            int offsetAboveBaseline = i5 + getOffsetAboveBaseline(this.mFontMetricsInt);
            canvas.translate(f2, offsetAboveBaseline);
            this.mDrawable.draw(canvas);
            canvas.translate(-f2, -offsetAboveBaseline);
        }
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDrawable : (Drawable) invokeV.objValue;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            updateBounds();
            if (fontMetricsInt == null) {
                return this.mWidth;
            }
            int offsetAboveBaseline = getOffsetAboveBaseline(fontMetricsInt);
            int i4 = this.mHeight + offsetAboveBaseline;
            if (offsetAboveBaseline < fontMetricsInt.ascent) {
                fontMetricsInt.ascent = offsetAboveBaseline;
            }
            if (offsetAboveBaseline < fontMetricsInt.top) {
                fontMetricsInt.top = offsetAboveBaseline;
            }
            if (i4 > fontMetricsInt.descent) {
                fontMetricsInt.descent = i4;
            }
            if (i4 > fontMetricsInt.bottom) {
                fontMetricsInt.bottom = i4;
            }
            return this.mWidth;
        }
        return invokeCommon.intValue;
    }

    public void updateBounds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Rect bounds = this.mDrawable.getBounds();
            this.mBounds = bounds;
            this.mWidth = bounds.width();
            this.mHeight = this.mBounds.height();
        }
    }

    public BetterImageSpan(Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFontMetricsInt = new Paint.FontMetricsInt();
        this.mDrawable = drawable;
        this.mAlignment = i2;
        updateBounds();
    }
}
