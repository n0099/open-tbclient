package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes3.dex */
public class j extends DeflatedChunksSet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f59370g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f59371h;

    /* renamed from: i  reason: collision with root package name */
    public final k f59372i;

    /* renamed from: j  reason: collision with root package name */
    public final e f59373j;

    /* renamed from: k  reason: collision with root package name */
    public final p f59374k;
    public int[] l;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1268876676, "Lcom/kwad/sdk/pngencrypt/j$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1268876676, "Lcom/kwad/sdk/pngencrypt/j$1;");
                    return;
                }
            }
            int[] iArr = new int[FilterType.values().length];
            a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), kVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (k) objArr2[2], (e) objArr2[3], (Inflater) objArr2[4], (byte[]) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.h() : kVar.f59384k) + 1, kVar.f59384k + 1, inflater, bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {str, Boolean.valueOf(z), kVar, eVar, inflater, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (Inflater) objArr2[4], (byte[]) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new int[5];
        this.f59372i = kVar;
        this.f59373j = eVar;
        this.f59374k = new p(kVar, eVar);
        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            int i3 = 1;
            int i4 = 1 - this.f59372i.f59383j;
            while (i3 <= i2) {
                this.f59370g[i3] = (byte) (this.a[i3] + (((i4 > 0 ? this.f59370g[i4] & 255 : 0) + (this.f59371h[i3] & 255)) / 2));
                i3++;
                i4++;
            }
        }
    }

    private void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            for (int i3 = 1; i3 <= i2; i3++) {
                this.f59370g[i3] = this.a[i3];
            }
        }
    }

    private void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            int i3 = 1;
            int i4 = 1 - this.f59372i.f59383j;
            while (i3 <= i2) {
                int i5 = 0;
                int i6 = i4 > 0 ? this.f59370g[i4] & 255 : 0;
                if (i4 > 0) {
                    i5 = this.f59371h[i4] & 255;
                }
                this.f59370g[i3] = (byte) (this.a[i3] + n.a(i6, this.f59371h[i3] & 255, i5));
                i3++;
                i4++;
            }
        }
    }

    private void f(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i2) == null) {
            int i4 = 1;
            while (true) {
                i3 = this.f59372i.f59383j;
                if (i4 > i3) {
                    break;
                }
                this.f59370g[i4] = this.a[i4];
                i4++;
            }
            int i5 = i3 + 1;
            int i6 = 1;
            while (i5 <= i2) {
                byte[] bArr = this.f59370g;
                bArr[i5] = (byte) (this.a[i5] + bArr[i6]);
                i5++;
                i6++;
            }
        }
    }

    private void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i2) == null) {
            for (int i3 = 1; i3 <= i2; i3++) {
                this.f59370g[i3] = (byte) (this.a[i3] + this.f59371h[i3]);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f59374k.a(h());
            i();
            p pVar = this.f59374k;
            pVar.a(this.f59370g, pVar.m + 1);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? j() : invokeV.intValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            byte[] bArr = this.f59370g;
            if (bArr == null || bArr.length < this.a.length) {
                byte[] bArr2 = this.a;
                this.f59370g = new byte[bArr2.length];
                this.f59371h = new byte[bArr2.length];
            }
            if (this.f59374k.f59403j == 0) {
                Arrays.fill(this.f59370g, (byte) 0);
            }
            byte[] bArr3 = this.f59370g;
            this.f59370g = this.f59371h;
            this.f59371h = bArr3;
            byte b2 = this.a[0];
            if (!FilterType.isValidStandard(b2)) {
                throw new PngjException("Filter type " + ((int) b2) + " invalid");
            }
            FilterType byVal = FilterType.getByVal(b2);
            int[] iArr = this.l;
            iArr[b2] = iArr[b2] + 1;
            this.f59370g[0] = this.a[0];
            int i3 = AnonymousClass1.a[byVal.ordinal()];
            if (i3 == 1) {
                d(i2);
            } else if (i3 == 2) {
                f(i2);
            } else if (i3 == 3) {
                g(i2);
            } else if (i3 == 4) {
                c(i2);
            } else if (i3 == 5) {
                e(i2);
            } else {
                throw new PngjException("Filter type " + ((int) b2) + " not implemented");
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            this.f59370g = null;
            this.f59371h = null;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b(this.f59374k.m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int j() {
        InterceptResult invokeV;
        int h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e eVar = this.f59373j;
            int i2 = 0;
            if (eVar != null) {
                if (eVar.a()) {
                    h2 = this.f59373j.h();
                    i2 = h2 + 1;
                }
                if (!this.f59242c) {
                }
                return i2;
            }
            int h3 = h();
            k kVar = this.f59372i;
            if (h3 < kVar.f59375b - 1) {
                h2 = kVar.f59384k;
                i2 = h2 + 1;
            }
            if (!this.f59242c) {
                a(i2);
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
