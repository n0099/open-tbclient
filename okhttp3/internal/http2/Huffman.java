package okhttp3.internal.http2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNodeJNIBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes8.dex */
public class Huffman {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] CODES;
    public static final byte[] CODE_LENGTHS;
    public static final Huffman INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final Node root;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(660725785, "Lokhttp3/internal/http2/Huffman;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(660725785, "Lokhttp3/internal/http2/Huffman;");
                return;
            }
        }
        CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, GDiffPatcher.COPY_INT_USHORT, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        CODE_LENGTHS = new byte[]{13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, Constants.GZIP_CAST_TYPE, 10, 10, 8, Constants.GZIP_CAST_TYPE, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, Constants.GZIP_CAST_TYPE, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        INSTANCE = new Huffman();
    }

    public Huffman() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.root = new Node();
        buildTree();
    }

    private void addCode(int i, int i2, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Byte.valueOf(b2)}) == null) {
            Node node = new Node(i, b2);
            Node node2 = this.root;
            while (b2 > 8) {
                b2 = (byte) (b2 - 8);
                int i3 = (i2 >>> b2) & 255;
                Node[] nodeArr = node2.children;
                if (nodeArr != null) {
                    if (nodeArr[i3] == null) {
                        nodeArr[i3] = new Node();
                    }
                    node2 = node2.children[i3];
                } else {
                    throw new IllegalStateException("invalid dictionary: prefix not unique");
                }
            }
            int i4 = 8 - b2;
            int i5 = (i2 << i4) & 255;
            int i6 = 1 << i4;
            for (int i7 = i5; i7 < i5 + i6; i7++) {
                node2.children[i7] = node;
            }
        }
    }

    private void buildTree() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        int i = 0;
        while (true) {
            byte[] bArr = CODE_LENGTHS;
            if (i >= bArr.length) {
                return;
            }
            addCode(i, CODES[i], bArr[i]);
            i++;
        }
    }

    public static Huffman get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? INSTANCE : (Huffman) invokeV.objValue;
    }

    public byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Node node = this.root;
            int i = 0;
            int i2 = 0;
            for (byte b2 : bArr) {
                i = (i << 8) | (b2 & 255);
                i2 += 8;
                while (i2 >= 8) {
                    node = node.children[(i >>> (i2 - 8)) & 255];
                    if (node.children == null) {
                        byteArrayOutputStream.write(node.symbol);
                        i2 -= node.terminalBits;
                        node = this.root;
                    } else {
                        i2 -= 8;
                    }
                }
            }
            while (i2 > 0) {
                Node node2 = node.children[(i << (8 - i2)) & 255];
                if (node2.children != null || node2.terminalBits > i2) {
                    break;
                }
                byteArrayOutputStream.write(node2.symbol);
                i2 -= node2.terminalBits;
                node = this.root;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public void encode(ByteString byteString, BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteString, bufferedSink) == null) {
            int i = 0;
            long j = 0;
            byte b2 = 0;
            while (i < byteString.size()) {
                int i2 = byteString.getByte(i) & 255;
                int i3 = CODES[i2];
                byte b3 = CODE_LENGTHS[i2];
                j = (j << b3) | i3;
                int i4 = b2 + b3;
                while (i4 >= 8) {
                    i4 = (i4 == 1 ? 1 : 0) - 8;
                    bufferedSink.writeByte((int) (j >> i4));
                }
                i++;
                b2 = i4;
            }
            if (b2 > 0) {
                bufferedSink.writeByte((int) ((255 >>> b2) | (j << (8 - b2))));
            }
        }
    }

    public int encodedLength(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteString)) == null) {
            long j = 0;
            for (int i = 0; i < byteString.size(); i++) {
                j += CODE_LENGTHS[byteString.getByte(i) & 255];
            }
            return (int) ((j + 7) >> 3);
        }
        return invokeL.intValue;
    }

    /* loaded from: classes8.dex */
    public static final class Node {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Node[] children;
        public final int symbol;
        public final int terminalBits;

        public Node() {
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
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBits = 0;
        }

        public Node(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.children = null;
            this.symbol = i;
            int i5 = i2 & 7;
            this.terminalBits = i5 == 0 ? 8 : i5;
        }
    }
}
