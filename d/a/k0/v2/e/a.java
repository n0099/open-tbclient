package d.a.k0.v2.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import d.a.c.a.d;
import d.a.c.a.f;
/* loaded from: classes5.dex */
public class a extends d<PrivacyMarkActivity> {

    /* renamed from: a  reason: collision with root package name */
    public f<?> f62537a;

    /* renamed from: b  reason: collision with root package name */
    public View f62538b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62539c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62540d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62541e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f62542f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62543g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62544h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f62545i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.k0.v2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1690a implements BdSwitchView.b {
        public C1690a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f62542f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f62537a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.f62545i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f62537a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f62542f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        this.l = new C1690a();
        this.f62537a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View j() {
        return this.f62538b;
    }

    public final void k(Context context, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f62538b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f62539c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f62539c.showBottomLine();
        this.f62539c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62540d = (TextView) this.f62538b.findViewById(R.id.inside_text);
        this.f62541e = (TextView) this.f62538b.findViewById(R.id.inside_desc);
        this.f62542f = (BdSwitchView) this.f62538b.findViewById(R.id.inside_switch);
        this.f62543g = (TextView) this.f62538b.findViewById(R.id.outside_text);
        this.f62544h = (TextView) this.f62538b.findViewById(R.id.outside_desc);
        this.f62545i = (BdSwitchView) this.f62538b.findViewById(R.id.outside_switch);
        this.f62540d.setText(R.string.mark_show_inside);
        this.f62541e.setText(R.string.mark_show_everywhere);
        this.f62543g.setText(R.string.mark_show_outside);
        this.f62544h.setText(R.string.mark_show_somewhere);
        int i3 = i2 & 3;
        int i4 = (i2 >> 2) & 3;
        if (i3 == 3) {
            this.f62545i.h();
        } else {
            this.f62545i.k();
        }
        if (i4 == 3) {
            this.f62542f.h();
        } else {
            this.f62542f.k();
        }
        this.j = i3 != 3;
        this.k = i4 != 3;
        this.f62542f.setOnSwitchStateChangeListener(this.l);
        this.f62545i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f62540d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62541e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f62543g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62544h, R.color.CAM_X0109);
        this.f62539c.onChangeSkinType(this.f62537a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f62542f.k();
        } else {
            this.f62542f.h();
        }
    }

    public void n() {
        boolean z = !this.j;
        this.j = z;
        if (z) {
            this.f62545i.k();
        } else {
            this.f62545i.h();
        }
    }
}
