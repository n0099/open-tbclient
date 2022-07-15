package com.kuaishou.weapon.p0;

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
import com.bumptech.glide.disklrucache.StrictLineReader;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* renamed from: com.kuaishou.weapon.p0.ⁱⁱ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0446 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final int f630 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final int f631 = 1;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final int f632 = 2;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final int f633 = 4;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final int f634 = 8;

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final int f635 = 16;

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final /* synthetic */ boolean f636;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.ⁱⁱ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC0447 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public byte[] f637;

        /* renamed from: ʼ  reason: contains not printable characters */
        public int f638;

        public AbstractC0447() {
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

        /* renamed from: ʻ  reason: contains not printable characters */
        public abstract int mo981(int i);

        /* renamed from: ʻ  reason: contains not printable characters */
        public abstract boolean mo982(byte[] bArr, int i, int i2, boolean z);
    }

    /* renamed from: com.kuaishou.weapon.p0.ⁱⁱ$ʼ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0448 extends AbstractC0447 {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: ˆ  reason: contains not printable characters */
        public static final int[] f639;

        /* renamed from: ˈ  reason: contains not printable characters */
        public static final int[] f640;

        /* renamed from: ˉ  reason: contains not printable characters */
        public static final int f641 = -1;

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final int f642 = -2;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʽ  reason: contains not printable characters */
        public int f643;

        /* renamed from: ʾ  reason: contains not printable characters */
        public int f644;

        /* renamed from: ʿ  reason: contains not printable characters */
        public final int[] f645;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1352973921, "Lcom/kuaishou/weapon/p0/ⁱⁱ$ʼ;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1352973921, "Lcom/kuaishou/weapon/p0/ⁱⁱ$ʼ;");
                    return;
                }
            }
            f639 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            f640 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public C0448(int i, byte[] bArr) {
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
            this.f637 = bArr;
            this.f645 = (i & 8) == 0 ? f639 : f640;
            this.f643 = 0;
            this.f644 = 0;
        }

        @Override // com.kuaishou.weapon.p0.C0446.AbstractC0447
        /* renamed from: ʻ */
        public int mo981(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? ((i * 3) / 4) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00fc, code lost:
            if (r5 != 4) goto L29;
         */
        @Override // com.kuaishou.weapon.p0.C0446.AbstractC0447
        /* renamed from: ʻ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean mo982(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int i3 = this.f643;
                if (i3 == 6) {
                    return false;
                }
                int i4 = i2 + i;
                int i5 = this.f644;
                byte[] bArr2 = this.f637;
                int[] iArr = this.f645;
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
                        if (i8 == 1) {
                            if (i12 < 0) {
                                if (i12 != -1) {
                                    this.f643 = 6;
                                    return false;
                                }
                            }
                            i12 |= i6 << 6;
                        } else if (i8 == 2) {
                            if (i12 < 0) {
                                if (i12 == -2) {
                                    bArr2[i7] = (byte) (i6 >> 4);
                                    i7++;
                                    i8 = 4;
                                } else if (i12 != -1) {
                                    break;
                                }
                            }
                            i12 |= i6 << 6;
                        } else if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5 && i12 != -1) {
                                    this.f643 = 6;
                                    return false;
                                }
                            } else if (i12 == -2) {
                                i8++;
                            } else if (i12 != -1) {
                                this.f643 = 6;
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
                            break;
                        }
                        i8++;
                        i6 = i12;
                    } else {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.f643 = 6;
                                return false;
                            }
                        }
                        i8++;
                        i6 = i12;
                    }
                    i9 = i11;
                }
                if (z) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            bArr2[i7] = (byte) (i6 >> 4);
                            i7++;
                        } else if (i8 == 3) {
                            int i14 = i7 + 1;
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 = i14 + 1;
                            bArr2[i14] = (byte) (i6 >> 2);
                        }
                        this.f643 = i8;
                    }
                    this.f643 = 6;
                    return false;
                }
                this.f643 = i8;
                this.f644 = i6;
                this.f638 = i7;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.ⁱⁱ$ʽ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0449 extends AbstractC0447 {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final int f646 = 19;

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final byte[] f647;

        /* renamed from: ˏ  reason: contains not printable characters */
        public static final byte[] f648;

        /* renamed from: ˑ  reason: contains not printable characters */
        public static final /* synthetic */ boolean f649;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʽ  reason: contains not printable characters */
        public final byte[] f650;

        /* renamed from: ʾ  reason: contains not printable characters */
        public int f651;

        /* renamed from: ʿ  reason: contains not printable characters */
        public int f652;

        /* renamed from: ˆ  reason: contains not printable characters */
        public final boolean f653;

        /* renamed from: ˈ  reason: contains not printable characters */
        public final boolean f654;

        /* renamed from: ˉ  reason: contains not printable characters */
        public final boolean f655;

        /* renamed from: ˊ  reason: contains not printable characters */
        public final byte[] f656;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1352973890, "Lcom/kuaishou/weapon/p0/ⁱⁱ$ʽ;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1352973890, "Lcom/kuaishou/weapon/p0/ⁱⁱ$ʽ;");
                    return;
                }
            }
            f649 = !C0446.class.desiredAssertionStatus();
            f647 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
            f648 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public C0449(int i, byte[] bArr) {
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
            this.f637 = bArr;
            this.f653 = (i & 1) == 0;
            this.f654 = (i & 2) == 0;
            this.f655 = (i & 4) != 0;
            this.f656 = (i & 8) == 0 ? f647 : f648;
            this.f650 = new byte[2];
            this.f651 = 0;
            this.f652 = this.f654 ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p0.C0446.AbstractC0447
        /* renamed from: ʻ */
        public int mo981(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? ((i * 8) / 5) + 10 : invokeI.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
            if (r17.f655 == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
            r2[r6] = com.bumptech.glide.disklrucache.StrictLineReader.CR;
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
        @Override // com.kuaishou.weapon.p0.C0446.AbstractC0447
        /* renamed from: ʻ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean mo982(byte[] bArr, int i, int i2, boolean z) {
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
            byte[] bArr2 = this.f656;
            byte[] bArr3 = this.f637;
            int i10 = this.f652;
            int i11 = i2 + i;
            int i12 = this.f651;
            int i13 = 0;
            if (i12 != 1) {
                if (i12 == 2 && (i9 = i + 1) <= i11) {
                    byte[] bArr4 = this.f650;
                    i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                    this.f651 = 0;
                    i3 = i9;
                }
                i3 = i;
                i4 = -1;
            } else {
                if (i + 2 <= i11) {
                    int i14 = i + 1;
                    i3 = i14 + 1;
                    i4 = (bArr[i14] & 255) | ((this.f650[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                    this.f651 = 0;
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
                    if (this.f655) {
                        i8 = 5;
                        bArr3[4] = StrictLineReader.CR;
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
                        int i16 = this.f651;
                        int i17 = i3 - i16;
                        if (i17 == i11 - 1) {
                            if (i16 > 0) {
                                b3 = this.f650[0];
                                i13 = 1;
                            } else {
                                byte b4 = bArr[i3];
                                i3++;
                                b3 = b4;
                            }
                            int i18 = (b3 & 255) << 4;
                            this.f651 -= i13;
                            int i19 = i5 + 1;
                            bArr3[i5] = bArr2[(i18 >> 6) & 63];
                            i5 = i19 + 1;
                            bArr3[i19] = bArr2[i18 & 63];
                            if (this.f653) {
                                int i20 = i5 + 1;
                                bArr3[i5] = BaseNCodec.PAD_DEFAULT;
                                i5 = i20 + 1;
                                bArr3[i20] = BaseNCodec.PAD_DEFAULT;
                            }
                            if (this.f654) {
                                if (this.f655) {
                                    bArr3[i5] = StrictLineReader.CR;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                            if (f649 && this.f651 != 0) {
                                throw new AssertionError();
                            }
                            if (!f649 && i3 != i11) {
                                throw new AssertionError();
                            }
                        } else if (i17 == i11 - 2) {
                            if (i16 > 1) {
                                b = this.f650[0];
                                i13 = 1;
                            } else {
                                byte b5 = bArr[i3];
                                i3++;
                                b = b5;
                            }
                            int i21 = (b & 255) << 10;
                            if (this.f651 > 0) {
                                i7 = i13 + 1;
                                b2 = this.f650[i13];
                            } else {
                                i7 = i13;
                                b2 = bArr[i3];
                                i3++;
                            }
                            int i22 = i21 | ((b2 & 255) << 2);
                            this.f651 -= i7;
                            int i23 = i5 + 1;
                            bArr3[i5] = bArr2[(i22 >> 12) & 63];
                            int i24 = i23 + 1;
                            bArr3[i23] = bArr2[(i22 >> 6) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[i22 & 63];
                            if (this.f653) {
                                bArr3[i25] = BaseNCodec.PAD_DEFAULT;
                                i25++;
                            }
                            if (this.f654) {
                                if (this.f655) {
                                    bArr3[i25] = StrictLineReader.CR;
                                    i25++;
                                }
                                i6 = i25 + 1;
                                bArr3[i25] = 10;
                                i5 = i6;
                                if (f649) {
                                }
                                if (!f649) {
                                    throw new AssertionError();
                                }
                            } else {
                                i5 = i25;
                                if (f649) {
                                }
                                if (!f649) {
                                }
                            }
                        } else {
                            if (this.f654 && i5 > 0 && i10 != 19) {
                                if (this.f655) {
                                    bArr3[i5] = StrictLineReader.CR;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                            if (f649) {
                            }
                            if (!f649) {
                            }
                        }
                    } else if (i3 == i11 - 1) {
                        byte[] bArr5 = this.f650;
                        int i26 = this.f651;
                        this.f651 = i26 + 1;
                        bArr5[i26] = bArr[i3];
                    } else if (i3 == i11 - 2) {
                        byte[] bArr6 = this.f650;
                        int i27 = this.f651;
                        int i28 = i27 + 1;
                        this.f651 = i28;
                        bArr6[i27] = bArr[i3];
                        this.f651 = i28 + 1;
                        bArr6[i28] = bArr[i3 + 1];
                    }
                    this.f638 = i5;
                    this.f652 = i10;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(342725815, "Lcom/kuaishou/weapon/p0/ⁱⁱ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(342725815, "Lcom/kuaishou/weapon/p0/ⁱⁱ;");
                return;
            }
        }
        f636 = !C0446.class.desiredAssertionStatus();
    }

    public C0446() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m971(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            try {
                return new String(m977(bArr, 0), str);
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte[] m972(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) ? m974(str.getBytes(), i) : (byte[]) invokeLI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte[] m973(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? m975(bArr, 0, bArr.length, 0) : (byte[]) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte[] m974(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) ? m975(bArr, 0, bArr.length, i) : (byte[]) invokeLI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte[] m975(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i, i2, i3)) == null) {
            C0448 c0448 = new C0448(i3, new byte[(i2 * 3) / 4]);
            if (c0448.mo982(bArr, i, i2, true)) {
                int i4 = c0448.f638;
                byte[] bArr2 = c0448.f637;
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m976(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) ? new String(m974(str.getBytes(), i)) : (String) invokeLI.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static byte[] m977(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i)) == null) ? m978(bArr, 0, bArr.length, i) : (byte[]) invokeLI.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static byte[] m978(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65545, null, bArr, i, i2, i3)) == null) {
            C0449 c0449 = new C0449(i3, null);
            int i4 = (i2 / 3) * 4;
            if (!c0449.f653) {
                int i5 = i2 % 3;
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            } else if (i2 % 3 > 0) {
                i4 += 4;
            }
            if (c0449.f654 && i2 > 0) {
                i4 += (((i2 - 1) / 57) + 1) * (c0449.f655 ? 2 : 1);
            }
            c0449.f637 = new byte[i4];
            c0449.mo982(bArr, i, i2, true);
            if (f636 || c0449.f638 == i4) {
                return c0449.f637;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeLIII.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m979(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, bArr, i)) == null) {
            try {
                return new String(m977(bArr, i), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLI.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m980(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65547, null, bArr, i, i2, i3)) == null) {
            try {
                return new String(m978(bArr, i, i2, i3), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLIII.objValue;
    }
}
