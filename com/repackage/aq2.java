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
import com.repackage.mq2;
import com.repackage.pk2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes5.dex */
public class aq2 extends HandlerThread implements zp2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public cq2 a;
        public Deque<cq2> b;
        public boolean c;
        public mq2 d;
        public int e;
        public HashMap<String, Integer> f;
        public nq2 g;
        public final /* synthetic */ aq2 h;

        /* renamed from: com.repackage.aq2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0386a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cq2 a;
            public final /* synthetic */ a b;

            public RunnableC0386a(a aVar, cq2 cq2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cq2Var};
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
                this.a = cq2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = jd3.p();
                    if (p != null) {
                        cq2 cq2Var = this.a;
                        Message.obtain(this.b, 8, new kq2(cq2Var.a, p, cq2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.aq2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0387a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.repackage.aq2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public class RunnableC0388a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0388a(RunnableC0387a runnableC0387a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0387a, swanAppActivity};
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
                            if (aq2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0387a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        md3.a0(new RunnableC0388a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            eq2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            tz1.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            tz1.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !bq2.g()) {
                        } else {
                            tz1.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = fl2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                mc3.f().execute(new RunnableC0387a(this, jd3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(aq2 aq2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq2Var, looper};
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
            this.h = aq2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = mq2.a.a("simple_parser");
            this.g = (nq2) mq2.a.a("hsv_parser");
        }

        public final void g(cq2 cq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, cq2Var) == null) && cq2Var != null && i(cq2Var.a)) {
                md3.e0(new RunnableC0386a(this, cq2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                cq2 cq2Var = this.a;
                return cq2Var != null && cq2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (aq2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (g63.d) {
                            q((jq2) message.obj);
                            return;
                        } else {
                            p((jq2) message.obj);
                            return;
                        }
                    case 2:
                        g((cq2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((iq2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        hq2 hq2Var = (hq2) message.obj;
                        if (hq2Var != null) {
                            if (hq2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((lq2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((kq2) message.obj);
                        return;
                    case 9:
                        o((jq2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((jq2) message.obj);
                        return;
                    case 13:
                        q((jq2) message.obj);
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
                cq2 cq2Var = this.a;
                return (cq2Var == null || str == null || !TextUtils.equals(str, cq2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                cq2 cq2Var = this.a;
                if (cq2Var == null || cq2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (aq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(jq2 jq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, jq2Var) == null) {
                this.h.a.removeMessages(2);
                cq2 cq2Var = this.a;
                String str = cq2Var != null ? cq2Var.a : StringUtil.NULL_STRING;
                if (aq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + jq2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                cq2 cq2Var = this.a;
                if (cq2Var != null && cq2Var.c() && this.a.c && h()) {
                    dq2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    dq2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    uz1.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                cq2 cq2Var = this.a;
                if (cq2Var == null || !cq2Var.i || cq2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (aq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = fl2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            ue3 T = activity.T();
            boolean z = (T == null || (view2 = T.a) == null || view2.getVisibility() != 0) ? false : true;
            if (aq2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                lb3 lb3Var = new lb3();
                lb3Var.k(5L);
                lb3Var.i(19L);
                lb3Var.f("loading=true");
                sz2 b0 = sz2.b0();
                pk2.a W = b0 == null ? null : b0.W();
                t63 t63Var = new t63();
                t63Var.p(lb3Var);
                t63Var.r(W);
                t63Var.q(l63.n(rz2.K().l()));
                t63Var.m(rz2.K().getAppId());
                t63Var.s(String.valueOf(this.b.size()));
                t63Var.n(false);
                l63.R(t63Var);
            }
        }

        public final void o(@NonNull jq2 jq2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, jq2Var) == null) || jq2Var.c() < 0) {
                return;
            }
            bz1 V = fl2.U().V();
            if (V == null || V.k() <= 0) {
                if (aq2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + jq2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, jq2Var), jq2Var.c());
            }
        }

        public final void p(jq2 jq2Var) {
            az1 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, jq2Var) == null) || (f = bq2.f()) == null) {
                return;
            }
            String t3 = f.t3();
            yl1 o3 = f.o3();
            if (aq2.b && o3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
            }
            if (o3 == null || i(t3)) {
                return;
            }
            cq2 cq2Var = new cq2(t3, f.m3().a, jq2Var.c(), jq2Var.a());
            this.b.addLast(cq2Var);
            this.a = cq2Var;
            o3.v(gq2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.remove(t3).intValue();
            }
            if (this.c || cq2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, cq2Var), this.a.b());
        }

        public final void q(jq2 jq2Var) {
            az1 f;
            yl1 o3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, jq2Var) == null) || (f = bq2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            cq2 cq2Var = new cq2(t3, f.m3().a, jq2Var.c(), jq2Var.a());
            if (!i(t3)) {
                this.b.addLast(cq2Var);
                o3.v(gq2.e());
            }
            this.a = cq2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (this.c || cq2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, cq2Var), this.a.b());
            if (aq2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(lq2 lq2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, lq2Var) == null) || lq2Var == null) {
                return;
            }
            String d = lq2Var.d();
            cq2 cq2Var = null;
            Iterator<cq2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cq2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    cq2Var = next;
                    break;
                }
            }
            if (lq2Var.e()) {
                if (cq2Var != null) {
                    cq2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (cq2Var != null) {
                cq2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(kq2 kq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, kq2Var) == null) && kq2Var != null && i(kq2Var.d())) {
                dq2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = kq2Var.e();
                az1 f = bq2.f();
                View B = fl2.U().B(kq2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = bq2.b(e, f, B);
                this.d.c(bq2.d(f));
                this.a.g();
                boolean a = kq2Var.a();
                if (!bq2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        dq2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        bq2.i(a, kq2Var.d());
                        int i = 19;
                        if (g63.d && !a) {
                            i = 55;
                        }
                        eq2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    dq2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (aq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + kq2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    dq2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (g63.d && !a) {
                        i3 = 56;
                    }
                    eq2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    s02 s02Var = new s02();
                    if (bq2.g()) {
                        if (i2 >= 0) {
                            s02Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            s02Var.d(kq2Var.d());
                            this.a.c = true;
                            dq2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        s02Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        s02Var.d(kq2Var.d());
                        this.a.c = true;
                        dq2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        h02.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (aq2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                md3.a0(new b(this));
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
                dq2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                fl2.U().u(t53.a(new t53()));
                fl2.U().m(str, t53.a(new t53()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = g83.a().getString("screenshot_upload_switch", "1");
                if (aq2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755848209, "Lcom/repackage/aq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755848209, "Lcom/repackage/aq2;");
                return;
            }
        }
        b = sz2.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq2() {
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

    @Override // com.repackage.zp2
    public void a(jq2 jq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jq2Var) == null) {
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
            if (jq2Var != null) {
                Message.obtain(this.a, jq2Var.b(), jq2Var).sendToTarget();
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
