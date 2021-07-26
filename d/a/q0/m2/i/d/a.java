package d.a.q0.m2.i.d;

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
import d.a.d.e.p.l;
import d.a.q0.m2.c.n;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60957a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f60958b;

    /* renamed from: c  reason: collision with root package name */
    public View f60959c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f60960d;

    /* renamed from: e  reason: collision with root package name */
    public n f60961e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f60962f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f60963g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.o0.b f60964h;

    /* renamed from: i  reason: collision with root package name */
    public int f60965i;

    /* renamed from: d.a.q0.m2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1552a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1552a(a aVar, Context context) {
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

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60966a;

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
            this.f60966a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f60966a.f60964h == null) {
                    this.f60966a.f60964h = new d.a.p0.o0.b();
                    this.f60966a.f60964h.a(this.f60966a.f60965i);
                }
                if (i2 == 0) {
                    this.f60966a.f60964h.e();
                } else {
                    this.f60966a.f60964h.d();
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
        this.f60964h = null;
        this.f60965i = 1010;
        this.f60957a = tbPageContext;
        this.f60959c = view;
        this.f60962f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f60958b.s(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60961e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60959c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f60958b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f60959c.findViewById(R.id.new_person_center_common_lv);
            this.f60958b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1552a(this, bdTypeRecyclerView.getContext()));
            this.f60958b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.f60957a.getPageActivity());
            this.f60960d = pbListView;
            pbListView.a();
            this.f60960d.o(R.color.CAM_X0205);
            this.f60960d.r(l.g(this.f60957a.getPageActivity(), R.dimen.tbds182));
            this.f60960d.v();
            this.f60960d.E(R.dimen.tbfontsize33);
            this.f60960d.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f60960d.y(R.color.CAM_X0110);
            n nVar = new n(this.f60957a, this.f60958b, this.f60962f.getUniqueId());
            this.f60961e = nVar;
            nVar.d(this.f60962f.O0());
            this.f60961e.h(32);
            if (this.f60962f.O0()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f60962f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f60961e.f(i2);
                this.f60961e.g(this.f60962f.N0());
            }
            i2 = 0;
            this.f60961e.f(i2);
            this.f60961e.g(this.f60962f.N0());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f60959c, R.color.CAM_X0201);
            n nVar = this.f60961e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f60963g;
            if (noDataView != null) {
                noDataView.f(this.f60957a, i2);
            }
            PbListView pbListView = this.f60960d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f60960d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.p0.o0.b bVar = this.f60964h;
            if (bVar != null) {
                bVar.c();
            }
            this.f60958b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f60958b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f60958b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f60965i = i2;
        }
    }

    public void n(List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f60958b.getHeaderViewsCount() == 0) {
                    p(R.string.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f60963g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f60958b.removeHeaderView(this.f60963g);
                }
            }
            this.f60958b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f60962f.N0())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f60958b.setNextPage(this.f60960d);
            this.f60960d.J(0);
            this.f60960d.O();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f60962f.N0() == 1) {
                string = this.f60962f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
            } else {
                string = this.f60962f.getResources().getString(R.string.person_center_listempty_thread_txt);
            }
            if (this.f60963g == null) {
                this.f60963g = NoDataViewFactory.a(this.f60957a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f60963g.f(this.f60957a, TbadkApplication.getInst().getSkinType());
            this.f60963g.setVisibility(0);
            this.f60958b.removeHeaderView(this.f60963g);
            this.f60963g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f60958b.s(this.f60963g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f60958b.setNextPage(this.f60960d);
            this.f60960d.J(0);
            this.f60960d.f();
            this.f60960d.A(this.f60957a.getString(R.string.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f60958b.setNextPage(this.f60960d);
            this.f60960d.J(0);
            this.f60960d.f();
            this.f60960d.A(this.f60957a.getString(i2));
        }
    }
}
