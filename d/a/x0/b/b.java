package d.a.x0.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes9.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f70971a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70972b;

    /* renamed from: c  reason: collision with root package name */
    public final int f70973c;

    /* renamed from: d  reason: collision with root package name */
    public final int f70974d;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f70975a;

        /* renamed from: b  reason: collision with root package name */
        public long f70976b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f70977c;

        /* renamed from: d  reason: collision with root package name */
        public int f70978d;

        /* renamed from: e  reason: collision with root package name */
        public int f70979e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70980f;

        /* renamed from: g  reason: collision with root package name */
        public int f70981g;

        /* renamed from: h  reason: collision with root package name */
        public int f70982h;

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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f70977c), Integer.valueOf(this.f70981g), Boolean.valueOf(this.f70980f), Integer.valueOf(this.f70975a), Long.valueOf(this.f70976b), Integer.valueOf(this.f70982h), Integer.valueOf(this.f70978d), Integer.valueOf(this.f70979e)) : (String) invokeV.objValue;
        }
    }

    public b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70971a = i2;
        this.f70972b = i3;
        this.f70973c = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f70974d = i5;
    }

    public int a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar.f70977c != null) {
                return aVar.f70978d - aVar.f70979e;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            for (byte b2 : bArr) {
                if (61 == b2 || k(b2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract void c(byte[] bArr, int i2, int i3, a aVar);

    public byte[] d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? e(d.b(str)) : (byte[]) invokeL.objValue;
    }

    public byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a aVar = new a();
            c(bArr, 0, bArr.length, aVar);
            c(bArr, 0, -1, aVar);
            int i2 = aVar.f70978d;
            byte[] bArr2 = new byte[i2];
            l(bArr2, 0, i2, aVar);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public abstract void f(byte[] bArr, int i2, int i3, a aVar);

    public byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a aVar = new a();
            f(bArr, 0, bArr.length, aVar);
            f(bArr, 0, -1, aVar);
            int i2 = aVar.f70978d - aVar.f70979e;
            byte[] bArr2 = new byte[i2];
            l(bArr2, 0, i2, aVar);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] h(int i2, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, aVar)) == null) {
            byte[] bArr = aVar.f70977c;
            return (bArr == null || bArr.length < aVar.f70978d + i2) ? m(aVar) : bArr;
        }
        return (byte[]) invokeIL.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 8192;
        }
        return invokeV.intValue;
    }

    public long j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            int length = bArr.length;
            int i2 = this.f70971a;
            long j = (((length + i2) - 1) / i2) * this.f70972b;
            int i3 = this.f70973c;
            return i3 > 0 ? j + ((((i3 + j) - 1) / i3) * this.f70974d) : j;
        }
        return invokeL.longValue;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i2, int i3, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), aVar})) == null) {
            if (aVar.f70977c == null) {
                return aVar.f70980f ? -1 : 0;
            }
            int min = Math.min(a(aVar), i3);
            System.arraycopy(aVar.f70977c, aVar.f70979e, bArr, i2, min);
            int i4 = aVar.f70979e + min;
            aVar.f70979e = i4;
            if (i4 >= aVar.f70978d) {
                aVar.f70977c = null;
            }
            return min;
        }
        return invokeCommon.intValue;
    }

    public final byte[] m(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, aVar)) == null) {
            byte[] bArr = aVar.f70977c;
            if (bArr == null) {
                aVar.f70977c = new byte[i()];
                aVar.f70978d = 0;
                aVar.f70979e = 0;
            } else {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                aVar.f70977c = bArr2;
            }
            return aVar.f70977c;
        }
        return (byte[]) invokeL.objValue;
    }
}
