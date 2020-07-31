package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.apache.http.HttpStatus;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, Opcodes.IAND, 127, 128, 129, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, Opcodes.LCMP, Opcodes.FCMPL, 150, Opcodes.DCMPL, 152, Opcodes.IFEQ, Opcodes.IFNE, 155, 156, 157, Opcodes.IFLE, Opcodes.IF_ICMPEQ, 160, 161, 162, Opcodes.IF_ICMPGT, 164, Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPNE, 167, 168, Opcodes.RET, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, 173, 174, 175, Opcodes.ARETURN, Opcodes.RETURN, Opcodes.GETSTATIC, 179, 180, Opcodes.PUTFIELD, Opcodes.INVOKEVIRTUAL, 183, Opcodes.INVOKESTATIC, 185, 186, Opcodes.NEW, Opcodes.NEWARRAY, 189, 190, 191, 192, 193, DownloadConstants.STATUS_WAITING_TO_RETRY, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 203, 204, 205, 206, HttpStatus.SC_MULTI_STATUS, 208, 209, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, BaseActivity.DIALOG_PROMPT, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253})
/* loaded from: classes20.dex */
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
