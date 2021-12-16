package com.google.common.hash;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class HashCode {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] hexDigits;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class BytesHashCode extends HashCode implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] bytes;

        public BytesHashCode(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(bArr);
            this.bytes = bArr;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (byte[]) this.bytes.clone() : (byte[]) invokeV.objValue;
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                n.y(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
                byte[] bArr = this.bytes;
                return ((bArr[3] & 255) << 24) | ((bArr[1] & 255) << 8) | (bArr[0] & 255) | ((bArr[2] & 255) << 16);
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                n.y(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
                return padToLong();
            }
            return invokeV.longValue;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bytes.length * 8 : invokeV.intValue;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode hashCode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, hashCode)) != null) {
                return invokeL.booleanValue;
            }
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            int i2 = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i2 >= bArr.length) {
                    return z;
                }
                z &= bArr[i2] == hashCode.getBytesInternal()[i2];
                i2++;
            }
        }

        @Override // com.google.common.hash.HashCode
        public byte[] getBytesInternal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.bytes : (byte[]) invokeV.objValue;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                long j2 = this.bytes[0] & 255;
                for (int i2 = 1; i2 < Math.min(this.bytes.length, 8); i2++) {
                    j2 |= (this.bytes[i2] & 255) << (i2 * 8);
                }
                return j2;
            }
            return invokeV.longValue;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i2, i3) == null) {
                System.arraycopy(this.bytes, 0, bArr, i2, i3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class IntHashCode extends HashCode implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final int hash;

        public IntHashCode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hash = i2;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.hash;
                return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.hash : invokeV.intValue;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
            }
            return invokeV.longValue;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode hashCode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hashCode)) == null) ? this.hash == hashCode.asInt() : invokeL.booleanValue;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? UnsignedInts.f(this.hash) : invokeV.longValue;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr[i2 + i4] = (byte) (this.hash >> (i4 * 8));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class LongHashCode extends HashCode implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final long hash;

        public LongHashCode(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hash = j2;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.hash;
                return new byte[]{(byte) j2, (byte) (j2 >> 8), (byte) (j2 >> 16), (byte) (j2 >> 24), (byte) (j2 >> 32), (byte) (j2 >> 40), (byte) (j2 >> 48), (byte) (j2 >> 56)};
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.hash : invokeV.intValue;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hash : invokeV.longValue;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 64;
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode hashCode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hashCode)) == null) ? this.hash == hashCode.asLong() : invokeL.booleanValue;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hash : invokeV.longValue;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr[i2 + i4] = (byte) (this.hash >> (i4 * 8));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1734903559, "Lcom/google/common/hash/HashCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1734903559, "Lcom/google/common/hash/HashCode;");
                return;
            }
        }
        hexDigits = "0123456789abcdef".toCharArray();
    }

    public HashCode() {
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

    public static int decode(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                if (c2 < 'a' || c2 > 'f') {
                    throw new IllegalArgumentException("Illegal hexadecimal character: " + c2);
                }
                return (c2 - 'a') + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public static HashCode fromBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            n.e(bArr.length >= 1, "A HashCode must contain at least 1 byte.");
            return fromBytesNoCopy((byte[]) bArr.clone());
        }
        return (HashCode) invokeL.objValue;
    }

    public static HashCode fromBytesNoCopy(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? new BytesHashCode(bArr) : (HashCode) invokeL.objValue;
    }

    public static HashCode fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? new IntHashCode(i2) : (HashCode) invokeI.objValue;
    }

    public static HashCode fromLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j2)) == null) ? new LongHashCode(j2) : (HashCode) invokeJ.objValue;
    }

    public static HashCode fromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            n.k(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
            n.k(str.length() % 2 == 0, "input string (%s) must have an even number of characters", str);
            byte[] bArr = new byte[str.length() / 2];
            for (int i2 = 0; i2 < str.length(); i2 += 2) {
                bArr[i2 / 2] = (byte) ((decode(str.charAt(i2)) << 4) + decode(str.charAt(i2 + 1)));
            }
            return fromBytesNoCopy(bArr);
        }
        return (HashCode) invokeL.objValue;
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof HashCode) {
                HashCode hashCode = (HashCode) obj;
                return bits() == hashCode.bits() && equalsSameBits(hashCode);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract boolean equalsSameBits(HashCode hashCode);

    public byte[] getBytesInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? asBytes() : (byte[]) invokeV.objValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (bits() >= 32) {
                return asInt();
            }
            byte[] bytesInternal = getBytesInternal();
            int i2 = bytesInternal[0] & 255;
            for (int i3 = 1; i3 < bytesInternal.length; i3++) {
                i2 |= (bytesInternal[i3] & 255) << (i3 * 8);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public abstract long padToLong();

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            byte[] bytesInternal = getBytesInternal();
            StringBuilder sb = new StringBuilder(bytesInternal.length * 2);
            for (byte b2 : bytesInternal) {
                sb.append(hexDigits[(b2 >> 4) & 15]);
                sb.append(hexDigits[b2 & 15]);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int writeBytesTo(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, bArr, i2, i3)) == null) {
            int i4 = Ints.i(i3, bits() / 8);
            n.v(i2, i2 + i4, bArr.length);
            writeBytesToImpl(bArr, i2, i4);
            return i4;
        }
        return invokeLII.intValue;
    }

    public abstract void writeBytesToImpl(byte[] bArr, int i2, int i3);
}
