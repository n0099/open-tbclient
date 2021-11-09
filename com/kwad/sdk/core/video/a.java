package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends TextureView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65058a;

    /* renamed from: b  reason: collision with root package name */
    public int f65059b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f65059b == i2 || this.f65058a == i3) {
            return;
        }
        this.f65059b = i2;
        this.f65058a = i3;
        requestLayout();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            float rotation = getRotation();
            if (rotation == 90.0f || rotation == 270.0f) {
                i3 = i2;
                i2 = i3;
            }
            int defaultSize = TextureView.getDefaultSize(this.f65059b, i2);
            int defaultSize2 = TextureView.getDefaultSize(this.f65058a, i3);
            if (this.f65059b > 0 && this.f65058a > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i5 = this.f65059b;
                    int i6 = i5 * size2;
                    int i7 = this.f65058a;
                    if (i6 < size * i7) {
                        defaultSize = (i5 * size2) / i7;
                    } else if (i5 * size2 > size * i7) {
                        defaultSize2 = (i7 * size) / i5;
                        defaultSize = size;
                    } else {
                        defaultSize = size;
                    }
                    defaultSize2 = size2;
                } else if (mode == 1073741824) {
                    int i8 = this.f65058a;
                    int i9 = this.f65059b;
                    int i10 = (size * i8) / i9;
                    if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                        defaultSize = size;
                        defaultSize2 = i10;
                    } else {
                        defaultSize = (i9 * size2) / i8;
                        defaultSize2 = size2;
                    }
                } else if (mode2 == 1073741824) {
                    int i11 = this.f65059b;
                    int i12 = this.f65058a;
                    i4 = (size2 * i11) / i12;
                    if (mode != Integer.MIN_VALUE || i4 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i4;
                    } else {
                        defaultSize2 = (i12 * size) / i11;
                        defaultSize = size;
                    }
                } else {
                    i4 = this.f65059b;
                    int i13 = this.f65058a;
                    if (mode2 != Integer.MIN_VALUE || i13 <= size2) {
                        defaultSize2 = i13;
                    } else {
                        i4 = (i4 * size2) / i13;
                        defaultSize2 = size2;
                    }
                    if (mode == Integer.MIN_VALUE && i4 > size) {
                        defaultSize2 = (this.f65058a * size) / this.f65059b;
                        defaultSize = size;
                    }
                    defaultSize = i4;
                }
            }
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) || f2 == getRotation()) {
            return;
        }
        super.setRotation(f2);
        requestLayout();
    }
}
