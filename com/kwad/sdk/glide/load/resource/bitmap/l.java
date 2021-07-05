package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter;
import java.util.concurrent.locks.Lock;
/* loaded from: classes7.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38231a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32649262, "Lcom/kwad/sdk/glide/load/resource/bitmap/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32649262, "Lcom/kwad/sdk/glide/load/resource/bitmap/l;");
                return;
            }
        }
        f38231a = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f() { // from class: com.kwad.sdk.glide.load.resource.bitmap.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.f, com.kwad.sdk.glide.load.engine.bitmap_recycle.e
            public void a(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                }
            }
        };
    }

    @Nullable
    public static com.kwad.sdk.glide.load.engine.s<Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i2, int i3) {
        InterceptResult invokeLLII;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65537, null, eVar, drawable, i2, i3)) == null) {
            Drawable current = drawable.getCurrent();
            boolean z = false;
            if (current instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) current).getBitmap();
            } else if (current instanceof Animatable) {
                bitmap = null;
            } else {
                bitmap = b(eVar, current, i2, i3);
                z = true;
            }
            if (!z) {
                eVar = f38231a;
            }
            return d.a(bitmap, eVar);
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeLLII.objValue;
    }

    @Nullable
    public static Bitmap b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, eVar, drawable, i2, i3)) == null) {
            if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable(DrawableToBitmapConverter.TAG, 5)) {
                    Log.w(DrawableToBitmapConverter.TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                }
                return null;
            } else if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
                if (Log.isLoggable(DrawableToBitmapConverter.TAG, 5)) {
                    Log.w(DrawableToBitmapConverter.TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
                return null;
            } else {
                if (drawable.getIntrinsicWidth() > 0) {
                    i2 = drawable.getIntrinsicWidth();
                }
                if (drawable.getIntrinsicHeight() > 0) {
                    i3 = drawable.getIntrinsicHeight();
                }
                Lock a2 = t.a();
                a2.lock();
                Bitmap a3 = eVar.a(i2, i3, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(a3);
                    drawable.setBounds(0, 0, i2, i3);
                    drawable.draw(canvas);
                    canvas.setBitmap(null);
                    return a3;
                } finally {
                    a2.unlock();
                }
            }
        }
        return (Bitmap) invokeLLII.objValue;
    }
}
