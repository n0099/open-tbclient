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
    public f<?> f61408a;

    /* renamed from: b  reason: collision with root package name */
    public View f61409b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61410c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61411d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61412e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f61413f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61414g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61415h;
    public BdSwitchView i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.b.i0.u2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1601a implements BdSwitchView.b {
        public C1601a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f61413f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f61408a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f61408a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f61413f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.l = new C1601a();
        this.f61408a = fVar;
        k(fVar.getPageActivity(), i);
        l();
    }

    public View i() {
        return this.f61409b;
    }

    public final void k(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f61409b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f61410c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f61410c.showBottomLine();
        this.f61410c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61411d = (TextView) this.f61409b.findViewById(R.id.inside_text);
        this.f61412e = (TextView) this.f61409b.findViewById(R.id.inside_desc);
        this.f61413f = (BdSwitchView) this.f61409b.findViewById(R.id.inside_switch);
        this.f61414g = (TextView) this.f61409b.findViewById(R.id.outside_text);
        this.f61415h = (TextView) this.f61409b.findViewById(R.id.outside_desc);
        this.i = (BdSwitchView) this.f61409b.findViewById(R.id.outside_switch);
        this.f61411d.setText(R.string.mark_show_inside);
        this.f61412e.setText(R.string.mark_show_everywhere);
        this.f61414g.setText(R.string.mark_show_outside);
        this.f61415h.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.i.h();
        } else {
            this.i.k();
        }
        if (i3 == 3) {
            this.f61413f.h();
        } else {
            this.f61413f.k();
        }
        this.j = i2 != 3;
        this.k = i3 != 3;
        this.f61413f.setOnSwitchStateChangeListener(this.l);
        this.i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f61411d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61412e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f61414g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61415h, R.color.CAM_X0109);
        this.f61410c.onChangeSkinType(this.f61408a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f61413f.k();
        } else {
            this.f61413f.h();
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
