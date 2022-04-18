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
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class bj6 extends ho<fj6, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity i;
    public String j;
    public boolean k;
    public int l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj6 a;
        public final /* synthetic */ bj6 b;

        public a(bj6 bj6Var, fj6 fj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj6Var, fj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bj6Var;
            this.a = fj6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.k) {
                    this.b.g0();
                } else {
                    this.b.h0(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj6(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
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
        this.k = false;
        this.l = 0;
        this.i = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, fj6 fj6Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        f0(i, view2, viewGroup, fj6Var, forumRuleDetailSelfVH);
        return view2;
    }

    public final void c0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, fj6 fj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailSelfVH, fj6Var) == null) {
            if (fj6Var.e() != null) {
                forumRuleDetailSelfVH.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080b7a);
                forumRuleDetailSelfVH.b.K(fj6Var.e().portrait, 12, false);
                forumRuleDetailSelfVH.c.setText(fj6Var.e().name_show);
                forumRuleDetailSelfVH.d(fj6Var.e().user_level.intValue());
                forumRuleDetailSelfVH.e.setVisibility(0);
            }
            forumRuleDetailSelfVH.d.setText(R.string.obfuscated_res_0x7f0f02eb);
            forumRuleDetailSelfVH.d.setVisibility(0);
            forumRuleDetailSelfVH.i("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j)) {
                forumRuleDetailSelfVH.h(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.g.setText(fj6Var.k());
            }
            d0(forumRuleDetailSelfVH, fj6Var);
            forumRuleDetailSelfVH.e(fj6Var.j());
        }
    }

    public final void d0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, fj6 fj6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, forumRuleDetailSelfVH, fj6Var) == null) && fj6Var.i()) {
            forumRuleDetailSelfVH.h.setOnClickListener(new a(this, fj6Var));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j)) {
                forumRuleDetailSelfVH.h.setVisibility(8);
            } else if (!StringUtils.isNull(fj6Var.k()) && fj6Var.b() == 0) {
                long a2 = kj6.a(fj6Var.k());
                int b = kj6.b(Long.valueOf(StringUtils.isNull(fj6Var.f()) ? "0" : fj6Var.f()).longValue() - a2);
                if (b < 0) {
                    b = kj6.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.h.setVisibility(0);
                if (b >= 7) {
                    this.k = false;
                    return;
                }
                forumRuleDetailSelfVH.h.setUseDisableState(true);
                this.k = true;
                this.l = 7 - b;
            } else {
                forumRuleDetailSelfVH.g(fj6Var.b());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: e0 */
    public ForumRuleDetailSelfVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d02ca, viewGroup, false));
            this.g = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View f0(int i, View view2, ViewGroup viewGroup, fj6 fj6Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fj6Var, forumRuleDetailSelfVH})) == null) {
            if (fj6Var == null) {
                return view2;
            }
            c0(forumRuleDetailSelfVH, fj6Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (forumRulesShowActivity = this.i) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.obfuscated_res_0x7f0f069c);
        String format = String.format(string, this.l + "");
        if (this.i.getView() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.i);
            bdTopToast.i(false);
            bdTopToast.h(format);
            bdTopToast.j(this.i.getView().l());
        }
    }

    public final void h0(fj6 fj6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fj6Var) == null) || this.i == null || fj6Var == null) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
        forumRuleBaseData.setTitle(fj6Var.n());
        forumRuleBaseData.setPreface(fj6Var.j());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fj6Var.m().size(); i++) {
            ForumRule forumRule = fj6Var.m().get(i);
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.i, fj6Var.g().forum_id + "", fj6Var.g().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, fj6Var.g().avatar, fj6Var.e().user_level.intValue(), 25053)));
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }
}
