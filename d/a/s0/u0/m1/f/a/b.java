package d.a.s0.u0.m1.f.a;

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
import d.a.c.e.p.j;
import d.a.r0.b.d;
import d.a.r0.z0.c0;
import d.a.s0.h3.n0.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66390a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f66391b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66392c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f66393d;

    /* renamed from: e  reason: collision with root package name */
    public String f66394e;

    /* renamed from: f  reason: collision with root package name */
    public int f66395f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f66396g;

    /* loaded from: classes9.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66397a;

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
            this.f66397a = bVar;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!d.a.s0.u0.b.e().g() && !d.a.s0.u0.a.h().j()) {
                    if (!j.A()) {
                        this.f66397a.f66391b.showToast(R.string.neterror);
                        return false;
                    } else if (this.f66397a.f66391b.d0() != null && this.f66397a.f66391b.B0() != null) {
                        z = true;
                        if (this.f66397a.f66395f == i2) {
                            return true;
                        }
                        this.f66397a.f66391b.d0().N0(this.f66397a.f66393d.v(this.f66397a.f66395f));
                        this.f66397a.f66395f = i2;
                        if (this.f66397a.f66395f != 7) {
                            c0.c();
                            e.a();
                        } else {
                            e.b();
                        }
                        this.f66397a.f66391b.d0().J0(this.f66397a.f66393d.v(this.f66397a.f66395f));
                        if (d.n()) {
                            d.a.r0.b.g.a.f(this.f66397a.f66393d.v(this.f66397a.f66395f));
                        }
                        this.f66397a.f66391b.d0().M0(true);
                        this.f66397a.f66391b.B0().N1();
                        this.f66397a.f66391b.d0().L0(true);
                        this.f66397a.f();
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
        this.f66395f = -1;
        this.f66396g = new a(this);
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f66391b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f66390a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f66392c = (TextView) this.f66390a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f66390a.findViewById(R.id.sort_tab_switch_btn);
        this.f66393d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f66396g);
        this.f66395f = this.f66393d.getState();
        i();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f66393d.v(this.f66395f));
            statisticItem.param("fid", this.f66394e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (frsTabSortSwitchButton = this.f66393d) == null) {
            return;
        }
        frsTabSortSwitchButton.s(i2);
        this.f66395f = this.f66393d.getState();
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66393d : (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f66393d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.C();
            }
            SkinManager.setViewTextColor(this.f66392c, R.color.CAM_X0108);
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (frsTabSortSwitchButton = this.f66393d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f66394e = str;
        }
    }
}
