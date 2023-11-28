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
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final /* synthetic */ boolean g;
    public static final Pattern h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public int b;

        public abstract int a(int i);

        public abstract boolean a(byte[] bArr, int i, int i2, boolean z);

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

    /* loaded from: classes10.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] c;
        public static final int[] d;
        public static final int e = -1;
        public static final int f = -2;
        public transient /* synthetic */ FieldHolder $fh;
        public int g;
        public int h;
        public final int[] i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1782155486, "Lcom/kuaishou/weapon/p0/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1782155486, "Lcom/kuaishou/weapon/p0/c$b;");
                    return;
                }
            }
            c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(int i, byte[] bArr) {
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
            this.a = bArr;
            if ((i & 8) == 0) {
                iArr = c;
            } else {
                iArr = d;
            }
            this.i = iArr;
            this.g = 0;
            this.h = 0;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return ((i * 3) / 4) + 10;
            }
            return invokeI.intValue;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int i3 = this.g;
                if (i3 == 6) {
                    return false;
                }
                int i4 = i2 + i;
                int i5 = this.h;
                byte[] bArr2 = this.a;
                int[] iArr = this.i;
                int i6 = i5;
                int i7 = 0;
                int i8 = i3;
                int i9 = i;
                while (i9 < i4) {
                    if (i8 == 0) {
                        while (true) {
                            int i10 = i9 + 4;
                            if (i10 > i4 || (i6 = iArr[bArr[i9 + 3] & 255] | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 2] & 255] << 6)) < 0) {
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
                                            this.g = 6;
                                            return false;
                                        }
                                    } else {
                                        if (i12 != -2) {
                                            if (i12 != -1) {
                                                this.g = 6;
                                                return false;
                                            }
                                        }
                                        i8++;
                                    }
                                } else if (i12 >= 0) {
                                    i6 = (i6 << 6) | i12;
                                    bArr2[i7 + 2] = (byte) i6;
                                    bArr2[i7 + 1] = (byte) (i6 >> 8);
                                    bArr2[i7] = (byte) (i6 >> 16);
                                    i7 += 3;
                                    i9 = i11;
                                    i8 = 0;
                                } else if (i12 == -2) {
                                    bArr2[i7 + 1] = (byte) (i6 >> 2);
                                    bArr2[i7] = (byte) (i6 >> 10);
                                    i7 += 2;
                                    i9 = i11;
                                    i8 = 5;
                                } else if (i12 != -1) {
                                    this.g = 6;
                                    return false;
                                }
                            } else if (i12 < 0) {
                                if (i12 == -2) {
                                    bArr2[i7] = (byte) (i6 >> 4);
                                    i7++;
                                    i9 = i11;
                                    i8 = 4;
                                } else if (i12 != -1) {
                                    this.g = 6;
                                    return false;
                                }
                            } else {
                                i6 = (i6 << 6) | i12;
                                i8++;
                            }
                        } else {
                            if (i12 < 0) {
                                if (i12 != -1) {
                                    this.g = 6;
                                    return false;
                                }
                            }
                            i6 = (i6 << 6) | i12;
                            i8++;
                        }
                    } else if (i12 >= 0) {
                        i8++;
                        i6 = i12;
                    } else if (i12 != -1) {
                        this.g = 6;
                        return false;
                    }
                    i9 = i11;
                }
                if (!z) {
                    this.g = i8;
                    this.h = i6;
                    this.b = i7;
                    return true;
                } else if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                this.g = 6;
                                return false;
                            }
                        } else {
                            int i13 = i7 + 1;
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 = i13 + 1;
                            bArr2[i13] = (byte) (i6 >> 2);
                        }
                    } else {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                    }
                    this.g = i8;
                    this.b = i7;
                    return true;
                } else {
                    this.g = 6;
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0579c extends a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int c = 19;
        public static final /* synthetic */ boolean h;
        public static final byte[] i;
        public static final byte[] j;
        public transient /* synthetic */ FieldHolder $fh;
        public int d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final byte[] k;
        public int l;
        public final byte[] m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1782155517, "Lcom/kuaishou/weapon/p0/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1782155517, "Lcom/kuaishou/weapon/p0/c$c;");
                    return;
                }
            }
            h = !c.class.desiredAssertionStatus();
            i = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
        }

        public C0579c(int i2, byte[] bArr) {
            boolean z;
            boolean z2;
            byte[] bArr2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            if ((i2 & 1) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.e = z;
            if ((i2 & 2) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f = z2;
            this.g = (i2 & 4) != 0;
            if ((i2 & 8) == 0) {
                bArr2 = i;
            } else {
                bArr2 = j;
            }
            this.m = bArr2;
            this.k = new byte[2];
            this.d = 0;
            if (this.f) {
                i3 = 19;
            } else {
                i3 = -1;
            }
            this.l = i3;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                return ((i2 * 8) / 5) + 10;
            }
            return invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.g == false) goto L28;
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
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            int i4;
            int i5;
            int i6;
            int i7;
            byte b;
            int i8;
            byte b2;
            byte b3;
            int i9;
            int i10;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                byte[] bArr2 = this.m;
                byte[] bArr3 = this.a;
                int i11 = this.l;
                int i12 = i3 + i2;
                int i13 = this.d;
                int i14 = 0;
                if (i13 != 1) {
                    if (i13 == 2 && (i10 = i2 + 1) <= i12) {
                        byte[] bArr4 = this.k;
                        i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i2] & 255);
                        this.d = 0;
                        i4 = i10;
                    }
                    i4 = i2;
                    i5 = -1;
                } else {
                    if (i2 + 2 <= i12) {
                        int i15 = i2 + 1;
                        i4 = i15 + 1;
                        i5 = (bArr[i15] & 255) | ((this.k[0] & 255) << 16) | ((bArr[i2] & 255) << 8);
                        this.d = 0;
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
                        if (this.g) {
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
                            int i18 = this.d;
                            if (i4 - i18 == i12 - 1) {
                                if (i18 > 0) {
                                    b3 = this.k[0];
                                    i14 = 1;
                                } else {
                                    byte b4 = bArr[i4];
                                    i4++;
                                    b3 = b4;
                                }
                                int i19 = (b3 & 255) << 4;
                                this.d -= i14;
                                int i20 = i6 + 1;
                                bArr3[i6] = bArr2[(i19 >> 6) & 63];
                                i6 = i20 + 1;
                                bArr3[i20] = bArr2[i19 & 63];
                                if (this.e) {
                                    int i21 = i6 + 1;
                                    bArr3[i6] = 61;
                                    i6 = i21 + 1;
                                    bArr3[i21] = 61;
                                }
                                if (this.f) {
                                    if (this.g) {
                                        bArr3[i6] = 13;
                                        i6++;
                                    }
                                    i7 = i6 + 1;
                                    bArr3[i6] = 10;
                                    i6 = i7;
                                }
                                if (h && this.d != 0) {
                                    throw new AssertionError();
                                }
                                if (!h && i4 != i12) {
                                    throw new AssertionError();
                                }
                            } else {
                                if (i4 - i18 == i12 - 2) {
                                    if (i18 > 1) {
                                        b = this.k[0];
                                        i14 = 1;
                                    } else {
                                        byte b5 = bArr[i4];
                                        i4++;
                                        b = b5;
                                    }
                                    int i22 = (b & 255) << 10;
                                    if (this.d > 0) {
                                        i8 = i14 + 1;
                                        b2 = this.k[i14];
                                    } else {
                                        i8 = i14;
                                        b2 = bArr[i4];
                                        i4++;
                                    }
                                    int i23 = i22 | ((b2 & 255) << 2);
                                    this.d -= i8;
                                    int i24 = i6 + 1;
                                    bArr3[i6] = bArr2[(i23 >> 12) & 63];
                                    int i25 = i24 + 1;
                                    bArr3[i24] = bArr2[(i23 >> 6) & 63];
                                    int i26 = i25 + 1;
                                    bArr3[i25] = bArr2[i23 & 63];
                                    if (this.e) {
                                        bArr3[i26] = 61;
                                        i26++;
                                    }
                                    if (this.f) {
                                        if (this.g) {
                                            bArr3[i26] = 13;
                                            i26++;
                                        }
                                        bArr3[i26] = 10;
                                        i26++;
                                    }
                                    i6 = i26;
                                } else if (this.f && i6 > 0 && i11 != 19) {
                                    if (this.g) {
                                        bArr3[i6] = 13;
                                        i6++;
                                    }
                                    i7 = i6 + 1;
                                    bArr3[i6] = 10;
                                    i6 = i7;
                                }
                                if (h) {
                                }
                                if (!h) {
                                    throw new AssertionError();
                                }
                            }
                        } else if (i4 == i12 - 1) {
                            byte[] bArr5 = this.k;
                            int i27 = this.d;
                            this.d = i27 + 1;
                            bArr5[i27] = bArr[i4];
                        } else if (i4 == i12 - 2) {
                            byte[] bArr6 = this.k;
                            int i28 = this.d;
                            int i29 = i28 + 1;
                            this.d = i29;
                            bArr6[i28] = bArr[i4];
                            this.d = i29 + 1;
                            bArr6[i29] = bArr[i4 + 1];
                        }
                        this.b = i6;
                        this.l = i11;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774948, "Lcom/kuaishou/weapon/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774948, "Lcom/kuaishou/weapon/p0/c;");
                return;
            }
        }
        g = !c.class.desiredAssertionStatus();
        h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");
    }

    public c() {
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
                return new String(c(bArr, 0), str);
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLL.objValue;
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

    public static byte[] c(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, bArr, i)) == null) {
            try {
                return c(bArr, 0, bArr.length, i);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                try {
                    if (!str.equals("")) {
                        return h.matcher(str).matches();
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            return a(str.getBytes(), i);
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bArr, i)) == null) {
            try {
                return new String(c(bArr, i), "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLI.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            return a(bArr, 0, bArr.length, 0);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bArr, i)) == null) {
            return a(bArr, 0, bArr.length, i);
        }
        return (byte[]) invokeLI.objValue;
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

    public static String b(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65546, null, bArr, i, i2, i3)) == null) {
            try {
                return new String(c(bArr, i, i2, i3), "US-ASCII");
            } catch (Throwable th) {
                throw new AssertionError(th);
            }
        }
        return (String) invokeLIII.objValue;
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65548, null, bArr, i, i2, i3)) == null) {
            C0579c c0579c = new C0579c(i3, null);
            int i4 = (i2 / 3) * 4;
            int i5 = 2;
            if (c0579c.e) {
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
            if (c0579c.f && i2 > 0) {
                int i7 = ((i2 - 1) / 57) + 1;
                if (!c0579c.g) {
                    i5 = 1;
                }
                i4 += i7 * i5;
            }
            c0579c.a = new byte[i4];
            c0579c.a(bArr, i, i2, true);
            if (!g && c0579c.b != i4) {
                throw new AssertionError();
            }
            return c0579c.a;
        }
        return (byte[]) invokeLIII.objValue;
    }
}
