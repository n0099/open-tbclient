package d.a.p0.c2.h.f;

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
import d.a.c.e.p.l;
import d.a.o0.b1.e.a;
import d.a.o0.d0.g;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f54826e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDragSortListView f54827f;

    /* renamed from: g  reason: collision with root package name */
    public View f54828g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.c2.h.d.a f54829h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.c2.h.f.b f54830i;
    public g j;
    public FrameLayout k;
    public boolean l;
    public d.a.p0.c2.h.b.a m;
    public NoDataView n;
    public NoNetworkView o;

    /* loaded from: classes7.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f54831a;

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
            this.f54831a = dVar;
        }

        @Override // d.a.o0.b1.e.a.i
        public void drop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f54831a.f54829h.a(i2, i3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f54832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f54833f;

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
            this.f54833f = dVar;
            this.f54832e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54833f.j();
                if (this.f54833f.f54829h == null || this.f54832e == null) {
                    return;
                }
                this.f54833f.f54829h.c(this.f54832e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f54834e;

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
            this.f54834e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54834e.f54829h == null) {
                return;
            }
            this.f54834e.f54829h.b();
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
        this.f54826e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.f54828g = inflate;
        this.k = (FrameLayout) inflate.findViewById(R.id.my_emotion_loading);
        this.o = (NoNetworkView) this.f54828g.findViewById(R.id.view_no_network);
        this.f54830i = new d.a.p0.c2.h.f.b(this.f54828g.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.f54828g.findViewById(R.id.my_emotion_list);
        this.f54827f = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.f54827f.setOverScrollMode(2);
        this.f54827f.setVerticalScrollBarEnabled(false);
        k();
        this.f54829h = new d.a.p0.c2.h.d.a(tbPageContext, this.f54827f, this.m);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54828g : (View) invokeV.objValue;
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
            d.a.p0.c2.h.f.b bVar = this.f54830i;
            if (bVar != null) {
                bVar.b(i2);
            }
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i2);
            }
            d.a.p0.c2.h.f.b bVar2 = this.f54830i;
            if (bVar2 != null) {
                SkinManager.setBackgroundColor(bVar2.a(), R.color.CAM_X0201, i2);
            }
            SimpleDragSortListView simpleDragSortListView = this.f54827f;
            if (simpleDragSortListView != null) {
                SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i2);
            }
            NoNetworkView noNetworkView = this.o;
            if (noNetworkView != null) {
                noNetworkView.c(this.f54826e, i2);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.c.e.m.e.a().post(new c(this));
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
        d.a.p0.c2.h.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (simpleDragSortListView = this.f54827f) == null || this.l || (bVar = this.f54830i) == null) {
            return;
        }
        this.l = true;
        simpleDragSortListView.setEmptyView(bVar.a());
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.p0.c2.h.b.a aVar = new d.a.p0.c2.h.b.a(this.f54827f);
            this.m = aVar;
            aVar.c(new a(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f54826e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        g gVar = new g(this.f54826e.getPageActivity());
        this.j = gVar;
        gVar.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f54826e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f54826e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f54826e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f54826e.getString(R.string.emotion_error_net_tip)), null, true);
        this.n = b2;
        b2.setVisibility(0);
        this.n.d(this.f54826e);
    }

    public void n(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            d.a.c.e.m.e.a().post(new b(this, list));
        }
    }
}
