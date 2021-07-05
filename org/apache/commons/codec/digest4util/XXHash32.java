package org.apache.commons.codec.digest4util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.zip.Checksum;
/* loaded from: classes10.dex */
public class XXHash32 implements Checksum {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUF_SIZE = 16;
    public static final int PRIME1 = -1640531535;
    public static final int PRIME2 = -2048144777;
    public static final int PRIME3 = -1028477379;
    public static final int PRIME4 = 668265263;
    public static final int PRIME5 = 374761393;
    public static final int ROTATE_BITS = 13;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] buffer;
    public final byte[] oneByte;
    public int pos;
    public final int seed;
    public final int[] state;
    public int totalLen;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XXHash32() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static long fromLittleEndian(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i2, i3)) == null) {
            if (i3 <= 8) {
                long j = 0;
                for (int i4 = 0; i4 < i3; i4++) {
                    j |= (bArr[i2 + i4] & 255) << (i4 * 8);
                }
                return j;
            }
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        return invokeLII.longValue;
    }

    public static int getInt(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) ? (int) (fromLittleEndian(bArr, i2, 4) & 4294967295L) : invokeLI.intValue;
    }

    private void initializeState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            int[] iArr = this.state;
            int i2 = this.seed;
            iArr[0] = i2 + PRIME1 + PRIME2;
            iArr[1] = PRIME2 + i2;
            iArr[2] = i2;
            iArr[3] = i2 - PRIME1;
        }
    }

    private void process(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, bArr, i2) == null) {
            int[] iArr = this.state;
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            int i6 = iArr[3];
            int rotateLeft = Integer.rotateLeft(i3 + (getInt(bArr, i2) * PRIME2), 13) * PRIME1;
            int rotateLeft2 = Integer.rotateLeft(i4 + (getInt(bArr, i2 + 4) * PRIME2), 13) * PRIME1;
            int rotateLeft3 = Integer.rotateLeft(i5 + (getInt(bArr, i2 + 8) * PRIME2), 13) * PRIME1;
            int rotateLeft4 = Integer.rotateLeft(i6 + (getInt(bArr, i2 + 12) * PRIME2), 13) * PRIME1;
            int[] iArr2 = this.state;
            iArr2[0] = rotateLeft;
            iArr2[1] = rotateLeft2;
            iArr2[2] = rotateLeft3;
            iArr2[3] = rotateLeft4;
            this.pos = 0;
        }
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i3 = 0;
            if (this.totalLen > 16) {
                i2 = Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[3], 18);
            } else {
                i2 = this.state[2] + PRIME5;
            }
            int i4 = i2 + this.totalLen;
            int i5 = this.pos - 4;
            while (i3 <= i5) {
                i4 = Integer.rotateLeft(i4 + (getInt(this.buffer, i3) * PRIME3), 17) * PRIME4;
                i3 += 4;
            }
            while (i3 < this.pos) {
                i4 = Integer.rotateLeft(i4 + ((this.buffer[i3] & 255) * PRIME5), 11) * PRIME1;
                i3++;
            }
            int i6 = (i4 ^ (i4 >>> 15)) * PRIME2;
            int i7 = (i6 ^ (i6 >>> 13)) * PRIME3;
            return (i7 ^ (i7 >>> 16)) & 4294967295L;
        }
        return invokeV.longValue;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            initializeState();
            this.totalLen = 0;
            this.pos = 0;
        }
    }

    @Override // java.util.zip.Checksum
    public void update(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) (i2 & 255);
            update(bArr, 0, 1);
        }
    }

    public XXHash32(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oneByte = new byte[1];
        this.state = new int[4];
        this.buffer = new byte[16];
        this.seed = i2;
        initializeState();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) || i3 <= 0) {
            return;
        }
        this.totalLen += i3;
        int i4 = i2 + i3;
        int i5 = this.pos;
        if (i5 + i3 < 16) {
            System.arraycopy(bArr, i2, this.buffer, i5, i3);
            this.pos += i3;
            return;
        }
        if (i5 > 0) {
            int i6 = 16 - i5;
            System.arraycopy(bArr, i2, this.buffer, i5, i6);
            process(this.buffer, 0);
            i2 += i6;
        }
        int i7 = i4 - 16;
        while (i2 <= i7) {
            process(bArr, i2);
            i2 += 16;
        }
        if (i2 < i4) {
            int i8 = i4 - i2;
            this.pos = i8;
            System.arraycopy(bArr, i2, this.buffer, 0, i8);
        }
    }
}
