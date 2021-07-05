package com.kwai.player.vr;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SurfaceUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SurfaceUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public SurfaceUtil() {
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

    public static Surface create(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, surfaceTexture)) == null) {
            try {
                Surface surface = new Surface(surfaceTexture);
                Log.i(TAG, "create " + surface);
                return surface;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Surface) invokeL.objValue;
    }

    public static void release(Surface surface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, surface) == null) || surface == null) {
            return;
        }
        try {
            surface.release();
            Log.i(TAG, "release " + surface);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
