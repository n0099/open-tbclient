package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionVoteEntryView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pu4;
import java.util.List;
/* loaded from: classes7.dex */
public class r96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public qu4 c;
    public RelativeLayout d;
    public NoNetworkView e;
    public PbListView f;
    public b96 g;
    public ForumEmotionVoteEntryView h;
    public x45 i;
    public NoDataView j;
    public LinearLayout k;

    public r96(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02d6, (ViewGroup) null);
        this.d = relativeLayout;
        this.e = (NoNetworkView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0915ac);
        BdTypeListView bdTypeListView = (BdTypeListView) this.d.findViewById(R.id.obfuscated_res_0x7f090a30);
        this.b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.b.setDivider(null);
        qu4 qu4Var = new qu4(this.a);
        this.c = qu4Var;
        qu4Var.a0(bdUniqueId);
        this.b.setPullRefresh(this.c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.z();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.b.setNextPage(null);
        }
    }

    public void g() {
        x45 x45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (x45Var = this.i) == null) {
            return;
        }
        x45Var.dettachView(this.d);
        this.i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.g.c().setVisibility(0);
            this.h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b96 b96Var = new b96(this.a);
            this.g = b96Var;
            b96Var.c().setVisibility(8);
            this.b.addHeaderView(this.g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.a.getPageActivity());
            this.h = forumEmotionVoteEntryView;
            this.b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f.p(R.color.CAM_X0204);
            this.f.d(i);
            this.c.H(i);
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.e.c(this.a, i);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.h;
            if (forumEmotionVoteEntryView != null) {
                forumEmotionVoteEntryView.b(i);
            }
        }
    }

    public void m(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, forumEmotionData) == null) || forumEmotionData == null) {
            return;
        }
        g();
        if (forumEmotionData.banner != null) {
            this.g.c().setVisibility(0);
            this.g.f(this.a.getUniqueId());
            this.g.e(new f96(forumEmotionData.banner));
            this.g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.h.setAvatarList(list);
        }
    }

    public void n(pu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.c.e(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.b.setNextPage(this.f);
        }
        this.f.O();
        this.f.Q();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.d == null) {
            return;
        }
        x45 x45Var = new x45(tbPageContext.getPageActivity());
        this.i = x45Var;
        x45Var.attachView(this.d, false);
        this.i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, mi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070239)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f0549)), null, true);
            }
            this.j.setVisibility(0);
            this.g.c().setVisibility(4);
            this.h.setVisibility(4);
            this.j.f(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.b.setNextPage(this.f);
        }
        this.f.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ee));
        this.f.f();
    }
}
