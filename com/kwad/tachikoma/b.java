package com.kwad.tachikoma;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.app.IAnimatedImage;
import com.kuaishou.tachikoma.api.app.IHostEnv;
import com.kuaishou.tachikoma.api.app.IHostService;
import com.kuaishou.tachikoma.api.app.WebImageHandler;
import com.kuaishou.tachikoma.api.model.TKCDNUrl;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements IHostService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kuaishou.tachikoma.api.app.IHostService
    public IAnimatedImage obtainAnimatedImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (IAnimatedImage) invokeV.objValue;
    }

    @Override // com.kuaishou.tachikoma.api.app.IHostService
    public IHostEnv obtainHostEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new IHostEnv(this) { // from class: com.kwad.tachikoma.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kuaishou.tachikoma.api.app.IHostEnv
            public boolean isDark() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.kuaishou.tachikoma.api.app.IHostEnv
            public boolean isDebug() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.kuaishou.tachikoma.api.app.IHostEnv
            public boolean isShowLog() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.d.a.a : invokeV2.booleanValue;
            }
        } : (IHostEnv) invokeV.objValue;
    }

    @Override // com.kuaishou.tachikoma.api.app.IHostService
    public WebImageHandler obtainWebImageService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new WebImageHandler(this) { // from class: com.kwad.tachikoma.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kuaishou.tachikoma.api.app.WebImageHandler
            public void load(ImageView imageView, String str, Drawable drawable, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLLI(1048576, this, imageView, str, drawable, i2) == null) {
                    KSImageLoader.loadImage(imageView, str, (AdTemplate) null, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnFail(drawable).showImageForEmptyUri(drawable).showImageOnLoading(drawable).build());
                }
            }

            @Override // com.kuaishou.tachikoma.api.app.WebImageHandler
            public void load(ImageView imageView, List<TKCDNUrl> list, int i2, int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageView, list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || list == null || list.isEmpty()) {
                    return;
                }
                KSImageLoader.loadImage(imageView, list.get(0).getUrl(), null);
            }

            @Override // com.kuaishou.tachikoma.api.app.WebImageHandler
            public void load(ImageView imageView, List<TKCDNUrl> list, int i2, int i3, Drawable drawable, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{imageView, list, Integer.valueOf(i2), Integer.valueOf(i3), drawable, Integer.valueOf(i4)}) == null) || list == null || list.isEmpty()) {
                    return;
                }
                KSImageLoader.loadImage(imageView, list.get(0).getUrl(), (AdTemplate) null, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnFail(drawable).showImageForEmptyUri(drawable).showImageOnLoading(drawable).build());
            }

            @Override // com.kuaishou.tachikoma.api.app.WebImageHandler
            public void load(String str, ImageView imageView, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048579, this, str, imageView, i2) == null) {
                    KSImageLoader.loadImage(imageView, str, null);
                }
            }
        } : (WebImageHandler) invokeV.objValue;
    }
}
