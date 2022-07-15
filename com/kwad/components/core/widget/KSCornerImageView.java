package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.widget.h;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class KSCornerImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCornerImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCornerImageView(Context context, @Nullable AttributeSet attributeSet) {
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
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCornerImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public KSCornerImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a(context, attributeSet);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet) == null) {
            h.a aVar = new h.a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040348, R.attr.obfuscated_res_0x7f04036e, R.attr.obfuscated_res_0x7f040378, R.attr.obfuscated_res_0x7f04039d});
            aVar.a(obtainStyledAttributes.getBoolean(1, true));
            aVar.b(obtainStyledAttributes.getBoolean(3, true));
            aVar.c(obtainStyledAttributes.getBoolean(2, true));
            aVar.d(obtainStyledAttributes.getBoolean(0, true));
            obtainStyledAttributes.recycle();
            h hVar = new h(aVar);
            this.a = hVar;
            hVar.a(context, attributeSet);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.a.c(canvas);
            super.dispatchDraw(canvas);
            this.a.d(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.a.a(canvas);
            super.draw(canvas);
            this.a.b(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.a.a(i, i2);
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.a.a(f);
            postInvalidate();
        }
    }
}
