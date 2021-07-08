package d.a.p0.e3.k;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.v;
import d.a.o0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56090a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f56091b;

    /* renamed from: c  reason: collision with root package name */
    public g f56092c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f56093d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f56094e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f56095f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f56096g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f56097h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f56098i;
    public d.a.p0.e3.e.a j;
    public BdListView.p k;
    public BdListView.p l;
    public final View m;

    /* loaded from: classes8.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56099e;

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
            this.f56099e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56099e.f56096g != null) {
                    this.f56099e.f56096g.stopScroll();
                }
                if (this.f56099e.k != null) {
                    this.f56099e.k.onScrollToBottom();
                }
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.f56090a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.f56096g.getFirstVisiblePosition();
            View childAt = this.f56096g.getChildAt(0);
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
        }
        return (Pair) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56095f.g() : (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f56096g.setNextPage(null);
        }
    }

    public void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f56092c) == null) {
            return;
        }
        gVar.dettachView(this.f56091b);
        this.f56092c = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f56090a.getPageActivity());
            this.f56094e = linearLayoutManager;
            this.f56093d.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.f56090a.getPageActivity());
            this.f56095f = leftAdapter;
            this.f56093d.setAdapter(leftAdapter);
            this.j = new d.a.p0.e3.e.a(this.f56090a, this.f56096g);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f56090a.getPageActivity());
            this.f56097h = linearLayoutManager2;
            this.f56096g.setLayoutManager(linearLayoutManager2);
            this.f56096g.setFadingEdgeLength(0);
            this.f56096g.setOverScrollMode(2);
            this.f56096g.setOnSrollToBottomListener(this.l);
            PbListView pbListView = new PbListView(this.f56090a.getPageActivity());
            this.f56098i = pbListView;
            pbListView.b();
            this.f56098i.o(R.color.CAM_X0205);
            this.f56098i.r(l.g(this.f56090a.getPageActivity(), R.dimen.tbds182));
            this.f56098i.v();
            this.f56098i.E(R.dimen.tbfontsize33);
            this.f56098i.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56098i.y(R.color.CAM_X0110);
            this.f56098i.q();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f56091b = (RelativeLayout) this.m.findViewById(R.id.right_container);
            this.f56093d = (RecyclerView) this.m.findViewById(R.id.rv_left);
            this.f56096g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.f56092c;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f56096g.setNextPage(this.f56098i);
            this.f56098i.i();
            this.f56098i.b().setPadding(0, l.g(this.f56090a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f56090a.getPageActivity(), R.dimen.tbds362));
            this.f56098i.A(this.f56090a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
            this.f56098i.f();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f56096g.setNextPage(this.f56098i);
            this.f56098i.i();
            this.f56098i.b().setPadding(0, 0, 0, 0);
            this.f56098i.L();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f56096g.setNextPage(this.f56098i);
            this.f56098i.i();
            this.f56098i.b().setPadding(0, 0, 0, 0);
            this.f56098i.A(this.f56090a.getPageActivity().getString(R.string.pb_load_more));
            this.f56098i.f();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            d.a.p0.e3.e.a aVar = this.j;
            if (aVar != null) {
                aVar.b();
            }
            LeftAdapter leftAdapter = this.f56095f;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.f56098i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f56098i.d(i2);
            }
            g gVar = this.f56092c;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (bdTypeRecyclerView = this.f56096g) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f56096g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f56096g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.f56095f.j(position, list);
            if (z) {
                z(position);
            }
        }
    }

    public void p(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            q(list, 0);
        }
    }

    public void q(List<n> list, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, list, i2) == null) {
            if (ListUtils.isEmpty(list)) {
                r();
                return;
            }
            if (i2 > 0) {
                Pair<Integer, Integer> c2 = c();
                int intValue = ((Integer) c2.first).intValue();
                int intValue2 = ((Integer) c2.second).intValue();
                int i3 = intValue - i2;
                if (this.f56097h != null && (bdTypeRecyclerView = this.f56096g) != null) {
                    bdTypeRecyclerView.z();
                    this.f56097h.scrollToPositionWithOffset(i3, intValue2);
                    this.f56096g.A();
                }
            }
            this.j.c(list);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f41934e = this.f56090a.getString(R.string.forum_square_list_no_data);
            vVar.f41935f = R.drawable.new_pic_emotion_06;
            arrayList.add(vVar);
            this.j.c(arrayList);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f56093d.setVisibility(i2);
            this.f56096g.setVisibility(i2);
        }
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || (leftAdapter = this.f56095f) == null) {
            return;
        }
        leftAdapter.k(bVar);
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) || (bdTypeRecyclerView = this.f56096g) == null) {
            return;
        }
        bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
        this.f56096g.addOnScrollListener(onScrollListener);
    }

    public void v(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.k = pVar;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f56096g.setVisibility(i2);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || str == null) {
            return;
        }
        int f2 = this.f56095f.f(str);
        this.f56095f.l(f2);
        z(f2);
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || i()) {
            return;
        }
        if (this.f56092c == null) {
            g gVar = new g(this.f56090a.getPageActivity());
            this.f56092c = gVar;
            gVar.q(this.f56090a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f56092c.onChangeSkinType();
        this.f56092c.attachView(this.f56091b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && (recyclerView = this.f56093d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f56093d.getLayoutManager();
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > this.f56095f.getItemCount() - 1) {
                i2 = this.f56095f.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i2, 0);
        }
    }
}
