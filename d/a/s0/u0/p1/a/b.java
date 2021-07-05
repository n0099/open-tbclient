package d.a.s0.u0.p1.a;

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
/* loaded from: classes9.dex */
public class b extends d.a.c.k.e.a<d.a.s0.u0.p1.c.a, ForumRuleDetailBottomVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public String n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.s0.u0.p1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        i0(i2, view, viewGroup, aVar, forumRuleDetailBottomVH);
        return view;
    }

    public final void f0(ForumRuleDetailBottomVH forumRuleDetailBottomVH, d.a.s0.u0.p1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailBottomVH, aVar) == null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.f15584b.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f15584b.M(aVar.b(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(R.string.forum_rules_bar_management_group);
        EMTextView eMTextView = forumRuleDetailBottomVH.f15586d;
        eMTextView.setText(aVar.c() + string);
        forumRuleDetailBottomVH.f15588f.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f15588f.M(aVar.e(), 12, false);
        forumRuleDetailBottomVH.f15589g.setText(aVar.d());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
            forumRuleDetailBottomVH.b(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.f15590h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.h()));
            forumRuleDetailBottomVH.f15587e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.h()));
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g0(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumRuleDetailBottomVH) == null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ForumRuleDetailBottomVH Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_bottom, viewGroup, false));
            g0(forumRuleDetailBottomVH);
            this.k = forumRuleDetailBottomVH;
            return forumRuleDetailBottomVH;
        }
        return (ForumRuleDetailBottomVH) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.s0.u0.p1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, forumRuleDetailBottomVH})) == null) {
            if (aVar != null) {
                f0(forumRuleDetailBottomVH, aVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.n = str;
        }
    }
}
