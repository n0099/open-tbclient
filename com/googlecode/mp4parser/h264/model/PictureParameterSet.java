package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class PictureParameterSet extends BitstreamElement {
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

    /* loaded from: classes6.dex */
    public static class PPSExt {
        public boolean[] pic_scaling_list_present_flag;
        public ScalingMatrix scalindMatrix = new ScalingMatrix();
        public int second_chroma_qp_index_offset;
        public boolean transform_8x8_mode_flag;

        public String toString() {
            return "PPSExt{transform_8x8_mode_flag=" + this.transform_8x8_mode_flag + ", scalindMatrix=" + this.scalindMatrix + ", second_chroma_qp_index_offset=" + this.second_chroma_qp_index_offset + ", pic_scaling_list_present_flag=" + this.pic_scaling_list_present_flag + '}';
        }
    }

    public static PictureParameterSet read(byte[] bArr) throws IOException {
        return read(new ByteArrayInputStream(bArr));
    }

    public static PictureParameterSet read(InputStream inputStream) throws IOException {
        int i = 3;
        CAVLCReader cAVLCReader = new CAVLCReader(inputStream);
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.pic_parameter_set_id = cAVLCReader.readUE("PPS: pic_parameter_set_id");
        pictureParameterSet.seq_parameter_set_id = cAVLCReader.readUE("PPS: seq_parameter_set_id");
        pictureParameterSet.entropy_coding_mode_flag = cAVLCReader.readBool("PPS: entropy_coding_mode_flag");
        pictureParameterSet.pic_order_present_flag = cAVLCReader.readBool("PPS: pic_order_present_flag");
        pictureParameterSet.num_slice_groups_minus1 = cAVLCReader.readUE("PPS: num_slice_groups_minus1");
        if (pictureParameterSet.num_slice_groups_minus1 > 0) {
            pictureParameterSet.slice_group_map_type = cAVLCReader.readUE("PPS: slice_group_map_type");
            pictureParameterSet.top_left = new int[pictureParameterSet.num_slice_groups_minus1 + 1];
            pictureParameterSet.bottom_right = new int[pictureParameterSet.num_slice_groups_minus1 + 1];
            pictureParameterSet.run_length_minus1 = new int[pictureParameterSet.num_slice_groups_minus1 + 1];
            if (pictureParameterSet.slice_group_map_type == 0) {
                for (int i2 = 0; i2 <= pictureParameterSet.num_slice_groups_minus1; i2++) {
                    pictureParameterSet.run_length_minus1[i2] = cAVLCReader.readUE("PPS: run_length_minus1");
                }
            } else if (pictureParameterSet.slice_group_map_type == 2) {
                for (int i3 = 0; i3 < pictureParameterSet.num_slice_groups_minus1; i3++) {
                    pictureParameterSet.top_left[i3] = cAVLCReader.readUE("PPS: top_left");
                    pictureParameterSet.bottom_right[i3] = cAVLCReader.readUE("PPS: bottom_right");
                }
            } else if (pictureParameterSet.slice_group_map_type == 3 || pictureParameterSet.slice_group_map_type == 4 || pictureParameterSet.slice_group_map_type == 5) {
                pictureParameterSet.slice_group_change_direction_flag = cAVLCReader.readBool("PPS: slice_group_change_direction_flag");
                pictureParameterSet.slice_group_change_rate_minus1 = cAVLCReader.readUE("PPS: slice_group_change_rate_minus1");
            } else if (pictureParameterSet.slice_group_map_type == 6) {
                if (pictureParameterSet.num_slice_groups_minus1 + 1 <= 4) {
                    i = pictureParameterSet.num_slice_groups_minus1 + 1 > 2 ? 2 : 1;
                }
                int readUE = cAVLCReader.readUE("PPS: pic_size_in_map_units_minus1");
                pictureParameterSet.slice_group_id = new int[readUE + 1];
                for (int i4 = 0; i4 <= readUE; i4++) {
                    pictureParameterSet.slice_group_id[i4] = cAVLCReader.readU(i, "PPS: slice_group_id [" + i4 + "]f");
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
            pictureParameterSet.extended = new PPSExt();
            pictureParameterSet.extended.transform_8x8_mode_flag = cAVLCReader.readBool("PPS: transform_8x8_mode_flag");
            if (cAVLCReader.readBool("PPS: pic_scaling_matrix_present_flag")) {
                int i5 = 0;
                while (true) {
                    if (i5 >= ((pictureParameterSet.extended.transform_8x8_mode_flag ? 1 : 0) * 2) + 6) {
                        break;
                    }
                    if (cAVLCReader.readBool("PPS: pic_scaling_list_present_flag")) {
                        pictureParameterSet.extended.scalindMatrix.ScalingList4x4 = new ScalingList[8];
                        pictureParameterSet.extended.scalindMatrix.ScalingList8x8 = new ScalingList[8];
                        if (i5 < 6) {
                            pictureParameterSet.extended.scalindMatrix.ScalingList4x4[i5] = ScalingList.read(cAVLCReader, 16);
                        } else {
                            pictureParameterSet.extended.scalindMatrix.ScalingList8x8[i5 - 6] = ScalingList.read(cAVLCReader, 64);
                        }
                    }
                    i5++;
                }
            }
            pictureParameterSet.extended.second_chroma_qp_index_offset = cAVLCReader.readSE("PPS: second_chroma_qp_index_offset");
        }
        cAVLCReader.readTrailingBits();
        return pictureParameterSet;
    }

    @Override // com.googlecode.mp4parser.h264.model.BitstreamElement
    public void write(OutputStream outputStream) throws IOException {
        int i = 3;
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
            if (this.slice_group_map_type == 0) {
                for (int i2 = 0; i2 <= this.num_slice_groups_minus1; i2++) {
                    cAVLCWriter.writeUE(iArr3[i2], "PPS: ");
                }
            } else if (this.slice_group_map_type == 2) {
                for (int i3 = 0; i3 < this.num_slice_groups_minus1; i3++) {
                    cAVLCWriter.writeUE(iArr[i3], "PPS: ");
                    cAVLCWriter.writeUE(iArr2[i3], "PPS: ");
                }
            } else if (this.slice_group_map_type == 3 || this.slice_group_map_type == 4 || this.slice_group_map_type == 5) {
                cAVLCWriter.writeBool(this.slice_group_change_direction_flag, "PPS: slice_group_change_direction_flag");
                cAVLCWriter.writeUE(this.slice_group_change_rate_minus1, "PPS: slice_group_change_rate_minus1");
            } else if (this.slice_group_map_type == 6) {
                if (this.num_slice_groups_minus1 + 1 <= 4) {
                    i = this.num_slice_groups_minus1 + 1 > 2 ? 2 : 1;
                }
                cAVLCWriter.writeUE(this.slice_group_id.length, "PPS: ");
                for (int i4 = 0; i4 <= this.slice_group_id.length; i4++) {
                    cAVLCWriter.writeU(this.slice_group_id[i4], i);
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
        if (this.extended != null) {
            cAVLCWriter.writeBool(this.extended.transform_8x8_mode_flag, "PPS: transform_8x8_mode_flag");
            cAVLCWriter.writeBool(this.extended.scalindMatrix != null, "PPS: scalindMatrix");
            if (this.extended.scalindMatrix != null) {
                int i5 = 0;
                while (true) {
                    if (i5 >= ((this.extended.transform_8x8_mode_flag ? 1 : 0) * 2) + 6) {
                        break;
                    }
                    if (i5 < 6) {
                        cAVLCWriter.writeBool(this.extended.scalindMatrix.ScalingList4x4[i5] != null, "PPS: ");
                        if (this.extended.scalindMatrix.ScalingList4x4[i5] != null) {
                            this.extended.scalindMatrix.ScalingList4x4[i5].write(cAVLCWriter);
                        }
                    } else {
                        cAVLCWriter.writeBool(this.extended.scalindMatrix.ScalingList8x8[i5 + (-6)] != null, "PPS: ");
                        if (this.extended.scalindMatrix.ScalingList8x8[i5 - 6] != null) {
                            this.extended.scalindMatrix.ScalingList8x8[i5 - 6].write(cAVLCWriter);
                        }
                    }
                    i5++;
                }
            }
            cAVLCWriter.writeSE(this.extended.second_chroma_qp_index_offset, "PPS: ");
        }
        cAVLCWriter.writeTrailingBits();
    }

    public int hashCode() {
        return (((((((((((((this.slice_group_change_direction_flag ? 1231 : 1237) + (((((((this.redundant_pic_cnt_present_flag ? 1231 : 1237) + (((((this.pic_order_present_flag ? 1231 : 1237) + (((((((((((((this.extended == null ? 0 : this.extended.hashCode()) + (((this.entropy_coding_mode_flag ? 1231 : 1237) + (((this.deblocking_filter_control_present_flag ? 1231 : 1237) + (((this.constrained_intra_pred_flag ? 1231 : 1237) + ((((Arrays.hashCode(this.bottom_right) + 31) * 31) + this.chroma_qp_index_offset) * 31)) * 31)) * 31)) * 31)) * 31) + this.num_ref_idx_l0_active_minus1) * 31) + this.num_ref_idx_l1_active_minus1) * 31) + this.num_slice_groups_minus1) * 31) + this.pic_init_qp_minus26) * 31) + this.pic_init_qs_minus26) * 31)) * 31) + this.pic_parameter_set_id) * 31)) * 31) + Arrays.hashCode(this.run_length_minus1)) * 31) + this.seq_parameter_set_id) * 31)) * 31) + this.slice_group_change_rate_minus1) * 31) + Arrays.hashCode(this.slice_group_id)) * 31) + this.slice_group_map_type) * 31) + Arrays.hashCode(this.top_left)) * 31) + this.weighted_bipred_idc) * 31) + (this.weighted_pred_flag ? 1231 : 1237);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
            if (Arrays.equals(this.bottom_right, pictureParameterSet.bottom_right) && this.chroma_qp_index_offset == pictureParameterSet.chroma_qp_index_offset && this.constrained_intra_pred_flag == pictureParameterSet.constrained_intra_pred_flag && this.deblocking_filter_control_present_flag == pictureParameterSet.deblocking_filter_control_present_flag && this.entropy_coding_mode_flag == pictureParameterSet.entropy_coding_mode_flag) {
                if (this.extended == null) {
                    if (pictureParameterSet.extended != null) {
                        return false;
                    }
                } else if (!this.extended.equals(pictureParameterSet.extended)) {
                    return false;
                }
                return this.num_ref_idx_l0_active_minus1 == pictureParameterSet.num_ref_idx_l0_active_minus1 && this.num_ref_idx_l1_active_minus1 == pictureParameterSet.num_ref_idx_l1_active_minus1 && this.num_slice_groups_minus1 == pictureParameterSet.num_slice_groups_minus1 && this.pic_init_qp_minus26 == pictureParameterSet.pic_init_qp_minus26 && this.pic_init_qs_minus26 == pictureParameterSet.pic_init_qs_minus26 && this.pic_order_present_flag == pictureParameterSet.pic_order_present_flag && this.pic_parameter_set_id == pictureParameterSet.pic_parameter_set_id && this.redundant_pic_cnt_present_flag == pictureParameterSet.redundant_pic_cnt_present_flag && Arrays.equals(this.run_length_minus1, pictureParameterSet.run_length_minus1) && this.seq_parameter_set_id == pictureParameterSet.seq_parameter_set_id && this.slice_group_change_direction_flag == pictureParameterSet.slice_group_change_direction_flag && this.slice_group_change_rate_minus1 == pictureParameterSet.slice_group_change_rate_minus1 && Arrays.equals(this.slice_group_id, pictureParameterSet.slice_group_id) && this.slice_group_map_type == pictureParameterSet.slice_group_map_type && Arrays.equals(this.top_left, pictureParameterSet.top_left) && this.weighted_bipred_idc == pictureParameterSet.weighted_bipred_idc && this.weighted_pred_flag == pictureParameterSet.weighted_pred_flag;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "PictureParameterSet{\n       entropy_coding_mode_flag=" + this.entropy_coding_mode_flag + ",\n       num_ref_idx_l0_active_minus1=" + this.num_ref_idx_l0_active_minus1 + ",\n       num_ref_idx_l1_active_minus1=" + this.num_ref_idx_l1_active_minus1 + ",\n       slice_group_change_rate_minus1=" + this.slice_group_change_rate_minus1 + ",\n       pic_parameter_set_id=" + this.pic_parameter_set_id + ",\n       seq_parameter_set_id=" + this.seq_parameter_set_id + ",\n       pic_order_present_flag=" + this.pic_order_present_flag + ",\n       num_slice_groups_minus1=" + this.num_slice_groups_minus1 + ",\n       slice_group_map_type=" + this.slice_group_map_type + ",\n       weighted_pred_flag=" + this.weighted_pred_flag + ",\n       weighted_bipred_idc=" + this.weighted_bipred_idc + ",\n       pic_init_qp_minus26=" + this.pic_init_qp_minus26 + ",\n       pic_init_qs_minus26=" + this.pic_init_qs_minus26 + ",\n       chroma_qp_index_offset=" + this.chroma_qp_index_offset + ",\n       deblocking_filter_control_present_flag=" + this.deblocking_filter_control_present_flag + ",\n       constrained_intra_pred_flag=" + this.constrained_intra_pred_flag + ",\n       redundant_pic_cnt_present_flag=" + this.redundant_pic_cnt_present_flag + ",\n       top_left=" + this.top_left + ",\n       bottom_right=" + this.bottom_right + ",\n       run_length_minus1=" + this.run_length_minus1 + ",\n       slice_group_change_direction_flag=" + this.slice_group_change_direction_flag + ",\n       slice_group_id=" + this.slice_group_id + ",\n       extended=" + this.extended + '}';
    }
}
