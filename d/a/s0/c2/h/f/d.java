package d.a.s0.c2.h.f;

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
import d.a.r0.b1.e.a;
import d.a.r0.d0.g;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f58081e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDragSortListView f58082f;

    /* renamed from: g  reason: collision with root package name */
    public View f58083g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.c2.h.d.a f58084h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.c2.h.f.b f58085i;
    public g j;
    public FrameLayout k;
    public boolean l;
    public d.a.s0.c2.h.b.a m;
    public NoDataView n;
    public NoNetworkView o;

    /* loaded from: classes9.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f58086a;

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
            this.f58086a = dVar;
        }

        @Override // d.a.r0.b1.e.a.i
        public void drop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f58086a.f58084h.a(i2, i3);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f58087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f58088f;

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
            this.f58088f = dVar;
            this.f58087e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58088f.j();
                if (this.f58088f.f58084h == null || this.f58087e == null) {
                    return;
                }
                this.f58088f.f58084h.c(this.f58087e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f58089e;

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
            this.f58089e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58089e.f58084h == null) {
                return;
            }
            this.f58089e.f58084h.b();
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
        this.f58081e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.f58083g = inflate;
        this.k = (FrameLayout) inflate.findViewById(R.id.my_emotion_loading);
        this.o = (NoNetworkView) this.f58083g.findViewById(R.id.view_no_network);
        this.f58085i = new d.a.s0.c2.h.f.b(this.f58083g.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.f58083g.findViewById(R.id.my_emotion_list);
        this.f58082f = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.f58082f.setOverScrollMode(2);
        this.f58082f.setVerticalScrollBarEnabled(false);
        k();
        this.f58084h = new d.a.s0.c2.h.d.a(tbPageContext, this.f58082f, this.m);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58083g : (View) invokeV.objValue;
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
            d.a.s0.c2.h.f.b bVar = this.f58085i;
            if (bVar != null) {
                bVar.b(i2);
            }
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i2);
            }
            d.a.s0.c2.h.f.b bVar2 = this.f58085i;
            if (bVar2 != null) {
                SkinManager.setBackgroundColor(bVar2.a(), R.color.CAM_X0201, i2);
            }
            SimpleDragSortListView simpleDragSortListView = this.f58082f;
            if (simpleDragSortListView != null) {
                SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i2);
            }
            NoNetworkView noNetworkView = this.o;
            if (noNetworkView != null) {
                noNetworkView.c(this.f58081e, i2);
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
        d.a.s0.c2.h.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (simpleDragSortListView = this.f58082f) == null || this.l || (bVar = this.f58085i) == null) {
            return;
        }
        this.l = true;
        simpleDragSortListView.setEmptyView(bVar.a());
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.s0.c2.h.b.a aVar = new d.a.s0.c2.h.b.a(this.f58082f);
            this.m = aVar;
            aVar.c(new a(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f58081e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        g gVar = new g(this.f58081e.getPageActivity());
        this.j = gVar;
        gVar.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f58081e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f58081e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f58081e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f58081e.getString(R.string.emotion_error_net_tip)), null, true);
        this.n = b2;
        b2.setVisibility(0);
        this.n.d(this.f58081e);
    }

    public void n(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            d.a.c.e.m.e.a().post(new b(this, list));
        }
    }
}
