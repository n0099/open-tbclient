package d.a.o0.e;

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
import d.a.o0.a;
import d.a.o0.l.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f46271g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f46272a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46273b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f46274c;

    /* renamed from: d  reason: collision with root package name */
    public Context f46275d;

    /* renamed from: e  reason: collision with root package name */
    public int f46276e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.InterfaceC0668a> f46277f;

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC0668a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f46278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f46279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f46280c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f46281d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0668a f46282e;

        public a(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0668a interfaceC0668a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j), interfaceC0668a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46278a = iVar;
            this.f46279b = context;
            this.f46280c = i2;
            this.f46281d = j;
            this.f46282e = interfaceC0668a;
        }

        @Override // d.a.o0.a.InterfaceC0668a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.f46278a.i(this.f46279b, this.f46280c, this.f46281d);
                        return;
                    }
                    if (this.f46282e != null) {
                        this.f46282e.onFinish(str);
                    }
                    d.a.o0.c.a.c().d(false);
                } catch (Throwable unused) {
                    a.InterfaceC0668a interfaceC0668a = this.f46282e;
                    if (interfaceC0668a != null) {
                        interfaceC0668a.onFinish(str);
                    }
                    d.a.o0.c.a.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0668a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f46283a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f46284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f46285c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f46286d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0668a f46287e;

        public b(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0668a interfaceC0668a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j), interfaceC0668a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46283a = iVar;
            this.f46284b = context;
            this.f46285c = i2;
            this.f46286d = j;
            this.f46287e = interfaceC0668a;
        }

        @Override // d.a.o0.a.InterfaceC0668a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.f46283a.p(this.f46284b, this.f46285c, this.f46286d);
                        return;
                    }
                    if (this.f46287e != null) {
                        this.f46287e.onFinish(str);
                    }
                    d.a.o0.c.a.c().m(false);
                } catch (Throwable unused) {
                    a.InterfaceC0668a interfaceC0668a = this.f46287e;
                    if (interfaceC0668a != null) {
                        interfaceC0668a.onFinish(str);
                    }
                    d.a.o0.c.a.c().m(false);
                }
            }
        }
    }

    public c() {
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
        this.f46272a = new HashMap();
        this.f46276e = -1;
        this.f46277f = new ArrayList<>();
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f46271g == null) {
                synchronized (c.class) {
                    if (f46271g == null) {
                        f46271g = new c();
                    }
                }
            }
            return f46271g;
        }
        return (c) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46276e : invokeV.intValue;
    }

    public final int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (this.f46272a.size() == 1) {
                return Integer.valueOf(this.f46272a.get(this.f46272a.keySet().iterator().next()).f46348c).intValue();
            }
            return (this.f46272a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i2, int i3, int i4, int i5, String str, d.a.o0.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, bVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                Pair<Boolean, a.InterfaceC0668a> b2 = d.a.o0.c.a.c().b(i2);
                if (((Boolean) b2.first).booleanValue()) {
                    d.a().b(i2);
                    h((a.InterfaceC0668a) b2.second, new h(i3, i4, i5, str), bVar.f46267a, z);
                    if (i3 == 1) {
                        bVar.f46268b = 1;
                    }
                    if (z) {
                        int i6 = bVar.f46267a;
                        if (i6 == 1) {
                            d.a.o0.h.d.e(this.f46275d, i5, bVar.f46268b, i4, str);
                        } else if (i6 == 3) {
                            d.a.o0.h.d.b(this.f46275d, i5, bVar.f46268b, i4, str);
                        } else if (i6 == 2) {
                            if (i3 == 3 && i4 == 2019) {
                                d.a.o0.b.a.h(this.f46275d).A(System.currentTimeMillis());
                                d.a.o0.b.a.h(this.f46275d).k(i4);
                            }
                            d.a.o0.h.d.a(this.f46275d, i5, i3, i4, bVar.f46269c, bVar.f46270d);
                        } else {
                            if (i3 == 3 && i4 == 2019) {
                                d.a.o0.b.a.h(this.f46275d).K(System.currentTimeMillis());
                                d.a.o0.b.a.h(this.f46275d).q(i4);
                            }
                            d.a.o0.h.d.d(this.f46275d, i5, i3, i4, bVar.f46269c, bVar.f46270d);
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
                    if (this.f46273b) {
                        return;
                    }
                    this.f46275d = context.getApplicationContext();
                    d.a.o0.m.a.b().a(this.f46275d, null);
                    boolean z = false;
                    if (!d.a.o0.b.c.b(this.f46275d).f() && d.a.o0.l.c.k(this.f46275d) == 0) {
                        z = true;
                    }
                    g(this.f46275d, z);
                    d.a.o0.l.c.m(this.f46275d);
                    this.f46272a.put(1, new e(this.f46275d));
                    this.f46272a.put(3, new f(this.f46275d));
                    this.f46272a.put(2, new g(this.f46275d));
                    this.f46273b = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0668a interfaceC0668a) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j), interfaceC0668a}) == null) {
            synchronized (this) {
                int i3 = -1;
                if (d.a.o0.c.a.c().g()) {
                    this.f46277f.add(interfaceC0668a);
                    return;
                }
                this.f46277f.clear();
                int a2 = d.a.o0.c.a.c().a(interfaceC0668a);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f46276e = -1;
                    d.a().c(message, j);
                    Pair<Integer, Integer> d2 = pair == null ? k.d(context) : pair;
                    intValue = ((Integer) d2.first).intValue();
                    intValue2 = ((Integer) d2.second).intValue();
                    intValue3 = ((Integer) d2.second).intValue();
                } catch (Throwable unused) {
                    i3 = a2;
                    d.a.o0.e.b bVar = new d.a.o0.e.b();
                    bVar.f46267a = 1;
                    c(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i2);
                    this.f46276e = b2;
                    d.a.o0.c.a.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        d.a.o0.e.b bVar2 = new d.a.o0.e.b();
                        bVar2.f46267a = 1;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                        return;
                    }
                    d.a.o0.b.c.b(this.f46275d).d();
                    i iVar = this.f46272a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.a.o0.e.b bVar3 = new d.a.o0.e.b();
                        bVar3.f46267a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                    } else {
                        iVar.l(intValue3);
                        iVar.h(context, a2);
                        d.a.o0.h.d.c(context, intValue3, 1, i.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j, a.InterfaceC0668a interfaceC0668a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), interfaceC0668a}) == null) {
            int a2 = d.a.o0.c.a.c().a(interfaceC0668a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    d.a.o0.e.b bVar = new d.a.o0.e.b();
                    bVar.f46267a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.f46272a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    d.a.o0.e.b bVar2 = new d.a.o0.e.b();
                    bVar2.f46267a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!d.a.o0.c.a.c().e(false, true)) {
                    d.a.o0.e.b bVar3 = new d.a.o0.e.b();
                    bVar3.f46267a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
                } else {
                    d.a.o0.h.d.c(context, intValue2, 2, i.q);
                    if (!iVar.k()) {
                        iVar.i(context, a2, j);
                    } else if (d.a.o0.c.a.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (d.a.o0.c.a.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.k()) {
                                        iVar.i(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    d.a.o0.l.c.d(th);
                                    d.a.o0.e.b bVar4 = new d.a.o0.e.b();
                                    bVar4.f46267a = 2;
                                    c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                d.a.o0.e.b bVar5 = new d.a.o0.e.b();
                                bVar5.f46267a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, d2, j, new a(this, iVar, context, a2, j, interfaceC0668a));
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
                    this.f46274c = new com.baidu.sso.g.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.f46274c, intentFilter);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    public final void h(a.InterfaceC0668a interfaceC0668a, h hVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{interfaceC0668a, hVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                this.f46277f.clear();
                d.a.o0.e.a.b(interfaceC0668a, hVar, i2, (ArrayList) this.f46277f.clone(), z);
                return;
            }
            d.a.o0.e.a.b(interfaceC0668a, hVar, i2, null, z);
        }
    }

    public final boolean i(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5)) == null) {
            d.a.o0.e.b bVar = new d.a.o0.e.b();
            bVar.f46267a = i5;
            if (!this.f46273b) {
                c(i2, 3, 2001, i3, "has no init.", bVar, false);
                return false;
            } else if (TextUtils.isEmpty(d.a.o0.a.f46218b) && TextUtils.isEmpty(d.a.o0.a.f46219c)) {
                c(i2, 3, 2007, i3, "has no key.", bVar, false);
                return false;
            } else if (this.f46272a.isEmpty()) {
                c(i2, 3, 2002, i3, "has no sdk.", bVar, false);
                return false;
            } else if (i4 == 0) {
                c(i2, 3, 2003, i3, "has no net.", bVar, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public void k(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0668a interfaceC0668a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j), interfaceC0668a}) == null) {
            int a2 = d.a.o0.c.a.c().a(interfaceC0668a);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f46276e = -1;
                d.a().c(message, j);
                if (pair == null) {
                    pair = k.d(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i2);
                    this.f46276e = b2;
                    if (!d.a.o0.c.a.c().l(false, true)) {
                        d.a.o0.e.b bVar = new d.a.o0.e.b();
                        bVar.f46267a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        d.a.o0.e.b bVar2 = new d.a.o0.e.b();
                        bVar2.f46267a = 3;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                    } else {
                        d.a.o0.b.c.b(this.f46275d).d();
                        i iVar = this.f46272a.get(Integer.valueOf(b2));
                        if (iVar == null) {
                            d.a.o0.e.b bVar3 = new d.a.o0.e.b();
                            bVar3.f46267a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                            return;
                        }
                        iVar.l(intValue3);
                        iVar.o(context, a2);
                        d.a.o0.h.d.c(context, intValue3, 3, i.r);
                    }
                }
            } catch (Throwable unused) {
                d.a.o0.e.b bVar4 = new d.a.o0.e.b();
                bVar4.f46267a = 3;
                c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
            }
        }
    }

    public void l(Context context, long j, a.InterfaceC0668a interfaceC0668a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), interfaceC0668a}) == null) {
            int a2 = d.a.o0.c.a.c().a(interfaceC0668a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    d.a.o0.e.b bVar = new d.a.o0.e.b();
                    bVar.f46267a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.f46272a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    d.a.o0.e.b bVar2 = new d.a.o0.e.b();
                    bVar2.f46267a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!d.a.o0.c.a.c().n(false, true)) {
                    d.a.o0.e.b bVar3 = new d.a.o0.e.b();
                    bVar3.f46267a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
                } else {
                    d.a.o0.h.d.c(context, intValue2, 4, i.r);
                    if (!iVar.q()) {
                        iVar.p(context, a2, j);
                    } else if (d.a.o0.c.a.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (d.a.o0.c.a.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.q()) {
                                        iVar.p(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    d.a.o0.l.c.d(th);
                                    d.a.o0.e.b bVar4 = new d.a.o0.e.b();
                                    bVar4.f46267a = 4;
                                    c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                d.a.o0.e.b bVar5 = new d.a.o0.e.b();
                                bVar5.f46267a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, d2, j, new b(this, iVar, context, a2, j, interfaceC0668a));
                    }
                }
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.f46274c != null) {
                    context.unregisterReceiver(this.f46274c);
                }
                this.f46274c = null;
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }
}
