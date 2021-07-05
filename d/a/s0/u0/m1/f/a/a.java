package d.a.s0.u0.m1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.r0.b.d;
import d.a.r0.z0.c0;
import d.a.s0.h3.n0.e;
import d.a.s0.u0.n2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66382a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f66383b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66384c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f66385d;

    /* renamed from: e  reason: collision with root package name */
    public int f66386e;

    /* renamed from: f  reason: collision with root package name */
    public String f66387f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f66388g;

    /* renamed from: d.a.s0.u0.m1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1731a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66389a;

        public C1731a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66389a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.f66389a.f66383b).S0() != null) goto L18;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!d.a.s0.u0.b.e().g() && !d.a.s0.u0.a.h().j()) {
                    if (!j.A()) {
                        this.f66389a.f66383b.showToast(R.string.neterror);
                        return false;
                    }
                    if (this.f66389a.f66383b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.f66389a.f66383b).p1() == null || ((FrsNewAreaFragment) this.f66389a.f66383b).l1() == null) {
                            return false;
                        }
                    } else if (this.f66389a.f66383b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.f66389a.f66383b).T0() != null) {
                        }
                    }
                    z = true;
                    if (this.f66389a.f66386e == i2) {
                        return true;
                    }
                    this.f66389a.f66386e = i2;
                    if (this.f66389a.f66386e != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.f66389a.f66383b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.f66389a.f66383b).p1().M(this.f66389a.f66385d.v(this.f66389a.f66386e));
                        if (d.n()) {
                            d.a.r0.b.g.a.f(this.f66389a.f66385d.v(this.f66389a.f66386e));
                        }
                        ((FrsNewAreaFragment) this.f66389a.f66383b).l1().L();
                    } else {
                        ((FrsCommonTabFragment) this.f66389a.f66383b).b1(k.d(this.f66389a.f66385d.v(this.f66389a.f66386e)));
                        ((FrsCommonTabFragment) this.f66389a.f66383b).S0().w(true);
                    }
                    this.f66389a.f();
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66386e = -1;
        this.f66388g = new C1731a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f66383b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f66382a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f66384c = (TextView) this.f66382a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f66382a.findViewById(R.id.sort_tab_switch_btn);
        this.f66385d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f66388g);
        this.f66386e = this.f66385d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f66385d.v(this.f66386e));
            statisticItem.param("fid", this.f66387f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f66385d == null) {
            return;
        }
        this.f66385d.s(k.f(i2));
        this.f66386e = this.f66385d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f66385d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.C();
            }
            SkinManager.setViewTextColor(this.f66384c, R.color.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f66385d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f66387f = str;
        }
    }
}
