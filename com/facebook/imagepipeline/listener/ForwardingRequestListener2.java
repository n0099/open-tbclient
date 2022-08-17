package com.facebook.imagepipeline.listener;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ForwardingRequestListener2 implements RequestListener2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ForwardingRequestListener2";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<RequestListener2> mRequestListeners;

    public ForwardingRequestListener2(Set<RequestListener2> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestListeners = new ArrayList(set.size());
        for (RequestListener2 requestListener2 : set) {
            if (requestListener2 != null) {
                this.mRequestListeners.add(requestListener2);
            }
        }
    }

    private void onException(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, th) == null) {
            FLog.e(TAG, str, th);
        }
    }

    public void addRequestListener(RequestListener2 requestListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, requestListener2) == null) {
            this.mRequestListeners.add(requestListener2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest, encodedImage, th, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onDecoderFinishWithFailure(imageRequest, encodedImage, th, map);
                } catch (Exception e) {
                    onException("InternalListener exception in onProducerFinishWithFailure", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(ProducerContext producerContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, producerContext, str, str2) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onProducerEvent(producerContext, str, str2);
                } catch (Exception e) {
                    onException("InternalListener exception in onIntermediateChunkStart", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, producerContext, str, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onProducerFinishWithCancellation(producerContext, str, map);
                } catch (Exception e) {
                    onException("InternalListener exception in onProducerFinishWithCancellation", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, producerContext, str, th, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onProducerFinishWithFailure(producerContext, str, th, map);
                } catch (Exception e) {
                    onException("InternalListener exception in onProducerFinishWithFailure", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, producerContext, str, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onProducerFinishWithSuccess(producerContext, str, map);
                } catch (Exception e) {
                    onException("InternalListener exception in onProducerFinishWithSuccess", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(ProducerContext producerContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, producerContext, str) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onProducerStart(producerContext, str);
                } catch (Exception e) {
                    onException("InternalListener exception in onProducerStart", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, producerContext) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onRequestCancellation(producerContext);
                } catch (Exception e) {
                    onException("InternalListener exception in onRequestCancellation", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(ProducerContext producerContext, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, producerContext, th) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onRequestFailure(producerContext, th);
                } catch (Exception e) {
                    onException("InternalListener exception in onRequestFailure", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, producerContext) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onRequestStart(producerContext);
                } catch (Exception e) {
                    onException("InternalListener exception in onRequestStart", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, producerContext) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onRequestSuccess(producerContext);
                } catch (Exception e) {
                    onException("InternalListener exception in onRequestSuccess", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, producerContext, str, z) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRequestListeners.get(i).onUltimateProducerReached(producerContext, str, z);
                } catch (Exception e) {
                    onException("InternalListener exception in onProducerFinishWithSuccess", e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(ProducerContext producerContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, producerContext, str)) == null) {
            int size = this.mRequestListeners.size();
            for (int i = 0; i < size; i++) {
                if (this.mRequestListeners.get(i).requiresExtraMap(producerContext, str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public ForwardingRequestListener2(RequestListener2... requestListener2Arr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestListener2Arr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRequestListeners = new ArrayList(requestListener2Arr.length);
        for (RequestListener2 requestListener2 : requestListener2Arr) {
            if (requestListener2 != null) {
                this.mRequestListeners.add(requestListener2);
            }
        }
    }
}
