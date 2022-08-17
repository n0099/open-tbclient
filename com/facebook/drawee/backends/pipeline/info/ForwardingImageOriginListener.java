package com.facebook.drawee.backends.pipeline.info;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ForwardingImageOriginListener";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(Set<ImageOriginListener> set) {
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
        this.mImageOriginListeners = new ArrayList(set);
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageOriginListener) == null) {
            synchronized (this) {
                this.mImageOriginListeners.add(imageOriginListener);
            }
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public synchronized void onImageLoaded(String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            synchronized (this) {
                int size = this.mImageOriginListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ImageOriginListener imageOriginListener = this.mImageOriginListeners.get(i2);
                    if (imageOriginListener != null) {
                        try {
                            imageOriginListener.onImageLoaded(str, i, z, str2);
                        } catch (Exception e) {
                            FLog.e(TAG, "InternalListener exception in onImageLoaded", e);
                        }
                    }
                }
            }
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageOriginListener) == null) {
            synchronized (this) {
                this.mImageOriginListeners.remove(imageOriginListener);
            }
        }
    }

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageOriginListenerArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.mImageOriginListeners = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }
}
