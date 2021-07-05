package d.a.s0.g1.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.s0.u0.s;
import d.a.s0.u0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f59721a;

    /* renamed from: b  reason: collision with root package name */
    public View f59722b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f59723c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f59724d;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59722b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f59723c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f59723c.setFadingEdgeLength(0);
        this.f59723c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f59724d = pbListView;
        pbListView.a();
        this.f59724d.o(R.color.CAM_X0205);
        this.f59724d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f59724d.v();
        this.f59724d.E(R.dimen.tbfontsize33);
        this.f59724d.y(R.color.CAM_X0110);
        this.f59723c.setNextPage(this.f59724d);
        this.f59724d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f59724d.f();
        this.f59724d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f59721a = new b(tbPageContext, this.f59723c);
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59722b : (View) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f59723c;
            if (bdTypeRecyclerView == null) {
                return false;
            }
            return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            PbListView pbListView = this.f59724d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f59724d.d(skinType);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f59723c;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
                return;
            }
            this.f59723c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59723c.scrollToPosition(0);
        }
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f59723c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageTag) == null) {
            this.f59721a.a(tbPageTag);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.f59723c.setVisibility(0);
            } else {
                this.f59723c.setVisibility(8);
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            t tVar = new t();
            tVar.f67022a = 401;
            tVar.f67023b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new s());
            this.f59723c.setData(arrayList);
        }
    }
}
