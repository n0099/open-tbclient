package d.a.n0.w3.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.p.l;
import d.a.m0.s.c.i0;
import d.a.n0.e3.q0.g;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f66647a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f66648b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66649c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f66650d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f66651e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f66652f;

    /* renamed from: d.a.n0.w3.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1776a implements NewWriteModel.g {
        public C1776a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (a.this.f66647a == null) {
                return;
            }
            a.this.f66647a.showPostThreadLoadingView(false);
            if (z) {
                a.this.f66650d = postWriteCallBackData;
                a.this.f66649c = true;
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
                a.this.f66647a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (a.this.f66652f != null) {
                    a.this.f66652f.callback(false, postWriteCallBackData, i0Var, writeData, antiData);
                }
            } else {
                a.this.f66647a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f66647a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        C1776a c1776a = new C1776a();
        this.f66651e = c1776a;
        this.f66647a = newVcodeView;
        this.f66648b = newWriteModel;
        newWriteModel.h0(c1776a);
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void a(boolean z) {
        this.f66647a.setRatio(0.9433962f);
        this.f66647a.showWebView(false);
        this.f66647a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // d.a.n0.w3.s.a.a.b
    public boolean b(WebView webView, String str) {
        WriteData X;
        String str2;
        if (this.f66648b.X() == null || StringUtils.isNull(str) || (X = this.f66648b.X()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (X.getVcodeExtra() == null) {
                return false;
            }
            this.f66647a.runJsMethod("handleFreshCaptcha", "'" + X.getVcodeUrl() + "','" + X.getVcodeExtra().slideImg + "','" + X.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            j(d.a.m0.a1.a.a(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (X != null && X.getVideoReviewType() == 1) {
                NewVcodeView newVcodeView = this.f66647a;
                newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (X != null && X.getVideoReviewType() == 2) {
                NewVcodeView newVcodeView2 = this.f66647a;
                newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.f66647a.getContext().getResources().getString(R.string.send_success);
                PostWriteCallBackData postWriteCallBackData = this.f66650d;
                String str3 = null;
                if (postWriteCallBackData != null) {
                    str3 = postWriteCallBackData.getPreMsg();
                    str2 = this.f66650d.getColorMsg();
                    string = this.f66650d.getErrorString();
                } else {
                    str2 = null;
                }
                if (X.getType() != 7) {
                    g.b(this.f66647a.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.f66650d);
            intent.putExtras(bundle);
            BaseActivity context = this.f66647a.getContext();
            this.f66647a.getContext();
            context.setResult(-1, intent);
            this.f66647a.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.f66647a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.f66652f = gVar;
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void d() {
        this.f66647a.showPostThreadLoadingView(false);
        this.f66648b.cancelLoadData();
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void e(boolean z, String str) {
    }

    public final void j(String str) {
        if (!l.D()) {
            this.f66647a.getContext().showToast(R.string.neterror);
            this.f66647a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f66647a.showPostThreadLoadingView(true);
            this.f66648b.X().setVcode(str);
            this.f66648b.X().setVcodeType("5");
            this.f66648b.m0();
        } else {
            this.f66647a.getContext().showToast(R.string.neterror);
            this.f66647a.getContext().finish();
        }
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void onDestroy() {
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f66647a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(1000);
        }
    }
}
