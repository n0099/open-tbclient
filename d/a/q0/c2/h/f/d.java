package d.a.q0.c2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.d1.e.a;
import d.a.p0.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class d implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f55370e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDragSortListView f55371f;

    /* renamed from: g  reason: collision with root package name */
    public View f55372g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.c2.h.d.a f55373h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.c2.h.f.b f55374i;
    public g j;
    public FrameLayout k;
    public boolean l;
    public d.a.q0.c2.h.b.a m;
    public NoDataView n;
    public NoNetworkView o;

    /* loaded from: classes8.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f55375a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55375a = dVar;
        }

        @Override // d.a.p0.d1.e.a.i
        public void drop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f55375a.f55373h.a(i2, i3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f55376e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f55377f;

        public b(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55377f = dVar;
            this.f55376e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55377f.j();
                if (this.f55377f.f55373h == null || this.f55376e == null) {
                    return;
                }
                this.f55377f.f55373h.c(this.f55376e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f55378e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55378e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55378e.f55373h == null) {
                return;
            }
            this.f55378e.f55373h.b();
        }
    }

    public d(TbPageContext tbPageContext) {
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
        this.l = false;
        this.f55370e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.f55372g = inflate;
        this.k = (FrameLayout) inflate.findViewById(R.id.my_emotion_loading);
        this.o = (NoNetworkView) this.f55372g.findViewById(R.id.view_no_network);
        this.f55374i = new d.a.q0.c2.h.f.b(this.f55372g.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.f55372g.findViewById(R.id.my_emotion_list);
        this.f55371f = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.f55371f.setOverScrollMode(2);
        this.f55371f.setVerticalScrollBarEnabled(false);
        k();
        this.f55373h = new d.a.q0.c2.h.d.a(tbPageContext, this.f55371f, this.m);
        l();
        this.o.a(this);
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
            l();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55372g : (View) invokeV.objValue;
    }

    public void e() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.j == null || (frameLayout = this.k) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.j.dettachView(this.k);
        this.j = null;
    }

    public final void f() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (noDataView = this.n) != null && noDataView.getParent() == this.k) {
            this.n.setVisibility(8);
            this.k.removeView(this.n);
            this.k.setVisibility(8);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            d.a.q0.c2.h.f.b bVar = this.f55374i;
            if (bVar != null) {
                bVar.b(i2);
            }
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i2);
            }
            d.a.q0.c2.h.f.b bVar2 = this.f55374i;
            if (bVar2 != null) {
                SkinManager.setBackgroundColor(bVar2.a(), R.color.CAM_X0201, i2);
            }
            SimpleDragSortListView simpleDragSortListView = this.f55371f;
            if (simpleDragSortListView != null) {
                SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i2);
            }
            NoNetworkView noNetworkView = this.o;
            if (noNetworkView != null) {
                noNetworkView.c(this.f55370e, i2);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.d.e.m.e.a().post(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e();
            f();
        }
    }

    public final void j() {
        SimpleDragSortListView simpleDragSortListView;
        d.a.q0.c2.h.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (simpleDragSortListView = this.f55371f) == null || this.l || (bVar = this.f55374i) == null) {
            return;
        }
        this.l = true;
        simpleDragSortListView.setEmptyView(bVar.a());
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.c2.h.b.a aVar = new d.a.q0.c2.h.b.a(this.f55371f);
            this.m = aVar;
            aVar.c(new a(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f55370e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        g gVar = new g(this.f55370e.getPageActivity());
        this.j = gVar;
        gVar.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f55370e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f55370e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f55370e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f55370e.getString(R.string.emotion_error_net_tip)), null, true);
        this.n = b2;
        b2.setVisibility(0);
        this.n.d(this.f55370e);
    }

    public void n(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            d.a.d.e.m.e.a().post(new b(this, list));
        }
    }
}
