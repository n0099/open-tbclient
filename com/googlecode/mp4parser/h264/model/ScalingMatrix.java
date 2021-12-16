package com.googlecode.mp4parser.h264.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class ScalingMatrix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScalingList[] ScalingList4x4;
    public ScalingList[] ScalingList8x8;

    public ScalingMatrix() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder("ScalingMatrix{ScalingList4x4=");
            ScalingList[] scalingListArr = this.ScalingList4x4;
            sb.append(scalingListArr == null ? null : Arrays.asList(scalingListArr));
            sb.append(StringUtils.LF);
            sb.append(", ScalingList8x8=");
            ScalingList[] scalingListArr2 = this.ScalingList8x8;
            sb.append(scalingListArr2 != null ? Arrays.asList(scalingListArr2) : null);
            sb.append(StringUtils.LF);
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
