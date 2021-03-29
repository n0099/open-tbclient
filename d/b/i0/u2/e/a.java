package d.b.i0.u2.e;

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
import d.b.b.a.d;
import d.b.b.a.f;
/* loaded from: classes5.dex */
public class a extends d<PrivacyMarkActivity> {

    /* renamed from: a  reason: collision with root package name */
    public f<?> f61409a;

    /* renamed from: b  reason: collision with root package name */
    public View f61410b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61411c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61412d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61413e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f61414f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61415g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61416h;
    public BdSwitchView i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.b.i0.u2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1602a implements BdSwitchView.b {
        public C1602a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f61414f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f61409a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f61409a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f61414f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.l = new C1602a();
        this.f61409a = fVar;
        k(fVar.getPageActivity(), i);
        l();
    }

    public View i() {
        return this.f61410b;
    }

    public final void k(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f61410b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f61411c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f61411c.showBottomLine();
        this.f61411c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61412d = (TextView) this.f61410b.findViewById(R.id.inside_text);
        this.f61413e = (TextView) this.f61410b.findViewById(R.id.inside_desc);
        this.f61414f = (BdSwitchView) this.f61410b.findViewById(R.id.inside_switch);
        this.f61415g = (TextView) this.f61410b.findViewById(R.id.outside_text);
        this.f61416h = (TextView) this.f61410b.findViewById(R.id.outside_desc);
        this.i = (BdSwitchView) this.f61410b.findViewById(R.id.outside_switch);
        this.f61412d.setText(R.string.mark_show_inside);
        this.f61413e.setText(R.string.mark_show_everywhere);
        this.f61415g.setText(R.string.mark_show_outside);
        this.f61416h.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.i.h();
        } else {
            this.i.k();
        }
        if (i3 == 3) {
            this.f61414f.h();
        } else {
            this.f61414f.k();
        }
        this.j = i2 != 3;
        this.k = i3 != 3;
        this.f61414f.setOnSwitchStateChangeListener(this.l);
        this.i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f61412d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61413e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f61415g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61416h, R.color.CAM_X0109);
        this.f61411c.onChangeSkinType(this.f61409a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f61414f.k();
        } else {
            this.f61414f.h();
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
