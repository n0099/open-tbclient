package d.a.s0.m2.i.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.m2.c.n;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63580a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63581b;

    /* renamed from: c  reason: collision with root package name */
    public View f63582c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f63583d;

    /* renamed from: e  reason: collision with root package name */
    public n f63584e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f63585f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f63586g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.m0.b f63587h;

    /* renamed from: i  reason: collision with root package name */
    public int f63588i;

    /* renamed from: d.a.s0.m2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1591a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1591a(a aVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63589a;

        public b(a aVar) {
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
            this.f63589a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f63589a.f63587h == null) {
                    this.f63589a.f63587h = new d.a.r0.m0.b();
                    this.f63589a.f63587h.a(this.f63589a.f63588i);
                }
                if (i2 == 0) {
                    this.f63589a.f63587h.e();
                } else {
                    this.f63589a.f63587h.d();
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, personCenterTabBaseFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63587h = null;
        this.f63588i = 1010;
        this.f63580a = tbPageContext;
        this.f63582c = view;
        this.f63585f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f63581b.s(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63584e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63582c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f63581b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f63582c.findViewById(R.id.new_person_center_common_lv);
            this.f63581b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1591a(this, bdTypeRecyclerView.getContext()));
            this.f63581b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.f63580a.getPageActivity());
            this.f63583d = pbListView;
            pbListView.a();
            this.f63583d.o(R.color.CAM_X0205);
            this.f63583d.r(l.g(this.f63580a.getPageActivity(), R.dimen.tbds182));
            this.f63583d.v();
            this.f63583d.E(R.dimen.tbfontsize33);
            this.f63583d.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f63583d.y(R.color.CAM_X0110);
            n nVar = new n(this.f63580a, this.f63581b, this.f63585f.getUniqueId());
            this.f63584e = nVar;
            nVar.d(this.f63585f.I0());
            this.f63584e.h(32);
            if (this.f63585f.I0()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f63585f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f63584e.f(i2);
                this.f63584e.g(this.f63585f.H0());
            }
            i2 = 0;
            this.f63584e.f(i2);
            this.f63584e.g(this.f63585f.H0());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f63582c, R.color.CAM_X0201);
            n nVar = this.f63584e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f63586g;
            if (noDataView != null) {
                noDataView.f(this.f63580a, i2);
            }
            PbListView pbListView = this.f63583d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f63583d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.r0.m0.b bVar = this.f63587h;
            if (bVar != null) {
                bVar.c();
            }
            this.f63581b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f63581b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f63581b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f63588i = i2;
        }
    }

    public void n(List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f63581b.getHeaderViewsCount() == 0) {
                    p(R.string.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f63586g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f63581b.removeHeaderView(this.f63586g);
                }
            }
            this.f63581b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f63585f.H0())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f63581b.setNextPage(this.f63583d);
            this.f63583d.J(0);
            this.f63583d.O();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f63585f.H0() == 1) {
                string = this.f63585f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
            } else {
                string = this.f63585f.getResources().getString(R.string.person_center_listempty_thread_txt);
            }
            if (this.f63586g == null) {
                this.f63586g = NoDataViewFactory.a(this.f63580a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f63586g.f(this.f63580a, TbadkApplication.getInst().getSkinType());
            this.f63586g.setVisibility(0);
            this.f63581b.removeHeaderView(this.f63586g);
            this.f63586g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f63581b.s(this.f63586g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f63581b.setNextPage(this.f63583d);
            this.f63583d.J(0);
            this.f63583d.f();
            this.f63583d.A(this.f63580a.getString(R.string.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f63581b.setNextPage(this.f63583d);
            this.f63583d.J(0);
            this.f63583d.f();
            this.f63583d.A(this.f63580a.getString(i2));
        }
    }
}
