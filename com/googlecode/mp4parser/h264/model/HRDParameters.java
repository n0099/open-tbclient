package com.googlecode.mp4parser.h264.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class HRDParameters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bit_rate_scale;
    public int[] bit_rate_value_minus1;
    public boolean[] cbr_flag;
    public int cpb_cnt_minus1;
    public int cpb_removal_delay_length_minus1;
    public int cpb_size_scale;
    public int[] cpb_size_value_minus1;
    public int dpb_output_delay_length_minus1;
    public int initial_cpb_removal_delay_length_minus1;
    public int time_offset_length;

    public HRDParameters() {
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
            return "HRDParameters{cpb_cnt_minus1=" + this.cpb_cnt_minus1 + ", bit_rate_scale=" + this.bit_rate_scale + ", cpb_size_scale=" + this.cpb_size_scale + ", bit_rate_value_minus1=" + Arrays.toString(this.bit_rate_value_minus1) + ", cpb_size_value_minus1=" + Arrays.toString(this.cpb_size_value_minus1) + ", cbr_flag=" + Arrays.toString(this.cbr_flag) + ", initial_cpb_removal_delay_length_minus1=" + this.initial_cpb_removal_delay_length_minus1 + ", cpb_removal_delay_length_minus1=" + this.cpb_removal_delay_length_minus1 + ", dpb_output_delay_length_minus1=" + this.dpb_output_delay_length_minus1 + ", time_offset_length=" + this.time_offset_length + '}';
        }
        return (String) invokeV.objValue;
    }
}
