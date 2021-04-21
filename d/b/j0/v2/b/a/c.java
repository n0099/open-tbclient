package d.b.j0.v2.b.a;

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
import d.b.c.a.d;
/* loaded from: classes4.dex */
public class c extends d<SecretSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f63468a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f63469b;

    /* renamed from: c  reason: collision with root package name */
    public View f63470c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f63471d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f63472e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f63473f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f63474g;

    /* renamed from: h  reason: collision with root package name */
    public View f63475h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public SecretSettingActivity k;
    public View l;
    public String[] m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public View.OnClickListener p;
    public b q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.q == null) {
                return;
            }
            if (view == c.this.f63470c) {
                c.this.q.onBackPressed();
            } else if (view == c.this.f63471d) {
                c.this.q.e();
            } else if (view == c.this.f63472e) {
                c.this.q.d();
            } else if (view == c.this.f63474g) {
                c.this.q.g();
            } else if (view == c.this.j) {
                c.this.q.a();
            } else if (view == c.this.i) {
                c.this.q.c();
            } else if (view == c.this.n) {
                c.this.q.b();
            } else if (view == c.this.f63473f) {
                c.this.q.h();
            } else if (view == c.this.o) {
                c.this.q.f();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f63468a = null;
        this.p = new a();
        this.k = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        o(secretSettingActivity);
    }

    public final void o(SecretSettingActivity secretSettingActivity) {
        this.f63469b = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.f63468a = navigationBar;
        this.f63470c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63468a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.f63471d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.f63472e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.f63473f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.f63474g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.i = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.f63475h = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.f63470c.setOnClickListener(this.p);
        this.f63471d.setOnClickListener(this.p);
        this.j.setOnClickListener(this.p);
        this.f63472e.setOnClickListener(this.p);
        this.f63473f.setOnClickListener(this.p);
        this.f63474g.setOnClickListener(this.p);
        this.i.setOnClickListener(this.p);
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
        UserData b2 = d.b.i0.z.b.a().b();
        if (b2 != null && b2.getBazhuGradeData() != null && !StringUtils.isNull(b2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(b2.getBazhuGradeData().getLevel())) {
            this.f63473f.setVisibility(0);
        } else {
            this.f63473f.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.k.getLayoutMode().k(i == 1);
        this.k.getLayoutMode().j(this.f63469b);
        this.f63468a.onChangeSkinType(this.k.getPageContext(), i);
    }

    public void q() {
        this.f63471d.g();
    }

    public void r(b bVar) {
        this.q = bVar;
    }

    public void s(boolean z) {
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.f63475h.setVisibility(0);
            this.i.setVisibility(0);
            return;
        }
        this.f63475h.setVisibility(8);
        this.i.setVisibility(8);
    }

    public void u(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.f63473f.setTip(this.k.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.f63473f.setTip(this.k.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.f63473f.setTip(this.k.getString(R.string.mark_tip_outside));
        } else {
            this.f63473f.setTip(this.k.getString(R.string.mark_tip_all));
        }
    }

    public void v(String str, int i) {
        int i2 = i - 1;
        String[] strArr = this.m;
        if (strArr == null || i2 >= strArr.length || i2 < 0) {
            return;
        }
        if (TextUtils.equals(str, "like")) {
            this.f63472e.setTip(this.m[i2]);
        } else if (TextUtils.equals(str, "group")) {
            this.j.setTip(this.m[i2]);
        } else if (TextUtils.equals(str, "live")) {
            this.f63474g.setTip(this.m[i2]);
        } else if (TextUtils.equals(str, "reply")) {
            if (i2 == 0) {
                this.i.setTip(this.k.getString(R.string.all_person));
            } else {
                this.i.setTip(this.m[i2]);
            }
        } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            u(d.b.i0.r.d0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), d.b.i0.r.d0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
        }
    }

    public void w(d.b.j0.v2.b.a.a aVar) {
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
            this.f63472e.setTip(this.m[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f63474g.setTip(this.m[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.i.setTip(this.k.getString(R.string.all_person));
            } else {
                this.i.setTip(this.m[g2]);
            }
        }
        u(aVar.a(), aVar.b());
    }
}
