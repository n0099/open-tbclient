package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.coremedia.iso.Hex;
import com.thunder.livesdk.system.ThunderNetStateService;
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, Constants.METHOD_IM_FRIEND_GROUP_DROP, 122, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, Opcodes.IAND, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128, 129, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, Opcodes.LCMP, Opcodes.FCMPL, 150, Opcodes.DCMPL, 152, Opcodes.IFEQ, Opcodes.IFNE, 155, 156, 157, Opcodes.IFLE, Opcodes.IF_ICMPEQ, 160, 161, 162, Opcodes.IF_ICMPGT, 164, Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPNE, 167, 168, Opcodes.RET, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, 173, 174, 175, Opcodes.ARETURN, Opcodes.RETURN, Opcodes.GETSTATIC, 179, 180, Opcodes.PUTFIELD, Opcodes.INVOKEVIRTUAL, 183, Opcodes.INVOKESTATIC, 185, 186, Opcodes.NEW, Opcodes.NEWARRAY, 189, 190, 191, 192, 193, DownloadConstants.STATUS_WAITING_TO_RETRY, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 203, 204, 205, 206, 207, 208, FAUEnum.PR_TIMEOUT, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265, VideoLiveConfig.EncodeType.PHONE_CODEC_X265, 222, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, 227, 228, 229, RtcConstants.METHOD_IM_RTC_MSG, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, BaseActivity.DIALOG_PROMPT, BaseActivity.DIALOG_LOADING, 243, GDiffPatcher.COPY_UBYTE_UBYTE, GDiffPatcher.COPY_UBYTE_USHORT, 246, GDiffPatcher.DATA_USHORT, GDiffPatcher.DATA_INT, 249, 250, GDiffPatcher.COPY_USHORT_INT, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.COPY_INT_USHORT})
/* loaded from: classes5.dex */
public class ExtensionDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(ExtensionDescriptor.class.getName());
    byte[] bytes;

    static int[] allTags() {
        int[] iArr = new int[Opcodes.LCMP];
        for (int i = 106; i < 254; i++) {
            int i2 = i + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL;
            log.finest("pos:" + i2);
            iArr[i2] = i;
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        if (getSize() > 0) {
            this.bytes = new byte[this.sizeOfInstance];
            byteBuffer.get(this.bytes);
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=").append(this.bytes == null ? "null" : Hex.encodeHex(this.bytes));
        sb.append('}');
        return sb.toString();
    }
}
