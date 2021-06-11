package d.a.n0.r0.n1.f.a;

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
import d.a.m0.b.d;
import d.a.m0.z0.c0;
import d.a.n0.e3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f62785a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f62786b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62787c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f62788d;

    /* renamed from: e  reason: collision with root package name */
    public String f62789e;

    /* renamed from: f  reason: collision with root package name */
    public int f62790f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f62791g = new a();

    /* loaded from: classes4.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public a() {
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.n0.r0.b.e().g() && !d.a.n0.r0.a.h().j()) {
                if (!j.A()) {
                    b.this.f62786b.showToast(R.string.neterror);
                    return false;
                } else if (b.this.f62786b.e0() != null && b.this.f62786b.B0() != null) {
                    z = true;
                    if (b.this.f62790f == i2) {
                        return true;
                    }
                    b.this.f62786b.e0().N0(b.this.f62788d.v(b.this.f62790f));
                    b.this.f62790f = i2;
                    if (b.this.f62790f != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    b.this.f62786b.e0().J0(b.this.f62788d.v(b.this.f62790f));
                    if (d.n()) {
                        d.a.m0.b.g.a.f(b.this.f62788d.v(b.this.f62790f));
                    }
                    b.this.f62786b.e0().M0(true);
                    b.this.f62786b.B0().K1();
                    b.this.f62786b.e0().L0(true);
                    b.this.f();
                }
            }
            return z;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.f62790f = -1;
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f62786b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f62785a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f62787c = (TextView) this.f62785a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f62785a.findViewById(R.id.sort_tab_switch_btn);
        this.f62788d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f62791g);
        this.f62790f = this.f62788d.getState();
        i();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f62788d.v(this.f62790f));
        statisticItem.param("fid", this.f62789e);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62788d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.s(i2);
            this.f62790f = this.f62788d.getState();
        }
    }

    public FrsTabSortSwitchButton h() {
        return this.f62788d;
    }

    public void i() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62788d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f62787c, R.color.CAM_X0108);
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62788d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void k(String str) {
        this.f62789e = str;
    }
}
