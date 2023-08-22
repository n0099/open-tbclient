package com.kuaishou.weapon.p0;

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
import java.util.regex.Pattern;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final /* synthetic */ boolean g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public int b;

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

        public abstract int a(int i);

        public abstract boolean a(byte[] bArr, int i, int i2, boolean z);
    }

    /* loaded from: classes10.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] f;
        public static final int[] g;
        public static final int h = -1;
        public static final int i = -2;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;
        public int d;
        public final int[] e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1782185277, "Lcom/kuaishou/weapon/p0/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1782185277, "Lcom/kuaishou/weapon/p0/d$b;");
                    return;
                }
            }
            f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            g = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(int i2, byte[] bArr) {
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
            this.a = bArr;
            this.e = (i2 & 8) == 0 ? f : g;
            this.c = 0;
            this.d = 0;
        }

        @Override // com.kuaishou.weapon.p0.d.a
        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ((i2 * 3) / 4) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00fc, code lost:
            if (r5 != 4) goto L29;
         */
        @Override // com.kuaishou.weapon.p0.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.c;
                if (i4 == 6) {
                    return false;
                }
                int i5 = i3 + i2;
                int i6 = this.d;
                byte[] bArr2 = this.a;
                int[] iArr = this.e;
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
                                    this.c = 6;
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
                                    break;
                                }
                            }
                            i13 |= i7 << 6;
                        } else if (i9 != 3) {
                            if (i9 != 4) {
                                if (i9 == 5 && i13 != -1) {
                                    this.c = 6;
                                    return false;
                                }
                            } else if (i13 == -2) {
                                i9++;
                            } else if (i13 != -1) {
                                this.c = 6;
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
                            break;
                        }
                        i9++;
                        i7 = i13;
                    } else {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.c = 6;
                                return false;
                            }
                        }
                        i9++;
                        i7 = i13;
                    }
                    i10 = i12;
                }
                if (z) {
                    if (i9 != 1) {
                        if (i9 == 2) {
                            bArr2[i8] = (byte) (i7 >> 4);
                            i8++;
                        } else if (i9 == 3) {
                            int i15 = i8 + 1;
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 = i15 + 1;
                            bArr2[i15] = (byte) (i7 >> 2);
                        }
                        this.c = i9;
                    }
                    this.c = 6;
                    return false;
                }
                this.c = i9;
                this.d = i7;
                this.b = i8;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int j = 19;
        public static final byte[] k;
        public static final byte[] l;
        public static final /* synthetic */ boolean m;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] c;
        public int d;
        public int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final byte[] i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1782185308, "Lcom/kuaishou/weapon/p0/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1782185308, "Lcom/kuaishou/weapon/p0/d$c;");
                    return;
                }
            }
            m = !d.class.desiredAssertionStatus();
            k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            l = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
        }

        public c(int i, byte[] bArr) {
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
            this.a = bArr;
            this.f = (i & 1) == 0;
            this.g = (i & 2) == 0;
            this.h = (i & 4) != 0;
            this.i = (i & 8) == 0 ? k : l;
            this.c = new byte[2];
            this.d = 0;
            this.e = this.g ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p0.d.a
        public int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? ((i * 8) / 5) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
            if (r17.h == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
            r2[r6] = 13;
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00e0, code lost:
            r2[r6] = 10;
            r6 = r6 + 1;
            r11 = r10;
         */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d1 A[ADDED_TO_REGION] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e0 -> B:23:0x008d). Please submit an issue!!! */
        @Override // com.kuaishou.weapon.p0.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            int i3;
            int i4;
            int i5;
            int i6;
            byte b;
            int i7;
            byte b2;
            byte b3;
            int i8;
            int i9;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.i;
            byte[] bArr3 = this.a;
            int i10 = this.e;
            int i11 = i2 + i;
            int i12 = this.d;
            int i13 = 0;
            if (i12 != 1) {
                if (i12 == 2 && (i9 = i + 1) <= i11) {
                    byte[] bArr4 = this.c;
                    i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                    this.d = 0;
                    i3 = i9;
                }
                i3 = i;
                i4 = -1;
            } else {
                if (i + 2 <= i11) {
                    int i14 = i + 1;
                    i3 = i14 + 1;
                    i4 = (bArr[i14] & 255) | ((this.c[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                    this.d = 0;
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
                    if (this.h) {
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
                if (i15 > i11) {
                    if (z) {
                        int i16 = this.d;
                        int i17 = i3 - i16;
                        if (i17 == i11 - 1) {
                            if (i16 > 0) {
                                b3 = this.c[0];
                                i13 = 1;
                            } else {
                                byte b4 = bArr[i3];
                                i3++;
                                b3 = b4;
                            }
                            int i18 = (b3 & 255) << 4;
                            this.d -= i13;
                            int i19 = i5 + 1;
                            bArr3[i5] = bArr2[(i18 >> 6) & 63];
                            i5 = i19 + 1;
                            bArr3[i19] = bArr2[i18 & 63];
                            if (this.f) {
                                int i20 = i5 + 1;
                                bArr3[i5] = 61;
                                i5 = i20 + 1;
                                bArr3[i20] = 61;
                            }
                            if (this.g) {
                                if (this.h) {
                                    bArr3[i5] = 13;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                            if (m && this.d != 0) {
                                throw new AssertionError();
                            }
                            if (!m && i3 != i11) {
                                throw new AssertionError();
                            }
                        } else if (i17 == i11 - 2) {
                            if (i16 > 1) {
                                b = this.c[0];
                                i13 = 1;
                            } else {
                                byte b5 = bArr[i3];
                                i3++;
                                b = b5;
                            }
                            int i21 = (b & 255) << 10;
                            if (this.d > 0) {
                                i7 = i13 + 1;
                                b2 = this.c[i13];
                            } else {
                                i7 = i13;
                                b2 = bArr[i3];
                                i3++;
                            }
                            int i22 = i21 | ((b2 & 255) << 2);
                            this.d -= i7;
                            int i23 = i5 + 1;
                            bArr3[i5] = bArr2[(i22 >> 12) & 63];
                            int i24 = i23 + 1;
                            bArr3[i23] = bArr2[(i22 >> 6) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[i22 & 63];
                            if (this.f) {
                                bArr3[i25] = 61;
                                i25++;
                            }
                            if (this.g) {
                                if (this.h) {
                                    bArr3[i25] = 13;
                                    i25++;
                                }
                                i6 = i25 + 1;
                                bArr3[i25] = 10;
                                i5 = i6;
                                if (m) {
                                }
                                if (!m) {
                                    throw new AssertionError();
                                }
                            } else {
                                i5 = i25;
                                if (m) {
                                }
                                if (!m) {
                                }
                            }
                        } else {
                            if (this.g && i5 > 0 && i10 != 19) {
                                if (this.h) {
                                    bArr3[i5] = 13;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                            if (m) {
                            }
                            if (!m) {
                            }
                        }
                    } else if (i3 == i11 - 1) {
                        byte[] bArr5 = this.c;
                        int i26 = this.d;
                        this.d = i26 + 1;
                        bArr5[i26] = bArr[i3];
                    } else if (i3 == i11 - 2) {
                        byte[] bArr6 = this.c;
                        int i27 = this.d;
                        int i28 = i27 + 1;
                        this.d = i28;
                        bArr6[i27] = bArr[i3];
                        this.d = i28 + 1;
                        bArr6[i28] = bArr[i3 + 1];
                    }
                    this.b = i5;
                    this.e = i10;
                    return true;
                }
                int i29 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
                bArr3[i5] = bArr2[(i29 >> 18) & 63];
                bArr3[i5 + 1] = bArr2[(i29 >> 12) & 63];
                bArr3[i5 + 2] = bArr2[(i29 >> 6) & 63];
                bArr3[i5 + 3] = bArr2[i29 & 63];
                i5 += 4;
                i10--;
                if (i10 == 0) {
                    break;
                }
                i3 = i15;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774917, "Lcom/kuaishou/weapon/p0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774917, "Lcom/kuaishou/weapon/p0/d;");
                return;
            }
        }
        g = !d.class.desiredAssertionStatus();
    }

    public d() {
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

    public static String a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            try {
                return new String(b(bArr, 0), str);
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                try {
                    if (!str.equals("")) {
                        return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$", str);
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) ? a(str.getBytes(), i) : (byte[]) invokeLI.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? a(bArr, 0, bArr.length, 0) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bArr, i)) == null) ? a(bArr, 0, bArr.length, i) : (byte[]) invokeLI.objValue;
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65543, null, bArr, i, i2, i3)) == null) {
            b bVar = new b(i3, new byte[(i2 * 3) / 4]);
            if (bVar.a(bArr, i, i2, true)) {
                int i4 = bVar.b;
                byte[] bArr2 = bVar.a;
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

    public static String b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) {
            try {
                return new String(a(str.getBytes(), i));
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static byte[] b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bArr, i)) == null) {
            try {
                return b(bArr, 0, bArr.length, i);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65546, null, bArr, i, i2, i3)) == null) {
            c cVar = new c(i3, null);
            int i4 = (i2 / 3) * 4;
            if (!cVar.f) {
                int i5 = i2 % 3;
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            } else if (i2 % 3 > 0) {
                i4 += 4;
            }
            if (cVar.g && i2 > 0) {
                i4 += (((i2 - 1) / 57) + 1) * (cVar.h ? 2 : 1);
            }
            cVar.a = new byte[i4];
            cVar.a(bArr, i, i2, true);
            if (g || cVar.b == i4) {
                return cVar.a;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static String c(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, bArr, i)) == null) {
            try {
                return new String(b(bArr, i), "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String c(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65548, null, bArr, i, i2, i3)) == null) {
            try {
                return new String(b(bArr, i, i2, i3), "US-ASCII");
            } catch (Throwable th) {
                throw new AssertionError(th);
            }
        }
        return (String) invokeLIII.objValue;
    }
}
