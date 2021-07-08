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
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f69444a;

    /* renamed from: b  reason: collision with root package name */
    public final l f69445b;

    /* renamed from: c  reason: collision with root package name */
    public int f69446c;

    /* renamed from: d  reason: collision with root package name */
    public int f69447d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69448e;

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
        this.f69444a = new e();
        this.f69445b = new l(new byte[65025], 0);
        this.f69446c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f69447d = 0;
            do {
                int i5 = this.f69447d;
                int i6 = i2 + i5;
                e eVar = this.f69444a;
                if (i6 >= eVar.f69453d) {
                    break;
                }
                int[] iArr = eVar.f69456g;
                this.f69447d = i5 + 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69444a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69445b : (l) invokeV.objValue;
    }

    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            d.f.b.a.i0.a.f(fVar != null);
            if (this.f69448e) {
                this.f69448e = false;
                this.f69445b.F();
            }
            while (!this.f69448e) {
                if (this.f69446c < 0) {
                    if (!this.f69444a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.f69444a;
                    int i3 = eVar.f69454e;
                    if ((eVar.f69451b & 1) == 1 && this.f69445b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f69447d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f69446c = i2;
                }
                int a2 = a(this.f69446c);
                int i4 = this.f69446c + this.f69447d;
                if (a2 > 0) {
                    if (this.f69445b.b() < this.f69445b.d() + a2) {
                        l lVar = this.f69445b;
                        lVar.f70489a = Arrays.copyOf(lVar.f70489a, lVar.d() + a2);
                    }
                    l lVar2 = this.f69445b;
                    fVar.readFully(lVar2.f70489a, lVar2.d(), a2);
                    l lVar3 = this.f69445b;
                    lVar3.I(lVar3.d() + a2);
                    this.f69448e = this.f69444a.f69456g[i4 + (-1)] != 255;
                }
                if (i4 == this.f69444a.f69453d) {
                    i4 = -1;
                }
                this.f69446c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f69444a.b();
            this.f69445b.F();
            this.f69446c = -1;
            this.f69448e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f69445b;
            byte[] bArr = lVar.f70489a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.f70489a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
