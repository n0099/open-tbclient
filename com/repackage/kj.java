package com.repackage;

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
/* loaded from: classes6.dex */
public class kj {
    public static /* synthetic */ Interceptable $ic;
    public static kj h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public lj e;
    public ArrayList<jj> f;
    public jj g;

    /* loaded from: classes6.dex */
    public class a implements jj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kj a;

        public a(kj kjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kjVar;
        }

        @Override // com.repackage.jj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).a(str);
                }
            }
        }

        @Override // com.repackage.jj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.e = null;
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).b(i, str);
                }
            }
        }

        @Override // com.repackage.jj
        public void c(fj fjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).c(fjVar);
                }
            }
        }

        @Override // com.repackage.jj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).d(bArr);
                }
            }
        }

        @Override // com.repackage.jj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).e();
                }
            }
        }

        @Override // com.repackage.jj
        public void f(nj njVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, njVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).f(njVar);
                }
            }
        }

        @Override // com.repackage.jj
        public void g(int i, fj fjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, fjVar) == null) || fjVar == null) {
                return;
            }
            fjVar.a(i);
        }

        @Override // com.repackage.jj
        public void h(fj fjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, fjVar) == null) || fjVar == null) {
                return;
            }
            fjVar.c();
        }

        @Override // com.repackage.jj
        public void i(fj fjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fjVar) == null) || fjVar == null) {
                return;
            }
            fjVar.b();
        }

        @Override // com.repackage.jj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((jj) it.next()).onOpen(map);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964035450, "Lcom/repackage/kj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964035450, "Lcom/repackage/kj;");
        }
    }

    public kj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = new ArrayList<>();
        this.g = null;
        this.g = new a(this);
    }

    public static kj j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (kj.class) {
                    if (h == null) {
                        h = new kj();
                    }
                }
            }
            return h;
        }
        return (kj) invokeV.objValue;
    }

    public boolean c(jj jjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jjVar)) == null) {
            if (jjVar != null) {
                synchronized (kj.class) {
                    if (this.f.contains(jjVar)) {
                        return false;
                    }
                    return this.f.add(jjVar);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        lj ljVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ljVar = this.e) == null) {
            return;
        }
        ljVar.o();
    }

    public void e() {
        lj ljVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ljVar = this.e) == null) {
            return;
        }
        ljVar.p();
    }

    public void f(int i, String str) {
        lj ljVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (ljVar = this.e) == null) {
            return;
        }
        this.e = null;
        ljVar.q(i, str);
        if (this.e != null) {
            BdLog.e("close is opened and thread is leaded!!!");
            this.e = null;
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.v();
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
                li.c();
            }
            lj ljVar = this.e;
            return (ljVar == null || !ljVar.E() || this.e.F()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (t()) {
                li.c();
            }
            lj ljVar = this.e;
            return ljVar != null && ljVar.E();
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            lj ljVar = this.e;
            if (ljVar != null) {
                return ljVar.y();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, strArr, list) == null) {
            this.a = str;
            this.d = str2;
            this.c = strArr;
            this.b = list;
            t();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (t()) {
                li.c();
            }
            lj ljVar = this.e;
            return ljVar != null && ljVar.C();
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
                li.c();
            }
            lj ljVar = this.e;
            if (ljVar != null) {
                if (!ljVar.C() && !this.e.E()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.e = new lj();
            try {
                gk gkVar = new gk();
                gkVar.j(this.d);
                this.e.r(this.a, this.c, this.g, gkVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean v(fj fjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fjVar)) == null) {
            synchronized (this) {
                if (fjVar == null) {
                    return false;
                }
                li.c();
                if (this.e != null) {
                    return this.e.I(fjVar);
                }
                if (fjVar != null) {
                    fjVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void w(List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.b = list;
        }
    }
}
