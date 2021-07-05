package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, list, inputStream, bVar)) == null) {
            if (inputStream == null) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
            }
            inputStream.mark(5242880);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ImageHeaderParser.ImageType a2 = list.get(i2).a(inputStream);
                    if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                        return a2;
                    }
                } finally {
                    inputStream.reset();
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return (ImageHeaderParser.ImageType) invokeLLL.objValue;
    }

    @NonNull
    public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, byteBuffer)) == null) {
            if (byteBuffer == null) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImageHeaderParser.ImageType a2 = list.get(i2).a(byteBuffer);
                if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return a2;
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return (ImageHeaderParser.ImageType) invokeLL.objValue;
    }

    public static int b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, list, inputStream, bVar)) == null) {
            if (inputStream == null) {
                return -1;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
            }
            inputStream.mark(5242880);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    int a2 = list.get(i2).a(inputStream, bVar);
                    if (a2 != -1) {
                        return a2;
                    }
                } finally {
                    inputStream.reset();
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }
}
