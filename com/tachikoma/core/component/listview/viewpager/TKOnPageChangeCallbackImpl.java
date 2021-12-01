package com.tachikoma.core.component.listview.viewpager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.exception.TKExceptionDispatcher;
/* loaded from: classes2.dex */
public class TKOnPageChangeCallbackImpl implements ITKOnPageChangeCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TKJSContext mTKJSContext;
    public final V8Object mTKOnChangeCallback;

    public TKOnPageChangeCallbackImpl(V8Object v8Object, TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object, tKJSContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTKJSContext = tKJSContext;
        this.mTKOnChangeCallback = v8Object.twin();
    }

    private void executeJsFunction(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, objArr) == null) {
            try {
                this.mTKOnChangeCallback.executeJSFunction(str, objArr);
            } catch (Throwable th) {
                TKExceptionDispatcher.dispatchJSException(th, "executeJsFunction: name is " + str, this.mTKJSContext.hashCode());
            }
        }
    }

    @Override // com.tachikoma.core.component.listview.viewpager.ITKOnPageChangeCallback
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            executeJsFunction("onPageScrollStateChanged", Integer.valueOf(i2));
        }
    }

    @Override // com.tachikoma.core.component.listview.viewpager.ITKOnPageChangeCallback
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            executeJsFunction("onPageScrolled", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        }
    }

    @Override // com.tachikoma.core.component.listview.viewpager.ITKOnPageChangeCallback
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            executeJsFunction("onPageSelected", Integer.valueOf(i2));
        }
    }
}
