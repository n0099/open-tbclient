package d.a.q0.a4.s.a.a;

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
import d.a.d.e.p.l;
import d.a.p0.t.c.k0;
import d.a.q0.h3.q0.m;
/* loaded from: classes7.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f54859a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f54860b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54861c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f54862d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f54863e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f54864f;

    /* renamed from: d.a.q0.a4.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1282a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f54865a;

        public C1282a(a aVar) {
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
            this.f54865a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || this.f54865a.f54859a == null) {
                return;
            }
            this.f54865a.f54859a.showPostThreadLoadingView(false);
            if (z) {
                this.f54865a.f54862d = postWriteCallBackData;
                this.f54865a.f54861c = true;
                String str3 = null;
                if (k0Var == null || k0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = k0Var.a().endPoint;
                    String str5 = k0Var.a().successImg;
                    str2 = k0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                this.f54865a.f54859a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.f54865a.f54864f != null) {
                    this.f54865a.f54864f.callback(false, postWriteCallBackData, k0Var, writeData, antiData);
                }
            } else {
                this.f54865a.f54859a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f54865a.f54859a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
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
        C1282a c1282a = new C1282a(this);
        this.f54863e = c1282a;
        this.f54859a = newVcodeView;
        this.f54860b = newWriteModel;
        newWriteModel.h0(c1282a);
    }

    @Override // d.a.q0.a4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f54859a.setRatio(0.9433962f);
            this.f54859a.showWebView(false);
            this.f54859a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // d.a.q0.a4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData X;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f54860b.X() == null || StringUtils.isNull(str) || (X = this.f54860b.X()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (X.getVcodeExtra() == null) {
                    return false;
                }
                this.f54859a.runJsMethod("handleFreshCaptcha", "'" + X.getVcodeUrl() + "','" + X.getVcodeExtra().slideImg + "','" + X.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(d.a.p0.c1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (X != null && X.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.f54859a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (X != null && X.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.f54859a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
                } else {
                    String string = this.f54859a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f54862d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f54862d.getColorMsg();
                        string = this.f54862d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (X.getType() != 7) {
                        m.b(this.f54859a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f54862d);
                intent.putExtras(bundle);
                BaseActivity context = this.f54859a.getContext();
                this.f54859a.getContext();
                context.setResult(-1, intent);
                this.f54859a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.f54859a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.a4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f54864f = gVar;
        }
    }

    @Override // d.a.q0.a4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f54859a.showPostThreadLoadingView(false);
            this.f54860b.cancelLoadData();
        }
    }

    @Override // d.a.q0.a4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!l.D()) {
                this.f54859a.getContext().showToast(R.string.neterror);
                this.f54859a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f54859a.showPostThreadLoadingView(true);
                this.f54860b.X().setVcode(str);
                this.f54860b.X().setVcodeType("5");
                this.f54860b.l0();
            } else {
                this.f54859a.getContext().showToast(R.string.neterror);
                this.f54859a.getContext().finish();
            }
        }
    }

    @Override // d.a.q0.a4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // d.a.q0.a4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.f54859a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
