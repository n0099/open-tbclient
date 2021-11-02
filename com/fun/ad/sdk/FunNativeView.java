package com.fun.ad.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
/* loaded from: classes11.dex */
public final class FunNativeView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NativeAdContainer f62742a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62743b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunNativeView(@NonNull Context context) {
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
        a(context);
    }

    public static FunNativeView inflate(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            FunNativeView funNativeView = new FunNativeView(context);
            funNativeView.f62742a.addView(LayoutInflater.from(context).inflate(i2, (ViewGroup) funNativeView, false));
            return funNativeView;
        }
        return (FunNativeView) invokeLI.objValue;
    }

    public static FunNativeView inflate(Context context, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, view)) == null) {
            FunNativeView funNativeView = new FunNativeView(context);
            funNativeView.f62742a.addView(view);
            return funNativeView;
        }
        return (FunNativeView) invokeLL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62743b) {
            IllegalStateException illegalStateException = new IllegalStateException("Forbid add/rm view from FunNativeAdView.");
            if (FunAdSdk.isLogEnabled()) {
                throw illegalStateException;
            }
            LogPrinter.e(illegalStateException);
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            NativeAdContainer nativeAdContainer = new NativeAdContainer(context);
            this.f62742a = nativeAdContainer;
            addView(nativeAdContainer);
            this.f62743b = true;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, layoutParams) == null) {
            a();
            super.addView(view, i2, layoutParams);
        }
    }

    public ViewGroup getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62742a : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            super.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            super.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            a();
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            a();
            super.removeViewAt(i2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            a();
            super.removeViewInLayout(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            a();
            super.removeViews(i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            a();
            super.removeViewsInLayout(i2, i3);
        }
    }
}
