package d.a.n0.r.c0;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import d.a.n0.a.e0.d;
import d.a.n0.s.g.f;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static a f53439i;
    public static CustomMessageListener j = new b(2921440);

    /* renamed from: a  reason: collision with root package name */
    public int f53440a;

    /* renamed from: b  reason: collision with root package name */
    public int f53441b;

    /* renamed from: c  reason: collision with root package name */
    public int f53442c;

    /* renamed from: d  reason: collision with root package name */
    public int f53443d;

    /* renamed from: e  reason: collision with root package name */
    public int f53444e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f53445f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f53446g = new C1190a(2921406);

    /* renamed from: h  reason: collision with root package name */
    public final d.a.c.e.l.c<d.a.c.k.d.a> f53447h = new c();

    /* renamed from: d.a.n0.r.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1190a extends CustomMessageListener {
        public C1190a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                f.c(((ShareEvent) customResponsedMessage.getData()).channel);
                a.this.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Activity currentActivity;
            if (aVar == null || a.this.f53445f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || a.this.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(a.this.f53445f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
        }
    }

    public static a e() {
        if (f53439i == null) {
            synchronized (a.class) {
                if (f53439i == null) {
                    f53439i = new a();
                }
            }
        }
        return f53439i;
    }

    public final void c() {
        d.a.n0.r.d0.b.j().C("task_share_thread_success_data_total_limit");
        d.a.n0.r.d0.b.j().C("task_share_thread_success_data_mission_id");
        d.a.n0.r.d0.b.j().C("task_share_thread_success_data_action_id");
        d.a.n0.r.d0.b.j().C("task_share_thread_success_data_specific_clear_time");
    }

    public final TbPageContext d(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void f() {
        MessageManager.getInstance().registerListener(this.f53446g);
        MessageManager.getInstance().registerListener(j);
    }

    public void g(MissionInfo missionInfo) {
        if (missionInfo == null || missionInfo.activityid.intValue() == 0 || missionInfo.missionid.intValue() == 0) {
            return;
        }
        this.f53442c = missionInfo.activityid.intValue();
        this.f53440a = missionInfo.missionid.intValue();
        this.f53441b = missionInfo.total_limit.intValue();
        this.f53444e = missionInfo.cleartype.intValue();
        this.f53443d = missionInfo.cleartime.intValue();
        d.a.n0.a.c cVar = new d.a.n0.a.c();
        cVar.X(this.f53443d);
        cVar.Y(this.f53444e);
        d.a.n0.r.d0.b.j().v("task_share_thread_success_data_total_limit", this.f53441b);
        d.a.n0.r.d0.b.j().v("task_share_thread_success_data_mission_id", this.f53440a);
        d.a.n0.r.d0.b.j().v("task_share_thread_success_data_action_id", this.f53442c);
        d.a.n0.r.d0.b.j().w("task_share_thread_success_data_specific_clear_time", cVar.c());
    }

    public final void h(String str) {
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(5);
        completeTaskReqMsg.completeId = str;
        completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
        completeTaskReqMsg.extra = new d.g();
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public void i() {
        TbPageContext d2;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null || (d2 = d(currentActivity)) == null || !d.a.c.a.b.f().h("MainTabActivity")) {
            return;
        }
        d2.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d2.getPageActivity())));
    }

    public void j(d.a.n0.a.c0.b bVar) {
        Activity currentActivity;
        TbPageContext d2;
        if (bVar == null) {
            return;
        }
        ActiveCenterData activeCenterData = bVar.f52409g;
        if ((activeCenterData != null && activeCenterData.is_new_window) || !bVar.f52404b || StringUtils.isNull(bVar.f52405c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d2 = d(currentActivity)) == null) {
            return;
        }
        this.f53445f = bVar.f52408f;
        d.a.c.e.l.d.h().k(this.f53445f.topPicUrl, 10, this.f53447h, 0, 0, d2.getUniqueId(), new Object[0]);
    }

    public void k() {
        int k;
        if (TbadkCoreApplication.isLogin()) {
            int k2 = d.a.n0.r.d0.b.j().k("task_share_thread_success_data_mission_id", 0);
            int k3 = d.a.n0.r.d0.b.j().k("task_share_thread_success_data_action_id", 0);
            long l = d.a.n0.r.d0.b.j().l("task_share_thread_success_data_specific_clear_time", 0L);
            d.a.n0.a.c cVar = new d.a.n0.a.c();
            cVar.d0(l);
            if (cVar.M()) {
                c();
            } else if (k3 == 0 || k2 == 0 || (k = d.a.n0.r.d0.b.j().k("task_share_thread_success_data_total_limit", 0)) <= 0) {
            } else {
                d.a.n0.r.d0.b.j().v("task_share_thread_success_data_total_limit", k - 1);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(k3), String.valueOf(k2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                h(jSONObject.toString());
            }
        }
    }
}
