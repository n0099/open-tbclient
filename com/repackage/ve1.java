package com.repackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ie1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ve1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ve1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, re1> a;
    public final ArrayList<ie1.a> b;
    public com.baidu.sso.h.h c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements ie1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ie1.a e;

        public a(ve1 ve1Var, re1 re1Var, Context context, int i, long j, ie1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve1Var, re1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = re1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.repackage.ie1.a
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
                    ne1.c().d(false);
                } catch (Throwable unused) {
                    ie1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    ne1.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ie1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ie1.a e;

        public b(ve1 ve1Var, re1 re1Var, Context context, int i, long j, ie1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve1Var, re1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = re1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.repackage.ie1.a
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
                    ne1.c().n(false);
                } catch (Throwable unused) {
                    ie1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    ne1.c().n(false);
                }
            }
        }
    }

    public ve1() {
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

    public static ve1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (ve1.class) {
                    if (g == null) {
                        g = new ve1();
                    }
                }
            }
            return g;
        }
        return (ve1) invokeV.objValue;
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

    public synchronized void c(int i, int i2, int i3, int i4, String str, ue1 ue1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, ue1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (ue1Var == null) {
                    return;
                }
                Pair<Boolean, ie1.a> b2 = ne1.c().b(i);
                if (((Boolean) b2.first).booleanValue()) {
                    xe1.a().b(i);
                    h((ie1.a) b2.second, new qe1(i2, i3, i4, str), ue1Var.a, z);
                    if (i2 == 1) {
                        ue1Var.b = 1;
                    }
                    if (z) {
                        int i5 = ue1Var.a;
                        if (i5 == 1) {
                            kf1.b(this.d, i4, ue1Var.b, i3, str);
                        } else if (i5 == 3) {
                            kf1.f(this.d, i4, ue1Var.b, i3, str);
                        } else if (i5 == 2) {
                            if (i2 == 3 && i3 == 2019) {
                                je1.f(this.d).z(System.currentTimeMillis());
                                je1.f(this.d).i(i3);
                            }
                            kf1.a(this.d, i4, i2, i3, ue1Var.c, ue1Var.d);
                        } else {
                            if (i2 == 3 && i3 == 2019) {
                                je1.f(this.d).L(System.currentTimeMillis());
                                je1.f(this.d).q(i3);
                            }
                            kf1.e(this.d, i4, i2, i3, ue1Var.c, ue1Var.d);
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
                    if (!gf1.f(context)) {
                        dg1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!le1.a(this.d).d() && uf1.j(this.d) == 0) {
                        z = true;
                    }
                    g(this.d, z);
                    uf1.l(this.d);
                    this.a.put(1, new oe1(this.d));
                    this.a.put(3, new ye1(this.d));
                    this.a.put(2, new af1(this.d));
                    this.e = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i, Pair<Integer, Integer> pair, long j, ie1.a aVar) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (ne1.c().g()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = ne1.c().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    xe1.a().c(message, j);
                    Pair<Integer, Integer> c = pair == null ? cg1.c(context) : pair;
                    intValue = ((Integer) c.first).intValue();
                    intValue2 = ((Integer) c.second).intValue();
                    intValue3 = ((Integer) c.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    ue1 ue1Var = new ue1();
                    ue1Var.a = 1;
                    c(i2, 3, 2009, -1, "auth login unknown error.", ue1Var, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i);
                    this.f = b2;
                    ne1.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        ue1 ue1Var2 = new ue1();
                        ue1Var2.a = 1;
                        c(a2, 3, 2004, b2, "has no op.", ue1Var2, true);
                        return;
                    }
                    re1 re1Var = this.a.get(Integer.valueOf(b2));
                    if (re1Var == null) {
                        ue1 ue1Var3 = new ue1();
                        ue1Var3.a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", ue1Var3, true);
                    } else {
                        re1Var.m(intValue3);
                        re1Var.i(context, intValue, a2);
                        kf1.d(context, intValue3, 1, re1.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j, ie1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = ne1.c().a(aVar);
            Pair<Integer, Integer> c = cg1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    ue1 ue1Var = new ue1();
                    ue1Var.a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", ue1Var, true);
                    return;
                }
                re1 re1Var = this.a.get(Integer.valueOf(intValue2));
                if (re1Var == null) {
                    ue1 ue1Var2 = new ue1();
                    ue1Var2.a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", ue1Var2, true);
                } else if (!ne1.c().e(false, true)) {
                    ue1 ue1Var3 = new ue1();
                    ue1Var3.a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", ue1Var3, false);
                } else {
                    kf1.d(context, intValue2, 2, re1.q);
                    if (!re1Var.l()) {
                        re1Var.j(context, a2, j);
                    } else if (ne1.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (ne1.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!re1Var.l()) {
                                        re1Var.j(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    uf1.d(th);
                                    ue1 ue1Var4 = new ue1();
                                    ue1Var4.a = 2;
                                    c(a2, 3, 2019, intValue2, "auth out time", ue1Var4, true);
                                    return;
                                }
                            } else {
                                ue1 ue1Var5 = new ue1();
                                ue1Var5.a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", ue1Var5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, c, j, new a(this, re1Var, context, a2, j, aVar));
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
                    uf1.d(th);
                }
            }
        }
    }

    public final void h(ie1.a aVar, qe1 qe1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, qe1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 1) {
                this.b.clear();
                te1.b(aVar, qe1Var, i, (ArrayList) this.b.clone(), z);
                return;
            }
            te1.b(aVar, qe1Var, i, null, z);
        }
    }

    public final boolean i(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            ue1 ue1Var = new ue1();
            ue1Var.a = i4;
            if (!this.e) {
                c(i, 3, 2001, i2, "has no init.", ue1Var, false);
                return false;
            } else if (TextUtils.isEmpty(ie1.b) && TextUtils.isEmpty(ie1.c)) {
                c(i, 3, 2007, i2, "has no key.", ue1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                c(i, 3, 2002, i2, "has no sdk.", ue1Var, false);
                return false;
            } else if (i3 == 0) {
                c(i, 3, 2003, i2, "has no net.", ue1Var, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, ie1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            int a2 = ne1.c().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                xe1.a().c(message, j);
                if (pair == null) {
                    pair = cg1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i);
                    this.f = b2;
                    if (!ne1.c().m(false, true)) {
                        ue1 ue1Var = new ue1();
                        ue1Var.a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", ue1Var, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        ue1 ue1Var2 = new ue1();
                        ue1Var2.a = 3;
                        c(a2, 3, 2004, b2, "has no op.", ue1Var2, true);
                    } else {
                        re1 re1Var = this.a.get(Integer.valueOf(b2));
                        if (re1Var == null) {
                            ue1 ue1Var3 = new ue1();
                            ue1Var3.a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", ue1Var3, true);
                            return;
                        }
                        re1Var.m(intValue3);
                        re1Var.h(context, a2);
                        kf1.d(context, intValue3, 3, re1.r);
                    }
                }
            } catch (Throwable unused) {
                ue1 ue1Var4 = new ue1();
                ue1Var4.a = 3;
                c(a2, 3, 2009, -1, "auth login unknown error.", ue1Var4, true);
            }
        }
    }

    public void l(Context context, long j, ie1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = ne1.c().a(aVar);
            Pair<Integer, Integer> c = cg1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    ue1 ue1Var = new ue1();
                    ue1Var.a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", ue1Var, true);
                    return;
                }
                re1 re1Var = this.a.get(Integer.valueOf(intValue2));
                if (re1Var == null) {
                    ue1 ue1Var2 = new ue1();
                    ue1Var2.a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", ue1Var2, true);
                } else if (!ne1.c().o(false, true)) {
                    ue1 ue1Var3 = new ue1();
                    ue1Var3.a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", ue1Var3, false);
                } else {
                    kf1.d(context, intValue2, 4, re1.r);
                    if (!re1Var.q()) {
                        re1Var.p(context, a2, j);
                    } else if (ne1.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (ne1.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!re1Var.q()) {
                                        re1Var.p(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    uf1.d(th);
                                    ue1 ue1Var4 = new ue1();
                                    ue1Var4.a = 4;
                                    c(a2, 3, 2019, intValue2, "auth out time", ue1Var4, true);
                                    return;
                                }
                            } else {
                                ue1 ue1Var5 = new ue1();
                                ue1Var5.a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", ue1Var5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, c, j, new b(this, re1Var, context, a2, j, aVar));
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
                uf1.d(th);
            }
        }
    }
}
