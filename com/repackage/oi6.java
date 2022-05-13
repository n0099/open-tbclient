package com.repackage;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class oi6 extends z8<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public int b;
    public String c;
    public ViewGroup d;
    public NavigationBar e;
    public View f;
    public ImageView g;
    public View h;
    public ImageView i;
    public zh6 j;
    public ki6 k;
    public ji6 l;
    public BdTypeRecyclerView m;
    public List<ro> n;
    public View o;
    public y45 p;
    public int q;
    public int r;
    public gi6 s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ oi6 b;

        public a(oi6 oi6Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi6Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oi6Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bi.a(this.a.v);
                mi.N(this.b.a, this.b.a.getResources().getString(R.string.obfuscated_res_0x7f0f0447));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oi6(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.n = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.a = forumRulesShowActivity;
        this.c = str;
        forumRulesShowActivity.setContentView(R.layout.obfuscated_res_0x7f0d0038);
        this.k = new ki6(forumRulesShowActivity);
        this.l = new ji6(forumRulesShowActivity);
        this.q = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070309);
        this.r = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        t(forumRulesShowActivity);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.k == null || StringUtils.isNull(str)) {
            return;
        }
        this.k.a(this.m);
        this.k.e(str);
    }

    public void B(String str) {
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (ji6Var = this.l) == null) {
            return;
        }
        ji6Var.a(this.m);
        this.l.e(str);
    }

    public void g(gi6 gi6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gi6Var) == null) {
            this.s = gi6Var;
            this.n.add(gi6Var);
        }
    }

    public void h(fi6 fi6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fi6Var) == null) {
            this.n.add(fi6Var);
        }
    }

    public void i(List<hi6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.n.addAll(list);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            A(str);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = null;
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (ViewGroup) invokeV.objValue;
    }

    public void n() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.m) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(8);
    }

    public void o() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (view2 = this.o) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e.onChangeSkinType(this.a.getPageContext(), i);
            if (this.b == i) {
                this.e.getCenterText().setTextSize((float) R.dimen.L_X06);
                SkinManager.setNavbarTitleColor(this.e.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
                WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f0809df, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.i, R.drawable.obfuscated_res_0x7f0809db, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.k.c(i);
                this.l.c(i);
                this.j.b(i);
                this.b = i;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, view2) == null) || this.a == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091b28) {
            int i = -1;
            gi6 gi6Var = this.s;
            if (gi6Var == null || gi6Var.g() == null) {
                str = "";
            } else {
                i = this.s.g().forum_id.intValue();
                str = this.s.g().forum_name;
            }
            gi6 gi6Var2 = this.s;
            String n = gi6Var2 != null ? gi6Var2.n() : "";
            String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
            ShareItem shareItem = new ShareItem();
            shareItem.t = n;
            shareItem.u = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06a8), str);
            shareItem.v = str2;
            shareItem.l0 = false;
            gi6 gi6Var3 = this.s;
            if (gi6Var3 != null && !StringUtils.isNull(gi6Var3.g().avatar)) {
                shareItem.x = Uri.parse(this.s.g().avatar);
                shareItem.g();
            }
            shareItem.R = n;
            shareItem.S = str2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09152c) {
            this.a.finish();
        } else if (this.p == null || view2.getId() != this.p.c().getId()) {
        } else {
            this.a.requestNet();
        }
    }

    public void q() {
        ki6 ki6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ki6Var = this.k) == null) {
            return;
        }
        ki6Var.d(this.m);
    }

    public void r() {
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (ji6Var = this.l) == null) {
            return;
        }
        ji6Var.d(this.m);
    }

    public final void s(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, navigationBar) == null) {
            View addSystemImageButton = this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f = addSystemImageButton;
            this.g = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09249c);
            this.e.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06a5));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05dc, this);
            this.h = addCustomView;
            this.i = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09152a);
            int i = this.q;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.rightMargin = this.r;
            this.h.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            x();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.c = str;
            zh6 zh6Var = this.j;
            if (zh6Var != null) {
                zh6Var.d(str);
            }
        }
    }

    public final void t(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumRulesShowActivity) == null) {
            this.d = (ViewGroup) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090a68);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f091547);
            this.e = navigationBar;
            s(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090a75);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.j = new zh6(forumRulesShowActivity, this.m);
            this.o = forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090a76);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            r();
            q();
        }
    }

    public void v() {
        zh6 zh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (zh6Var = this.j) == null) {
            return;
        }
        zh6Var.c(this.n);
    }

    public void w(y45 y45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, y45Var) == null) {
            this.p = y45Var;
            y45Var.c().setOnClickListener(this);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.c)) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        }
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (bdTypeRecyclerView = this.m) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void z() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (view2 = this.o) == null) {
            return;
        }
        view2.setVisibility(0);
    }
}
