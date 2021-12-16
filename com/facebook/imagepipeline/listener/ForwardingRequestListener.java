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
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ForwardingRequestListener implements RequestListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ForwardingRequestListener";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<RequestListener> mRequestListeners;

    public ForwardingRequestListener(Set<RequestListener> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestListeners = new ArrayList(set.size());
        for (RequestListener requestListener : set) {
            if (requestListener != null) {
                this.mRequestListeners.add(requestListener);
            }
        }
    }

    private void onException(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, th) == null) {
            FLog.e(TAG, str, th);
        }
    }

    public void addRequestListener(RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, requestListener) == null) {
            this.mRequestListeners.add(requestListener);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest, encodedImage, th, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onDecoderFinishWithFailure(imageRequest, encodedImage, th, map);
                } catch (Exception e2) {
                    onException("InternalListener exception in onProducerFinishWithFailure", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onProducerEvent(str, str2, str3);
                } catch (Exception e2) {
                    onException("InternalListener exception in onIntermediateChunkStart", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String str, String str2, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onProducerFinishWithCancellation(str, str2, map);
                } catch (Exception e2) {
                    onException("InternalListener exception in onProducerFinishWithCancellation", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, th, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onProducerFinishWithFailure(str, str2, th, map);
                } catch (Exception e2) {
                    onException("InternalListener exception in onProducerFinishWithFailure", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String str, String str2, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, map) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onProducerFinishWithSuccess(str, str2, map);
                } catch (Exception e2) {
                    onException("InternalListener exception in onProducerFinishWithSuccess", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onProducerStart(str, str2);
                } catch (Exception e2) {
                    onException("InternalListener exception in onProducerStart", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onRequestCancellation(str);
                } catch (Exception e2) {
                    onException("InternalListener exception in onRequestCancellation", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{imageRequest, str, th, Boolean.valueOf(z)}) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onRequestFailure(imageRequest, str, th, z);
                } catch (Exception e2) {
                    onException("InternalListener exception in onRequestFailure", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{imageRequest, obj, str, Boolean.valueOf(z)}) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onRequestStart(imageRequest, obj, str, z);
                } catch (Exception e2) {
                    onException("InternalListener exception in onRequestStart", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, imageRequest, str, z) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onRequestSuccess(imageRequest, str, z);
                } catch (Exception e2) {
                    onException("InternalListener exception in onRequestSuccess", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, str, str2, z) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRequestListeners.get(i2).onUltimateProducerReached(str, str2, z);
                } catch (Exception e2) {
                    onException("InternalListener exception in onProducerFinishWithSuccess", e2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            int size = this.mRequestListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mRequestListeners.get(i2).requiresExtraMap(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ForwardingRequestListener(RequestListener... requestListenerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestListenerArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRequestListeners = new ArrayList(requestListenerArr.length);
        for (RequestListener requestListener : requestListenerArr) {
            if (requestListener != null) {
                this.mRequestListeners.add(requestListener);
            }
        }
    }
}
