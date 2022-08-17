package com.facebook.soloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes4.dex */
public final class MinElf {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class ElfError extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElfError(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ISA {
        public static final /* synthetic */ ISA[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ISA AARCH64;
        public static final ISA ARM;
        public static final ISA NOT_SO;
        public static final ISA OTHERS;
        public static final ISA X86;
        public static final ISA X86_64;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(870657066, "Lcom/facebook/soloader/MinElf$ISA;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(870657066, "Lcom/facebook/soloader/MinElf$ISA;");
                    return;
                }
            }
            NOT_SO = new ISA("NOT_SO", 0, "not_so");
            X86 = new ISA("X86", 1, "x86");
            ARM = new ISA("ARM", 2, PassBiometricUtil.CPU_TYPE_ARMEABI_V7A);
            X86_64 = new ISA("X86_64", 3, "x86_64");
            AARCH64 = new ISA("AARCH64", 4, "arm64-v8a");
            ISA isa = new ISA("OTHERS", 5, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
            OTHERS = isa;
            $VALUES = new ISA[]{NOT_SO, X86, ARM, X86_64, AARCH64, isa};
        }

        public ISA(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static ISA valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ISA) Enum.valueOf(ISA.class, str) : (ISA) invokeL.objValue;
        }

        public static ISA[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ISA[]) $VALUES.clone() : (ISA[]) invokeV.objValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    public MinElf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return extract_DT_NEEDED(fileInputStream.getChannel());
            } finally {
                fileInputStream.close();
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j)})) == null) {
            read(fileChannel, byteBuffer, 8, j);
            return byteBuffer.getLong();
        }
        return invokeCommon.longValue;
    }

    public static String getSz(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j)})) != null) {
            return (String) invokeCommon.objValue;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(fileChannel, byteBuffer, j);
            if (u8Var != 0) {
                sb.append((char) u8Var);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    public static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j)})) == null) {
            read(fileChannel, byteBuffer, 2, j);
            return byteBuffer.getShort() & UShort.MAX_VALUE;
        }
        return invokeCommon.intValue;
    }

    public static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j)})) == null) {
            read(fileChannel, byteBuffer, 4, j);
            return byteBuffer.getInt() & 4294967295L;
        }
        return invokeCommon.longValue;
    }

    public static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j)})) == null) {
            read(fileChannel, byteBuffer, 1, j);
            return (short) (byteBuffer.get() & 255);
        }
        return invokeCommon.shortValue;
    }

    public static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{fileChannel, byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j)) != -1) {
                j += read;
            }
            if (byteBuffer.remaining() <= 0) {
                byteBuffer.position(0);
                return;
            }
            throw new ElfError("ELF file truncated");
        }
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        InterceptResult invokeL;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, fileChannel)) != null) {
            return (String[]) invokeL.objValue;
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel, allocate, 0L) == 1179403647) {
            boolean z = getu8(fileChannel, allocate, 4L) == 1;
            if (getu8(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long j11 = z ? getu32(fileChannel, allocate, 28L) : get64(fileChannel, allocate, 32L);
            long j12 = z ? getu16(fileChannel, allocate, 44L) : getu16(fileChannel, allocate, 56L);
            int i = getu16(fileChannel, allocate, z ? 42L : 54L);
            if (j12 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                long j13 = z ? getu32(fileChannel, allocate, 32L) : get64(fileChannel, allocate, 40L);
                if (z) {
                    j10 = getu32(fileChannel, allocate, j13 + 28);
                } else {
                    j10 = getu32(fileChannel, allocate, j13 + 44);
                }
                j12 = j10;
            }
            long j14 = j11;
            long j15 = 0;
            while (true) {
                if (j15 >= j12) {
                    j = 0;
                    break;
                }
                if (z) {
                    j9 = getu32(fileChannel, allocate, j14 + 0);
                } else {
                    j9 = getu32(fileChannel, allocate, j14 + 0);
                }
                if (j9 != 2) {
                    j14 += i;
                    j15++;
                } else if (z) {
                    j = getu32(fileChannel, allocate, j14 + 4);
                } else {
                    j = get64(fileChannel, allocate, j14 + 8);
                }
            }
            long j16 = 0;
            if (j == 0) {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
            long j17 = j;
            long j18 = 0;
            int i2 = 0;
            while (true) {
                boolean z2 = z;
                long j19 = z ? getu32(fileChannel, allocate, j17 + j16) : get64(fileChannel, allocate, j17 + j16);
                if (j19 == 1) {
                    j2 = j;
                    if (i2 == Integer.MAX_VALUE) {
                        throw new ElfError("malformed DT_NEEDED section");
                    }
                    i2++;
                } else {
                    j2 = j;
                    if (j19 == 5) {
                        j18 = z2 ? getu32(fileChannel, allocate, j17 + 4) : get64(fileChannel, allocate, j17 + 8);
                    }
                }
                long j20 = 16;
                j17 += z2 ? 8L : 16L;
                j16 = 0;
                if (j19 != 0) {
                    z = z2;
                    j = j2;
                } else if (j18 == 0) {
                    throw new ElfError("Dynamic section string-table not found");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= j12) {
                            j3 = 0;
                            break;
                        }
                        if (z2) {
                            j4 = getu32(fileChannel, allocate, j11 + j16);
                        } else {
                            j4 = getu32(fileChannel, allocate, j11 + j16);
                        }
                        if (j4 == 1) {
                            if (z2) {
                                j6 = getu32(fileChannel, allocate, j11 + 8);
                            } else {
                                j6 = get64(fileChannel, allocate, j11 + j20);
                            }
                            if (z2) {
                                j5 = j12;
                                j7 = getu32(fileChannel, allocate, j11 + 20);
                            } else {
                                j5 = j12;
                                j7 = get64(fileChannel, allocate, j11 + 40);
                            }
                            if (j6 <= j18 && j18 < j7 + j6) {
                                if (z2) {
                                    j8 = getu32(fileChannel, allocate, j11 + 4);
                                } else {
                                    j8 = get64(fileChannel, allocate, j11 + 8);
                                }
                                j3 = j8 + (j18 - j6);
                            }
                        } else {
                            j5 = j12;
                        }
                        j11 += i;
                        i3++;
                        j12 = j5;
                        j20 = 16;
                        j16 = 0;
                    }
                    long j21 = 0;
                    if (j3 != 0) {
                        String[] strArr = new String[i2];
                        int i4 = 0;
                        while (true) {
                            long j22 = j2 + j21;
                            long j23 = z2 ? getu32(fileChannel, allocate, j22) : get64(fileChannel, allocate, j22);
                            if (j23 == 1) {
                                strArr[i4] = getSz(fileChannel, allocate, (z2 ? getu32(fileChannel, allocate, j2 + 4) : get64(fileChannel, allocate, j2 + 8)) + j3);
                                if (i4 == Integer.MAX_VALUE) {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                                i4++;
                            }
                            j2 += z2 ? 8L : 16L;
                            if (j23 == 0) {
                                if (i4 == i2) {
                                    return strArr;
                                }
                                throw new ElfError("malformed DT_NEEDED section");
                            }
                            j21 = 0;
                        }
                    } else {
                        throw new ElfError("did not find file offset of DT_STRTAB table");
                    }
                }
            }
        } else {
            throw new ElfError("file is not ELF");
        }
    }
}
