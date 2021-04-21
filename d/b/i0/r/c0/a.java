package d.b.i0.r.c0;

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
import d.b.i0.a.b0.d;
import d.b.i0.s.g.f;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class a {
    public static a i;
    public static CustomMessageListener j = new b(2921440);

    /* renamed from: a  reason: collision with root package name */
    public int f51178a;

    /* renamed from: b  reason: collision with root package name */
    public int f51179b;

    /* renamed from: c  reason: collision with root package name */
    public int f51180c;

    /* renamed from: d  reason: collision with root package name */
    public int f51181d;

    /* renamed from: e  reason: collision with root package name */
    public int f51182e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f51183f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f51184g = new C1107a(2921406);

    /* renamed from: h  reason: collision with root package name */
    public final d.b.c.e.l.c<d.b.c.j.d.a> f51185h = new c();

    /* renamed from: d.b.i0.r.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1107a extends CustomMessageListener {
        public C1107a(int i) {
            super(i);
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
        public b(int i) {
            super(i);
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
    public class c extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            Activity currentActivity;
            if (aVar == null || a.this.f51183f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || a.this.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(a.this.f51183f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
        }
    }

    public static a e() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    public final void c() {
        d.b.i0.r.d0.b.j().C("task_share_thread_success_data_total_limit");
        d.b.i0.r.d0.b.j().C("task_share_thread_success_data_mission_id");
        d.b.i0.r.d0.b.j().C("task_share_thread_success_data_action_id");
        d.b.i0.r.d0.b.j().C("task_share_thread_success_data_specific_clear_time");
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
        MessageManager.getInstance().registerListener(this.f51184g);
        MessageManager.getInstance().registerListener(j);
    }

    public void g(MissionInfo missionInfo) {
        if (missionInfo == null || missionInfo.activityid.intValue() == 0 || missionInfo.missionid.intValue() == 0) {
            return;
        }
        this.f51180c = missionInfo.activityid.intValue();
        this.f51178a = missionInfo.missionid.intValue();
        this.f51179b = missionInfo.total_limit.intValue();
        this.f51182e = missionInfo.cleartype.intValue();
        this.f51181d = missionInfo.cleartime.intValue();
        d.b.i0.a.b bVar = new d.b.i0.a.b();
        bVar.X(this.f51181d);
        bVar.Y(this.f51182e);
        d.b.i0.r.d0.b.j().v("task_share_thread_success_data_total_limit", this.f51179b);
        d.b.i0.r.d0.b.j().v("task_share_thread_success_data_mission_id", this.f51178a);
        d.b.i0.r.d0.b.j().v("task_share_thread_success_data_action_id", this.f51180c);
        d.b.i0.r.d0.b.j().w("task_share_thread_success_data_specific_clear_time", bVar.c());
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
        if (currentActivity == null || (d2 = d(currentActivity)) == null || !d.b.c.a.b.f().h("MainTabActivity")) {
            return;
        }
        d2.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d2.getPageActivity())));
    }

    public void j(d.b.i0.a.z.b bVar) {
        Activity currentActivity;
        TbPageContext d2;
        if (bVar == null) {
            return;
        }
        ActiveCenterData activeCenterData = bVar.f50395g;
        if ((activeCenterData != null && activeCenterData.is_new_window) || !bVar.f50390b || StringUtils.isNull(bVar.f50391c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d2 = d(currentActivity)) == null) {
            return;
        }
        this.f51183f = bVar.f50394f;
        d.b.c.e.l.d.h().k(this.f51183f.topPicUrl, 10, this.f51185h, 0, 0, d2.getUniqueId(), new Object[0]);
    }

    public void k() {
        int k;
        if (TbadkCoreApplication.isLogin()) {
            int k2 = d.b.i0.r.d0.b.j().k("task_share_thread_success_data_mission_id", 0);
            int k3 = d.b.i0.r.d0.b.j().k("task_share_thread_success_data_action_id", 0);
            long l = d.b.i0.r.d0.b.j().l("task_share_thread_success_data_specific_clear_time", 0L);
            d.b.i0.a.b bVar = new d.b.i0.a.b();
            bVar.d0(l);
            if (bVar.M()) {
                c();
            } else if (k3 == 0 || k2 == 0 || (k = d.b.i0.r.d0.b.j().k("task_share_thread_success_data_total_limit", 0)) <= 0) {
            } else {
                d.b.i0.r.d0.b.j().v("task_share_thread_success_data_total_limit", k - 1);
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
