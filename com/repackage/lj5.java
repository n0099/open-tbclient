package com.repackage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.account.safeManage.AccountSafeModel;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lj5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseActivity a;
    public mj5 b;
    public AccountSafeModel c;
    public wa d;

    /* loaded from: classes6.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lj5 lj5Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj5Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lj5Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.a.c != null) {
                    this.a.c.G(false);
                }
                this.a.a.closeLoadingDialog();
                if (responsedMessage == null) {
                    return;
                }
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    uc8 privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                    if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                        privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                    }
                    if (this.a.c != null) {
                        this.a.c.F(privacyData);
                    }
                    if (this.a.b == null || this.a.c == null || this.a.c.z() == null) {
                        return;
                    }
                    this.a.b.d(this.a.c.z().f());
                    return;
                }
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.a.getString(R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.a.a.showToast(errorString);
            }
        }
    }

    public lj5(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.d = aVar;
        this.a = baseActivity;
        baseActivity.registerListener(aVar);
        this.b = new mj5(this.a, this);
        this.c = new AccountSafeModel(this.a);
        if (ki.z()) {
            g();
        } else {
            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.a() : (View) invokeV.objValue;
    }

    public void e(int i) {
        mj5 mj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (mj5Var = this.b) == null) {
            return;
        }
        mj5Var.e(i);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.closeLoadingDialog();
            AccountSafeModel accountSafeModel = this.c;
            if (accountSafeModel != null) {
                accountSafeModel.cancelLoadData();
            }
            mj5 mj5Var = this.b;
            if (mj5Var != null) {
                mj5Var.c();
            }
        }
    }

    public final void g() {
        AccountSafeModel accountSafeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (accountSafeModel = this.c) == null || accountSafeModel.C()) {
            return;
        }
        this.c.E();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090322) {
                TiebaStatic.log("c10013");
                if (!ki.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090053) {
                AccountSafeModel accountSafeModel = this.c;
                AntiHelper.p(this.a, accountSafeModel != null ? accountSafeModel.A() : "");
            }
        }
    }
}
