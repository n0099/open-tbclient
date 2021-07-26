package d.a.q0.u0.m1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.p0.b.d;
import d.a.p0.b1.c0;
import d.a.q0.h3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f63814a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f63815b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63816c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f63817d;

    /* renamed from: e  reason: collision with root package name */
    public String f63818e;

    /* renamed from: f  reason: collision with root package name */
    public int f63819f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f63820g;

    /* loaded from: classes8.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63821a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63821a = bVar;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!d.a.q0.u0.b.e().g() && !d.a.q0.u0.a.h().j()) {
                    if (!j.A()) {
                        this.f63821a.f63815b.showToast(R.string.neterror);
                        return false;
                    } else if (this.f63821a.f63815b.g0() != null && this.f63821a.f63815b.G0() != null) {
                        z = true;
                        if (this.f63821a.f63819f == i2) {
                            return true;
                        }
                        this.f63821a.f63815b.g0().N0(this.f63821a.f63817d.v(this.f63821a.f63819f));
                        this.f63821a.f63819f = i2;
                        if (this.f63821a.f63819f != 7) {
                            c0.c();
                            e.a();
                        } else {
                            e.b();
                        }
                        this.f63821a.f63815b.g0().J0(this.f63821a.f63817d.v(this.f63821a.f63819f));
                        if (d.y()) {
                            d.a.p0.b.g.a.f(this.f63821a.f63817d.v(this.f63821a.f63819f));
                        }
                        this.f63821a.f63815b.g0().M0(true);
                        this.f63821a.f63815b.G0().O1();
                        this.f63821a.f63815b.g0().L0(true);
                        this.f63821a.f();
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63819f = -1;
        this.f63820g = new a(this);
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f63815b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f63814a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f63816c = (TextView) this.f63814a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f63814a.findViewById(R.id.sort_tab_switch_btn);
        this.f63817d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f63820g);
        this.f63819f = this.f63817d.getState();
        i();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f63817d.v(this.f63819f));
            statisticItem.param("fid", this.f63818e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (frsTabSortSwitchButton = this.f63817d) == null) {
            return;
        }
        frsTabSortSwitchButton.s(i2);
        this.f63819f = this.f63817d.getState();
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63817d : (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f63817d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.C();
            }
            SkinManager.setViewTextColor(this.f63816c, R.color.CAM_X0108);
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (frsTabSortSwitchButton = this.f63817d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f63818e = str;
        }
    }
}
