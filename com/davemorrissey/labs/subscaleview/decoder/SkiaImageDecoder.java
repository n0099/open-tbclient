package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class SkiaImageDecoder implements ImageDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSET_PREFIX = "file:///android_asset/";
    public static final String FILE_PREFIX = "file://";
    public static final String RESOURCE_PREFIX = "android.resource://";
    public transient /* synthetic */ FieldHolder $fh;

    public SkiaImageDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageDecoder
    public Bitmap decode(Context context, Uri uri) throws Exception {
        InterceptResult invokeLL;
        Bitmap decodeStream;
        Resources resourcesForApplication;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, uri)) == null) {
            String uri2 = uri.toString();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            if (uri2.startsWith("android.resource://")) {
                String authority = uri.getAuthority();
                if (context.getPackageName().equals(authority)) {
                    resourcesForApplication = context.getResources();
                } else {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
                }
                List<String> pathSegments = uri.getPathSegments();
                int size = pathSegments.size();
                int i2 = 0;
                if (size == 2 && pathSegments.get(0).equals("drawable")) {
                    i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
                } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i2 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                decodeStream = BitmapFactory.decodeResource(context.getResources(), i2, options);
            } else if (uri2.startsWith("file:///android_asset/")) {
                decodeStream = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring(22)), null, options);
            } else if (uri2.startsWith("file://")) {
                decodeStream = BitmapFactory.decodeFile(uri2.substring(7), options);
            } else {
                decodeStream = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options);
            }
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
        }
        return (Bitmap) invokeLL.objValue;
    }
}
