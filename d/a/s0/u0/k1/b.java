package d.a.s0.u0.k1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.s0.a0.t;
import d.a.s0.n2.i;
import d.a.s0.u0.h0;
import d.a.s0.u0.l0;
import d.a.s0.u0.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f66204a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f66205b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f66206c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.u0.k1.a f66207d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.u0.k1.d f66208e;

    /* renamed from: f  reason: collision with root package name */
    public i f66209f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f66210g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.u0.m1.f.a.a f66211h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66212i;
    public h0 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66213e;

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
            this.f66213e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f66213e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: d.a.s0.u0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1723b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66214e;

        public C1723b(b bVar) {
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
            this.f66214e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f66214e.f66205b != null) {
                    this.f66214e.f66205b.stopScroll();
                }
                if (this.f66214e.f66206c == null || this.f66214e.f66204a == null) {
                    return;
                }
                if (j.z()) {
                    this.f66214e.f66205b.setNextPage(this.f66214e.f66206c);
                    this.f66214e.f66206c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f66214e.f66206c.z(null);
                    if (this.f66214e.f66212i) {
                        this.f66214e.f66206c.L();
                        this.f66214e.f66206c.z(null);
                        this.f66214e.f66204a.W0();
                        return;
                    }
                    this.f66214e.f66206c.A(this.f66214e.f66204a.getResources().getString(R.string.list_has_no_more));
                    this.f66214e.f66206c.f();
                    this.f66214e.f66206c.z(null);
                    return;
                }
                this.f66214e.f66205b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f66215a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f66216b;

        public c(b bVar) {
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
            this.f66216b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f66216b.f66209f != null) {
                    this.f66216b.f66209f.n(this.f66216b.f66205b.getFirstVisiblePosition(), this.f66216b.f66205b.getLastVisiblePosition(), this.f66215a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f66215a = false;
                } else {
                    this.f66215a = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66217a;

        public d(b bVar) {
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
            this.f66217a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f66217a.f66209f != null) {
                    this.f66217a.f66209f.k(view);
                }
                if (view != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.h();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.p();
                    }
                    if (view instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view).reset();
                    }
                }
            }
        }
    }

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, view, frsViewData};
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
        this.m = new C1723b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f66204a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f66205b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f66204a.getContext()));
        this.f66205b.setFadingEdgeLength(0);
        this.f66205b.setOverScrollMode(2);
        this.f66205b.setOnSrollToBottomListener(this.m);
        this.f66205b.addOnScrollListener(this.n);
        this.f66205b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f66205b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f66205b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f66204a.getPageContext().getPageActivity());
        this.f66206c = pbListView;
        pbListView.b();
        this.f66206c.o(R.color.transparent);
        this.f66206c.r(l.g(this.f66204a.getActivity(), R.dimen.tbds182));
        this.f66206c.v();
        this.f66206c.E(R.dimen.tbfontsize33);
        this.f66206c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f66206c.y(R.color.CAM_X0110);
        this.f66206c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f66204a;
        this.f66207d = new d.a.s0.u0.k1.a(frsCommonTabFragment2, this.f66205b, frsViewData, frsCommonTabFragment2.l == 16);
        w(false);
        if (this.f66209f == null) {
            this.f66209f = new i(this.f66204a.getPageContext(), this.f66205b);
        }
        this.f66209f.p(1);
        this.f66209f.t(this.f66204a.getUniqueId());
        if (g()) {
            this.f66210g = new RelativeLayout(this.f66204a.getContext());
            this.f66210g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f66211h = new d.a.s0.u0.m1.f.a.a(this.f66204a, this.f66210g);
            this.f66205b.t(this.f66210g, 0);
            this.f66211h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f66204a;
        if (frsCommonTabFragment3.l == 16) {
            h0 h0Var = new h0(frsCommonTabFragment3);
            this.j = h0Var;
            this.f66205b.t(h0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f66204a;
            if (frsCommonTabFragment != null) {
                return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<FrsTabInfo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 2;
            builder.tab_type = Integer.valueOf(this.f66204a.l);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f66204a.l);
            FrsTabInfo build2 = builder2.build(true);
            arrayList.add(build);
            arrayList.add(build2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66209f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66205b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<n> arrayList, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i2)) == null) {
            if (ListUtils.isEmpty(arrayList) || i2 < 0) {
                return false;
            }
            if (i2 == 0) {
                return true;
            }
            int i4 = 1;
            while (i3 < arrayList.size() && i4 <= i2) {
                if (arrayList.get(i3) instanceof a2) {
                    int i5 = i3 - 1;
                    i3 = ((arrayList.get(i5) instanceof a2) && ((a2) arrayList.get(i3)).position == ((a2) arrayList.get(i5)).position) ? i3 + 1 : 1;
                }
                i4++;
            }
            return i4 > i2;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            d.a.s0.u0.k1.a aVar = this.f66207d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f66206c;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f66206c.d(i2);
            }
            d.a.s0.u0.m1.f.a.a aVar2 = this.f66211h;
            if (aVar2 != null) {
                aVar2.h();
            }
            h0 h0Var = this.j;
            if (h0Var != null) {
                h0Var.b();
            }
        }
    }

    public void m(String str) {
        d.a.s0.u0.k1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f66208e) == null || ListUtils.isEmpty(dVar.f66225g)) {
            return;
        }
        Iterator<n> it = this.f66208e.f66225g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            b2 b2Var = null;
            if (next instanceof a2) {
                b2Var = ((a2) next).w;
            } else if (next instanceof b2) {
                b2Var = (b2) next;
            }
            if (b2Var != null && TextUtils.equals(str, b2Var.c0())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f66208e.f66225g)) {
            this.f66208e.f66225g.add(new s());
        }
        this.f66207d.i(this.f66208e.f66225g);
        this.f66207d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f66209f;
            if (iVar != null) {
                iVar.h();
            }
            d.a.s0.u0.k1.a aVar = this.f66207d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(d.a.s0.u0.k1.d dVar) {
        h0 h0Var;
        d.a.s0.u0.m1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f66212i = dVar.f66223e;
        if (ListUtils.isEmpty(dVar.f66225g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f66225g = arrayList;
            arrayList.add(sVar);
            dVar.f66223e = false;
        }
        this.f66208e = dVar;
        this.f66206c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f66212i) {
            this.f66205b.setNextPage(this.f66206c);
            if (k(dVar.f66225g, 3)) {
                this.f66206c.z(null);
                this.f66206c.K();
            } else {
                this.f66206c.K();
                this.f66206c.z(this.l);
                this.f66206c.A(this.f66204a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f66205b.setNextPage(null);
            this.f66206c.A(this.f66204a.getResources().getString(R.string.list_has_no_more));
            this.f66206c.z(null);
            this.f66206c.f();
        }
        this.f66207d.i(dVar.f66225g);
        this.f66207d.f();
        i iVar = this.f66209f;
        if (iVar != null) {
            iVar.n(this.f66205b.getFirstVisiblePosition(), this.f66205b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f66211h) != null) {
            aVar.g(this.f66204a.U0());
            this.f66211h.j(this.f66204a.f15508i);
        }
        this.k = dVar.n;
        if (this.f66204a.getFragmentActivity() instanceof l0) {
            ((l0) this.f66204a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f66204a.l != 16 || (h0Var = this.j) == null) {
            return;
        }
        h0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f66209f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f66207d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.s0.u0.t tVar = new d.a.s0.u0.t();
            tVar.f67022a = this.f66204a.k;
            tVar.f67023b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f66209f) == null) {
            return;
        }
        iVar.o();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f66205b.scrollToPosition(0);
        }
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdTypeRecyclerView = this.f66205b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z) {
        d.a.s0.u0.k1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.f66207d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f66204a == null) {
            return;
        }
        d.a.s0.u0.t tVar = new d.a.s0.u0.t();
        tVar.f67022a = this.f66204a.k;
        tVar.f67023b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onScrollListener) == null) {
            this.f66205b.setOnScrollListener(onScrollListener);
        }
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (bdTypeRecyclerView = this.f66205b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
