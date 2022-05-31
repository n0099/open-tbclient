package com.repackage;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.mutiprocess.event.AppBackgroundSwitchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class rb5 {
    public static /* synthetic */ Interceptable $ic;
    public static rb5 i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public int d;
    public AtomicBoolean e;
    public boolean f;
    public Handler g;
    public Runnable h;

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rb5 a;

        public a(rb5 rb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rb5Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 5) {
                    return false;
                }
                if (Boolean.TRUE.equals(message.obj)) {
                    this.a.o();
                    this.a.k();
                    return false;
                }
                this.a.l();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rb5 a;

        public b(rb5 rb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rb5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rb5 rb5Var = this.a;
                if (rb5Var.e == null) {
                    rb5Var.e = new AtomicBoolean(false);
                }
                if (this.a.e.get()) {
                    return;
                }
                this.a.e.set(true);
                if (this.a.j(true)) {
                    TbadkCoreApplication.getInst().fixOppoTimeout();
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.TRUE));
                    a55.i(new AppBackgroundSwitchEvent(true));
                    TiebaStaticHelper.setCurrentActivity(null);
                    TiebaStatic.save();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(rb5 rb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nm4.c().b();
            }
        }
    }

    public rb5() {
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
        this.a = 0;
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
        this.e = null;
        this.f = false;
        this.g = new Handler(Looper.getMainLooper(), new a(this));
        this.h = new b(this);
    }

    public static rb5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (rb5.class) {
                    if (i == null) {
                        i = new rb5();
                    }
                }
            }
            return i;
        }
        return (rb5) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d++;
            n();
            nb.b().a("CornerManager", new c(this));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d--;
            n();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (j(false)) {
                if (this.f) {
                    Intent intent = new Intent("com.tieba.baidu.notifyprocess");
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra("message", true);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                    return false;
                }
                return true;
            }
            Intent intent2 = new Intent("com.tieba.baidu.notifyprocess");
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent2.putExtra("message", false);
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = 0;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AtomicBoolean atomicBoolean = this.e;
            if (atomicBoolean == null) {
                return true;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public boolean j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? TbadkCoreApplication.getInst().isMainProcess(z) : invokeZ.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AsyncService.INSTANCE.sendRunnable(this.h);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AsyncService.INSTANCE.removeRunnable(this.h);
            if (this.e == null) {
                this.e = new AtomicBoolean(true);
            }
            if (this.e.get()) {
                this.e.set(false);
                this.a++;
                if (j(true)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.b;
                    if ((currentTimeMillis - j > 3600000 || j == 0) && PermissionUtil.isAgreePrivacyPolicy()) {
                        q();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.FALSE));
                    a55.i(new AppBackgroundSwitchEvent(false));
                }
            }
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f = !z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.d < 0) {
                this.d = 0;
            }
            if (j(true) && this.c == 0 && this.d > 0) {
                this.c = System.nanoTime();
            }
            this.g.removeMessages(5);
            if (this.d == 0) {
                SpeedStats.getInstance().onAppBackground();
                p();
                return;
            }
            AtomicBoolean atomicBoolean = this.e;
            if (atomicBoolean == null || atomicBoolean.get()) {
                SpeedStats.getInstance().onAppForeground();
                Handler handler = this.g;
                handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.d == 0 && this.c > 0) {
            long nanoTime = ((System.nanoTime() - this.c) / 1000000) / 1000;
            if (nanoTime >= TbadkCoreApplication.getInst().getUseTimeInterval()) {
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    new PvThread(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                }
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
            }
            this.c = 0L;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Handler handler = this.g;
            handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.TRUE), 1000L);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b = System.currentTimeMillis();
            new EnterForePvThread().start();
        }
    }
}
