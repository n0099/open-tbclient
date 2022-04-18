package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BawuTeamInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberTeamViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.MemberGroupInfo;
/* loaded from: classes6.dex */
public class ob6 extends kd6<pb6, FrsMemberTeamViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob6 a;

        public a(ob6 ob6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pb6 pb6Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = "";
                if (view2.getTag() instanceof BawuRoleInfoPub) {
                    BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view2.getTag();
                    this.a.k.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092041) {
                    Object tag = view2.getTag();
                    if (tag instanceof Integer) {
                        Integer num = (Integer) tag;
                        if (this.a.z(num.intValue()) instanceof pb6) {
                            pb6Var = (pb6) this.a.z(num.intValue());
                            if (pb6Var != null || pb6Var.b() == null) {
                            }
                            String[] split = StringUtils.isNull(pb6Var.b().member_group_type) ? null : pb6Var.b().member_group_type.split("_");
                            if (split != null && split.length == 2) {
                                str = split[0];
                            }
                            if (StringUtils.isNull(str) || !str.equalsIgnoreCase("1")) {
                                return;
                            }
                            this.a.k.sendMessage(new CustomMessage(2002001, new BawuTeamInfoActivityConfig(this.a.a, mg.g(pb6Var.a(), 0L))));
                            return;
                        }
                    }
                    pb6Var = null;
                    if (pb6Var != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new a(this);
    }

    @Override // com.repackage.kd6, com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i, view2, viewGroup, (pb6) obj, (FrsMemberTeamViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: p0 */
    public FrsMemberTeamViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new FrsMemberTeamViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02c2, (ViewGroup) null), this.t) : (FrsMemberTeamViewHolder) invokeL.objValue;
    }

    public View q0(int i, View view2, ViewGroup viewGroup, pb6 pb6Var, FrsMemberTeamViewHolder frsMemberTeamViewHolder) {
        InterceptResult invokeCommon;
        MemberGroupInfo b;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pb6Var, frsMemberTeamViewHolder})) == null) {
            super.S(i, view2, viewGroup, pb6Var, frsMemberTeamViewHolder);
            if (pb6Var != null && pb6Var.b() != null && (list = (b = pb6Var.b()).member_group_list) != null && list.size() > 0 && !StringUtils.isNull(b.member_group_type)) {
                frsMemberTeamViewHolder.a.setTag(Integer.valueOf(i));
                String[] split = !StringUtils.isNull(b.member_group_type) ? b.member_group_type.split("_") : null;
                String str = (split == null || split.length != 2) ? "" : split[1];
                TextView textView = frsMemberTeamViewHolder.a;
                textView.setText(str + "(" + b.member_group_num + SmallTailInfo.EMOTION_SUFFIX);
                int i2 = 0;
                for (BawuRoleInfoPub bawuRoleInfoPub : b.member_group_list) {
                    if (i2 > 3) {
                        break;
                    } else if (bawuRoleInfoPub != null) {
                        frsMemberTeamViewHolder.c(bawuRoleInfoPub, i2);
                        i2++;
                    }
                }
                frsMemberTeamViewHolder.d(this.n);
                SkinManager.setBackgroundColor(frsMemberTeamViewHolder.n, R.color.CAM_X0201);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.a, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.m, R.color.CAM_X0106, 1);
                frsMemberTeamViewHolder.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
