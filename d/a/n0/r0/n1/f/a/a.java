package d.a.n0.r0.n1.f.a;

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
import d.a.m0.b.d;
import d.a.m0.z0.c0;
import d.a.n0.e3.n0.e;
import d.a.n0.r0.n2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f62777a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f62778b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62779c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f62780d;

    /* renamed from: e  reason: collision with root package name */
    public int f62781e;

    /* renamed from: f  reason: collision with root package name */
    public String f62782f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f62783g = new C1575a();

    /* renamed from: d.a.n0.r0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1575a implements FrsTabSortSwitchButton.e {
        public C1575a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f62784a.f62778b).S0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.n0.r0.b.e().g() && !d.a.n0.r0.a.h().j()) {
                if (!j.A()) {
                    a.this.f62778b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f62778b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f62778b).p1() == null || ((FrsNewAreaFragment) a.this.f62778b).l1() == null) {
                        return false;
                    }
                } else if (a.this.f62778b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f62778b).T0() != null) {
                    }
                }
                z = true;
                if (a.this.f62781e == i2) {
                    return true;
                }
                a.this.f62781e = i2;
                if (a.this.f62781e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f62778b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f62778b).p1().M(a.this.f62780d.v(a.this.f62781e));
                    if (d.n()) {
                        d.a.m0.b.g.a.f(a.this.f62780d.v(a.this.f62781e));
                    }
                    ((FrsNewAreaFragment) a.this.f62778b).l1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f62778b).b1(k.d(a.this.f62780d.v(a.this.f62781e)));
                    ((FrsCommonTabFragment) a.this.f62778b).S0().w(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f62781e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f62778b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f62777a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f62779c = (TextView) this.f62777a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f62777a.findViewById(R.id.sort_tab_switch_btn);
        this.f62780d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f62783g);
        this.f62781e = this.f62780d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f62780d.v(this.f62781e));
        statisticItem.param("fid", this.f62782f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        if (this.f62780d != null) {
            this.f62780d.s(k.f(i2));
            this.f62781e = this.f62780d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62780d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f62779c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f62780d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f62782f = str;
    }
}
