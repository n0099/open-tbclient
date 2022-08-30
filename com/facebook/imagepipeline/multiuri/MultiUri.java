package com.facebook.imagepipeline.multiuri;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class MultiUri {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ImageRequest mHighResImageRequest;
    @Nullable
    public ImageRequest mLowResImageRequest;
    @Nullable
    public ImageRequest[] mMultiImageRequests;

    /* renamed from: com.facebook.imagepipeline.multiuri.MultiUri$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ImageRequest mHighResImageRequest;
        @Nullable
        public ImageRequest mLowResImageRequest;
        @Nullable
        public ImageRequest[] mMultiImageRequests;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public MultiUri build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MultiUri(this, null) : (MultiUri) invokeV.objValue;
        }

        public Builder setHighResImageRequest(@Nullable ImageRequest imageRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest)) == null) {
                this.mHighResImageRequest = imageRequest;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageRequests(@Nullable ImageRequest... imageRequestArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageRequestArr)) == null) {
                this.mMultiImageRequests = imageRequestArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLowResImageRequest(@Nullable ImageRequest imageRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imageRequest)) == null) {
                this.mLowResImageRequest = imageRequest;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

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
    }

    public /* synthetic */ MultiUri(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder(null) : (Builder) invokeV.objValue;
    }

    @Nullable
    public ImageRequest getHighResImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHighResImageRequest : (ImageRequest) invokeV.objValue;
    }

    @Nullable
    public ImageRequest getLowResImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLowResImageRequest : (ImageRequest) invokeV.objValue;
    }

    @Nullable
    public ImageRequest[] getMultiImageRequests() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMultiImageRequests : (ImageRequest[]) invokeV.objValue;
    }

    public MultiUri(Builder builder) {
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
        this.mLowResImageRequest = builder.mLowResImageRequest;
        this.mHighResImageRequest = builder.mHighResImageRequest;
        this.mMultiImageRequests = builder.mMultiImageRequests;
    }
}
