package d.a.m0.a;

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
public class s {

    /* renamed from: a  reason: collision with root package name */
    public ActiveCenterData f52433a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52434b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52435c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52436d;

    /* renamed from: e  reason: collision with root package name */
    public final f f52437e;

    /* renamed from: f  reason: collision with root package name */
    public final g f52438f;

    /* renamed from: g  reason: collision with root package name */
    public final i f52439g;

    /* renamed from: h  reason: collision with root package name */
    public final b f52440h;

    /* renamed from: i  reason: collision with root package name */
    public final h f52441i;
    public final d j;
    public final c k;

    /* loaded from: classes3.dex */
    public class b extends e {
        public b(int i2) {
            super(i2);
        }

        @Override // d.a.m0.a.s.e
        public void a() {
        }

        @Override // d.a.m0.a.s.e
        public void d(TbPageContext<?> tbPageContext) {
            if (s.this.f52433a == null || s.this.f52433a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{s.this.f52433a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c(int i2) {
            super(i2);
        }

        @Override // d.a.m0.a.s.e
        public void a() {
        }

        @Override // d.a.m0.a.s.e
        public void d(TbPageContext<?> tbPageContext) {
            if (s.this.f52433a == null || s.this.f52433a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{s.this.f52433a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class d extends e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f52444e;

            public a(d dVar, TbPageContext tbPageContext) {
                this.f52444e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.r.a0.b.e(this.f52444e.getPageActivity(), 1);
            }
        }

        public d(s sVar, int i2) {
            super(i2);
        }

        @Override // d.a.m0.a.s.e
        public void a() {
        }

        @Override // d.a.m0.a.s.e
        public void d(TbPageContext<?> tbPageContext) {
            d.a.c.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public int f52445a;

        public e(int i2) {
            this.f52445a = i2;
        }

        public abstract void a();

        public void b() {
            if (c()) {
                a();
            }
        }

        public boolean c() {
            return (s.this.f52433a == null || s.this.f52433a.mission == null || s.this.f52433a.getCurTaskType() != this.f52445a) ? false : true;
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
        public u f52447c;

        public f(int i2) {
            super(i2);
            this.f52447c = new u();
        }

        @Override // d.a.m0.a.s.e
        public void a() {
            if (this.f52447c == null || s.this.f52433a == null) {
                return;
            }
            this.f52447c.a();
        }

        @Override // d.a.m0.a.s.e
        public void d(TbPageContext<?> tbPageContext) {
            if (this.f52447c == null || s.this.f52433a == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{s.this.f52433a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class g extends e {

        /* renamed from: c  reason: collision with root package name */
        public boolean f52449c;

        public g(int i2) {
            super(i2);
            this.f52449c = false;
        }

        @Override // d.a.m0.a.s.e
        public void a() {
            if (!f() || this.f52449c) {
                return;
            }
            s.this.t();
            this.f52449c = true;
        }

        @Override // d.a.m0.a.s.e
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

        @Override // d.a.m0.a.s.e
        public void a() {
        }

        @Override // d.a.m0.a.s.e
        public void d(TbPageContext<?> tbPageContext) {
            if (s.this.f52433a == null || s.this.f52433a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{s.this.f52433a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class i extends e {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f52453e;

            public a(i iVar, TbPageContext tbPageContext) {
                this.f52453e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.r.a0.b.e(this.f52453e.getPageActivity(), 1);
            }
        }

        public i(int i2) {
            super(i2);
        }

        @Override // d.a.m0.a.s.e
        public void a() {
            s.this.t();
        }

        @Override // d.a.m0.a.s.e
        public void d(TbPageContext<?> tbPageContext) {
            d.a.c.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static s f52454a = new s();
    }

    public static s g() {
        return j.f52454a;
    }

    public final void b() {
        d.a.m0.r.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, d.a.m0.r.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
    }

    public ActiveCenterData c() {
        return this.f52433a;
    }

    public b d() {
        return this.f52440h;
    }

    public c e() {
        return this.k;
    }

    public d f() {
        return this.j;
    }

    public f h() {
        return this.f52437e;
    }

    public g i() {
        return this.f52438f;
    }

    public h j() {
        return this.f52441i;
    }

    public i k() {
        return this.f52439g;
    }

    public void l(TbPageContext<?> tbPageContext) {
        ActiveCenterData activeCenterData = this.f52433a;
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
        ActiveCenterData activeCenterData = this.f52433a;
        return activeCenterData != null && activeCenterData.is_new_window;
    }

    public final boolean n() {
        int i2;
        if (c() != null && (i2 = c().win_jump_time) > 0) {
            if (d.a.m0.a.d.y().u()) {
                return d.a.m0.r.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
            }
            d.a.m0.r.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
            return false;
        }
        return true;
    }

    public boolean o() {
        return this.f52435c;
    }

    public final boolean p() {
        ActiveCenterData activeCenterData = this.f52433a;
        return (activeCenterData == null || activeCenterData.mission == null || !m() || n() || this.f52434b) ? false : true;
    }

    public void q(ActiveCenterData activeCenterData) {
        if (activeCenterData == null) {
            return;
        }
        this.f52433a = activeCenterData;
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
            d.a.m0.r.d0.b.j().w("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", d.a.m0.a.d.y().D() ? 2 : 1).param("obj_type", 1));
        }
    }

    public void s() {
        if (this.f52436d || !d.a.m0.a.d.y().I()) {
            return;
        }
        this.f52436d = true;
    }

    public void t() {
        ActiveCenterData.ActiveCenterMissionData activeCenterMissionData;
        ActiveCenterData activeCenterData = this.f52433a;
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
        this.f52434b = z;
    }

    public s() {
        this.f52434b = false;
        this.f52435c = true;
        this.f52436d = false;
        this.f52437e = new f(12);
        this.f52438f = new g(6);
        this.f52439g = new i(10);
        this.f52440h = new b(7);
        this.f52441i = new h(5);
        this.j = new d(this, 9);
        this.k = new c(13);
        if (d.a.m0.a.d.y().s()) {
            this.f52435c = d.a.m0.r.d0.b.j().g("key_delete_mission_home_entrance", true);
            return;
        }
        this.f52435c = true;
        d.a.m0.r.d0.b.j().t("key_delete_mission_home_entrance", true);
    }
}
