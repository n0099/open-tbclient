package com.repackage;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoMemberItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z86 extends fb6<a96, ManitoMemberItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        public a(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a96 a96Var = (a96) view2.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, a96Var.i(), a96Var.f(), "")));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z86(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.repackage.fb6, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        o0(i, view2, viewGroup, (a96) obj, (ManitoMemberItemViewHolder) viewHolder);
        return view2;
    }

    public final SpannableStringBuilder m0(String str, String[] strArr, int[] iArr) {
        InterceptResult invokeLLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, strArr, iArr)) == null) {
            if (str == null || strArr == null || iArr == null || strArr.length <= 0 || iArr.length <= 0 || strArr.length != iArr.length) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] != null && (indexOf = str.indexOf(strArr[i])) >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(iArr[i]), indexOf, strArr[i].length() + indexOf, 17);
                }
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: n0 */
    public ManitoMemberItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ManitoMemberItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0520, (ViewGroup) null)) : (ManitoMemberItemViewHolder) invokeL.objValue;
    }

    public View o0(int i, View view2, ViewGroup viewGroup, a96 a96Var, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, a96Var, manitoMemberItemViewHolder})) == null) {
            super.S(i, view2, viewGroup, a96Var, manitoMemberItemViewHolder);
            if (a96Var != null && manitoMemberItemViewHolder != null) {
                if (manitoMemberItemViewHolder.f != this.n) {
                    SkinManager.setBackgroundResource(manitoMemberItemViewHolder.b(), R.drawable.frs_member_manito_bg);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.b, R.color.CAM_X0106, 1);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.c, R.color.CAM_X0109, 1);
                    SkinManager.setBackgroundColor(manitoMemberItemViewHolder.e, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.d, R.color.CAM_X0109, 1);
                }
                manitoMemberItemViewHolder.a.e(a96Var.b(), 12, false);
                manitoMemberItemViewHolder.b.setText(rc5.e(a96Var.g(), 16));
                if (StringUtils.isNull(a96Var.e())) {
                    manitoMemberItemViewHolder.c.setText(R.string.obfuscated_res_0x7f0f07ce);
                } else {
                    manitoMemberItemViewHolder.c.setText(rc5.e(a96Var.e(), 30));
                }
                int color = SkinManager.getColor(R.color.CAM_X0301);
                String numberUniformFormat = StringHelper.numberUniformFormat(a96Var.a());
                manitoMemberItemViewHolder.d.setText(m0(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f05fa), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
                manitoMemberItemViewHolder.b().setTag(a96Var);
                manitoMemberItemViewHolder.b().setOnClickListener(this.t);
                manitoMemberItemViewHolder.f = this.n;
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
