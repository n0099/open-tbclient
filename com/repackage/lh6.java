package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsVideoActivityViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class lh6 extends pc6<ti8, FrsVideoActivityViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti8 a;
        public final /* synthetic */ lh6 b;

        public a(lh6 lh6Var, ti8 ti8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh6Var, ti8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh6Var;
            this.a = ti8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12587").param("fid", this.b.t));
                iu4 k = iu4.k();
                k.x("frs_video_activity_tip" + this.b.t, System.currentTimeMillis());
                ti8 ti8Var = this.a;
                if (ti8Var == null || StringUtils.isNull(ti8Var.b)) {
                    return;
                }
                fm4.l(this.b.a, this.a.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean n0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j == 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 86400000) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j);
            return calendar.get(7) > calendar2.get(7);
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: o0 */
    public FrsVideoActivityViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0356, (ViewGroup) null);
            FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.a, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.c, (int) R.color.CAM_X0301);
            SkinManager.setImageResource(frsVideoActivityViewHolder.b, R.drawable.icon_news_list_prompt);
            SkinManager.setImageResource(frsVideoActivityViewHolder.d, R.drawable.icon_index_category_arrow_r);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
            return frsVideoActivityViewHolder;
        }
        return (FrsVideoActivityViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: p0 */
    public View S(int i, View view2, ViewGroup viewGroup, ti8 ti8Var, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ti8Var, frsVideoActivityViewHolder})) == null) {
            if (view2 == null || frsVideoActivityViewHolder == null) {
                return null;
            }
            view2.setOnClickListener(new a(this, ti8Var));
            frsVideoActivityViewHolder.a.setText(ti8Var != null ? ti8Var.a : "");
            iu4 k = iu4.k();
            if (n0(k.m("frs_video_activity_tip" + this.t, 0L))) {
                frsVideoActivityViewHolder.b.setVisibility(0);
            } else {
                frsVideoActivityViewHolder.b.setVisibility(8);
            }
            return frsVideoActivityViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.t = str;
        }
    }
}
