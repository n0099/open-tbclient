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
import com.repackage.dr2;
import com.repackage.gl2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes7.dex */
public class rq2 extends HandlerThread implements qq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public tq2 a;
        public Deque<tq2> b;
        public boolean c;
        public dr2 d;
        public int e;
        public HashMap<String, Integer> f;
        public er2 g;
        public final /* synthetic */ rq2 h;

        /* renamed from: com.repackage.rq2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0508a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tq2 a;
            public final /* synthetic */ a b;

            public RunnableC0508a(a aVar, tq2 tq2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, tq2Var};
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
                this.a = tq2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = ae3.p();
                    if (p != null) {
                        tq2 tq2Var = this.a;
                        Message.obtain(this.b, 8, new br2(tq2Var.a, p, tq2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.rq2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0509a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.repackage.rq2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0510a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0510a(RunnableC0509a runnableC0509a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0509a, swanAppActivity};
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
                            if (rq2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0509a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        de3.a0(new RunnableC0510a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            vq2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            k02.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            k02.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !sq2.g()) {
                        } else {
                            k02.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = wl2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                dd3.f().execute(new RunnableC0509a(this, ae3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rq2 rq2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq2Var, looper};
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
            this.h = rq2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = dr2.a.a("simple_parser");
            this.g = (er2) dr2.a.a("hsv_parser");
        }

        public final void g(tq2 tq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tq2Var) == null) && tq2Var != null && i(tq2Var.a)) {
                de3.e0(new RunnableC0508a(this, tq2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                tq2 tq2Var = this.a;
                return tq2Var != null && tq2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (rq2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (x63.d) {
                            q((ar2) message.obj);
                            return;
                        } else {
                            p((ar2) message.obj);
                            return;
                        }
                    case 2:
                        g((tq2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((zq2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        yq2 yq2Var = (yq2) message.obj;
                        if (yq2Var != null) {
                            if (yq2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((cr2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((br2) message.obj);
                        return;
                    case 9:
                        o((ar2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((ar2) message.obj);
                        return;
                    case 13:
                        q((ar2) message.obj);
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
                tq2 tq2Var = this.a;
                return (tq2Var == null || str == null || !TextUtils.equals(str, tq2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                tq2 tq2Var = this.a;
                if (tq2Var == null || tq2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (rq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(ar2 ar2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ar2Var) == null) {
                this.h.a.removeMessages(2);
                tq2 tq2Var = this.a;
                String str = tq2Var != null ? tq2Var.a : StringUtil.NULL_STRING;
                if (rq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + ar2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                tq2 tq2Var = this.a;
                if (tq2Var != null && tq2Var.c() && this.a.c && h()) {
                    uq2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    uq2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    l02.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                tq2 tq2Var = this.a;
                if (tq2Var == null || !tq2Var.i || tq2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (rq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = wl2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            lf3 loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view2 = loadingView.a) == null || view2.getVisibility() != 0) ? false : true;
            if (rq2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                cc3 cc3Var = new cc3();
                cc3Var.k(5L);
                cc3Var.i(19L);
                cc3Var.f("loading=true");
                j03 a0 = j03.a0();
                gl2.a V = a0 == null ? null : a0.V();
                k73 k73Var = new k73();
                k73Var.p(cc3Var);
                k73Var.r(V);
                k73Var.q(c73.n(i03.J().l()));
                k73Var.m(i03.J().getAppId());
                k73Var.s(String.valueOf(this.b.size()));
                k73Var.n(false);
                c73.R(k73Var);
            }
        }

        public final void o(@NonNull ar2 ar2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, ar2Var) == null) || ar2Var.c() < 0) {
                return;
            }
            sz1 V = wl2.U().V();
            if (V == null || V.k() <= 0) {
                if (rq2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + ar2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, ar2Var), ar2Var.c());
            }
        }

        public final void p(ar2 ar2Var) {
            rz1 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, ar2Var) == null) || (f = sq2.f()) == null) {
                return;
            }
            String s3 = f.s3();
            pm1 n3 = f.n3();
            if (rq2.b && n3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + s3);
            }
            if (n3 == null || i(s3)) {
                return;
            }
            tq2 tq2Var = new tq2(s3, f.l3().a, ar2Var.c(), ar2Var.a());
            this.b.addLast(tq2Var);
            this.a = tq2Var;
            n3.v(xq2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(s3)) {
                this.a.g = this.f.remove(s3).intValue();
            }
            if (this.c || tq2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, tq2Var), this.a.b());
        }

        public final void q(ar2 ar2Var) {
            rz1 f;
            pm1 n3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, ar2Var) == null) || (f = sq2.f()) == null || (n3 = f.n3()) == null) {
                return;
            }
            String s3 = f.s3();
            tq2 tq2Var = new tq2(s3, f.l3().a, ar2Var.c(), ar2Var.a());
            if (!i(s3)) {
                this.b.addLast(tq2Var);
                n3.v(xq2.e());
            }
            this.a = tq2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(s3)) {
                this.a.g = this.f.get(s3).intValue();
            }
            if (this.c || tq2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, tq2Var), this.a.b());
            if (rq2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + s3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(cr2 cr2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cr2Var) == null) || cr2Var == null) {
                return;
            }
            String d = cr2Var.d();
            tq2 tq2Var = null;
            Iterator<tq2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                tq2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    tq2Var = next;
                    break;
                }
            }
            if (cr2Var.e()) {
                if (tq2Var != null) {
                    tq2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (tq2Var != null) {
                tq2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(br2 br2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, br2Var) == null) && br2Var != null && i(br2Var.d())) {
                uq2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = br2Var.e();
                rz1 f = sq2.f();
                View B = wl2.U().B(br2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = sq2.b(e, f, B);
                this.d.c(sq2.d(f));
                this.a.g();
                boolean a = br2Var.a();
                if (!sq2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        uq2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        sq2.i(a, br2Var.d());
                        int i = 19;
                        if (x63.d && !a) {
                            i = 55;
                        }
                        vq2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    uq2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (rq2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + br2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    uq2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (x63.d && !a) {
                        i3 = 56;
                    }
                    vq2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    j12 j12Var = new j12();
                    if (sq2.g()) {
                        if (i2 >= 0) {
                            j12Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            j12Var.d(br2Var.d());
                            this.a.c = true;
                            uq2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        j12Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        j12Var.d(br2Var.d());
                        this.a.c = true;
                        uq2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        y02.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (rq2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                de3.a0(new b(this));
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
                uq2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                wl2.U().u(k63.a(new k63()));
                wl2.U().m(str, k63.a(new k63()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = x83.a().getString("screenshot_upload_switch", "1");
                if (rq2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755341762, "Lcom/repackage/rq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755341762, "Lcom/repackage/rq2;");
                return;
            }
        }
        b = j03.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq2() {
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

    @Override // com.repackage.qq2
    public void a(ar2 ar2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ar2Var) == null) {
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
            if (ar2Var != null) {
                Message.obtain(this.a, ar2Var.b(), ar2Var).sendToTarget();
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
