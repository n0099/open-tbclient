package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class InternalProducerListener implements ProducerListener2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ProducerListener mProducerListener;
    @Nullable
    public final ProducerListener2 mProducerListener2;

    public InternalProducerListener(ProducerListener producerListener, @Nullable ProducerListener2 producerListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producerListener, producerListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProducerListener = producerListener;
        this.mProducerListener2 = producerListener2;
    }

    public ProducerListener getProducerListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mProducerListener : (ProducerListener) invokeV.objValue;
    }

    @Nullable
    public ProducerListener2 getProducerListener2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mProducerListener2 : (ProducerListener2) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, imageRequest, encodedImage, th, map) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(ProducerContext producerContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, producerContext, str, str2) == null) {
            ProducerListener producerListener = this.mProducerListener;
            if (producerListener != null) {
                producerListener.onProducerEvent(producerContext.getId(), str, str2);
            }
            ProducerListener2 producerListener2 = this.mProducerListener2;
            if (producerListener2 != null) {
                producerListener2.onProducerEvent(producerContext, str, str2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, producerContext, str, map) == null) {
            ProducerListener producerListener = this.mProducerListener;
            if (producerListener != null) {
                producerListener.onProducerFinishWithCancellation(producerContext.getId(), str, map);
            }
            ProducerListener2 producerListener2 = this.mProducerListener2;
            if (producerListener2 != null) {
                producerListener2.onProducerFinishWithCancellation(producerContext, str, map);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, producerContext, str, th, map) == null) {
            ProducerListener producerListener = this.mProducerListener;
            if (producerListener != null) {
                producerListener.onProducerFinishWithFailure(producerContext.getId(), str, th, map);
            }
            ProducerListener2 producerListener2 = this.mProducerListener2;
            if (producerListener2 != null) {
                producerListener2.onProducerFinishWithFailure(producerContext, str, th, map);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, producerContext, str, map) == null) {
            ProducerListener producerListener = this.mProducerListener;
            if (producerListener != null) {
                producerListener.onProducerFinishWithSuccess(producerContext.getId(), str, map);
            }
            ProducerListener2 producerListener2 = this.mProducerListener2;
            if (producerListener2 != null) {
                producerListener2.onProducerFinishWithSuccess(producerContext, str, map);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(ProducerContext producerContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, producerContext, str) == null) {
            ProducerListener producerListener = this.mProducerListener;
            if (producerListener != null) {
                producerListener.onProducerStart(producerContext.getId(), str);
            }
            ProducerListener2 producerListener2 = this.mProducerListener2;
            if (producerListener2 != null) {
                producerListener2.onProducerStart(producerContext, str);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, producerContext, str, z) == null) {
            ProducerListener producerListener = this.mProducerListener;
            if (producerListener != null) {
                producerListener.onUltimateProducerReached(producerContext.getId(), str, z);
            }
            ProducerListener2 producerListener2 = this.mProducerListener2;
            if (producerListener2 != null) {
                producerListener2.onUltimateProducerReached(producerContext, str, z);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(ProducerContext producerContext, String str) {
        InterceptResult invokeLL;
        ProducerListener2 producerListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, producerContext, str)) == null) {
            ProducerListener producerListener = this.mProducerListener;
            boolean requiresExtraMap = producerListener != null ? producerListener.requiresExtraMap(producerContext.getId()) : false;
            return (requiresExtraMap || (producerListener2 = this.mProducerListener2) == null) ? requiresExtraMap : producerListener2.requiresExtraMap(producerContext, str);
        }
        return invokeLL.booleanValue;
    }
}
