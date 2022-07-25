package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ComplaintBarlordViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ya6 extends an<za6, ComplaintBarlordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public View.OnClickListener j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya6 a;

        public a(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof String)) {
                String str = (String) view2.getTag();
                if (this.a.i == 1 || this.a.i == 4) {
                    str = str + "?isNightModel=1";
                }
                CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f0416), str, true));
                customMessage.setTag(this.a.e);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya6(d9 d9Var) {
        super(d9Var.getPageActivity(), za6.c, d9Var.getUniqueId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, za6 za6Var, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        g0(i, view2, viewGroup, za6Var, complaintBarlordViewHolder);
        return view2;
    }

    public final void d0(ComplaintBarlordViewHolder complaintBarlordViewHolder, za6 za6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, complaintBarlordViewHolder, za6Var) == null) {
            complaintBarlordViewHolder.d.setText(za6Var.a);
            complaintBarlordViewHolder.b.setTag(za6Var.b);
            complaintBarlordViewHolder.b.setOnClickListener(this.j);
        }
    }

    public final void e0(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, complaintBarlordViewHolder) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.i = skinType;
            if (complaintBarlordViewHolder.a == skinType) {
                return;
            }
            complaintBarlordViewHolder.a = skinType;
            SkinManager.setBackgroundResource(complaintBarlordViewHolder.b, R.drawable.frs_member_manito_bg);
            SkinManager.setBackgroundColor(complaintBarlordViewHolder.c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(complaintBarlordViewHolder.d, R.color.CAM_X0105, 1);
            SkinManager.setImageResource(complaintBarlordViewHolder.e, R.drawable.icon_arrow12_gray66_right);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public ComplaintBarlordViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new ComplaintBarlordViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03e3, viewGroup, false)) : (ComplaintBarlordViewHolder) invokeL.objValue;
    }

    public View g0(int i, View view2, ViewGroup viewGroup, za6 za6Var, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, za6Var, complaintBarlordViewHolder})) == null) {
            if (za6Var != null && complaintBarlordViewHolder != null) {
                e0(complaintBarlordViewHolder);
                d0(complaintBarlordViewHolder, za6Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
