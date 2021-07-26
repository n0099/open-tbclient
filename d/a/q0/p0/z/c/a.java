package d.a.q0.p0.z.c;

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
import d.a.d.e.p.l;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.q0.p0.y.c.c;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61985a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61986b;

    /* renamed from: c  reason: collision with root package name */
    public g f61987c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61988d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61989e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f61990f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.p0.y.a f61991g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f61992h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.f0.g f61993i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61985a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f61988d = relativeLayout;
        this.f61989e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f61988d.findViewById(R.id.forum_emotion_list);
        this.f61986b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f61986b.setDivider(null);
        g gVar = new g(this.f61985a);
        this.f61987c = gVar;
        gVar.a0(bdUniqueId);
        this.f61986b.setPullRefresh(this.f61987c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61990f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61986b.z();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61986b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61989e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61988d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61992h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f61990f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f61986b.setNextPage(null);
        }
    }

    public void g() {
        d.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f61993i) == null) {
            return;
        }
        gVar.dettachView(this.f61988d);
        this.f61993i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f61991g.c().setVisibility(0);
            this.f61992h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.p0.y.a aVar = new d.a.q0.p0.y.a(this.f61985a);
            this.f61991g = aVar;
            aVar.c().setVisibility(8);
            this.f61986b.addHeaderView(this.f61991g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f61985a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f61986b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f61985a.getPageActivity());
            this.f61992h = forumEmotionVoteEntryView;
            this.f61986b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f61990f.o(R.color.CAM_X0204);
            this.f61990f.d(i2);
            this.f61987c.I(i2);
            this.f61986b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f61988d, R.color.CAM_X0201);
            this.f61989e.c(this.f61985a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f61992h;
            if (forumEmotionVoteEntryView != null) {
                forumEmotionVoteEntryView.b(i2);
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
            this.f61991g.c().setVisibility(0);
            this.f61991g.f(this.f61985a.getUniqueId());
            this.f61991g.e(new c(forumEmotionData.banner));
            this.f61991g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f61992h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f61987c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f61986b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f61990f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f61986b.setNextPage(this.f61990f);
        }
        this.f61990f.M();
        this.f61990f.O();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f61985a) == null || this.f61988d == null) {
            return;
        }
        d.a.p0.f0.g gVar = new d.a.p0.f0.g(tbPageContext.getPageActivity());
        this.f61993i = gVar;
        gVar.attachView(this.f61988d, false);
        this.f61993i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.f61985a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f61985a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f61985a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.j.setVisibility(0);
            this.f61991g.c().setVisibility(4);
            this.f61992h.setVisibility(4);
            this.j.f(this.f61985a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f61990f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f61986b.setNextPage(this.f61990f);
        }
        this.f61990f.A(this.f61985a.getResources().getString(R.string.list_no_more));
        this.f61990f.f();
    }
}
