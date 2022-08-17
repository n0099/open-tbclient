package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailSelfVH;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class jk6 extends bn<nk6, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public String b;
    public boolean c;
    public int d;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk6 a;
        public final /* synthetic */ jk6 b;

        public a(jk6 jk6Var, nk6 nk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jk6Var, nk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jk6Var;
            this.a = nk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.c) {
                    this.b.z();
                } else {
                    this.b.A(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jk6(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdUniqueId};
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
        this.c = false;
        this.d = 0;
        this.a = forumRulesShowActivity;
    }

    public final void A(nk6 nk6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, nk6Var) == null) || this.a == null || nk6Var == null) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
        forumRuleBaseData.setTitle(nk6Var.n());
        forumRuleBaseData.setPreface(nk6Var.j());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nk6Var.l().size(); i++) {
            ForumRule forumRule = nk6Var.l().get(i);
            ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
            forumRuleItemPbData.status = forumRule.status + "";
            forumRuleItemPbData.title = forumRule.title + "";
            forumRuleItemPbData.mContent = new ArrayList();
            List<PbContent> list = forumRule.content;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < forumRule.content.size(); i2++) {
                    PbContent pbContent = forumRule.content.get(i2);
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                    forumRuleItemPbContentData.href = pbContent.link;
                    if (pbContent.type.intValue() == 0) {
                        forumRuleItemPbContentData.tag = "plainText";
                    } else if (pbContent.type.intValue() == 1) {
                        forumRuleItemPbContentData.tag = "a";
                    } else if (pbContent.type.intValue() == 2) {
                        forumRuleItemPbContentData.tag = TtmlNode.TAG_BR;
                    }
                    forumRuleItemPbContentData.value = pbContent.text;
                    forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                }
            }
            arrayList.add(forumRuleItemPbData);
        }
        forumRuleBaseData.setPbDataList(arrayList);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a, nk6Var.g().forum_id + "", nk6Var.g().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, nk6Var.g().avatar, nk6Var.c().user_level.intValue(), 25053)));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nk6 nk6Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        y(i, view2, viewGroup, nk6Var, forumRuleDetailSelfVH);
        return view2;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = str;
        }
    }

    public final void v(ForumRuleDetailSelfVH forumRuleDetailSelfVH, nk6 nk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, forumRuleDetailSelfVH, nk6Var) == null) {
            if (nk6Var.c() != null) {
                forumRuleDetailSelfVH.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080bc2);
                forumRuleDetailSelfVH.b.K(nk6Var.c().portrait, 12, false);
                forumRuleDetailSelfVH.c.setText(nk6Var.c().name_show);
                forumRuleDetailSelfVH.b(nk6Var.c().user_level.intValue());
                forumRuleDetailSelfVH.e.setVisibility(0);
            }
            forumRuleDetailSelfVH.d.setText(R.string.obfuscated_res_0x7f0f02fa);
            forumRuleDetailSelfVH.d.setVisibility(0);
            forumRuleDetailSelfVH.g("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
                forumRuleDetailSelfVH.f(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.g.setText(nk6Var.k());
            }
            w(forumRuleDetailSelfVH, nk6Var);
            forumRuleDetailSelfVH.c(nk6Var.j());
        }
    }

    public final void w(ForumRuleDetailSelfVH forumRuleDetailSelfVH, nk6 nk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, forumRuleDetailSelfVH, nk6Var) == null) && nk6Var.h()) {
            forumRuleDetailSelfVH.h.setOnClickListener(new a(this, nk6Var));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
                forumRuleDetailSelfVH.h.setVisibility(8);
            } else if (!StringUtils.isNull(nk6Var.k()) && nk6Var.b() == 0) {
                long a2 = sk6.a(nk6Var.k());
                int b = sk6.b(Long.valueOf(StringUtils.isNull(nk6Var.f()) ? "0" : nk6Var.f()).longValue() - a2);
                if (b < 0) {
                    b = sk6.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.h.setVisibility(0);
                if (b >= 7) {
                    this.c = false;
                    return;
                }
                forumRuleDetailSelfVH.h.setUseDisableState(true);
                this.c = true;
                this.d = 7 - b;
            } else {
                forumRuleDetailSelfVH.e(nk6Var.b());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: x */
    public ForumRuleDetailSelfVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02be, viewGroup, false));
            this.viewholder = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View y(int i, View view2, ViewGroup viewGroup, nk6 nk6Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nk6Var, forumRuleDetailSelfVH})) == null) {
            if (nk6Var == null) {
                return view2;
            }
            v(forumRuleDetailSelfVH, nk6Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (forumRulesShowActivity = this.a) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.obfuscated_res_0x7f0f06b3);
        String format = String.format(string, this.d + "");
        if (this.a.A1() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.a);
            bdTopToast.h(false);
            bdTopToast.g(format);
            bdTopToast.i(this.a.A1().q());
        }
    }
}
