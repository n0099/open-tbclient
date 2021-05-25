package d.a.n0.w3.s.a.a;

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
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.m0.s.c.i0;
import d.a.n0.e3.q0.g;
/* loaded from: classes5.dex */
public class c implements d.a.n0.w3.s.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f62939a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f62940b;

    /* renamed from: c  reason: collision with root package name */
    public String f62941c;

    /* renamed from: d  reason: collision with root package name */
    public String f62942d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62945g;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f62947i;
    public NewWriteModel.g j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62943e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f62944f = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f62946h = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f62939a == null) {
                return;
            }
            if (StringUtils.isNull(c.this.f62944f)) {
                c.this.f62939a.showToast(false, c.this.f62939a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                c.this.f62939a.showToast(false, c.this.f62944f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            if (c.this.f62939a == null) {
                return;
            }
            c.this.f62939a.showPostThreadLoadingView(false);
            if (z) {
                c.this.f62945g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    c.this.f62939a.showToast(true, c.this.f62939a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    c.this.f62939a.showToast(true, c.this.f62939a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = c.this.f62939a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        g.b(c.this.f62939a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = c.this.f62939a.getContext();
                c.this.f62939a.getContext();
                context.setResult(-1, intent);
                c.this.f62939a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                c.this.f62939a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.f62939a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.j != null) {
                if (c.this.j != null) {
                    c.this.j.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    c.this.f62939a.showToast(false, c.this.f62939a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    c.this.f62939a.showToast(false, postWriteCallBackData.getErrorString());
                }
                c.this.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        b bVar = new b();
        this.f62947i = bVar;
        this.f62939a = newVcodeView;
        this.f62940b = newWriteModel;
        newWriteModel.d0(bVar);
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void a(boolean z) {
        this.f62939a.setRatio(1.2631578f);
        this.f62939a.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.f62939a.getWebView().loadUrl(str);
    }

    @Override // d.a.n0.w3.s.a.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            String a2 = d.a.m0.a1.a.a(str);
            this.f62941c = a2;
            if (a2 == null || this.f62940b.T() == null) {
                return false;
            }
            NewVcodeView newVcodeView = this.f62939a;
            String str2 = this.f62941c;
            newVcodeView.runJsMethod(str2, "'" + this.f62940b.T().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.f62939a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return k(d.a.m0.a1.a.a(str));
        } else {
            return false;
        }
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.j = gVar;
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void d() {
        this.f62939a.showPostThreadLoadingView(false);
        this.f62940b.cancelLoadData();
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void e(boolean z, String str) {
        this.f62943e = z;
        this.f62944f = str;
    }

    public final boolean k(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.f62942d = split[0];
        l(split[1]);
        return true;
    }

    public final void l(String str) {
        if (!l.D()) {
            this.f62939a.getContext().showToast(R.string.neterror);
            this.f62939a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f62939a.showPostThreadLoadingView(true);
            this.f62940b.T().setVcode(str);
            this.f62940b.T().setVcodeType("4");
            this.f62940b.i0();
        } else {
            this.f62939a.getContext().showToast(R.string.neterror);
            this.f62939a.getContext().finish();
        }
    }

    public final void m() {
        NewVcodeView newVcodeView = this.f62939a;
        String str = this.f62942d;
        newVcodeView.runJsMethod(str, "'" + this.f62940b.T().getVcodeUrl() + "'");
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void onDestroy() {
        e.a().removeCallbacks(this.f62946h);
    }

    @Override // d.a.n0.w3.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f62939a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(500);
            if (this.f62943e) {
                e.a().postDelayed(this.f62946h, 500L);
            }
        }
    }
}
