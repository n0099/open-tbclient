package com.repackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ge1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class te1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile te1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, pe1> a;
    public final ArrayList<ge1.a> b;
    public com.baidu.sso.h.h c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements ge1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ge1.a e;

        public a(te1 te1Var, pe1 pe1Var, Context context, int i, long j, ge1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te1Var, pe1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.repackage.ge1.a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.j(this.b, this.c, this.d);
                        return;
                    }
                    if (this.e != null) {
                        this.e.onFinish(str);
                    }
                    le1.c().d(false);
                } catch (Throwable unused) {
                    ge1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    le1.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ge1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ge1.a e;

        public b(te1 te1Var, pe1 pe1Var, Context context, int i, long j, ge1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te1Var, pe1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.repackage.ge1.a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.p(this.b, this.c, this.d);
                        return;
                    }
                    if (this.e != null) {
                        this.e.onFinish(str);
                    }
                    le1.c().n(false);
                } catch (Throwable unused) {
                    ge1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    le1.c().n(false);
                }
            }
        }
    }

    public te1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new ArrayList<>();
        this.f = -1;
    }

    public static te1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (te1.class) {
                    if (g == null) {
                        g = new te1();
                    }
                }
            }
            return g;
        }
        return (te1) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : invokeV.intValue;
    }

    public final int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (this.a.size() == 1) {
                return Integer.valueOf(this.a.get(this.a.keySet().iterator().next()).c).intValue();
            }
            return (this.a.size() != 2 || i2 >= 4 || i2 <= 0) ? i : i2;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i, int i2, int i3, int i4, String str, se1 se1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, se1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (se1Var == null) {
                    return;
                }
                Pair<Boolean, ge1.a> b2 = le1.c().b(i);
                if (((Boolean) b2.first).booleanValue()) {
                    ve1.a().b(i);
                    h((ge1.a) b2.second, new oe1(i2, i3, i4, str), se1Var.a, z);
                    if (i2 == 1) {
                        se1Var.b = 1;
                    }
                    if (z) {
                        int i5 = se1Var.a;
                        if (i5 == 1) {
                            if1.b(this.d, i4, se1Var.b, i3, str);
                        } else if (i5 == 3) {
                            if1.f(this.d, i4, se1Var.b, i3, str);
                        } else if (i5 == 2) {
                            if (i2 == 3 && i3 == 2019) {
                                he1.f(this.d).z(System.currentTimeMillis());
                                he1.f(this.d).i(i3);
                            }
                            if1.a(this.d, i4, i2, i3, se1Var.c, se1Var.d);
                        } else {
                            if (i2 == 3 && i3 == 2019) {
                                he1.f(this.d).L(System.currentTimeMillis());
                                he1.f(this.d).q(i3);
                            }
                            if1.e(this.d, i4, i2, i3, se1Var.c, se1Var.d);
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                try {
                    if (this.e) {
                        return;
                    }
                    this.d = context.getApplicationContext();
                    if (!ef1.f(context)) {
                        bg1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!je1.a(this.d).d() && sf1.j(this.d) == 0) {
                        z = true;
                    }
                    g(this.d, z);
                    sf1.l(this.d);
                    this.a.put(1, new me1(this.d));
                    this.a.put(3, new we1(this.d));
                    this.a.put(2, new ye1(this.d));
                    this.e = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i, Pair<Integer, Integer> pair, long j, ge1.a aVar) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (le1.c().g()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = le1.c().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    ve1.a().c(message, j);
                    Pair<Integer, Integer> c = pair == null ? ag1.c(context) : pair;
                    intValue = ((Integer) c.first).intValue();
                    intValue2 = ((Integer) c.second).intValue();
                    intValue3 = ((Integer) c.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    se1 se1Var = new se1();
                    se1Var.a = 1;
                    c(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", se1Var, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i);
                    this.f = b2;
                    le1.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        se1 se1Var2 = new se1();
                        se1Var2.a = 1;
                        c(a2, 3, 2004, b2, "has no op.", se1Var2, true);
                        return;
                    }
                    pe1 pe1Var = this.a.get(Integer.valueOf(b2));
                    if (pe1Var == null) {
                        se1 se1Var3 = new se1();
                        se1Var3.a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", se1Var3, true);
                    } else {
                        pe1Var.m(intValue3);
                        pe1Var.i(context, intValue, a2);
                        if1.d(context, intValue3, 1, pe1.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j, ge1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = le1.c().a(aVar);
            Pair<Integer, Integer> c = ag1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    se1 se1Var = new se1();
                    se1Var.a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", se1Var, true);
                    return;
                }
                pe1 pe1Var = this.a.get(Integer.valueOf(intValue2));
                if (pe1Var == null) {
                    se1 se1Var2 = new se1();
                    se1Var2.a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", se1Var2, true);
                } else if (!le1.c().e(false, true)) {
                    se1 se1Var3 = new se1();
                    se1Var3.a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", se1Var3, false);
                } else {
                    if1.d(context, intValue2, 2, pe1.q);
                    if (!pe1Var.l()) {
                        pe1Var.j(context, a2, j);
                    } else if (le1.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (le1.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!pe1Var.l()) {
                                        pe1Var.j(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    sf1.d(th);
                                    se1 se1Var4 = new se1();
                                    se1Var4.a = 2;
                                    c(a2, 3, 2019, intValue2, "auth out time", se1Var4, true);
                                    return;
                                }
                            } else {
                                se1 se1Var5 = new se1();
                                se1Var5.a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", se1Var5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, c, j, new a(this, pe1Var, context, a2, j, aVar));
                    }
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            synchronized (this) {
                try {
                    m(context);
                    this.c = new com.baidu.sso.h.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.c, intentFilter);
                } catch (Throwable th) {
                    sf1.d(th);
                }
            }
        }
    }

    public final void h(ge1.a aVar, oe1 oe1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, oe1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 1) {
                this.b.clear();
                re1.b(aVar, oe1Var, i, (ArrayList) this.b.clone(), z);
                return;
            }
            re1.b(aVar, oe1Var, i, null, z);
        }
    }

    public final boolean i(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            se1 se1Var = new se1();
            se1Var.a = i4;
            if (!this.e) {
                c(i, 3, 2001, i2, "has no init.", se1Var, false);
                return false;
            } else if (TextUtils.isEmpty(ge1.b) && TextUtils.isEmpty(ge1.c)) {
                c(i, 3, 2007, i2, "has no key.", se1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                c(i, 3, 2002, i2, "has no sdk.", se1Var, false);
                return false;
            } else if (i3 == 0) {
                c(i, 3, 2003, i2, "has no net.", se1Var, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, ge1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            int a2 = le1.c().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                ve1.a().c(message, j);
                if (pair == null) {
                    pair = ag1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i);
                    this.f = b2;
                    if (!le1.c().m(false, true)) {
                        se1 se1Var = new se1();
                        se1Var.a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", se1Var, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        se1 se1Var2 = new se1();
                        se1Var2.a = 3;
                        c(a2, 3, 2004, b2, "has no op.", se1Var2, true);
                    } else {
                        pe1 pe1Var = this.a.get(Integer.valueOf(b2));
                        if (pe1Var == null) {
                            se1 se1Var3 = new se1();
                            se1Var3.a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", se1Var3, true);
                            return;
                        }
                        pe1Var.m(intValue3);
                        pe1Var.h(context, a2);
                        if1.d(context, intValue3, 3, pe1.r);
                    }
                }
            } catch (Throwable unused) {
                se1 se1Var4 = new se1();
                se1Var4.a = 3;
                c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", se1Var4, true);
            }
        }
    }

    public void l(Context context, long j, ge1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = le1.c().a(aVar);
            Pair<Integer, Integer> c = ag1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    se1 se1Var = new se1();
                    se1Var.a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", se1Var, true);
                    return;
                }
                pe1 pe1Var = this.a.get(Integer.valueOf(intValue2));
                if (pe1Var == null) {
                    se1 se1Var2 = new se1();
                    se1Var2.a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", se1Var2, true);
                } else if (!le1.c().o(false, true)) {
                    se1 se1Var3 = new se1();
                    se1Var3.a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", se1Var3, false);
                } else {
                    if1.d(context, intValue2, 4, pe1.r);
                    if (!pe1Var.q()) {
                        pe1Var.p(context, a2, j);
                    } else if (le1.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (le1.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!pe1Var.q()) {
                                        pe1Var.p(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    sf1.d(th);
                                    se1 se1Var4 = new se1();
                                    se1Var4.a = 4;
                                    c(a2, 3, 2019, intValue2, "auth out time", se1Var4, true);
                                    return;
                                }
                            } else {
                                se1 se1Var5 = new se1();
                                se1Var5.a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", se1Var5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, c, j, new b(this, pe1Var, context, a2, j, aVar));
                    }
                }
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.c != null) {
                    context.unregisterReceiver(this.c);
                }
                this.c = null;
            } catch (Throwable th) {
                sf1.d(th);
            }
        }
    }
}
