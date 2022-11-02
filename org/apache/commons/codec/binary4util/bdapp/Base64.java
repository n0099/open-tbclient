package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary4util.BaseNCodec;
@SuppressLint({"BDThrowableCheck"})
@Deprecated
/* loaded from: classes8.dex */
public class Base64 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1749647544, "Lorg/apache/commons/codec/binary4util/bdapp/Base64;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1749647544, "Lorg/apache/commons/codec/binary4util/bdapp/Base64;");
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class Coder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        public Coder() {
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
    }

    /* loaded from: classes8.dex */
    public static class Decoder extends Coder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] DECODE;
        public static final int[] DECODE_WEBSAFE;
        public static final int EQUALS = -2;
        public static final int SKIP = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] alphabet;
        public int state;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1414295496, "Lorg/apache/commons/codec/binary4util/bdapp/Base64$Decoder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1414295496, "Lorg/apache/commons/codec/binary4util/bdapp/Base64$Decoder;");
                    return;
                }
            }
            DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public Decoder(int i, byte[] bArr) {
            int[] iArr;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bArr};
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
            if ((i & 8) == 0) {
                iArr = DECODE;
            } else {
                iArr = DECODE_WEBSAFE;
            }
            this.alphabet = iArr;
            this.state = 0;
            this.value = 0;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return ((i * 3) / 4) + 10;
            }
            return invokeI.intValue;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int i3 = this.state;
                if (i3 == 6) {
                    return false;
                }
                int i4 = i2 + i;
                int i5 = this.value;
                byte[] bArr2 = this.output;
                int[] iArr = this.alphabet;
                int i6 = i5;
                int i7 = 0;
                int i8 = i3;
                int i9 = i;
                while (i9 < i4) {
                    if (i8 == 0) {
                        while (true) {
                            int i10 = i9 + 4;
                            if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                                break;
                            }
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i10;
                        }
                        if (i9 >= i4) {
                            break;
                        }
                    }
                    int i11 = i9 + 1;
                    int i12 = iArr[bArr[i9] & 255];
                    if (i8 != 0) {
                        if (i8 != 1) {
                            if (i8 != 2) {
                                if (i8 != 3) {
                                    if (i8 != 4) {
                                        if (i8 == 5 && i12 != -1) {
                                            this.state = 6;
                                            return false;
                                        }
                                    } else if (i12 == -2) {
                                        i8++;
                                    } else if (i12 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                } else if (i12 >= 0) {
                                    int i13 = i12 | (i6 << 6);
                                    bArr2[i7 + 2] = (byte) i13;
                                    bArr2[i7 + 1] = (byte) (i13 >> 8);
                                    bArr2[i7] = (byte) (i13 >> 16);
                                    i7 += 3;
                                    i6 = i13;
                                    i8 = 0;
                                } else if (i12 == -2) {
                                    bArr2[i7 + 1] = (byte) (i6 >> 2);
                                    bArr2[i7] = (byte) (i6 >> 10);
                                    i7 += 2;
                                    i8 = 5;
                                } else if (i12 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else {
                                if (i12 < 0) {
                                    if (i12 == -2) {
                                        bArr2[i7] = (byte) (i6 >> 4);
                                        i7++;
                                        i8 = 4;
                                    } else if (i12 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                }
                                i12 |= i6 << 6;
                            }
                        } else {
                            if (i12 < 0) {
                                if (i12 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            }
                            i12 |= i6 << 6;
                        }
                        i8++;
                        i6 = i12;
                    } else {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i8++;
                        i6 = i12;
                    }
                    i9 = i11;
                }
                if (!z) {
                    this.state = i8;
                    this.value = i6;
                    this.op = i7;
                    return true;
                } else if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                this.state = 6;
                                return false;
                            }
                        } else {
                            int i14 = i7 + 1;
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 = i14 + 1;
                            bArr2[i14] = (byte) (i6 >> 2);
                        }
                    } else {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                    }
                    this.state = i8;
                    this.op = i7;
                    return true;
                } else {
                    this.state = 6;
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class Encoder extends Coder {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic = null;
        public static final byte[] ENCODE;
        public static final byte[] ENCODE_WEBSAFE;
        public static final int LINE_GROUPS = 19;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] alphabet;
        public int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        public final byte[] tail;
        public int tailLen;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273886624, "Lorg/apache/commons/codec/binary4util/bdapp/Base64$Encoder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-273886624, "Lorg/apache/commons/codec/binary4util/bdapp/Base64$Encoder;");
                    return;
                }
            }
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public Encoder(int i, byte[] bArr) {
            boolean z;
            boolean z2;
            byte[] bArr2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.output = bArr;
            if ((i & 1) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.do_padding = z;
            if ((i & 2) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.do_newline = z2;
            this.do_cr = (i & 4) != 0;
            if ((i & 8) == 0) {
                bArr2 = ENCODE;
            } else {
                bArr2 = ENCODE_WEBSAFE;
            }
            this.alphabet = bArr2;
            this.tail = new byte[2];
            this.tailLen = 0;
            if (this.do_newline) {
                i2 = 19;
            } else {
                i2 = -1;
            }
            this.count = i2;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return ((i * 8) / 5) + 10;
            }
            return invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.do_cr == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
            r2[r6] = com.bumptech.glide.disklrucache.StrictLineReader.CR;
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e1, code lost:
            r2[r6] = 10;
            r6 = r6 + 1;
            r11 = r10;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e1 -> B:24:0x008e). Please submit an issue!!! */
        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        @SuppressLint({"Assert"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            int i3;
            int i4;
            int i5;
            int i6;
            byte b;
            byte b2;
            byte b3;
            int i7;
            int i8;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                byte[] bArr2 = this.alphabet;
                byte[] bArr3 = this.output;
                int i9 = this.count;
                int i10 = i2 + i;
                int i11 = this.tailLen;
                int i12 = 0;
                if (i11 != 1) {
                    if (i11 == 2 && (i8 = i + 1) <= i10) {
                        byte[] bArr4 = this.tail;
                        i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                        this.tailLen = 0;
                        i3 = i8;
                    }
                    i3 = i;
                    i4 = -1;
                } else {
                    if (i + 2 <= i10) {
                        int i13 = i + 1;
                        i3 = i13 + 1;
                        i4 = (bArr[i13] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                        this.tailLen = 0;
                    }
                    i3 = i;
                    i4 = -1;
                }
                if (i4 != -1) {
                    bArr3[0] = bArr2[(i4 >> 18) & 63];
                    bArr3[1] = bArr2[(i4 >> 12) & 63];
                    bArr3[2] = bArr2[(i4 >> 6) & 63];
                    bArr3[3] = bArr2[i4 & 63];
                    i9--;
                    if (i9 == 0) {
                        if (this.do_cr) {
                            i7 = 5;
                            bArr3[4] = StrictLineReader.CR;
                        } else {
                            i7 = 4;
                        }
                        i5 = i7 + 1;
                        bArr3[i7] = 10;
                        i9 = 19;
                    } else {
                        i5 = 4;
                    }
                } else {
                    i5 = 0;
                }
                while (true) {
                    int i14 = i3 + 3;
                    if (i14 <= i10) {
                        int i15 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
                        bArr3[i5] = bArr2[(i15 >> 18) & 63];
                        bArr3[i5 + 1] = bArr2[(i15 >> 12) & 63];
                        bArr3[i5 + 2] = bArr2[(i15 >> 6) & 63];
                        bArr3[i5 + 3] = bArr2[i15 & 63];
                        i5 += 4;
                        i9--;
                        if (i9 == 0) {
                            break;
                        }
                        i3 = i14;
                    } else {
                        if (z) {
                            int i16 = this.tailLen;
                            if (i3 - i16 == i10 - 1) {
                                if (i16 > 0) {
                                    b3 = this.tail[0];
                                    i12 = 1;
                                } else {
                                    b3 = bArr[i3];
                                }
                                int i17 = (b3 & 255) << 4;
                                this.tailLen -= i12;
                                int i18 = i5 + 1;
                                bArr3[i5] = bArr2[(i17 >> 6) & 63];
                                i5 = i18 + 1;
                                bArr3[i18] = bArr2[i17 & 63];
                                if (this.do_padding) {
                                    int i19 = i5 + 1;
                                    bArr3[i5] = BaseNCodec.PAD_DEFAULT;
                                    i5 = i19 + 1;
                                    bArr3[i19] = BaseNCodec.PAD_DEFAULT;
                                }
                                if (this.do_newline) {
                                    if (this.do_cr) {
                                        bArr3[i5] = StrictLineReader.CR;
                                        i5++;
                                    }
                                    i6 = i5 + 1;
                                    bArr3[i5] = 10;
                                    i5 = i6;
                                }
                            } else if (i3 - i16 == i10 - 2) {
                                if (i16 > 1) {
                                    b = this.tail[0];
                                    i12 = 1;
                                } else {
                                    byte b4 = bArr[i3];
                                    i3++;
                                    b = b4;
                                }
                                int i20 = (b & 255) << 10;
                                if (this.tailLen > 0) {
                                    b2 = this.tail[i12];
                                    i12++;
                                } else {
                                    b2 = bArr[i3];
                                }
                                int i21 = i20 | ((b2 & 255) << 2);
                                this.tailLen -= i12;
                                int i22 = i5 + 1;
                                bArr3[i5] = bArr2[(i21 >> 12) & 63];
                                int i23 = i22 + 1;
                                bArr3[i22] = bArr2[(i21 >> 6) & 63];
                                int i24 = i23 + 1;
                                bArr3[i23] = bArr2[i21 & 63];
                                if (this.do_padding) {
                                    bArr3[i24] = BaseNCodec.PAD_DEFAULT;
                                    i24++;
                                }
                                if (this.do_newline) {
                                    if (this.do_cr) {
                                        bArr3[i24] = StrictLineReader.CR;
                                        i24++;
                                    }
                                    bArr3[i24] = 10;
                                    i24++;
                                }
                                i5 = i24;
                            } else if (this.do_newline && i5 > 0 && i9 != 19) {
                                if (this.do_cr) {
                                    bArr3[i5] = StrictLineReader.CR;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                        } else if (i3 == i10 - 1) {
                            byte[] bArr5 = this.tail;
                            int i25 = this.tailLen;
                            this.tailLen = i25 + 1;
                            bArr5[i25] = bArr[i3];
                        } else if (i3 == i10 - 2) {
                            byte[] bArr6 = this.tail;
                            int i26 = this.tailLen;
                            int i27 = i26 + 1;
                            this.tailLen = i27;
                            bArr6[i26] = bArr[i3];
                            this.tailLen = i27 + 1;
                            bArr6[i27] = bArr[i3 + 1];
                        }
                        this.op = i5;
                        this.count = i9;
                        return true;
                    }
                }
            } else {
                return invokeCommon.booleanValue;
            }
        }
    }

    public Base64() {
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

    public static byte[] decode(String str, int i) throws IllegalArgumentException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            return decode(str.getBytes(), i);
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] encode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) {
            return encode(bArr, 0, bArr.length, i);
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String encodeToString(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i)) == null) {
            try {
                return new String(encode(bArr, i), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i) throws IllegalArgumentException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) {
            return decode(bArr, 0, bArr.length, i);
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) throws IllegalArgumentException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2, i3)) == null) {
            Decoder decoder = new Decoder(i3, new byte[(i2 * 3) / 4]);
            if (decoder.process(bArr, i, i2, true)) {
                int i4 = decoder.op;
                byte[] bArr2 = decoder.output;
                if (i4 == bArr2.length) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i4];
                System.arraycopy(bArr2, 0, bArr3, 0, i4);
                return bArr3;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        return (byte[]) invokeLIII.objValue;
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i, i2, i3)) == null) {
            Encoder encoder = new Encoder(i3, null);
            int i4 = (i2 / 3) * 4;
            int i5 = 2;
            if (encoder.do_padding) {
                if (i2 % 3 > 0) {
                    i4 += 4;
                }
            } else {
                int i6 = i2 % 3;
                if (i6 != 1) {
                    if (i6 == 2) {
                        i4 += 3;
                    }
                } else {
                    i4 += 2;
                }
            }
            if (encoder.do_newline && i2 > 0) {
                int i7 = ((i2 - 1) / 57) + 1;
                if (!encoder.do_cr) {
                    i5 = 1;
                }
                i4 += i7 * i5;
            }
            encoder.output = new byte[i4];
            encoder.process(bArr, i, i2, true);
            return encoder.output;
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i, i2, i3)) == null) {
            try {
                return new String(encode(bArr, i, i2, i3), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLIII.objValue;
    }
}
