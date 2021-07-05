package com.kwad.sdk.glide.load.resource.bitmap;

import android.media.ExifInterface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
@RequiresApi(27)
/* loaded from: classes7.dex */
public final class n implements ImageHeaderParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
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

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, inputStream, bVar)) == null) {
            int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
            if (attributeInt == 0) {
                return -1;
            }
            return attributeInt;
        }
        return invokeLL.intValue;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) ? ImageHeaderParser.ImageType.UNKNOWN : (ImageHeaderParser.ImageType) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) ? ImageHeaderParser.ImageType.UNKNOWN : (ImageHeaderParser.ImageType) invokeL.objValue;
    }
}
