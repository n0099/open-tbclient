package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.IDevices;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.location.BDLocation;
import com.baidu.sapi2.SapiAccountManager;
import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.apache.http.HttpStatus;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, BDLocation.TypeNetWorkLocation, BDLocation.TypeServerDecryptError, 163, 164, 165, 166, BDLocation.TypeServerError, 168, 169, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, IDevices.EM_AARCH64, 184, Constants.METHOD_IM_SEND_MCAST_MSG, 186, 187, 188, 189, 190, 191, DownloadConstants.STATUS_RUNNING, 193, DownloadConstants.STATUS_WAITING_TO_RETRY, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 198, 199, 200, 201, 202, 203, 204, 205, 206, HttpStatus.SC_MULTI_STATUS, 208, 209, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, SapiAccountManager.VERSION_CODE, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, BaseActivity.DIALOG_PROMPT, BaseActivity.DIALOG_LOADING, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253})
/* loaded from: classes5.dex */
public class ExtensionDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(ExtensionDescriptor.class.getName());
    byte[] bytes;

    static int[] allTags() {
        int[] iArr = new int[148];
        for (int i = 106; i < 254; i++) {
            int i2 = i - 106;
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
