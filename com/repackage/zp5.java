package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zp5 extends uw5<so5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TabLiveStageLiveView j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zp5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        s();
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07e7 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
            TabLiveStageLiveView tabLiveStageLiveView = this.j;
            if (tabLiveStageLiveView != null) {
                tabLiveStageLiveView.c();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = k();
            int[] b = io5.b(getContext());
            int i = b[0];
            int i2 = b[1];
            TabLiveStageLiveView tabLiveStageLiveView = (TabLiveStageLiveView) this.i.findViewById(R.id.obfuscated_res_0x7f091dd7);
            this.j = tabLiveStageLiveView;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tabLiveStageLiveView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
            } else {
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            layoutParams.gravity = 1;
            this.j.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: t */
    public void l(so5 so5Var) {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, so5Var) == null) || so5Var == null || so5Var.a == null) {
            return;
        }
        int k = mi.k(this.c);
        if (k != this.k) {
            int[] b = io5.b(getContext());
            int i = b[0];
            int i2 = b[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.j.setLayoutParams(layoutParams);
            this.k = k;
        }
        this.j.setData(so5Var.a.a, 101);
        StatisticItem statisticItem = new StatisticItem("c13551");
        to5 to5Var = so5Var.a;
        if (to5Var != null && (sdkLiveInfoData = to5Var.a) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
            int a = io5.a(alaLiveInfo);
            SdkLiveInfoData sdkLiveInfoData2 = so5Var.a.a;
            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData2.liveInfo.yyExt;
            if (yYExt != null) {
                TiebaStaticHelper.addYYParam(statisticItem, io5.k(yYExt, sdkLiveInfoData2.roomId));
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param("obj_param1", a);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
        statisticItem.param("nid", so5Var.a.a.nid);
        statisticItem.param(TiebaStatic.Params.LOGID, so5Var.a.a.logid);
        TiebaStatic.log(statisticItem);
    }
}
