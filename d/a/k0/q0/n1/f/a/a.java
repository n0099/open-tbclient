package d.a.k0.q0.n1.f.a;

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
import d.a.c.e.p.j;
import d.a.j0.b.d;
import d.a.j0.z0.c0;
import d.a.k0.d3.n0.e;
import d.a.k0.q0.n2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f58945a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f58946b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58947c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f58948d;

    /* renamed from: e  reason: collision with root package name */
    public int f58949e;

    /* renamed from: f  reason: collision with root package name */
    public String f58950f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f58951g = new C1506a();

    /* renamed from: d.a.k0.q0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1506a implements FrsTabSortSwitchButton.e {
        public C1506a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f58952a.f58946b).P0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.k0.q0.b.e().g() && !d.a.k0.q0.a.h().j()) {
                if (!j.A()) {
                    a.this.f58946b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f58946b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f58946b).m1() == null || ((FrsNewAreaFragment) a.this.f58946b).i1() == null) {
                        return false;
                    }
                } else if (a.this.f58946b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f58946b).Q0() != null) {
                    }
                }
                z = true;
                if (a.this.f58949e == i2) {
                    return true;
                }
                a.this.f58949e = i2;
                if (a.this.f58949e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f58946b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f58946b).m1().I(a.this.f58948d.v(a.this.f58949e));
                    if (d.n()) {
                        d.a.j0.b.g.a.f(a.this.f58948d.v(a.this.f58949e));
                    }
                    ((FrsNewAreaFragment) a.this.f58946b).i1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f58946b).Y0(k.d(a.this.f58948d.v(a.this.f58949e)));
                    ((FrsCommonTabFragment) a.this.f58946b).P0().w(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f58949e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f58946b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f58945a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f58947c = (TextView) this.f58945a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f58945a.findViewById(R.id.sort_tab_switch_btn);
        this.f58948d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f58951g);
        this.f58949e = this.f58948d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f58948d.v(this.f58949e));
        statisticItem.param("fid", this.f58950f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        if (this.f58948d != null) {
            this.f58948d.s(k.f(i2));
            this.f58949e = this.f58948d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58948d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f58947c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58948d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f58950f = str;
    }
}
