package com.kwad.sdk.core.imageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.ContentLengthInputStream;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class BaseImageDownloader implements ImageDownloader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    public static final int BUFFER_SIZE = 32768;
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    public static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    public static final int MAX_REDIRECT_COUNT = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final int connectTimeout;
    public final Context context;
    public final int readTimeout;

    /* renamed from: com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1630418140, "Lcom/kwad/sdk/core/imageloader/core/download/BaseImageDownloader$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1630418140, "Lcom/kwad/sdk/core/imageloader/core/download/BaseImageDownloader$1;");
                    return;
                }
            }
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseImageDownloader(Context context) {
        this(context, 5000, 20000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public BaseImageDownloader(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context.getApplicationContext();
        this.connectTimeout = i2;
        this.readTimeout = i3;
    }

    @TargetApi(8)
    private InputStream getVideoThumbnailStream(String str) {
        InterceptResult invokeL;
        Bitmap createVideoThumbnail;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (Build.VERSION.SDK_INT < 8 || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2)) == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return (InputStream) invokeL.objValue;
    }

    private boolean isVideoContentUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, uri)) == null) {
            String type = this.context.getContentResolver().getType(uri);
            return type != null && type.startsWith(FileUtils.VIDEO_FILE_START);
        }
        return invokeL.booleanValue;
    }

    private boolean isVideoFileUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
            return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith(FileUtils.VIDEO_FILE_START);
        }
        return invokeL.booleanValue;
    }

    public HttpURLConnection createConnection(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
            httpURLConnection.setConnectTimeout(this.connectTimeout);
            httpURLConnection.setReadTimeout(this.readTimeout);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            switch (AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
                case 1:
                case 2:
                    return getStreamFromNetwork(str, obj);
                case 3:
                    return getStreamFromFile(str, obj);
                case 4:
                    return getStreamFromContent(str, obj);
                case 5:
                    return getStreamFromAssets(str, obj);
                case 6:
                    return getStreamFromDrawable(str, obj);
                default:
                    return getStreamFromOtherSource(str, obj);
            }
        }
        return (InputStream) invokeLL.objValue;
    }

    public InputStream getStreamFromAssets(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) ? this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str)) : (InputStream) invokeLL.objValue;
    }

    public InputStream getStreamFromContent(String str, Object obj) {
        InterceptResult invokeLL;
        Bitmap thumbnail;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, obj)) == null) {
            ContentResolver contentResolver = this.context.getContentResolver();
            Uri parse = Uri.parse(str);
            if (!isVideoContentUri(parse) || (thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null)) == null) {
                return contentResolver.openInputStream(parse);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return (InputStream) invokeLL.objValue;
    }

    public InputStream getStreamFromDrawable(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, obj)) == null) ? this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str))) : (InputStream) invokeLL.objValue;
    }

    public InputStream getStreamFromFile(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, obj)) == null) {
            String crop = ImageDownloader.Scheme.FILE.crop(str);
            return isVideoFileUri(str) ? getVideoThumbnailStream(crop) : new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
        }
        return (InputStream) invokeLL.objValue;
    }

    public InputStream getStreamFromNetwork(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
            HttpURLConnection createConnection = createConnection(str, obj);
            for (int i2 = 0; createConnection.getResponseCode() / 100 == 3 && i2 < 5; i2++) {
                createConnection = createConnection(createConnection.getHeaderField("Location"), obj);
            }
            try {
                InputStream inputStream = createConnection.getInputStream();
                if (shouldBeProcessed(createConnection)) {
                    return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
                }
                IoUtils.closeSilently(inputStream);
                throw new IOException("Image request failed with response code " + createConnection.getResponseCode());
            } catch (IOException e2) {
                IoUtils.readAndCloseStream(createConnection.getErrorStream());
                throw e2;
            }
        }
        return (InputStream) invokeLL.objValue;
    }

    public InputStream getStreamFromOtherSource(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, obj)) == null) {
            throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, str));
        }
        return (InputStream) invokeLL.objValue;
    }

    public boolean shouldBeProcessed(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpURLConnection)) == null) ? httpURLConnection.getResponseCode() == 200 : invokeL.booleanValue;
    }
}
