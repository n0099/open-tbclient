package d.a.j0.a;

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
import com.baidu.tieba.service.AsInstallService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public ActiveCenterData f48735a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48736b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48737c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48738d;

    /* renamed from: e  reason: collision with root package name */
    public final f f48739e;

    /* renamed from: f  reason: collision with root package name */
    public final g f48740f;

    /* renamed from: g  reason: collision with root package name */
    public final i f48741g;

    /* renamed from: h  reason: collision with root package name */
    public final b f48742h;

    /* renamed from: i  reason: collision with root package name */
    public final h f48743i;
    public final d j;
    public final c k;

    /* loaded from: classes3.dex */
    public class b extends e {
        public b(int i2) {
            super(i2);
        }

        @Override // d.a.j0.a.r.e
        public void a() {
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            if (r.this.f48735a == null || r.this.f48735a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{r.this.f48735a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c(int i2) {
            super(i2);
        }

        @Override // d.a.j0.a.r.e
        public void a() {
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            if (r.this.f48735a == null || r.this.f48735a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{r.this.f48735a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class d extends e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f48746e;

            public a(d dVar, TbPageContext tbPageContext) {
                this.f48746e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.j0.r.a0.b.e(this.f48746e.getPageActivity(), 1);
            }
        }

        public d(r rVar, int i2) {
            super(i2);
        }

        @Override // d.a.j0.a.r.e
        public void a() {
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            d.a.c.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public int f48747a;

        public e(int i2) {
            this.f48747a = i2;
        }

        public abstract void a();

        public void b() {
            if (c()) {
                a();
            }
        }

        public boolean c() {
            return (r.this.f48735a == null || r.this.f48735a.mission == null || r.this.f48735a.getCurTaskType() != this.f48747a) ? false : true;
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
        public t f48749c;

        public f(int i2) {
            super(i2);
            this.f48749c = new t();
        }

        @Override // d.a.j0.a.r.e
        public void a() {
            if (this.f48749c == null || r.this.f48735a == null) {
                return;
            }
            this.f48749c.a();
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            if (this.f48749c == null || r.this.f48735a == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{r.this.f48735a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class g extends e {

        /* renamed from: c  reason: collision with root package name */
        public boolean f48751c;

        public g(int i2) {
            super(i2);
            this.f48751c = false;
        }

        @Override // d.a.j0.a.r.e
        public void a() {
            if (!f() || this.f48751c) {
                return;
            }
            r.this.t();
            this.f48751c = true;
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Activity pageActivity = tbPageContext.getPageActivity();
            try {
                Intent intent = new Intent();
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                if (Build.VERSION.SDK_INT >= 9) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, pageActivity.getPackageName(), null));
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
        public h(int i2) {
            super(i2);
        }

        @Override // d.a.j0.a.r.e
        public void a() {
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            if (r.this.f48735a == null || r.this.f48735a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{r.this.f48735a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class i extends e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f48755e;

            public a(i iVar, TbPageContext tbPageContext) {
                this.f48755e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.j0.r.a0.b.e(this.f48755e.getPageActivity(), 1);
            }
        }

        public i(int i2) {
            super(i2);
        }

        @Override // d.a.j0.a.r.e
        public void a() {
            r.this.t();
        }

        @Override // d.a.j0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            d.a.c.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static r f48756a = new r();
    }

    public static r g() {
        return j.f48756a;
    }

    public final void b() {
        d.a.j0.r.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, d.a.j0.r.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public ActiveCenterData c() {
        return this.f48735a;
    }

    public b d() {
        return this.f48742h;
    }

    public c e() {
        return this.k;
    }

    public d f() {
        return this.j;
    }

    public f h() {
        return this.f48739e;
    }

    public g i() {
        return this.f48740f;
    }

    public h j() {
        return this.f48743i;
    }

    public i k() {
        return this.f48741g;
    }

    public void l(TbPageContext<?> tbPageContext) {
        ActiveCenterData activeCenterData = this.f48735a;
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
        ActiveCenterData activeCenterData = this.f48735a;
        return activeCenterData != null && activeCenterData.is_new_window;
    }

    public final boolean n() {
        int i2;
        if (c() != null && (i2 = c().win_jump_time) > 0) {
            if (d.a.j0.a.c.y().u()) {
                return d.a.j0.r.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            d.a.j0.r.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    public boolean o() {
        return this.f48737c;
    }

    public final boolean p() {
        ActiveCenterData activeCenterData = this.f48735a;
        return (activeCenterData == null || activeCenterData.mission == null || !m() || n() || this.f48736b) ? false : true;
    }

    public void q(ActiveCenterData activeCenterData) {
        if (activeCenterData == null) {
            return;
        }
        this.f48735a = activeCenterData;
        Activity b2 = d.a.c.a.b.f().b();
        if (b2 == null || !"MainTabActivity".equals(b2.getClass().getSimpleName())) {
            return;
        }
        r(b2);
    }

    public void r(Context context) {
        if (p()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MissionCustomDialogActivityConfig(context)));
            b();
            d.a.j0.r.d0.b.j().w("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", d.a.j0.a.c.y().D() ? 2 : 1).param("obj_type", 1));
        }
    }

    public void s() {
        if (this.f48738d || !d.a.j0.a.c.y().I()) {
            return;
        }
        this.f48738d = true;
    }

    public void t() {
        ActiveCenterData.ActiveCenterMissionData activeCenterMissionData;
        ActiveCenterData activeCenterData = this.f48735a;
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
        this.f48736b = z;
    }

    public r() {
        this.f48736b = false;
        this.f48737c = true;
        this.f48738d = false;
        this.f48739e = new f(12);
        this.f48740f = new g(6);
        this.f48741g = new i(10);
        this.f48742h = new b(7);
        this.f48743i = new h(5);
        this.j = new d(this, 9);
        this.k = new c(13);
        if (d.a.j0.a.c.y().s()) {
            this.f48737c = d.a.j0.r.d0.b.j().g("key_delete_mission_home_entrance", true);
            return;
        }
        this.f48737c = true;
        d.a.j0.r.d0.b.j().t("key_delete_mission_home_entrance", true);
    }
}
