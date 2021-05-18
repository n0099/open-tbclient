package d.a.k0.v3.s.a.a;

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
import d.a.j0.s.c.h0;
import d.a.k0.d3.q0.g;
/* loaded from: classes5.dex */
public class c implements d.a.k0.v3.s.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f62830a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f62831b;

    /* renamed from: c  reason: collision with root package name */
    public String f62832c;

    /* renamed from: d  reason: collision with root package name */
    public String f62833d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62836g;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f62838i;
    public NewWriteModel.g j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62834e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f62835f = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f62837h = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f62830a == null) {
                return;
            }
            if (StringUtils.isNull(c.this.f62835f)) {
                c.this.f62830a.showToast(false, c.this.f62830a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                c.this.f62830a.showToast(false, c.this.f62835f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            String str;
            if (c.this.f62830a == null) {
                return;
            }
            c.this.f62830a.showPostThreadLoadingView(false);
            if (z) {
                c.this.f62836g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    c.this.f62830a.showToast(true, c.this.f62830a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    c.this.f62830a.showToast(true, c.this.f62830a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = c.this.f62830a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        g.b(c.this.f62830a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = c.this.f62830a.getContext();
                c.this.f62830a.getContext();
                context.setResult(-1, intent);
                c.this.f62830a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                c.this.f62830a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.f62830a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.j != null) {
                if (c.this.j != null) {
                    c.this.j.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    c.this.f62830a.showToast(false, c.this.f62830a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    c.this.f62830a.showToast(false, postWriteCallBackData.getErrorString());
                }
                c.this.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        b bVar = new b();
        this.f62838i = bVar;
        this.f62830a = newVcodeView;
        this.f62831b = newWriteModel;
        newWriteModel.d0(bVar);
    }

    @Override // d.a.k0.v3.s.a.a.b
    public void a(boolean z) {
        this.f62830a.setRatio(1.2631578f);
        this.f62830a.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.f62830a.getWebView().loadUrl(str);
    }

    @Override // d.a.k0.v3.s.a.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            String a2 = d.a.j0.a1.a.a(str);
            this.f62832c = a2;
            if (a2 == null || this.f62831b.T() == null) {
                return false;
            }
            NewVcodeView newVcodeView = this.f62830a;
            String str2 = this.f62832c;
            newVcodeView.runJsMethod(str2, "'" + this.f62831b.T().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.f62830a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return k(d.a.j0.a1.a.a(str));
        } else {
            return false;
        }
    }

    @Override // d.a.k0.v3.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.j = gVar;
    }

    @Override // d.a.k0.v3.s.a.a.b
    public void d() {
        this.f62830a.showPostThreadLoadingView(false);
        this.f62831b.cancelLoadData();
    }

    @Override // d.a.k0.v3.s.a.a.b
    public void e(boolean z, String str) {
        this.f62834e = z;
        this.f62835f = str;
    }

    public final boolean k(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.f62833d = split[0];
        l(split[1]);
        return true;
    }

    public final void l(String str) {
        if (!l.D()) {
            this.f62830a.getContext().showToast(R.string.neterror);
            this.f62830a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f62830a.showPostThreadLoadingView(true);
            this.f62831b.T().setVcode(str);
            this.f62831b.T().setVcodeType("4");
            this.f62831b.i0();
        } else {
            this.f62830a.getContext().showToast(R.string.neterror);
            this.f62830a.getContext().finish();
        }
    }

    public final void m() {
        NewVcodeView newVcodeView = this.f62830a;
        String str = this.f62833d;
        newVcodeView.runJsMethod(str, "'" + this.f62831b.T().getVcodeUrl() + "'");
    }

    @Override // d.a.k0.v3.s.a.a.b
    public void onDestroy() {
        e.a().removeCallbacks(this.f62837h);
    }

    @Override // d.a.k0.v3.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f62830a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(500);
            if (this.f62834e) {
                e.a().postDelayed(this.f62837h, 500L);
            }
        }
    }
}
