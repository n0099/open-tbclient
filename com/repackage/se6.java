package com.repackage;

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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public class se6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public PbListView c;
    public re6 d;
    public ue6 e;
    public j48 f;
    public RelativeLayout g;
    public ig6 h;
    public boolean i;
    public dc6 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se6 a;

        public a(se6 se6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se6 a;

        public b(se6 se6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b != null) {
                    this.a.b.stopScroll();
                }
                if (this.a.c == null || this.a.a == null) {
                    return;
                }
                if (ji.z()) {
                    this.a.b.setNextPage(this.a.c);
                    this.a.c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.c.B(null);
                    if (this.a.i) {
                        this.a.c.N();
                        this.a.c.B(null);
                        this.a.a.X0();
                        return;
                    }
                    this.a.c.C(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
                    this.a.c.f();
                    this.a.c.B(null);
                    return;
                }
                this.a.b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ se6 b;

        public c(se6 se6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.f != null) {
                    this.b.f.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, true);
                }
                gw5.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;
        public final /* synthetic */ se6 b;

        public d(se6 se6Var, FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se6Var, frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se6Var;
            this.a = frsCommonTabFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            FrsCommonTabFragment frsCommonTabFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.b.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
                    this.b.f.k(view2);
                    this.b.f.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), false, true);
                }
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f090029);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.k();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f090027);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.p();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        }
    }

    public se6(FrsCommonTabFragment frsCommonTabFragment, View view2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, view2, frsViewData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view2 == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090ac9);
        this.b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.b.setFadingEdgeLength(0);
        this.b.setOverScrollMode(2);
        this.b.setOnSrollToBottomListener(this.m);
        this.b.addOnScrollListener(this.n);
        this.b.setRecyclerListener(new d(this, frsCommonTabFragment));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.c = pbListView;
        pbListView.b();
        this.c.p(R.color.transparent);
        this.c.t(li.f(this.a.getActivity(), R.dimen.tbds182));
        this.c.x();
        this.c.G(R.dimen.tbfontsize33);
        this.c.E(SkinManager.getColor(R.color.CAM_X0107));
        this.c.A(R.color.CAM_X0110);
        this.c.s();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.d = new re6(frsCommonTabFragment2, this.b, frsViewData, frsCommonTabFragment2.h == 16);
        x(false);
        if (this.f == null) {
            this.f = new j48(this.a.getPageContext(), this.b);
        }
        if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
            this.f.p(2);
        } else {
            this.f.p(1);
        }
        this.f.u(this.a.getUniqueId());
        if (g()) {
            this.g = new RelativeLayout(this.a.getContext());
            this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.h = new ig6(this.a, this.g);
            this.b.t(this.g, 0);
            this.h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.h == 16) {
            dc6 dc6Var = new dc6(frsCommonTabFragment3);
            this.j = dc6Var;
            this.b.t(dc6Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment != null) {
                return frsCommonTabFragment.j == 1 || frsCommonTabFragment.h == 16;
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
            builder.tab_type = Integer.valueOf(this.a.h);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.a.h);
            FrsTabInfo build2 = builder2.build(true);
            arrayList.add(build);
            arrayList.add(build2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public j48 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (j48) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || i < 0) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int i3 = 1;
            while (i2 < arrayList.size() && i3 <= i) {
                if (arrayList.get(i2) instanceof rp4) {
                    int i4 = i2 - 1;
                    i2 = ((arrayList.get(i4) instanceof rp4) && ((rp4) arrayList.get(i2)).position == ((rp4) arrayList.get(i4)).position) ? i2 + 1 : 1;
                }
                i3++;
            }
            return i3 > i;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i) {
        re6 re6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (!UbsABTestHelper.isFeedVideoImmersionTransition() && (re6Var = this.d) != null) {
                re6Var.f();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.c.d(i);
            }
            ig6 ig6Var = this.h;
            if (ig6Var != null) {
                ig6Var.h();
            }
            dc6 dc6Var = this.j;
            if (dc6Var != null) {
                dc6Var.b();
            }
        }
    }

    public void m(String str) {
        ue6 ue6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (ue6Var = this.e) == null || ListUtils.isEmpty(ue6Var.c)) {
            return;
        }
        Iterator<jn> it = this.e.c.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            ThreadData threadData = null;
            if (next instanceof rp4) {
                threadData = ((rp4) next).s;
            } else if (next instanceof ThreadData) {
                threadData = (ThreadData) next;
            }
            if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.e.c)) {
            this.e.c.add(new nb6());
        }
        this.d.i(this.e.c);
        this.d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j48 j48Var = this.f;
            if (j48Var != null) {
                j48Var.h();
            }
            re6 re6Var = this.d;
            if (re6Var != null) {
                re6Var.g();
            }
        }
    }

    public void o(ue6 ue6Var) {
        dc6 dc6Var;
        ig6 ig6Var;
        FrsCommonTabFragment frsCommonTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ue6Var) == null) || ue6Var == null) {
            return;
        }
        this.i = ue6Var.a;
        if (ListUtils.isEmpty(ue6Var.c)) {
            nb6 nb6Var = new nb6();
            ArrayList<jn> arrayList = new ArrayList<>();
            ue6Var.c = arrayList;
            arrayList.add(nb6Var);
            ue6Var.a = false;
        }
        this.e = ue6Var;
        this.c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.b.setNextPage(this.c);
            if (k(ue6Var.c, 3)) {
                this.c.B(null);
                this.c.M();
            } else {
                this.c.M();
                this.c.B(this.l);
                this.c.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f2));
            }
        } else {
            this.b.setNextPage(null);
            this.c.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
            this.c.B(null);
            this.c.f();
        }
        this.d.i(ue6Var.c);
        this.d.f();
        if (this.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
            this.f.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
        if (this.a != null && g() && (ig6Var = this.h) != null) {
            ig6Var.g(this.a.V0());
            this.h.j(this.a.e);
        }
        this.k = ue6Var.j;
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        if (frsCommonTabFragment2 != null && (frsCommonTabFragment2.getFragmentActivity() instanceof hc6)) {
            ((hc6) this.a.getFragmentActivity()).setItemInfo(this.k);
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3 == null || frsCommonTabFragment3.h != 16 || (dc6Var = this.j) == null) {
            return;
        }
        dc6Var.c(this.k);
    }

    public void p() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (j48Var = this.f) == null) {
            return;
        }
        j48Var.y();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ob6 ob6Var = new ob6();
            ob6Var.a = this.a.g;
            ob6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ob6Var));
        }
    }

    public void s() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (j48Var = this.f) == null) {
            return;
        }
        j48Var.o();
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.b.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            if (this.i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        re6 re6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (re6Var = this.d) == null) {
            return;
        }
        re6Var.j(z);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.a == null) {
            return;
        }
        ob6 ob6Var = new ob6();
        ob6Var.a = this.a.g;
        ob6Var.b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ob6Var));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i);
    }
}
