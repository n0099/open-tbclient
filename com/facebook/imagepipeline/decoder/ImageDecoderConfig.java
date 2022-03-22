package com.facebook.imagepipeline.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imageformat.ImageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ImageDecoderConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
    public final List<ImageFormat.FormatChecker> mCustomImageFormats;

    /* renamed from: com.facebook.imagepipeline.decoder.ImageDecoderConfig$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
        public List<ImageFormat.FormatChecker> mCustomImageFormats;

        public Builder() {
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

        public Builder addDecodingCapability(ImageFormat imageFormat, ImageFormat.FormatChecker formatChecker, ImageDecoder imageDecoder) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, imageFormat, formatChecker, imageDecoder)) == null) {
                if (this.mCustomImageFormats == null) {
                    this.mCustomImageFormats = new ArrayList();
                }
                this.mCustomImageFormats.add(formatChecker);
                overrideDecoder(imageFormat, imageDecoder);
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public ImageDecoderConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ImageDecoderConfig(this, null) : (ImageDecoderConfig) invokeV.objValue;
        }

        public Builder overrideDecoder(ImageFormat imageFormat, ImageDecoder imageDecoder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageFormat, imageDecoder)) == null) {
                if (this.mCustomImageDecoders == null) {
                    this.mCustomImageDecoders = new HashMap();
                }
                this.mCustomImageDecoders.put(imageFormat, imageDecoder);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    public /* synthetic */ ImageDecoderConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
    }

    public Map<ImageFormat, ImageDecoder> getCustomImageDecoders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCustomImageDecoders : (Map) invokeV.objValue;
    }

    public List<ImageFormat.FormatChecker> getCustomImageFormats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCustomImageFormats : (List) invokeV.objValue;
    }

    public ImageDecoderConfig(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCustomImageDecoders = builder.mCustomImageDecoders;
        this.mCustomImageFormats = builder.mCustomImageFormats;
    }
}
