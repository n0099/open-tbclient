package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void reportEncodedFrame(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (i3 = this.targetFps) == 0) {
            return;
        }
        int i4 = this.targetBitrateBps;
        double d2 = this.deviationBytes + (i2 - ((i4 / 8.0d) / i3));
        this.deviationBytes = d2;
        this.timeSinceLastAdjustmentMs += 1000.0d / i3;
        double d3 = i4 / 8.0d;
        double d4 = 3.0d * d3;
        double min = Math.min(d2, d4);
        this.deviationBytes = min;
        double max = Math.max(min, -d4);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d3) {
            int i5 = this.bitrateAdjustmentScaleExp - ((int) ((max / d3) + 0.5d));
            this.bitrateAdjustmentScaleExp = i5;
            this.bitrateAdjustmentScaleExp = Math.max(i5, -20);
            this.deviationBytes = d3;
        } else {
            double d5 = -d3;
            if (max < d5) {
                int i6 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d3) + 0.5d));
                this.bitrateAdjustmentScaleExp = i6;
                this.bitrateAdjustmentScaleExp = Math.min(i6, 20);
                this.deviationBytes = d5;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int i4 = this.targetBitrateBps;
            if (i4 > 0 && i2 < i4) {
                this.deviationBytes = (this.deviationBytes * i2) / i4;
            }
            super.setTargets(i2, i3);
        }
    }
}
