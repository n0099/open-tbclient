package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.UnsupportedEncodingException;
@Deprecated
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static abstract class Coder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int op;
        public byte[] output;

        public Coder() {
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

        public abstract int maxOutputSize(int i2);

        public abstract boolean process(byte[] bArr, int i2, int i3, boolean z);
    }

    /* loaded from: classes2.dex */
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

        public Decoder(int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr};
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
            this.alphabet = (i2 & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ((i2 * 3) / 4) + 10 : invokeI.intValue;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public boolean process(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.state;
                if (i4 == 6) {
                    return false;
                }
                int i5 = i3 + i2;
                int i6 = this.value;
                byte[] bArr2 = this.output;
                int[] iArr = this.alphabet;
                int i7 = i6;
                int i8 = 0;
                int i9 = i4;
                int i10 = i2;
                while (i10 < i5) {
                    if (i9 == 0) {
                        while (true) {
                            int i11 = i10 + 4;
                            if (i11 > i5 || (i7 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
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
                            i13 |= i7 << 6;
                        } else if (i9 == 2) {
                            if (i13 < 0) {
                                if (i13 == -2) {
                                    bArr2[i8] = (byte) (i7 >> 4);
                                    i8++;
                                    i9 = 4;
                                } else if (i13 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            }
                            i13 |= i7 << 6;
                        } else if (i9 != 3) {
                            if (i9 != 4) {
                                if (i9 == 5 && i13 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i13 == -2) {
                                i9++;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i13 >= 0) {
                            int i14 = i13 | (i7 << 6);
                            bArr2[i8 + 2] = (byte) i14;
                            bArr2[i8 + 1] = (byte) (i14 >> 8);
                            bArr2[i8] = (byte) (i14 >> 16);
                            i8 += 3;
                            i7 = i14;
                            i9 = 0;
                        } else if (i13 == -2) {
                            bArr2[i8 + 1] = (byte) (i7 >> 2);
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 += 2;
                            i9 = 5;
                        } else if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                        i9++;
                        i7 = i13;
                    } else {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i9++;
                        i7 = i13;
                    }
                    i10 = i12;
                }
                if (!z) {
                    this.state = i9;
                    this.value = i7;
                    this.op = i8;
                    return true;
                } else if (i9 != 1) {
                    if (i9 == 2) {
                        bArr2[i8] = (byte) (i7 >> 4);
                        i8++;
                    } else if (i9 == 3) {
                        int i15 = i8 + 1;
                        bArr2[i8] = (byte) (i7 >> 10);
                        i8 = i15 + 1;
                        bArr2[i15] = (byte) (i7 >> 2);
                    } else if (i9 == 4) {
                        this.state = 6;
                        return false;
                    }
                    this.state = i9;
                    this.op = i8;
                    return true;
                } else {
                    this.state = 6;
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
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
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        }

        public Encoder(int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr};
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
            this.do_padding = (i2 & 1) == 0;
            this.do_newline = (i2 & 2) == 0;
            this.do_cr = (i2 & 4) != 0;
            this.alphabet = (i2 & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ((i2 * 8) / 5) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.do_cr == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
            r2[r6] = 13;
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
        public boolean process(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            int i4;
            int i5;
            int i6;
            int i7;
            byte b2;
            byte b3;
            byte b4;
            int i8;
            int i9;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i10 = this.count;
            int i11 = i3 + i2;
            int i12 = this.tailLen;
            int i13 = 0;
            if (i12 != 1) {
                if (i12 == 2 && (i9 = i2 + 1) <= i11) {
                    byte[] bArr4 = this.tail;
                    i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i2] & 255);
                    this.tailLen = 0;
                    i4 = i9;
                }
                i4 = i2;
                i5 = -1;
            } else {
                if (i2 + 2 <= i11) {
                    int i14 = i2 + 1;
                    i4 = i14 + 1;
                    i5 = (bArr[i14] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i2] & 255) << 8);
                    this.tailLen = 0;
                }
                i4 = i2;
                i5 = -1;
            }
            if (i5 != -1) {
                bArr3[0] = bArr2[(i5 >> 18) & 63];
                bArr3[1] = bArr2[(i5 >> 12) & 63];
                bArr3[2] = bArr2[(i5 >> 6) & 63];
                bArr3[3] = bArr2[i5 & 63];
                i10--;
                if (i10 == 0) {
                    if (this.do_cr) {
                        i8 = 5;
                        bArr3[4] = 13;
                    } else {
                        i8 = 4;
                    }
                    i6 = i8 + 1;
                    bArr3[i8] = 10;
                    i10 = 19;
                } else {
                    i6 = 4;
                }
            } else {
                i6 = 0;
            }
            while (true) {
                int i15 = i4 + 3;
                if (i15 <= i11) {
                    int i16 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 2] & 255);
                    bArr3[i6] = bArr2[(i16 >> 18) & 63];
                    bArr3[i6 + 1] = bArr2[(i16 >> 12) & 63];
                    bArr3[i6 + 2] = bArr2[(i16 >> 6) & 63];
                    bArr3[i6 + 3] = bArr2[i16 & 63];
                    i6 += 4;
                    i10--;
                    if (i10 == 0) {
                        break;
                    }
                    i4 = i15;
                } else {
                    if (z) {
                        int i17 = this.tailLen;
                        if (i4 - i17 == i11 - 1) {
                            if (i17 > 0) {
                                b4 = this.tail[0];
                                i13 = 1;
                            } else {
                                b4 = bArr[i4];
                            }
                            int i18 = (b4 & 255) << 4;
                            this.tailLen -= i13;
                            int i19 = i6 + 1;
                            bArr3[i6] = bArr2[(i18 >> 6) & 63];
                            i6 = i19 + 1;
                            bArr3[i19] = bArr2[i18 & 63];
                            if (this.do_padding) {
                                int i20 = i6 + 1;
                                bArr3[i6] = 61;
                                i6 = i20 + 1;
                                bArr3[i20] = 61;
                            }
                            if (this.do_newline) {
                                if (this.do_cr) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                        } else if (i4 - i17 == i11 - 2) {
                            if (i17 > 1) {
                                b2 = this.tail[0];
                                i13 = 1;
                            } else {
                                byte b5 = bArr[i4];
                                i4++;
                                b2 = b5;
                            }
                            int i21 = (b2 & 255) << 10;
                            if (this.tailLen > 0) {
                                b3 = this.tail[i13];
                                i13++;
                            } else {
                                b3 = bArr[i4];
                            }
                            int i22 = i21 | ((b3 & 255) << 2);
                            this.tailLen -= i13;
                            int i23 = i6 + 1;
                            bArr3[i6] = bArr2[(i22 >> 12) & 63];
                            int i24 = i23 + 1;
                            bArr3[i23] = bArr2[(i22 >> 6) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[i22 & 63];
                            if (this.do_padding) {
                                bArr3[i25] = 61;
                                i25++;
                            }
                            if (this.do_newline) {
                                if (this.do_cr) {
                                    bArr3[i25] = 13;
                                    i25++;
                                }
                                bArr3[i25] = 10;
                                i25++;
                            }
                            i6 = i25;
                        } else if (this.do_newline && i6 > 0 && i10 != 19) {
                            if (this.do_cr) {
                                bArr3[i6] = 13;
                                i6++;
                            }
                            i7 = i6 + 1;
                            bArr3[i6] = 10;
                            i6 = i7;
                        }
                    } else if (i4 == i11 - 1) {
                        byte[] bArr5 = this.tail;
                        int i26 = this.tailLen;
                        this.tailLen = i26 + 1;
                        bArr5[i26] = bArr[i4];
                    } else if (i4 == i11 - 2) {
                        byte[] bArr6 = this.tail;
                        int i27 = this.tailLen;
                        int i28 = i27 + 1;
                        this.tailLen = i28;
                        bArr6[i27] = bArr[i4];
                        this.tailLen = i28 + 1;
                        bArr6[i28] = bArr[i4 + 1];
                    }
                    this.op = i6;
                    this.count = i10;
                    return true;
                }
            }
        }
    }

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

    public Base64() {
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

    public static byte[] decode(String str, int i2) throws IllegalArgumentException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) ? decode(str.getBytes(), i2) : (byte[]) invokeLI.objValue;
    }

    public static byte[] encode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, bArr, i2)) == null) ? encode(bArr, 0, bArr.length, i2) : (byte[]) invokeLI.objValue;
    }

    public static String encodeToString(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i2)) == null) {
            try {
                return new String(encode(bArr, i2), "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i2) throws IllegalArgumentException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) ? decode(bArr, 0, bArr.length, i2) : (byte[]) invokeLI.objValue;
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2, i3, i4)) == null) {
            Encoder encoder = new Encoder(i4, null);
            int i5 = (i3 / 3) * 4;
            if (encoder.do_padding) {
                if (i3 % 3 > 0) {
                    i5 += 4;
                }
            } else {
                int i6 = i3 % 3;
                if (i6 == 1) {
                    i5 += 2;
                } else if (i6 == 2) {
                    i5 += 3;
                }
            }
            if (encoder.do_newline && i3 > 0) {
                i5 += (((i3 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
            }
            encoder.output = new byte[i5];
            encoder.process(bArr, i2, i3, true);
            return encoder.output;
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IllegalArgumentException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3, i4)) == null) {
            Decoder decoder = new Decoder(i4, new byte[(i3 * 3) / 4]);
            if (decoder.process(bArr, i2, i3, true)) {
                int i5 = decoder.op;
                byte[] bArr2 = decoder.output;
                if (i5 == bArr2.length) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i5];
                System.arraycopy(bArr2, 0, bArr3, 0, i5);
                return bArr3;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static String encodeToString(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i2, i3, i4)) == null) {
            try {
                return new String(encode(bArr, i2, i3, i4), "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLIII.objValue;
    }
}
