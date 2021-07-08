package d.a.n0.a.m1;

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
import d.a.n0.a.f1.e.b;
import d.a.n0.a.h0.i.i;
import d.a.n0.a.j2.h;
import d.a.n0.a.j2.k;
import d.a.n0.a.m1.i.a;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.q0;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes7.dex */
public class b extends HandlerThread implements d.a.n0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46069f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f46070e;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f46071a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f46072b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f46073c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.n0.a.m1.i.a f46074d;

        /* renamed from: e  reason: collision with root package name */
        public int f46075e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f46076f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.n0.a.m1.i.b f46077g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f46078h;

        /* renamed from: d.a.n0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0806a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f46079e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46080f;

            public RunnableC0806a(a aVar, d dVar) {
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
                this.f46080f = aVar;
                this.f46079e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46080f.w(this.f46079e.f46091a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f46079e;
                        Message.obtain(this.f46080f, 8, new d.a.n0.a.m1.h.d(dVar.f46091a, p, dVar.f46099i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: d.a.n0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0807b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f46081e;

            /* renamed from: d.a.n0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0808a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f46082e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f46083f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0807b f46084g;

                /* renamed from: d.a.n0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0809a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f46085e;

                    public RunnableC0809a(RunnableC0808a runnableC0808a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0808a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f46085e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            if (b.f46069f) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.f46085e.finish();
                        }
                    }
                }

                public RunnableC0808a(RunnableC0807b runnableC0807b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0807b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f46084g = runnableC0807b;
                    this.f46082e = bitmap;
                    this.f46083f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.X(new RunnableC0809a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f46084g.f46081e.f46074d.a(this.f46082e, this.f46084g.f46081e.f46071a.f46098h)) {
                            e.c(this.f46084g.f46081e.f46071a, 33, false, this.f46084g.f46081e.f46072b.size());
                            d.a.n0.a.h0.i.f.a("exit_whiteScreen_L1");
                            a(this.f46083f);
                            return;
                        }
                        double d2 = this.f46084g.f46081e.f46077g.d(this.f46082e, this.f46084g.f46081e.f46071a.f46098h);
                        if (d2 >= 0.7d && this.f46084g.f46081e.f46075e == 0) {
                            d.a.n0.a.h0.i.f.a("exit_whiteScreen_L2");
                            a(this.f46083f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            d.a.n0.a.h0.i.f.a("exit_whiteScreen_L3");
                            a(this.f46083f);
                        }
                    }
                }
            }

            public RunnableC0807b(a aVar) {
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
                this.f46081e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = d.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f46081e.f46071a == null) {
                    return;
                }
                q.e().execute(new RunnableC0808a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f46078h = bVar;
            this.f46072b = new ArrayDeque();
            this.f46073c = true;
            this.f46075e = 0;
            this.f46074d = a.C0811a.a("simple_parser");
            this.f46077g = (d.a.n0.a.m1.i.b) a.C0811a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && j(dVar.f46091a)) {
                q0.b0(new RunnableC0806a(this, dVar));
            }
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46075e : invokeV.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f46069f) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (h.f45761e) {
                            r((d.a.n0.a.m1.h.c) message.obj);
                            return;
                        } else {
                            q((d.a.n0.a.m1.h.c) message.obj);
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
                        if (((d.a.n0.a.m1.h.b) message.obj).e()) {
                            k();
                            return;
                        } else {
                            n();
                            return;
                        }
                    case 5:
                        d.a.n0.a.m1.h.a aVar = (d.a.n0.a.m1.h.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f46075e++;
                                return;
                            } else {
                                this.f46075e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        s((d.a.n0.a.m1.h.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        v();
                        return;
                    case 8:
                        t((d.a.n0.a.m1.h.d) message.obj);
                        return;
                    case 9:
                        p((d.a.n0.a.m1.h.c) message.obj);
                        return;
                    case 10:
                        o();
                        return;
                    case 11:
                        m();
                        return;
                    case 12:
                        l((d.a.n0.a.m1.h.c) message.obj);
                        return;
                    case 13:
                        r((d.a.n0.a.m1.h.c) message.obj);
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
                d dVar = this.f46071a;
                return dVar != null && dVar.f46099i;
            }
            return invokeV.booleanValue;
        }

        public final boolean j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d dVar = this.f46071a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f46091a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f46073c = true;
                d dVar = this.f46071a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f46078h.f46070e != null) {
                    this.f46078h.f46070e.removeMessages(2);
                }
                this.f46071a.d();
                if (b.f46069f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.f46071a.f46099i);
                }
            }
        }

        public final void l(d.a.n0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.f46078h.f46070e.removeMessages(2);
                d dVar = this.f46071a;
                String str = dVar != null ? dVar.f46091a : StringUtil.NULL_STRING;
                if (b.f46069f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a());
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d dVar = this.f46071a;
                if (dVar != null && dVar.c() && this.f46071a.f46093c && i()) {
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
                this.f46073c = false;
                d dVar = this.f46071a;
                if (dVar == null || !dVar.f46099i || dVar.c()) {
                    return;
                }
                this.f46071a.e();
                long b2 = this.f46071a.b();
                if (b2 >= 0) {
                    this.f46078h.f46070e.sendMessageDelayed(Message.obtain(this.f46078h.f46070e, 2, this.f46071a), b2);
                }
                if (b.f46069f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.f46071a.f46099i);
                }
            }
        }

        public final void o() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = d.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            d.a.n0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f48293a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f46069f) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a N = d.a.n0.a.a2.e.i() != null ? d.a.n0.a.a2.e.i().N() : null;
                d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(N);
                dVar.q(k.m(d.a.n0.a.a2.d.g().l()));
                dVar.m(d.a.n0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f46072b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull d.a.n0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
            if (W == null || W.k() <= 0) {
                if (b.f46069f) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.c());
                }
                this.f46078h.f46070e.sendMessageDelayed(Message.obtain(this.f46078h.f46070e, 10, cVar), cVar.c());
            }
        }

        public final void q(d.a.n0.a.m1.h.c cVar) {
            d.a.n0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String g3 = f2.g3();
            d.a.n0.a.p.e.b b3 = f2.b3();
            if (b.f46069f && b3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + g3);
            }
            if (b3 == null || j(g3)) {
                return;
            }
            d dVar = new d(g3, f2.Z2().f45989e, cVar.c(), cVar.a());
            this.f46072b.addLast(dVar);
            this.f46071a = dVar;
            b3.v(g.f());
            HashMap<String, Integer> hashMap = this.f46076f;
            if (hashMap != null && hashMap.containsKey(g3)) {
                this.f46071a.f46097g = this.f46076f.remove(g3).intValue();
            }
            if (this.f46073c || dVar.b() < 0) {
                return;
            }
            this.f46078h.f46070e.sendMessageDelayed(Message.obtain(this.f46078h.f46070e, 2, dVar), this.f46071a.b());
        }

        public final void r(d.a.n0.a.m1.h.c cVar) {
            d.a.n0.a.h0.g.f f2;
            d.a.n0.a.p.e.b b3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (f2 = c.f()) == null || (b3 = f2.b3()) == null) {
                return;
            }
            String g3 = f2.g3();
            d dVar = new d(g3, f2.Z2().f45989e, cVar.c(), cVar.a());
            if (!j(g3)) {
                this.f46072b.addLast(dVar);
                b3.v(g.f());
            }
            this.f46071a = dVar;
            HashMap<String, Integer> hashMap = this.f46076f;
            if (hashMap != null && hashMap.containsKey(g3)) {
                this.f46071a.f46097g = this.f46076f.get(g3).intValue();
            }
            if (this.f46073c || dVar.b() < 0) {
                return;
            }
            this.f46078h.f46070e.sendMessageDelayed(Message.obtain(this.f46078h.f46070e, 2, dVar), this.f46071a.b());
            if (b.f46069f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + g3 + " time=" + this.f46071a.b() + " isNewLaunch=" + this.f46071a.f46099i);
            }
        }

        public final void s(d.a.n0.a.m1.h.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f46072b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f46091a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f46097g++;
                    return;
                }
                if (this.f46076f == null) {
                    this.f46076f = new HashMap<>();
                }
                Integer num2 = this.f46076f.get(d2);
                this.f46076f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f46097g--;
            } else {
                HashMap<String, Integer> hashMap = this.f46076f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f46076f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(d.a.n0.a.m1.h.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && dVar != null && j(dVar.d())) {
                Bitmap e2 = dVar.e();
                d.a.n0.a.h0.g.f f2 = c.f();
                AbsoluteLayout C = d.a.n0.a.g1.f.V().C(dVar.d());
                if (e2 == null || C == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, C);
                this.f46074d.c(c.d(f2));
                this.f46071a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f46075e <= 0) {
                    this.f46071a.f46093c = this.f46074d.a(e2, b2);
                    d dVar2 = this.f46071a;
                    if (dVar2.f46093c) {
                        if (a2) {
                            dVar2.f(e2);
                            this.f46071a.f46098h = b2;
                        }
                        c.i(a2);
                        int i2 = 19;
                        if (h.f45761e && !a2) {
                            i2 = 55;
                        }
                        e.c(this.f46071a, i2, a2, this.f46072b.size());
                    }
                } else {
                    this.f46071a.f46093c = false;
                }
                this.f46071a.a();
                if (b.f46069f) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f46071a.f46093c + " isNewLaunch=" + a2);
                }
                if (this.f46071a.f46093c) {
                    return;
                }
                double d2 = this.f46077g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    int i4 = 28;
                    if (h.f45761e && !a2) {
                        i4 = 56;
                    }
                    e.d(this.f46071a, i4, x(), e2, a2, this.f46072b.size());
                }
                if (a2) {
                    if (c.g()) {
                        if (i3 >= 0) {
                            c.j("whiteScreen_L3", d.a.n0.a.h0.i.c.f44796c);
                            this.f46071a.f46093c = true;
                        }
                    } else if (this.f46075e != 0 || d2 < 0.7d) {
                    } else {
                        c.j("whiteScreen_L2", d.a.n0.a.h0.i.c.f44795b);
                        this.f46071a.f46093c = true;
                    }
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                if (b.f46069f) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                q0.X(new RunnableC0807b(this));
            }
        }

        public final void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f46072b.clear();
                HashMap<String, Integer> hashMap = this.f46076f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f46071a = null;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i()) {
                d.a.n0.a.g1.f.V().v(d.a.n0.a.i2.b.a(new d.a.n0.a.i2.b()));
                d.a.n0.a.g1.f.V().m(str, d.a.n0.a.i2.b.a(new d.a.n0.a.i2.b()));
                if (b.f46069f) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        public final boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                String string = d.a.n0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f46069f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(711122798, "Ld/a/n0/a/m1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(711122798, "Ld/a/n0/a/m1/b;");
                return;
            }
        }
        f46069f = d.a.n0.a.a2.e.y;
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

    @Override // d.a.n0.a.m1.a
    public void a(d.a.n0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                if (f46069f) {
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
                Message.obtain(this.f46070e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f46070e;
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
            this.f46070e = new a(this, getLooper());
        }
    }
}
