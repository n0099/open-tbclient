package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f73551a;

    /* renamed from: b  reason: collision with root package name */
    public int f73552b;

    /* renamed from: c  reason: collision with root package name */
    public int f73553c;

    /* renamed from: d  reason: collision with root package name */
    public int f73554d;

    /* renamed from: e  reason: collision with root package name */
    public int f73555e;

    /* renamed from: f  reason: collision with root package name */
    public int f73556f;

    /* renamed from: g  reason: collision with root package name */
    public int f73557g;

    /* renamed from: h  reason: collision with root package name */
    public int f73558h;

    /* renamed from: i  reason: collision with root package name */
    public int f73559i;

    /* renamed from: j  reason: collision with root package name */
    public int f73560j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;

    public e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.f73551a = kVar;
        this.f73559i = 0;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = false;
        this.f73558h = 0;
        a(1);
        c(0);
    }

    public static byte[] b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return new byte[]{8, 8, 0, 0};
                case 2:
                    return new byte[]{8, 8, 4, 0};
                case 3:
                    return new byte[]{4, 8, 0, 4};
                case 4:
                    return new byte[]{4, 4, 2, 0};
                case 5:
                    return new byte[]{2, 4, 0, 2};
                case 6:
                    return new byte[]{2, 2, 1, 0};
                case 7:
                    return new byte[]{1, 2, 0, 1};
                default:
                    throw new PngjException("bad interlace pass" + i2);
            }
        }
        return (byte[]) invokeI.objValue;
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.l = i2;
            int i3 = (i2 * this.f73552b) + this.f73554d;
            this.m = i3;
            if (i3 < 0 || i3 >= this.f73551a.f73567b) {
                throw new PngjException("bad row - this should not happen");
            }
        }
    }

    public void a(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f73559i == i2) {
            return;
        }
        this.f73559i = i2;
        byte[] b2 = b(i2);
        this.f73553c = b2[0];
        byte b3 = b2[1];
        this.f73552b = b3;
        this.f73555e = b2[2];
        byte b4 = b2[3];
        this.f73554d = b4;
        int i4 = this.f73551a.f73567b;
        this.f73560j = i4 > b4 ? (((i4 + b3) - 1) - b4) / b3 : 0;
        int i5 = this.f73551a.f73566a;
        int i6 = this.f73555e;
        if (i5 > i6) {
            int i7 = this.f73553c;
            i3 = (((i5 + i7) - 1) - i6) / i7;
        } else {
            i3 = 0;
        }
        this.k = i3;
        if (i3 == 0) {
            this.f73560j = 0;
        }
        int i8 = this.f73553c;
        int i9 = this.f73551a.f73569d;
        this.f73557g = i8 * i9;
        this.f73556f = this.f73555e * i9;
    }

    public boolean a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.n++;
            int i3 = this.f73560j;
            if (i3 == 0 || (i2 = this.l) >= i3 - 1) {
                int i4 = this.f73559i;
                if (i4 == 7) {
                    this.o = true;
                    return false;
                }
                a(i4 + 1);
                if (this.f73560j == 0) {
                    this.n--;
                    return a();
                }
                c(0);
            } else {
                c(i2 + 1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f73559i : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f73560j : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((this.f73551a.f73574i * g()) + 7) / 8 : invokeV.intValue;
    }
}
