package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br2;
import com.repackage.el2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes6.dex */
public class pq2 extends HandlerThread implements oq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rq2 a;
        public Deque<rq2> b;
        public boolean c;
        public br2 d;
        public int e;
        public HashMap<String, Integer> f;
        public cr2 g;
        public final /* synthetic */ pq2 h;

        /* renamed from: com.repackage.pq2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0706a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rq2 a;
            public final /* synthetic */ a b;

            public RunnableC0706a(a aVar, rq2 rq2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, rq2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = rq2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = yd3.p();
                    if (p != null) {
                        rq2 rq2Var = this.a;
                        Message.obtain(this.b, 8, new zq2(rq2Var.a, p, rq2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.pq2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0707a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.repackage.pq2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0708a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0708a(RunnableC0707a runnableC0707a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0707a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            if (pq2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0707a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = bVar;
                    this.a = bitmap;
                    this.b = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        be3.a0(new RunnableC0708a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            tq2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            i02.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            i02.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !qq2.g()) {
                        } else {
                            i02.a("exit_whiteScreen_L3");
                            a(this.b);
                        }
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = ul2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                bd3.f().execute(new RunnableC0707a(this, yd3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pq2 pq2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq2Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = pq2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = br2.a.a("simple_parser");
            this.g = (cr2) br2.a.a("hsv_parser");
        }

        public final void g(rq2 rq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rq2Var) == null) && rq2Var != null && i(rq2Var.a)) {
                be3.e0(new RunnableC0706a(this, rq2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                rq2 rq2Var = this.a;
                return rq2Var != null && rq2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (pq2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (v63.d) {
                            q((yq2) message.obj);
                            return;
                        } else {
                            p((yq2) message.obj);
                            return;
                        }
                    case 2:
                        g((rq2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((xq2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        wq2 wq2Var = (wq2) message.obj;
                        if (wq2Var != null) {
                            if (wq2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((ar2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((zq2) message.obj);
                        return;
                    case 9:
                        o((yq2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((yq2) message.obj);
                        return;
                    case 13:
                        q((yq2) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                rq2 rq2Var = this.a;
                return (rq2Var == null || str == null || !TextUtils.equals(str, rq2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                rq2 rq2Var = this.a;
                if (rq2Var == null || rq2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (pq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(yq2 yq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, yq2Var) == null) {
                this.h.a.removeMessages(2);
                rq2 rq2Var = this.a;
                String str = rq2Var != null ? rq2Var.a : StringUtil.NULL_STRING;
                if (pq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + yq2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                rq2 rq2Var = this.a;
                if (rq2Var != null && rq2Var.c() && this.a.c && h()) {
                    sq2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    sq2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    j02.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                rq2 rq2Var = this.a;
                if (rq2Var == null || !rq2Var.i || rq2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (pq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = ul2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            jf3 T = activity.T();
            boolean z = (T == null || (view2 = T.a) == null || view2.getVisibility() != 0) ? false : true;
            if (pq2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                ac3 ac3Var = new ac3();
                ac3Var.k(5L);
                ac3Var.i(19L);
                ac3Var.f("loading=true");
                h03 b0 = h03.b0();
                el2.a W = b0 == null ? null : b0.W();
                i73 i73Var = new i73();
                i73Var.p(ac3Var);
                i73Var.r(W);
                i73Var.q(a73.n(g03.K().k()));
                i73Var.m(g03.K().getAppId());
                i73Var.s(String.valueOf(this.b.size()));
                i73Var.n(false);
                a73.R(i73Var);
            }
        }

        public final void o(@NonNull yq2 yq2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, yq2Var) == null) || yq2Var.c() < 0) {
                return;
            }
            qz1 V = ul2.U().V();
            if (V == null || V.k() <= 0) {
                if (pq2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + yq2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, yq2Var), yq2Var.c());
            }
        }

        public final void p(yq2 yq2Var) {
            pz1 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, yq2Var) == null) || (f = qq2.f()) == null) {
                return;
            }
            String t3 = f.t3();
            nm1 o3 = f.o3();
            if (pq2.b && o3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
            }
            if (o3 == null || i(t3)) {
                return;
            }
            rq2 rq2Var = new rq2(t3, f.m3().a, yq2Var.c(), yq2Var.a());
            this.b.addLast(rq2Var);
            this.a = rq2Var;
            o3.u(vq2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.remove(t3).intValue();
            }
            if (this.c || rq2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, rq2Var), this.a.b());
        }

        public final void q(yq2 yq2Var) {
            pz1 f;
            nm1 o3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, yq2Var) == null) || (f = qq2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            rq2 rq2Var = new rq2(t3, f.m3().a, yq2Var.c(), yq2Var.a());
            if (!i(t3)) {
                this.b.addLast(rq2Var);
                o3.u(vq2.e());
            }
            this.a = rq2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (this.c || rq2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, rq2Var), this.a.b());
            if (pq2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(ar2 ar2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, ar2Var) == null) || ar2Var == null) {
                return;
            }
            String d = ar2Var.d();
            rq2 rq2Var = null;
            Iterator<rq2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rq2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    rq2Var = next;
                    break;
                }
            }
            if (ar2Var.e()) {
                if (rq2Var != null) {
                    rq2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (rq2Var != null) {
                rq2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(zq2 zq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, zq2Var) == null) && zq2Var != null && i(zq2Var.d())) {
                sq2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = zq2Var.e();
                pz1 f = qq2.f();
                View B = ul2.U().B(zq2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = qq2.b(e, f, B);
                this.d.c(qq2.d(f));
                this.a.g();
                boolean a = zq2Var.a();
                if (!qq2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        sq2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        qq2.i(a, zq2Var.d());
                        int i = 19;
                        if (v63.d && !a) {
                            i = 55;
                        }
                        tq2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    sq2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (pq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + zq2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    sq2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (v63.d && !a) {
                        i3 = 56;
                    }
                    tq2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    h12 h12Var = new h12();
                    if (qq2.g()) {
                        if (i2 >= 0) {
                            h12Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            h12Var.d(zq2Var.d());
                            this.a.c = true;
                            sq2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        h12Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        h12Var.d(zq2Var.d());
                        this.a.c = true;
                        sq2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        w02.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (pq2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                be3.a0(new b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.b.clear();
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.a = null;
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                sq2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                ul2.U().u(i63.a(new i63()));
                ul2.U().m(str, i63.a(new i63()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = v83.a().getString("screenshot_upload_switch", "1");
                if (pq2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755401344, "Lcom/repackage/pq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755401344, "Lcom/repackage/pq2;");
                return;
            }
        }
        b = h03.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq2() {
        super("SwanAppPageMonitor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    @Override // com.repackage.oq2
    public void a(yq2 yq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yq2Var) == null) {
            if (!isAlive()) {
                if (b) {
                    Log.d("SwanAppPageMonitor", "thread is not alive");
                }
                try {
                    d();
                } catch (Error | Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (yq2Var != null) {
                Message.obtain(this.a, yq2Var.b(), yq2Var).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.a = new a(this, getLooper());
        }
    }
}
