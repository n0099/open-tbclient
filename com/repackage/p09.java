package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p09 implements q09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;
    public final NewWriteModel b;
    public boolean c;
    public PostWriteCallBackData d;
    public final NewWriteModel.g e;
    public NewWriteModel.g f;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p09 a;

        public a(p09 p09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p09Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qx4Var, writeData, antiData}) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showPostThreadLoadingView(false);
            if (z) {
                this.a.d = postWriteCallBackData;
                this.a.c = true;
                String str3 = null;
                if (qx4Var == null || qx4Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = qx4Var.a().endPoint;
                    String str5 = qx4Var.a().successImg;
                    str2 = qx4Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                this.a.a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.a.f != null) {
                    this.a.f.callback(false, postWriteCallBackData, qx4Var, writeData, antiData);
                }
            } else {
                this.a.a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public p09(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeView, newWriteModel};
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
        this.e = aVar;
        this.a = newVcodeView;
        this.b = newWriteModel;
        newWriteModel.n0(aVar);
    }

    @Override // com.repackage.q09
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(0.9433962f);
            this.a.showWebView(false);
            this.a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // com.repackage.q09
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData b0;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.b.b0() == null || StringUtils.isNull(str) || (b0 = this.b.b0()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (b0.getVcodeExtra() == null) {
                    return false;
                }
                this.a.runJsMethod("handleFreshCaptcha", "'" + b0.getVcodeUrl() + "','" + b0.getVcodeExtra().slideImg + "','" + b0.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(qd5.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (b0 != null && b0.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f14f7));
                } else if (b0 != null && b0.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f14f6));
                } else {
                    String string = this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f10ec);
                    PostWriteCallBackData postWriteCallBackData = this.d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.d.getColorMsg();
                        string = this.d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (b0.getType() != 7) {
                        en8.b(this.a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.d);
                intent.putExtras(bundle);
                BaseActivity context = this.a.getContext();
                this.a.getContext();
                context.setResult(-1, intent);
                this.a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.q09
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f = gVar;
        }
    }

    @Override // com.repackage.q09
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.b.cancelLoadData();
        }
    }

    @Override // com.repackage.q09
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!oi.C()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0c17);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.b.b0().setVcode(str);
                this.b.b0().setVcodeType("5");
                this.b.r0();
            } else {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0c17);
                this.a.getContext().finish();
            }
        }
    }

    @Override // com.repackage.q09
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.repackage.q09
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
