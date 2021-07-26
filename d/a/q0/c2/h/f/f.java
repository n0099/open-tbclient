package d.a.q0.c2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class f implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f55384e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f55385f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.c2.h.d.b f55386g;

    /* renamed from: h  reason: collision with root package name */
    public b f55387h;

    /* renamed from: i  reason: collision with root package name */
    public View f55388i;
    public g j;
    public FrameLayout k;
    public NoDataView l;
    public boolean m;
    public NoNetworkView n;

    public f(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.f55384e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.f55388i = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.a(this);
        this.k = (FrameLayout) this.f55388i.findViewById(R.id.single_emotion_loading);
        this.f55385f = (BdListView) this.f55388i.findViewById(R.id.emotion_single_thread_list);
        this.f55387h = new b(this.f55388i.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.f55385f.setDivider(null);
        this.f55385f.setOverScrollMode(2);
        this.f55385f.setVerticalScrollBarEnabled(false);
        this.f55386g = new d.a.q0.c2.h.d.b(tbPageContext, this.f55385f);
        h();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55388i : (View) invokeV.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    public void c() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.j == null || (frameLayout = this.k) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.j.dettachView(this.k);
        this.j = null;
    }

    public final void d() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (noDataView = this.l) != null && noDataView.getParent() == this.k) {
            this.l.setVisibility(8);
            this.k.removeView(this.l);
            this.k.setVisibility(8);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            View view = this.f55388i;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
            }
            BdListView bdListView = this.f55385f;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i2);
            }
            b bVar = this.f55387h;
            if (bVar != null) {
                bVar.b(i2);
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.c(this.f55384e, i2);
            }
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i2);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c();
            d();
        }
    }

    public final void g() {
        BdListView bdListView;
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdListView = this.f55385f) == null || this.m || (bVar = this.f55387h) == null) {
            return;
        }
        this.m = true;
        bdListView.setEmptyView(bVar.a());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f55384e == null || this.k == null) {
            return;
        }
        f();
        this.k.setVisibility(0);
        if (this.j == null) {
            this.j = new g(this.f55384e.getPageActivity());
        }
        this.j.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f55384e == null || this.k == null) {
            return;
        }
        f();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f55384e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f55384e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f55384e.getString(R.string.emotion_error_net_tip)), null, true);
        this.l = b2;
        b2.setVisibility(0);
        this.l.d(this.f55384e);
    }

    public void j(List<EmotionPackageData> list) {
        d.a.q0.c2.h.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            g();
            if (list == null || (bVar = this.f55386g) == null) {
                return;
            }
            bVar.a(list);
        }
    }
}
