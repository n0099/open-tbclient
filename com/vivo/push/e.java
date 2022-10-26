package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.t;
import com.vivo.push.util.w;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e a;
    public transient /* synthetic */ FieldHolder $fh;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Context h;
    public boolean i;
    public com.vivo.push.util.b j;
    public String k;
    public String l;
    public SparseArray m;
    public int n;
    public Boolean o;
    public Long p;
    public boolean q;
    public IPushClientFactory r;
    public int s;

    /* loaded from: classes8.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IPushActionListener a;
        public com.vivo.push.b.c b;
        public IPushActionListener c;
        public Runnable d;
        public Object[] e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iPushActionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cVar;
            this.a = iPushActionListener;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Runnable runnable = this.d;
                if (runnable == null) {
                    com.vivo.push.util.p.a("PushClientManager", "task is null");
                } else {
                    runnable.run();
                }
            }
        }

        public final Object[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.e;
            }
            return (Object[]) invokeV.objValue;
        }

        public final void a(int i, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, objArr) == null) {
                this.e = objArr;
                IPushActionListener iPushActionListener = this.c;
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(i);
                }
                IPushActionListener iPushActionListener2 = this.a;
                if (iPushActionListener2 != null) {
                    iPushActionListener2.onStateChanged(i);
                }
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iPushActionListener) == null) {
                this.c = iPushActionListener;
            }
        }

        public final void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
                this.d = runnable;
            }
        }
    }

    public e() {
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
        this.b = -1L;
        this.c = -1L;
        this.d = -1L;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
        this.i = true;
        this.m = new SparseArray();
        this.n = 0;
        this.r = new d();
    }

    private boolean n() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.o == null) {
                if (l() >= 1230 && z.d(this.h)) {
                    z = true;
                } else {
                    z = false;
                }
                this.o = Boolean.valueOf(z);
            }
            return this.o.booleanValue();
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            synchronized (this) {
                if (str != null) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        a aVar = (a) this.m.get(parseInt);
                        this.m.delete(parseInt);
                        return aVar;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            m.a(new k(this, str));
        }
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, bVar, iPushActionListener)) == null) {
            a aVar = new a(bVar, iPushActionListener);
            String a2 = a(aVar);
            bVar.b(a2);
            aVar.a(new h(this, bVar, a2));
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
                eVar = a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.l = null;
            this.j.b("APP_ALIAS");
        }
    }

    public final void b() throws VivoPushException {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (context = this.h) != null) {
            z.b(context);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.h == null) {
                com.vivo.push.util.p.d("PushClientManager", "support:context is null");
                return false;
            }
            Boolean valueOf = Boolean.valueOf(n());
            this.o = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!TextUtils.isEmpty(this.k)) {
                return this.k;
            }
            com.vivo.push.util.b bVar = this.j;
            if (bVar != null) {
                str = bVar.b("APP_TOKEN", (String) null);
            } else {
                str = "";
            }
            c(str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (Context) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.j.a();
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public final long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Context context = this.h;
            if (context == null) {
                return -1L;
            }
            if (this.p == null) {
                this.p = Long.valueOf(z.a(context));
            }
            return this.p.longValue();
        }
        return invokeV.longValue;
    }

    private synchronized String a(a aVar) {
        InterceptResult invokeL;
        String num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar)) == null) {
            synchronized (this) {
                this.m.put(this.n, aVar);
                int i = this.n;
                this.n = i + 1;
                num = Integer.toString(i);
            }
            return num;
        }
        return (String) invokeL.objValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            m.c(new f(this, str));
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.l = str;
            this.j.a("APP_ALIAS", str);
        }
    }

    public static boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (j != -1 && elapsedRealtime > j && elapsedRealtime < j + 2000) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public final void c(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list.contains(this.l)) {
            m();
        }
    }

    public final synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = ContextDelegate.getContext(context);
                    this.q = t.c(context, context.getPackageName());
                    w.b().a(this.h);
                    a(new com.vivo.push.b.g());
                    com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                    this.j = bVar;
                    bVar.a(this.h, "com.vivo.push_preferences.appconfig_v1");
                    this.k = f();
                    this.l = this.j.b("APP_ALIAS", (String) null);
                }
            }
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, pushMessageCallback) == null) {
            o createReceiverCommand = this.r.createReceiverCommand(intent);
            Context context = a().h;
            if (createReceiverCommand == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                    return;
                }
                return;
            }
            com.vivo.push.d.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
            if (createReceiveTask == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                    return;
                }
                return;
            }
            if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
                com.vivo.push.util.p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
            }
            createReceiveTask.a(pushMessageCallback);
            m.a((l) createReceiveTask);
        }
    }

    public final void a(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iPushActionListener) == null) {
            if (this.h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            String f = f();
            this.k = f;
            if (!TextUtils.isEmpty(f)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!a(this.b)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.b = SystemClock.elapsedRealtime();
                String packageName = this.h.getPackageName();
                a aVar = null;
                if (this.h == null) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(102);
                    }
                } else {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                    bVar.g();
                    bVar.d();
                    bVar.e();
                    bVar.a(100);
                    if (this.q) {
                        if (!n()) {
                            if (iPushActionListener != null) {
                                iPushActionListener.onStateChanged(101);
                            }
                        } else {
                            aVar = a(bVar, iPushActionListener);
                        }
                    } else if (bVar.a(this.h) == 2) {
                        aVar = a(bVar, iPushActionListener);
                    } else {
                        a(bVar);
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(0);
                        }
                    }
                }
                if (aVar == null) {
                    return;
                }
                aVar.a(new g(this, aVar));
                aVar.a();
            }
        }
    }

    public final void b(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iPushActionListener) == null) {
            if (this.h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if ("".equals(this.k)) {
                iPushActionListener.onStateChanged(0);
            } else if (!a(this.c)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.c = SystemClock.elapsedRealtime();
                String packageName = this.h.getPackageName();
                a aVar = null;
                if (this.h == null) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(102);
                    }
                } else {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                    bVar.d();
                    bVar.e();
                    bVar.g();
                    bVar.a(100);
                    if (this.q) {
                        if (!n()) {
                            if (iPushActionListener != null) {
                                iPushActionListener.onStateChanged(101);
                            }
                        } else {
                            aVar = new a(bVar, iPushActionListener);
                            String a2 = a(aVar);
                            bVar.b(a2);
                            aVar.a(new j(this, bVar, a2));
                        }
                    } else if (bVar.a(this.h) == 2) {
                        aVar = a(bVar, iPushActionListener);
                    } else {
                        a(bVar);
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(0);
                        }
                    }
                }
                if (aVar == null) {
                    return;
                }
                aVar.a(new i(this));
                aVar.a();
            }
        }
    }

    public final void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) {
            Context context = a().h;
            if (oVar == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                    return;
                }
                return;
            }
            l createTask = this.r.createTask(oVar);
            if (createTask == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(oVar)));
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
                    return;
                }
                return;
            }
            com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(oVar)));
            m.a(createTask);
        }
    }

    public final void b(List list) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                String b = this.j.b("APP_TAGS", (String) null);
                if (TextUtils.isEmpty(b)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(b);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jSONObject.remove((String) it.next());
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.j.b("APP_TAGS");
                } else {
                    this.j.a("APP_TAGS", jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.j.b("APP_TAGS");
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.k = str;
            this.j.a("APP_TOKEN", str);
        }
    }

    public final void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            a d = d(str);
            if (d != null) {
                d.a(i, new Object[0]);
            } else {
                com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
            }
        }
    }

    public final void a(String str, int i, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, objArr) == null) {
            a d = d(str);
            if (d != null) {
                d.a(i, objArr);
            } else {
                com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
            }
        }
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, iPushActionListener) == null) {
            if (this.h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if (!TextUtils.isEmpty(this.l) && this.l.equals(str)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.h.getPackageName(), arrayList);
                aVar.a(100);
                if (this.q) {
                    if (!n()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            return;
                        }
                        return;
                    } else if (!a(this.d)) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(1002);
                            return;
                        }
                        return;
                    } else {
                        this.d = SystemClock.elapsedRealtime();
                        String a2 = a(new a(aVar, iPushActionListener));
                        aVar.b(a2);
                        if (TextUtils.isEmpty(this.k)) {
                            a(a2, SessionCommand.COMMAND_CODE_VOLUME_ADJUST_VOLUME);
                            return;
                        } else if (TextUtils.isEmpty(str)) {
                            a(a2, 30002);
                            return;
                        } else if (str.length() > 70) {
                            a(a2, 30003);
                            return;
                        } else {
                            a(aVar);
                            e(a2);
                            return;
                        }
                    }
                }
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        }
    }

    public final void b(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, iPushActionListener) == null) {
            if (this.h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if (TextUtils.isEmpty(this.l)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.h.getPackageName(), arrayList);
                aVar.a(100);
                if (this.q) {
                    if (!n()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            return;
                        }
                        return;
                    } else if (!a(this.e)) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(1002);
                            return;
                        }
                        return;
                    } else {
                        this.e = SystemClock.elapsedRealtime();
                        String a2 = a(new a(aVar, iPushActionListener));
                        aVar.b(a2);
                        if (TextUtils.isEmpty(this.k)) {
                            a(a2, SessionCommand.COMMAND_CODE_VOLUME_ADJUST_VOLUME);
                            return;
                        } else if (TextUtils.isEmpty(str)) {
                            a(a2, 30002);
                            return;
                        } else if (str.length() > 70) {
                            a(a2, 30003);
                            return;
                        } else {
                            a(aVar);
                            e(a2);
                            return;
                        }
                    }
                }
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        }
    }

    public final void a(ArrayList arrayList, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, iPushActionListener) == null) {
            Context context = this.h;
            if (context == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
            zVar.a(500);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f = SystemClock.elapsedRealtime();
                    String a2 = a(new a(zVar, iPushActionListener));
                    zVar.b(a2);
                    if (TextUtils.isEmpty(this.k)) {
                        a(a2, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        return;
                    } else if (arrayList.size() < 0) {
                        a(a2, 20002);
                        return;
                    } else {
                        if (arrayList.size() + c().size() > 500) {
                            a(a2, 20004);
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (((String) it.next()).length() > 70) {
                                a(a2, 20003);
                                return;
                            }
                        }
                        a(zVar);
                        e(a2);
                        return;
                    }
                }
            }
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void b(ArrayList arrayList, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, arrayList, iPushActionListener) == null) {
            Context context = this.h;
            if (context == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
            zVar.a(500);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.g)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.g = SystemClock.elapsedRealtime();
                    String a2 = a(new a(zVar, iPushActionListener));
                    zVar.b(a2);
                    if (TextUtils.isEmpty(this.k)) {
                        a(a2, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        return;
                    } else if (arrayList.size() < 0) {
                        a(a2, 20002);
                        return;
                    } else if (arrayList.size() > 500) {
                        a(a2, 20004);
                        return;
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (((String) it.next()).length() > 70) {
                                a(a2, 20003);
                                return;
                            }
                        }
                        a(zVar);
                        e(a2);
                        return;
                    }
                }
            }
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void a(List list) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                String b = this.j.b("APP_TAGS", (String) null);
                if (TextUtils.isEmpty(b)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(b);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jSONObject.put((String) it.next(), System.currentTimeMillis());
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.j.b("APP_TAGS");
                } else {
                    this.j.a("APP_TAGS", jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.j.b("APP_TAGS");
            }
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
        }
    }

    public final List c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            String b = this.j.b("APP_TAGS", (String) null);
            ArrayList arrayList = new ArrayList();
            try {
            } catch (JSONException unused) {
                this.j.b("APP_TAGS");
                arrayList.clear();
                com.vivo.push.util.p.d("PushClientManager", "getTags error");
            }
            if (TextUtils.isEmpty(b)) {
                return arrayList;
            }
            Iterator<String> keys = new JSONObject(b).keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
