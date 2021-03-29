package d.b.i0.p0.n1.f.a;

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
import d.b.b.e.p.j;
import d.b.h0.b.d;
import d.b.h0.z0.c0;
import d.b.i0.c3.n0.e;
import d.b.i0.p0.m2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f58061a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f58062b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58063c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f58064d;

    /* renamed from: e  reason: collision with root package name */
    public int f58065e;

    /* renamed from: f  reason: collision with root package name */
    public String f58066f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f58067g = new C1407a();

    /* renamed from: d.b.i0.p0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1407a implements FrsTabSortSwitchButton.e {
        public C1407a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f58068a.f58062b).Q0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i) {
            boolean z = false;
            if (!d.b.i0.p0.b.e().g() && !d.b.i0.p0.a.h().j()) {
                if (!j.A()) {
                    a.this.f58062b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f58062b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f58062b).n1() == null || ((FrsNewAreaFragment) a.this.f58062b).j1() == null) {
                        return false;
                    }
                } else if (a.this.f58062b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f58062b).R0() != null) {
                    }
                }
                z = true;
                if (a.this.f58065e == i) {
                    return true;
                }
                a.this.f58065e = i;
                if (a.this.f58065e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f58062b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f58062b).n1().I(a.this.f58064d.v(a.this.f58065e));
                    if (d.m()) {
                        d.b.h0.b.g.a.f(a.this.f58064d.v(a.this.f58065e));
                    }
                    ((FrsNewAreaFragment) a.this.f58062b).j1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f58062b).Z0(k.d(a.this.f58064d.v(a.this.f58065e)));
                    ((FrsCommonTabFragment) a.this.f58062b).Q0().v(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f58065e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f58062b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f58061a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f58063c = (TextView) this.f58061a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f58061a.findViewById(R.id.sort_tab_switch_btn);
        this.f58064d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f58067g);
        this.f58065e = this.f58064d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f58064d.v(this.f58065e));
        statisticItem.param("fid", this.f58066f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i) {
        if (this.f58064d != null) {
            this.f58064d.s(k.f(i));
            this.f58065e = this.f58064d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58064d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f58063c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58064d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f58066f = str;
    }
}
