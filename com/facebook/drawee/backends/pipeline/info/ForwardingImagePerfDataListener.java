package com.facebook.drawee.backends.pipeline.info;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes7.dex */
public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Collection mListeners;

    public ForwardingImagePerfDataListener(Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListeners = collection;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener
    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, imagePerfData, i) == null) {
            for (ImagePerfDataListener imagePerfDataListener : this.mListeners) {
                imagePerfDataListener.onImageLoadStatusUpdated(imagePerfData, i);
            }
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener
    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imagePerfData, i) == null) {
            for (ImagePerfDataListener imagePerfDataListener : this.mListeners) {
                imagePerfDataListener.onImageVisibilityUpdated(imagePerfData, i);
            }
        }
    }
}
