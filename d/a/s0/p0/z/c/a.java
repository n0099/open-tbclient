package d.a.s0.p0.z.c;

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
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.s0.p0.y.c.c;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64605a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64606b;

    /* renamed from: c  reason: collision with root package name */
    public g f64607c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f64608d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f64609e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f64610f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.p0.y.a f64611g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f64612h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.d0.g f64613i;
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
        this.f64605a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f64608d = relativeLayout;
        this.f64609e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f64608d.findViewById(R.id.forum_emotion_list);
        this.f64606b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f64606b.setDivider(null);
        g gVar = new g(this.f64605a);
        this.f64607c = gVar;
        gVar.a0(bdUniqueId);
        this.f64606b.setPullRefresh(this.f64607c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f64610f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64606b.z();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64606b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64609e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64608d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64612h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f64610f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f64606b.setNextPage(null);
        }
    }

    public void g() {
        d.a.r0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f64613i) == null) {
            return;
        }
        gVar.dettachView(this.f64608d);
        this.f64613i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f64611g.c().setVisibility(0);
            this.f64612h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.s0.p0.y.a aVar = new d.a.s0.p0.y.a(this.f64605a);
            this.f64611g = aVar;
            aVar.c().setVisibility(8);
            this.f64606b.addHeaderView(this.f64611g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f64605a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f64606b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f64605a.getPageActivity());
            this.f64612h = forumEmotionVoteEntryView;
            this.f64606b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f64610f.o(R.color.CAM_X0204);
            this.f64610f.d(i2);
            this.f64607c.I(i2);
            this.f64606b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f64608d, R.color.CAM_X0201);
            this.f64609e.c(this.f64605a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f64612h;
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
            this.f64611g.c().setVisibility(0);
            this.f64611g.f(this.f64605a.getUniqueId());
            this.f64611g.e(new c(forumEmotionData.banner));
            this.f64611g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f64612h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f64607c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f64606b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f64610f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64606b.setNextPage(this.f64610f);
        }
        this.f64610f.M();
        this.f64610f.O();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f64605a) == null || this.f64608d == null) {
            return;
        }
        d.a.r0.d0.g gVar = new d.a.r0.d0.g(tbPageContext.getPageActivity());
        this.f64613i = gVar;
        gVar.attachView(this.f64608d, false);
        this.f64613i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.f64605a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f64605a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f64605a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.j.setVisibility(0);
            this.f64611g.c().setVisibility(4);
            this.f64612h.setVisibility(4);
            this.j.f(this.f64605a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f64610f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64606b.setNextPage(this.f64610f);
        }
        this.f64610f.A(this.f64605a.getResources().getString(R.string.list_no_more));
        this.f64610f.f();
    }
}
