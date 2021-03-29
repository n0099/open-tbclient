package d.b.i0.p0.n1.f.a;

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
import d.b.b.e.p.j;
import d.b.h0.b.d;
import d.b.h0.z0.c0;
import d.b.i0.c3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f58069a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f58070b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58071c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f58072d;

    /* renamed from: e  reason: collision with root package name */
    public String f58073e;

    /* renamed from: f  reason: collision with root package name */
    public int f58074f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f58075g = new a();

    /* loaded from: classes4.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public a() {
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i) {
            boolean z = false;
            if (!d.b.i0.p0.b.e().g() && !d.b.i0.p0.a.h().j()) {
                if (!j.A()) {
                    b.this.f58070b.showToast(R.string.neterror);
                    return false;
                } else if (b.this.f58070b.M() != null && b.this.f58070b.x0() != null) {
                    z = true;
                    if (b.this.f58074f == i) {
                        return true;
                    }
                    b.this.f58070b.M().J0(b.this.f58072d.v(b.this.f58074f));
                    b.this.f58074f = i;
                    if (b.this.f58074f != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    b.this.f58070b.M().F0(b.this.f58072d.v(b.this.f58074f));
                    if (d.m()) {
                        d.b.h0.b.g.a.f(b.this.f58072d.v(b.this.f58074f));
                    }
                    b.this.f58070b.M().I0(true);
                    b.this.f58070b.x0().K1();
                    b.this.f58070b.M().H0(true);
                    b.this.f();
                }
            }
            return z;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.f58074f = -1;
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f58070b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f58069a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f58071c = (TextView) this.f58069a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f58069a.findViewById(R.id.sort_tab_switch_btn);
        this.f58072d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f58075g);
        this.f58074f = this.f58072d.getState();
        i();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f58072d.v(this.f58074f));
        statisticItem.param("fid", this.f58073e);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58072d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.s(i);
            this.f58074f = this.f58072d.getState();
        }
    }

    public FrsTabSortSwitchButton h() {
        return this.f58072d;
    }

    public void i() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58072d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f58071c, R.color.CAM_X0108);
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58072d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void k(String str) {
        this.f58073e = str;
    }
}
