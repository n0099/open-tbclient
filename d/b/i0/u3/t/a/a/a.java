package d.b.i0.u3.t.a.a;

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
import d.b.b.e.p.l;
import d.b.h0.s.c.f0;
import d.b.i0.c3.q0.g;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f61700a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f61701b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61702c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f61703d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f61704e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f61705f;

    /* renamed from: d.b.i0.u3.t.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1619a implements NewWriteModel.g {
        public C1619a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (a.this.f61700a == null) {
                return;
            }
            a.this.f61700a.showPostThreadLoadingView(false);
            if (z) {
                a.this.f61703d = postWriteCallBackData;
                a.this.f61702c = true;
                String str3 = null;
                if (f0Var == null || f0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = f0Var.a().endPoint;
                    String str5 = f0Var.a().successImg;
                    str2 = f0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                a.this.f61700a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (a.this.f61705f != null) {
                    a.this.f61705f.callback(false, postWriteCallBackData, f0Var, writeData, antiData);
                }
            } else {
                a.this.f61700a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f61700a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        C1619a c1619a = new C1619a();
        this.f61704e = c1619a;
        this.f61700a = newVcodeView;
        this.f61701b = newWriteModel;
        newWriteModel.d0(c1619a);
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void a(boolean z) {
        this.f61700a.setRatio(0.9433962f);
        this.f61700a.showWebView(false);
        this.f61700a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // d.b.i0.u3.t.a.a.b
    public boolean b(WebView webView, String str) {
        WriteData T;
        String str2;
        if (this.f61701b.T() == null || StringUtils.isNull(str) || (T = this.f61701b.T()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (T.getVcodeExtra() == null) {
                return false;
            }
            this.f61700a.runJsMethod("handleFreshCaptcha", "'" + T.getVcodeUrl() + "','" + T.getVcodeExtra().slideImg + "','" + T.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            j(d.b.h0.a1.a.a(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (T != null && T.getVideoReviewType() == 1) {
                NewVcodeView newVcodeView = this.f61700a;
                newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (T != null && T.getVideoReviewType() == 2) {
                NewVcodeView newVcodeView2 = this.f61700a;
                newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.f61700a.getContext().getResources().getString(R.string.send_success);
                PostWriteCallBackData postWriteCallBackData = this.f61703d;
                String str3 = null;
                if (postWriteCallBackData != null) {
                    str3 = postWriteCallBackData.getPreMsg();
                    str2 = this.f61703d.getColorMsg();
                    string = this.f61703d.getErrorString();
                } else {
                    str2 = null;
                }
                if (T.getType() != 7) {
                    g.b(this.f61700a.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.f61703d);
            intent.putExtras(bundle);
            BaseActivity context = this.f61700a.getContext();
            this.f61700a.getContext();
            context.setResult(-1, intent);
            this.f61700a.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.f61700a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.f61705f = gVar;
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void d() {
        this.f61700a.showPostThreadLoadingView(false);
        this.f61701b.cancelLoadData();
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void e(boolean z, String str) {
    }

    public final void j(String str) {
        if (!l.C()) {
            this.f61700a.getContext().showToast(R.string.neterror);
            this.f61700a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f61700a.showPostThreadLoadingView(true);
            this.f61701b.T().setVcode(str);
            this.f61701b.T().setVcodeType("5");
            this.f61701b.i0();
        } else {
            this.f61700a.getContext().showToast(R.string.neterror);
            this.f61700a.getContext().finish();
        }
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void onDestroy() {
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f61700a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(1000);
        }
    }
}
