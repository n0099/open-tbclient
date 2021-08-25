package com.ta.utdid2.a.a;

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
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f75854a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f75855a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f4a;

        public a() {
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
    }

    /* renamed from: com.ta.utdid2.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2079b extends a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f75856a;

        /* renamed from: b  reason: collision with root package name */
        public static final int[] f75857b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f75858c;
        public int state;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2128370772, "Lcom/ta/utdid2/a/a/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2128370772, "Lcom/ta/utdid2/a/a/b$b;");
                    return;
                }
            }
            f75856a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            f75857b = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public C2079b(int i2, byte[] bArr) {
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
            ((a) this).f4a = bArr;
            this.f75858c = (i2 & 8) == 0 ? f75856a : f75857b;
            this.state = 0;
            this.value = 0;
        }

        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.state;
                if (i4 == 6) {
                    return false;
                }
                int i5 = i3 + i2;
                int i6 = this.value;
                byte[] bArr2 = ((a) this).f4a;
                int[] iArr = this.f75858c;
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
                    ((a) this).f75855a = i8;
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
                    ((a) this).f75855a = i8;
                    return true;
                } else {
                    this.state = 6;
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ boolean f75859a;

        /* renamed from: b  reason: collision with root package name */
        public static final byte[] f75860b;

        /* renamed from: c  reason: collision with root package name */
        public static final byte[] f75861c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with other field name */
        public int f5b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f6b;

        /* renamed from: c  reason: collision with other field name */
        public final boolean f7c;
        public int count;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f75862d;

        /* renamed from: d  reason: collision with other field name */
        public final byte[] f8d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f75863e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2128370741, "Lcom/ta/utdid2/a/a/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2128370741, "Lcom/ta/utdid2/a/a/b$c;");
                    return;
                }
            }
            f75859a = !b.class.desiredAssertionStatus();
            f75860b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            f75861c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        }

        public c(int i2, byte[] bArr) {
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
            ((a) this).f4a = bArr;
            this.f6b = (i2 & 1) == 0;
            this.f7c = (i2 & 2) == 0;
            this.f75862d = (i2 & 4) != 0;
            this.f75863e = (i2 & 8) == 0 ? f75860b : f75861c;
            this.f8d = new byte[2];
            this.f5b = 0;
            this.count = this.f7c ? 19 : -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.f75862d == false) goto L28;
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            int i4;
            int i5;
            int i6;
            int i7;
            byte b2;
            int i8;
            byte b3;
            byte b4;
            int i9;
            int i10;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.f75863e;
            byte[] bArr3 = ((a) this).f4a;
            int i11 = this.count;
            int i12 = i3 + i2;
            int i13 = this.f5b;
            int i14 = 0;
            if (i13 != 1) {
                if (i13 == 2 && (i10 = i2 + 1) <= i12) {
                    byte[] bArr4 = this.f8d;
                    i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i2] & 255);
                    this.f5b = 0;
                    i4 = i10;
                }
                i4 = i2;
                i5 = -1;
            } else {
                if (i2 + 2 <= i12) {
                    int i15 = i2 + 1;
                    i4 = i15 + 1;
                    i5 = (bArr[i15] & 255) | ((this.f8d[0] & 255) << 16) | ((bArr[i2] & 255) << 8);
                    this.f5b = 0;
                }
                i4 = i2;
                i5 = -1;
            }
            if (i5 != -1) {
                bArr3[0] = bArr2[(i5 >> 18) & 63];
                bArr3[1] = bArr2[(i5 >> 12) & 63];
                bArr3[2] = bArr2[(i5 >> 6) & 63];
                bArr3[3] = bArr2[i5 & 63];
                i11--;
                if (i11 == 0) {
                    if (this.f75862d) {
                        i9 = 5;
                        bArr3[4] = 13;
                    } else {
                        i9 = 4;
                    }
                    i6 = i9 + 1;
                    bArr3[i9] = 10;
                    i11 = 19;
                } else {
                    i6 = 4;
                }
            } else {
                i6 = 0;
            }
            while (true) {
                int i16 = i4 + 3;
                if (i16 <= i12) {
                    int i17 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 2] & 255);
                    bArr3[i6] = bArr2[(i17 >> 18) & 63];
                    bArr3[i6 + 1] = bArr2[(i17 >> 12) & 63];
                    bArr3[i6 + 2] = bArr2[(i17 >> 6) & 63];
                    bArr3[i6 + 3] = bArr2[i17 & 63];
                    i6 += 4;
                    i11--;
                    if (i11 == 0) {
                        break;
                    }
                    i4 = i16;
                } else {
                    if (z) {
                        int i18 = this.f5b;
                        if (i4 - i18 == i12 - 1) {
                            if (i18 > 0) {
                                b4 = this.f8d[0];
                                i14 = 1;
                            } else {
                                byte b5 = bArr[i4];
                                i4++;
                                b4 = b5;
                            }
                            int i19 = (b4 & 255) << 4;
                            this.f5b -= i14;
                            int i20 = i6 + 1;
                            bArr3[i6] = bArr2[(i19 >> 6) & 63];
                            i6 = i20 + 1;
                            bArr3[i20] = bArr2[i19 & 63];
                            if (this.f6b) {
                                int i21 = i6 + 1;
                                bArr3[i6] = 61;
                                i6 = i21 + 1;
                                bArr3[i21] = 61;
                            }
                            if (this.f7c) {
                                if (this.f75862d) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (f75859a && this.f5b != 0) {
                                throw new AssertionError();
                            }
                            if (!f75859a && i4 != i12) {
                                throw new AssertionError();
                            }
                        } else {
                            if (i4 - i18 == i12 - 2) {
                                if (i18 > 1) {
                                    b2 = this.f8d[0];
                                    i14 = 1;
                                } else {
                                    byte b6 = bArr[i4];
                                    i4++;
                                    b2 = b6;
                                }
                                int i22 = (b2 & 255) << 10;
                                if (this.f5b > 0) {
                                    i8 = i14 + 1;
                                    b3 = this.f8d[i14];
                                } else {
                                    i8 = i14;
                                    b3 = bArr[i4];
                                    i4++;
                                }
                                int i23 = i22 | ((b3 & 255) << 2);
                                this.f5b -= i8;
                                int i24 = i6 + 1;
                                bArr3[i6] = bArr2[(i23 >> 12) & 63];
                                int i25 = i24 + 1;
                                bArr3[i24] = bArr2[(i23 >> 6) & 63];
                                int i26 = i25 + 1;
                                bArr3[i25] = bArr2[i23 & 63];
                                if (this.f6b) {
                                    bArr3[i26] = 61;
                                    i26++;
                                }
                                if (this.f7c) {
                                    if (this.f75862d) {
                                        bArr3[i26] = 13;
                                        i26++;
                                    }
                                    bArr3[i26] = 10;
                                    i26++;
                                }
                                i6 = i26;
                            } else if (this.f7c && i6 > 0 && i11 != 19) {
                                if (this.f75862d) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (f75859a) {
                            }
                            if (!f75859a) {
                                throw new AssertionError();
                            }
                        }
                    } else if (i4 == i12 - 1) {
                        byte[] bArr5 = this.f8d;
                        int i27 = this.f5b;
                        this.f5b = i27 + 1;
                        bArr5[i27] = bArr[i4];
                    } else if (i4 == i12 - 2) {
                        byte[] bArr6 = this.f8d;
                        int i28 = this.f5b;
                        int i29 = i28 + 1;
                        this.f5b = i29;
                        bArr6[i28] = bArr[i4];
                        this.f5b = i29 + 1;
                        bArr6[i29] = bArr[i4 + 1];
                    }
                    ((a) this).f75855a = i6;
                    this.count = i11;
                    return true;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641359978, "Lcom/ta/utdid2/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(641359978, "Lcom/ta/utdid2/a/a/b;");
                return;
            }
        }
        f75854a = !b.class.desiredAssertionStatus();
    }

    public b() {
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

    public static byte[] decode(String str, int i2) {
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

    public static byte[] decode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) ? decode(bArr, 0, bArr.length, i2) : (byte[]) invokeLI.objValue;
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2, i3, i4)) == null) {
            c cVar = new c(i4, null);
            int i5 = (i3 / 3) * 4;
            if (cVar.f6b) {
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
            if (cVar.f7c && i3 > 0) {
                i5 += (((i3 - 1) / 57) + 1) * (cVar.f75862d ? 2 : 1);
            }
            ((a) cVar).f4a = new byte[i5];
            cVar.a(bArr, i2, i3, true);
            if (f75854a || ((a) cVar).f75855a == i5) {
                return ((a) cVar).f4a;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3, i4)) == null) {
            C2079b c2079b = new C2079b(i4, new byte[(i3 * 3) / 4]);
            if (c2079b.a(bArr, i2, i3, true)) {
                int i5 = ((a) c2079b).f75855a;
                byte[] bArr2 = ((a) c2079b).f4a;
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
}
