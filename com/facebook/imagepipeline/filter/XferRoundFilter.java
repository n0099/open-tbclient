package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
/* loaded from: classes7.dex */
public final class XferRoundFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public XferRoundFilter() {
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

    public static boolean canUseXferRoundFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 12) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void xferRoundBitmap(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        Paint paint;
        Paint paint2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, bitmap, bitmap2, z) == null) {
            Preconditions.checkNotNull(bitmap2);
            Preconditions.checkNotNull(bitmap);
            bitmap.setHasAlpha(true);
            if (z) {
                paint = new Paint(1);
                paint2 = new Paint(1);
            } else {
                paint = new Paint();
                paint2 = new Paint();
            }
            paint.setColor(-16777216);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Canvas canvas = new Canvas(bitmap);
            float width = bitmap2.getWidth() / 2.0f;
            float height = bitmap2.getHeight() / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height), paint);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint2);
        }
    }
}
