package d.b.i0.q0.n1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import d.b.c.e.p.j;
import d.b.h0.b.d;
import d.b.h0.z0.c0;
import d.b.i0.d3.n0.e;
import d.b.i0.q0.n2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f59701a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f59702b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59703c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f59704d;

    /* renamed from: e  reason: collision with root package name */
    public int f59705e;

    /* renamed from: f  reason: collision with root package name */
    public String f59706f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f59707g = new C1470a();

    /* renamed from: d.b.i0.q0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1470a implements FrsTabSortSwitchButton.e {
        public C1470a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f59708a.f59702b).Q0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i) {
            boolean z = false;
            if (!d.b.i0.q0.b.e().g() && !d.b.i0.q0.a.h().j()) {
                if (!j.A()) {
                    a.this.f59702b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f59702b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f59702b).n1() == null || ((FrsNewAreaFragment) a.this.f59702b).j1() == null) {
                        return false;
                    }
                } else if (a.this.f59702b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f59702b).R0() != null) {
                    }
                }
                z = true;
                if (a.this.f59705e == i) {
                    return true;
                }
                a.this.f59705e = i;
                if (a.this.f59705e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f59702b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f59702b).n1().I(a.this.f59704d.v(a.this.f59705e));
                    if (d.n()) {
                        d.b.h0.b.g.a.f(a.this.f59704d.v(a.this.f59705e));
                    }
                    ((FrsNewAreaFragment) a.this.f59702b).j1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f59702b).Z0(k.d(a.this.f59704d.v(a.this.f59705e)));
                    ((FrsCommonTabFragment) a.this.f59702b).Q0().w(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f59705e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f59702b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f59701a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f59703c = (TextView) this.f59701a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f59701a.findViewById(R.id.sort_tab_switch_btn);
        this.f59704d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f59707g);
        this.f59705e = this.f59704d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f59704d.v(this.f59705e));
        statisticItem.param("fid", this.f59706f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i) {
        if (this.f59704d != null) {
            this.f59704d.s(k.f(i));
            this.f59705e = this.f59704d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f59704d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f59703c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f59704d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f59706f = str;
    }
}
