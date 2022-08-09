package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class SubtitleView extends View implements TextOutput {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ABSOLUTE = 2;
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int FRACTIONAL = 0;
    public static final int FRACTIONAL_IGNORE_PADDING = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean applyEmbeddedFontSizes;
    public boolean applyEmbeddedStyles;
    public float bottomPaddingFraction;
    public List<Cue> cues;
    public final List<SubtitlePainter> painters;
    public CaptionStyleCompat style;
    public float textSize;
    public int textSizeType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubtitleView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale() : invokeV.floatValue;
    }

    @TargetApi(19)
    private CaptionStyleCompat getUserCaptionStyleV19() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? CaptionStyleCompat.createFromCaptionStyle(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle()) : (CaptionStyleCompat) invokeV.objValue;
    }

    private void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            if (this.textSizeType == i && this.textSize == f) {
                return;
            }
            this.textSizeType = i;
            this.textSize = f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            List<Cue> list = this.cues;
            int i = 0;
            int size = list == null ? 0 : list.size();
            int top = getTop();
            int bottom = getBottom();
            int left = getLeft() + getPaddingLeft();
            int paddingTop = getPaddingTop() + top;
            int right = getRight() + getPaddingRight();
            int paddingBottom = bottom - getPaddingBottom();
            if (paddingBottom <= paddingTop || right <= left) {
                return;
            }
            int i2 = this.textSizeType;
            if (i2 == 2) {
                f = this.textSize;
            } else {
                f = (i2 == 0 ? paddingBottom - paddingTop : bottom - top) * this.textSize;
            }
            if (f <= 0.0f) {
                return;
            }
            while (i < size) {
                int i3 = paddingBottom;
                int i4 = right;
                this.painters.get(i).draw(this.cues.get(i), this.applyEmbeddedStyles, this.applyEmbeddedFontSizes, this.style, f, this.bottomPaddingFraction, canvas, left, paddingTop, i4, i3);
                i++;
                paddingBottom = i3;
                right = i4;
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public void onCues(List<Cue> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            setCues(list);
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedFontSizes = z;
        invalidate();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z) {
                return;
            }
            this.applyEmbeddedStyles = z;
            this.applyEmbeddedFontSizes = z;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f) == null) || this.bottomPaddingFraction == f) {
            return;
        }
        this.bottomPaddingFraction = f;
        invalidate();
    }

    public void setCues(List<Cue> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || this.cues == list) {
            return;
        }
        this.cues = list;
        int size = list == null ? 0 : list.size();
        while (this.painters.size() < size) {
            this.painters.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    public void setFixedTextSize(int i, float f) {
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            Context context = getContext();
            if (context == null) {
                resources = Resources.getSystem();
            } else {
                resources = context.getResources();
            }
            setTextSize(2, TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
        }
    }

    public void setFractionalTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            setFractionalTextSize(f, false);
        }
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, captionStyleCompat) == null) || this.style == captionStyleCompat) {
            return;
        }
        this.style = captionStyleCompat;
        invalidate();
    }

    public void setUserDefaultStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setStyle((Util.SDK_INT < 19 || isInEditMode()) ? CaptionStyleCompat.DEFAULT : getUserCaptionStyleV19());
        }
    }

    public void setUserDefaultTextSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setFractionalTextSize(((Util.SDK_INT < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.painters = new ArrayList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
    }

    public void setFractionalTextSize(float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            setTextSize(z ? 1 : 0, f);
        }
    }
}
