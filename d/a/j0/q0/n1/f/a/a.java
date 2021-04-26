package d.a.j0.q0.n1.f.a;

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
import d.a.i0.b.d;
import d.a.i0.z0.c0;
import d.a.j0.d3.n0.e;
import d.a.j0.q0.n2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f58203a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f58204b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58205c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f58206d;

    /* renamed from: e  reason: collision with root package name */
    public int f58207e;

    /* renamed from: f  reason: collision with root package name */
    public String f58208f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f58209g = new C1432a();

    /* renamed from: d.a.j0.q0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1432a implements FrsTabSortSwitchButton.e {
        public C1432a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f58210a.f58204b).Q0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            boolean z = false;
            if (!d.a.j0.q0.b.e().g() && !d.a.j0.q0.a.h().j()) {
                if (!j.A()) {
                    a.this.f58204b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f58204b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f58204b).n1() == null || ((FrsNewAreaFragment) a.this.f58204b).j1() == null) {
                        return false;
                    }
                } else if (a.this.f58204b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f58204b).R0() != null) {
                    }
                }
                z = true;
                if (a.this.f58207e == i2) {
                    return true;
                }
                a.this.f58207e = i2;
                if (a.this.f58207e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f58204b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f58204b).n1().I(a.this.f58206d.v(a.this.f58207e));
                    if (d.n()) {
                        d.a.i0.b.g.a.f(a.this.f58206d.v(a.this.f58207e));
                    }
                    ((FrsNewAreaFragment) a.this.f58204b).j1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f58204b).Z0(k.d(a.this.f58206d.v(a.this.f58207e)));
                    ((FrsCommonTabFragment) a.this.f58204b).Q0().w(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f58207e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f58204b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f58203a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f58205c = (TextView) this.f58203a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f58203a.findViewById(R.id.sort_tab_switch_btn);
        this.f58206d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f58209g);
        this.f58207e = this.f58206d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f58206d.v(this.f58207e));
        statisticItem.param("fid", this.f58208f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i2) {
        if (this.f58206d != null) {
            this.f58206d.s(k.f(i2));
            this.f58207e = this.f58206d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58206d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f58205c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58206d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f58208f = str;
    }
}
