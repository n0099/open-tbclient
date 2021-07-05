package d.a.q0.a.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51406a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51407a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51408b;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51407a = bVar;
            this.f51408b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                this.f51407a.a(this.f51408b, null);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.f51407a.a(this.f51408b, null);
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        this.f51407a.a(this.f51408b, copy);
                        return;
                    } catch (Exception e2) {
                        if (t.f51406a) {
                            Log.e("SwanAppFrescoImageUtils", e2.getMessage());
                        }
                        this.f51407a.a(this.f51408b, null);
                        return;
                    }
                }
                this.f51407a.a(this.f51408b, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129924321, "Ld/a/q0/a/v2/t;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129924321, "Ld/a/q0/a/v2/t;");
                return;
            }
        }
        f51406a = d.a.q0.a.k.f49133a;
    }

    public static Bitmap b(DataSource<CloseableReference<CloseableImage>> dataSource) {
        InterceptResult invokeL;
        CloseableReference<CloseableImage> closeableReference;
        Throwable th;
        Bitmap underlyingBitmap;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, dataSource)) != null) {
            return (Bitmap) invokeL.objValue;
        }
        if (dataSource == null) {
            return null;
        }
        try {
            closeableReference = dataSource.getResult();
            if (closeableReference != null) {
                try {
                    CloseableImage closeableImage = closeableReference.get();
                    if (closeableImage != null && (closeableImage instanceof CloseableBitmap) && (underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap()) != null && !underlyingBitmap.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(underlyingBitmap);
                            dataSource.close();
                            CloseableReference.closeSafely(closeableReference);
                            return createBitmap;
                        } catch (OutOfMemoryError unused) {
                            System.gc();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataSource.close();
                    CloseableReference.closeSafely(closeableReference);
                    throw th;
                }
            }
            dataSource.close();
            CloseableReference.closeSafely(closeableReference);
            return null;
        } catch (Throwable th3) {
            closeableReference = null;
            th = th3;
        }
    }

    public static Bitmap c(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, uri, context)) == null) {
            if (uri != null && context != null) {
                if (d(uri)) {
                    if (f51406a) {
                        Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
                    }
                    return b(Fresco.getImagePipeline().fetchImageFromBitmapCache(ImageRequest.fromUri(uri), context.getApplicationContext()));
                }
                if (f51406a) {
                    Log.i("SwanAppFrescoImageUtils", "start get Bitmap from sdcard, uri : " + uri.toString());
                }
                DataSource<Boolean> isInDiskCache = Fresco.getImagePipeline().isInDiskCache(uri);
                if (isInDiskCache != null && isInDiskCache.hasResult() && isInDiskCache.getResult() != null && isInDiskCache.getResult().booleanValue()) {
                    try {
                        return b(Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(uri), context));
                    } finally {
                        isInDiskCache.close();
                    }
                }
            }
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static boolean d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, uri)) == null) ? uri != null && Fresco.getImagePipeline().isInBitmapMemoryCache(uri) : invokeL.booleanValue;
    }

    public static void e(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, bVar) == null) {
            Uri C = q0.C(str);
            if (C == null) {
                bVar.a(str, null);
                return;
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, str), UiThreadImmediateExecutorService.getInstance());
        }
    }

    public static void f(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, uri, str) == null) || uri == null) {
            return;
        }
        if (f51406a) {
            Log.i("SwanAppFrescoImageUtils", "start preFetch into memory, uri : " + uri.toString());
        }
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequestBuilder.newBuilderWithSource(uri).build(), str);
    }

    public static Bitmap g(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bitmap, i2, i3)) == null) {
            if (bitmap == null || i2 <= 0 || i3 <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception | OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
