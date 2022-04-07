package com.tachikoma.core.component.listview.viewpager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.exception.TKExceptionDispatcher;
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            executeJsFunction("onPageScrollStateChanged", Integer.valueOf(i));
        }
    }

    @Override // com.tachikoma.core.component.listview.viewpager.ITKOnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            executeJsFunction("onPageScrolled", Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2));
        }
    }

    @Override // com.tachikoma.core.component.listview.viewpager.ITKOnPageChangeCallback
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            executeJsFunction("onPageSelected", Integer.valueOf(i));
        }
    }
}
