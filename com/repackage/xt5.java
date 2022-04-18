package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
/* loaded from: classes7.dex */
public class xt5 extends ho<nu5, CardViewHolder<kv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public ur8 j;
    public boolean k;
    public String l;
    public String m;
    public String n;
    public TextView o;
    public boolean p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu5 a;
        public final /* synthetic */ xt5 b;

        public a(xt5 xt5Var, nu5 nu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt5Var, nu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt5Var;
            this.a = nu5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f0(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xt5 xt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ xt5 b;

        public c(xt5 xt5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt5Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt5Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.b.k ? this.b.l : "0";
                String str2 = this.b.k ? this.b.m : null;
                String str3 = this.b.k ? this.b.n : null;
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                gf.n().j(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), nu5.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.p = false;
        this.i = tbPageContext;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.m = str;
        }
    }

    public final void e0(nu5 nu5Var, kv5 kv5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, nu5Var, kv5Var) == null) || nu5Var.e() == null) {
            return;
        }
        this.o = kv5Var.s();
        n0();
        kv5Var.x(8);
        kv5Var.y(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0232));
        kv5Var.m(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void f0(nu5 nu5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, nu5Var) == null) || nu5Var == null || nu5Var.e() == null) {
            return;
        }
        vt4.k().u(vt4.o("live_publish_live_has_showed"), true);
        o0(this.o, null, false);
        j0();
        TiebaStatic.log("c13618");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: g0 */
    public CardViewHolder<kv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new CardViewHolder<>(new kv5(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: h0 */
    public View S(int i, View view2, ViewGroup viewGroup, nu5 nu5Var, CardViewHolder<kv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nu5Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            e0(nu5Var, cardViewHolder.c());
            cardViewHolder.c().k().setOnClickListener(new a(this, nu5Var));
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }

    public final void i0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
        permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void j0() {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                cr4 cr4Var = new cr4(this.i.getPageActivity());
                cr4Var.setAutoNight(false);
                cr4Var.setTitle(R.string.obfuscated_res_0x7f0f0eec);
                cr4Var.setMessage(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f04e1));
                cr4Var.setTitleShowCenter(true);
                cr4Var.setMessageShowCenter(true);
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0984, new b(this));
                cr4Var.create(this.i).show();
            } else if (ViewHelper.checkUpIsLogin(this.i.getPageActivity())) {
                if (this.j == null) {
                    this.j = new ur8(this.i);
                }
                if (this.k) {
                    if (this.j.c()) {
                        return;
                    }
                } else if (this.j.d()) {
                    return;
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    oi.M(this.i.getPageActivity(), R.string.obfuscated_res_0x7f0f0e5a);
                } else {
                    i0(this.i);
                }
            }
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.n = str;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.p) {
            return;
        }
        this.p = true;
        if (!vt4.k().h(vt4.o("live_publish_live_has_showed"), false)) {
            vt4.k().u(vt4.o("live_publish_live_has_showed"), true);
            o0(this.o, null, true);
            return;
        }
        o0(this.o, null, false);
    }

    public final void o0(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048589, this, textView, str, z) == null) || textView == null || this.i == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801e2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
