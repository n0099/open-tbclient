package com.repackage;

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
import com.repackage.cr4;
import java.util.List;
/* loaded from: classes6.dex */
public class kr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressupCenterActivity a;
    public View b;
    public BdListView c;
    public NavigationBar d;
    public NoNetworkView e;
    public CoverFlowView<ir8> f;
    public MemberRecommendView g;
    public TextView h;
    public jr8 i;
    public int j;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kr8 a;

        public a(kr8 kr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kr8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            lr8 item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.i.getItem(i)) == null) {
                return;
            }
            vt4 k = vt4.k();
            k.x("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), item.c());
            this.a.i.notifyDataSetChanged();
            if (StringUtils.isNull(item.getType())) {
                return;
            }
            String type = item.getType();
            int e = mg.e(type, 0);
            CustomMessage customMessage = null;
            if (e == 1) {
                TiebaStatic.log("c10263");
                this.a.k();
            } else if (e == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.a.a.getActivity()));
            } else if (e == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.a.getActivity()));
            } else if (e == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.a.a.getPageContext().getPageActivity()));
            } else if (e != 5) {
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{type});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.a.a.getActivity()));
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(kr8 kr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements zr4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(kr8 kr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.zr4
        public cs4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                cs4 cs4Var = new cs4();
                cs4Var.c(R.drawable.obfuscated_res_0x7f0806e8);
                cs4Var.g(R.drawable.obfuscated_res_0x7f0806e9);
                cs4Var.h(R.dimen.obfuscated_res_0x7f070198);
                cs4Var.d(85);
                cs4Var.f(R.dimen.obfuscated_res_0x7f070201);
                cs4Var.e(R.dimen.obfuscated_res_0x7f0701d5);
                return cs4Var;
            }
            return (cs4) invokeV.objValue;
        }

        @Override // com.repackage.zr4
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.zr4
        public es4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                es4 es4Var = new es4();
                es4Var.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070295));
                return es4Var;
            }
            return (es4) invokeV.objValue;
        }

        @Override // com.repackage.zr4
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

    /* loaded from: classes6.dex */
    public class d implements ds4<ir8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kr8 a;

        public d(kr8 kr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kr8Var;
        }

        @Override // com.repackage.ds4
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ds4
        /* renamed from: c */
        public void a(int i, ir8 ir8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ir8Var) == null) {
            }
        }
    }

    public kr8(DressupCenterActivity dressupCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dressupCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.a = dressupCenterActivity;
        this.j = oi.f(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07023f);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0246, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0923ac);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f050b));
        this.e = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0923ae);
        this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f090845);
        this.f = (CoverFlowView) this.b.findViewById(R.id.obfuscated_res_0x7f090846);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f090847);
        this.g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.i = new jr8(this.a.getPageContext());
        TextView textView = new TextView(this.a.getActivity());
        this.h = textView;
        textView.setHeight(oi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070201));
        this.c.setAdapter((ListAdapter) this.i);
        this.c.setOnItemClickListener(new a(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
            this.g.setVisibility(0);
            this.f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        jr8 jr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.c(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<ir8> coverFlowView = this.f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f.s();
            }
            BdListView bdListView = this.c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (jr8Var = this.i) != null) {
                jr8Var.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.g.d();
            }
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        }
    }

    public final boolean g(List<ir8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f.setVisibility(0);
                this.f.setData(list);
                return true;
            }
            this.f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(List<lr8> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.c.removeHeaderView(this.h);
                    this.c.addHeaderView(this.h);
                } else {
                    this.c.removeHeaderView(this.h);
                }
                this.c.setVisibility(0);
                this.i.b(list);
                this.i.notifyDataSetChanged();
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public final boolean i(mr8 mr8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mr8Var)) == null) {
            if (mr8Var != null && !StringUtils.isNull(mr8Var.c())) {
                this.g.setVisibility(0);
                this.g.e(mr8Var);
                return true;
            }
            this.g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        CoverFlowView<ir8> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (coverFlowView = this.f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new c(this));
        this.f.setCallback(new d(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cr4 cr4Var = new cr4(this.a.getPageContext().getPageActivity());
            cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0777);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new b(this));
            cr4Var.create(this.a.getPageContext()).show();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2f);
            this.a.setNetRefreshViewTopMargin(this.j);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void m(List<ir8> list, mr8 mr8Var, List<lr8> list2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, mr8Var, list2, Boolean.valueOf(z)}) == null) {
            if ((list != null && list.size() > 0) || ((mr8Var != null && !StringUtils.isNull(mr8Var.c())) || (list2 != null && list2.size() > 0))) {
                d();
                h(list2, g(list) || i(mr8Var));
                return;
            }
            l();
        }
    }
}
