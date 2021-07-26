package d.a.p0.b0;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f52018g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.e.k.a<String, d.a.d.k.d.a> f52019a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d.e.k.a<String, d.a.d.k.d.a> f52020b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.d.e.k.a<String, Bitmap> f52021c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.e.k.a<String, d.a.d.k.d.a> f52022d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.e.k.b<d.a.p0.d1.i.a.a> f52023e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.d1.i.c.b f52024f;

    /* loaded from: classes7.dex */
    public class a extends d.a.d.e.k.a<String, d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.a.d.k.d.a aVar, d.a.d.k.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, aVar, aVar2}) == null) || aVar == null) {
                return;
            }
            aVar.x();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.d.e.k.a<String, d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.a.d.k.d.a aVar, d.a.d.k.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, aVar, aVar2}) == null) || aVar == null) {
                return;
            }
            BdLog.isDebugMode();
            aVar.x();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.a
        /* renamed from: p */
        public int m(String str, d.a.d.k.d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
                if (aVar != null) {
                    return aVar.B();
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* renamed from: d.a.p0.b0.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1178c extends d.a.d.e.k.a<String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1178c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bitmap, bitmap2}) == null) || bitmap == null) {
                return;
            }
            bitmap.recycle();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1576425585, "Ld/a/p0/b0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1576425585, "Ld/a/p0/b0/c;");
                return;
            }
        }
        f52018g = new c();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52019a = null;
        this.f52020b = null;
        this.f52021c = null;
        this.f52022d = null;
        this.f52019a = new a(this, 0);
        this.f52020b = new b(this, 0);
        this.f52021c = new C1178c(this, 0);
        this.f52022d = new d.a.d.e.k.a<>(Integer.MAX_VALUE);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f52018g : (c) invokeV.objValue;
    }

    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f52021c.h(str, bitmap);
    }

    public void b(String str, d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            c(str, aVar, false);
        }
    }

    public void c(String str, d.a.d.k.d.a aVar, boolean z) {
        d.a.d.e.k.a<String, d.a.d.k.d.a> aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, aVar, z) == null) || aVar == null || (aVar2 = this.f52019a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            e(str, aVar, false);
        }
    }

    public void e(String str, d.a.d.k.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, str, aVar, z) == null) || aVar == null || this.f52020b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f52020b.h(str, aVar);
    }

    public void f(String str, d.a.d.k.d.a aVar) {
        d.a.d.e.k.a<String, d.a.d.k.d.a> aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) || aVar == null || (aVar2 = this.f52022d) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f52019a.i(str);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f52020b.i(str);
        }
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f52020b.e(i2) : invokeI.booleanValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.f52021c.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public d.a.d.k.d.a l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.f52019a.f(str) : (d.a.d.k.d.a) invokeL.objValue;
    }

    public d.a.d.k.d.a m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this.f52020b.f(str) : (d.a.d.k.d.a) invokeL.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f52020b.g() : invokeV.intValue;
    }

    public d.a.d.k.d.a o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.f52022d.f(str);
        }
        return (d.a.d.k.d.a) invokeL.objValue;
    }

    public d.a.d.e.k.b<d.a.p0.d1.i.a.a> p(int i2) {
        InterceptResult invokeI;
        d.a.p0.d1.i.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (this.f52023e != null && (bVar = this.f52024f) != null) {
                if (bVar.g() == i2) {
                    return this.f52023e;
                }
                this.f52024f.j(i2);
                this.f52023e.c();
            }
            if (this.f52024f == null) {
                this.f52024f = new d.a.p0.d1.i.c.b(i2);
            }
            if (this.f52023e == null) {
                this.f52023e = new d.a.d.e.k.b<>(this.f52024f, 6, 0);
            }
            return this.f52023e;
        }
        return (d.a.d.e.k.b) invokeI.objValue;
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            t(i2);
            u(i3);
            s(60);
        }
    }

    public void r() {
        d.a.d.e.k.b<d.a.p0.d1.i.a.a> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bVar = this.f52023e) == null) {
            return;
        }
        bVar.g(0);
        this.f52023e.f(0);
        this.f52023e.c();
        this.f52023e = null;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f52021c.k(i2);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f52019a.k(i2);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "pic:" + this.f52020b.toString() + "  photo:" + this.f52019a.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f52020b.k(i2);
        }
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.f52020b.l() + "/" + this.f52020b.g() + "/" + this.f52020b.d() + "_" + this.f52019a.l() + "/" + this.f52019a.g() + "/" + this.f52019a.d();
        }
        return (String) invokeV.objValue;
    }
}
