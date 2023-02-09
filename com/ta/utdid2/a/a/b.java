package com.ta.utdid2.a.a;

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
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f11a;

        public a() {
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

    /* renamed from: com.ta.utdid2.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0727b extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] a;
        public static final int[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] c;
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
            a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            b = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public C0727b(int i, byte[] bArr) {
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
            ((a) this).f11a = bArr;
            if ((i & 8) == 0) {
                iArr = a;
            } else {
                iArr = b;
            }
            this.c = iArr;
            this.state = 0;
            this.value = 0;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int i3 = this.state;
                if (i3 == 6) {
                    return false;
                }
                int i4 = i2 + i;
                int i5 = this.value;
                byte[] bArr2 = ((a) this).f11a;
                int[] iArr = this.c;
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
                    ((a) this).a = i7;
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
                    ((a) this).a = i7;
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
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean a;
        public static final byte[] b;
        public static final byte[] c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with other field name */
        public int f12b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f13b;

        /* renamed from: c  reason: collision with other field name */
        public final boolean f14c;
        public int count;
        public final boolean d;

        /* renamed from: d  reason: collision with other field name */
        public final byte[] f15d;
        public final byte[] e;

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
            a = !b.class.desiredAssertionStatus();
            b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public c(int i, byte[] bArr) {
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
            ((a) this).f11a = bArr;
            if ((i & 1) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f13b = z;
            if ((i & 2) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f14c = z2;
            this.d = (i & 4) != 0;
            if ((i & 8) == 0) {
                bArr2 = b;
            } else {
                bArr2 = c;
            }
            this.e = bArr2;
            this.f15d = new byte[2];
            this.f12b = 0;
            if (this.f14c) {
                i2 = 19;
            } else {
                i2 = -1;
            }
            this.count = i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.d == false) goto L28;
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
        /* JADX WARN: Removed duplicated region for block: B:82:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d1 A[ADDED_TO_REGION] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e1 -> B:24:0x008e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            int i3;
            int i4;
            int i5;
            int i6;
            byte b2;
            int i7;
            byte b3;
            byte b4;
            int i8;
            int i9;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                byte[] bArr2 = this.e;
                byte[] bArr3 = ((a) this).f11a;
                int i10 = this.count;
                int i11 = i2 + i;
                int i12 = this.f12b;
                int i13 = 0;
                if (i12 != 1) {
                    if (i12 == 2 && (i9 = i + 1) <= i11) {
                        byte[] bArr4 = this.f15d;
                        i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                        this.f12b = 0;
                        i3 = i9;
                    }
                    i3 = i;
                    i4 = -1;
                } else {
                    if (i + 2 <= i11) {
                        int i14 = i + 1;
                        i3 = i14 + 1;
                        i4 = (bArr[i14] & 255) | ((this.f15d[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                        this.f12b = 0;
                    }
                    i3 = i;
                    i4 = -1;
                }
                if (i4 != -1) {
                    bArr3[0] = bArr2[(i4 >> 18) & 63];
                    bArr3[1] = bArr2[(i4 >> 12) & 63];
                    bArr3[2] = bArr2[(i4 >> 6) & 63];
                    bArr3[3] = bArr2[i4 & 63];
                    i10--;
                    if (i10 == 0) {
                        if (this.d) {
                            i8 = 5;
                            bArr3[4] = 13;
                        } else {
                            i8 = 4;
                        }
                        i5 = i8 + 1;
                        bArr3[i8] = 10;
                        i10 = 19;
                    } else {
                        i5 = 4;
                    }
                } else {
                    i5 = 0;
                }
                while (true) {
                    int i15 = i3 + 3;
                    if (i15 <= i11) {
                        int i16 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
                        bArr3[i5] = bArr2[(i16 >> 18) & 63];
                        bArr3[i5 + 1] = bArr2[(i16 >> 12) & 63];
                        bArr3[i5 + 2] = bArr2[(i16 >> 6) & 63];
                        bArr3[i5 + 3] = bArr2[i16 & 63];
                        i5 += 4;
                        i10--;
                        if (i10 == 0) {
                            break;
                        }
                        i3 = i15;
                    } else {
                        if (z) {
                            int i17 = this.f12b;
                            int i18 = i3 - i17;
                            if (i18 == i11 - 1) {
                                if (i17 > 0) {
                                    b4 = this.f15d[0];
                                    i13 = 1;
                                } else {
                                    byte b5 = bArr[i3];
                                    i3++;
                                    b4 = b5;
                                }
                                int i19 = (b4 & 255) << 4;
                                this.f12b -= i13;
                                int i20 = i5 + 1;
                                bArr3[i5] = bArr2[(i19 >> 6) & 63];
                                i5 = i20 + 1;
                                bArr3[i20] = bArr2[i19 & 63];
                                if (this.f13b) {
                                    int i21 = i5 + 1;
                                    bArr3[i5] = BaseNCodec.PAD_DEFAULT;
                                    i5 = i21 + 1;
                                    bArr3[i21] = BaseNCodec.PAD_DEFAULT;
                                }
                                if (this.f14c) {
                                    if (this.d) {
                                        bArr3[i5] = 13;
                                        i5++;
                                    }
                                    i6 = i5 + 1;
                                    bArr3[i5] = 10;
                                    i5 = i6;
                                }
                                if (a && this.f12b != 0) {
                                    throw new AssertionError();
                                }
                                if (!a && i3 != i11) {
                                    throw new AssertionError();
                                }
                            } else if (i18 == i11 - 2) {
                                if (i17 > 1) {
                                    b2 = this.f15d[0];
                                    i13 = 1;
                                } else {
                                    byte b6 = bArr[i3];
                                    i3++;
                                    b2 = b6;
                                }
                                int i22 = (b2 & 255) << 10;
                                if (this.f12b > 0) {
                                    i7 = i13 + 1;
                                    b3 = this.f15d[i13];
                                } else {
                                    i7 = i13;
                                    b3 = bArr[i3];
                                    i3++;
                                }
                                int i23 = i22 | ((b3 & 255) << 2);
                                this.f12b -= i7;
                                int i24 = i5 + 1;
                                bArr3[i5] = bArr2[(i23 >> 12) & 63];
                                int i25 = i24 + 1;
                                bArr3[i24] = bArr2[(i23 >> 6) & 63];
                                int i26 = i25 + 1;
                                bArr3[i25] = bArr2[i23 & 63];
                                if (this.f13b) {
                                    bArr3[i26] = BaseNCodec.PAD_DEFAULT;
                                    i26++;
                                }
                                if (this.f14c) {
                                    if (this.d) {
                                        bArr3[i26] = 13;
                                        i26++;
                                    }
                                    i6 = i26 + 1;
                                    bArr3[i26] = 10;
                                    i5 = i6;
                                    if (a) {
                                    }
                                    if (!a) {
                                        throw new AssertionError();
                                    }
                                } else {
                                    i5 = i26;
                                    if (a) {
                                    }
                                    if (!a) {
                                    }
                                }
                            } else {
                                if (this.f14c && i5 > 0 && i10 != 19) {
                                    if (this.d) {
                                        bArr3[i5] = 13;
                                        i5++;
                                    }
                                    i6 = i5 + 1;
                                    bArr3[i5] = 10;
                                    i5 = i6;
                                }
                                if (a) {
                                }
                                if (!a) {
                                }
                            }
                        } else if (i3 == i11 - 1) {
                            byte[] bArr5 = this.f15d;
                            int i27 = this.f12b;
                            this.f12b = i27 + 1;
                            bArr5[i27] = bArr[i3];
                        } else if (i3 == i11 - 2) {
                            byte[] bArr6 = this.f15d;
                            int i28 = this.f12b;
                            int i29 = i28 + 1;
                            this.f12b = i29;
                            bArr6[i28] = bArr[i3];
                            this.f12b = i29 + 1;
                            bArr6[i29] = bArr[i3 + 1];
                        }
                        ((a) this).a = i5;
                        this.count = i10;
                        return true;
                    }
                }
            } else {
                return invokeCommon.booleanValue;
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
        a = !b.class.desiredAssertionStatus();
    }

    public b() {
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

    public static byte[] decode(String str, int i) {
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

    public static byte[] decode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) {
            return decode(bArr, 0, bArr.length, i);
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2, i3)) == null) {
            C0727b c0727b = new C0727b(i3, new byte[(i2 * 3) / 4]);
            if (c0727b.a(bArr, i, i2, true)) {
                int i4 = ((a) c0727b).a;
                byte[] bArr2 = ((a) c0727b).f11a;
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
            c cVar = new c(i3, null);
            int i4 = (i2 / 3) * 4;
            int i5 = 2;
            if (cVar.f13b) {
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
            if (cVar.f14c && i2 > 0) {
                int i7 = ((i2 - 1) / 57) + 1;
                if (!cVar.d) {
                    i5 = 1;
                }
                i4 += i7 * i5;
            }
            ((a) cVar).f11a = new byte[i4];
            cVar.a(bArr, i, i2, true);
            if (!a && ((a) cVar).a != i4) {
                throw new AssertionError();
            }
            return ((a) cVar).f11a;
        }
        return (byte[]) invokeLIII.objValue;
    }
}
