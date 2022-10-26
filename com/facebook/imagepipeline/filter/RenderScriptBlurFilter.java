package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
/* loaded from: classes7.dex */
public abstract class RenderScriptBlurFilter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLUR_MAX_RADIUS = 25;
    public transient /* synthetic */ FieldHolder $fh;

    public RenderScriptBlurFilter() {
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

    public static boolean canUseRenderScript() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void blurBitmap(Bitmap bitmap, Bitmap bitmap2, Context context, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65537, null, bitmap, bitmap2, context, i) == null) {
            Preconditions.checkNotNull(bitmap);
            Preconditions.checkNotNull(bitmap2);
            Preconditions.checkNotNull(context);
            if (i > 0 && i <= 25) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            RenderScript renderScript = null;
            try {
                renderScript = RenderScript.create(context);
                ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap2);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(renderScript, bitmap);
                create.setRadius(i);
                create.setInput(createFromBitmap);
                create.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(bitmap);
                create.destroy();
                createFromBitmap.destroy();
                createFromBitmap2.destroy();
            } finally {
                if (renderScript != null) {
                    renderScript.destroy();
                }
            }
        }
    }
}
