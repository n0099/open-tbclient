package d.a.p0.n3.d;

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
import d.a.p0.n3.h.e;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d.a.c.a.d<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f60877a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f60878b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f60879c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f60880d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f60881e;

    /* renamed from: f  reason: collision with root package name */
    public int f60882f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60883g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60884h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f60885i;
    public View j;
    public TextView k;

    /* loaded from: classes8.dex */
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
        this.f60882f = 0;
        this.f60885i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f60882f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f60878b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f60879c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f60881e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60881e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f60880d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f60880d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f60883g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f60884h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f60878b.x(this.k, 0);
        this.f60878b.addFooterView(this.f60884h);
        d dVar = new d(avatarPendantActivity);
        this.f60877a = dVar;
        this.f60878b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f60879c.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f60885i.hideNetRefreshView(this.j);
            this.f60878b.setVisibility(0);
        }
    }

    public MemberRecommendView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60880d : (MemberRecommendView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f60878b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f60877a.notifyDataSetChanged();
            this.f60881e.onChangeSkinType(this.f60885i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f60879c.c(this.f60885i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f60880d.d();
            SkinManager.setBackgroundColor(this.f60883g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f60884h, R.color.CAM_X0201);
        }
    }

    public void k(List<d.a.p0.n3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f60878b.setVisibility(0);
                this.f60877a.c(list);
                this.f60877a.notifyDataSetChanged();
                return;
            }
            this.f60878b.setVisibility(8);
        }
    }

    public final boolean l(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f60880d.setVisibility(0);
                this.f60880d.e(eVar);
                return true;
            }
            this.f60880d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f60877a.b(aVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f60878b.setVisibility(8);
            String string = this.f60885i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f60885i.setNetRefreshViewTopMargin(this.f60882f);
            this.f60885i.showNetRefreshView(this.j, string, false);
        }
    }

    public void o(e eVar, List<d.a.p0.n3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                e();
                if (l(eVar)) {
                    this.f60878b.removeHeaderView(this.f60883g);
                    this.f60878b.addHeaderView(this.f60883g);
                } else {
                    this.f60878b.removeHeaderView(this.f60883g);
                }
                k(list);
                return;
            }
            n();
        }
    }
}
