package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class WarpLinearLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f35828a;

    /* renamed from: b  reason: collision with root package name */
    public float f35829b;

    /* renamed from: c  reason: collision with root package name */
    public float f35830c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35831d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f35832e;

    /* renamed from: com.kwad.sdk.contentalliance.tube.view.WarpLinearLayout$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WarpLinearLayout f35833a;

        /* renamed from: b  reason: collision with root package name */
        public List<View> f35834b;

        /* renamed from: c  reason: collision with root package name */
        public int f35835c;

        /* renamed from: d  reason: collision with root package name */
        public int f35836d;

        public a(WarpLinearLayout warpLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {warpLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35833a = warpLinearLayout;
            this.f35834b = new ArrayList();
            this.f35835c = this.f35833a.getPaddingLeft() + this.f35833a.getPaddingRight();
            this.f35836d = 0;
        }

        public /* synthetic */ a(WarpLinearLayout warpLinearLayout, AnonymousClass1 anonymousClass1) {
            this(warpLinearLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, view) == null) {
                if (this.f35834b.size() != 0) {
                    this.f35835c = (int) (this.f35835c + this.f35833a.f35829b);
                }
                this.f35836d = this.f35836d > view.getMeasuredHeight() ? this.f35836d : view.getMeasuredHeight();
                this.f35835c += view.getMeasuredWidth();
                this.f35834b.add(view);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WarpLinearLayout(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WarpLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WarpLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35828a = 1;
        this.f35829b = ao.a(getContext(), 8.0f);
        this.f35830c = ao.a(getContext(), 8.0f);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35831d : invokeV.booleanValue;
    }

    public int getGrivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35828a : invokeV.intValue;
    }

    public float getHorizontalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35829b : invokeV.floatValue;
    }

    public float getVerticalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35830c : invokeV.floatValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        float measuredWidth;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingTop = getPaddingTop();
            for (int i7 = 0; i7 < this.f35832e.size(); i7++) {
                int paddingLeft = getPaddingLeft();
                a aVar = this.f35832e.get(i7);
                int measuredWidth2 = getMeasuredWidth() - aVar.f35835c;
                for (int i8 = 0; i8 < aVar.f35834b.size(); i8++) {
                    View view = (View) aVar.f35834b.get(i8);
                    if (a()) {
                        view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft + (measuredWidth2 / aVar.f35834b.size()), view.getMeasuredHeight() + paddingTop);
                        f2 = paddingLeft;
                        measuredWidth = view.getMeasuredWidth() + this.f35829b;
                        f3 = measuredWidth2 / aVar.f35834b.size();
                    } else {
                        int grivate = getGrivate();
                        if (grivate == 0) {
                            i6 = paddingLeft + measuredWidth2;
                        } else if (grivate != 2) {
                            view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft, view.getMeasuredHeight() + paddingTop);
                            f2 = paddingLeft;
                            measuredWidth = view.getMeasuredWidth();
                            f3 = this.f35829b;
                        } else {
                            i6 = (measuredWidth2 / 2) + paddingLeft;
                        }
                        view.layout(i6, paddingTop, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + paddingTop);
                        f2 = paddingLeft;
                        measuredWidth = view.getMeasuredWidth();
                        f3 = this.f35829b;
                    }
                    paddingLeft = (int) (f2 + measuredWidth + f3);
                }
                paddingTop = (int) (paddingTop + aVar.f35836d + this.f35830c);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            int childCount = getChildCount();
            measureChildren(i2, i3);
            if (mode == Integer.MIN_VALUE) {
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    if (i5 != 0) {
                        i4 = (int) (i4 + this.f35829b);
                    }
                    i4 += getChildAt(i5).getMeasuredWidth();
                }
                int paddingLeft = i4 + getPaddingLeft() + getPaddingRight();
                if (paddingLeft <= size) {
                    size = paddingLeft;
                }
            } else if (mode == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < childCount; i7++) {
                    if (i7 != 0) {
                        i6 = (int) (i6 + this.f35829b);
                    }
                    i6 += getChildAt(i7).getMeasuredWidth();
                }
                size = i6 + getPaddingLeft() + getPaddingRight();
            }
            a aVar = new a(this, null);
            this.f35832e = new ArrayList();
            for (int i8 = 0; i8 < childCount; i8++) {
                if (aVar.f35835c + getChildAt(i8).getMeasuredWidth() + this.f35829b > size) {
                    if (aVar.f35834b.size() == 0) {
                        aVar.a(getChildAt(i8));
                        this.f35832e.add(aVar);
                        aVar = new a(this, null);
                    } else {
                        this.f35832e.add(aVar);
                        aVar = new a(this, null);
                    }
                }
                aVar.a(getChildAt(i8));
            }
            if (aVar.f35834b.size() > 0 && !this.f35832e.contains(aVar)) {
                this.f35832e.add(aVar);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            for (int i9 = 0; i9 < this.f35832e.size(); i9++) {
                if (i9 != 0) {
                    paddingTop = (int) (paddingTop + this.f35830c);
                }
                paddingTop += this.f35832e.get(i9).f35836d;
            }
            if (mode2 == Integer.MIN_VALUE ? paddingTop <= size2 : mode2 != 1073741824) {
                size2 = paddingTop;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setGrivate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f35828a = i2;
        }
    }

    public void setHorizontalSpace(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f35829b = f2;
        }
    }

    public void setIsFull(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f35831d = z;
        }
    }

    public void setVerticalSpace(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f35830c = f2;
        }
    }
}
