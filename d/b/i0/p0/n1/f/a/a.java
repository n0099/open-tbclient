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
    public View f58060a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f58061b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58062c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f58063d;

    /* renamed from: e  reason: collision with root package name */
    public int f58064e;

    /* renamed from: f  reason: collision with root package name */
    public String f58065f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f58066g = new C1406a();

    /* renamed from: d.b.i0.p0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1406a implements FrsTabSortSwitchButton.e {
        public C1406a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r3.f58067a.f58061b).Q0() != null) goto L16;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i) {
            boolean z = false;
            if (!d.b.i0.p0.b.e().g() && !d.b.i0.p0.a.h().j()) {
                if (!j.A()) {
                    a.this.f58061b.showToast(R.string.neterror);
                    return false;
                }
                if (a.this.f58061b instanceof FrsNewAreaFragment) {
                    if (((FrsNewAreaFragment) a.this.f58061b).n1() == null || ((FrsNewAreaFragment) a.this.f58061b).j1() == null) {
                        return false;
                    }
                } else if (a.this.f58061b instanceof FrsCommonTabFragment) {
                    if (((FrsCommonTabFragment) a.this.f58061b).R0() != null) {
                    }
                }
                z = true;
                if (a.this.f58064e == i) {
                    return true;
                }
                a.this.f58064e = i;
                if (a.this.f58064e != 7) {
                    c0.c();
                    e.a();
                } else {
                    e.b();
                }
                if (a.this.f58061b instanceof FrsNewAreaFragment) {
                    ((FrsNewAreaFragment) a.this.f58061b).n1().I(a.this.f58063d.v(a.this.f58064e));
                    if (d.m()) {
                        d.b.h0.b.g.a.f(a.this.f58063d.v(a.this.f58064e));
                    }
                    ((FrsNewAreaFragment) a.this.f58061b).j1().L();
                } else {
                    ((FrsCommonTabFragment) a.this.f58061b).Z0(k.d(a.this.f58063d.v(a.this.f58064e)));
                    ((FrsCommonTabFragment) a.this.f58061b).Q0().v(true);
                }
                a.this.f();
            }
            return z;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.f58064e = -1;
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f58061b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f58060a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f58062c = (TextView) this.f58060a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f58060a.findViewById(R.id.sort_tab_switch_btn);
        this.f58063d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f58066g);
        this.f58064e = this.f58063d.getState();
        h();
    }

    public final void f() {
        StatisticItem statisticItem = new StatisticItem("c11437");
        statisticItem.param("obj_type", this.f58063d.v(this.f58064e));
        statisticItem.param("fid", this.f58065f);
        TiebaStatic.log(statisticItem);
    }

    public void g(int i) {
        if (this.f58063d != null) {
            this.f58063d.s(k.f(i));
            this.f58064e = this.f58063d.getState();
        }
    }

    public void h() {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58063d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.C();
        }
        SkinManager.setViewTextColor(this.f58062c, R.color.CAM_X0105);
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton = this.f58063d;
        if (frsTabSortSwitchButton != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        this.f58065f = str;
    }
}
