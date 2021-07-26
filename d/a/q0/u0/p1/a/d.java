package d.a.q0.u0.p1.a;

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
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes8.dex */
public class d extends d.a.d.k.e.a<d.a.q0.u0.p1.c.b, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity m;
    public String n;
    public boolean o;
    public int p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.u0.p1.c.b f64143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f64144f;

        public a(d dVar, d.a.q0.u0.p1.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64144f = dVar;
            this.f64143e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f64144f.o) {
                    this.f64144f.m0();
                } else {
                    this.f64144f.n0(this.f64143e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdUniqueId};
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
        this.o = false;
        this.p = 0;
        this.m = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.u0.p1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        l0(i2, view, viewGroup, bVar, forumRuleDetailSelfVH);
        return view;
    }

    public final void i0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, d.a.q0.u0.p1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailSelfVH, bVar) == null) {
            if (bVar.d() != null) {
                forumRuleDetailSelfVH.f15685b.setDefaultResource(R.drawable.img_default_100);
                forumRuleDetailSelfVH.f15685b.M(bVar.d().portrait, 12, false);
                forumRuleDetailSelfVH.f15686c.setText(bVar.d().name_show);
                forumRuleDetailSelfVH.c(bVar.d().user_level.intValue());
                forumRuleDetailSelfVH.f15688e.setVisibility(0);
            }
            forumRuleDetailSelfVH.f15687d.setText(R.string.bawu_member_bazhu_tip);
            forumRuleDetailSelfVH.f15687d.setVisibility(0);
            forumRuleDetailSelfVH.h("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.g(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.f15690g.setText(bVar.l());
            }
            j0(forumRuleDetailSelfVH, bVar);
            forumRuleDetailSelfVH.d(bVar.j());
        }
    }

    public final void j0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, d.a.q0.u0.p1.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, forumRuleDetailSelfVH, bVar) == null) && bVar.i()) {
            forumRuleDetailSelfVH.f15691h.setOnClickListener(new a(this, bVar));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.f15691h.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.l()) && bVar.c() == 0) {
                long a2 = d.a.q0.u0.p1.e.a.a(bVar.l());
                int b2 = d.a.q0.u0.p1.e.a.b(Long.valueOf(StringUtils.isNull(bVar.e()) ? "0" : bVar.e()).longValue() - a2);
                if (b2 < 0) {
                    b2 = d.a.q0.u0.p1.e.a.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.f15691h.setVisibility(0);
                if (b2 >= 7) {
                    this.o = false;
                    return;
                }
                forumRuleDetailSelfVH.f15691h.setUseDisableState(true);
                this.o = true;
                this.p = 7 - b2;
            } else {
                forumRuleDetailSelfVH.f(bVar.c());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: k0 */
    public ForumRuleDetailSelfVH Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_user_area, viewGroup, false));
            this.k = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, d.a.q0.u0.p1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, forumRuleDetailSelfVH})) == null) {
            if (bVar == null) {
                return view;
            }
            i0(forumRuleDetailSelfVH, bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (forumRulesShowActivity = this.m) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.forum_rules_later_days_edit);
        String format = String.format(string, this.p + "");
        if (this.m.getView() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.m);
            bdTopToast.i(false);
            bdTopToast.h(format);
            bdTopToast.j(this.m.getView().l());
        }
    }

    public final void n0(d.a.q0.u0.p1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.m == null || bVar == null) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
        forumRuleBaseData.setTitle(bVar.o());
        forumRuleBaseData.setPreface(bVar.j());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bVar.n().size(); i2++) {
            ForumRule forumRule = bVar.n().get(i2);
            ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
            forumRuleItemPbData.status = forumRule.status + "";
            forumRuleItemPbData.title = forumRule.title + "";
            forumRuleItemPbData.mContent = new ArrayList();
            List<PbContent> list = forumRule.content;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < forumRule.content.size(); i3++) {
                    PbContent pbContent = forumRule.content.get(i3);
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                    forumRuleItemPbContentData.href = pbContent.link;
                    if (pbContent.type.intValue() == 0) {
                        forumRuleItemPbContentData.tag = "plainText";
                    } else if (pbContent.type.intValue() == 1) {
                        forumRuleItemPbContentData.tag = "a";
                    } else if (pbContent.type.intValue() == 2) {
                        forumRuleItemPbContentData.tag = "br";
                    }
                    forumRuleItemPbContentData.value = pbContent.text;
                    forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                }
            }
            arrayList.add(forumRuleItemPbData);
        }
        forumRuleBaseData.setPbDataList(arrayList);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.m, bVar.h().forum_id + "", bVar.h().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.h().avatar, bVar.d().user_level.intValue(), 25053)));
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.n = str;
        }
    }
}
