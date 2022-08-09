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
import com.repackage.tr2;
import com.repackage.wl2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes6.dex */
public class hr2 extends HandlerThread implements gr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public jr2 a;
        public Deque<jr2> b;
        public boolean c;
        public tr2 d;
        public int e;
        public HashMap<String, Integer> f;
        public ur2 g;
        public final /* synthetic */ hr2 h;

        /* renamed from: com.repackage.hr2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0492a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jr2 a;
            public final /* synthetic */ a b;

            public RunnableC0492a(a aVar, jr2 jr2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jr2Var};
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
                this.a = jr2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = qe3.p();
                    if (p != null) {
                        jr2 jr2Var = this.a;
                        Message.obtain(this.b, 8, new rr2(jr2Var.a, p, jr2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.hr2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0493a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.repackage.hr2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0494a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0494a(RunnableC0493a runnableC0493a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0493a, swanAppActivity};
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
                            if (hr2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0493a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        te3.a0(new RunnableC0494a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            lr2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            a12.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            a12.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !ir2.g()) {
                        } else {
                            a12.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = mm2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                td3.f().execute(new RunnableC0493a(this, qe3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hr2 hr2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hr2Var, looper};
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
            this.h = hr2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = tr2.a.a("simple_parser");
            this.g = (ur2) tr2.a.a("hsv_parser");
        }

        public final void g(jr2 jr2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jr2Var) == null) && jr2Var != null && i(jr2Var.a)) {
                te3.e0(new RunnableC0492a(this, jr2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                jr2 jr2Var = this.a;
                return jr2Var != null && jr2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (hr2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (n73.d) {
                            q((qr2) message.obj);
                            return;
                        } else {
                            p((qr2) message.obj);
                            return;
                        }
                    case 2:
                        g((jr2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((pr2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        or2 or2Var = (or2) message.obj;
                        if (or2Var != null) {
                            if (or2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((sr2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((rr2) message.obj);
                        return;
                    case 9:
                        o((qr2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((qr2) message.obj);
                        return;
                    case 13:
                        q((qr2) message.obj);
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
                jr2 jr2Var = this.a;
                return (jr2Var == null || str == null || !TextUtils.equals(str, jr2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                jr2 jr2Var = this.a;
                if (jr2Var == null || jr2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (hr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(qr2 qr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, qr2Var) == null) {
                this.h.a.removeMessages(2);
                jr2 jr2Var = this.a;
                String str = jr2Var != null ? jr2Var.a : StringUtil.NULL_STRING;
                if (hr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + qr2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                jr2 jr2Var = this.a;
                if (jr2Var != null && jr2Var.c() && this.a.c && h()) {
                    kr2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    kr2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    b12.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                jr2 jr2Var = this.a;
                if (jr2Var == null || !jr2Var.i || jr2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (hr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = mm2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            bg3 T = activity.T();
            boolean z = (T == null || (view2 = T.a) == null || view2.getVisibility() != 0) ? false : true;
            if (hr2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                sc3 sc3Var = new sc3();
                sc3Var.k(5L);
                sc3Var.i(19L);
                sc3Var.f("loading=true");
                z03 b0 = z03.b0();
                wl2.a W = b0 == null ? null : b0.W();
                a83 a83Var = new a83();
                a83Var.p(sc3Var);
                a83Var.r(W);
                a83Var.q(s73.n(y03.K().k()));
                a83Var.m(y03.K().getAppId());
                a83Var.s(String.valueOf(this.b.size()));
                a83Var.n(false);
                s73.R(a83Var);
            }
        }

        public final void o(@NonNull qr2 qr2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, qr2Var) == null) || qr2Var.c() < 0) {
                return;
            }
            i02 V = mm2.U().V();
            if (V == null || V.k() <= 0) {
                if (hr2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + qr2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, qr2Var), qr2Var.c());
            }
        }

        public final void p(qr2 qr2Var) {
            h02 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, qr2Var) == null) || (f = ir2.f()) == null) {
                return;
            }
            String t3 = f.t3();
            fn1 o3 = f.o3();
            if (hr2.b && o3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
            }
            if (o3 == null || i(t3)) {
                return;
            }
            jr2 jr2Var = new jr2(t3, f.m3().a, qr2Var.c(), qr2Var.a());
            this.b.addLast(jr2Var);
            this.a = jr2Var;
            o3.s(nr2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.remove(t3).intValue();
            }
            if (this.c || jr2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, jr2Var), this.a.b());
        }

        public final void q(qr2 qr2Var) {
            h02 f;
            fn1 o3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, qr2Var) == null) || (f = ir2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            jr2 jr2Var = new jr2(t3, f.m3().a, qr2Var.c(), qr2Var.a());
            if (!i(t3)) {
                this.b.addLast(jr2Var);
                o3.s(nr2.e());
            }
            this.a = jr2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (this.c || jr2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, jr2Var), this.a.b());
            if (hr2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(sr2 sr2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, sr2Var) == null) || sr2Var == null) {
                return;
            }
            String d = sr2Var.d();
            jr2 jr2Var = null;
            Iterator<jr2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                jr2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    jr2Var = next;
                    break;
                }
            }
            if (sr2Var.e()) {
                if (jr2Var != null) {
                    jr2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (jr2Var != null) {
                jr2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(rr2 rr2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, rr2Var) == null) && rr2Var != null && i(rr2Var.d())) {
                kr2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = rr2Var.e();
                h02 f = ir2.f();
                View B = mm2.U().B(rr2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = ir2.b(e, f, B);
                this.d.c(ir2.d(f));
                this.a.g();
                boolean a = rr2Var.a();
                if (!ir2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        kr2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        ir2.i(a, rr2Var.d());
                        int i = 19;
                        if (n73.d && !a) {
                            i = 55;
                        }
                        lr2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    kr2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (hr2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + rr2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    kr2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (n73.d && !a) {
                        i3 = 56;
                    }
                    lr2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    z12 z12Var = new z12();
                    if (ir2.g()) {
                        if (i2 >= 0) {
                            z12Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            z12Var.d(rr2Var.d());
                            this.a.c = true;
                            kr2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        z12Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        z12Var.d(rr2Var.d());
                        this.a.c = true;
                        kr2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        o12.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (hr2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                te3.a0(new b(this));
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
                kr2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                mm2.U().u(a73.a(new a73()));
                mm2.U().m(str, a73.a(new a73()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = n93.a().getString("screenshot_upload_switch", "1");
                if (hr2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638711, "Lcom/repackage/hr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638711, "Lcom/repackage/hr2;");
                return;
            }
        }
        b = z03.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hr2() {
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

    @Override // com.repackage.gr2
    public void a(qr2 qr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qr2Var) == null) {
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
            if (qr2Var != null) {
                Message.obtain(this.a, qr2Var.b(), qr2Var).sendToTarget();
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
