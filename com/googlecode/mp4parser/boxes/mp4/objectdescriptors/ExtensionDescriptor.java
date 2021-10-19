package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.apollon.a;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.coremedia.iso.Hex;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, 132, 133, 134, 135, 136, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, Opcodes.LCMP, Opcodes.FCMPL, 150, Opcodes.DCMPL, 152, 153, Opcodes.IFNE, a.f37803e, 156, 157, 158, Opcodes.IF_ICMPEQ, 160, 161, 162, 163, IChannelPay.ID_IPAY_PAY_GAME, 165, 166, 167, 168, Opcodes.RET, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, 173, 174, 175, Opcodes.ARETURN, Opcodes.RETURN, 178, 179, 180, Opcodes.PUTFIELD, Opcodes.INVOKEVIRTUAL, 183, Opcodes.INVOKESTATIC, 185, 186, Opcodes.NEW, Opcodes.NEWARRAY, 189, 190, 191, 192, 193, 194, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, JfifUtil.MARKER_RST7, JfifUtil.MARKER_SOI, 217, 218, 219, PassLivenessRecogActivity.S, 221, 222, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, 227, 228, 229, 230, 231, 232, WriteActivity.CONTENT_MAX_COUNT, 234, 235, 236, 237, 238, 239, 240, BaseActivity.DIALOG_PROMPT, BaseActivity.DIALOG_LOADING, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 244, 245, 246, GDiffPatcher.DATA_USHORT, GDiffPatcher.DATA_INT, 249, 250, GDiffPatcher.COPY_USHORT_INT, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.COPY_INT_USHORT})
/* loaded from: classes10.dex */
public class ExtensionDescriptor extends BaseDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public static Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] bytes;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975021927, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/ExtensionDescriptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-975021927, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/ExtensionDescriptor;");
                return;
            }
        }
        log = Logger.getLogger(ExtensionDescriptor.class.getName());
    }

    public ExtensionDescriptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int[] allTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int[] iArr = new int[Opcodes.LCMP];
            for (int i2 = 106; i2 < 254; i2++) {
                int i3 = i2 - 106;
                log.finest("pos:" + i3);
                iArr[i3] = i2;
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) || getSize() <= 0) {
            return;
        }
        byte[] bArr = new byte[this.sizeOfInstance];
        this.bytes = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ExtensionDescriptor");
            sb.append("{bytes=");
            byte[] bArr = this.bytes;
            sb.append(bArr == null ? StringUtil.NULL_STRING : Hex.encodeHex(bArr));
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
