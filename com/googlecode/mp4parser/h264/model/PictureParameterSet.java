package com.googlecode.mp4parser.h264.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class PictureParameterSet extends BitstreamElement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] bottom_right;
    public int chroma_qp_index_offset;
    public boolean constrained_intra_pred_flag;
    public boolean deblocking_filter_control_present_flag;
    public boolean entropy_coding_mode_flag;
    public PPSExt extended;
    public int num_ref_idx_l0_active_minus1;
    public int num_ref_idx_l1_active_minus1;
    public int num_slice_groups_minus1;
    public int pic_init_qp_minus26;
    public int pic_init_qs_minus26;
    public boolean pic_order_present_flag;
    public int pic_parameter_set_id;
    public boolean redundant_pic_cnt_present_flag;
    public int[] run_length_minus1;
    public int seq_parameter_set_id;
    public boolean slice_group_change_direction_flag;
    public int slice_group_change_rate_minus1;
    public int[] slice_group_id;
    public int slice_group_map_type;
    public int[] top_left;
    public int weighted_bipred_idc;
    public boolean weighted_pred_flag;

    /* loaded from: classes7.dex */
    public static class PPSExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean[] pic_scaling_list_present_flag;
        public ScalingMatrix scalindMatrix;
        public int second_chroma_qp_index_offset;
        public boolean transform_8x8_mode_flag;

        public PPSExt() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scalindMatrix = new ScalingMatrix();
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "PPSExt{transform_8x8_mode_flag=" + this.transform_8x8_mode_flag + ", scalindMatrix=" + this.scalindMatrix + ", second_chroma_qp_index_offset=" + this.second_chroma_qp_index_offset + ", pic_scaling_list_present_flag=" + this.pic_scaling_list_present_flag + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public PictureParameterSet() {
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

    public static PictureParameterSet read(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            CAVLCReader cAVLCReader = new CAVLCReader(inputStream);
            PictureParameterSet pictureParameterSet = new PictureParameterSet();
            pictureParameterSet.pic_parameter_set_id = cAVLCReader.readUE("PPS: pic_parameter_set_id");
            pictureParameterSet.seq_parameter_set_id = cAVLCReader.readUE("PPS: seq_parameter_set_id");
            pictureParameterSet.entropy_coding_mode_flag = cAVLCReader.readBool("PPS: entropy_coding_mode_flag");
            pictureParameterSet.pic_order_present_flag = cAVLCReader.readBool("PPS: pic_order_present_flag");
            int readUE = cAVLCReader.readUE("PPS: num_slice_groups_minus1");
            pictureParameterSet.num_slice_groups_minus1 = readUE;
            if (readUE > 0) {
                int readUE2 = cAVLCReader.readUE("PPS: slice_group_map_type");
                pictureParameterSet.slice_group_map_type = readUE2;
                int i = pictureParameterSet.num_slice_groups_minus1;
                pictureParameterSet.top_left = new int[i + 1];
                pictureParameterSet.bottom_right = new int[i + 1];
                pictureParameterSet.run_length_minus1 = new int[i + 1];
                if (readUE2 == 0) {
                    for (int i2 = 0; i2 <= pictureParameterSet.num_slice_groups_minus1; i2++) {
                        pictureParameterSet.run_length_minus1[i2] = cAVLCReader.readUE("PPS: run_length_minus1");
                    }
                } else if (readUE2 == 2) {
                    for (int i3 = 0; i3 < pictureParameterSet.num_slice_groups_minus1; i3++) {
                        pictureParameterSet.top_left[i3] = cAVLCReader.readUE("PPS: top_left");
                        pictureParameterSet.bottom_right[i3] = cAVLCReader.readUE("PPS: bottom_right");
                    }
                } else {
                    int i4 = 3;
                    if (readUE2 != 3 && readUE2 != 4 && readUE2 != 5) {
                        if (readUE2 == 6) {
                            if (i + 1 <= 4) {
                                if (i + 1 > 2) {
                                    i4 = 2;
                                } else {
                                    i4 = 1;
                                }
                            }
                            int readUE3 = cAVLCReader.readUE("PPS: pic_size_in_map_units_minus1");
                            pictureParameterSet.slice_group_id = new int[readUE3 + 1];
                            for (int i5 = 0; i5 <= readUE3; i5++) {
                                int[] iArr = pictureParameterSet.slice_group_id;
                                iArr[i5] = cAVLCReader.readU(i4, "PPS: slice_group_id [" + i5 + "]f");
                            }
                        }
                    } else {
                        pictureParameterSet.slice_group_change_direction_flag = cAVLCReader.readBool("PPS: slice_group_change_direction_flag");
                        pictureParameterSet.slice_group_change_rate_minus1 = cAVLCReader.readUE("PPS: slice_group_change_rate_minus1");
                    }
                }
            }
            pictureParameterSet.num_ref_idx_l0_active_minus1 = cAVLCReader.readUE("PPS: num_ref_idx_l0_active_minus1");
            pictureParameterSet.num_ref_idx_l1_active_minus1 = cAVLCReader.readUE("PPS: num_ref_idx_l1_active_minus1");
            pictureParameterSet.weighted_pred_flag = cAVLCReader.readBool("PPS: weighted_pred_flag");
            pictureParameterSet.weighted_bipred_idc = (int) cAVLCReader.readNBit(2, "PPS: weighted_bipred_idc");
            pictureParameterSet.pic_init_qp_minus26 = cAVLCReader.readSE("PPS: pic_init_qp_minus26");
            pictureParameterSet.pic_init_qs_minus26 = cAVLCReader.readSE("PPS: pic_init_qs_minus26");
            pictureParameterSet.chroma_qp_index_offset = cAVLCReader.readSE("PPS: chroma_qp_index_offset");
            pictureParameterSet.deblocking_filter_control_present_flag = cAVLCReader.readBool("PPS: deblocking_filter_control_present_flag");
            pictureParameterSet.constrained_intra_pred_flag = cAVLCReader.readBool("PPS: constrained_intra_pred_flag");
            pictureParameterSet.redundant_pic_cnt_present_flag = cAVLCReader.readBool("PPS: redundant_pic_cnt_present_flag");
            if (cAVLCReader.moreRBSPData()) {
                PPSExt pPSExt = new PPSExt();
                pictureParameterSet.extended = pPSExt;
                pPSExt.transform_8x8_mode_flag = cAVLCReader.readBool("PPS: transform_8x8_mode_flag");
                if (cAVLCReader.readBool("PPS: pic_scaling_matrix_present_flag")) {
                    for (int i6 = 0; i6 < ((pictureParameterSet.extended.transform_8x8_mode_flag ? 1 : 0) * 2) + 6; i6++) {
                        if (cAVLCReader.readBool("PPS: pic_scaling_list_present_flag")) {
                            ScalingMatrix scalingMatrix = pictureParameterSet.extended.scalindMatrix;
                            ScalingList[] scalingListArr = new ScalingList[8];
                            scalingMatrix.ScalingList4x4 = scalingListArr;
                            ScalingList[] scalingListArr2 = new ScalingList[8];
                            scalingMatrix.ScalingList8x8 = scalingListArr2;
                            if (i6 < 6) {
                                scalingListArr[i6] = ScalingList.read(cAVLCReader, 16);
                            } else {
                                scalingListArr2[i6 - 6] = ScalingList.read(cAVLCReader, 64);
                            }
                        }
                    }
                }
                pictureParameterSet.extended.second_chroma_qp_index_offset = cAVLCReader.readSE("PPS: second_chroma_qp_index_offset");
            }
            cAVLCReader.readTrailingBits();
            return pictureParameterSet;
        }
        return (PictureParameterSet) invokeL.objValue;
    }

    public static PictureParameterSet read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            return read(new ByteArrayInputStream(bArr));
        }
        return (PictureParameterSet) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PictureParameterSet.class != obj.getClass()) {
                return false;
            }
            PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
            if (!Arrays.equals(this.bottom_right, pictureParameterSet.bottom_right) || this.chroma_qp_index_offset != pictureParameterSet.chroma_qp_index_offset || this.constrained_intra_pred_flag != pictureParameterSet.constrained_intra_pred_flag || this.deblocking_filter_control_present_flag != pictureParameterSet.deblocking_filter_control_present_flag || this.entropy_coding_mode_flag != pictureParameterSet.entropy_coding_mode_flag) {
                return false;
            }
            PPSExt pPSExt = this.extended;
            if (pPSExt == null) {
                if (pictureParameterSet.extended != null) {
                    return false;
                }
            } else if (!pPSExt.equals(pictureParameterSet.extended)) {
                return false;
            }
            if (this.num_ref_idx_l0_active_minus1 == pictureParameterSet.num_ref_idx_l0_active_minus1 && this.num_ref_idx_l1_active_minus1 == pictureParameterSet.num_ref_idx_l1_active_minus1 && this.num_slice_groups_minus1 == pictureParameterSet.num_slice_groups_minus1 && this.pic_init_qp_minus26 == pictureParameterSet.pic_init_qp_minus26 && this.pic_init_qs_minus26 == pictureParameterSet.pic_init_qs_minus26 && this.pic_order_present_flag == pictureParameterSet.pic_order_present_flag && this.pic_parameter_set_id == pictureParameterSet.pic_parameter_set_id && this.redundant_pic_cnt_present_flag == pictureParameterSet.redundant_pic_cnt_present_flag && Arrays.equals(this.run_length_minus1, pictureParameterSet.run_length_minus1) && this.seq_parameter_set_id == pictureParameterSet.seq_parameter_set_id && this.slice_group_change_direction_flag == pictureParameterSet.slice_group_change_direction_flag && this.slice_group_change_rate_minus1 == pictureParameterSet.slice_group_change_rate_minus1 && Arrays.equals(this.slice_group_id, pictureParameterSet.slice_group_id) && this.slice_group_map_type == pictureParameterSet.slice_group_map_type && Arrays.equals(this.top_left, pictureParameterSet.top_left) && this.weighted_bipred_idc == pictureParameterSet.weighted_bipred_idc && this.weighted_pred_flag == pictureParameterSet.weighted_pred_flag) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int hashCode;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int hashCode2 = (((Arrays.hashCode(this.bottom_right) + 31) * 31) + this.chroma_qp_index_offset) * 31;
            int i7 = 1231;
            if (this.constrained_intra_pred_flag) {
                i = 1231;
            } else {
                i = 1237;
            }
            int i8 = (hashCode2 + i) * 31;
            if (this.deblocking_filter_control_present_flag) {
                i2 = 1231;
            } else {
                i2 = 1237;
            }
            int i9 = (i8 + i2) * 31;
            if (this.entropy_coding_mode_flag) {
                i3 = 1231;
            } else {
                i3 = 1237;
            }
            int i10 = (i9 + i3) * 31;
            PPSExt pPSExt = this.extended;
            if (pPSExt == null) {
                hashCode = 0;
            } else {
                hashCode = pPSExt.hashCode();
            }
            int i11 = (((((((((((i10 + hashCode) * 31) + this.num_ref_idx_l0_active_minus1) * 31) + this.num_ref_idx_l1_active_minus1) * 31) + this.num_slice_groups_minus1) * 31) + this.pic_init_qp_minus26) * 31) + this.pic_init_qs_minus26) * 31;
            if (this.pic_order_present_flag) {
                i4 = 1231;
            } else {
                i4 = 1237;
            }
            int i12 = (((i11 + i4) * 31) + this.pic_parameter_set_id) * 31;
            if (this.redundant_pic_cnt_present_flag) {
                i5 = 1231;
            } else {
                i5 = 1237;
            }
            int hashCode3 = (((((i12 + i5) * 31) + Arrays.hashCode(this.run_length_minus1)) * 31) + this.seq_parameter_set_id) * 31;
            if (this.slice_group_change_direction_flag) {
                i6 = 1231;
            } else {
                i6 = 1237;
            }
            int hashCode4 = (((((((((((hashCode3 + i6) * 31) + this.slice_group_change_rate_minus1) * 31) + Arrays.hashCode(this.slice_group_id)) * 31) + this.slice_group_map_type) * 31) + Arrays.hashCode(this.top_left)) * 31) + this.weighted_bipred_idc) * 31;
            if (!this.weighted_pred_flag) {
                i7 = 1237;
            }
            return hashCode4 + i7;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "PictureParameterSet{\n       entropy_coding_mode_flag=" + this.entropy_coding_mode_flag + ",\n       num_ref_idx_l0_active_minus1=" + this.num_ref_idx_l0_active_minus1 + ",\n       num_ref_idx_l1_active_minus1=" + this.num_ref_idx_l1_active_minus1 + ",\n       slice_group_change_rate_minus1=" + this.slice_group_change_rate_minus1 + ",\n       pic_parameter_set_id=" + this.pic_parameter_set_id + ",\n       seq_parameter_set_id=" + this.seq_parameter_set_id + ",\n       pic_order_present_flag=" + this.pic_order_present_flag + ",\n       num_slice_groups_minus1=" + this.num_slice_groups_minus1 + ",\n       slice_group_map_type=" + this.slice_group_map_type + ",\n       weighted_pred_flag=" + this.weighted_pred_flag + ",\n       weighted_bipred_idc=" + this.weighted_bipred_idc + ",\n       pic_init_qp_minus26=" + this.pic_init_qp_minus26 + ",\n       pic_init_qs_minus26=" + this.pic_init_qs_minus26 + ",\n       chroma_qp_index_offset=" + this.chroma_qp_index_offset + ",\n       deblocking_filter_control_present_flag=" + this.deblocking_filter_control_present_flag + ",\n       constrained_intra_pred_flag=" + this.constrained_intra_pred_flag + ",\n       redundant_pic_cnt_present_flag=" + this.redundant_pic_cnt_present_flag + ",\n       top_left=" + this.top_left + ",\n       bottom_right=" + this.bottom_right + ",\n       run_length_minus1=" + this.run_length_minus1 + ",\n       slice_group_change_direction_flag=" + this.slice_group_change_direction_flag + ",\n       slice_group_id=" + this.slice_group_id + ",\n       extended=" + this.extended + '}';
        }
        return (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.h264.model.BitstreamElement
    public void write(OutputStream outputStream) throws IOException {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, outputStream) == null) {
            CAVLCWriter cAVLCWriter = new CAVLCWriter(outputStream);
            cAVLCWriter.writeUE(this.pic_parameter_set_id, "PPS: pic_parameter_set_id");
            cAVLCWriter.writeUE(this.seq_parameter_set_id, "PPS: seq_parameter_set_id");
            cAVLCWriter.writeBool(this.entropy_coding_mode_flag, "PPS: entropy_coding_mode_flag");
            cAVLCWriter.writeBool(this.pic_order_present_flag, "PPS: pic_order_present_flag");
            cAVLCWriter.writeUE(this.num_slice_groups_minus1, "PPS: num_slice_groups_minus1");
            if (this.num_slice_groups_minus1 > 0) {
                cAVLCWriter.writeUE(this.slice_group_map_type, "PPS: slice_group_map_type");
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                int[] iArr3 = new int[1];
                int i = this.slice_group_map_type;
                if (i == 0) {
                    for (int i2 = 0; i2 <= this.num_slice_groups_minus1; i2++) {
                        cAVLCWriter.writeUE(iArr3[i2], "PPS: ");
                    }
                } else if (i == 2) {
                    for (int i3 = 0; i3 < this.num_slice_groups_minus1; i3++) {
                        cAVLCWriter.writeUE(iArr[i3], "PPS: ");
                        cAVLCWriter.writeUE(iArr2[i3], "PPS: ");
                    }
                } else {
                    int i4 = 3;
                    if (i != 3 && i != 4 && i != 5) {
                        if (i == 6) {
                            int i5 = this.num_slice_groups_minus1;
                            if (i5 + 1 <= 4) {
                                if (i5 + 1 > 2) {
                                    i4 = 2;
                                } else {
                                    i4 = 1;
                                }
                            }
                            cAVLCWriter.writeUE(this.slice_group_id.length, "PPS: ");
                            int i6 = 0;
                            while (true) {
                                int[] iArr4 = this.slice_group_id;
                                if (i6 > iArr4.length) {
                                    break;
                                }
                                cAVLCWriter.writeU(iArr4[i6], i4);
                                i6++;
                            }
                        }
                    } else {
                        cAVLCWriter.writeBool(this.slice_group_change_direction_flag, "PPS: slice_group_change_direction_flag");
                        cAVLCWriter.writeUE(this.slice_group_change_rate_minus1, "PPS: slice_group_change_rate_minus1");
                    }
                }
            }
            cAVLCWriter.writeUE(this.num_ref_idx_l0_active_minus1, "PPS: num_ref_idx_l0_active_minus1");
            cAVLCWriter.writeUE(this.num_ref_idx_l1_active_minus1, "PPS: num_ref_idx_l1_active_minus1");
            cAVLCWriter.writeBool(this.weighted_pred_flag, "PPS: weighted_pred_flag");
            cAVLCWriter.writeNBit(this.weighted_bipred_idc, 2, "PPS: weighted_bipred_idc");
            cAVLCWriter.writeSE(this.pic_init_qp_minus26, "PPS: pic_init_qp_minus26");
            cAVLCWriter.writeSE(this.pic_init_qs_minus26, "PPS: pic_init_qs_minus26");
            cAVLCWriter.writeSE(this.chroma_qp_index_offset, "PPS: chroma_qp_index_offset");
            cAVLCWriter.writeBool(this.deblocking_filter_control_present_flag, "PPS: deblocking_filter_control_present_flag");
            cAVLCWriter.writeBool(this.constrained_intra_pred_flag, "PPS: constrained_intra_pred_flag");
            cAVLCWriter.writeBool(this.redundant_pic_cnt_present_flag, "PPS: redundant_pic_cnt_present_flag");
            PPSExt pPSExt = this.extended;
            if (pPSExt != null) {
                cAVLCWriter.writeBool(pPSExt.transform_8x8_mode_flag, "PPS: transform_8x8_mode_flag");
                if (this.extended.scalindMatrix != null) {
                    z = true;
                } else {
                    z = false;
                }
                cAVLCWriter.writeBool(z, "PPS: scalindMatrix");
                if (this.extended.scalindMatrix != null) {
                    int i7 = 0;
                    while (true) {
                        PPSExt pPSExt2 = this.extended;
                        if (i7 >= ((pPSExt2.transform_8x8_mode_flag ? 1 : 0) * 2) + 6) {
                            break;
                        }
                        if (i7 < 6) {
                            if (pPSExt2.scalindMatrix.ScalingList4x4[i7] != null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            cAVLCWriter.writeBool(z3, "PPS: ");
                            ScalingList[] scalingListArr = this.extended.scalindMatrix.ScalingList4x4;
                            if (scalingListArr[i7] != null) {
                                scalingListArr[i7].write(cAVLCWriter);
                            }
                        } else {
                            int i8 = i7 - 6;
                            if (pPSExt2.scalindMatrix.ScalingList8x8[i8] != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            cAVLCWriter.writeBool(z2, "PPS: ");
                            ScalingList[] scalingListArr2 = this.extended.scalindMatrix.ScalingList8x8;
                            if (scalingListArr2[i8] != null) {
                                scalingListArr2[i8].write(cAVLCWriter);
                            }
                        }
                        i7++;
                    }
                }
                cAVLCWriter.writeSE(this.extended.second_chroma_qp_index_offset, "PPS: ");
            }
            cAVLCWriter.writeTrailingBits();
        }
    }
}
