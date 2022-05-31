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
import com.repackage.bq2;
import com.repackage.ek2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes6.dex */
public class pp2 extends HandlerThread implements op2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rp2 a;
        public Deque<rp2> b;
        public boolean c;
        public bq2 d;
        public int e;
        public HashMap<String, Integer> f;
        public cq2 g;
        public final /* synthetic */ pp2 h;

        /* renamed from: com.repackage.pp2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0496a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rp2 a;
            public final /* synthetic */ a b;

            public RunnableC0496a(a aVar, rp2 rp2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, rp2Var};
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
                this.a = rp2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = yc3.p();
                    if (p != null) {
                        rp2 rp2Var = this.a;
                        Message.obtain(this.b, 8, new zp2(rp2Var.a, p, rp2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.pp2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0497a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.repackage.pp2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0498a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0498a(RunnableC0497a runnableC0497a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0497a, swanAppActivity};
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
                            if (pp2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0497a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        bd3.a0(new RunnableC0498a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            tp2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            iz1.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            iz1.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !qp2.g()) {
                        } else {
                            iz1.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = uk2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                bc3.f().execute(new RunnableC0497a(this, yc3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pp2 pp2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp2Var, looper};
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
            this.h = pp2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = bq2.a.a("simple_parser");
            this.g = (cq2) bq2.a.a("hsv_parser");
        }

        public final void g(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rp2Var) == null) && rp2Var != null && i(rp2Var.a)) {
                bd3.e0(new RunnableC0496a(this, rp2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                rp2 rp2Var = this.a;
                return rp2Var != null && rp2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (pp2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (v53.d) {
                            q((yp2) message.obj);
                            return;
                        } else {
                            p((yp2) message.obj);
                            return;
                        }
                    case 2:
                        g((rp2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((xp2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        wp2 wp2Var = (wp2) message.obj;
                        if (wp2Var != null) {
                            if (wp2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((aq2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((zp2) message.obj);
                        return;
                    case 9:
                        o((yp2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((yp2) message.obj);
                        return;
                    case 13:
                        q((yp2) message.obj);
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
                rp2 rp2Var = this.a;
                return (rp2Var == null || str == null || !TextUtils.equals(str, rp2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                rp2 rp2Var = this.a;
                if (rp2Var == null || rp2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (pp2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(yp2 yp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, yp2Var) == null) {
                this.h.a.removeMessages(2);
                rp2 rp2Var = this.a;
                String str = rp2Var != null ? rp2Var.a : StringUtil.NULL_STRING;
                if (pp2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + yp2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                rp2 rp2Var = this.a;
                if (rp2Var != null && rp2Var.c() && this.a.c && h()) {
                    sp2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    sp2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    jz1.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                rp2 rp2Var = this.a;
                if (rp2Var == null || !rp2Var.i || rp2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (pp2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = uk2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            je3 loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view2 = loadingView.a) == null || view2.getVisibility() != 0) ? false : true;
            if (pp2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                ab3 ab3Var = new ab3();
                ab3Var.k(5L);
                ab3Var.i(19L);
                ab3Var.f("loading=true");
                hz2 a0 = hz2.a0();
                ek2.a V = a0 == null ? null : a0.V();
                i63 i63Var = new i63();
                i63Var.p(ab3Var);
                i63Var.r(V);
                i63Var.q(a63.n(gz2.J().l()));
                i63Var.m(gz2.J().getAppId());
                i63Var.s(String.valueOf(this.b.size()));
                i63Var.n(false);
                a63.R(i63Var);
            }
        }

        public final void o(@NonNull yp2 yp2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, yp2Var) == null) || yp2Var.c() < 0) {
                return;
            }
            qy1 V = uk2.U().V();
            if (V == null || V.k() <= 0) {
                if (pp2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + yp2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, yp2Var), yp2Var.c());
            }
        }

        public final void p(yp2 yp2Var) {
            py1 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, yp2Var) == null) || (f = qp2.f()) == null) {
                return;
            }
            String s3 = f.s3();
            nl1 n3 = f.n3();
            if (pp2.b && n3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + s3);
            }
            if (n3 == null || i(s3)) {
                return;
            }
            rp2 rp2Var = new rp2(s3, f.l3().a, yp2Var.c(), yp2Var.a());
            this.b.addLast(rp2Var);
            this.a = rp2Var;
            n3.v(vp2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(s3)) {
                this.a.g = this.f.remove(s3).intValue();
            }
            if (this.c || rp2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, rp2Var), this.a.b());
        }

        public final void q(yp2 yp2Var) {
            py1 f;
            nl1 n3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, yp2Var) == null) || (f = qp2.f()) == null || (n3 = f.n3()) == null) {
                return;
            }
            String s3 = f.s3();
            rp2 rp2Var = new rp2(s3, f.l3().a, yp2Var.c(), yp2Var.a());
            if (!i(s3)) {
                this.b.addLast(rp2Var);
                n3.v(vp2.e());
            }
            this.a = rp2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(s3)) {
                this.a.g = this.f.get(s3).intValue();
            }
            if (this.c || rp2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, rp2Var), this.a.b());
            if (pp2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + s3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(aq2 aq2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, aq2Var) == null) || aq2Var == null) {
                return;
            }
            String d = aq2Var.d();
            rp2 rp2Var = null;
            Iterator<rp2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rp2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    rp2Var = next;
                    break;
                }
            }
            if (aq2Var.e()) {
                if (rp2Var != null) {
                    rp2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (rp2Var != null) {
                rp2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(zp2 zp2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, zp2Var) == null) && zp2Var != null && i(zp2Var.d())) {
                sp2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = zp2Var.e();
                py1 f = qp2.f();
                View B = uk2.U().B(zp2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = qp2.b(e, f, B);
                this.d.c(qp2.d(f));
                this.a.g();
                boolean a = zp2Var.a();
                if (!qp2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        sp2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        qp2.i(a, zp2Var.d());
                        int i = 19;
                        if (v53.d && !a) {
                            i = 55;
                        }
                        tp2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    sp2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (pp2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + zp2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    sp2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (v53.d && !a) {
                        i3 = 56;
                    }
                    tp2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    h02 h02Var = new h02();
                    if (qp2.g()) {
                        if (i2 >= 0) {
                            h02Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            h02Var.d(zp2Var.d());
                            this.a.c = true;
                            sp2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        h02Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        h02Var.d(zp2Var.d());
                        this.a.c = true;
                        sp2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        wz1.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (pp2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                bd3.a0(new b(this));
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
                sp2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                uk2.U().u(i53.a(new i53()));
                uk2.U().m(str, i53.a(new i53()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = v73.a().getString("screenshot_upload_switch", "1");
                if (pp2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755402305, "Lcom/repackage/pp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755402305, "Lcom/repackage/pp2;");
                return;
            }
        }
        b = hz2.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pp2() {
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

    @Override // com.repackage.op2
    public void a(yp2 yp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yp2Var) == null) {
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
            if (yp2Var != null) {
                Message.obtain(this.a, yp2Var.b(), yp2Var).sendToTarget();
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
