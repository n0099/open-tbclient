package d.b.i0.f3.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.tblauncher.alarmRemind.AlarmReceiver;
import d.b.b.e.p.j;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static b f54866g;

    /* renamed from: a  reason: collision with root package name */
    public ClientConfigModel f54867a;

    /* renamed from: b  reason: collision with root package name */
    public d f54868b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54869c = false;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.h0.p.a f54870d = new a();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f54871e = new C1255b(2000994);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f54872f = new c(2005016);

    /* loaded from: classes5.dex */
    public class a implements d.b.h0.p.a {
        public a() {
        }

        @Override // d.b.h0.p.a
        public void a(Object obj) {
            b.this.f54869c = false;
            if (obj == null || !(obj instanceof DataRes)) {
                return;
            }
            DataRes dataRes = (DataRes) obj;
            if (dataRes.local_dialog != null) {
                String g2 = d.b.i0.f3.f.a.g(dataRes);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                TbadkSettings.getInst().saveString(b.this.h("remind_recommend_info"), g2);
                TbadkSettings.getInst().saveInt(b.this.h("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                TbadkSettings.getInst().saveString(b.this.h("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                b.this.k(true);
                TbadkSettings.getInst().saveLong(b.this.h("remind_recommend_data_time"), System.currentTimeMillis());
            }
        }

        @Override // d.b.h0.p.a
        public void onError(String str) {
            b.this.f54869c = false;
        }
    }

    /* renamed from: d.b.i0.f3.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1255b extends CustomMessageListener {
        public C1255b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z() && b.this.f()) {
                b.this.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.f()) {
                b.this.k(true);
                b.this.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d() {
            super(2001011);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) == null || data.booleanValue()) {
                return;
            }
            d.b.h0.r.d0.b.i().v("tieba_last_active_time", System.currentTimeMillis());
            if (b.this.f()) {
                b.this.k(true);
                b.this.g();
            }
        }
    }

    public static b i() {
        if (f54866g == null) {
            synchronized (b.class) {
                if (f54866g == null) {
                    f54866g = new b();
                }
            }
        }
        return f54866g;
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        d dVar = new d();
        this.f54868b = dVar;
        baseFragmentActivity.registerListener(dVar);
        baseFragmentActivity.registerListener(this.f54871e);
        baseFragmentActivity.registerListener(this.f54872f);
        this.f54867a = new ClientConfigModel(baseFragmentActivity, this.f54870d);
        d.b.h0.r.d0.b.i().v("tieba_last_active_time", System.currentTimeMillis());
        if (f()) {
            k(true);
            g();
        }
    }

    public final boolean f() {
        if (!TbadkCoreApplication.isLogin()) {
            k(false);
            return false;
        } else if (!d.b.i0.f3.f.a.e()) {
            k(false);
            return false;
        } else if (d.b.i0.f3.f.a.d()) {
            return true;
        } else {
            k(false);
            return false;
        }
    }

    public final void g() {
        if (d.b.i0.f3.f.a.f(TbadkSettings.getInst().loadLong(h("remind_recommend_data_time"), 0L)) || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        j();
    }

    public String h(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    public final void j() {
        ClientConfigModel clientConfigModel = this.f54867a;
        if (clientConfigModel == null || this.f54869c) {
            return;
        }
        this.f54869c = true;
        clientConfigModel.x("local_dialog");
    }

    public final void k(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, d.b.i0.f3.f.a.b() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }
}
