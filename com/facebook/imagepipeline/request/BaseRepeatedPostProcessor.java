package com.facebook.imagepipeline.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RepeatedPostprocessorRunner mCallback;

    public BaseRepeatedPostProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private synchronized RepeatedPostprocessorRunner getCallback() {
        InterceptResult invokeV;
        RepeatedPostprocessorRunner repeatedPostprocessorRunner;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (this) {
                repeatedPostprocessorRunner = this.mCallback;
            }
            return repeatedPostprocessorRunner;
        }
        return (RepeatedPostprocessorRunner) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.request.RepeatedPostprocessor
    public synchronized void setCallback(RepeatedPostprocessorRunner repeatedPostprocessorRunner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, repeatedPostprocessorRunner) == null) {
            synchronized (this) {
                this.mCallback = repeatedPostprocessorRunner;
            }
        }
    }

    public void update() {
        RepeatedPostprocessorRunner callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.update();
    }
}
