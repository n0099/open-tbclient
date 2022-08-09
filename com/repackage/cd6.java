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
/* loaded from: classes5.dex */
public class cd6 extends ue6<dd6, PrivateMgrApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131302982;
    public transient /* synthetic */ FieldHolder $fh;
    public o05 l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd6 a;

        public a(cd6 cd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view2.getTag(cd6.obfuscated);
                    if (tag == null || tag.toString().equals("")) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(this.a.mContext), new String[]{tag.toString()});
                    return;
                }
                this.a.K(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755800996, "Lcom/repackage/cd6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755800996, "Lcom/repackage/cd6;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: H */
    public PrivateMgrApplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) ? new PrivateMgrApplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0739, (ViewGroup) null)) : (PrivateMgrApplyViewHolder) invokeL.objValue;
    }

    public View J(int i, View view2, ViewGroup viewGroup, dd6 dd6Var, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dd6Var, privateMgrApplyViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, dd6Var, privateMgrApplyViewHolder);
            if (dd6Var != null && !dd6Var.f() && privateMgrApplyViewHolder != null) {
                if (dd6Var.f()) {
                    privateMgrApplyViewHolder.e.setVisibility(8);
                    return view2;
                }
                boolean z = true;
                if (privateMgrApplyViewHolder.f != this.f) {
                    SkinManager.setBackgroundColor(privateMgrApplyViewHolder.d, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(privateMgrApplyViewHolder.c, R.drawable.frs_member_manito_bg);
                }
                int a2 = dd6Var.a();
                String string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f139f);
                if (a2 == -1) {
                    int c = dd6Var.c();
                    String numberUniformFormat = StringHelper.numberUniformFormat(c);
                    if (c > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1399), numberUniformFormat);
                        privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                        privateMgrApplyViewHolder.b.setText(string);
                        privateMgrApplyViewHolder.c.setTag(obfuscated, dd6Var.b());
                        privateMgrApplyViewHolder.c.setEnabled(z);
                        privateMgrApplyViewHolder.c.setClickable(z);
                        privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.f = this.f;
                    }
                    z = false;
                    privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, dd6Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.f;
                } else {
                    if (a2 == 0) {
                        string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f139d);
                    } else if (a2 == 1) {
                        string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f139b);
                    } else {
                        if (a2 == 2) {
                            string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f139a);
                        }
                        z = false;
                    }
                    privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, dd6Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.f;
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void K(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            d9<?> a2 = h9.a(this.mContext);
            Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
            if (this.l == null) {
                this.l = new o05(pageActivity);
            }
            this.l.p();
            this.l.u(accountData);
            this.l.z(1);
        }
    }

    public void onDestroy() {
        o05 o05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (o05Var = this.l) == null) {
            return;
        }
        o05Var.s();
    }

    @Override // com.repackage.ue6, com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        J(i, view2, viewGroup, (dd6) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view2;
    }
}
