package d.a.o0.w2.b.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import d.a.c.a.d;
/* loaded from: classes5.dex */
public class c extends d<SecretSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f66375a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f66376b;

    /* renamed from: c  reason: collision with root package name */
    public View f66377c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f66378d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f66379e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f66380f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66381g;

    /* renamed from: h  reason: collision with root package name */
    public View f66382h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66383i;
    public TbSettingTextTipView j;
    public SecretSettingActivity k;
    public View l;
    public String[] m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public View.OnClickListener p;
    public b q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.q == null) {
                return;
            }
            if (view == c.this.f66377c) {
                c.this.q.onBackPressed();
            } else if (view == c.this.f66378d) {
                c.this.q.h();
            } else if (view == c.this.f66379e) {
                c.this.q.g();
            } else if (view == c.this.f66381g) {
                c.this.q.c();
            } else if (view == c.this.j) {
                c.this.q.e();
            } else if (view == c.this.f66383i) {
                c.this.q.a();
            } else if (view == c.this.n) {
                c.this.q.f();
            } else if (view == c.this.f66380f) {
                c.this.q.d();
            } else if (view == c.this.o) {
                c.this.q.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.f66375a = null;
        this.p = new a();
        this.k = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        o(secretSettingActivity);
    }

    public final void o(SecretSettingActivity secretSettingActivity) {
        this.f66376b = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.f66375a = navigationBar;
        this.f66377c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66375a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.f66378d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.f66379e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.f66380f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.f66381g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.f66383i = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.f66382h = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.f66377c.setOnClickListener(this.p);
        this.f66378d.setOnClickListener(this.p);
        this.j.setOnClickListener(this.p);
        this.f66379e.setOnClickListener(this.p);
        this.f66380f.setOnClickListener(this.p);
        this.f66381g.setOnClickListener(this.p);
        this.f66383i.setOnClickListener(this.p);
        this.l = this.k.findViewById(R.id.privacy_setting_container);
        this.m = this.k.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.n = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.p);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
        this.o = tbSettingTextTipView2;
        tbSettingTextTipView2.setOnClickListener(this.p);
        UserData b2 = d.a.n0.z.b.a().b();
        if (b2 != null && b2.getBazhuGradeData() != null && !StringUtils.isNull(b2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(b2.getBazhuGradeData().getLevel())) {
            this.f66380f.setVisibility(0);
        } else {
            this.f66380f.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i2) {
        this.k.getLayoutMode().k(i2 == 1);
        this.k.getLayoutMode().j(this.f66376b);
        this.f66375a.onChangeSkinType(this.k.getPageContext(), i2);
    }

    public void p() {
        this.f66378d.g();
    }

    public void q(b bVar) {
        this.q = bVar;
    }

    public void r(boolean z) {
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.f66382h.setVisibility(0);
            this.f66383i.setVisibility(0);
            return;
        }
        this.f66382h.setVisibility(8);
        this.f66383i.setVisibility(8);
    }

    public void s(int i2, int i3) {
        if (i3 == 3 && i2 == 3) {
            this.f66380f.setTip(this.k.getString(R.string.mark_tip_no));
        } else if (i3 == 3) {
            this.f66380f.setTip(this.k.getString(R.string.mark_tip_inside));
        } else if (i2 == 3) {
            this.f66380f.setTip(this.k.getString(R.string.mark_tip_outside));
        } else {
            this.f66380f.setTip(this.k.getString(R.string.mark_tip_all));
        }
    }

    public void t(String str, int i2) {
        int i3 = i2 - 1;
        String[] strArr = this.m;
        if (strArr == null || i3 >= strArr.length || i3 < 0) {
            return;
        }
        if (TextUtils.equals(str, "like")) {
            this.f66379e.setTip(this.m[i3]);
        } else if (TextUtils.equals(str, "group")) {
            this.j.setTip(this.m[i3]);
        } else if (TextUtils.equals(str, "live")) {
            this.f66381g.setTip(this.m[i3]);
        } else if (TextUtils.equals(str, "reply")) {
            if (i3 == 0) {
                this.f66383i.setTip(this.k.getString(R.string.all_person));
            } else {
                this.f66383i.setTip(this.m[i3]);
            }
        } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            s(d.a.n0.r.d0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), d.a.n0.r.d0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
        }
    }

    public void u(d.a.o0.w2.b.a.a aVar) {
        String[] strArr;
        if (aVar == null || (strArr = this.m) == null) {
            return;
        }
        int length = strArr.length;
        int d2 = aVar.d() - 1;
        if (d2 < length && d2 >= 0) {
            this.j.setTip(this.m[d2]);
        }
        int c2 = aVar.c() - 1;
        if (c2 < length && c2 >= 0) {
            this.f66379e.setTip(this.m[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f66381g.setTip(this.m[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.f66383i.setTip(this.k.getString(R.string.all_person));
            } else {
                this.f66383i.setTip(this.m[g2]);
            }
        }
        s(aVar.a(), aVar.b());
    }
}
