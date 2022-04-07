package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    public static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    public static final int BITRATE_ADJUSTMENT_STEPS = 20;
    public static final double BITS_PER_BYTE = 8.0d;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitrateAdjustmentScaleExp;
    public double deviationBytes;
    public double timeSinceLastAdjustmentMs;

    public DynamicBitrateAdjuster() {
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

    private double getBitrateAdjustmentScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? Math.pow(4.0d, this.bitrateAdjustmentScaleExp / 20.0d) : invokeV.doubleValue;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (int) (this.targetBitrateBps * getBitrateAdjustmentScale()) : invokeV.intValue;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (i2 = this.targetFps) == 0) {
            return;
        }
        int i3 = this.targetBitrateBps;
        double d = this.deviationBytes + (i - ((i3 / 8.0d) / i2));
        this.deviationBytes = d;
        this.timeSinceLastAdjustmentMs += 1000.0d / i2;
        double d2 = i3 / 8.0d;
        double d3 = 3.0d * d2;
        double min = Math.min(d, d3);
        this.deviationBytes = min;
        double max = Math.max(min, -d3);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d2) {
            int i4 = this.bitrateAdjustmentScaleExp - ((int) ((max / d2) + 0.5d));
            this.bitrateAdjustmentScaleExp = i4;
            this.bitrateAdjustmentScaleExp = Math.max(i4, -20);
            this.deviationBytes = d2;
        } else {
            double d4 = -d2;
            if (max < d4) {
                int i5 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d2) + 0.5d));
                this.bitrateAdjustmentScaleExp = i5;
                this.bitrateAdjustmentScaleExp = Math.min(i5, 20);
                this.deviationBytes = d4;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int i3 = this.targetBitrateBps;
            if (i3 > 0 && i < i3) {
                this.deviationBytes = (this.deviationBytes * i) / i3;
            }
            super.setTargets(i, i2);
        }
    }
}
