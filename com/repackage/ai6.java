package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailBottomVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ai6 extends eo<fi6, ForumRuleDetailBottomVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai6(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, fi6 fi6Var, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        c0(i, view2, viewGroup, fi6Var, forumRuleDetailBottomVH);
        return view2;
    }

    public final void Z(ForumRuleDetailBottomVH forumRuleDetailBottomVH, fi6 fi6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailBottomVH, fi6Var) == null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080b95);
        forumRuleDetailBottomVH.b.K(fi6Var.a(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f06a0);
        EMTextView eMTextView = forumRuleDetailBottomVH.d;
        eMTextView.setText(fi6Var.b() + string);
        forumRuleDetailBottomVH.f.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080b95);
        forumRuleDetailBottomVH.f.K(fi6Var.f(), 12, false);
        forumRuleDetailBottomVH.g.setText(fi6Var.e());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j)) {
            forumRuleDetailBottomVH.c(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.h.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06a7), fi6Var.g()));
            forumRuleDetailBottomVH.e.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06a7), fi6Var.g()));
        }
        forumRuleDetailBottomVH.d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a0(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumRuleDetailBottomVH) == null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.d(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public ForumRuleDetailBottomVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d02be, viewGroup, false));
            a0(forumRuleDetailBottomVH);
            this.g = forumRuleDetailBottomVH;
            return forumRuleDetailBottomVH;
        }
        return (ForumRuleDetailBottomVH) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, fi6 fi6Var, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fi6Var, forumRuleDetailBottomVH})) == null) {
            if (fi6Var != null) {
                Z(forumRuleDetailBottomVH, fi6Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
        }
    }
}
