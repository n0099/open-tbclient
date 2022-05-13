package com.repackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.PrivateMgrApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xa6 extends pc6<ya6, PrivateMgrApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: v */
    public static final int obfuscated = 2131302727;
    public transient /* synthetic */ FieldHolder $fh;
    public kz4 t;
    public View.OnClickListener u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;

        public a(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view2.getTag(xa6.obfuscated);
                    if (tag == null || tag.toString().equals("")) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.a), new String[]{tag.toString()});
                    return;
                }
                this.a.q0(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755178268, "Lcom/repackage/xa6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755178268, "Lcom/repackage/xa6;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xa6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new a(this);
    }

    @Override // com.repackage.pc6, com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        p0(i, view2, viewGroup, (ya6) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: o0 */
    public PrivateMgrApplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PrivateMgrApplyViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06f9, (ViewGroup) null)) : (PrivateMgrApplyViewHolder) invokeL.objValue;
    }

    public void onDestroy() {
        kz4 kz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (kz4Var = this.t) == null) {
            return;
        }
        kz4Var.s();
    }

    public View p0(int i, View view2, ViewGroup viewGroup, ya6 ya6Var, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ya6Var, privateMgrApplyViewHolder})) == null) {
            super.S(i, view2, viewGroup, ya6Var, privateMgrApplyViewHolder);
            if (ya6Var != null && !ya6Var.f() && privateMgrApplyViewHolder != null) {
                if (ya6Var.f()) {
                    privateMgrApplyViewHolder.e.setVisibility(8);
                    return view2;
                }
                boolean z = true;
                if (privateMgrApplyViewHolder.f != this.n) {
                    SkinManager.setBackgroundColor(privateMgrApplyViewHolder.d, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(privateMgrApplyViewHolder.c, R.drawable.frs_member_manito_bg);
                }
                int a2 = ya6Var.a();
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f139b);
                if (a2 == -1) {
                    int e = ya6Var.e();
                    String numberUniformFormat = StringHelper.numberUniformFormat(e);
                    if (e > 0) {
                        string = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1395), numberUniformFormat);
                        privateMgrApplyViewHolder.c.setOnClickListener(this.u);
                        privateMgrApplyViewHolder.b.setText(string);
                        privateMgrApplyViewHolder.c.setTag(obfuscated, ya6Var.b());
                        privateMgrApplyViewHolder.c.setEnabled(z);
                        privateMgrApplyViewHolder.c.setClickable(z);
                        privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.f = this.n;
                    }
                    z = false;
                    privateMgrApplyViewHolder.c.setOnClickListener(this.u);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, ya6Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.n;
                } else {
                    if (a2 == 0) {
                        string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1399);
                    } else if (a2 == 1) {
                        string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1397);
                    } else {
                        if (a2 == 2) {
                            string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1396);
                        }
                        z = false;
                    }
                    privateMgrApplyViewHolder.c.setOnClickListener(this.u);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, ya6Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.n;
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void q0(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accountData) == null) {
            b9<?> a2 = f9.a(this.a);
            Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
            if (this.t == null) {
                this.t = new kz4(pageActivity);
            }
            this.t.p();
            this.t.u(accountData);
            this.t.z(1);
        }
    }
}
