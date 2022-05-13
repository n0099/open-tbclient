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
import com.repackage.or2;
import com.repackage.rl2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes5.dex */
public class cr2 extends HandlerThread implements br2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public er2 a;
        public Deque<er2> b;
        public boolean c;
        public or2 d;
        public int e;
        public HashMap<String, Integer> f;
        public pr2 g;
        public final /* synthetic */ cr2 h;

        /* renamed from: com.repackage.cr2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0392a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ er2 a;
            public final /* synthetic */ a b;

            public RunnableC0392a(a aVar, er2 er2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, er2Var};
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
                this.a = er2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = le3.p();
                    if (p != null) {
                        er2 er2Var = this.a;
                        Message.obtain(this.b, 8, new mr2(er2Var.a, p, er2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.cr2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0393a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.repackage.cr2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public class RunnableC0394a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0394a(RunnableC0393a runnableC0393a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0393a, swanAppActivity};
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
                            if (cr2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0393a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        oe3.a0(new RunnableC0394a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            gr2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            v02.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            v02.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !dr2.g()) {
                        } else {
                            v02.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                od3.f().execute(new RunnableC0393a(this, le3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cr2 cr2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr2Var, looper};
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
            this.h = cr2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = or2.a.a("simple_parser");
            this.g = (pr2) or2.a.a("hsv_parser");
        }

        public final void g(er2 er2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, er2Var) == null) && er2Var != null && i(er2Var.a)) {
                oe3.e0(new RunnableC0392a(this, er2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                er2 er2Var = this.a;
                return er2Var != null && er2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (cr2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (i73.d) {
                            q((lr2) message.obj);
                            return;
                        } else {
                            p((lr2) message.obj);
                            return;
                        }
                    case 2:
                        g((er2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((kr2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        jr2 jr2Var = (jr2) message.obj;
                        if (jr2Var != null) {
                            if (jr2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((nr2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((mr2) message.obj);
                        return;
                    case 9:
                        o((lr2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((lr2) message.obj);
                        return;
                    case 13:
                        q((lr2) message.obj);
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
                er2 er2Var = this.a;
                return (er2Var == null || str == null || !TextUtils.equals(str, er2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                er2 er2Var = this.a;
                if (er2Var == null || er2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (cr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(lr2 lr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, lr2Var) == null) {
                this.h.a.removeMessages(2);
                er2 er2Var = this.a;
                String str = er2Var != null ? er2Var.a : StringUtil.NULL_STRING;
                if (cr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + lr2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                er2 er2Var = this.a;
                if (er2Var != null && er2Var.c() && this.a.c && h()) {
                    fr2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    fr2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    w02.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                er2 er2Var = this.a;
                if (er2Var == null || !er2Var.i || er2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (cr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            wf3 loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view2 = loadingView.a) == null || view2.getVisibility() != 0) ? false : true;
            if (cr2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                nc3 nc3Var = new nc3();
                nc3Var.k(5L);
                nc3Var.i(19L);
                nc3Var.f("loading=true");
                u03 a0 = u03.a0();
                rl2.a V = a0 == null ? null : a0.V();
                v73 v73Var = new v73();
                v73Var.p(nc3Var);
                v73Var.r(V);
                v73Var.q(n73.n(t03.J().l()));
                v73Var.m(t03.J().getAppId());
                v73Var.s(String.valueOf(this.b.size()));
                v73Var.n(false);
                n73.R(v73Var);
            }
        }

        public final void o(@NonNull lr2 lr2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, lr2Var) == null) || lr2Var.c() < 0) {
                return;
            }
            d02 V = hm2.U().V();
            if (V == null || V.k() <= 0) {
                if (cr2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + lr2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, lr2Var), lr2Var.c());
            }
        }

        public final void p(lr2 lr2Var) {
            c02 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, lr2Var) == null) || (f = dr2.f()) == null) {
                return;
            }
            String s3 = f.s3();
            an1 n3 = f.n3();
            if (cr2.b && n3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + s3);
            }
            if (n3 == null || i(s3)) {
                return;
            }
            er2 er2Var = new er2(s3, f.l3().a, lr2Var.c(), lr2Var.a());
            this.b.addLast(er2Var);
            this.a = er2Var;
            n3.v(ir2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(s3)) {
                this.a.g = this.f.remove(s3).intValue();
            }
            if (this.c || er2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, er2Var), this.a.b());
        }

        public final void q(lr2 lr2Var) {
            c02 f;
            an1 n3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, lr2Var) == null) || (f = dr2.f()) == null || (n3 = f.n3()) == null) {
                return;
            }
            String s3 = f.s3();
            er2 er2Var = new er2(s3, f.l3().a, lr2Var.c(), lr2Var.a());
            if (!i(s3)) {
                this.b.addLast(er2Var);
                n3.v(ir2.e());
            }
            this.a = er2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(s3)) {
                this.a.g = this.f.get(s3).intValue();
            }
            if (this.c || er2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, er2Var), this.a.b());
            if (cr2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + s3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(nr2 nr2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, nr2Var) == null) || nr2Var == null) {
                return;
            }
            String d = nr2Var.d();
            er2 er2Var = null;
            Iterator<er2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                er2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    er2Var = next;
                    break;
                }
            }
            if (nr2Var.e()) {
                if (er2Var != null) {
                    er2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (er2Var != null) {
                er2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(mr2 mr2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, mr2Var) == null) && mr2Var != null && i(mr2Var.d())) {
                fr2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = mr2Var.e();
                c02 f = dr2.f();
                View B = hm2.U().B(mr2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = dr2.b(e, f, B);
                this.d.c(dr2.d(f));
                this.a.g();
                boolean a = mr2Var.a();
                if (!dr2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        fr2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        dr2.i(a, mr2Var.d());
                        int i = 19;
                        if (i73.d && !a) {
                            i = 55;
                        }
                        gr2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    fr2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (cr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + mr2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    fr2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (i73.d && !a) {
                        i3 = 56;
                    }
                    gr2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    u12 u12Var = new u12();
                    if (dr2.g()) {
                        if (i2 >= 0) {
                            u12Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            u12Var.d(mr2Var.d());
                            this.a.c = true;
                            fr2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        u12Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        u12Var.d(mr2Var.d());
                        this.a.c = true;
                        fr2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        j12.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (cr2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                oe3.a0(new b(this));
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
                fr2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                hm2.U().u(v63.a(new v63()));
                hm2.U().m(str, v63.a(new v63()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = i93.a().getString("screenshot_upload_switch", "1");
                if (cr2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755787666, "Lcom/repackage/cr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755787666, "Lcom/repackage/cr2;");
                return;
            }
        }
        b = u03.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr2() {
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

    @Override // com.repackage.br2
    public void a(lr2 lr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lr2Var) == null) {
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
            if (lr2Var != null) {
                Message.obtain(this.a, lr2Var.b(), lr2Var).sendToTarget();
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
