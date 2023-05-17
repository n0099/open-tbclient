package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
/* loaded from: classes8.dex */
public class SkiaImageRegionDecoder implements ImageRegionDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSET_PREFIX = "file:///android_asset/";
    public static final String FILE_PREFIX = "file://";
    public static final String RESOURCE_PREFIX = "android.resource://";
    public transient /* synthetic */ FieldHolder $fh;
    public BitmapRegionDecoder decoder;
    public final Object decoderLock;

    public SkiaImageRegionDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.decoderLock = new Object();
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.decoder.recycle();
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect rect, int i) {
        InterceptResult invokeLI;
        Bitmap decodeRegion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, rect, i)) == null) {
            synchronized (this.decoderLock) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                decodeRegion = this.decoder.decodeRegion(rect, options);
                if (decodeRegion == null) {
                    throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                }
            }
            return decodeRegion;
        }
        return (Bitmap) invokeLI.objValue;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context context, Uri uri) throws Exception {
        InterceptResult invokeLL;
        Resources resourcesForApplication;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uri)) == null) {
            String uri2 = uri.toString();
            if (uri2.startsWith("android.resource://")) {
                String authority = uri.getAuthority();
                if (context.getPackageName().equals(authority)) {
                    resourcesForApplication = context.getResources();
                } else {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
                }
                List<String> pathSegments = uri.getPathSegments();
                int size = pathSegments.size();
                if (size == 2 && pathSegments.get(0).equals(ResourceManager.DRAWABLE)) {
                    i = resourcesForApplication.getIdentifier(pathSegments.get(1), ResourceManager.DRAWABLE, authority);
                } else {
                    if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                        }
                    }
                    i = 0;
                }
                this.decoder = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
            } else if (uri2.startsWith("file:///android_asset/")) {
                this.decoder = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
            } else if (uri2.startsWith("file://")) {
                this.decoder = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
            } else {
                this.decoder = BitmapRegionDecoder.newInstance(context.getContentResolver().openInputStream(uri), false);
            }
            return new Point(this.decoder.getWidth(), this.decoder.getHeight());
        }
        return (Point) invokeLL.objValue;
    }
}
