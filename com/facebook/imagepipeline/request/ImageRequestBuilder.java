package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ImageRequestBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BytesRange mBytesRange;
    public ImageRequest.CacheChoice mCacheChoice;
    @Nullable
    public Boolean mDecodePrefetches;
    public boolean mDiskCacheEnabled;
    public ImageDecodeOptions mImageDecodeOptions;
    public boolean mLocalThumbnailPreviewsEnabled;
    public String mLogTag;
    public ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    public boolean mMemoryCacheEnabled;
    public Map<String, String> mNetRequestHeader;
    @Nullable
    public Postprocessor mPostprocessor;
    public boolean mProgressiveRenderingEnabled;
    @Nullable
    public RequestListener mRequestListener;
    public Priority mRequestPriority;
    @Nullable
    public ResizeOptions mResizeOptions;
    @Nullable
    public Boolean mResizingAllowedOverride;
    @Nullable
    public RotationOptions mRotationOptions;
    public Uri mSourceUri;
    public String mTag;

    /* loaded from: classes12.dex */
    public static class BuilderException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public ImageRequestBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSourceUri = null;
        this.mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
        this.mResizeOptions = null;
        this.mRotationOptions = null;
        this.mImageDecodeOptions = ImageDecodeOptions.defaults();
        this.mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
        this.mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
        this.mLocalThumbnailPreviewsEnabled = false;
        this.mRequestPriority = Priority.HIGH;
        this.mPostprocessor = null;
        this.mDiskCacheEnabled = true;
        this.mMemoryCacheEnabled = true;
        this.mDecodePrefetches = null;
        this.mBytesRange = null;
        this.mResizingAllowedOverride = null;
        this.mNetRequestHeader = null;
        this.mTag = null;
        this.mLogTag = null;
    }

    public static ImageRequestBuilder fromRequest(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageRequest)) == null) ? newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions()).setShouldDecodePrefetches(imageRequest.shouldDecodePrefetches()).setNetRequestHeader(imageRequest.getNetRequestHeader()).setTag(imageRequest.mTag).setLogTag(imageRequest.mLogTag) : (ImageRequestBuilder) invokeL.objValue;
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? newBuilderWithSource(UriUtil.getUriForResourceId(i2)) : (ImageRequestBuilder) invokeI.objValue;
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) ? new ImageRequestBuilder().setSource(uri) : (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequest build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            validate();
            return new ImageRequest(this);
        }
        return (ImageRequest) invokeV.objValue;
    }

    public ImageRequestBuilder disableDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.mDiskCacheEnabled = false;
            return this;
        }
        return (ImageRequestBuilder) invokeV.objValue;
    }

    public ImageRequestBuilder disableMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.mMemoryCacheEnabled = false;
            return this;
        }
        return (ImageRequestBuilder) invokeV.objValue;
    }

    @Nullable
    public BytesRange getBytesRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBytesRange : (BytesRange) invokeV.objValue;
    }

    public ImageRequest.CacheChoice getCacheChoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCacheChoice : (ImageRequest.CacheChoice) invokeV.objValue;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImageDecodeOptions : (ImageDecodeOptions) invokeV.objValue;
    }

    public String getLogTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLogTag : (String) invokeV.objValue;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLowestPermittedRequestLevel : (ImageRequest.RequestLevel) invokeV.objValue;
    }

    public Map<String, String> getNetRequestHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mNetRequestHeader : (Map) invokeV.objValue;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPostprocessor : (Postprocessor) invokeV.objValue;
    }

    @Nullable
    public RequestListener getRequestListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mRequestListener : (RequestListener) invokeV.objValue;
    }

    public Priority getRequestPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRequestPriority : (Priority) invokeV.objValue;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mResizeOptions : (ResizeOptions) invokeV.objValue;
    }

    @Nullable
    public Boolean getResizingAllowedOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mResizingAllowedOverride : (Boolean) invokeV.objValue;
    }

    @Nullable
    public RotationOptions getRotationOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRotationOptions : (RotationOptions) invokeV.objValue;
    }

    public Uri getSourceUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSourceUri : (Uri) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTag : (String) invokeV.objValue;
    }

    public boolean isDiskCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mDiskCacheEnabled && UriUtil.isNetworkUri(this.mSourceUri) : invokeV.booleanValue;
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mLocalThumbnailPreviewsEnabled : invokeV.booleanValue;
    }

    public boolean isMemoryCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mMemoryCacheEnabled : invokeV.booleanValue;
    }

    public boolean isProgressiveRenderingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mProgressiveRenderingEnabled : invokeV.booleanValue;
    }

    @Deprecated
    public ImageRequestBuilder setAutoRotateEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (z) {
                return setRotationOptions(RotationOptions.autoRotate());
            }
            return setRotationOptions(RotationOptions.disableRotation());
        }
        return (ImageRequestBuilder) invokeZ.objValue;
    }

    public ImageRequestBuilder setBytesRange(@Nullable BytesRange bytesRange) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bytesRange)) == null) {
            this.mBytesRange = bytesRange;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice cacheChoice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, cacheChoice)) == null) {
            this.mCacheChoice = cacheChoice;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, imageDecodeOptions)) == null) {
            this.mImageDecodeOptions = imageDecodeOptions;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            this.mLocalThumbnailPreviewsEnabled = z;
            return this;
        }
        return (ImageRequestBuilder) invokeZ.objValue;
    }

    public ImageRequestBuilder setLogTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.mLogTag = str;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel requestLevel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, requestLevel)) == null) {
            this.mLowestPermittedRequestLevel = requestLevel;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setNetRequestHeader(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, map)) == null) {
            this.mNetRequestHeader = map;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setPostprocessor(Postprocessor postprocessor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, postprocessor)) == null) {
            this.mPostprocessor = postprocessor;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            this.mProgressiveRenderingEnabled = z;
            return this;
        }
        return (ImageRequestBuilder) invokeZ.objValue;
    }

    public ImageRequestBuilder setRequestListener(RequestListener requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, requestListener)) == null) {
            this.mRequestListener = requestListener;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setRequestPriority(Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, priority)) == null) {
            this.mRequestPriority = priority;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions resizeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, resizeOptions)) == null) {
            this.mResizeOptions = resizeOptions;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setResizingAllowedOverride(@Nullable Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bool)) == null) {
            this.mResizingAllowedOverride = bool;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions rotationOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, rotationOptions)) == null) {
            this.mRotationOptions = rotationOptions;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setShouldDecodePrefetches(@Nullable Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bool)) == null) {
            this.mDecodePrefetches = bool;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setSource(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, uri)) == null) {
            Preconditions.checkNotNull(uri);
            this.mSourceUri = uri;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    public ImageRequestBuilder setTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            this.mTag = str;
            return this;
        }
        return (ImageRequestBuilder) invokeL.objValue;
    }

    @Nullable
    public Boolean shouldDecodePrefetches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mDecodePrefetches : (Boolean) invokeV.objValue;
    }

    public void validate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            Uri uri = this.mSourceUri;
            if (uri != null) {
                if (UriUtil.isLocalResourceUri(uri)) {
                    if (this.mSourceUri.isAbsolute()) {
                        if (!this.mSourceUri.getPath().isEmpty()) {
                            try {
                                Integer.parseInt(this.mSourceUri.getPath().substring(1));
                            } catch (NumberFormatException unused) {
                                throw new BuilderException("Resource URI path must be a resource id.");
                            }
                        } else {
                            throw new BuilderException("Resource URI must not be empty");
                        }
                    } else {
                        throw new BuilderException("Resource URI path must be absolute.");
                    }
                }
                if (UriUtil.isLocalAssetUri(this.mSourceUri) && !this.mSourceUri.isAbsolute()) {
                    throw new BuilderException("Asset URI path must be absolute.");
                }
                return;
            }
            throw new BuilderException("Source must be set!");
        }
    }
}
