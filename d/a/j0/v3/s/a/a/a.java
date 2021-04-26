package d.a.j0.v3.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.i0.s.c.h0;
import d.a.j0.d3.q0.g;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f62099a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f62100b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62101c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f62102d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f62103e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f62104f;

    /* renamed from: d.a.j0.v3.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1640a implements NewWriteModel.g {
        public C1640a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (a.this.f62099a == null) {
                return;
            }
            a.this.f62099a.showPostThreadLoadingView(false);
            if (z) {
                a.this.f62102d = postWriteCallBackData;
                a.this.f62101c = true;
                String str3 = null;
                if (h0Var == null || h0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = h0Var.a().endPoint;
                    String str5 = h0Var.a().successImg;
                    str2 = h0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                a.this.f62099a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (a.this.f62104f != null) {
                    a.this.f62104f.callback(false, postWriteCallBackData, h0Var, writeData, antiData);
                }
            } else {
                a.this.f62099a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f62099a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        C1640a c1640a = new C1640a();
        this.f62103e = c1640a;
        this.f62099a = newVcodeView;
        this.f62100b = newWriteModel;
        newWriteModel.d0(c1640a);
    }

    @Override // d.a.j0.v3.s.a.a.b
    public void a(boolean z) {
        this.f62099a.setRatio(0.9433962f);
        this.f62099a.showWebView(false);
        this.f62099a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // d.a.j0.v3.s.a.a.b
    public boolean b(WebView webView, String str) {
        WriteData T;
        String str2;
        if (this.f62100b.T() == null || StringUtils.isNull(str) || (T = this.f62100b.T()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (T.getVcodeExtra() == null) {
                return false;
            }
            this.f62099a.runJsMethod("handleFreshCaptcha", "'" + T.getVcodeUrl() + "','" + T.getVcodeExtra().slideImg + "','" + T.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            j(d.a.i0.a1.a.a(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (T != null && T.getVideoReviewType() == 1) {
                NewVcodeView newVcodeView = this.f62099a;
                newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (T != null && T.getVideoReviewType() == 2) {
                NewVcodeView newVcodeView2 = this.f62099a;
                newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.f62099a.getContext().getResources().getString(R.string.send_success);
                PostWriteCallBackData postWriteCallBackData = this.f62102d;
                String str3 = null;
                if (postWriteCallBackData != null) {
                    str3 = postWriteCallBackData.getPreMsg();
                    str2 = this.f62102d.getColorMsg();
                    string = this.f62102d.getErrorString();
                } else {
                    str2 = null;
                }
                if (T.getType() != 7) {
                    g.b(this.f62099a.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.f62102d);
            intent.putExtras(bundle);
            BaseActivity context = this.f62099a.getContext();
            this.f62099a.getContext();
            context.setResult(-1, intent);
            this.f62099a.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.f62099a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // d.a.j0.v3.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.f62104f = gVar;
    }

    @Override // d.a.j0.v3.s.a.a.b
    public void d() {
        this.f62099a.showPostThreadLoadingView(false);
        this.f62100b.cancelLoadData();
    }

    @Override // d.a.j0.v3.s.a.a.b
    public void e(boolean z, String str) {
    }

    public final void j(String str) {
        if (!l.D()) {
            this.f62099a.getContext().showToast(R.string.neterror);
            this.f62099a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f62099a.showPostThreadLoadingView(true);
            this.f62100b.T().setVcode(str);
            this.f62100b.T().setVcodeType("5");
            this.f62100b.i0();
        } else {
            this.f62099a.getContext().showToast(R.string.neterror);
            this.f62099a.getContext().finish();
        }
    }

    @Override // d.a.j0.v3.s.a.a.b
    public void onDestroy() {
    }

    @Override // d.a.j0.v3.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f62099a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(1000);
        }
    }
}
