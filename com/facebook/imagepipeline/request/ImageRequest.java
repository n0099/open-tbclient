package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import java.io.File;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes11.dex */
public class ImageRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final BytesRange mBytesRange;
    public final CacheChoice mCacheChoice;
    @Nullable
    public final Boolean mDecodePrefetches;
    public final ImageDecodeOptions mImageDecodeOptions;
    public final boolean mIsDiskCacheEnabled;
    public final boolean mIsMemoryCacheEnabled;
    public final boolean mLocalThumbnailPreviewsEnabled;
    public String mLogTag;
    public final RequestLevel mLowestPermittedRequestLevel;
    public final Map<String, String> mNetRequestHeader;
    @Nullable
    public final Postprocessor mPostprocessor;
    public final boolean mProgressiveRenderingEnabled;
    @Nullable
    public final RequestListener mRequestListener;
    public final Priority mRequestPriority;
    @Nullable
    public final ResizeOptions mResizeOptions;
    @Nullable
    public final Boolean mResizingAllowedOverride;
    public final RotationOptions mRotationOptions;
    public File mSourceFile;
    public final Uri mSourceUri;
    public final int mSourceUriType;
    public String mTag;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class CacheChoice {
        public static final /* synthetic */ CacheChoice[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CacheChoice DEFAULT;
        public static final CacheChoice SMALL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-716524409, "Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-716524409, "Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;");
                    return;
                }
            }
            SMALL = new CacheChoice("SMALL", 0);
            CacheChoice cacheChoice = new CacheChoice("DEFAULT", 1);
            DEFAULT = cacheChoice;
            $VALUES = new CacheChoice[]{SMALL, cacheChoice};
        }

        public CacheChoice(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CacheChoice valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CacheChoice) Enum.valueOf(CacheChoice.class, str) : (CacheChoice) invokeL.objValue;
        }

        public static CacheChoice[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CacheChoice[]) $VALUES.clone() : (CacheChoice[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class RequestLevel {
        public static final /* synthetic */ RequestLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RequestLevel BITMAP_MEMORY_CACHE;
        public static final RequestLevel DISK_CACHE;
        public static final RequestLevel ENCODED_MEMORY_CACHE;
        public static final RequestLevel FULL_FETCH;
        public transient /* synthetic */ FieldHolder $fh;
        public int mValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(836122327, "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(836122327, "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;");
                    return;
                }
            }
            FULL_FETCH = new RequestLevel("FULL_FETCH", 0, 1);
            DISK_CACHE = new RequestLevel("DISK_CACHE", 1, 2);
            ENCODED_MEMORY_CACHE = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
            RequestLevel requestLevel = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
            BITMAP_MEMORY_CACHE = requestLevel;
            $VALUES = new RequestLevel[]{FULL_FETCH, DISK_CACHE, ENCODED_MEMORY_CACHE, requestLevel};
        }

        public RequestLevel(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mValue = i3;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, requestLevel, requestLevel2)) == null) ? requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2 : (RequestLevel) invokeLL.objValue;
        }

        public static RequestLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (RequestLevel) Enum.valueOf(RequestLevel.class, str) : (RequestLevel) invokeL.objValue;
        }

        public static RequestLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (RequestLevel[]) $VALUES.clone() : (RequestLevel[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mValue : invokeV.intValue;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageRequestBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCacheChoice = imageRequestBuilder.getCacheChoice();
        Uri sourceUri = imageRequestBuilder.getSourceUri();
        this.mSourceUri = sourceUri;
        this.mSourceUriType = getSourceUriType(sourceUri);
        this.mProgressiveRenderingEnabled = imageRequestBuilder.isProgressiveRenderingEnabled();
        this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.isLocalThumbnailPreviewsEnabled();
        this.mImageDecodeOptions = imageRequestBuilder.getImageDecodeOptions();
        this.mResizeOptions = imageRequestBuilder.getResizeOptions();
        this.mRotationOptions = imageRequestBuilder.getRotationOptions() == null ? RotationOptions.autoRotate() : imageRequestBuilder.getRotationOptions();
        this.mBytesRange = imageRequestBuilder.getBytesRange();
        this.mRequestPriority = imageRequestBuilder.getRequestPriority();
        this.mLowestPermittedRequestLevel = imageRequestBuilder.getLowestPermittedRequestLevel();
        this.mIsDiskCacheEnabled = imageRequestBuilder.isDiskCacheEnabled();
        this.mIsMemoryCacheEnabled = imageRequestBuilder.isMemoryCacheEnabled();
        this.mDecodePrefetches = imageRequestBuilder.shouldDecodePrefetches();
        this.mPostprocessor = imageRequestBuilder.getPostprocessor();
        this.mRequestListener = imageRequestBuilder.getRequestListener();
        this.mResizingAllowedOverride = imageRequestBuilder.getResizingAllowedOverride();
        this.mNetRequestHeader = imageRequestBuilder.getNetRequestHeader();
        this.mTag = imageRequestBuilder.getTag();
        this.mLogTag = imageRequestBuilder.getLogTag();
    }

    @Nullable
    public static ImageRequest fromFile(@Nullable File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null) {
                return null;
            }
            return fromUri(UriUtil.getUriForFile(file));
        }
        return (ImageRequest) invokeL.objValue;
    }

    @Nullable
    public static ImageRequest fromUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            return ImageRequestBuilder.newBuilderWithSource(uri).build();
        }
        return (ImageRequest) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof ImageRequest) {
                ImageRequest imageRequest = (ImageRequest) obj;
                if (Objects.equal(this.mSourceUri, imageRequest.mSourceUri) && Objects.equal(this.mCacheChoice, imageRequest.mCacheChoice) && Objects.equal(this.mSourceFile, imageRequest.mSourceFile) && Objects.equal(this.mBytesRange, imageRequest.mBytesRange) && Objects.equal(this.mImageDecodeOptions, imageRequest.mImageDecodeOptions) && Objects.equal(this.mResizeOptions, imageRequest.mResizeOptions) && Objects.equal(this.mRotationOptions, imageRequest.mRotationOptions)) {
                    Postprocessor postprocessor = this.mPostprocessor;
                    CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
                    Postprocessor postprocessor2 = imageRequest.mPostprocessor;
                    return Objects.equal(postprocessorCacheKey, postprocessor2 != null ? postprocessor2.getPostprocessorCacheKey() : null);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public boolean getAutoRotateEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRotationOptions.useImageMetadata() : invokeV.booleanValue;
    }

    @Nullable
    public BytesRange getBytesRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBytesRange : (BytesRange) invokeV.objValue;
    }

    public CacheChoice getCacheChoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheChoice : (CacheChoice) invokeV.objValue;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImageDecodeOptions : (ImageDecodeOptions) invokeV.objValue;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLocalThumbnailPreviewsEnabled : invokeV.booleanValue;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLowestPermittedRequestLevel : (RequestLevel) invokeV.objValue;
    }

    public Map<String, String> getNetRequestHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mNetRequestHeader : (Map) invokeV.objValue;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPostprocessor : (Postprocessor) invokeV.objValue;
    }

    public int getPreferredHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ResizeOptions resizeOptions = this.mResizeOptions;
            if (resizeOptions != null) {
                return resizeOptions.height;
            }
            return 2048;
        }
        return invokeV.intValue;
    }

    public int getPreferredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ResizeOptions resizeOptions = this.mResizeOptions;
            if (resizeOptions != null) {
                return resizeOptions.width;
            }
            return 2048;
        }
        return invokeV.intValue;
    }

    public Priority getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRequestPriority : (Priority) invokeV.objValue;
    }

    public boolean getProgressiveRenderingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mProgressiveRenderingEnabled : invokeV.booleanValue;
    }

    @Nullable
    public RequestListener getRequestListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRequestListener : (RequestListener) invokeV.objValue;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mResizeOptions : (ResizeOptions) invokeV.objValue;
    }

    @Nullable
    public Boolean getResizingAllowedOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mResizingAllowedOverride : (Boolean) invokeV.objValue;
    }

    public RotationOptions getRotationOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mRotationOptions : (RotationOptions) invokeV.objValue;
    }

    public synchronized File getSourceFile() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                if (this.mSourceFile == null) {
                    this.mSourceFile = new File(this.mSourceUri.getPath());
                }
                file = this.mSourceFile;
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public Uri getSourceUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mSourceUri : (Uri) invokeV.objValue;
    }

    public int getSourceUriType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mSourceUriType : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Postprocessor postprocessor = this.mPostprocessor;
            return Objects.hashCode(this.mCacheChoice, this.mSourceUri, this.mSourceFile, this.mBytesRange, this.mImageDecodeOptions, this.mResizeOptions, this.mRotationOptions, postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null, this.mResizingAllowedOverride);
        }
        return invokeV.intValue;
    }

    public boolean isDiskCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mIsDiskCacheEnabled : invokeV.booleanValue;
    }

    public boolean isMemoryCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mIsMemoryCacheEnabled : invokeV.booleanValue;
    }

    @Nullable
    public Boolean shouldDecodePrefetches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mDecodePrefetches : (Boolean) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Objects.toStringHelper(this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).add("resizingAllowedOverride", this.mResizingAllowedOverride).toString() : (String) invokeV.objValue;
    }

    @Nullable
    public static ImageRequest fromUri(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return fromUri(Uri.parse(str));
        }
        return (ImageRequest) invokeL.objValue;
    }

    public static int getSourceUriType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) {
            if (uri == null) {
                return -1;
            }
            if (UriUtil.isNetworkUri(uri)) {
                return 0;
            }
            if (UriUtil.isLocalFileUri(uri)) {
                return MediaUtils.isVideo(MediaUtils.extractMime(uri.getPath())) ? 2 : 3;
            } else if (UriUtil.isLocalContentUri(uri)) {
                return 4;
            } else {
                if (UriUtil.isLocalAssetUri(uri)) {
                    return 5;
                }
                if (UriUtil.isLocalResourceUri(uri)) {
                    return 6;
                }
                if (UriUtil.isDataUri(uri)) {
                    return 7;
                }
                return UriUtil.isQualifiedResourceUri(uri) ? 8 : -1;
            }
        }
        return invokeL.intValue;
    }
}
