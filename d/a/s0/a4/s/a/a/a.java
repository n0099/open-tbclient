package d.a.s0.a4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import d.a.c.e.p.l;
import d.a.r0.s.c.i0;
import d.a.s0.h3.q0.g;
/* loaded from: classes9.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f57570a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f57571b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57572c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f57573d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f57574e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f57575f;

    /* renamed from: d.a.s0.a4.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1319a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57576a;

        public C1319a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57576a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || this.f57576a.f57570a == null) {
                return;
            }
            this.f57576a.f57570a.showPostThreadLoadingView(false);
            if (z) {
                this.f57576a.f57573d = postWriteCallBackData;
                this.f57576a.f57572c = true;
                String str3 = null;
                if (i0Var == null || i0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = i0Var.a().endPoint;
                    String str5 = i0Var.a().successImg;
                    str2 = i0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                this.f57576a.f57570a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.f57576a.f57575f != null) {
                    this.f57576a.f57575f.callback(false, postWriteCallBackData, i0Var, writeData, antiData);
                }
            } else {
                this.f57576a.f57570a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f57576a.f57570a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeView, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1319a c1319a = new C1319a(this);
        this.f57574e = c1319a;
        this.f57570a = newVcodeView;
        this.f57571b = newWriteModel;
        newWriteModel.h0(c1319a);
    }

    @Override // d.a.s0.a4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f57570a.setRatio(0.9433962f);
            this.f57570a.showWebView(false);
            this.f57570a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // d.a.s0.a4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData X;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f57571b.X() == null || StringUtils.isNull(str) || (X = this.f57571b.X()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (X.getVcodeExtra() == null) {
                    return false;
                }
                this.f57570a.runJsMethod("handleFreshCaptcha", "'" + X.getVcodeUrl() + "','" + X.getVcodeExtra().slideImg + "','" + X.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(d.a.r0.a1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (X != null && X.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.f57570a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (X != null && X.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.f57570a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
                } else {
                    String string = this.f57570a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f57573d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f57573d.getColorMsg();
                        string = this.f57573d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (X.getType() != 7) {
                        g.b(this.f57570a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f57573d);
                intent.putExtras(bundle);
                BaseActivity context = this.f57570a.getContext();
                this.f57570a.getContext();
                context.setResult(-1, intent);
                this.f57570a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.f57570a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.s0.a4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f57575f = gVar;
        }
    }

    @Override // d.a.s0.a4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57570a.showPostThreadLoadingView(false);
            this.f57571b.cancelLoadData();
        }
    }

    @Override // d.a.s0.a4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!l.D()) {
                this.f57570a.getContext().showToast(R.string.neterror);
                this.f57570a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f57570a.showPostThreadLoadingView(true);
                this.f57571b.X().setVcode(str);
                this.f57571b.X().setVcodeType("5");
                this.f57571b.m0();
            } else {
                this.f57570a.getContext().showToast(R.string.neterror);
                this.f57570a.getContext().finish();
            }
        }
    }

    @Override // d.a.s0.a4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // d.a.s0.a4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.f57570a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
