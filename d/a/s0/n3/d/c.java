package d.a.s0.n3.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.s0.n3.h.e;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d.a.c.a.d<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f64111a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f64112b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f64113c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f64114d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f64115e;

    /* renamed from: f  reason: collision with root package name */
    public int f64116f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64117g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64118h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f64119i;
    public View j;
    public TextView k;

    /* loaded from: classes9.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64116f = 0;
        this.f64119i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f64116f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f64112b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f64113c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f64115e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64115e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f64114d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f64114d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f64117g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f64118h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f64112b.x(this.k, 0);
        this.f64112b.addFooterView(this.f64118h);
        d dVar = new d(avatarPendantActivity);
        this.f64111a = dVar;
        this.f64112b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f64113c.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64119i.hideNetRefreshView(this.j);
            this.f64112b.setVisibility(0);
        }
    }

    public MemberRecommendView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64114d : (MemberRecommendView) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64112b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f64111a.notifyDataSetChanged();
            this.f64115e.onChangeSkinType(this.f64119i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f64113c.c(this.f64119i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f64114d.d();
            SkinManager.setBackgroundColor(this.f64117g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f64118h, R.color.CAM_X0201);
        }
    }

    public void l(List<d.a.s0.n3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f64112b.setVisibility(0);
                this.f64111a.c(list);
                this.f64111a.notifyDataSetChanged();
                return;
            }
            this.f64112b.setVisibility(8);
        }
    }

    public final boolean m(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f64114d.setVisibility(0);
                this.f64114d.e(eVar);
                return true;
            }
            this.f64114d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f64111a.b(aVar);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f64112b.setVisibility(8);
            String string = this.f64119i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f64119i.setNetRefreshViewTopMargin(this.f64116f);
            this.f64119i.showNetRefreshView(this.j, string, false);
        }
    }

    public void p(e eVar, List<d.a.s0.n3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                e();
                if (m(eVar)) {
                    this.f64112b.removeHeaderView(this.f64117g);
                    this.f64112b.addHeaderView(this.f64117g);
                } else {
                    this.f64112b.removeHeaderView(this.f64117g);
                }
                l(list);
                return;
            }
            o();
        }
    }
}
