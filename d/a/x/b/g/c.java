package d.a.x.b.g;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.x.b.f.d;
/* loaded from: classes8.dex */
public class c implements Cloneable, Comparable<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f68999e;

    /* renamed from: f  reason: collision with root package name */
    public d f69000f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.x.b.f.c f69001g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.x.b.f.a f69002h;

    /* renamed from: i  reason: collision with root package name */
    public a f69003i;
    public boolean j;
    public d.a.x.b.e.c k;
    public b l;
    public int m;
    public boolean n;

    public c(EGLContext eGLContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68999e = eGLContext;
        this.m = i2;
        this.n = z;
        this.f69000f = new d();
        this.f69001g = new d.a.x.b.f.c();
        this.f69002h = new d.a.x.b.f.b();
        this.f69003i = new a();
        this.j = false;
        this.k = null;
        this.l = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public c clone() {
        c cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                cVar = (c) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                cVar = null;
            }
            if (cVar != null) {
                cVar.p(this.f69003i.clone());
                cVar.s(this.l.clone());
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) ? this.m < cVar.g() ? -1 : 1 : invokeL.intValue;
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69003i : (a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public d.a.x.b.f.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69002h : (d.a.x.b.f.a) invokeV.objValue;
    }

    public EGLContext i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f68999e : (EGLContext) invokeV.objValue;
    }

    public d.a.x.b.e.c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (d.a.x.b.e.c) invokeV.objValue;
    }

    public b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (b) invokeV.objValue;
    }

    public d.a.x.b.f.c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f69001g : (d.a.x.b.f.c) invokeV.objValue;
    }

    public d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f69000f : (d) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void p(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f69003i = aVar;
        }
    }

    public void q(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.f68999e = eGLContext;
        }
    }

    public void r(d.a.x.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.f69000f = dVar;
        }
    }
}
