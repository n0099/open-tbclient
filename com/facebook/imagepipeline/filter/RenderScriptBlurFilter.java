package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
/* loaded from: classes6.dex */
public abstract class RenderScriptBlurFilter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLUR_MAX_RADIUS = 25;
    public transient /* synthetic */ FieldHolder $fh;

    public RenderScriptBlurFilter() {
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

    @RequiresApi(17)
    public static void blurBitmap(Bitmap bitmap, Bitmap bitmap2, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65537, null, bitmap, bitmap2, context, i2) == null) {
            Preconditions.checkNotNull(bitmap);
            Preconditions.checkNotNull(bitmap2);
            Preconditions.checkNotNull(context);
            Preconditions.checkArgument(i2 > 0 && i2 <= 25);
            RenderScript renderScript = null;
            try {
                renderScript = RenderScript.create(context);
                ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap2);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(renderScript, bitmap);
                create.setRadius(i2);
                create.setInput(createFromBitmap);
                create.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(bitmap);
            } finally {
                if (renderScript != null) {
                    renderScript.destroy();
                }
            }
        }
    }

    public static boolean canUseRenderScript() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.VERSION.SDK_INT >= 17 : invokeV.booleanValue;
    }
}
