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
public class mj {
    public static /* synthetic */ Interceptable $ic;
    public static mj h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public nj e;
    public ArrayList<lj> f;
    public lj g;

    /* loaded from: classes6.dex */
    public class a implements lj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mj a;

        public a(mj mjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mjVar;
        }

        @Override // com.repackage.lj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).a(str);
                }
            }
        }

        @Override // com.repackage.lj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.e = null;
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).b(i, str);
                }
            }
        }

        @Override // com.repackage.lj
        public void c(hj hjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).c(hjVar);
                }
            }
        }

        @Override // com.repackage.lj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).d(bArr);
                }
            }
        }

        @Override // com.repackage.lj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).e();
                }
            }
        }

        @Override // com.repackage.lj
        public void f(pj pjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).f(pjVar);
                }
            }
        }

        @Override // com.repackage.lj
        public void g(int i, hj hjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, hjVar) == null) || hjVar == null) {
                return;
            }
            hjVar.a(i);
        }

        @Override // com.repackage.lj
        public void h(hj hjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, hjVar) == null) || hjVar == null) {
                return;
            }
            hjVar.c();
        }

        @Override // com.repackage.lj
        public void i(hj hjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hjVar) == null) || hjVar == null) {
                return;
            }
            hjVar.b();
        }

        @Override // com.repackage.lj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((lj) it.next()).onOpen(map);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964033528, "Lcom/repackage/mj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964033528, "Lcom/repackage/mj;");
        }
    }

    public mj() {
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

    public static mj j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (mj.class) {
                    if (h == null) {
                        h = new mj();
                    }
                }
            }
            return h;
        }
        return (mj) invokeV.objValue;
    }

    public boolean c(lj ljVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ljVar)) == null) {
            if (ljVar != null) {
                synchronized (mj.class) {
                    if (this.f.contains(ljVar)) {
                        return false;
                    }
                    return this.f.add(ljVar);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        nj njVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (njVar = this.e) == null) {
            return;
        }
        njVar.o();
    }

    public void e() {
        nj njVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (njVar = this.e) == null) {
            return;
        }
        njVar.p();
    }

    public void f(int i, String str) {
        nj njVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (njVar = this.e) == null) {
            return;
        }
        this.e = null;
        njVar.q(i, str);
        if (this.e != null) {
            BdLog.e("close is opened and thread is leaded!!!");
            this.e = null;
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.v();
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
                mi.c();
            }
            nj njVar = this.e;
            return (njVar == null || !njVar.E() || this.e.F()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (t()) {
                mi.c();
            }
            nj njVar = this.e;
            return njVar != null && njVar.E();
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            nj njVar = this.e;
            if (njVar != null) {
                return njVar.y();
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
                mi.c();
            }
            nj njVar = this.e;
            return njVar != null && njVar.C();
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
                mi.c();
            }
            nj njVar = this.e;
            if (njVar != null) {
                if (!njVar.C() && !this.e.E()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.e = new nj();
            try {
                ik ikVar = new ik();
                ikVar.j(this.d);
                this.e.r(this.a, this.c, this.g, ikVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean v(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, hjVar)) == null) {
            synchronized (this) {
                if (hjVar == null) {
                    return false;
                }
                mi.c();
                if (this.e != null) {
                    return this.e.I(hjVar);
                }
                if (hjVar != null) {
                    hjVar.a(1);
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
