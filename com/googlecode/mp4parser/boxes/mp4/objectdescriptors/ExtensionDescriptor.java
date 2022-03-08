package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.coremedia.iso.Hex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kuaishou.weapon.un.w0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, Cea708Decoder.COMMAND_DLY, Cea708Decoder.COMMAND_DLC, 143, Cea708Decoder.COMMAND_SPA, 145, Cea708Decoder.COMMAND_SPL, 147, 148, Opcodes.FCMPL, 150, 151, Cea708Decoder.COMMAND_DF0, 153, 154, 155, Cea708Decoder.COMMAND_DS4, 157, 158, 159, 160, 161, 162, 163, IChannelPay.ID_IPAY_PAY_GAME, 165, 166, 167, w0.d0, 169, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, w0.f53860i, MatroskaExtractor.ID_TRACK_ENTRY, 175, 176, 177, 178, 179, 180, 181, Opcodes.INVOKEVIRTUAL, 183, 184, 185, 186, 187, 188, PsExtractor.PRIVATE_STREAM_1, 190, w0.M, 192, 193, 194, 195, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Opcodes.IFNULL, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, w0.A, w0.f53859h, 213, w0.c0, 215, 216, 217, 218, 219, 220, w0.h0, w0.k, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, w0.z, 228, 229, 230, 231, w0.c1, WriteActivity.CONTENT_MAX_COUNT, 234, w0.k0, 236, 237, 238, 239, 240, 241, 242, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 244, 245, 246, GDiffPatcher.DATA_USHORT, 248, 249, 250, 251, 252, GDiffPatcher.COPY_INT_USHORT})
/* loaded from: classes7.dex */
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
            int[] iArr = new int[148];
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
