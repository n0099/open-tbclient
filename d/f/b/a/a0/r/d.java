package d.f.b.a.a0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f72341a;

    /* renamed from: b  reason: collision with root package name */
    public final l f72342b;

    /* renamed from: c  reason: collision with root package name */
    public int f72343c;

    /* renamed from: d  reason: collision with root package name */
    public int f72344d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72345e;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72341a = new e();
        this.f72342b = new l(new byte[65025], 0);
        this.f72343c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f72344d = 0;
            do {
                int i5 = this.f72344d;
                int i6 = i2 + i5;
                e eVar = this.f72341a;
                if (i6 >= eVar.f72350d) {
                    break;
                }
                int[] iArr = eVar.f72353g;
                this.f72344d = i5 + 1;
                i3 = iArr[i5 + i2];
                i4 += i3;
            } while (i3 == 255);
            return i4;
        }
        return invokeI.intValue;
    }

    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72341a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72342b : (l) invokeV.objValue;
    }

    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            d.f.b.a.i0.a.f(fVar != null);
            if (this.f72345e) {
                this.f72345e = false;
                this.f72342b.F();
            }
            while (!this.f72345e) {
                if (this.f72343c < 0) {
                    if (!this.f72341a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.f72341a;
                    int i3 = eVar.f72351e;
                    if ((eVar.f72348b & 1) == 1 && this.f72342b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f72344d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f72343c = i2;
                }
                int a2 = a(this.f72343c);
                int i4 = this.f72343c + this.f72344d;
                if (a2 > 0) {
                    if (this.f72342b.b() < this.f72342b.d() + a2) {
                        l lVar = this.f72342b;
                        lVar.f73386a = Arrays.copyOf(lVar.f73386a, lVar.d() + a2);
                    }
                    l lVar2 = this.f72342b;
                    fVar.readFully(lVar2.f73386a, lVar2.d(), a2);
                    l lVar3 = this.f72342b;
                    lVar3.I(lVar3.d() + a2);
                    this.f72345e = this.f72341a.f72353g[i4 + (-1)] != 255;
                }
                if (i4 == this.f72341a.f72350d) {
                    i4 = -1;
                }
                this.f72343c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f72341a.b();
            this.f72342b.F();
            this.f72343c = -1;
            this.f72345e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f72342b;
            byte[] bArr = lVar.f73386a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.f73386a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
