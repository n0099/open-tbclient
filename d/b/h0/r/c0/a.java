package d.b.h0.r.c0;

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
import d.b.h0.a.b0.d;
import d.b.h0.s.g.f;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class a {
    public static a i;
    public static CustomMessageListener j = new b(2921440);

    /* renamed from: a  reason: collision with root package name */
    public int f50435a;

    /* renamed from: b  reason: collision with root package name */
    public int f50436b;

    /* renamed from: c  reason: collision with root package name */
    public int f50437c;

    /* renamed from: d  reason: collision with root package name */
    public int f50438d;

    /* renamed from: e  reason: collision with root package name */
    public int f50439e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f50440f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f50441g = new C1072a(2921406);

    /* renamed from: h  reason: collision with root package name */
    public final d.b.b.e.l.c<d.b.b.j.d.a> f50442h = new c();

    /* renamed from: d.b.h0.r.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1072a extends CustomMessageListener {
        public C1072a(int i) {
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
    public class c extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            Activity currentActivity;
            if (aVar == null || a.this.f50440f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || a.this.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(a.this.f50440f);
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
        d.b.h0.r.d0.b.i().B("task_share_thread_success_data_total_limit");
        d.b.h0.r.d0.b.i().B("task_share_thread_success_data_mission_id");
        d.b.h0.r.d0.b.i().B("task_share_thread_success_data_action_id");
        d.b.h0.r.d0.b.i().B("task_share_thread_success_data_specific_clear_time");
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
        MessageManager.getInstance().registerListener(this.f50441g);
        MessageManager.getInstance().registerListener(j);
    }

    public void g(MissionInfo missionInfo) {
        if (missionInfo == null || missionInfo.activityid.intValue() == 0 || missionInfo.missionid.intValue() == 0) {
            return;
        }
        this.f50437c = missionInfo.activityid.intValue();
        this.f50435a = missionInfo.missionid.intValue();
        this.f50436b = missionInfo.total_limit.intValue();
        this.f50439e = missionInfo.cleartype.intValue();
        this.f50438d = missionInfo.cleartime.intValue();
        d.b.h0.a.b bVar = new d.b.h0.a.b();
        bVar.X(this.f50438d);
        bVar.Y(this.f50439e);
        d.b.h0.r.d0.b.i().u("task_share_thread_success_data_total_limit", this.f50436b);
        d.b.h0.r.d0.b.i().u("task_share_thread_success_data_mission_id", this.f50435a);
        d.b.h0.r.d0.b.i().u("task_share_thread_success_data_action_id", this.f50437c);
        d.b.h0.r.d0.b.i().v("task_share_thread_success_data_specific_clear_time", bVar.c());
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
        if (currentActivity == null || (d2 = d(currentActivity)) == null || !d.b.b.a.b.f().h("MainTabActivity")) {
            return;
        }
        d2.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d2.getPageActivity())));
    }

    public void j(d.b.h0.a.z.b bVar) {
        Activity currentActivity;
        TbPageContext d2;
        if (bVar == null) {
            return;
        }
        ActiveCenterData activeCenterData = bVar.f49667g;
        if ((activeCenterData != null && activeCenterData.is_new_window) || !bVar.f49662b || StringUtils.isNull(bVar.f49663c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d2 = d(currentActivity)) == null) {
            return;
        }
        this.f50440f = bVar.f49666f;
        d.b.b.e.l.d.h().k(this.f50440f.topPicUrl, 10, this.f50442h, 0, 0, d2.getUniqueId(), new Object[0]);
    }

    public void k() {
        int j2;
        if (TbadkCoreApplication.isLogin()) {
            int j3 = d.b.h0.r.d0.b.i().j("task_share_thread_success_data_mission_id", 0);
            int j4 = d.b.h0.r.d0.b.i().j("task_share_thread_success_data_action_id", 0);
            long k = d.b.h0.r.d0.b.i().k("task_share_thread_success_data_specific_clear_time", 0L);
            d.b.h0.a.b bVar = new d.b.h0.a.b();
            bVar.d0(k);
            if (bVar.M()) {
                c();
            } else if (j4 == 0 || j3 == 0 || (j2 = d.b.h0.r.d0.b.i().j("task_share_thread_success_data_total_limit", 0)) <= 0) {
            } else {
                d.b.h0.r.d0.b.i().u("task_share_thread_success_data_total_limit", j2 - 1);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(j4), String.valueOf(j3));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                h(jSONObject.toString());
            }
        }
    }
}
