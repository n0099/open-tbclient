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
    public View f59086a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f59087b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59088c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f59089d;

    /* renamed from: e  reason: collision with root package name */
    public int f59090e;

    /* renamed from: f  reason: collision with root package name */
    public String f59091f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f59092g = new C1519a();

    /* renamed from: d.a.n0.r0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1519a implements FrsTabSortSwitchButton.e {
        public C1519a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f59093a.f59087b).P0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.n0.r0.b.e().g() && !d.a.n0.r0.a.h().j()) {
                if (!j.A()) {
                    a.this.f59087b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f59087b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f59087b).m1() == null || ((FrsNewAreaFragment) a.this.f59087b).i1() == null) {
                        return false;
                    }
                } else if (a.this.f59087b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f59087b).Q0() != null) {
                    }
                }
                z = true;
                if (a.this.f59090e == i2) {
                    return true;
                }
                a.this.f59090e = i2;
                if (a.this.f59090e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f59087b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f59087b).m1().I(a.this.f59089d.v(a.this.f59090e));
                    if (d.n()) {
                        d.a.m0.b.g.a.f(a.this.f59089d.v(a.this.f59090e));
                    }
                    ((FrsNewAreaFragment) a.this.f59087b).i1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f59087b).Y0(k.d(a.this.f59089d.v(a.this.f59090e)));
                    ((FrsCommonTabFragment) a.this.f59087b).P0().w(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f59090e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f59087b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f59086a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f59088c = (TextView) this.f59086a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f59086a.findViewById(R.id.sort_tab_switch_btn);
        this.f59089d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f59092g);
        this.f59090e = this.f59089d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f59089d.v(this.f59090e));
        statisticItem.param("fid", this.f59091f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        if (this.f59089d != null) {
            this.f59089d.s(k.f(i2));
            this.f59090e = this.f59089d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f59089d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f59088c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f59089d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f59091f = str;
    }
}
