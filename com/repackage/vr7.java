package com.repackage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx4;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class vr7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vr7 d;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public AtomicBoolean b;
    public AtomicBoolean c;

    /* loaded from: classes7.dex */
    public static class a implements CustomMessageTask.CustomRunnable<wx4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<wx4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    wx4 data = customMessage.getData();
                    String e = data.e();
                    if (data.getType() == 0 && TextUtils.isEmpty(e)) {
                        if (data.f() != null) {
                            data.f().b(null);
                        }
                        return null;
                    } else if (data.getType() == 4) {
                        qi.N(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.f() != null) {
                            data.f().b(null);
                        }
                        return null;
                    } else {
                        MessageManager.getInstance().runTask(2921332, (Class) null);
                        vr7.f().r(data, new c(data));
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(wx4.c cVar);
    }

    /* loaded from: classes7.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wx4 a;

        public c(wx4 wx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx4Var;
        }

        @Override // com.repackage.vr7.b
        public void a(wx4.c cVar) {
            wx4 wx4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (wx4Var = this.a) == null || wx4Var.f() == null) {
                return;
            }
            this.a.f().b(cVar);
        }
    }

    public vr7() {
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
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
    }

    public static vr7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (vr7.class) {
                    if (d == null) {
                        d = new vr7();
                    }
                }
            }
            return d;
        }
        return (vr7) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            n();
        }
    }

    public void a(wx4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (this.a != null) {
                if (cVar == null) {
                    cVar = new wx4.c(false);
                }
                this.a.a(cVar);
            }
            this.a = null;
            this.b.set(false);
        }
    }

    public void b(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
            a(new wx4.a(z, str));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            a(new wx4.c(z));
        }
    }

    public void d(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            wr7.i().k(null);
            a(new wx4.b(z, str));
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            a(new wx4.c(false));
            if (z) {
                p();
            }
        }
    }

    public final ComponentName g() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (BdBaseApplication.getInst() == null || (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) {
                    return null;
                }
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                        return runningTaskInfo.topActivity;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ComponentName) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ComponentName g = g();
            if (g != null) {
                return AuthActivity.class.getName().equals(g.getClassName()) || PassLivenessRecogActivity.class.getName().equals(g.getClassName());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i(wx4 wx4Var, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, wx4Var, bVar) == null) {
            q(bVar);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (wx4Var != null && session != null) {
                if (wx4Var.getType() == 0) {
                    j(wx4Var.e());
                    return;
                } else if (wx4Var.getType() == 1) {
                    l(session.bduss);
                    return;
                } else if (wx4Var.getType() == 2) {
                    k(session.bduss);
                    return;
                } else if (wx4Var.getType() == 3) {
                    m();
                    return;
                } else {
                    return;
                }
            }
            a(null);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, AuthActivity.class);
            intent.putExtra("EXTRA_TYPE", 0);
            intent.putExtra("EXTRA_AUTH_TOKEN", str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, AuthActivity.class);
            intent.putExtra("EXTRA_TYPE", 2);
            intent.putExtra("EXTRA_BDUSS", str);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, AuthActivity.class);
            intent.putExtra("EXTRA_TYPE", 1);
            intent.putExtra("EXTRA_BDUSS", str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, RemindActivity.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void p() {
        jx4 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = un4.e();
            }
            if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                un4.c(currentAccountObj.getID());
                if (ReloginManager.g().i() && !TextUtils.isEmpty(currentAccountObj.getID()) && (b2 = ix4.b()) != null) {
                    b2.c(currentAccountObj);
                }
                ReloginManager.g().f(null);
                return;
            }
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void r(wx4 wx4Var, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, wx4Var, bVar) == null) && this.c.compareAndSet(false, true)) {
            if (this.b.compareAndSet(false, true)) {
                try {
                    i(wx4Var, bVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.b.set(false);
                }
            } else if (!h()) {
                try {
                    i(wx4Var, bVar);
                } catch (Exception unused) {
                    this.b.set(false);
                }
            }
            this.c.set(false);
        }
    }
}
