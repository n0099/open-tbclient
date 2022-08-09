package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
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
public class o09 implements n09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final NewVcodeView a;
    @NonNull
    public final NewWriteModel b;
    public final NewWriteModel.e c;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o09 a;

        public a(o09 o09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o09Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                this.a.a.showPostThreadLoadingView(false);
                if (z) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    this.a.a.getContext().setResult(-1, intent);
                    this.a.a.getContext().finish();
                } else if (az4Var == null || TextUtils.isEmpty(az4Var.c())) {
                    if (postWriteCallBackData != null) {
                        this.a.a.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    this.a.a.getContext().finish();
                } else if (this.a.a.getWebView() != null) {
                    this.a.a.getWebView().loadUrl(az4Var.c());
                }
            }
        }
    }

    public o09(@NonNull NewVcodeView newVcodeView, @NonNull NewWriteModel newWriteModel) {
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
        this.c = aVar;
        this.a = newVcodeView;
        this.b = newWriteModel;
        newWriteModel.d0(aVar);
    }

    @Override // com.repackage.n09
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.showWebView(false);
            if (this.b.U() == null) {
                return;
            }
            String vcodeUrl = this.b.U().getVcodeUrl();
            if (TextUtils.isEmpty(vcodeUrl) || this.a.getWebView() == null) {
                return;
            }
            this.a.getWebView().loadUrl(vcodeUrl);
        }
    }

    @Override // com.repackage.n09
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains("objc:jsAiCodeBack")) {
                String a2 = uf5.a(str);
                if (!TextUtils.isEmpty(a2) && !"0".equals(a2)) {
                    g(a2);
                    return true;
                }
                this.a.getContext().finish();
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.n09
    public void c(NewWriteModel.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
        }
    }

    @Override // com.repackage.n09
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.b.cancelLoadData();
        }
    }

    @Override // com.repackage.n09
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!qi.D()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0c3c);
                this.a.getContext().finish();
            } else if (!TextUtils.isEmpty(str)) {
                this.a.showPostThreadLoadingView(true);
                if (this.b.U() != null) {
                    this.b.U().setVcode(str);
                    this.b.U().setVcodeType("6");
                }
                this.b.g0();
            } else {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0c3c);
                this.a.getContext().finish();
            }
        }
    }

    @Override // com.repackage.n09
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.repackage.n09
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) {
            this.a.showWebViewDelay(500);
        }
    }
}
