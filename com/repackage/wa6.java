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
public class wa6 extends cd6<xa6, ManitoMemberItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa6 a;

        public a(wa6 wa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xa6 xa6Var = (xa6) view2.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, xa6Var.h(), xa6Var.d(), "")));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.repackage.cd6, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        o0(i, view2, viewGroup, (xa6) obj, (ManitoMemberItemViewHolder) viewHolder);
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
    @Override // com.repackage.an
    /* renamed from: n0 */
    public ManitoMemberItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ManitoMemberItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0541, (ViewGroup) null)) : (ManitoMemberItemViewHolder) invokeL.objValue;
    }

    public View o0(int i, View view2, ViewGroup viewGroup, xa6 xa6Var, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xa6Var, manitoMemberItemViewHolder})) == null) {
            super.S(i, view2, viewGroup, xa6Var, manitoMemberItemViewHolder);
            if (xa6Var != null && manitoMemberItemViewHolder != null) {
                if (manitoMemberItemViewHolder.f != this.n) {
                    SkinManager.setBackgroundResource(manitoMemberItemViewHolder.a(), R.drawable.frs_member_manito_bg);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.b, R.color.CAM_X0106, 1);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.c, R.color.CAM_X0109, 1);
                    SkinManager.setBackgroundColor(manitoMemberItemViewHolder.e, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.d, R.color.CAM_X0109, 1);
                }
                manitoMemberItemViewHolder.a.e(xa6Var.b(), 12, false);
                manitoMemberItemViewHolder.b.setText(je5.e(xa6Var.g(), 16));
                if (StringUtils.isNull(xa6Var.c())) {
                    manitoMemberItemViewHolder.c.setText(R.string.obfuscated_res_0x7f0f07d1);
                } else {
                    manitoMemberItemViewHolder.c.setText(je5.e(xa6Var.c(), 30));
                }
                int color = SkinManager.getColor(R.color.CAM_X0301);
                String numberUniformFormat = StringHelper.numberUniformFormat(xa6Var.a());
                manitoMemberItemViewHolder.d.setText(m0(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f05f4), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
                manitoMemberItemViewHolder.a().setTag(xa6Var);
                manitoMemberItemViewHolder.a().setOnClickListener(this.t);
                manitoMemberItemViewHolder.f = this.n;
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
