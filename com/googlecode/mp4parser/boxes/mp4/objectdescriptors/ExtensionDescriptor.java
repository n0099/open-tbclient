package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kuaishou.weapon.un.w0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, Cea708Decoder.COMMAND_DSW, 138, 139, Cea708Decoder.COMMAND_DLW, Cea708Decoder.COMMAND_DLY, Cea708Decoder.COMMAND_DLC, 143, Cea708Decoder.COMMAND_SPA, 145, Cea708Decoder.COMMAND_SPL, 147, w0.I, 149, 150, Cea708Decoder.COMMAND_SWA, Cea708Decoder.COMMAND_DF0, 153, Cea708Decoder.COMMAND_DF2, 155, Cea708Decoder.COMMAND_DS4, 157, 158, 159, 160, 161, 162, MatroskaExtractor.ID_SIMPLE_BLOCK, 164, w0.n0, 166, 167, w0.d0, w0.w, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 172, w0.i, MatroskaExtractor.ID_TRACK_ENTRY, 175, MatroskaExtractor.ID_PIXEL_WIDTH, w0.u, 178, 179, 180, 181, 182, 183, H262Reader.START_GROUP, Constants.METHOD_IM_SEND_MCAST_MSG, 186, MatroskaExtractor.ID_CUE_POINT, TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1, 190, w0.M, 192, 193, 194, 195, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 198, w0.b1, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, w0.A, w0.h, 213, w0.c0, 215, 216, 217, 218, 219, 220, w0.h0, w0.k, 223, 224, 225, Constants.METHOD_MEDIA_NOTIFY, w0.z, 228, 229, 230, 231, w0.c1, 233, 234, w0.k0, 236, 237, 238, 239, 240, 241, w0.i0, 243, GDiffPatcher.COPY_UBYTE_UBYTE, 245, 246, GDiffPatcher.DATA_USHORT, 248, 249, 250, 251, 252, GDiffPatcher.COPY_INT_USHORT})
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
            int[] iArr = new int[w0.I];
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
