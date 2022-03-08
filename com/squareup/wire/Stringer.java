package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public final class Stringer {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset UTF_8;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class Decoder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] DECODE;
        public static final int EQUALS = -2;
        public static final int SKIP = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int op;
        public final byte[] output;
        public int state;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-280013328, "Lcom/squareup/wire/Stringer$Decoder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-280013328, "Lcom/squareup/wire/Stringer$Decoder;");
                    return;
                }
            }
            DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public Decoder(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.output = bArr;
            this.state = 0;
            this.value = 0;
        }

        public boolean process(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.state;
                if (i4 == 6) {
                    return false;
                }
                int i5 = i3 + i2;
                int i6 = this.value;
                byte[] bArr2 = this.output;
                int[] iArr = DECODE;
                int i7 = i6;
                int i8 = 0;
                int i9 = i4;
                int i10 = i2;
                while (i10 < i5) {
                    if (i9 == 0) {
                        while (true) {
                            int i11 = i10 + 4;
                            if (i11 > i5 || (i7 = iArr[bArr[i10 + 3] & 255] | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 2] & 255] << 6)) < 0) {
                                break;
                            }
                            bArr2[i8 + 2] = (byte) i7;
                            bArr2[i8 + 1] = (byte) (i7 >> 8);
                            bArr2[i8] = (byte) (i7 >> 16);
                            i8 += 3;
                            i10 = i11;
                        }
                        if (i10 >= i5) {
                            break;
                        }
                    }
                    int i12 = i10 + 1;
                    int i13 = iArr[bArr[i10] & 255];
                    if (i9 != 0) {
                        if (i9 == 1) {
                            if (i13 < 0) {
                                if (i13 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            }
                            i7 = (i7 << 6) | i13;
                            i9++;
                        } else if (i9 != 2) {
                            if (i9 != 3) {
                                if (i9 == 4) {
                                    if (i13 != -2) {
                                        if (i13 != -1) {
                                            this.state = 6;
                                            return false;
                                        }
                                    }
                                    i9++;
                                } else if (i9 != 5) {
                                    throw new AssertionError("state = " + i9);
                                } else if (i13 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i13 >= 0) {
                                i7 = (i7 << 6) | i13;
                                bArr2[i8 + 2] = (byte) i7;
                                bArr2[i8 + 1] = (byte) (i7 >> 8);
                                bArr2[i8] = (byte) (i7 >> 16);
                                i8 += 3;
                                i10 = i12;
                                i9 = 0;
                            } else if (i13 == -2) {
                                bArr2[i8 + 1] = (byte) (i7 >> 2);
                                bArr2[i8] = (byte) (i7 >> 10);
                                i8 += 2;
                                i10 = i12;
                                i9 = 5;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i13 >= 0) {
                            i7 = (i7 << 6) | i13;
                            i9++;
                        } else if (i13 == -2) {
                            bArr2[i8] = (byte) (i7 >> 4);
                            i8++;
                            i10 = i12;
                            i9 = 4;
                        } else if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        i9++;
                        i7 = i13;
                    } else if (i13 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i10 = i12;
                }
                if (!z) {
                    this.state = i9;
                    this.value = i7;
                    this.op = i8;
                    return true;
                }
                if (i9 != 0) {
                    if (i9 == 1) {
                        this.state = 6;
                        return false;
                    } else if (i9 == 2) {
                        bArr2[i8] = (byte) (i7 >> 4);
                        i8++;
                    } else if (i9 == 3) {
                        int i14 = i8 + 1;
                        bArr2[i8] = (byte) (i7 >> 10);
                        i8 = i14 + 1;
                        bArr2[i14] = (byte) (i7 >> 2);
                    } else if (i9 == 4) {
                        this.state = 6;
                        return false;
                    } else if (i9 != 5) {
                        throw new AssertionError("state = " + i9);
                    }
                }
                this.state = i9;
                this.op = i8;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class Encoder {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] ENCODE;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] output;
        public final byte[] tail;
        public int tailLen;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(860395544, "Lcom/squareup/wire/Stringer$Encoder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(860395544, "Lcom/squareup/wire/Stringer$Encoder;");
                    return;
                }
            }
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
        }

        public Encoder(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.output = bArr;
            this.tail = new byte[2];
            this.tailLen = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x013f A[LOOP:0: B:21:0x008c->B:47:0x013f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0090 A[EDGE_INSN: B:51:0x0090->B:23:0x0090 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void process(byte[] bArr, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            int i7;
            byte b2;
            byte b3;
            byte b4;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) != null) {
                return;
            }
            byte[] bArr2 = ENCODE;
            byte[] bArr3 = this.output;
            int i8 = i3 + i2;
            int i9 = this.tailLen;
            int i10 = 0;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        throw new AssertionError("tailLen = " + this.tailLen);
                    }
                    i4 = i2 + 1;
                    if (i4 <= i8) {
                        byte[] bArr4 = this.tail;
                        i5 = (bArr[i2] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16);
                        this.tailLen = 0;
                    }
                } else if (i2 + 2 <= i8) {
                    int i11 = i2 + 1;
                    i4 = i11 + 1;
                    i5 = ((bArr[i2] & 255) << 8) | ((this.tail[0] & 255) << 16) | (bArr[i11] & 255);
                    this.tailLen = 0;
                }
                if (i5 == -1) {
                    bArr3[0] = bArr2[(i5 >> 18) & 63];
                    bArr3[1] = bArr2[(i5 >> 12) & 63];
                    bArr3[2] = bArr2[(i5 >> 6) & 63];
                    bArr3[3] = bArr2[i5 & 63];
                    i6 = 4;
                } else {
                    i6 = 0;
                }
                while (true) {
                    i7 = i4 + 3;
                    if (i7 <= i8) {
                        break;
                    }
                    int i12 = (bArr[i4 + 2] & 255) | ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
                    bArr3[i6] = bArr2[(i12 >> 18) & 63];
                    bArr3[i6 + 1] = bArr2[(i12 >> 12) & 63];
                    bArr3[i6 + 2] = bArr2[(i12 >> 6) & 63];
                    bArr3[i6 + 3] = bArr2[i12 & 63];
                    i6 += 4;
                    i4 = i7;
                }
                if (z) {
                    if (i4 == i8 - 1) {
                        byte[] bArr5 = this.tail;
                        int i13 = this.tailLen;
                        this.tailLen = i13 + 1;
                        bArr5[i13] = bArr[i4];
                        return;
                    } else if (i4 == i8 - 2) {
                        byte[] bArr6 = this.tail;
                        int i14 = this.tailLen;
                        int i15 = i14 + 1;
                        this.tailLen = i15;
                        bArr6[i14] = bArr[i4];
                        this.tailLen = i15 + 1;
                        bArr6[i15] = bArr[i4 + 1];
                        return;
                    } else {
                        return;
                    }
                }
                int i16 = this.tailLen;
                if (i4 - i16 == i8 - 1) {
                    if (i16 > 0) {
                        b4 = this.tail[0];
                        i10 = 1;
                    } else {
                        b4 = bArr[i4];
                    }
                    int i17 = (b4 & 255) << 4;
                    this.tailLen -= i10;
                    int i18 = i6 + 1;
                    bArr3[i6] = bArr2[(i17 >> 6) & 63];
                    int i19 = i18 + 1;
                    bArr3[i18] = bArr2[i17 & 63];
                    bArr3[i19] = 61;
                    bArr3[i19 + 1] = 61;
                    return;
                } else if (i4 - i16 == i8 - 2) {
                    if (i16 > 1) {
                        b2 = this.tail[0];
                        i10 = 1;
                    } else {
                        byte b5 = bArr[i4];
                        i4++;
                        b2 = b5;
                    }
                    int i20 = (b2 & 255) << 10;
                    if (this.tailLen > 0) {
                        b3 = this.tail[i10];
                        i10++;
                    } else {
                        b3 = bArr[i4];
                    }
                    int i21 = ((b3 & 255) << 2) | i20;
                    this.tailLen -= i10;
                    int i22 = i6 + 1;
                    bArr3[i6] = bArr2[(i21 >> 12) & 63];
                    int i23 = i22 + 1;
                    bArr3[i22] = bArr2[(i21 >> 6) & 63];
                    bArr3[i23] = bArr2[i21 & 63];
                    bArr3[i23 + 1] = 61;
                    return;
                } else {
                    return;
                }
            }
            i4 = i2;
            i5 = -1;
            if (i5 == -1) {
            }
            while (true) {
                i7 = i4 + 3;
                if (i7 <= i8) {
                }
                int i122 = (bArr[i4 + 2] & 255) | ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
                bArr3[i6] = bArr2[(i122 >> 18) & 63];
                bArr3[i6 + 1] = bArr2[(i122 >> 12) & 63];
                bArr3[i6 + 2] = bArr2[(i122 >> 6) & 63];
                bArr3[i6 + 3] = bArr2[i122 & 63];
                i6 += 4;
                i4 = i7;
            }
            if (z) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1325236624, "Lcom/squareup/wire/Stringer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1325236624, "Lcom/squareup/wire/Stringer;");
                return;
            }
        }
        UTF_8 = Charset.forName("UTF-8");
    }

    public Stringer() {
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

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            byte[] bytes = str.getBytes(UTF_8);
            Decoder decoder = new Decoder(new byte[(bytes.length * 3) / 4]);
            if (decoder.process(bytes, 0, bytes.length, true)) {
                if (decoder.op == decoder.output.length) {
                    return decoder.output;
                }
                byte[] bArr = new byte[decoder.op];
                System.arraycopy(decoder.output, 0, bArr, 0, decoder.op);
                return bArr;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            int length = (bArr.length / 3) * 4;
            if (bArr.length % 3 > 0) {
                length += 4;
            }
            Encoder encoder = new Encoder(new byte[length]);
            encoder.process(bArr, 0, bArr.length, true);
            return new String(encoder.output, UTF_8);
        }
        return (String) invokeL.objValue;
    }
}
