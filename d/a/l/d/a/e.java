package d.a.l.d.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f43303a;

    /* renamed from: b  reason: collision with root package name */
    public int f43304b;

    /* renamed from: c  reason: collision with root package name */
    public int f43305c;

    /* renamed from: d  reason: collision with root package name */
    public int f43306d;

    /* renamed from: e  reason: collision with root package name */
    public int f43307e;

    /* renamed from: f  reason: collision with root package name */
    public i f43308f;

    /* renamed from: g  reason: collision with root package name */
    public f f43309g;

    /* renamed from: h  reason: collision with root package name */
    public int f43310h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43311i;

    public e(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43303a = null;
        this.f43304b = 0;
        this.f43305c = 0;
        this.f43306d = 0;
        this.f43307e = 0;
        this.f43308f = null;
        this.f43309g = null;
        this.f43310h = 1;
        this.f43311i = false;
        this.f43304b = i2;
        this.f43305c = i2;
        this.f43307e = i2;
        this.f43303a = new byte[i2 * 2];
        this.f43309g = new d(bVar);
        this.f43308f = new h(this.f43304b);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f43306d + i2;
            i iVar = this.f43308f;
            if (iVar == null || this.f43311i) {
                return i3;
            }
            int i4 = this.f43305c;
            int i5 = this.f43304b;
            if (i4 != i5) {
                int i6 = this.f43307e;
                return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
            }
            return i3 + iVar.a(i3);
        }
        return invokeI.intValue;
    }

    public final int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr == null || i4 == 0) {
                return 0;
            }
            int i5 = this.f43310h;
            if (i5 == 2 || i5 == 3 || i4 % this.f43305c == 0 || i5 == 6) {
                if (this.f43311i) {
                    this.f43309g.h(bArr, i2, i4, bArr2, i3);
                } else {
                    this.f43309g.f(bArr, i2, i4, bArr2, i3);
                }
                return i4;
            } else if (this.f43308f != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f43305c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.f43305c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public void c(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), bArr, bArr2, secureRandom}) == null) {
            boolean z = i2 == 2 || i2 == 4;
            this.f43311i = z;
            if (this.f43310h == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = c.f43298b;
                }
                bArr2 = new byte[this.f43304b];
                secureRandom.nextBytes(bArr2);
            }
            this.f43306d = 0;
            this.f43307e = this.f43304b;
            this.f43309g.a(this.f43311i, "", bArr, bArr2);
        }
    }

    public int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        InterceptResult invokeCommon;
        int a2;
        byte[] bArr3;
        int i5;
        i iVar;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)})) == null) {
            int i6 = this.f43306d + i3;
            int i7 = this.f43305c;
            int i8 = this.f43304b;
            if (i7 != i8) {
                int i9 = this.f43307e;
                a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
            } else {
                i iVar2 = this.f43308f;
                a2 = iVar2 != null ? iVar2.a(i6) : 0;
            }
            if (a2 > 0 && a2 != this.f43304b && this.f43308f != null && this.f43311i) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.f43304b + " when decrypting with padded cipher");
            }
            int i10 = (this.f43311i || this.f43308f == null) ? i6 : i6 + a2;
            if (bArr2 != null) {
                int length = bArr2.length - i4;
                if (((!this.f43311i || this.f43308f == null) && length < i10) || (this.f43311i && length < i10 - this.f43304b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
                }
                if (this.f43306d == 0 && (this.f43311i || this.f43308f == null)) {
                    bArr3 = bArr;
                    i5 = i2;
                } else {
                    byte[] bArr4 = new byte[i10];
                    int i11 = this.f43306d;
                    if (i11 != 0) {
                        System.arraycopy(this.f43303a, 0, bArr4, 0, i11);
                    }
                    if (i3 != 0) {
                        System.arraycopy(bArr, i2, bArr4, this.f43306d, i3);
                    }
                    if (!this.f43311i && (iVar = this.f43308f) != null) {
                        iVar.a(bArr4, i6, a2);
                    }
                    bArr3 = bArr4;
                    i5 = 0;
                }
                if (this.f43311i) {
                    if (length < i10) {
                        this.f43309g.e();
                    }
                    byte[] bArr5 = new byte[i6];
                    b2 = b(bArr3, i5, bArr5, 0, i6);
                    i iVar3 = this.f43308f;
                    if (iVar3 != null && (b2 = iVar3.b(bArr5, 0, b2)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i4 < b2) {
                        this.f43309g.g();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + b2 + " bytes needed");
                    }
                    for (int i12 = 0; i12 < b2; i12++) {
                        bArr2[i4 + i12] = bArr5[i12];
                    }
                } else {
                    b2 = b(bArr3, i5, bArr2, i4, i10);
                }
                this.f43306d = 0;
                this.f43307e = this.f43304b;
                if (this.f43310h != 0) {
                    this.f43309g.c();
                }
                return b2;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public byte[] e(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int a2;
        byte[] bArr2;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            byte[] bArr3 = null;
            try {
                a2 = a(i3);
                bArr2 = new byte[a2];
                d2 = d(bArr, i2, i3, bArr2, 0);
            } catch (ShortBufferException unused) {
            }
            if (d2 < a2) {
                bArr3 = new byte[d2];
                if (d2 != 0) {
                    System.arraycopy(bArr2, 0, bArr3, 0, d2);
                }
                return bArr3;
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }
}
