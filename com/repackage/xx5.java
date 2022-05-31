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
/* loaded from: classes7.dex */
public class xx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public dq4 b;
    public dq4 c;
    public dq4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx5 a;

        public a(xx5 xx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f0918ff || id == R.id.obfuscated_res_0x7f09248a) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        yc8.a("1", "1");
                        kr4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        yc8.a("2", "1");
                        kr4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        yc8.a("3", "1");
                        kr4.l("logoController", false);
                    }
                    ys4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.obfuscated_res_0x7f0918fa) {
                    if (this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        yc8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        xx5 xx5Var = this.a;
                        xx5Var.c = rh5.a(xx5Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0ee2, R.string.obfuscated_res_0x7f0f10e5);
                    }
                    this.a.c.show();
                    yc8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f0903ee) {
                    xx5.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        yc8.a("2", "2");
                        if (this.a.d == null) {
                            xx5 xx5Var2 = this.a;
                            xx5Var2.d = rh5.a(xx5Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0ee3, R.string.obfuscated_res_0x7f0f10da);
                            this.a.d.show();
                            yc8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        yc8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public xx5(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(xx5 xx5Var) {
        int i = xx5Var.e;
        xx5Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dq4 dq4Var = this.b;
            if (dq4Var != null) {
                dq4Var.dismiss();
            }
            dq4 dq4Var2 = this.c;
            if (dq4Var2 != null) {
                dq4Var2.dismiss();
            }
            dq4 dq4Var3 = this.d;
            if (dq4Var3 != null) {
                dq4Var3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dq4 b = rh5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
            yc8.b("1");
        }
    }
}
