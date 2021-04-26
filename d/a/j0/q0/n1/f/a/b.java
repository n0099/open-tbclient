package d.a.j0.q0.n1.f.a;

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
import d.a.i0.b.d;
import d.a.i0.z0.c0;
import d.a.j0.d3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f58211a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f58212b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58213c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f58214d;

    /* renamed from: e  reason: collision with root package name */
    public String f58215e;

    /* renamed from: f  reason: collision with root package name */
    public int f58216f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f58217g = new a();

    /* loaded from: classes4.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public a() {
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.j0.q0.b.e().g() && !d.a.j0.q0.a.h().j()) {
                if (!j.A()) {
                    b.this.f58212b.showToast(R.string.neterror);
                    return false;
                } else if (b.this.f58212b.b0() != null && b.this.f58212b.z0() != null) {
                    z = true;
                    if (b.this.f58216f == i2) {
                        return true;
                    }
                    b.this.f58212b.b0().J0(b.this.f58214d.v(b.this.f58216f));
                    b.this.f58216f = i2;
                    if (b.this.f58216f != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    b.this.f58212b.b0().F0(b.this.f58214d.v(b.this.f58216f));
                    if (d.n()) {
                        d.a.i0.b.g.a.f(b.this.f58214d.v(b.this.f58216f));
                    }
                    b.this.f58212b.b0().I0(true);
                    b.this.f58212b.z0().K1();
                    b.this.f58212b.b0().H0(true);
                    b.this.f();
                }
            }
            return z;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.f58216f = -1;
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f58212b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f58211a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f58213c = (TextView) this.f58211a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f58211a.findViewById(R.id.sort_tab_switch_btn);
        this.f58214d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f58217g);
        this.f58216f = this.f58214d.getState();
        i();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f58214d.v(this.f58216f));
        statisticItem.param("fid", this.f58215e);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58214d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.s(i2);
            this.f58216f = this.f58214d.getState();
        }
    }

    public FrsTabSortSwitchButton h() {
        return this.f58214d;
    }

    public void i() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58214d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f58213c, R.color.CAM_X0108);
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58214d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void k(String str) {
        this.f58215e = str;
    }
}
