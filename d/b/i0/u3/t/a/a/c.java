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
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.h0.s.c.f0;
import d.b.i0.c3.q0.g;
/* loaded from: classes5.dex */
public class c implements d.b.i0.u3.t.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f61708a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f61709b;

    /* renamed from: c  reason: collision with root package name */
    public String f61710c;

    /* renamed from: d  reason: collision with root package name */
    public String f61711d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61714g;
    public final NewWriteModel.g i;
    public NewWriteModel.g j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61712e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f61713f = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f61715h = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f61708a == null) {
                return;
            }
            if (StringUtils.isNull(c.this.f61713f)) {
                c.this.f61708a.showToast(false, c.this.f61708a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                c.this.f61708a.showToast(false, c.this.f61713f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            String str;
            if (c.this.f61708a == null) {
                return;
            }
            c.this.f61708a.showPostThreadLoadingView(false);
            if (z) {
                c.this.f61714g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    c.this.f61708a.showToast(true, c.this.f61708a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    c.this.f61708a.showToast(true, c.this.f61708a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = c.this.f61708a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        g.b(c.this.f61708a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = c.this.f61708a.getContext();
                c.this.f61708a.getContext();
                context.setResult(-1, intent);
                c.this.f61708a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                c.this.f61708a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.f61708a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.j != null) {
                if (c.this.j != null) {
                    c.this.j.callback(z, postWriteCallBackData, f0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    c.this.f61708a.showToast(false, c.this.f61708a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    c.this.f61708a.showToast(false, postWriteCallBackData.getErrorString());
                }
                c.this.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        b bVar = new b();
        this.i = bVar;
        this.f61708a = newVcodeView;
        this.f61709b = newWriteModel;
        newWriteModel.d0(bVar);
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void a(boolean z) {
        this.f61708a.setRatio(1.2631578f);
        this.f61708a.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.f61708a.getWebView().loadUrl(str);
    }

    @Override // d.b.i0.u3.t.a.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            String a2 = d.b.h0.a1.a.a(str);
            this.f61710c = a2;
            if (a2 == null || this.f61709b.T() == null) {
                return false;
            }
            NewVcodeView newVcodeView = this.f61708a;
            String str2 = this.f61710c;
            newVcodeView.runJsMethod(str2, "'" + this.f61709b.T().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.f61708a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return k(d.b.h0.a1.a.a(str));
        } else {
            return false;
        }
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.j = gVar;
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void d() {
        this.f61708a.showPostThreadLoadingView(false);
        this.f61709b.cancelLoadData();
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void e(boolean z, String str) {
        this.f61712e = z;
        this.f61713f = str;
    }

    public final boolean k(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.f61711d = split[0];
        l(split[1]);
        return true;
    }

    public final void l(String str) {
        if (!l.C()) {
            this.f61708a.getContext().showToast(R.string.neterror);
            this.f61708a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f61708a.showPostThreadLoadingView(true);
            this.f61709b.T().setVcode(str);
            this.f61709b.T().setVcodeType("4");
            this.f61709b.i0();
        } else {
            this.f61708a.getContext().showToast(R.string.neterror);
            this.f61708a.getContext().finish();
        }
    }

    public final void m() {
        NewVcodeView newVcodeView = this.f61708a;
        String str = this.f61711d;
        newVcodeView.runJsMethod(str, "'" + this.f61709b.T().getVcodeUrl() + "'");
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void onDestroy() {
        e.a().removeCallbacks(this.f61715h);
    }

    @Override // d.b.i0.u3.t.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f61708a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(500);
            if (this.f61712e) {
                e.a().postDelayed(this.f61715h, 500L);
            }
        }
    }
}
