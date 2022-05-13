package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailItemVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class bi6 extends eo<hi6, ForumRuleDetailItemVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public TbRichText j;
    public List<ro> k;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ bi6 b;

        public a(bi6 bi6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bi6Var;
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.b.k != null) {
                    ro roVar = (ro) this.b.k.get(this.a);
                    if (roVar instanceof hi6) {
                        bi.a(TbRichTextView.X(((hi6) roVar).b(), false).toString());
                        mi.M(this.b.i, R.string.obfuscated_res_0x7f0f06a2);
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi6(Context context, BdUniqueId bdUniqueId) {
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
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, hi6 hi6Var, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        c0(i, view2, viewGroup, hi6Var, forumRuleDetailItemVH);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public ForumRuleDetailItemVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.i, LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d02bf, viewGroup, false));
            this.g = forumRuleDetailItemVH;
            return forumRuleDetailItemVH;
        }
        return (ForumRuleDetailItemVH) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, hi6 hi6Var, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hi6Var, forumRuleDetailItemVH})) == null) {
            if (hi6Var != null && this.i != null) {
                forumRuleDetailItemVH.e(hi6Var.a());
                if (!StringUtils.isNull(hi6Var.e())) {
                    z = true;
                    forumRuleDetailItemVH.c.setVisibility(0);
                    forumRuleDetailItemVH.c.setText(hi6Var.e());
                } else {
                    forumRuleDetailItemVH.c.setVisibility(8);
                    z = false;
                }
                if (hi6Var.b() != null && !StringUtils.isNull(hi6Var.b().toString())) {
                    forumRuleDetailItemVH.d.setVisibility(0);
                    if (!z) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.d.getLayoutParams();
                        layoutParams.topMargin = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                        forumRuleDetailItemVH.d.setLayoutParams(layoutParams);
                    }
                    TbRichText X = TbRichTextView.X(hi6Var.b(), false);
                    this.j = X;
                    forumRuleDetailItemVH.d.setText(X);
                } else {
                    forumRuleDetailItemVH.d.setVisibility(8);
                }
                forumRuleDetailItemVH.d.setOnLongClickListener(new a(this, i));
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.k = list;
        }
    }
}
