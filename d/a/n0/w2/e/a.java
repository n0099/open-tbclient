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
    public f<?> f62644a;

    /* renamed from: b  reason: collision with root package name */
    public View f62645b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62646c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62647d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62648e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f62649f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62650g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62651h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f62652i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.n0.w2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1703a implements BdSwitchView.b {
        public C1703a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == a.this.f62649f) {
                a.this.k = switchState == BdSwitchView.SwitchState.ON;
                a.this.f62644a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            } else if (view == a.this.f62652i) {
                a.this.j = switchState == BdSwitchView.SwitchState.ON;
                a.this.f62644a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
            }
            TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != a.this.f62649f ? 2 : 1));
        }
    }

    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        this.l = new C1703a();
        this.f62644a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View j() {
        return this.f62645b;
    }

    public final void k(Context context, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.f62645b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f62646c = navigationBar;
        navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.f62646c.showBottomLine();
        this.f62646c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62647d = (TextView) this.f62645b.findViewById(R.id.inside_text);
        this.f62648e = (TextView) this.f62645b.findViewById(R.id.inside_desc);
        this.f62649f = (BdSwitchView) this.f62645b.findViewById(R.id.inside_switch);
        this.f62650g = (TextView) this.f62645b.findViewById(R.id.outside_text);
        this.f62651h = (TextView) this.f62645b.findViewById(R.id.outside_desc);
        this.f62652i = (BdSwitchView) this.f62645b.findViewById(R.id.outside_switch);
        this.f62647d.setText(R.string.mark_show_inside);
        this.f62648e.setText(R.string.mark_show_everywhere);
        this.f62650g.setText(R.string.mark_show_outside);
        this.f62651h.setText(R.string.mark_show_somewhere);
        int i3 = i2 & 3;
        int i4 = (i2 >> 2) & 3;
        if (i3 == 3) {
            this.f62652i.h();
        } else {
            this.f62652i.k();
        }
        if (i4 == 3) {
            this.f62649f.h();
        } else {
            this.f62649f.k();
        }
        this.j = i3 != 3;
        this.k = i4 != 3;
        this.f62649f.setOnSwitchStateChangeListener(this.l);
        this.f62652i.setOnSwitchStateChangeListener(this.l);
    }

    public void l() {
        SkinManager.setViewTextColor(this.f62647d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62648e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f62650g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62651h, R.color.CAM_X0109);
        this.f62646c.onChangeSkinType(this.f62644a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m() {
        boolean z = !this.k;
        this.k = z;
        if (z) {
            this.f62649f.k();
        } else {
            this.f62649f.h();
        }
    }

    public void n() {
        boolean z = !this.j;
        this.j = z;
        if (z) {
            this.f62652i.k();
        } else {
            this.f62652i.h();
        }
    }
}
