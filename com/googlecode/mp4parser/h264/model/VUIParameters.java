package com.googlecode.mp4parser.h264.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class VUIParameters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AspectRatio aspect_ratio;
    public boolean aspect_ratio_info_present_flag;
    public BitstreamRestriction bitstreamRestriction;
    public boolean chroma_loc_info_present_flag;
    public int chroma_sample_loc_type_bottom_field;
    public int chroma_sample_loc_type_top_field;
    public boolean colour_description_present_flag;
    public int colour_primaries;
    public boolean fixed_frame_rate_flag;
    public boolean low_delay_hrd_flag;
    public int matrix_coefficients;
    public HRDParameters nalHRDParams;
    public int num_units_in_tick;
    public boolean overscan_appropriate_flag;
    public boolean overscan_info_present_flag;
    public boolean pic_struct_present_flag;
    public int sar_height;
    public int sar_width;
    public int time_scale;
    public boolean timing_info_present_flag;
    public int transfer_characteristics;
    public HRDParameters vclHRDParams;
    public int video_format;
    public boolean video_full_range_flag;
    public boolean video_signal_type_present_flag;

    /* loaded from: classes10.dex */
    public static class BitstreamRestriction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int log2_max_mv_length_horizontal;
        public int log2_max_mv_length_vertical;
        public int max_bits_per_mb_denom;
        public int max_bytes_per_pic_denom;
        public int max_dec_frame_buffering;
        public boolean motion_vectors_over_pic_boundaries_flag;
        public int num_reorder_frames;

        public BitstreamRestriction() {
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
                return "BitstreamRestriction{motion_vectors_over_pic_boundaries_flag=" + this.motion_vectors_over_pic_boundaries_flag + ", max_bytes_per_pic_denom=" + this.max_bytes_per_pic_denom + ", max_bits_per_mb_denom=" + this.max_bits_per_mb_denom + ", log2_max_mv_length_horizontal=" + this.log2_max_mv_length_horizontal + ", log2_max_mv_length_vertical=" + this.log2_max_mv_length_vertical + ", num_reorder_frames=" + this.num_reorder_frames + ", max_dec_frame_buffering=" + this.max_dec_frame_buffering + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public VUIParameters() {
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
            return "VUIParameters{\naspect_ratio_info_present_flag=" + this.aspect_ratio_info_present_flag + StringUtils.LF + ", sar_width=" + this.sar_width + StringUtils.LF + ", sar_height=" + this.sar_height + StringUtils.LF + ", overscan_info_present_flag=" + this.overscan_info_present_flag + StringUtils.LF + ", overscan_appropriate_flag=" + this.overscan_appropriate_flag + StringUtils.LF + ", video_signal_type_present_flag=" + this.video_signal_type_present_flag + StringUtils.LF + ", video_format=" + this.video_format + StringUtils.LF + ", video_full_range_flag=" + this.video_full_range_flag + StringUtils.LF + ", colour_description_present_flag=" + this.colour_description_present_flag + StringUtils.LF + ", colour_primaries=" + this.colour_primaries + StringUtils.LF + ", transfer_characteristics=" + this.transfer_characteristics + StringUtils.LF + ", matrix_coefficients=" + this.matrix_coefficients + StringUtils.LF + ", chroma_loc_info_present_flag=" + this.chroma_loc_info_present_flag + StringUtils.LF + ", chroma_sample_loc_type_top_field=" + this.chroma_sample_loc_type_top_field + StringUtils.LF + ", chroma_sample_loc_type_bottom_field=" + this.chroma_sample_loc_type_bottom_field + StringUtils.LF + ", timing_info_present_flag=" + this.timing_info_present_flag + StringUtils.LF + ", num_units_in_tick=" + this.num_units_in_tick + StringUtils.LF + ", time_scale=" + this.time_scale + StringUtils.LF + ", fixed_frame_rate_flag=" + this.fixed_frame_rate_flag + StringUtils.LF + ", low_delay_hrd_flag=" + this.low_delay_hrd_flag + StringUtils.LF + ", pic_struct_present_flag=" + this.pic_struct_present_flag + StringUtils.LF + ", nalHRDParams=" + this.nalHRDParams + StringUtils.LF + ", vclHRDParams=" + this.vclHRDParams + StringUtils.LF + ", bitstreamRestriction=" + this.bitstreamRestriction + StringUtils.LF + ", aspect_ratio=" + this.aspect_ratio + StringUtils.LF + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
