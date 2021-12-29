package com.kuaishou.weapon.un;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.UnsupportedEncodingException;
/* loaded from: classes3.dex */
public class k1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f57296b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f57297c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f57298d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f57299e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f57300f = 16;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ boolean f57301g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f57302b;

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

        public abstract int a(int i2);

        public abstract boolean a(byte[] bArr, int i2, int i3, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: f  reason: collision with root package name */
        public static final int[] f57303f;

        /* renamed from: g  reason: collision with root package name */
        public static final int[] f57304g;

        /* renamed from: h  reason: collision with root package name */
        public static final int f57305h = -1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f57306i = -2;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f57307c;

        /* renamed from: d  reason: collision with root package name */
        public int f57308d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f57309e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1265267188, "Lcom/kuaishou/weapon/un/k1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1265267188, "Lcom/kuaishou/weapon/un/k1$b;");
                    return;
                }
            }
            f57303f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            f57304g = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
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
            this.f57309e = (i2 & 8) == 0 ? f57303f : f57304g;
            this.f57307c = 0;
            this.f57308d = 0;
        }

        @Override // com.kuaishou.weapon.un.k1.a
        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ((i2 * 3) / 4) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
            if (r5 != 4) goto L29;
         */
        @Override // com.kuaishou.weapon.un.k1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.f57307c;
                if (i4 == 6) {
                    return false;
                }
                int i5 = i3 + i2;
                int i6 = this.f57308d;
                byte[] bArr2 = this.a;
                int[] iArr = this.f57309e;
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
                                    this.f57307c = 6;
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
                                    this.f57307c = 6;
                                    return false;
                                }
                            } else if (i13 == -2) {
                                i9++;
                            } else if (i13 != -1) {
                                this.f57307c = 6;
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
                                this.f57307c = 6;
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
                        this.f57307c = i9;
                    }
                    this.f57307c = 6;
                    return false;
                }
                this.f57307c = i9;
                this.f57308d = i7;
                this.f57302b = i8;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: j  reason: collision with root package name */
        public static final int f57310j = 19;

        /* renamed from: k  reason: collision with root package name */
        public static final byte[] f57311k;
        public static final byte[] l;
        public static final /* synthetic */ boolean m;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f57312c;

        /* renamed from: d  reason: collision with root package name */
        public int f57313d;

        /* renamed from: e  reason: collision with root package name */
        public int f57314e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f57315f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f57316g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f57317h;

        /* renamed from: i  reason: collision with root package name */
        public final byte[] f57318i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1265267157, "Lcom/kuaishou/weapon/un/k1$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1265267157, "Lcom/kuaishou/weapon/un/k1$c;");
                    return;
                }
            }
            m = !k1.class.desiredAssertionStatus();
            f57311k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            l = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
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
            this.a = bArr;
            this.f57315f = (i2 & 1) == 0;
            this.f57316g = (i2 & 2) == 0;
            this.f57317h = (i2 & 4) != 0;
            this.f57318i = (i2 & 8) == 0 ? f57311k : l;
            this.f57312c = new byte[2];
            this.f57313d = 0;
            this.f57314e = this.f57316g ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.un.k1.a
        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ((i2 * 8) / 5) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.f57317h == false) goto L28;
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
        @Override // com.kuaishou.weapon.un.k1.a
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
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.f57318i;
            byte[] bArr3 = this.a;
            int i11 = this.f57314e;
            int i12 = i3 + i2;
            int i13 = this.f57313d;
            int i14 = 0;
            if (i13 != 1) {
                if (i13 == 2 && (i10 = i2 + 1) <= i12) {
                    byte[] bArr4 = this.f57312c;
                    i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i2] & 255);
                    this.f57313d = 0;
                    i4 = i10;
                }
                i4 = i2;
                i5 = -1;
            } else {
                if (i2 + 2 <= i12) {
                    int i15 = i2 + 1;
                    i4 = i15 + 1;
                    i5 = (bArr[i15] & 255) | ((this.f57312c[0] & 255) << 16) | ((bArr[i2] & 255) << 8);
                    this.f57313d = 0;
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
                    if (this.f57317h) {
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
                if (i16 > i12) {
                    if (z) {
                        int i17 = this.f57313d;
                        int i18 = i4 - i17;
                        if (i18 == i12 - 1) {
                            if (i17 > 0) {
                                b4 = this.f57312c[0];
                                i14 = 1;
                            } else {
                                byte b5 = bArr[i4];
                                i4++;
                                b4 = b5;
                            }
                            int i19 = (b4 & 255) << 4;
                            this.f57313d -= i14;
                            int i20 = i6 + 1;
                            bArr3[i6] = bArr2[(i19 >> 6) & 63];
                            i6 = i20 + 1;
                            bArr3[i20] = bArr2[i19 & 63];
                            if (this.f57315f) {
                                int i21 = i6 + 1;
                                bArr3[i6] = 61;
                                i6 = i21 + 1;
                                bArr3[i21] = 61;
                            }
                            if (this.f57316g) {
                                if (this.f57317h) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (m && this.f57313d != 0) {
                                throw new AssertionError();
                            }
                            if (!m && i4 != i12) {
                                throw new AssertionError();
                            }
                        } else if (i18 == i12 - 2) {
                            if (i17 > 1) {
                                b2 = this.f57312c[0];
                                i14 = 1;
                            } else {
                                byte b6 = bArr[i4];
                                i4++;
                                b2 = b6;
                            }
                            int i22 = (b2 & 255) << 10;
                            if (this.f57313d > 0) {
                                i8 = i14 + 1;
                                b3 = this.f57312c[i14];
                            } else {
                                i8 = i14;
                                b3 = bArr[i4];
                                i4++;
                            }
                            int i23 = i22 | ((b3 & 255) << 2);
                            this.f57313d -= i8;
                            int i24 = i6 + 1;
                            bArr3[i6] = bArr2[(i23 >> 12) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[(i23 >> 6) & 63];
                            int i26 = i25 + 1;
                            bArr3[i25] = bArr2[i23 & 63];
                            if (this.f57315f) {
                                bArr3[i26] = 61;
                                i26++;
                            }
                            if (this.f57316g) {
                                if (this.f57317h) {
                                    bArr3[i26] = 13;
                                    i26++;
                                }
                                i7 = i26 + 1;
                                bArr3[i26] = 10;
                                i6 = i7;
                                if (m) {
                                }
                                if (!m) {
                                    throw new AssertionError();
                                }
                            } else {
                                i6 = i26;
                                if (m) {
                                }
                                if (!m) {
                                }
                            }
                        } else {
                            if (this.f57316g && i6 > 0 && i11 != 19) {
                                if (this.f57317h) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (m) {
                            }
                            if (!m) {
                            }
                        }
                    } else if (i4 == i12 - 1) {
                        byte[] bArr5 = this.f57312c;
                        int i27 = this.f57313d;
                        this.f57313d = i27 + 1;
                        bArr5[i27] = bArr[i4];
                    } else if (i4 == i12 - 2) {
                        byte[] bArr6 = this.f57312c;
                        int i28 = this.f57313d;
                        int i29 = i28 + 1;
                        this.f57313d = i29;
                        bArr6[i28] = bArr[i4];
                        this.f57313d = i29 + 1;
                        bArr6[i29] = bArr[i4 + 1];
                    }
                    this.f57302b = i6;
                    this.f57314e = i11;
                    return true;
                }
                int i30 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 2] & 255);
                bArr3[i6] = bArr2[(i30 >> 18) & 63];
                bArr3[i6 + 1] = bArr2[(i30 >> 12) & 63];
                bArr3[i6 + 2] = bArr2[(i30 >> 6) & 63];
                bArr3[i6 + 3] = bArr2[i30 & 63];
                i6 += 4;
                i11--;
                if (i11 == 0) {
                    break;
                }
                i4 = i16;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(534995658, "Lcom/kuaishou/weapon/un/k1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(534995658, "Lcom/kuaishou/weapon/un/k1;");
                return;
            }
        }
        f57301g = !k1.class.desiredAssertionStatus();
    }

    public k1() {
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

    public static byte[] a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) ? a(str.getBytes(), i2) : (byte[]) invokeLI.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? a(bArr, 0, bArr.length, 0) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i2)) == null) ? a(bArr, 0, bArr.length, i2) : (byte[]) invokeLI.objValue;
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i2, i3, i4)) == null) {
            b bVar = new b(i4, new byte[(i3 * 3) / 4]);
            if (bVar.a(bArr, i2, i3, true)) {
                int i5 = bVar.f57302b;
                byte[] bArr2 = bVar.a;
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

    public static String b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) ? new String(a(str.getBytes(), i2)) : (String) invokeLI.objValue;
    }

    public static byte[] b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i2)) == null) ? b(bArr, 0, bArr.length, i2) : (byte[]) invokeLI.objValue;
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65545, null, bArr, i2, i3, i4)) == null) {
            c cVar = new c(i4, null);
            int i5 = (i3 / 3) * 4;
            if (!cVar.f57315f) {
                int i6 = i3 % 3;
                if (i6 == 1) {
                    i5 += 2;
                } else if (i6 == 2) {
                    i5 += 3;
                }
            } else if (i3 % 3 > 0) {
                i5 += 4;
            }
            if (cVar.f57316g && i3 > 0) {
                i5 += (((i3 - 1) / 57) + 1) * (cVar.f57317h ? 2 : 1);
            }
            cVar.a = new byte[i5];
            cVar.a(bArr, i2, i3, true);
            if (f57301g || cVar.f57302b == i5) {
                return cVar.a;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static String c(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, bArr, i2)) == null) {
            try {
                return new String(b(bArr, i2), "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String c(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65547, null, bArr, i2, i3, i4)) == null) {
            try {
                return new String(b(bArr, i2, i3, i4), "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLIII.objValue;
    }
}
