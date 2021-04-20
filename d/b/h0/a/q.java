package d.b.h0.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MissionCustomDialogActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public ActiveCenterData f50008a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50009b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50010c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50011d;

    /* renamed from: e  reason: collision with root package name */
    public final f f50012e;

    /* renamed from: f  reason: collision with root package name */
    public final g f50013f;

    /* renamed from: g  reason: collision with root package name */
    public final i f50014g;

    /* renamed from: h  reason: collision with root package name */
    public final b f50015h;
    public final h i;
    public final d j;
    public final c k;

    /* loaded from: classes3.dex */
    public class b extends e {
        public b(int i) {
            super(i);
        }

        @Override // d.b.h0.a.q.e
        public void a() {
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            if (q.this.f50008a == null || q.this.f50008a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{q.this.f50008a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c(int i) {
            super(i);
        }

        @Override // d.b.h0.a.q.e
        public void a() {
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            if (q.this.f50008a == null || q.this.f50008a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{q.this.f50008a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class d extends e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f50018e;

            public a(d dVar, TbPageContext tbPageContext) {
                this.f50018e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.r.a0.b.e(this.f50018e.getPageActivity(), 1);
            }
        }

        public d(q qVar, int i) {
            super(i);
        }

        @Override // d.b.h0.a.q.e
        public void a() {
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            d.b.c.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public int f50019a;

        public e(int i) {
            this.f50019a = i;
        }

        public abstract void a();

        public void b() {
            if (c()) {
                a();
            }
        }

        public boolean c() {
            return (q.this.f50008a == null || q.this.f50008a.mission == null || q.this.f50008a.getCurTaskType() != this.f50019a) ? false : true;
        }

        public abstract void d(TbPageContext<?> tbPageContext);

        public void e(TbPageContext<?> tbPageContext) {
            if (c()) {
                d(tbPageContext);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends e {

        /* renamed from: c  reason: collision with root package name */
        public s f50021c;

        public f(int i) {
            super(i);
            this.f50021c = new s();
        }

        @Override // d.b.h0.a.q.e
        public void a() {
            if (this.f50021c == null || q.this.f50008a == null) {
                return;
            }
            this.f50021c.a();
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            if (this.f50021c == null || q.this.f50008a == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{q.this.f50008a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class g extends e {

        /* renamed from: c  reason: collision with root package name */
        public boolean f50023c;

        public g(int i) {
            super(i);
            this.f50023c = false;
        }

        @Override // d.b.h0.a.q.e
        public void a() {
            if (!f() || this.f50023c) {
                return;
            }
            q.this.t();
            this.f50023c = true;
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            Activity pageActivity = tbPageContext.getPageActivity();
            try {
                Intent intent = new Intent();
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                if (Build.VERSION.SDK_INT >= 9) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", pageActivity.getPackageName(), null));
                }
                pageActivity.startActivity(intent);
            } catch (Exception unused) {
            }
        }

        public boolean f() {
            return NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends e {
        public h(int i) {
            super(i);
        }

        @Override // d.b.h0.a.q.e
        public void a() {
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            if (q.this.f50008a == null || q.this.f50008a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{q.this.f50008a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class i extends e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f50027e;

            public a(i iVar, TbPageContext tbPageContext) {
                this.f50027e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.r.a0.b.e(this.f50027e.getPageActivity(), 1);
            }
        }

        public i(int i) {
            super(i);
        }

        @Override // d.b.h0.a.q.e
        public void a() {
            q.this.t();
        }

        @Override // d.b.h0.a.q.e
        public void d(TbPageContext<?> tbPageContext) {
            d.b.c.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static q f50028a = new q();
    }

    public static q g() {
        return j.f50028a;
    }

    public final void b() {
        d.b.h0.r.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, d.b.h0.r.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public ActiveCenterData c() {
        return this.f50008a;
    }

    public b d() {
        return this.f50015h;
    }

    public c e() {
        return this.k;
    }

    public d f() {
        return this.j;
    }

    public f h() {
        return this.f50012e;
    }

    public g i() {
        return this.f50013f;
    }

    public h j() {
        return this.i;
    }

    public i k() {
        return this.f50014g;
    }

    public void l(TbPageContext<?> tbPageContext) {
        ActiveCenterData activeCenterData = this.f50008a;
        if (activeCenterData == null) {
            return;
        }
        int curTaskType = activeCenterData.getCurTaskType();
        if (curTaskType == 12) {
            h().e(tbPageContext);
            h().b();
        } else if (curTaskType == 6) {
            i().e(tbPageContext);
        } else if (curTaskType == 10) {
            k().e(tbPageContext);
            k().b();
        } else if (curTaskType == 7) {
            d().e(tbPageContext);
        } else if (curTaskType == 5) {
            j().e(tbPageContext);
        } else if (curTaskType == 9) {
            f().e(tbPageContext);
        } else if (curTaskType == 13) {
            e().e(tbPageContext);
        }
    }

    public boolean m() {
        ActiveCenterData activeCenterData = this.f50008a;
        return activeCenterData != null && activeCenterData.is_new_window;
    }

    public final boolean n() {
        int i2;
        if (c() != null && (i2 = c().win_jump_time) > 0) {
            if (d.b.h0.a.c.y().u()) {
                return d.b.h0.r.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            d.b.h0.r.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    public boolean o() {
        return this.f50010c;
    }

    public final boolean p() {
        ActiveCenterData activeCenterData = this.f50008a;
        return (activeCenterData == null || activeCenterData.mission == null || !m() || n() || this.f50009b) ? false : true;
    }

    public void q(ActiveCenterData activeCenterData) {
        if (activeCenterData == null) {
            return;
        }
        this.f50008a = activeCenterData;
        Activity b2 = d.b.c.a.b.f().b();
        if (b2 == null || !"MainTabActivity".equals(b2.getClass().getSimpleName())) {
            return;
        }
        r(b2);
    }

    public void r(Context context) {
        if (p()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MissionCustomDialogActivityConfig(context)));
            b();
            d.b.h0.r.d0.b.j().w("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", d.b.h0.a.c.y().D() ? 2 : 1).param("obj_type", 1));
        }
    }

    public void s() {
        if (this.f50011d || !d.b.h0.a.c.y().I()) {
            return;
        }
        this.f50011d = true;
    }

    public void t() {
        ActiveCenterData.ActiveCenterMissionData activeCenterMissionData;
        ActiveCenterData activeCenterData = this.f50008a;
        if (activeCenterData == null || (activeCenterMissionData = activeCenterData.mission) == null) {
            return;
        }
        int i2 = activeCenterMissionData.active_id;
        int i3 = activeCenterMissionData.mission_id;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(String.valueOf(i2), String.valueOf(i3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
        completeTaskReqMsg.completeId = jSONObject2;
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public void u(boolean z) {
        this.f50009b = z;
    }

    public q() {
        this.f50009b = false;
        this.f50010c = true;
        this.f50011d = false;
        this.f50012e = new f(12);
        this.f50013f = new g(6);
        this.f50014g = new i(10);
        this.f50015h = new b(7);
        this.i = new h(5);
        this.j = new d(this, 9);
        this.k = new c(13);
        if (d.b.h0.a.c.y().s()) {
            this.f50010c = d.b.h0.r.d0.b.j().g("key_delete_mission_home_entrance", true);
            return;
        }
        this.f50010c = true;
        d.b.h0.r.d0.b.j().t("key_delete_mission_home_entrance", true);
    }
}
