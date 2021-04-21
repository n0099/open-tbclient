package d.b.j0.q0.n1.f.a;

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
import d.b.c.e.p.j;
import d.b.i0.b.d;
import d.b.i0.z0.c0;
import d.b.j0.d3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f60130a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f60131b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60132c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f60133d;

    /* renamed from: e  reason: collision with root package name */
    public String f60134e;

    /* renamed from: f  reason: collision with root package name */
    public int f60135f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f60136g = new a();

    /* loaded from: classes4.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public a() {
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i) {
            boolean z = false;
            if (!d.b.j0.q0.b.e().g() && !d.b.j0.q0.a.h().j()) {
                if (!j.A()) {
                    b.this.f60131b.showToast(R.string.neterror);
                    return false;
                } else if (b.this.f60131b.M() != null && b.this.f60131b.x0() != null) {
                    z = true;
                    if (b.this.f60135f == i) {
                        return true;
                    }
                    b.this.f60131b.M().J0(b.this.f60133d.v(b.this.f60135f));
                    b.this.f60135f = i;
                    if (b.this.f60135f != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    b.this.f60131b.M().F0(b.this.f60133d.v(b.this.f60135f));
                    if (d.n()) {
                        d.b.i0.b.g.a.f(b.this.f60133d.v(b.this.f60135f));
                    }
                    b.this.f60131b.M().I0(true);
                    b.this.f60131b.x0().K1();
                    b.this.f60131b.M().H0(true);
                    b.this.f();
                }
            }
            return z;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.f60135f = -1;
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f60131b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f60130a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f60132c = (TextView) this.f60130a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f60130a.findViewById(R.id.sort_tab_switch_btn);
        this.f60133d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f60136g);
        this.f60135f = this.f60133d.getState();
        i();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f60133d.v(this.f60135f));
        statisticItem.param("fid", this.f60134e);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f60133d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.s(i);
            this.f60135f = this.f60133d.getState();
        }
    }

    public FrsTabSortSwitchButton h() {
        return this.f60133d;
    }

    public void i() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f60133d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f60132c, R.color.CAM_X0108);
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f60133d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void k(String str) {
        this.f60134e = str;
    }
}
