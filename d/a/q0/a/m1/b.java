package d.a.q0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.h0.i.i;
import d.a.q0.a.j2.h;
import d.a.q0.a.j2.k;
import d.a.q0.a.m1.i.a;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.q0;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes8.dex */
public class b extends HandlerThread implements d.a.q0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f49371f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f49372e;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f49373a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f49374b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f49375c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.q0.a.m1.i.a f49376d;

        /* renamed from: e  reason: collision with root package name */
        public int f49377e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f49378f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.q0.a.m1.i.b f49379g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f49380h;

        /* renamed from: d.a.q0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0857a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f49381e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f49382f;

            public RunnableC0857a(a aVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49382f = aVar;
                this.f49381e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49382f.w(this.f49381e.f49393a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f49381e;
                        Message.obtain(this.f49382f, 8, new d.a.q0.a.m1.h.d(dVar.f49393a, p, dVar.f49401i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: d.a.q0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0858b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f49383e;

            /* renamed from: d.a.q0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0859a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f49384e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f49385f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0858b f49386g;

                /* renamed from: d.a.q0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class RunnableC0860a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f49387e;

                    public RunnableC0860a(RunnableC0859a runnableC0859a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0859a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f49387e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            if (b.f49371f) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.f49387e.finish();
                        }
                    }
                }

                public RunnableC0859a(RunnableC0858b runnableC0858b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0858b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f49386g = runnableC0858b;
                    this.f49384e = bitmap;
                    this.f49385f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.X(new RunnableC0860a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f49386g.f49383e.f49376d.a(this.f49384e, this.f49386g.f49383e.f49373a.f49400h)) {
                            e.c(this.f49386g.f49383e.f49373a, 33, false, this.f49386g.f49383e.f49374b.size());
                            d.a.q0.a.h0.i.f.a("exit_whiteScreen_L1");
                            a(this.f49385f);
                            return;
                        }
                        double d2 = this.f49386g.f49383e.f49379g.d(this.f49384e, this.f49386g.f49383e.f49373a.f49400h);
                        if (d2 >= 0.7d && this.f49386g.f49383e.f49377e == 0) {
                            d.a.q0.a.h0.i.f.a("exit_whiteScreen_L2");
                            a(this.f49385f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            d.a.q0.a.h0.i.f.a("exit_whiteScreen_L3");
                            a(this.f49385f);
                        }
                    }
                }
            }

            public RunnableC0858b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49383e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = d.a.q0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f49383e.f49373a == null) {
                    return;
                }
                q.e().execute(new RunnableC0859a(this, n0.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49380h = bVar;
            this.f49374b = new ArrayDeque();
            this.f49375c = true;
            this.f49377e = 0;
            this.f49376d = a.C0862a.a("simple_parser");
            this.f49379g = (d.a.q0.a.m1.i.b) a.C0862a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && j(dVar.f49393a)) {
                q0.b0(new RunnableC0857a(this, dVar));
            }
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49377e : invokeV.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f49371f) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (h.f49063e) {
                            r((d.a.q0.a.m1.h.c) message.obj);
                            return;
                        } else {
                            q((d.a.q0.a.m1.h.c) message.obj);
                            return;
                        }
                    case 2:
                        g((d) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((d.a.q0.a.m1.h.b) message.obj).e()) {
                            k();
                            return;
                        } else {
                            n();
                            return;
                        }
                    case 5:
                        d.a.q0.a.m1.h.a aVar = (d.a.q0.a.m1.h.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f49377e++;
                                return;
                            } else {
                                this.f49377e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        s((d.a.q0.a.m1.h.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        v();
                        return;
                    case 8:
                        t((d.a.q0.a.m1.h.d) message.obj);
                        return;
                    case 9:
                        p((d.a.q0.a.m1.h.c) message.obj);
                        return;
                    case 10:
                        o();
                        return;
                    case 11:
                        m();
                        return;
                    case 12:
                        l((d.a.q0.a.m1.h.c) message.obj);
                        return;
                    case 13:
                        r((d.a.q0.a.m1.h.c) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                d dVar = this.f49373a;
                return dVar != null && dVar.f49401i;
            }
            return invokeV.booleanValue;
        }

        public final boolean j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d dVar = this.f49373a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f49393a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f49375c = true;
                d dVar = this.f49373a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f49380h.f49372e != null) {
                    this.f49380h.f49372e.removeMessages(2);
                }
                this.f49373a.d();
                if (b.f49371f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.f49373a.f49401i);
                }
            }
        }

        public final void l(d.a.q0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.f49380h.f49372e.removeMessages(2);
                d dVar = this.f49373a;
                String str = dVar != null ? dVar.f49393a : StringUtil.NULL_STRING;
                if (b.f49371f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a());
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d dVar = this.f49373a;
                if (dVar != null && dVar.c() && this.f49373a.f49395c && i()) {
                    u();
                }
                if (i()) {
                    i.c();
                }
            }
        }

        public final void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f49375c = false;
                d dVar = this.f49373a;
                if (dVar == null || !dVar.f49401i || dVar.c()) {
                    return;
                }
                this.f49373a.e();
                long b2 = this.f49373a.b();
                if (b2 >= 0) {
                    this.f49380h.f49372e.sendMessageDelayed(Message.obtain(this.f49380h.f49372e, 2, this.f49373a), b2);
                }
                if (b.f49371f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.f49373a.f49401i);
                }
            }
        }

        public final void o() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = d.a.q0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            d.a.q0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f51595a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f49371f) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a N = d.a.q0.a.a2.e.i() != null ? d.a.q0.a.a2.e.i().N() : null;
                d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(N);
                dVar.q(k.m(d.a.q0.a.a2.d.g().l()));
                dVar.m(d.a.q0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f49374b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull d.a.q0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            if (W == null || W.k() <= 0) {
                if (b.f49371f) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.c());
                }
                this.f49380h.f49372e.sendMessageDelayed(Message.obtain(this.f49380h.f49372e, 10, cVar), cVar.c());
            }
        }

        public final void q(d.a.q0.a.m1.h.c cVar) {
            d.a.q0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String g3 = f2.g3();
            d.a.q0.a.p.e.b b3 = f2.b3();
            if (b.f49371f && b3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + g3);
            }
            if (b3 == null || j(g3)) {
                return;
            }
            d dVar = new d(g3, f2.Z2().f49291e, cVar.c(), cVar.a());
            this.f49374b.addLast(dVar);
            this.f49373a = dVar;
            b3.v(g.f());
            HashMap<String, Integer> hashMap = this.f49378f;
            if (hashMap != null && hashMap.containsKey(g3)) {
                this.f49373a.f49399g = this.f49378f.remove(g3).intValue();
            }
            if (this.f49375c || dVar.b() < 0) {
                return;
            }
            this.f49380h.f49372e.sendMessageDelayed(Message.obtain(this.f49380h.f49372e, 2, dVar), this.f49373a.b());
        }

        public final void r(d.a.q0.a.m1.h.c cVar) {
            d.a.q0.a.h0.g.f f2;
            d.a.q0.a.p.e.b b3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (f2 = c.f()) == null || (b3 = f2.b3()) == null) {
                return;
            }
            String g3 = f2.g3();
            d dVar = new d(g3, f2.Z2().f49291e, cVar.c(), cVar.a());
            if (!j(g3)) {
                this.f49374b.addLast(dVar);
                b3.v(g.f());
            }
            this.f49373a = dVar;
            HashMap<String, Integer> hashMap = this.f49378f;
            if (hashMap != null && hashMap.containsKey(g3)) {
                this.f49373a.f49399g = this.f49378f.get(g3).intValue();
            }
            if (this.f49375c || dVar.b() < 0) {
                return;
            }
            this.f49380h.f49372e.sendMessageDelayed(Message.obtain(this.f49380h.f49372e, 2, dVar), this.f49373a.b());
            if (b.f49371f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + g3 + " time=" + this.f49373a.b() + " isNewLaunch=" + this.f49373a.f49401i);
            }
        }

        public final void s(d.a.q0.a.m1.h.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f49374b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f49393a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f49399g++;
                    return;
                }
                if (this.f49378f == null) {
                    this.f49378f = new HashMap<>();
                }
                Integer num2 = this.f49378f.get(d2);
                this.f49378f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f49399g--;
            } else {
                HashMap<String, Integer> hashMap = this.f49378f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f49378f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(d.a.q0.a.m1.h.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && dVar != null && j(dVar.d())) {
                Bitmap e2 = dVar.e();
                d.a.q0.a.h0.g.f f2 = c.f();
                AbsoluteLayout C = d.a.q0.a.g1.f.V().C(dVar.d());
                if (e2 == null || C == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, C);
                this.f49376d.c(c.d(f2));
                this.f49373a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f49377e <= 0) {
                    this.f49373a.f49395c = this.f49376d.a(e2, b2);
                    d dVar2 = this.f49373a;
                    if (dVar2.f49395c) {
                        if (a2) {
                            dVar2.f(e2);
                            this.f49373a.f49400h = b2;
                        }
                        c.i(a2);
                        int i2 = 19;
                        if (h.f49063e && !a2) {
                            i2 = 55;
                        }
                        e.c(this.f49373a, i2, a2, this.f49374b.size());
                    }
                } else {
                    this.f49373a.f49395c = false;
                }
                this.f49373a.a();
                if (b.f49371f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f49373a.f49395c + " isNewLaunch=" + a2);
                }
                if (this.f49373a.f49395c) {
                    return;
                }
                double d2 = this.f49379g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    int i4 = 28;
                    if (h.f49063e && !a2) {
                        i4 = 56;
                    }
                    e.d(this.f49373a, i4, x(), e2, a2, this.f49374b.size());
                }
                if (a2) {
                    if (c.g()) {
                        if (i3 >= 0) {
                            c.j("whiteScreen_L3", d.a.q0.a.h0.i.c.f48098c);
                            this.f49373a.f49395c = true;
                        }
                    } else if (this.f49377e != 0 || d2 < 0.7d) {
                    } else {
                        c.j("whiteScreen_L2", d.a.q0.a.h0.i.c.f48097b);
                        this.f49373a.f49395c = true;
                    }
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                if (b.f49371f) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                q0.X(new RunnableC0858b(this));
            }
        }

        public final void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f49374b.clear();
                HashMap<String, Integer> hashMap = this.f49378f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f49373a = null;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i()) {
                d.a.q0.a.g1.f.V().v(d.a.q0.a.i2.b.a(new d.a.q0.a.i2.b()));
                d.a.q0.a.g1.f.V().m(str, d.a.q0.a.i2.b.a(new d.a.q0.a.i2.b()));
                if (b.f49371f) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        public final boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                String string = d.a.q0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f49371f) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(121582283, "Ld/a/q0/a/m1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(121582283, "Ld/a/q0/a/m1/b;");
                return;
            }
        }
        f49371f = d.a.q0.a.a2.e.y;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("SwanAppPageMonitor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e();
    }

    @Override // d.a.q0.a.m1.a
    public void a(d.a.q0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                if (f49371f) {
                    Log.d("SwanAppPageMonitor", "thread is not alive");
                }
                try {
                    e();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f49372e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f49372e;
            if (aVar != null) {
                return aVar.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            start();
            this.f49372e = new a(this, getLooper());
        }
    }
}
