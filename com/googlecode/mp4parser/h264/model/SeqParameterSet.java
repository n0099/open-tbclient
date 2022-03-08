package com.googlecode.mp4parser.h264.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.model.VUIParameters;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class SeqParameterSet extends BitstreamElement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bit_depth_chroma_minus8;
    public int bit_depth_luma_minus8;
    public ChromaFormat chroma_format_idc;
    public boolean constraint_set_0_flag;
    public boolean constraint_set_1_flag;
    public boolean constraint_set_2_flag;
    public boolean constraint_set_3_flag;
    public boolean constraint_set_4_flag;
    public boolean constraint_set_5_flag;
    public boolean delta_pic_order_always_zero_flag;
    public boolean direct_8x8_inference_flag;
    public boolean entropy_coding_mode_flag;
    public boolean field_pic_flag;
    public int frame_crop_bottom_offset;
    public int frame_crop_left_offset;
    public int frame_crop_right_offset;
    public int frame_crop_top_offset;
    public boolean frame_cropping_flag;
    public boolean frame_mbs_only_flag;
    public boolean gaps_in_frame_num_value_allowed_flag;
    public int level_idc;
    public int log2_max_frame_num_minus4;
    public int log2_max_pic_order_cnt_lsb_minus4;
    public boolean mb_adaptive_frame_field_flag;
    public int num_ref_frames;
    public int num_ref_frames_in_pic_order_cnt_cycle;
    public int[] offsetForRefFrame;
    public int offset_for_non_ref_pic;
    public int offset_for_top_to_bottom_field;
    public int pic_height_in_map_units_minus1;
    public int pic_order_cnt_type;
    public int pic_width_in_mbs_minus1;
    public int profile_idc;
    public boolean qpprime_y_zero_transform_bypass_flag;
    public boolean residual_color_transform_flag;
    public ScalingMatrix scalingMatrix;
    public int seq_parameter_set_id;
    public VUIParameters vuiParams;
    public int weighted_bipred_idc;
    public boolean weighted_pred_flag;

    public SeqParameterSet() {
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

    public static VUIParameters ReadVUIParameters(CAVLCReader cAVLCReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cAVLCReader)) == null) {
            VUIParameters vUIParameters = new VUIParameters();
            boolean readBool = cAVLCReader.readBool("VUI: aspect_ratio_info_present_flag");
            vUIParameters.aspect_ratio_info_present_flag = readBool;
            if (readBool) {
                AspectRatio fromValue = AspectRatio.fromValue((int) cAVLCReader.readNBit(8, "VUI: aspect_ratio"));
                vUIParameters.aspect_ratio = fromValue;
                if (fromValue == AspectRatio.Extended_SAR) {
                    vUIParameters.sar_width = (int) cAVLCReader.readNBit(16, "VUI: sar_width");
                    vUIParameters.sar_height = (int) cAVLCReader.readNBit(16, "VUI: sar_height");
                }
            }
            boolean readBool2 = cAVLCReader.readBool("VUI: overscan_info_present_flag");
            vUIParameters.overscan_info_present_flag = readBool2;
            if (readBool2) {
                vUIParameters.overscan_appropriate_flag = cAVLCReader.readBool("VUI: overscan_appropriate_flag");
            }
            boolean readBool3 = cAVLCReader.readBool("VUI: video_signal_type_present_flag");
            vUIParameters.video_signal_type_present_flag = readBool3;
            if (readBool3) {
                vUIParameters.video_format = (int) cAVLCReader.readNBit(3, "VUI: video_format");
                vUIParameters.video_full_range_flag = cAVLCReader.readBool("VUI: video_full_range_flag");
                boolean readBool4 = cAVLCReader.readBool("VUI: colour_description_present_flag");
                vUIParameters.colour_description_present_flag = readBool4;
                if (readBool4) {
                    vUIParameters.colour_primaries = (int) cAVLCReader.readNBit(8, "VUI: colour_primaries");
                    vUIParameters.transfer_characteristics = (int) cAVLCReader.readNBit(8, "VUI: transfer_characteristics");
                    vUIParameters.matrix_coefficients = (int) cAVLCReader.readNBit(8, "VUI: matrix_coefficients");
                }
            }
            boolean readBool5 = cAVLCReader.readBool("VUI: chroma_loc_info_present_flag");
            vUIParameters.chroma_loc_info_present_flag = readBool5;
            if (readBool5) {
                vUIParameters.chroma_sample_loc_type_top_field = cAVLCReader.readUE("VUI chroma_sample_loc_type_top_field");
                vUIParameters.chroma_sample_loc_type_bottom_field = cAVLCReader.readUE("VUI chroma_sample_loc_type_bottom_field");
            }
            boolean readBool6 = cAVLCReader.readBool("VUI: timing_info_present_flag");
            vUIParameters.timing_info_present_flag = readBool6;
            if (readBool6) {
                vUIParameters.num_units_in_tick = (int) cAVLCReader.readNBit(32, "VUI: num_units_in_tick");
                vUIParameters.time_scale = (int) cAVLCReader.readNBit(32, "VUI: time_scale");
                vUIParameters.fixed_frame_rate_flag = cAVLCReader.readBool("VUI: fixed_frame_rate_flag");
            }
            boolean readBool7 = cAVLCReader.readBool("VUI: nal_hrd_parameters_present_flag");
            if (readBool7) {
                vUIParameters.nalHRDParams = readHRDParameters(cAVLCReader);
            }
            boolean readBool8 = cAVLCReader.readBool("VUI: vcl_hrd_parameters_present_flag");
            if (readBool8) {
                vUIParameters.vclHRDParams = readHRDParameters(cAVLCReader);
            }
            if (readBool7 || readBool8) {
                vUIParameters.low_delay_hrd_flag = cAVLCReader.readBool("VUI: low_delay_hrd_flag");
            }
            vUIParameters.pic_struct_present_flag = cAVLCReader.readBool("VUI: pic_struct_present_flag");
            if (cAVLCReader.readBool("VUI: bitstream_restriction_flag")) {
                VUIParameters.BitstreamRestriction bitstreamRestriction = new VUIParameters.BitstreamRestriction();
                vUIParameters.bitstreamRestriction = bitstreamRestriction;
                bitstreamRestriction.motion_vectors_over_pic_boundaries_flag = cAVLCReader.readBool("VUI: motion_vectors_over_pic_boundaries_flag");
                vUIParameters.bitstreamRestriction.max_bytes_per_pic_denom = cAVLCReader.readUE("VUI max_bytes_per_pic_denom");
                vUIParameters.bitstreamRestriction.max_bits_per_mb_denom = cAVLCReader.readUE("VUI max_bits_per_mb_denom");
                vUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal = cAVLCReader.readUE("VUI log2_max_mv_length_horizontal");
                vUIParameters.bitstreamRestriction.log2_max_mv_length_vertical = cAVLCReader.readUE("VUI log2_max_mv_length_vertical");
                vUIParameters.bitstreamRestriction.num_reorder_frames = cAVLCReader.readUE("VUI num_reorder_frames");
                vUIParameters.bitstreamRestriction.max_dec_frame_buffering = cAVLCReader.readUE("VUI max_dec_frame_buffering");
            }
            return vUIParameters;
        }
        return (VUIParameters) invokeL.objValue;
    }

    public static SeqParameterSet read(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            CAVLCReader cAVLCReader = new CAVLCReader(inputStream);
            SeqParameterSet seqParameterSet = new SeqParameterSet();
            seqParameterSet.profile_idc = (int) cAVLCReader.readNBit(8, "SPS: profile_idc");
            seqParameterSet.constraint_set_0_flag = cAVLCReader.readBool("SPS: constraint_set_0_flag");
            seqParameterSet.constraint_set_1_flag = cAVLCReader.readBool("SPS: constraint_set_1_flag");
            seqParameterSet.constraint_set_2_flag = cAVLCReader.readBool("SPS: constraint_set_2_flag");
            seqParameterSet.constraint_set_3_flag = cAVLCReader.readBool("SPS: constraint_set_3_flag");
            seqParameterSet.constraint_set_4_flag = cAVLCReader.readBool("SPS: constraint_set_4_flag");
            seqParameterSet.constraint_set_5_flag = cAVLCReader.readBool("SPS: constraint_set_5_flag");
            cAVLCReader.readNBit(2, "SPS: reserved_zero_2bits");
            seqParameterSet.level_idc = (int) cAVLCReader.readNBit(8, "SPS: level_idc");
            seqParameterSet.seq_parameter_set_id = cAVLCReader.readUE("SPS: seq_parameter_set_id");
            int i2 = seqParameterSet.profile_idc;
            if (i2 != 100 && i2 != 110 && i2 != 122 && i2 != 144) {
                seqParameterSet.chroma_format_idc = ChromaFormat.YUV_420;
            } else {
                ChromaFormat fromId = ChromaFormat.fromId(cAVLCReader.readUE("SPS: chroma_format_idc"));
                seqParameterSet.chroma_format_idc = fromId;
                if (fromId == ChromaFormat.YUV_444) {
                    seqParameterSet.residual_color_transform_flag = cAVLCReader.readBool("SPS: residual_color_transform_flag");
                }
                seqParameterSet.bit_depth_luma_minus8 = cAVLCReader.readUE("SPS: bit_depth_luma_minus8");
                seqParameterSet.bit_depth_chroma_minus8 = cAVLCReader.readUE("SPS: bit_depth_chroma_minus8");
                seqParameterSet.qpprime_y_zero_transform_bypass_flag = cAVLCReader.readBool("SPS: qpprime_y_zero_transform_bypass_flag");
                if (cAVLCReader.readBool("SPS: seq_scaling_matrix_present_lag")) {
                    readScalingListMatrix(cAVLCReader, seqParameterSet);
                }
            }
            seqParameterSet.log2_max_frame_num_minus4 = cAVLCReader.readUE("SPS: log2_max_frame_num_minus4");
            int readUE = cAVLCReader.readUE("SPS: pic_order_cnt_type");
            seqParameterSet.pic_order_cnt_type = readUE;
            if (readUE == 0) {
                seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 = cAVLCReader.readUE("SPS: log2_max_pic_order_cnt_lsb_minus4");
            } else if (readUE == 1) {
                seqParameterSet.delta_pic_order_always_zero_flag = cAVLCReader.readBool("SPS: delta_pic_order_always_zero_flag");
                seqParameterSet.offset_for_non_ref_pic = cAVLCReader.readSE("SPS: offset_for_non_ref_pic");
                seqParameterSet.offset_for_top_to_bottom_field = cAVLCReader.readSE("SPS: offset_for_top_to_bottom_field");
                int readUE2 = cAVLCReader.readUE("SPS: num_ref_frames_in_pic_order_cnt_cycle");
                seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle = readUE2;
                seqParameterSet.offsetForRefFrame = new int[readUE2];
                for (int i3 = 0; i3 < seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle; i3++) {
                    int[] iArr = seqParameterSet.offsetForRefFrame;
                    iArr[i3] = cAVLCReader.readSE("SPS: offsetForRefFrame [" + i3 + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            seqParameterSet.num_ref_frames = cAVLCReader.readUE("SPS: num_ref_frames");
            seqParameterSet.gaps_in_frame_num_value_allowed_flag = cAVLCReader.readBool("SPS: gaps_in_frame_num_value_allowed_flag");
            seqParameterSet.pic_width_in_mbs_minus1 = cAVLCReader.readUE("SPS: pic_width_in_mbs_minus1");
            seqParameterSet.pic_height_in_map_units_minus1 = cAVLCReader.readUE("SPS: pic_height_in_map_units_minus1");
            boolean readBool = cAVLCReader.readBool("SPS: frame_mbs_only_flag");
            seqParameterSet.frame_mbs_only_flag = readBool;
            if (!readBool) {
                seqParameterSet.mb_adaptive_frame_field_flag = cAVLCReader.readBool("SPS: mb_adaptive_frame_field_flag");
            }
            seqParameterSet.direct_8x8_inference_flag = cAVLCReader.readBool("SPS: direct_8x8_inference_flag");
            boolean readBool2 = cAVLCReader.readBool("SPS: frame_cropping_flag");
            seqParameterSet.frame_cropping_flag = readBool2;
            if (readBool2) {
                seqParameterSet.frame_crop_left_offset = cAVLCReader.readUE("SPS: frame_crop_left_offset");
                seqParameterSet.frame_crop_right_offset = cAVLCReader.readUE("SPS: frame_crop_right_offset");
                seqParameterSet.frame_crop_top_offset = cAVLCReader.readUE("SPS: frame_crop_top_offset");
                seqParameterSet.frame_crop_bottom_offset = cAVLCReader.readUE("SPS: frame_crop_bottom_offset");
            }
            if (cAVLCReader.readBool("SPS: vui_parameters_present_flag")) {
                seqParameterSet.vuiParams = ReadVUIParameters(cAVLCReader);
            }
            cAVLCReader.readTrailingBits();
            return seqParameterSet;
        }
        return (SeqParameterSet) invokeL.objValue;
    }

    public static HRDParameters readHRDParameters(CAVLCReader cAVLCReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cAVLCReader)) == null) {
            HRDParameters hRDParameters = new HRDParameters();
            hRDParameters.cpb_cnt_minus1 = cAVLCReader.readUE("SPS: cpb_cnt_minus1");
            hRDParameters.bit_rate_scale = (int) cAVLCReader.readNBit(4, "HRD: bit_rate_scale");
            hRDParameters.cpb_size_scale = (int) cAVLCReader.readNBit(4, "HRD: cpb_size_scale");
            int i2 = hRDParameters.cpb_cnt_minus1;
            hRDParameters.bit_rate_value_minus1 = new int[i2 + 1];
            hRDParameters.cpb_size_value_minus1 = new int[i2 + 1];
            hRDParameters.cbr_flag = new boolean[i2 + 1];
            for (int i3 = 0; i3 <= hRDParameters.cpb_cnt_minus1; i3++) {
                hRDParameters.bit_rate_value_minus1[i3] = cAVLCReader.readUE("HRD: bit_rate_value_minus1");
                hRDParameters.cpb_size_value_minus1[i3] = cAVLCReader.readUE("HRD: cpb_size_value_minus1");
                hRDParameters.cbr_flag[i3] = cAVLCReader.readBool("HRD: cbr_flag");
            }
            hRDParameters.initial_cpb_removal_delay_length_minus1 = (int) cAVLCReader.readNBit(5, "HRD: initial_cpb_removal_delay_length_minus1");
            hRDParameters.cpb_removal_delay_length_minus1 = (int) cAVLCReader.readNBit(5, "HRD: cpb_removal_delay_length_minus1");
            hRDParameters.dpb_output_delay_length_minus1 = (int) cAVLCReader.readNBit(5, "HRD: dpb_output_delay_length_minus1");
            hRDParameters.time_offset_length = (int) cAVLCReader.readNBit(5, "HRD: time_offset_length");
            return hRDParameters;
        }
        return (HRDParameters) invokeL.objValue;
    }

    public static void readScalingListMatrix(CAVLCReader cAVLCReader, SeqParameterSet seqParameterSet) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cAVLCReader, seqParameterSet) == null) {
            seqParameterSet.scalingMatrix = new ScalingMatrix();
            for (int i2 = 0; i2 < 8; i2++) {
                if (cAVLCReader.readBool("SPS: seqScalingListPresentFlag")) {
                    ScalingMatrix scalingMatrix = seqParameterSet.scalingMatrix;
                    ScalingList[] scalingListArr = new ScalingList[8];
                    scalingMatrix.ScalingList4x4 = scalingListArr;
                    ScalingList[] scalingListArr2 = new ScalingList[8];
                    scalingMatrix.ScalingList8x8 = scalingListArr2;
                    if (i2 < 6) {
                        scalingListArr[i2] = ScalingList.read(cAVLCReader, 16);
                    } else {
                        scalingListArr2[i2 - 6] = ScalingList.read(cAVLCReader, 64);
                    }
                }
            }
        }
    }

    private void writeHRDParameters(HRDParameters hRDParameters, CAVLCWriter cAVLCWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, hRDParameters, cAVLCWriter) == null) {
            cAVLCWriter.writeUE(hRDParameters.cpb_cnt_minus1, "HRD: cpb_cnt_minus1");
            cAVLCWriter.writeNBit(hRDParameters.bit_rate_scale, 4, "HRD: bit_rate_scale");
            cAVLCWriter.writeNBit(hRDParameters.cpb_size_scale, 4, "HRD: cpb_size_scale");
            for (int i2 = 0; i2 <= hRDParameters.cpb_cnt_minus1; i2++) {
                cAVLCWriter.writeUE(hRDParameters.bit_rate_value_minus1[i2], "HRD: ");
                cAVLCWriter.writeUE(hRDParameters.cpb_size_value_minus1[i2], "HRD: ");
                cAVLCWriter.writeBool(hRDParameters.cbr_flag[i2], "HRD: ");
            }
            cAVLCWriter.writeNBit(hRDParameters.initial_cpb_removal_delay_length_minus1, 5, "HRD: initial_cpb_removal_delay_length_minus1");
            cAVLCWriter.writeNBit(hRDParameters.cpb_removal_delay_length_minus1, 5, "HRD: cpb_removal_delay_length_minus1");
            cAVLCWriter.writeNBit(hRDParameters.dpb_output_delay_length_minus1, 5, "HRD: dpb_output_delay_length_minus1");
            cAVLCWriter.writeNBit(hRDParameters.time_offset_length, 5, "HRD: time_offset_length");
        }
    }

    private void writeVUIParameters(VUIParameters vUIParameters, CAVLCWriter cAVLCWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, vUIParameters, cAVLCWriter) == null) {
            cAVLCWriter.writeBool(vUIParameters.aspect_ratio_info_present_flag, "VUI: aspect_ratio_info_present_flag");
            if (vUIParameters.aspect_ratio_info_present_flag) {
                cAVLCWriter.writeNBit(vUIParameters.aspect_ratio.getValue(), 8, "VUI: aspect_ratio");
                if (vUIParameters.aspect_ratio == AspectRatio.Extended_SAR) {
                    cAVLCWriter.writeNBit(vUIParameters.sar_width, 16, "VUI: sar_width");
                    cAVLCWriter.writeNBit(vUIParameters.sar_height, 16, "VUI: sar_height");
                }
            }
            cAVLCWriter.writeBool(vUIParameters.overscan_info_present_flag, "VUI: overscan_info_present_flag");
            if (vUIParameters.overscan_info_present_flag) {
                cAVLCWriter.writeBool(vUIParameters.overscan_appropriate_flag, "VUI: overscan_appropriate_flag");
            }
            cAVLCWriter.writeBool(vUIParameters.video_signal_type_present_flag, "VUI: video_signal_type_present_flag");
            if (vUIParameters.video_signal_type_present_flag) {
                cAVLCWriter.writeNBit(vUIParameters.video_format, 3, "VUI: video_format");
                cAVLCWriter.writeBool(vUIParameters.video_full_range_flag, "VUI: video_full_range_flag");
                cAVLCWriter.writeBool(vUIParameters.colour_description_present_flag, "VUI: colour_description_present_flag");
                if (vUIParameters.colour_description_present_flag) {
                    cAVLCWriter.writeNBit(vUIParameters.colour_primaries, 8, "VUI: colour_primaries");
                    cAVLCWriter.writeNBit(vUIParameters.transfer_characteristics, 8, "VUI: transfer_characteristics");
                    cAVLCWriter.writeNBit(vUIParameters.matrix_coefficients, 8, "VUI: matrix_coefficients");
                }
            }
            cAVLCWriter.writeBool(vUIParameters.chroma_loc_info_present_flag, "VUI: chroma_loc_info_present_flag");
            if (vUIParameters.chroma_loc_info_present_flag) {
                cAVLCWriter.writeUE(vUIParameters.chroma_sample_loc_type_top_field, "VUI: chroma_sample_loc_type_top_field");
                cAVLCWriter.writeUE(vUIParameters.chroma_sample_loc_type_bottom_field, "VUI: chroma_sample_loc_type_bottom_field");
            }
            cAVLCWriter.writeBool(vUIParameters.timing_info_present_flag, "VUI: timing_info_present_flag");
            if (vUIParameters.timing_info_present_flag) {
                cAVLCWriter.writeNBit(vUIParameters.num_units_in_tick, 32, "VUI: num_units_in_tick");
                cAVLCWriter.writeNBit(vUIParameters.time_scale, 32, "VUI: time_scale");
                cAVLCWriter.writeBool(vUIParameters.fixed_frame_rate_flag, "VUI: fixed_frame_rate_flag");
            }
            cAVLCWriter.writeBool(vUIParameters.nalHRDParams != null, "VUI: ");
            HRDParameters hRDParameters = vUIParameters.nalHRDParams;
            if (hRDParameters != null) {
                writeHRDParameters(hRDParameters, cAVLCWriter);
            }
            cAVLCWriter.writeBool(vUIParameters.vclHRDParams != null, "VUI: ");
            HRDParameters hRDParameters2 = vUIParameters.vclHRDParams;
            if (hRDParameters2 != null) {
                writeHRDParameters(hRDParameters2, cAVLCWriter);
            }
            if (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null) {
                cAVLCWriter.writeBool(vUIParameters.low_delay_hrd_flag, "VUI: low_delay_hrd_flag");
            }
            cAVLCWriter.writeBool(vUIParameters.pic_struct_present_flag, "VUI: pic_struct_present_flag");
            cAVLCWriter.writeBool(vUIParameters.bitstreamRestriction != null, "VUI: ");
            VUIParameters.BitstreamRestriction bitstreamRestriction = vUIParameters.bitstreamRestriction;
            if (bitstreamRestriction != null) {
                cAVLCWriter.writeBool(bitstreamRestriction.motion_vectors_over_pic_boundaries_flag, "VUI: motion_vectors_over_pic_boundaries_flag");
                cAVLCWriter.writeUE(vUIParameters.bitstreamRestriction.max_bytes_per_pic_denom, "VUI: max_bytes_per_pic_denom");
                cAVLCWriter.writeUE(vUIParameters.bitstreamRestriction.max_bits_per_mb_denom, "VUI: max_bits_per_mb_denom");
                cAVLCWriter.writeUE(vUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal, "VUI: log2_max_mv_length_horizontal");
                cAVLCWriter.writeUE(vUIParameters.bitstreamRestriction.log2_max_mv_length_vertical, "VUI: log2_max_mv_length_vertical");
                cAVLCWriter.writeUE(vUIParameters.bitstreamRestriction.num_reorder_frames, "VUI: num_reorder_frames");
                cAVLCWriter.writeUE(vUIParameters.bitstreamRestriction.max_dec_frame_buffering, "VUI: max_dec_frame_buffering");
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SeqParameterSet{ \n        pic_order_cnt_type=" + this.pic_order_cnt_type + ", \n        field_pic_flag=" + this.field_pic_flag + ", \n        delta_pic_order_always_zero_flag=" + this.delta_pic_order_always_zero_flag + ", \n        weighted_pred_flag=" + this.weighted_pred_flag + ", \n        weighted_bipred_idc=" + this.weighted_bipred_idc + ", \n        entropy_coding_mode_flag=" + this.entropy_coding_mode_flag + ", \n        mb_adaptive_frame_field_flag=" + this.mb_adaptive_frame_field_flag + ", \n        direct_8x8_inference_flag=" + this.direct_8x8_inference_flag + ", \n        chroma_format_idc=" + this.chroma_format_idc + ", \n        log2_max_frame_num_minus4=" + this.log2_max_frame_num_minus4 + ", \n        log2_max_pic_order_cnt_lsb_minus4=" + this.log2_max_pic_order_cnt_lsb_minus4 + ", \n        pic_height_in_map_units_minus1=" + this.pic_height_in_map_units_minus1 + ", \n        pic_width_in_mbs_minus1=" + this.pic_width_in_mbs_minus1 + ", \n        bit_depth_luma_minus8=" + this.bit_depth_luma_minus8 + ", \n        bit_depth_chroma_minus8=" + this.bit_depth_chroma_minus8 + ", \n        qpprime_y_zero_transform_bypass_flag=" + this.qpprime_y_zero_transform_bypass_flag + ", \n        profile_idc=" + this.profile_idc + ", \n        constraint_set_0_flag=" + this.constraint_set_0_flag + ", \n        constraint_set_1_flag=" + this.constraint_set_1_flag + ", \n        constraint_set_2_flag=" + this.constraint_set_2_flag + ", \n        constraint_set_3_flag=" + this.constraint_set_3_flag + ", \n        constraint_set_4_flag=" + this.constraint_set_4_flag + ", \n        constraint_set_5_flag=" + this.constraint_set_5_flag + ", \n        level_idc=" + this.level_idc + ", \n        seq_parameter_set_id=" + this.seq_parameter_set_id + ", \n        residual_color_transform_flag=" + this.residual_color_transform_flag + ", \n        offset_for_non_ref_pic=" + this.offset_for_non_ref_pic + ", \n        offset_for_top_to_bottom_field=" + this.offset_for_top_to_bottom_field + ", \n        num_ref_frames=" + this.num_ref_frames + ", \n        gaps_in_frame_num_value_allowed_flag=" + this.gaps_in_frame_num_value_allowed_flag + ", \n        frame_mbs_only_flag=" + this.frame_mbs_only_flag + ", \n        frame_cropping_flag=" + this.frame_cropping_flag + ", \n        frame_crop_left_offset=" + this.frame_crop_left_offset + ", \n        frame_crop_right_offset=" + this.frame_crop_right_offset + ", \n        frame_crop_top_offset=" + this.frame_crop_top_offset + ", \n        frame_crop_bottom_offset=" + this.frame_crop_bottom_offset + ", \n        offsetForRefFrame=" + this.offsetForRefFrame + ", \n        vuiParams=" + this.vuiParams + ", \n        scalingMatrix=" + this.scalingMatrix + ", \n        num_ref_frames_in_pic_order_cnt_cycle=" + this.num_ref_frames_in_pic_order_cnt_cycle + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.h264.model.BitstreamElement
    public void write(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream) == null) {
            CAVLCWriter cAVLCWriter = new CAVLCWriter(outputStream);
            cAVLCWriter.writeNBit(this.profile_idc, 8, "SPS: profile_idc");
            cAVLCWriter.writeBool(this.constraint_set_0_flag, "SPS: constraint_set_0_flag");
            cAVLCWriter.writeBool(this.constraint_set_1_flag, "SPS: constraint_set_1_flag");
            cAVLCWriter.writeBool(this.constraint_set_2_flag, "SPS: constraint_set_2_flag");
            cAVLCWriter.writeBool(this.constraint_set_3_flag, "SPS: constraint_set_3_flag");
            cAVLCWriter.writeNBit(0L, 4, "SPS: reserved");
            cAVLCWriter.writeNBit(this.level_idc, 8, "SPS: level_idc");
            cAVLCWriter.writeUE(this.seq_parameter_set_id, "SPS: seq_parameter_set_id");
            int i2 = this.profile_idc;
            if (i2 == 100 || i2 == 110 || i2 == 122 || i2 == 144) {
                cAVLCWriter.writeUE(this.chroma_format_idc.getId(), "SPS: chroma_format_idc");
                if (this.chroma_format_idc == ChromaFormat.YUV_444) {
                    cAVLCWriter.writeBool(this.residual_color_transform_flag, "SPS: residual_color_transform_flag");
                }
                cAVLCWriter.writeUE(this.bit_depth_luma_minus8, "SPS: ");
                cAVLCWriter.writeUE(this.bit_depth_chroma_minus8, "SPS: ");
                cAVLCWriter.writeBool(this.qpprime_y_zero_transform_bypass_flag, "SPS: qpprime_y_zero_transform_bypass_flag");
                cAVLCWriter.writeBool(this.scalingMatrix != null, "SPS: ");
                if (this.scalingMatrix != null) {
                    for (int i3 = 0; i3 < 8; i3++) {
                        if (i3 < 6) {
                            cAVLCWriter.writeBool(this.scalingMatrix.ScalingList4x4[i3] != null, "SPS: ");
                            ScalingList[] scalingListArr = this.scalingMatrix.ScalingList4x4;
                            if (scalingListArr[i3] != null) {
                                scalingListArr[i3].write(cAVLCWriter);
                            }
                        } else {
                            int i4 = i3 - 6;
                            cAVLCWriter.writeBool(this.scalingMatrix.ScalingList8x8[i4] != null, "SPS: ");
                            ScalingList[] scalingListArr2 = this.scalingMatrix.ScalingList8x8;
                            if (scalingListArr2[i4] != null) {
                                scalingListArr2[i4].write(cAVLCWriter);
                            }
                        }
                    }
                }
            }
            cAVLCWriter.writeUE(this.log2_max_frame_num_minus4, "SPS: log2_max_frame_num_minus4");
            cAVLCWriter.writeUE(this.pic_order_cnt_type, "SPS: pic_order_cnt_type");
            int i5 = this.pic_order_cnt_type;
            if (i5 == 0) {
                cAVLCWriter.writeUE(this.log2_max_pic_order_cnt_lsb_minus4, "SPS: log2_max_pic_order_cnt_lsb_minus4");
            } else if (i5 == 1) {
                cAVLCWriter.writeBool(this.delta_pic_order_always_zero_flag, "SPS: delta_pic_order_always_zero_flag");
                cAVLCWriter.writeSE(this.offset_for_non_ref_pic, "SPS: offset_for_non_ref_pic");
                cAVLCWriter.writeSE(this.offset_for_top_to_bottom_field, "SPS: offset_for_top_to_bottom_field");
                cAVLCWriter.writeUE(this.offsetForRefFrame.length, "SPS: ");
                int i6 = 0;
                while (true) {
                    int[] iArr = this.offsetForRefFrame;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    cAVLCWriter.writeSE(iArr[i6], "SPS: ");
                    i6++;
                }
            }
            cAVLCWriter.writeUE(this.num_ref_frames, "SPS: num_ref_frames");
            cAVLCWriter.writeBool(this.gaps_in_frame_num_value_allowed_flag, "SPS: gaps_in_frame_num_value_allowed_flag");
            cAVLCWriter.writeUE(this.pic_width_in_mbs_minus1, "SPS: pic_width_in_mbs_minus1");
            cAVLCWriter.writeUE(this.pic_height_in_map_units_minus1, "SPS: pic_height_in_map_units_minus1");
            cAVLCWriter.writeBool(this.frame_mbs_only_flag, "SPS: frame_mbs_only_flag");
            if (!this.frame_mbs_only_flag) {
                cAVLCWriter.writeBool(this.mb_adaptive_frame_field_flag, "SPS: mb_adaptive_frame_field_flag");
            }
            cAVLCWriter.writeBool(this.direct_8x8_inference_flag, "SPS: direct_8x8_inference_flag");
            cAVLCWriter.writeBool(this.frame_cropping_flag, "SPS: frame_cropping_flag");
            if (this.frame_cropping_flag) {
                cAVLCWriter.writeUE(this.frame_crop_left_offset, "SPS: frame_crop_left_offset");
                cAVLCWriter.writeUE(this.frame_crop_right_offset, "SPS: frame_crop_right_offset");
                cAVLCWriter.writeUE(this.frame_crop_top_offset, "SPS: frame_crop_top_offset");
                cAVLCWriter.writeUE(this.frame_crop_bottom_offset, "SPS: frame_crop_bottom_offset");
            }
            cAVLCWriter.writeBool(this.vuiParams != null, "SPS: ");
            VUIParameters vUIParameters = this.vuiParams;
            if (vUIParameters != null) {
                writeVUIParameters(vUIParameters, cAVLCWriter);
            }
            cAVLCWriter.writeTrailingBits();
        }
    }
}
