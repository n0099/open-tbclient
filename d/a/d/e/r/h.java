package d.a.d.e.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static h f42049h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42050a;

    /* renamed from: b  reason: collision with root package name */
    public List<BasicNameValuePair> f42051b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f42052c;

    /* renamed from: d  reason: collision with root package name */
    public String f42053d;

    /* renamed from: e  reason: collision with root package name */
    public i f42054e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f42055f;

    /* renamed from: g  reason: collision with root package name */
    public g f42056g;

    /* loaded from: classes7.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f42057a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42057a = hVar;
        }

        @Override // d.a.d.e.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).a(str);
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f42057a.f42054e = null;
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).b(i2, str);
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).c(cVar);
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).d(bArr);
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).e();
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).f(kVar);
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void g(int i2, c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, cVar) == null) || cVar == null) {
                return;
            }
            cVar.a(i2);
        }

        @Override // d.a.d.e.r.g
        public void h(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null) {
                return;
            }
            cVar.c();
        }

        @Override // d.a.d.e.r.g
        public void i(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null) {
                return;
            }
            cVar.b();
        }

        @Override // d.a.d.e.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.f42057a.f42055f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).onOpen(map);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-401975862, "Ld/a/d/e/r/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-401975862, "Ld/a/d/e/r/h;");
        }
    }

    public h() {
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
        this.f42050a = null;
        this.f42051b = null;
        this.f42053d = null;
        this.f42054e = null;
        this.f42055f = new ArrayList<>();
        this.f42056g = null;
        this.f42056g = new a(this);
    }

    public static h j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f42049h == null) {
                synchronized (h.class) {
                    if (f42049h == null) {
                        f42049h = new h();
                    }
                }
            }
            return f42049h;
        }
        return (h) invokeV.objValue;
    }

    public boolean c(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                synchronized (h.class) {
                    if (this.f42055f.contains(gVar)) {
                        return false;
                    }
                    return this.f42055f.add(gVar);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iVar = this.f42054e) == null) {
            return;
        }
        iVar.o();
    }

    public void e() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.f42054e) == null) {
            return;
        }
        iVar.p();
    }

    public void f(int i2, String str) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (iVar = this.f42054e) == null) {
            return;
        }
        this.f42054e = null;
        iVar.q(i2, str);
        if (this.f42054e != null) {
            BdLog.e("close is opened and thread is leaded!!!");
            this.f42054e = null;
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.v();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (t()) {
                d.a.d.e.p.l.d();
            }
            i iVar = this.f42054e;
            return (iVar == null || !iVar.E() || this.f42054e.F()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (t()) {
                d.a.d.e.p.l.d();
            }
            i iVar = this.f42054e;
            return iVar != null && iVar.E();
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            i iVar = this.f42054e;
            if (iVar != null) {
                return iVar.y();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f42050a : (String) invokeV.objValue;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, strArr, list) == null) {
            this.f42050a = str;
            this.f42053d = str2;
            this.f42052c = strArr;
            this.f42051b = list;
            t();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (t()) {
                d.a.d.e.p.l.d();
            }
            i iVar = this.f42054e;
            return iVar != null && iVar.C();
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? BdBaseApplication.getInst().isDebugMode() : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (t()) {
                d.a.d.e.p.l.d();
            }
            i iVar = this.f42054e;
            if (iVar != null) {
                if (!iVar.C() && !this.f42054e.E()) {
                    this.f42054e.q(1, null);
                    this.f42054e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.f42054e = new i();
            try {
                d0 d0Var = new d0();
                d0Var.j(this.f42053d);
                this.f42054e.r(this.f42050a, this.f42052c, this.f42056g, d0Var, this.f42051b);
                return true;
            } catch (WebSocketException unused) {
                this.f42054e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean v(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cVar)) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return false;
                }
                d.a.d.e.p.l.d();
                if (this.f42054e != null) {
                    return this.f42054e.I(cVar);
                }
                if (cVar != null) {
                    cVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
