package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public dr4 b;
    public dr4 c;
    public dr4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz5 a;

        public a(jz5 jz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f0918f4 || id == R.id.obfuscated_res_0x7f092493) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        bh8.a("1", "1");
                        ks4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        bh8.a("2", "1");
                        ks4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        bh8.a("3", "1");
                        ks4.l("logoController", false);
                    }
                    wt4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.obfuscated_res_0x7f0918f2) {
                    if (this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        bh8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        jz5 jz5Var = this.a;
                        jz5Var.c = ei5.a(jz5Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0ec1, R.string.obfuscated_res_0x7f0f10bd);
                    }
                    this.a.c.show();
                    bh8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f0903f8) {
                    jz5.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        bh8.a("2", "2");
                        if (this.a.d == null) {
                            jz5 jz5Var2 = this.a;
                            jz5Var2.d = ei5.a(jz5Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0ec2, R.string.obfuscated_res_0x7f0f10b2);
                            this.a.d.show();
                            bh8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        bh8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public jz5(@NonNull BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(jz5 jz5Var) {
        int i = jz5Var.e;
        jz5Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dr4 dr4Var = this.b;
            if (dr4Var != null) {
                dr4Var.dismiss();
            }
            dr4 dr4Var2 = this.c;
            if (dr4Var2 != null) {
                dr4Var2.dismiss();
            }
            dr4 dr4Var3 = this.d;
            if (dr4Var3 != null) {
                dr4Var3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dr4 b = ei5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
            bh8.b("1");
        }
    }
}
