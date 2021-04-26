package d.a.j0.b2.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
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
import d.a.i0.s.c.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f51536d;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1144b f51537a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f51538b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f51539c = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<l> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<l> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                l data = customMessage.getData();
                String e2 = data.e();
                if (data.g() == 0 && TextUtils.isEmpty(e2)) {
                    if (data.f() != null) {
                        data.f().b(null);
                    }
                    return null;
                } else if (data.g() == 4) {
                    d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
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

    /* renamed from: d.a.j0.b2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1144b {
        void a(l.c cVar);
    }

    /* loaded from: classes3.dex */
    public static class c implements InterfaceC1144b {

        /* renamed from: a  reason: collision with root package name */
        public l f51540a;

        public c(l lVar) {
            this.f51540a = lVar;
        }

        @Override // d.a.j0.b2.d.b.InterfaceC1144b
        public void a(l.c cVar) {
            l lVar = this.f51540a;
            if (lVar == null || lVar.f() == null) {
                return;
            }
            this.f51540a.f().b(cVar);
        }
    }

    public static b f() {
        if (f51536d == null) {
            synchronized (b.class) {
                if (f51536d == null) {
                    f51536d = new b();
                }
            }
        }
        return f51536d;
    }

    public static void n() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void o() {
        n();
    }

    public void a(l.c cVar) {
        if (this.f51537a != null) {
            if (cVar == null) {
                cVar = new l.c(false);
            }
            this.f51537a.a(cVar);
        }
        this.f51537a = null;
        this.f51538b.set(false);
    }

    public void b(boolean z, String str) {
        a(new l.a(z, str));
    }

    public void c(boolean z) {
        a(new l.c(z));
    }

    public void d(boolean z, String str) {
        d.a.j0.b2.d.c.i().k(null);
        a(new l.b(z, str));
    }

    public void e(boolean z) {
        a(new l.c(false));
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

    public final void i(l lVar, InterfaceC1144b interfaceC1144b) {
        q(interfaceC1144b);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (lVar != null && session != null) {
            if (lVar.g() == 0) {
                j(lVar.e());
                return;
            } else if (lVar.g() == 1) {
                l(session.bduss);
                return;
            } else if (lVar.g() == 2) {
                k(session.bduss);
                return;
            } else if (lVar.g() == 3) {
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public final void k(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(AuthActivity.EXTRA_TYPE, 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public final void l(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(AuthActivity.EXTRA_TYPE, 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public final void m() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public final void p() {
        d.a.i0.s.a.b b2;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = d.a.i0.r.l.c.e();
        }
        if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            d.a.i0.r.l.c.c(currentAccountObj.getID());
            if (ReloginManager.g().i() && !TextUtils.isEmpty(currentAccountObj.getID()) && (b2 = d.a.i0.s.a.a.b()) != null) {
                b2.c(currentAccountObj);
            }
            ReloginManager.g().f(null);
            return;
        }
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public void q(InterfaceC1144b interfaceC1144b) {
        this.f51537a = interfaceC1144b;
    }

    public void r(l lVar, InterfaceC1144b interfaceC1144b) {
        if (this.f51539c.compareAndSet(false, true)) {
            if (this.f51538b.compareAndSet(false, true)) {
                try {
                    i(lVar, interfaceC1144b);
                } catch (Exception e2) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e2.toString());
                    this.f51538b.set(false);
                }
            } else if (!h()) {
                try {
                    i(lVar, interfaceC1144b);
                } catch (Exception unused) {
                    this.f51538b.set(false);
                }
            }
            this.f51539c.set(false);
        }
    }
}
