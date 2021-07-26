package d.a.q0.u0.m1.f.a;

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
import d.a.d.e.p.j;
import d.a.p0.b.d;
import d.a.p0.b1.c0;
import d.a.q0.h3.n0.e;
import d.a.q0.u0.n2.k;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f63806a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f63807b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63808c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f63809d;

    /* renamed from: e  reason: collision with root package name */
    public int f63810e;

    /* renamed from: f  reason: collision with root package name */
    public String f63811f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f63812g;

    /* renamed from: d.a.q0.u0.m1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1692a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63813a;

        public C1692a(a aVar) {
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
            this.f63813a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.f63813a.f63807b).Y0() != null) goto L18;
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
                if (!d.a.q0.u0.b.e().g() && !d.a.q0.u0.a.h().j()) {
                    if (!j.A()) {
                        this.f63813a.f63807b.showToast(R.string.neterror);
                        return false;
                    }
                    if (this.f63813a.f63807b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.f63813a.f63807b).v1() == null || ((FrsNewAreaFragment) this.f63813a.f63807b).r1() == null) {
                            return false;
                        }
                    } else if (this.f63813a.f63807b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.f63813a.f63807b).Z0() != null) {
                        }
                    }
                    z = true;
                    if (this.f63813a.f63810e == i2) {
                        return true;
                    }
                    this.f63813a.f63810e = i2;
                    if (this.f63813a.f63810e != 7) {
                        c0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.f63813a.f63807b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.f63813a.f63807b).v1().M(this.f63813a.f63809d.v(this.f63813a.f63810e));
                        if (d.y()) {
                            d.a.p0.b.g.a.f(this.f63813a.f63809d.v(this.f63813a.f63810e));
                        }
                        ((FrsNewAreaFragment) this.f63813a.f63807b).r1().L();
                    } else {
                        ((FrsCommonTabFragment) this.f63813a.f63807b).h1(k.d(this.f63813a.f63809d.v(this.f63813a.f63810e)));
                        ((FrsCommonTabFragment) this.f63813a.f63807b).Y0().w(true);
                    }
                    this.f63813a.f();
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
        this.f63810e = -1;
        this.f63812g = new C1692a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f63807b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f63806a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f63808c = (TextView) this.f63806a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f63806a.findViewById(R.id.sort_tab_switch_btn);
        this.f63809d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f63812g);
        this.f63810e = this.f63809d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f63809d.v(this.f63810e));
            statisticItem.param("fid", this.f63811f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f63809d == null) {
            return;
        }
        this.f63809d.s(k.f(i2));
        this.f63810e = this.f63809d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f63809d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.C();
            }
            SkinManager.setViewTextColor(this.f63808c, R.color.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f63809d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f63811f = str;
        }
    }
}
