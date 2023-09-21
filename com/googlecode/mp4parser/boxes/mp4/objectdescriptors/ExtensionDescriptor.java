package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.location.BDLocation;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.coremedia.iso.Hex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, Cea708Decoder.COMMAND_DSW, 138, Cea708Decoder.COMMAND_TGW, Cea708Decoder.COMMAND_DLW, 141, Cea708Decoder.COMMAND_DLC, Cea708Decoder.COMMAND_RST, Cea708Decoder.COMMAND_SPA, 145, Cea708Decoder.COMMAND_SPL, 147, 148, 149, 150, Cea708Decoder.COMMAND_SWA, Cea708Decoder.COMMAND_DF0, 153, Cea708Decoder.COMMAND_DF2, 155, Cea708Decoder.COMMAND_DS4, Cea708Decoder.COMMAND_DF5, Cea708Decoder.COMMAND_DF6, 159, 160, 161, BDLocation.TypeServerDecryptError, MatroskaExtractor.ID_SIMPLE_BLOCK, 164, 165, TTAdConstant.IMAGE_MODE_LIVE, 167, 168, 169, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, 173, MatroskaExtractor.ID_TRACK_ENTRY, 175, MatroskaExtractor.ID_PIXEL_WIDTH, 177, 178, 179, 180, 181, 182, 183, H262Reader.START_GROUP, Constants.METHOD_IM_SEND_MCAST_MSG, MatroskaExtractor.ID_PIXEL_HEIGHT, 187, TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1, 190, 191, 192, 193, 194, 195, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Constants.METHOD_IM_FETCH_BUSINESS_SESSION_MSG, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, PassFaceRecogManager.j, 221, 222, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, 227, 228, 229, 230, 231, 232, 233, 234, 235, Constants.METHOD_IM_CONSULT_NOTIFY_MSG, Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG, 238, Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG, 240, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, 242, 243, GDiffPatcher.COPY_UBYTE_UBYTE, GDiffPatcher.COPY_UBYTE_USHORT, 246, GDiffPatcher.DATA_USHORT, GDiffPatcher.DATA_INT, 249, 250, 251, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.COPY_INT_USHORT})
/* loaded from: classes9.dex */
public class ExtensionDescriptor extends BaseDescriptor {
    public static Logger log = Logger.getLogger(ExtensionDescriptor.class.getName());
    public byte[] bytes;

    public static int[] allTags() {
        int[] iArr = new int[148];
        for (int i = 106; i < 254; i++) {
            int i2 = i - 106;
            log.finest("pos:" + i2);
            iArr[i2] = i;
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        String encodeHex;
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        if (bArr == null) {
            encodeHex = StringUtil.NULL_STRING;
        } else {
            encodeHex = Hex.encodeHex(bArr);
        }
        sb.append(encodeHex);
        sb.append('}');
        return sb.toString();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        if (getSize() > 0) {
            byte[] bArr = new byte[this.sizeOfInstance];
            this.bytes = bArr;
            byteBuffer.get(bArr);
        }
    }
}
