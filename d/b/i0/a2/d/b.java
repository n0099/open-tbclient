package d.b.i0.a2.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import d.b.b.e.p.l;
import d.b.h0.s.c.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f51942d;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1123b f51943a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f51944b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f51945c = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<j> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<j> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                j data = customMessage.getData();
                String e2 = data.e();
                if (data.g() == 0 && TextUtils.isEmpty(e2)) {
                    if (data.f() != null) {
                        data.f().b(null);
                    }
                    return null;
                } else if (data.g() == 4) {
                    l.L(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                    if (data.f() != null) {
                        data.f().b(null);
                    }
                    return null;
                } else {
                    MessageManager.getInstance().runTask(2921332, (Class) null);
                    b.f().r(data, new c(data));
                }
            }
            return null;
        }
    }

    /* renamed from: d.b.i0.a2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1123b {
        void a(j.c cVar);
    }

    /* loaded from: classes3.dex */
    public static class c implements InterfaceC1123b {

        /* renamed from: a  reason: collision with root package name */
        public j f51946a;

        public c(j jVar) {
            this.f51946a = jVar;
        }

        @Override // d.b.i0.a2.d.b.InterfaceC1123b
        public void a(j.c cVar) {
            j jVar = this.f51946a;
            if (jVar == null || jVar.f() == null) {
                return;
            }
            this.f51946a.f().b(cVar);
        }
    }

    public static b f() {
        if (f51942d == null) {
            synchronized (b.class) {
                if (f51942d == null) {
                    f51942d = new b();
                }
            }
        }
        return f51942d;
    }

    public static void n() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void o() {
        n();
    }

    public void a(j.c cVar) {
        if (this.f51943a != null) {
            if (cVar == null) {
                cVar = new j.c(false);
            }
            this.f51943a.a(cVar);
        }
        this.f51943a = null;
        this.f51944b.set(false);
    }

    public void b(boolean z, String str) {
        a(new j.a(z, str));
    }

    public void c(boolean z) {
        a(new j.c(z));
    }

    public void d(boolean z, String str) {
        d.b.i0.a2.d.c.i().k(null);
        a(new j.b(z, str));
    }

    public void e(boolean z) {
        a(new j.c(false));
        if (z) {
            p();
        }
    }

    public final ComponentName g() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
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

    public final boolean h() {
        ComponentName g2 = g();
        if (g2 != null) {
            return AuthActivity.class.getName().equals(g2.getClassName()) || PassLivenessRecogActivity.class.getName().equals(g2.getClassName());
        }
        return false;
    }

    public final void i(j jVar, InterfaceC1123b interfaceC1123b) {
        q(interfaceC1123b);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (jVar != null && session != null) {
            if (jVar.g() == 0) {
                j(jVar.e());
                return;
            } else if (jVar.g() == 1) {
                l(session.bduss);
                return;
            } else if (jVar.g() == 2) {
                k(session.bduss);
                return;
            } else if (jVar.g() == 3) {
                m();
                return;
            } else {
                return;
            }
        }
        a(null);
    }

    public final void j(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(AuthActivity.EXTRA_TYPE, 0);
        intent.putExtra(AuthActivity.EXTRA_AUTH_TOKEN, str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final void k(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(AuthActivity.EXTRA_TYPE, 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public final void l(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(AuthActivity.EXTRA_TYPE, 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final void m() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public final void p() {
        d.b.h0.s.a.b b2;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = d.b.h0.r.l.c.e();
        }
        if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            d.b.h0.r.l.c.c(currentAccountObj.getID());
            if (ReloginManager.g().i() && !TextUtils.isEmpty(currentAccountObj.getID()) && (b2 = d.b.h0.s.a.a.b()) != null) {
                b2.c(currentAccountObj);
            }
            ReloginManager.g().f(null);
            return;
        }
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public void q(InterfaceC1123b interfaceC1123b) {
        this.f51943a = interfaceC1123b;
    }

    public void r(j jVar, InterfaceC1123b interfaceC1123b) {
        if (this.f51945c.compareAndSet(false, true)) {
            if (this.f51944b.compareAndSet(false, true)) {
                try {
                    i(jVar, interfaceC1123b);
                } catch (Exception e2) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e2.toString());
                    this.f51944b.set(false);
                }
            } else if (!h()) {
                try {
                    i(jVar, interfaceC1123b);
                } catch (Exception unused) {
                    this.f51944b.set(false);
                }
            }
            this.f51945c.set(false);
        }
    }
}
