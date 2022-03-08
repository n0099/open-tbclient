package com.facebook.soloader;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public MinElf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j2)})) == null) {
            read(fileChannel, byteBuffer, 8, j2);
            return byteBuffer.getLong();
        }
        return invokeCommon.longValue;
    }

    public static String getSz(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j2)})) != null) {
            return (String) invokeCommon.objValue;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short u8Var = getu8(fileChannel, byteBuffer, j2);
            if (u8Var != 0) {
                sb.append((char) u8Var);
                j2 = j3;
            } else {
                return sb.toString();
            }
        }
    }

    public static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j2)})) == null) {
            read(fileChannel, byteBuffer, 2, j2);
            return byteBuffer.getShort() & UShort.MAX_VALUE;
        }
        return invokeCommon.intValue;
    }

    public static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j2)})) == null) {
            read(fileChannel, byteBuffer, 4, j2);
            return byteBuffer.getInt() & 4294967295L;
        }
        return invokeCommon.longValue;
    }

    public static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{fileChannel, byteBuffer, Long.valueOf(j2)})) == null) {
            read(fileChannel, byteBuffer, 1, j2);
            return (short) (byteBuffer.get() & 255);
        }
        return invokeCommon.shortValue;
    }

    public static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i2, long j2) throws IOException {
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{fileChannel, byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j2)) != -1) {
                j2 += read;
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
        long j2;
        long j3;
        int i2;
        long j4;
        boolean z;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, fileChannel)) != null) {
            return (String[]) invokeL.objValue;
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel, allocate, 0L) == 1179403647) {
            boolean z2 = getu8(fileChannel, allocate, 4L) == 1;
            if (getu8(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z2) {
                j2 = getu32(fileChannel, allocate, 28L);
            } else {
                j2 = get64(fileChannel, allocate, 32L);
            }
            if (z2) {
                j3 = getu16(fileChannel, allocate, 44L);
            } else {
                j3 = getu16(fileChannel, allocate, 56L);
            }
            if (z2) {
                i2 = getu16(fileChannel, allocate, 42L);
            } else {
                i2 = getu16(fileChannel, allocate, 54L);
            }
            if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (z2) {
                    j17 = getu32(fileChannel, allocate, 32L);
                } else {
                    j17 = get64(fileChannel, allocate, 40L);
                }
                if (z2) {
                    j18 = getu32(fileChannel, allocate, j17 + 28);
                } else {
                    j18 = getu32(fileChannel, allocate, j17 + 44);
                }
                j3 = j18;
            }
            long j19 = j2;
            long j20 = 0;
            while (true) {
                if (j20 >= j3) {
                    j4 = 0;
                    break;
                }
                if (z2) {
                    j16 = getu32(fileChannel, allocate, j19 + 0);
                } else {
                    j16 = getu32(fileChannel, allocate, j19 + 0);
                }
                if (j16 != 2) {
                    j19 += i2;
                    j20++;
                } else if (z2) {
                    j4 = getu32(fileChannel, allocate, j19 + 4);
                } else {
                    j4 = get64(fileChannel, allocate, j19 + 8);
                }
            }
            long j21 = 0;
            if (j4 == 0) {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
            long j22 = j4;
            long j23 = 0;
            int i3 = 0;
            while (true) {
                if (z2) {
                    z = z2;
                    j5 = getu32(fileChannel, allocate, j22 + j21);
                } else {
                    z = z2;
                    j5 = get64(fileChannel, allocate, j22 + j21);
                }
                if (j5 == 1) {
                    j6 = j4;
                    if (i3 == Integer.MAX_VALUE) {
                        throw new ElfError("malformed DT_NEEDED section");
                    }
                    i3++;
                } else {
                    j6 = j4;
                    if (j5 == 5) {
                        if (z) {
                            j7 = getu32(fileChannel, allocate, j22 + 4);
                        } else {
                            j7 = get64(fileChannel, allocate, j22 + 8);
                        }
                        j23 = j7;
                    }
                }
                long j24 = 16;
                j22 += z ? 8L : 16L;
                j21 = 0;
                if (j5 != 0) {
                    z2 = z;
                    j4 = j6;
                } else if (j23 == 0) {
                    throw new ElfError("Dynamic section string-table not found");
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= j3) {
                            j8 = 0;
                            break;
                        }
                        if (z) {
                            j11 = getu32(fileChannel, allocate, j2 + j21);
                        } else {
                            j11 = getu32(fileChannel, allocate, j2 + j21);
                        }
                        if (j11 == 1) {
                            if (z) {
                                j13 = getu32(fileChannel, allocate, j2 + 8);
                            } else {
                                j13 = get64(fileChannel, allocate, j2 + j24);
                            }
                            if (z) {
                                j12 = j3;
                                j14 = getu32(fileChannel, allocate, j2 + 20);
                            } else {
                                j12 = j3;
                                j14 = get64(fileChannel, allocate, j2 + 40);
                            }
                            if (j13 <= j23 && j23 < j14 + j13) {
                                if (z) {
                                    j15 = getu32(fileChannel, allocate, j2 + 4);
                                } else {
                                    j15 = get64(fileChannel, allocate, j2 + 8);
                                }
                                j8 = j15 + (j23 - j13);
                            }
                        } else {
                            j12 = j3;
                        }
                        j2 += i2;
                        i4++;
                        j3 = j12;
                        j24 = 16;
                        j21 = 0;
                    }
                    long j25 = 0;
                    if (j8 != 0) {
                        String[] strArr = new String[i3];
                        int i5 = 0;
                        while (true) {
                            if (z) {
                                j9 = getu32(fileChannel, allocate, j6 + j25);
                            } else {
                                j9 = get64(fileChannel, allocate, j6 + j25);
                            }
                            if (j9 == 1) {
                                if (z) {
                                    j10 = getu32(fileChannel, allocate, j6 + 4);
                                } else {
                                    j10 = get64(fileChannel, allocate, j6 + 8);
                                }
                                strArr[i5] = getSz(fileChannel, allocate, j10 + j8);
                                if (i5 == Integer.MAX_VALUE) {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                                i5++;
                            }
                            j6 += z ? 8L : 16L;
                            if (j9 == 0) {
                                if (i5 == i3) {
                                    return strArr;
                                }
                                throw new ElfError("malformed DT_NEEDED section");
                            }
                            j25 = 0;
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
