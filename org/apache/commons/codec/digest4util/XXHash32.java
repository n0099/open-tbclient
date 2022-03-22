package org.apache.commons.codec.digest4util;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.zip.Checksum;
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static long fromLittleEndian(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i, i2)) == null) {
            if (i2 <= 8) {
                long j = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    j |= (bArr[i + i3] & 255) << (i3 * 8);
                }
                return j;
            }
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        return invokeLII.longValue;
    }

    public static int getInt(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) ? (int) (fromLittleEndian(bArr, i, 4) & 4294967295L) : invokeLI.intValue;
    }

    private void initializeState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int[] iArr = this.state;
            int i = this.seed;
            iArr[0] = i + PRIME1 + PRIME2;
            iArr[1] = PRIME2 + i;
            iArr[2] = i;
            iArr[3] = i - PRIME1;
        }
    }

    private void process(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, bArr, i) == null) {
            int[] iArr = this.state;
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            int rotateLeft = Integer.rotateLeft(i2 + (getInt(bArr, i) * PRIME2), 13) * PRIME1;
            int rotateLeft2 = Integer.rotateLeft(i3 + (getInt(bArr, i + 4) * PRIME2), 13) * PRIME1;
            int rotateLeft3 = Integer.rotateLeft(i4 + (getInt(bArr, i + 8) * PRIME2), 13) * PRIME1;
            int rotateLeft4 = Integer.rotateLeft(i5 + (getInt(bArr, i + 12) * PRIME2), 13) * PRIME1;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 0;
            if (this.totalLen > 16) {
                i = Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[3], 18);
            } else {
                i = this.state[2] + PRIME5;
            }
            int i3 = i + this.totalLen;
            int i4 = this.pos - 4;
            while (i2 <= i4) {
                i3 = Integer.rotateLeft(i3 + (getInt(this.buffer, i2) * PRIME3), 17) * PRIME4;
                i2 += 4;
            }
            while (i2 < this.pos) {
                i3 = Integer.rotateLeft(i3 + ((this.buffer[i2] & 255) * PRIME5), 11) * PRIME1;
                i2++;
            }
            int i5 = (i3 ^ (i3 >>> 15)) * PRIME2;
            int i6 = (i5 ^ (i5 >>> 13)) * PRIME3;
            return (i6 ^ (i6 >>> 16)) & 4294967295L;
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
    public void update(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) (i & 255);
            update(bArr, 0, 1);
        }
    }

    public XXHash32(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oneByte = new byte[1];
        this.state = new int[4];
        this.buffer = new byte[16];
        this.seed = i;
        initializeState();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) || i2 <= 0) {
            return;
        }
        this.totalLen += i2;
        int i3 = i + i2;
        int i4 = this.pos;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.buffer, i4, i2);
            this.pos += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.buffer, i4, i5);
            process(this.buffer, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            process(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.pos = i7;
            System.arraycopy(bArr, i, this.buffer, 0, i7);
        }
    }
}
