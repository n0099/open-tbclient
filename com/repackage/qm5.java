package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.holder.SquareLiveCategoryViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class qm5 extends wm<tm5, SquareLiveCategoryViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAlaSquareTabController i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm5 a;
        public final /* synthetic */ qm5 b;

        public a(qm5 qm5Var, tm5 tm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm5Var, tm5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qm5Var;
            this.a = tm5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.i != null) {
                    int tabIndex = this.b.i.getTabIndex(this.a.a);
                    if (tabIndex >= 0) {
                        this.b.i.goToTab(tabIndex);
                        return;
                    } else {
                        this.b.b0(this.a);
                        return;
                    }
                }
                this.b.b0(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qm5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b0(tm5 tm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tm5Var) == null) {
            Context context = this.a;
            String str = tm5Var.d;
            String str2 = tm5Var.b;
            String str3 = tm5Var.c;
            List<String> list = tm5Var.e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(context, str, str2, str3, (list == null || !(list instanceof ArrayList)) ? null : (ArrayList) list)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public SquareLiveCategoryViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new SquareLiveCategoryViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0788, viewGroup, false)) : (SquareLiveCategoryViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, tm5 tm5Var, SquareLiveCategoryViewHolder squareLiveCategoryViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tm5Var, squareLiveCategoryViewHolder})) == null) {
            View findViewById = squareLiveCategoryViewHolder.a.findViewById(R.id.obfuscated_res_0x7f091259);
            TextView textView = (TextView) squareLiveCategoryViewHolder.a.findViewById(R.id.obfuscated_res_0x7f091257);
            TextView textView2 = (TextView) squareLiveCategoryViewHolder.a.findViewById(R.id.obfuscated_res_0x7f091258);
            ImageView imageView = (ImageView) squareLiveCategoryViewHolder.a.findViewById(R.id.obfuscated_res_0x7f091256);
            if (i == 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(squareLiveCategoryViewHolder.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
            textView.setText(!TextUtils.isEmpty(tm5Var.c) ? tm5Var.c : tm5Var.b);
            textView2.setOnClickListener(new a(this, tm5Var));
            return squareLiveCategoryViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.i = iAlaSquareTabController;
        }
    }
}
