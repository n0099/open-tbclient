package d.b.g0.a.i2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45156a = d.b.g0.a.k.f45443a;

    /* loaded from: classes3.dex */
    public static class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f45157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45158b;

        public a(b bVar, String str) {
            this.f45157a = bVar;
            this.f45158b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            super.onCancellation(dataSource);
            this.f45157a.a(this.f45158b, null);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            this.f45157a.a(this.f45158b, null);
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    this.f45157a.a(this.f45158b, copy);
                    return;
                } catch (Exception e2) {
                    if (s.f45156a) {
                        Log.e("SwanAppFrescoImageUtils", e2.getMessage());
                    }
                    this.f45157a.a(this.f45158b, null);
                    return;
                }
            }
            this.f45157a.a(this.f45158b, null);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, Bitmap bitmap);
    }

    public static Bitmap b(DataSource<CloseableReference<CloseableImage>> dataSource) {
        CloseableReference<CloseableImage> closeableReference;
        Throwable th;
        Bitmap underlyingBitmap;
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
        if (uri != null && context != null) {
            if (d(uri)) {
                if (f45156a) {
                    Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
                }
                return b(Fresco.getImagePipeline().fetchImageFromBitmapCache(ImageRequest.fromUri(uri), context.getApplicationContext()));
            }
            if (f45156a) {
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

    public static boolean d(Uri uri) {
        return uri != null && Fresco.getImagePipeline().isInBitmapMemoryCache(uri);
    }

    public static void e(String str, b bVar) {
        Uri y = k0.y(str);
        if (y == null) {
            bVar.a(str, null);
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(y).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, str), UiThreadImmediateExecutorService.getInstance());
    }

    public static void f(Uri uri, String str) {
        if (uri == null) {
            return;
        }
        if (f45156a) {
            Log.i("SwanAppFrescoImageUtils", "start preFetch into memory, uri : " + uri.toString());
        }
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequestBuilder.newBuilderWithSource(uri).build(), str);
    }

    public static Bitmap g(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
