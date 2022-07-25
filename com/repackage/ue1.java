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
public class ue1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ue1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, qe1> a;
    public final ArrayList<ge1.a> b;
    public com.baidu.sso.h.h c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements ge1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ge1.a e;

        public a(ue1 ue1Var, qe1 qe1Var, Context context, int i, long j, ge1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue1Var, qe1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qe1Var;
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
                    me1.c().d(false);
                } catch (Throwable unused) {
                    ge1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    me1.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ge1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ge1.a e;

        public b(ue1 ue1Var, qe1 qe1Var, Context context, int i, long j, ge1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue1Var, qe1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qe1Var;
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
                    me1.c().n(false);
                } catch (Throwable unused) {
                    ge1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    me1.c().n(false);
                }
            }
        }
    }

    public ue1() {
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

    public static ue1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (ue1.class) {
                    if (g == null) {
                        g = new ue1();
                    }
                }
            }
            return g;
        }
        return (ue1) invokeV.objValue;
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

    public synchronized void c(int i, int i2, int i3, int i4, String str, te1 te1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, te1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (te1Var == null) {
                    return;
                }
                Pair<Boolean, ge1.a> b2 = me1.c().b(i);
                if (((Boolean) b2.first).booleanValue()) {
                    we1.a().b(i);
                    h((ge1.a) b2.second, new pe1(i2, i3, i4, str), te1Var.a, z);
                    if (i2 == 1) {
                        te1Var.b = 1;
                    }
                    if (z) {
                        int i5 = te1Var.a;
                        if (i5 == 1) {
                            jf1.b(this.d, i4, te1Var.b, i3, str);
                        } else if (i5 == 3) {
                            jf1.f(this.d, i4, te1Var.b, i3, str);
                        } else if (i5 == 2) {
                            if (i2 == 3 && i3 == 2019) {
                                he1.f(this.d).z(System.currentTimeMillis());
                                he1.f(this.d).i(i3);
                            }
                            jf1.a(this.d, i4, i2, i3, te1Var.c, te1Var.d);
                        } else {
                            if (i2 == 3 && i3 == 2019) {
                                he1.f(this.d).L(System.currentTimeMillis());
                                he1.f(this.d).q(i3);
                            }
                            jf1.e(this.d, i4, i2, i3, te1Var.c, te1Var.d);
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
                    if (!ff1.f(context)) {
                        cg1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!je1.a(this.d).d() && tf1.j(this.d) == 0) {
                        z = true;
                    }
                    g(this.d, z);
                    tf1.l(this.d);
                    this.a.put(1, new ne1(this.d));
                    this.a.put(3, new xe1(this.d));
                    this.a.put(2, new ze1(this.d));
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
                if (me1.c().g()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = me1.c().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    we1.a().c(message, j);
                    Pair<Integer, Integer> c = pair == null ? bg1.c(context) : pair;
                    intValue = ((Integer) c.first).intValue();
                    intValue2 = ((Integer) c.second).intValue();
                    intValue3 = ((Integer) c.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    te1 te1Var = new te1();
                    te1Var.a = 1;
                    c(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", te1Var, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i);
                    this.f = b2;
                    me1.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        te1 te1Var2 = new te1();
                        te1Var2.a = 1;
                        c(a2, 3, 2004, b2, "has no op.", te1Var2, true);
                        return;
                    }
                    qe1 qe1Var = this.a.get(Integer.valueOf(b2));
                    if (qe1Var == null) {
                        te1 te1Var3 = new te1();
                        te1Var3.a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", te1Var3, true);
                    } else {
                        qe1Var.m(intValue3);
                        qe1Var.i(context, intValue, a2);
                        jf1.d(context, intValue3, 1, qe1.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j, ge1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = me1.c().a(aVar);
            Pair<Integer, Integer> c = bg1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    te1 te1Var = new te1();
                    te1Var.a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", te1Var, true);
                    return;
                }
                qe1 qe1Var = this.a.get(Integer.valueOf(intValue2));
                if (qe1Var == null) {
                    te1 te1Var2 = new te1();
                    te1Var2.a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", te1Var2, true);
                } else if (!me1.c().e(false, true)) {
                    te1 te1Var3 = new te1();
                    te1Var3.a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", te1Var3, false);
                } else {
                    jf1.d(context, intValue2, 2, qe1.q);
                    if (!qe1Var.l()) {
                        qe1Var.j(context, a2, j);
                    } else if (me1.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (me1.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!qe1Var.l()) {
                                        qe1Var.j(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    tf1.d(th);
                                    te1 te1Var4 = new te1();
                                    te1Var4.a = 2;
                                    c(a2, 3, 2019, intValue2, "auth out time", te1Var4, true);
                                    return;
                                }
                            } else {
                                te1 te1Var5 = new te1();
                                te1Var5.a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", te1Var5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, c, j, new a(this, qe1Var, context, a2, j, aVar));
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
                    tf1.d(th);
                }
            }
        }
    }

    public final synchronized void h(ge1.a aVar, pe1 pe1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, pe1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (i == 1) {
                    this.b.clear();
                    se1.b(aVar, pe1Var, i, (ArrayList) this.b.clone(), z);
                } else {
                    se1.b(aVar, pe1Var, i, null, z);
                }
            }
        }
    }

    public final boolean i(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            te1 te1Var = new te1();
            te1Var.a = i4;
            if (!this.e) {
                c(i, 3, 2001, i2, "has no init.", te1Var, false);
                return false;
            } else if (TextUtils.isEmpty(ge1.b) && TextUtils.isEmpty(ge1.c)) {
                c(i, 3, 2007, i2, "has no key.", te1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                c(i, 3, 2002, i2, "has no sdk.", te1Var, false);
                return false;
            } else if (i3 == 0) {
                c(i, 3, 2003, i2, "has no net.", te1Var, false);
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
            int a2 = me1.c().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                we1.a().c(message, j);
                if (pair == null) {
                    pair = bg1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i);
                    this.f = b2;
                    if (!me1.c().m(false, true)) {
                        te1 te1Var = new te1();
                        te1Var.a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", te1Var, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        te1 te1Var2 = new te1();
                        te1Var2.a = 3;
                        c(a2, 3, 2004, b2, "has no op.", te1Var2, true);
                    } else {
                        qe1 qe1Var = this.a.get(Integer.valueOf(b2));
                        if (qe1Var == null) {
                            te1 te1Var3 = new te1();
                            te1Var3.a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", te1Var3, true);
                            return;
                        }
                        qe1Var.m(intValue3);
                        qe1Var.h(context, a2);
                        jf1.d(context, intValue3, 3, qe1.r);
                    }
                }
            } catch (Throwable unused) {
                te1 te1Var4 = new te1();
                te1Var4.a = 3;
                c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", te1Var4, true);
            }
        }
    }

    public void l(Context context, long j, ge1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = me1.c().a(aVar);
            Pair<Integer, Integer> c = bg1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    te1 te1Var = new te1();
                    te1Var.a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", te1Var, true);
                    return;
                }
                qe1 qe1Var = this.a.get(Integer.valueOf(intValue2));
                if (qe1Var == null) {
                    te1 te1Var2 = new te1();
                    te1Var2.a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", te1Var2, true);
                } else if (!me1.c().o(false, true)) {
                    te1 te1Var3 = new te1();
                    te1Var3.a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", te1Var3, false);
                } else {
                    jf1.d(context, intValue2, 4, qe1.r);
                    if (!qe1Var.q()) {
                        qe1Var.p(context, a2, j);
                    } else if (me1.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (me1.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!qe1Var.q()) {
                                        qe1Var.p(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    tf1.d(th);
                                    te1 te1Var4 = new te1();
                                    te1Var4.a = 4;
                                    c(a2, 3, 2019, intValue2, "auth out time", te1Var4, true);
                                    return;
                                }
                            } else {
                                te1 te1Var5 = new te1();
                                te1Var5.a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", te1Var5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, c, j, new b(this, qe1Var, context, a2, j, aVar));
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
                tf1.d(th);
            }
        }
    }
}
