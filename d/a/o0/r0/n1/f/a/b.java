package d.a.o0.r0.n1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import d.a.c.e.p.j;
import d.a.n0.b.d;
import d.a.n0.z0.c0;
import d.a.o0.e3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f62910a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f62911b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62912c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f62913d;

    /* renamed from: e  reason: collision with root package name */
    public String f62914e;

    /* renamed from: f  reason: collision with root package name */
    public int f62915f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f62916g = new a();

    /* loaded from: classes4.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public a() {
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.o0.r0.b.e().g() && !d.a.o0.r0.a.h().j()) {
                if (!j.A()) {
                    b.this.f62911b.showToast(R.string.neterror);
                    return false;
                } else if (b.this.f62911b.e0() != null && b.this.f62911b.B0() != null) {
                    z = true;
                    if (b.this.f62915f == i2) {
                        return true;
                    }
                    b.this.f62911b.e0().N0(b.this.f62913d.v(b.this.f62915f));
                    b.this.f62915f = i2;
                    if (b.this.f62915f != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    b.this.f62911b.e0().J0(b.this.f62913d.v(b.this.f62915f));
                    if (d.n()) {
                        d.a.n0.b.g.a.f(b.this.f62913d.v(b.this.f62915f));
                    }
                    b.this.f62911b.e0().M0(true);
                    b.this.f62911b.B0().K1();
                    b.this.f62911b.e0().L0(true);
                    b.this.f();
                }
            }
            return z;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.f62915f = -1;
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f62911b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f62910a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f62912c = (TextView) this.f62910a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f62910a.findViewById(R.id.sort_tab_switch_btn);
        this.f62913d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f62916g);
        this.f62915f = this.f62913d.getState();
        i();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f62913d.v(this.f62915f));
        statisticItem.param("fid", this.f62914e);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62913d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.s(i2);
            this.f62915f = this.f62913d.getState();
        }
    }

    public FrsTabSortSwitchButton h() {
        return this.f62913d;
    }

    public void i() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62913d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f62912c, R.color.CAM_X0108);
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62913d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void k(String str) {
        this.f62914e = str;
    }
}
