package d.a.j0.v2.e;

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
    public f<?> f61813a;

    /* renamed from: b  reason: collision with root package name */
    public View f61814b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61815c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61816d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61817e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f61818f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61819g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61820h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f61821i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.j0.v2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1625a implements BdSwitchView.b {
        public C1625a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f61818f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f61813a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.f61821i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f61813a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f61818f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        this.l = new C1625a();
        this.f61813a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View j() {
        return this.f61814b;
    }

    public final void k(Context context, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f61814b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f61815c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f61815c.showBottomLine();
        this.f61815c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61816d = (TextView) this.f61814b.findViewById(R.id.inside_text);
        this.f61817e = (TextView) this.f61814b.findViewById(R.id.inside_desc);
        this.f61818f = (BdSwitchView) this.f61814b.findViewById(R.id.inside_switch);
        this.f61819g = (TextView) this.f61814b.findViewById(R.id.outside_text);
        this.f61820h = (TextView) this.f61814b.findViewById(R.id.outside_desc);
        this.f61821i = (BdSwitchView) this.f61814b.findViewById(R.id.outside_switch);
        this.f61816d.setText(R.string.mark_show_inside);
        this.f61817e.setText(R.string.mark_show_everywhere);
        this.f61819g.setText(R.string.mark_show_outside);
        this.f61820h.setText(R.string.mark_show_somewhere);
        int i3 = i2 & 3;
        int i4 = (i2 >> 2) & 3;
        if (i3 == 3) {
            this.f61821i.h();
        } else {
            this.f61821i.k();
        }
        if (i4 == 3) {
            this.f61818f.h();
        } else {
            this.f61818f.k();
        }
        this.j = i3 != 3;
        this.k = i4 != 3;
        this.f61818f.setOnSwitchStateChangeListener(this.l);
        this.f61821i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f61816d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61817e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f61819g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61820h, R.color.CAM_X0109);
        this.f61815c.onChangeSkinType(this.f61813a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f61818f.k();
        } else {
            this.f61818f.h();
        }
    }

    public void n() {
        boolean z = !this.j;
        this.j = z;
        if (z) {
            this.f61821i.k();
        } else {
            this.f61821i.h();
        }
    }
}
