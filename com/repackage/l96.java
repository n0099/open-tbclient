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
import com.baidu.tieba.forumMember.member.ManagerApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l96 extends fb6<m96, ManagerApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: v */
    public static final int obfuscated = 2131296938;
    public transient /* synthetic */ FieldHolder $fh;
    public gy4 t;
    public View.OnClickListener u;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l96 a;

        public a(l96 l96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag(l96.obfuscated);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.a.q0(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.a), new String[]{tag.toString()});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755574200, "Lcom/repackage/l96;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755574200, "Lcom/repackage/l96;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l96(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.repackage.fb6, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        p0(i, view2, viewGroup, (m96) obj, (ManagerApplyViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: o0 */
    public ManagerApplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new ManagerApplyViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d032e, (ViewGroup) null)) : (ManagerApplyViewHolder) invokeL.objValue;
    }

    public void onDestroy() {
        gy4 gy4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gy4Var = this.t) == null) {
            return;
        }
        gy4Var.s();
    }

    public View p0(int i, View view2, ViewGroup viewGroup, m96 m96Var, ManagerApplyViewHolder managerApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m96Var, managerApplyViewHolder})) == null) {
            super.S(i, view2, viewGroup, m96Var, managerApplyViewHolder);
            if (m96Var != null && !m96Var.e() && managerApplyViewHolder != null) {
                if (m96Var.e()) {
                    managerApplyViewHolder.d.setVisibility(8);
                    return view2;
                }
                if (managerApplyViewHolder.e != this.n) {
                    SkinManager.setViewTextColor(managerApplyViewHolder.b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(managerApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(managerApplyViewHolder.c, R.drawable.frs_member_manito_bg);
                }
                int b = m96Var.b();
                if (b > 0) {
                    managerApplyViewHolder.b.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0298), StringHelper.numberUniformFormat(b)));
                    managerApplyViewHolder.c.setTag(obfuscated, m96Var.a());
                    managerApplyViewHolder.c.setOnClickListener(this.u);
                    managerApplyViewHolder.c.setEnabled(true);
                    managerApplyViewHolder.c.setClickable(true);
                } else {
                    managerApplyViewHolder.b.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f029a));
                    managerApplyViewHolder.c.setEnabled(false);
                    managerApplyViewHolder.c.setClickable(false);
                }
                managerApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.e = this.n;
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
                this.t = new gy4(pageActivity);
            }
            this.t.p();
            this.t.u(accountData);
            this.t.z(1);
        }
    }
}
