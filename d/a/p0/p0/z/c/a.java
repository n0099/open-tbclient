package d.a.p0.p0.z.c;

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
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import d.a.p0.p0.y.c.c;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61371a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61372b;

    /* renamed from: c  reason: collision with root package name */
    public g f61373c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61374d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61375e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f61376f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.p0.y.a f61377g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f61378h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.d0.g f61379i;
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
        this.f61371a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f61374d = relativeLayout;
        this.f61375e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f61374d.findViewById(R.id.forum_emotion_list);
        this.f61372b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f61372b.setDivider(null);
        g gVar = new g(this.f61371a);
        this.f61373c = gVar;
        gVar.a0(bdUniqueId);
        this.f61372b.setPullRefresh(this.f61373c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61376f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61372b.z();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61372b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61375e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61374d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61378h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f61376f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f61372b.setNextPage(null);
        }
    }

    public void g() {
        d.a.o0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f61379i) == null) {
            return;
        }
        gVar.dettachView(this.f61374d);
        this.f61379i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f61377g.c().setVisibility(0);
            this.f61378h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.p0.p0.y.a aVar = new d.a.p0.p0.y.a(this.f61371a);
            this.f61377g = aVar;
            aVar.c().setVisibility(8);
            this.f61372b.addHeaderView(this.f61377g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f61371a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f61372b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f61371a.getPageActivity());
            this.f61378h = forumEmotionVoteEntryView;
            this.f61372b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f61376f.o(R.color.CAM_X0204);
            this.f61376f.d(i2);
            this.f61373c.I(i2);
            this.f61372b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f61374d, R.color.CAM_X0201);
            this.f61375e.c(this.f61371a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f61378h;
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
            this.f61377g.c().setVisibility(0);
            this.f61377g.f(this.f61371a.getUniqueId());
            this.f61377g.e(new c(forumEmotionData.banner));
            this.f61377g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f61378h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f61373c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f61372b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f61376f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f61372b.setNextPage(this.f61376f);
        }
        this.f61376f.M();
        this.f61376f.O();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f61371a) == null || this.f61374d == null) {
            return;
        }
        d.a.o0.d0.g gVar = new d.a.o0.d0.g(tbPageContext.getPageActivity());
        this.f61379i = gVar;
        gVar.attachView(this.f61374d, false);
        this.f61379i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.f61371a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f61371a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f61371a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.j.setVisibility(0);
            this.f61377g.c().setVisibility(4);
            this.f61378h.setVisibility(4);
            this.j.f(this.f61371a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f61376f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f61372b.setNextPage(this.f61376f);
        }
        this.f61376f.A(this.f61371a.getResources().getString(R.string.list_no_more));
        this.f61376f.f();
    }
}
