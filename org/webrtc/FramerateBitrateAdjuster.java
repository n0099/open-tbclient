package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INITIAL_FPS = 30;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getCodecConfigFramerate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 30;
        }
        return invokeV.intValue;
    }

    public FramerateBitrateAdjuster() {
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

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.targetFps == 0) {
                i2 = 30;
            }
            super.setTargets(i, i2);
            this.targetBitrateBps = (this.targetBitrateBps * 30) / this.targetFps;
        }
    }
}
