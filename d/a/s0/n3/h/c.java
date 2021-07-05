package d.a.s0.n3.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DressupCenterActivity f64270a;

    /* renamed from: b  reason: collision with root package name */
    public View f64271b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f64272c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f64273d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f64274e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<d.a.s0.n3.h.a> f64275f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f64276g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64277h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.n3.h.b f64278i;
    public int j;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64279e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64279e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.s0.n3.h.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f64279e.f64278i.getItem(i2)) == null) {
                return;
            }
            d.a.r0.r.d0.b j2 = d.a.r0.r.d0.b.j();
            j2.w("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), item.d());
            this.f64279e.f64278i.notifyDataSetChanged();
            if (StringUtils.isNull(item.c())) {
                return;
            }
            String c2 = item.c();
            int d2 = d.a.c.e.m.b.d(c2, 0);
            CustomMessage customMessage = null;
            if (d2 == 1) {
                TiebaStatic.log("c10263");
                this.f64279e.k();
            } else if (d2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f64279e.f64270a.getActivity()));
            } else if (d2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.f64279e.f64270a.getActivity()));
            } else if (d2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.f64279e.f64270a.getPageContext().getPageActivity()));
            } else if (d2 != 5) {
                UrlManager.getInstance().dealOneLink(this.f64279e.f64270a.getPageContext(), new String[]{c2});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f64279e.f64270a.getActivity()));
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* renamed from: d.a.s0.n3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1622c implements d.a.r0.r.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1622c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.w.a
        public d.a.r0.r.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.r0.r.w.b.c cVar = new d.a.r0.r.w.b.c();
                cVar.c(R.drawable.icon_diandian_white_n);
                cVar.g(R.drawable.icon_diandian_white_s);
                cVar.h(R.dimen.ds1);
                cVar.d(85);
                cVar.f(R.dimen.ds30);
                cVar.e(R.dimen.ds20);
                return cVar;
            }
            return (d.a.r0.r.w.b.c) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.a
        public d.a.r0.r.w.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                d.a.r0.r.w.b.e eVar = new d.a.r0.r.w.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                return eVar;
            }
            return (d.a.r0.r.w.b.e) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.a
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d.a.r0.r.w.b.d<d.a.s0.n3.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64280a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64280a = cVar;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.f64280a.f64270a.getPageContext(), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, d.a.s0.n3.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) {
            }
        }
    }

    public c(DressupCenterActivity dressupCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dressupCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.f64270a = dressupCenterActivity;
        this.j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f64270a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f64271b = inflate;
        this.f64270a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f64271b.findViewById(R.id.view_navigation_bar);
        this.f64273d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64273d.setCenterTextTitle(this.f64270a.getPageContext().getString(R.string.dressup_center_title));
        this.f64274e = (NoNetworkView) this.f64271b.findViewById(R.id.view_no_network);
        this.f64272c = (BdListView) this.f64271b.findViewById(R.id.dress_listview);
        this.f64275f = (CoverFlowView) this.f64271b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f64271b.findViewById(R.id.dressup_center_recommend);
        this.f64276g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.f64278i = new d.a.s0.n3.h.b(this.f64270a.getPageContext());
        TextView textView = new TextView(this.f64270a.getActivity());
        this.f64277h = textView;
        textView.setHeight(l.g(this.f64270a.getActivity(), R.dimen.ds30));
        this.f64272c.setAdapter((ListAdapter) this.f64278i);
        this.f64272c.setOnItemClickListener(new a(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64270a.hideNetRefreshView(this.f64271b);
            this.f64272c.setVisibility(0);
            this.f64276g.setVisibility(0);
            this.f64275f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64271b : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        d.a.s0.n3.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f64270a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f64270a.getLayoutMode().j(this.f64271b);
            NavigationBar navigationBar = this.f64273d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64270a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f64274e;
            if (noNetworkView != null) {
                noNetworkView.c(this.f64270a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<d.a.s0.n3.h.a> coverFlowView = this.f64275f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f64275f.s();
            }
            BdListView bdListView = this.f64272c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f64278i) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f64276g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f64276g.d();
            }
            SkinManager.setBackgroundColor(this.f64277h, R.color.CAM_X0204);
        }
    }

    public final boolean g(List<d.a.s0.n3.h.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f64275f.setVisibility(0);
                this.f64275f.setData(list);
                return true;
            }
            this.f64275f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(List<d.a.s0.n3.h.d> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.f64272c.removeHeaderView(this.f64277h);
                    this.f64272c.addHeaderView(this.f64277h);
                } else {
                    this.f64272c.removeHeaderView(this.f64277h);
                }
                this.f64272c.setVisibility(0);
                this.f64278i.b(list);
                this.f64278i.notifyDataSetChanged();
                return;
            }
            this.f64272c.setVisibility(8);
        }
    }

    public final boolean i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f64276g.setVisibility(0);
                this.f64276g.e(eVar);
                return true;
            }
            this.f64276g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        CoverFlowView<d.a.s0.n3.h.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (coverFlowView = this.f64275f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1622c(this));
        this.f64275f.setCallback(new d(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f64270a.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.function_unavailable_tip);
            aVar.setPositiveButton(R.string.confirm, new b(this));
            aVar.create(this.f64270a.getPageContext()).show();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f64272c.setVisibility(8);
            this.f64275f.setVisibility(8);
            this.f64276g.setVisibility(8);
            String string = this.f64270a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f64270a.setNetRefreshViewTopMargin(this.j);
            this.f64270a.showNetRefreshView(this.f64271b, string, false);
        }
    }

    public void m(List<d.a.s0.n3.h.a> list, e eVar, List<d.a.s0.n3.h.d> list2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, eVar, list2, Boolean.valueOf(z)}) == null) {
            if ((list != null && list.size() > 0) || ((eVar != null && !StringUtils.isNull(eVar.c())) || (list2 != null && list2.size() > 0))) {
                d();
                h(list2, g(list) || i(eVar));
                return;
            }
            l();
        }
    }
}
