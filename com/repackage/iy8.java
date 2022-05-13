package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jy8 a;
    public final NewWriteModel b;
    public boolean c;
    public final NewWriteModel.g d;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy8 a;

        public a(iy8 iy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ey4 ey4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ey4Var, writeData, antiData}) == null) || this.a.a == null || this.a.b == null || this.a.b.b0() == null) {
                return;
            }
            this.a.a.o(false);
            if (writeData == null) {
                writeData = this.a.b.b0();
            }
            WriteData writeData2 = writeData;
            if (z) {
                this.a.c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        bm8.b(this.a.a.getContext().getActivity(), this.a.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1106), null, null);
                    } else {
                        bm8.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = this.a.a.getContext();
                this.a.a.getContext();
                context.setResult(-1, intent);
                this.a.a.getContext().finish();
            } else if (writeData2 != null && ey4Var != null && !TextUtils.isEmpty(ey4Var.d())) {
                writeData2.setVcodeMD5(ey4Var.b());
                writeData2.setVcodeUrl(ey4Var.c());
                writeData2.setVcodeExtra(ey4Var.a());
                this.a.a.getContext().setVisible(false);
                if (je5.b(ey4Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData2, false, ey4Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getContext().getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    bm8.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity context2 = this.a.a.getContext();
                    this.a.a.getContext();
                    context2.setResult(0, null);
                }
                this.a.a.getContext().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity context3 = this.a.a.getContext();
                this.a.a.getContext();
                context3.setResult(0, intent2);
                this.a.a.getContext().finish();
            }
        }
    }

    public iy8(jy8 jy8Var, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jy8Var, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.d = aVar;
        this.a = jy8Var;
        this.b = newWriteModel;
        newWriteModel.n0(aVar);
    }

    public void d() {
        jy8 jy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (jy8Var = this.a) == null) {
            return;
        }
        jy8Var.r(500);
    }

    public void e() {
        jy8 jy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jy8Var = this.a) == null) {
            return;
        }
        jy8Var.o(false);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a == null || str == null) {
                return false;
            }
            if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
                this.a.getContext().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
                this.a.n(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.a.g() != this.a.h()) {
                    jy8 jy8Var = this.a;
                    jy8Var.m(jy8Var.g());
                    this.a.s();
                }
                this.a.i().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
                this.a.getContext().finish();
                UrlManager.getInstance().dealOneLink(this.a.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == null || this.b == null) {
            return;
        }
        if (!mi.C()) {
            this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0c2d);
            this.a.getContext().finish();
            return;
        }
        this.a.o(true);
        this.b.r0();
    }

    public void h(String str) {
        jy8 jy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jy8Var = this.a) == null) {
            return;
        }
        jy8Var.p(true);
        this.a.q(false);
        this.a.i().loadUrl(str);
    }
}
