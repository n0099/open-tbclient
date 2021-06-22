package d.a.o0.w2.e;

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
    public f<?> f66484a;

    /* renamed from: b  reason: collision with root package name */
    public View f66485b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66486c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66487d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66488e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f66489f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66490g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66491h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f66492i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.o0.w2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1764a implements BdSwitchView.b {
        public C1764a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f66489f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f66484a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.f66492i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f66484a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f66489f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        this.l = new C1764a();
        this.f66484a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View i() {
        return this.f66485b;
    }

    public final void k(Context context, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f66485b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f66486c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f66486c.showBottomLine();
        this.f66486c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66487d = (TextView) this.f66485b.findViewById(R.id.inside_text);
        this.f66488e = (TextView) this.f66485b.findViewById(R.id.inside_desc);
        this.f66489f = (BdSwitchView) this.f66485b.findViewById(R.id.inside_switch);
        this.f66490g = (TextView) this.f66485b.findViewById(R.id.outside_text);
        this.f66491h = (TextView) this.f66485b.findViewById(R.id.outside_desc);
        this.f66492i = (BdSwitchView) this.f66485b.findViewById(R.id.outside_switch);
        this.f66487d.setText(R.string.mark_show_inside);
        this.f66488e.setText(R.string.mark_show_everywhere);
        this.f66490g.setText(R.string.mark_show_outside);
        this.f66491h.setText(R.string.mark_show_somewhere);
        int i3 = i2 & 3;
        int i4 = (i2 >> 2) & 3;
        if (i3 == 3) {
            this.f66492i.h();
        } else {
            this.f66492i.k();
        }
        if (i4 == 3) {
            this.f66489f.h();
        } else {
            this.f66489f.k();
        }
        this.j = i3 != 3;
        this.k = i4 != 3;
        this.f66489f.setOnSwitchStateChangeListener(this.l);
        this.f66492i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f66487d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66488e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f66490g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66491h, R.color.CAM_X0109);
        this.f66486c.onChangeSkinType(this.f66484a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f66489f.k();
        } else {
            this.f66489f.h();
        }
    }

    public void n() {
        boolean z = !this.j;
        this.j = z;
        if (z) {
            this.f66492i.k();
        } else {
            this.f66492i.h();
        }
    }
}
