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
public class mz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public nr4 b;
    public nr4 c;
    public nr4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz5 a;

        public a(mz5 mz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f09194d || id == R.id.obfuscated_res_0x7f0924e4) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        xf8.a("1", "1");
                        us4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        xf8.a("2", "1");
                        us4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        xf8.a("3", "1");
                        us4.l("logoController", false);
                    }
                    iu4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.obfuscated_res_0x7f09194b) {
                    if (this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        xf8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        mz5 mz5Var = this.a;
                        mz5Var.c = xi5.a(mz5Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0ede, R.string.obfuscated_res_0x7f0f10d5);
                    }
                    this.a.c.show();
                    xf8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f0903f3) {
                    mz5.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        xf8.a("2", "2");
                        if (this.a.d == null) {
                            mz5 mz5Var2 = this.a;
                            mz5Var2.d = xi5.a(mz5Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0edf, R.string.obfuscated_res_0x7f0f10ca);
                            this.a.d.show();
                            xf8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        xf8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public mz5(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(mz5 mz5Var) {
        int i = mz5Var.e;
        mz5Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nr4 nr4Var = this.b;
            if (nr4Var != null) {
                nr4Var.dismiss();
            }
            nr4 nr4Var2 = this.c;
            if (nr4Var2 != null) {
                nr4Var2.dismiss();
            }
            nr4 nr4Var3 = this.d;
            if (nr4Var3 != null) {
                nr4Var3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nr4 b = xi5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
            xf8.b("1");
        }
    }
}
