package d.a.n0.w2.e;

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
    public f<?> f66359a;

    /* renamed from: b  reason: collision with root package name */
    public View f66360b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66361c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66362d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66363e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f66364f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66365g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66366h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f66367i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.n0.w2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1760a implements BdSwitchView.b {
        public C1760a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f66364f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f66359a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.f66367i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f66359a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f66364f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        this.l = new C1760a();
        this.f66359a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View i() {
        return this.f66360b;
    }

    public final void k(Context context, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f66360b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f66361c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f66361c.showBottomLine();
        this.f66361c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66362d = (TextView) this.f66360b.findViewById(R.id.inside_text);
        this.f66363e = (TextView) this.f66360b.findViewById(R.id.inside_desc);
        this.f66364f = (BdSwitchView) this.f66360b.findViewById(R.id.inside_switch);
        this.f66365g = (TextView) this.f66360b.findViewById(R.id.outside_text);
        this.f66366h = (TextView) this.f66360b.findViewById(R.id.outside_desc);
        this.f66367i = (BdSwitchView) this.f66360b.findViewById(R.id.outside_switch);
        this.f66362d.setText(R.string.mark_show_inside);
        this.f66363e.setText(R.string.mark_show_everywhere);
        this.f66365g.setText(R.string.mark_show_outside);
        this.f66366h.setText(R.string.mark_show_somewhere);
        int i3 = i2 & 3;
        int i4 = (i2 >> 2) & 3;
        if (i3 == 3) {
            this.f66367i.h();
        } else {
            this.f66367i.k();
        }
        if (i4 == 3) {
            this.f66364f.h();
        } else {
            this.f66364f.k();
        }
        this.j = i3 != 3;
        this.k = i4 != 3;
        this.f66364f.setOnSwitchStateChangeListener(this.l);
        this.f66367i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f66362d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66363e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f66365g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66366h, R.color.CAM_X0109);
        this.f66361c.onChangeSkinType(this.f66359a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f66364f.k();
        } else {
            this.f66364f.h();
        }
    }

    public void n() {
        boolean z = !this.j;
        this.j = z;
        if (z) {
            this.f66367i.k();
        } else {
            this.f66367i.h();
        }
    }
}
