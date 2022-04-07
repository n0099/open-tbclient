package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Rect MICRO_THUMBNAIL_DIMENSIONS;
    public static final Rect MINI_THUMBNAIL_DIMENSIONS;
    public static final int NO_THUMBNAIL = 0;
    public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
    public static final String[] PROJECTION;
    public static final Class<?> TAG;
    public static final String[] THUMBNAIL_PROJECTION;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver mContentResolver;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1186254036, "Lcom/facebook/imagepipeline/producers/LocalContentUriThumbnailFetchProducer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1186254036, "Lcom/facebook/imagepipeline/producers/LocalContentUriThumbnailFetchProducer;");
                return;
            }
        }
        TAG = LocalContentUriThumbnailFetchProducer.class;
        PROJECTION = new String[]{"_id", "_data"};
        THUMBNAIL_PROJECTION = new String[]{"_data"};
        MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
        MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, pooledByteBufferFactory, contentResolver};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Executor) objArr2[0], (PooledByteBufferFactory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContentResolver = contentResolver;
    }

    @Nullable
    private EncodedImage getCameraImage(Uri uri, ResizeOptions resizeOptions) throws IOException {
        InterceptResult invokeLL;
        EncodedImage thumbnail;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, uri, resizeOptions)) == null) {
            Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.getCount() == 0) {
                    return null;
                }
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("_data"));
                if (resizeOptions == null || (thumbnail = getThumbnail(resizeOptions, query.getInt(query.getColumnIndex("_id")))) == null) {
                    return null;
                }
                thumbnail.setRotationAngle(getRotationAngle(string));
                return thumbnail;
            } finally {
                query.close();
            }
        }
        return (EncodedImage) invokeLL.objValue;
    }

    public static int getLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return -1;
            }
            return (int) new File(str).length();
        }
        return invokeL.intValue;
    }

    public static int getRotationAngle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null) {
                try {
                    return JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(str).getAttributeInt("Orientation", 1));
                } catch (IOException e) {
                    FLog.e(TAG, e, "Unable to retrieve thumbnail rotation for %s", str);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Nullable
    private EncodedImage getThumbnail(ResizeOptions resizeOptions, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65541, this, resizeOptions, i)) != null) {
            return (EncodedImage) invokeLI.objValue;
        }
        int thumbnailKind = getThumbnailKind(resizeOptions);
        Cursor cursor = null;
        if (thumbnailKind == 0) {
            return null;
        }
        try {
            Cursor queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, thumbnailKind, THUMBNAIL_PROJECTION);
            if (queryMiniThumbnail == null) {
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                return null;
            }
            try {
                queryMiniThumbnail.moveToFirst();
                if (queryMiniThumbnail.getCount() > 0) {
                    String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                    if (new File(string).exists()) {
                        EncodedImage encodedImage = getEncodedImage(new FileInputStream(string), getLength(string));
                        if (queryMiniThumbnail != null) {
                            queryMiniThumbnail.close();
                        }
                        return encodedImage;
                    }
                }
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                cursor = queryMiniThumbnail;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int getThumbnailKind(ResizeOptions resizeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, resizeOptions)) == null) {
            if (ThumbnailSizeChecker.isImageBigEnough(MICRO_THUMBNAIL_DIMENSIONS.width(), MICRO_THUMBNAIL_DIMENSIONS.height(), resizeOptions)) {
                return 3;
            }
            return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resizeOptions)) == null) ? ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions) : invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    @Nullable
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        InterceptResult invokeL;
        EncodedImage cameraImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest)) == null) {
            Uri sourceUri = imageRequest.getSourceUri();
            if (!UriUtil.isLocalCameraUri(sourceUri) || (cameraImage = getCameraImage(sourceUri, imageRequest.getResizeOptions())) == null) {
                return null;
            }
            return cameraImage;
        }
        return (EncodedImage) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PRODUCER_NAME : (String) invokeV.objValue;
    }
}
