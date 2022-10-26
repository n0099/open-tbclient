package com.facebook.imagepipeline;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.producers.NetworkFetcher;
/* loaded from: classes7.dex */
public class ImagePipelineConfigProxy {
    public static /* synthetic */ Interceptable $ic;
    public static ImagePipelineConfig imagePipelineConfig;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface ImagePipelineConfig {
        NetworkFetcher getNetworkFetcher();
    }

    public ImagePipelineConfigProxy() {
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

    public static ImagePipelineConfig getImagePipelineConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return imagePipelineConfig;
        }
        return (ImagePipelineConfig) invokeV.objValue;
    }

    public static void setImagePipelineConfig(ImagePipelineConfig imagePipelineConfig2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, imagePipelineConfig2) == null) {
            imagePipelineConfig = imagePipelineConfig2;
        }
    }
}
