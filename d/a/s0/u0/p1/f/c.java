package d.a.s0.u0.p1.f;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.d0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f66776e;

    /* renamed from: f  reason: collision with root package name */
    public int f66777f;

    /* renamed from: g  reason: collision with root package name */
    public String f66778g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f66779h;

    /* renamed from: i  reason: collision with root package name */
    public NavigationBar f66780i;
    public View j;
    public ImageView k;
    public View l;
    public ImageView m;
    public d.a.s0.u0.p1.a.a n;
    public d.a.s0.u0.p1.d.b o;
    public d.a.s0.u0.p1.d.a p;
    public BdTypeRecyclerView q;
    public List<n> r;
    public View s;
    public h t;
    public int u;
    public int v;
    public d.a.s0.u0.p1.c.b w;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f66781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f66782f;

        public a(c cVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66782f = cVar;
            this.f66781e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.p.a.a(this.f66781e.t);
                l.M(this.f66782f.f66776e, this.f66782f.f66776e.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, str};
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
        this.f66777f = 3;
        this.r = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.f66776e = forumRulesShowActivity;
        this.f66778g = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.o = new d.a.s0.u0.p1.d.b(forumRulesShowActivity);
        this.p = new d.a.s0.u0.p1.d.a(forumRulesShowActivity);
        this.u = l.g(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        r(forumRulesShowActivity);
    }

    public void e(d.a.s0.u0.p1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.w = bVar;
            this.r.add(bVar);
        }
    }

    public void f(d.a.s0.u0.p1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.r.add(aVar);
        }
    }

    public void g(List<d.a.s0.u0.p1.c.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.r.addAll(list);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            y(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f66776e = null;
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66779h : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.q) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(8);
    }

    public void n() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.s) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void o() {
        d.a.s0.u0.p1.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.o) == null) {
            return;
        }
        bVar.d(this.q);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f66780i.onChangeSkinType(this.f66776e.getPageContext(), i2);
            if (this.f66777f == i2) {
                this.f66780i.getCenterText().setTextSize(R.dimen.L_X06);
                TextView centerText = this.f66780i.getCenterText();
                int i3 = R.color.CAM_X0611;
                SkinManager.setNavbarTitleColor(centerText, i3, i3);
                WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.o.c(i2);
                this.p.c(i2);
                this.n.b(i2);
                this.f66777f = i2;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || this.f66776e == null) {
            return;
        }
        if (view.getId() == R.id.root_pb_more) {
            int i2 = -1;
            d.a.s0.u0.p1.c.b bVar = this.w;
            if (bVar == null || bVar.h() == null) {
                str = "";
            } else {
                i2 = this.w.h().forum_id.intValue();
                str = this.w.h().forum_name;
            }
            d.a.s0.u0.p1.c.b bVar2 = this.w;
            String o = bVar2 != null ? bVar2.o() : "";
            String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i2;
            ShareItem shareItem = new ShareItem();
            shareItem.r = o;
            shareItem.s = String.format(this.f66776e.getResources().getString(R.string.forum_rules_share_text), str);
            shareItem.t = str2;
            shareItem.b0 = false;
            d.a.s0.u0.p1.c.b bVar3 = this.w;
            if (bVar3 != null && !StringUtils.isNull(bVar3.h().avatar)) {
                shareItem.v = Uri.parse(this.w.h().avatar);
                shareItem.g();
            }
            shareItem.P = o;
            shareItem.Q = str2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f66776e, shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            this.f66776e.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } else if (view.getId() == R.id.navigationBarGoBack) {
            this.f66776e.finish();
        } else if (this.t == null || view.getId() != this.t.c().getId()) {
        } else {
            this.f66776e.requestNet();
        }
    }

    public void p() {
        d.a.s0.u0.p1.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.d(this.q);
    }

    public final void q(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) {
            View addSystemImageButton = this.f66780i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.j = addSystemImageButton;
            this.k = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.f66780i.setCenterTextTitle(this.f66776e.getResources().getString(R.string.forum_rules_local));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
            this.l = addCustomView;
            this.m = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int i2 = this.u;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            layoutParams.rightMargin = this.v;
            this.l.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            v();
        }
    }

    public final void r(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, forumRulesShowActivity) == null) {
            this.f66779h = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
            this.f66780i = navigationBar;
            q(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
            this.q = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.n = new d.a.s0.u0.p1.a.a(forumRulesShowActivity, this.q);
            this.s = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p();
            o();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f66778g = str;
            d.a.s0.u0.p1.a.a aVar = this.n;
            if (aVar != null) {
                aVar.d(str);
            }
        }
    }

    public void t() {
        d.a.s0.u0.p1.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.c(this.r);
    }

    public void u(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hVar) == null) {
            this.t = hVar;
            hVar.c().setOnClickListener(this);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f66778g)) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (bdTypeRecyclerView = this.q) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void x() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view = this.s) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || this.o == null || StringUtils.isNull(str)) {
            return;
        }
        this.o.a(this.q);
        this.o.e(str);
    }

    public void z(String str) {
        d.a.s0.u0.p1.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.a(this.q);
        this.p.e(str);
    }
}
