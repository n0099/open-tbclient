package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes7.dex */
public class tg6 implements BottomMenuView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public ImageView c;
    public BottomMenuView d;
    public ForumData e;
    public int f;
    public int g;
    public int h;

    public tg6(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
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
        this.b = view2;
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915b4);
        BottomMenuView bottomMenuView = (BottomMenuView) view2.findViewById(R.id.obfuscated_res_0x7f0903d8);
        this.d = bottomMenuView;
        bottomMenuView.setOnMenuItemClickListener(this);
        this.f = oi.f(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.g = oi.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.h = oi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, subMenuItemView, subBottomMenu) == null) || subBottomMenu == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{subBottomMenu.url});
        ForumData forumData = this.e;
        String id = forumData != null ? forumData.getId() : "";
        ForumData forumData2 = this.e;
        TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", subBottomMenu.name));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void b(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItemView, bottomMenu) == null) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (bottomMenu != null && ListUtils.getCount(bottomMenu.submenu) == 0) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{bottomMenu.url});
                ForumData forumData = this.e;
                String id = forumData != null ? forumData.getId() : "";
                ForumData forumData2 = this.e;
                TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", currentAccountId).param("obj_param1", bottomMenu.name));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13118").param("uid", currentAccountId));
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            if (z) {
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.addRule(14, 0);
                layoutParams.bottomMargin = this.f;
                layoutParams.rightMargin = this.g;
                return;
            }
            layoutParams.addRule(11, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = this.h;
            layoutParams.rightMargin = 0;
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.d.getVisibility() == 0) {
            this.d.a(tbPageContext, i);
        }
    }

    public void e(List<BottomMenu> list, ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, forumData) == null) {
            this.e = forumData;
            boolean z = ListUtils.getCount(list) > 0;
            c(z);
            if (z) {
                this.d.setVisibility(0);
                this.d.b(list, this.a);
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }
}
