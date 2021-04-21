package d.b.j0.v2.e;

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
import d.b.c.a.d;
import d.b.c.a.f;
/* loaded from: classes4.dex */
public class a extends d<PrivacyMarkActivity> {

    /* renamed from: a  reason: collision with root package name */
    public f<?> f63568a;

    /* renamed from: b  reason: collision with root package name */
    public View f63569b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63570c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63571d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63572e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f63573f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63574g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63575h;
    public BdSwitchView i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.b.j0.v2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1685a implements BdSwitchView.b {
        public C1685a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f63573f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f63568a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f63568a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f63573f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.l = new C1685a();
        this.f63568a = fVar;
        k(fVar.getPageActivity(), i);
        l();
    }

    public View i() {
        return this.f63569b;
    }

    public final void k(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f63569b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f63570c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f63570c.showBottomLine();
        this.f63570c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63571d = (TextView) this.f63569b.findViewById(R.id.inside_text);
        this.f63572e = (TextView) this.f63569b.findViewById(R.id.inside_desc);
        this.f63573f = (BdSwitchView) this.f63569b.findViewById(R.id.inside_switch);
        this.f63574g = (TextView) this.f63569b.findViewById(R.id.outside_text);
        this.f63575h = (TextView) this.f63569b.findViewById(R.id.outside_desc);
        this.i = (BdSwitchView) this.f63569b.findViewById(R.id.outside_switch);
        this.f63571d.setText(R.string.mark_show_inside);
        this.f63572e.setText(R.string.mark_show_everywhere);
        this.f63574g.setText(R.string.mark_show_outside);
        this.f63575h.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.i.h();
        } else {
            this.i.k();
        }
        if (i3 == 3) {
            this.f63573f.h();
        } else {
            this.f63573f.k();
        }
        this.j = i2 != 3;
        this.k = i3 != 3;
        this.f63573f.setOnSwitchStateChangeListener(this.l);
        this.i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f63571d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f63572e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f63574g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f63575h, R.color.CAM_X0109);
        this.f63570c.onChangeSkinType(this.f63568a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f63573f.k();
        } else {
            this.f63573f.h();
        }
    }

    public void n() {
        boolean z = !this.j;
        this.j = z;
        if (z) {
            this.i.k();
        } else {
            this.i.h();
        }
    }
}
