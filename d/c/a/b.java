package d.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f69504b = 922337203685477580L;

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f69505c;

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f69506d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f69507a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-96581878, "Ld/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-96581878, "Ld/c/a/b;");
                return;
            }
        }
        f69505c = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
        f69506d = new float[]{1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69507a : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x008d A[EDGE_INSN: B:119:0x008d->B:44:0x008d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float b(String str, int i2, int i3) {
        InterceptResult invokeLII;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        float f2;
        char charAt;
        int i9;
        boolean z3;
        boolean z4;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, i3)) == null) {
            this.f69507a = i2;
            if (i2 >= i3) {
                return Float.NaN;
            }
            char charAt3 = str.charAt(i2);
            if (charAt3 == '+') {
                z = false;
            } else if (charAt3 != '-') {
                z = false;
                int i10 = this.f69507a;
                long j = 0;
                i4 = 0;
                i5 = 0;
                int i11 = 0;
                z2 = false;
                int i12 = 0;
                while (true) {
                    i6 = this.f69507a;
                    if (i6 >= i3) {
                        break;
                    }
                    char charAt4 = str.charAt(i6);
                    if (charAt4 == '0') {
                        if (i4 == 0) {
                            i11++;
                        } else {
                            i5++;
                        }
                    } else if (charAt4 >= '1' && charAt4 <= '9') {
                        int i13 = i4 + i5;
                        while (i5 > 0) {
                            if (j > f69504b) {
                                return Float.NaN;
                            }
                            j *= 10;
                            i5--;
                        }
                        if (j > f69504b) {
                            return Float.NaN;
                        }
                        j = (j * 10) + (charAt4 - '0');
                        i4 = i13 + 1;
                        if (j < 0) {
                            return Float.NaN;
                        }
                    } else if (charAt4 != '.' || z2) {
                        break;
                    } else {
                        i12 = this.f69507a - i10;
                        z2 = true;
                    }
                    this.f69507a++;
                }
                if (z2 || this.f69507a != i12 + 1) {
                    if (i4 == 0) {
                        if (i11 == 0) {
                            return Float.NaN;
                        }
                        i4 = 1;
                    }
                    if (z2) {
                        i5 = (i12 - i11) - i4;
                    }
                    i7 = this.f69507a;
                    if (i7 < i3 && ((charAt = str.charAt(i7)) == 'E' || charAt == 'e')) {
                        i9 = this.f69507a + 1;
                        this.f69507a = i9;
                        if (i9 != i3) {
                            return Float.NaN;
                        }
                        char charAt5 = str.charAt(i9);
                        if (charAt5 == '+') {
                            z3 = false;
                        } else if (charAt5 != '-') {
                            switch (charAt5) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    z3 = false;
                                    z4 = false;
                                    break;
                                default:
                                    this.f69507a--;
                                    z3 = false;
                                    z4 = true;
                                    break;
                            }
                            if (!z4) {
                                int i14 = this.f69507a;
                                int i15 = 0;
                                while (true) {
                                    int i16 = this.f69507a;
                                    if (i16 < i3 && (charAt2 = str.charAt(i16)) >= '0' && charAt2 <= '9') {
                                        if (i15 > f69504b) {
                                            return Float.NaN;
                                        }
                                        i15 = (i15 * 10) + (charAt2 - '0');
                                        this.f69507a++;
                                    }
                                }
                                if (this.f69507a == i14) {
                                    return Float.NaN;
                                }
                                i5 = z3 ? i5 - i15 : i5 + i15;
                            }
                        } else {
                            z3 = true;
                        }
                        this.f69507a++;
                        z4 = false;
                        if (!z4) {
                        }
                    }
                    i8 = i4 + i5;
                    if (i8 <= 39 || i8 < -44) {
                        return Float.NaN;
                    }
                    long j2 = j;
                    float f3 = (float) j2;
                    if (j2 != 0) {
                        if (i5 > 0) {
                            f2 = f69505c[i5];
                        } else if (i5 < 0) {
                            if (i5 < -38) {
                                f3 = (float) (f3 * 1.0E-20d);
                                i5 += 20;
                            }
                            f2 = f69506d[-i5];
                        }
                        f3 *= f2;
                    }
                    return z ? -f3 : f3;
                }
                return Float.NaN;
            } else {
                z = true;
            }
            this.f69507a++;
            int i102 = this.f69507a;
            long j3 = 0;
            i4 = 0;
            i5 = 0;
            int i112 = 0;
            z2 = false;
            int i122 = 0;
            while (true) {
                i6 = this.f69507a;
                if (i6 >= i3) {
                }
                this.f69507a++;
            }
            if (z2) {
            }
            if (i4 == 0) {
            }
            if (z2) {
            }
            i7 = this.f69507a;
            if (i7 < i3) {
                i9 = this.f69507a + 1;
                this.f69507a = i9;
                if (i9 != i3) {
                }
            }
            i8 = i4 + i5;
            if (i8 <= 39) {
            }
            return Float.NaN;
        }
        return invokeLII.floatValue;
    }
}
