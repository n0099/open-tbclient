package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.location.BDLocation;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.coremedia.iso.Hex;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, Cea708Decoder.COMMAND_DSW, 138, Cea708Decoder.COMMAND_TGW, Cea708Decoder.COMMAND_DLW, Cea708Decoder.COMMAND_DLY, Cea708Decoder.COMMAND_DLC, Cea708Decoder.COMMAND_RST, Cea708Decoder.COMMAND_SPA, Cea708Decoder.COMMAND_SPC, Cea708Decoder.COMMAND_SPL, 147, 148, 149, 150, Cea708Decoder.COMMAND_SWA, Cea708Decoder.COMMAND_DF0, 153, Cea708Decoder.COMMAND_DF2, 155, Cea708Decoder.COMMAND_DS4, Cea708Decoder.COMMAND_DF5, Cea708Decoder.COMMAND_DF6, 159, 160, 161, BDLocation.TypeServerDecryptError, MatroskaExtractor.ID_SIMPLE_BLOCK, 164, 165, TTAdConstant.IMAGE_MODE_LIVE, 167, 168, 169, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, 173, MatroskaExtractor.ID_TRACK_ENTRY, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, MatroskaExtractor.ID_PIXEL_WIDTH, 177, 178, 179, 180, 181, 182, 183, H262Reader.START_GROUP, Constants.METHOD_IM_SEND_MCAST_MSG, MatroskaExtractor.ID_PIXEL_HEIGHT, MatroskaExtractor.ID_CUE_POINT, TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1, 190, 191, 192, 193, 194, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, JfifUtil.MARKER_SOI, 217, 218, 219, PassFaceRecogManager.k, 221, 222, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, 242, 243, GDiffPatcher.COPY_UBYTE_UBYTE, GDiffPatcher.COPY_UBYTE_USHORT, 246, GDiffPatcher.DATA_USHORT, GDiffPatcher.DATA_INT, 249, 250, 251, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.COPY_INT_USHORT})
/* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            for (int i = 106; i < 254; i++) {
                int i2 = i - 106;
                log.finest("pos:" + i2);
                iArr[i2] = i;
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
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
