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
import c.i.b.a.e0.a;
import c.i.b.a.e0.b;
import c.i.b.a.e0.j;
import c.i.b.a.g0.g;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class SubtitleView extends View implements j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<g> f69798e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f69799f;

    /* renamed from: g  reason: collision with root package name */
    public int f69800g;

    /* renamed from: h  reason: collision with root package name */
    public float f69801h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69802i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f69803j;
    public a k;
    public float l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubtitleView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    private a getUserCaptionStyleV19() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle()) : (a) invokeV.objValue;
    }

    public final void a(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.f69800g == i2 && this.f69801h == f2) {
                return;
            }
            this.f69800g = i2;
            this.f69801h = f2;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            List<b> list = this.f69799f;
            int i2 = 0;
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
            int i3 = this.f69800g;
            if (i3 == 2) {
                f2 = this.f69801h;
            } else {
                f2 = (i3 == 0 ? paddingBottom - paddingTop : bottom - top) * this.f69801h;
            }
            if (f2 <= 0.0f) {
                return;
            }
            while (i2 < size) {
                int i4 = paddingBottom;
                int i5 = right;
                this.f69798e.get(i2).b(this.f69799f.get(i2), this.f69802i, this.f69803j, this.k, f2, this.l, canvas, left, paddingTop, i5, i4);
                i2++;
                paddingBottom = i4;
                right = i5;
            }
        }
    }

    @Override // c.i.b.a.e0.j
    public void onCues(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            setCues(list);
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f69803j == z) {
            return;
        }
        this.f69803j = z;
        invalidate();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (this.f69802i == z && this.f69803j == z) {
                return;
            }
            this.f69802i = z;
            this.f69803j = z;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || this.l == f2) {
            return;
        }
        this.l = f2;
        invalidate();
    }

    public void setCues(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || this.f69799f == list) {
            return;
        }
        this.f69799f = list;
        int size = list == null ? 0 : list.size();
        while (this.f69798e.size() < size) {
            this.f69798e.add(new g(getContext()));
        }
        invalidate();
    }

    public void setFixedTextSize(int i2, float f2) {
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            Context context = getContext();
            if (context == null) {
                resources = Resources.getSystem();
            } else {
                resources = context.getResources();
            }
            a(2, TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
        }
    }

    public void setFractionalTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            setFractionalTextSize(f2, false);
        }
    }

    public void setStyle(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || this.k == aVar) {
            return;
        }
        this.k = aVar;
        invalidate();
    }

    public void setUserDefaultStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setStyle((v.f33623a < 19 || isInEditMode()) ? a.f33211g : getUserCaptionStyleV19());
        }
    }

    public void setUserDefaultTextSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setFractionalTextSize(((v.f33623a < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69798e = new ArrayList();
        this.f69800g = 0;
        this.f69801h = 0.0533f;
        this.f69802i = true;
        this.f69803j = true;
        this.k = a.f33211g;
        this.l = 0.08f;
    }

    public void setFractionalTextSize(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            a(z ? 1 : 0, f2);
        }
    }
}
