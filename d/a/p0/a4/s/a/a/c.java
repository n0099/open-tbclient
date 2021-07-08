package d.a.p0.a4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.o0.s.c.i0;
import d.a.p0.h3.q0.g;
/* loaded from: classes7.dex */
public class c implements d.a.p0.a4.s.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f54322a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f54323b;

    /* renamed from: c  reason: collision with root package name */
    public String f54324c;

    /* renamed from: d  reason: collision with root package name */
    public String f54325d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54326e;

    /* renamed from: f  reason: collision with root package name */
    public String f54327f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54328g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f54329h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f54330i;
    public NewWriteModel.g j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f54331e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54331e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54331e.f54322a == null) {
                return;
            }
            if (StringUtils.isNull(this.f54331e.f54327f)) {
                this.f54331e.f54322a.showToast(false, this.f54331e.f54322a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                this.f54331e.f54322a.showToast(false, this.f54331e.f54327f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f54332a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54332a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || this.f54332a.f54322a == null) {
                return;
            }
            this.f54332a.f54322a.showPostThreadLoadingView(false);
            if (z) {
                this.f54332a.f54328g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    this.f54332a.f54322a.showToast(true, this.f54332a.f54322a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    this.f54332a.f54322a.showToast(true, this.f54332a.f54322a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = this.f54332a.f54322a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        g.b(this.f54332a.f54322a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = this.f54332a.f54322a.getContext();
                this.f54332a.f54322a.getContext();
                context.setResult(-1, intent);
                this.f54332a.f54322a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                this.f54332a.f54322a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f54332a.f54322a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && this.f54332a.j != null) {
                if (this.f54332a.j != null) {
                    this.f54332a.j.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.f54332a.f54322a.showToast(false, this.f54332a.f54322a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    this.f54332a.f54322a.showToast(false, postWriteCallBackData.getErrorString());
                }
                this.f54332a.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
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
        this.f54326e = false;
        this.f54327f = null;
        this.f54329h = new a(this);
        b bVar = new b(this);
        this.f54330i = bVar;
        this.f54322a = newVcodeView;
        this.f54323b = newWriteModel;
        newWriteModel.h0(bVar);
    }

    @Override // d.a.p0.a4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f54322a.setRatio(1.2631578f);
            this.f54322a.showWebView(false);
            String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
            if (z) {
                str = str + "?feedback=1";
            }
            this.f54322a.getWebView().loadUrl(str);
        }
    }

    @Override // d.a.p0.a4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (str.contains("objc:jsChangeVcode")) {
                String a2 = d.a.o0.a1.a.a(str);
                this.f54324c = a2;
                if (a2 == null || this.f54323b.X() == null) {
                    return false;
                }
                NewVcodeView newVcodeView = this.f54322a;
                String str2 = this.f54324c;
                newVcodeView.runJsMethod(str2, "'" + this.f54323b.X().getVcodeUrl() + "'");
                return true;
            } else if (str.equals("objc:jumpToFeedback()")) {
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.f54322a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            } else if (str.contains("objc:jsSubmit")) {
                return k(d.a.o0.a1.a.a(str));
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.p0.a4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.j = gVar;
        }
    }

    @Override // d.a.p0.a4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f54322a.showPostThreadLoadingView(false);
            this.f54323b.cancelLoadData();
        }
    }

    @Override // d.a.p0.a4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
            this.f54326e = z;
            this.f54327f = str;
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
                return false;
            }
            this.f54325d = split[0];
            l(split[1]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!l.D()) {
                this.f54322a.getContext().showToast(R.string.neterror);
                this.f54322a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f54322a.showPostThreadLoadingView(true);
                this.f54323b.X().setVcode(str);
                this.f54323b.X().setVcodeType("4");
                this.f54323b.l0();
            } else {
                this.f54322a.getContext().showToast(R.string.neterror);
                this.f54322a.getContext().finish();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NewVcodeView newVcodeView = this.f54322a;
            String str = this.f54325d;
            newVcodeView.runJsMethod(str, "'" + this.f54323b.X().getVcodeUrl() + "'");
        }
    }

    @Override // d.a.p0.a4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e.a().removeCallbacks(this.f54329h);
        }
    }

    @Override // d.a.p0.a4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) || (newVcodeView = this.f54322a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(500);
        if (this.f54326e) {
            e.a().postDelayed(this.f54329h, 500L);
        }
    }
}
