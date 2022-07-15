package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tp7 extends qp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp7 a;

        public a(tp7 tp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp7Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.b.closeLoadingDialog();
                BaseActivity baseActivity = this.a.b;
                baseActivity.showToast(String.format(baseActivity.getString(R.string.obfuscated_res_0x7f0f0cda), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                this.a.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp7(TbPageContext tbPageContext, rp7 rp7Var) {
        super(tbPageContext, rp7Var, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rp7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (rp7) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.qp7
    public void j(sp7 sp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sp7Var) == null) {
            this.e = sp7Var;
        }
    }

    @Override // com.repackage.qp7
    public void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.n(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f091399) {
                s();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09166f) {
                t();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090163) {
                r();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091992) {
                u();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BaseActivity baseActivity = this.b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cd1), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            PassportSDK passportSDK = PassportSDK.getInstance();
            BaseActivity baseActivity = this.b;
            passportSDK.loadOneKeyLogin(baseActivity, yp7.j(baseActivity, this.e.c), new a(this));
        }
    }

    public final void t() {
        sp7 sp7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (sp7Var = this.e) == null) {
            return;
        }
        int a2 = sp7Var.a();
        if (a2 == 1) {
            BaseActivity baseActivity = this.b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cd2), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
        } else if (a2 == 2) {
            BaseActivity baseActivity2 = this.b;
            new TbWebViewActivityConfig(baseActivity2, baseActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0cd3), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
        } else if (a2 != 3) {
        } else {
            BaseActivity baseActivity3 = this.b;
            new TbWebViewActivityConfig(baseActivity3, baseActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0cd4), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BaseActivity baseActivity = this.b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cd5), "http://privacy.baidu.com/mdetail?id=288", false).start();
        }
    }
}
