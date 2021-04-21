package d.b.j0.v3.t.a.a;

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
import d.b.c.e.m.e;
import d.b.c.e.p.l;
import d.b.i0.s.c.h0;
import d.b.j0.d3.q0.g;
/* loaded from: classes5.dex */
public class c implements d.b.j0.v3.t.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f63867a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f63868b;

    /* renamed from: c  reason: collision with root package name */
    public String f63869c;

    /* renamed from: d  reason: collision with root package name */
    public String f63870d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63873g;
    public final NewWriteModel.g i;
    public NewWriteModel.g j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63871e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f63872f = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f63874h = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f63867a == null) {
                return;
            }
            if (StringUtils.isNull(c.this.f63872f)) {
                c.this.f63867a.showToast(false, c.this.f63867a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                c.this.f63867a.showToast(false, c.this.f63872f);
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
            if (c.this.f63867a == null) {
                return;
            }
            c.this.f63867a.showPostThreadLoadingView(false);
            if (z) {
                c.this.f63873g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    c.this.f63867a.showToast(true, c.this.f63867a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    c.this.f63867a.showToast(true, c.this.f63867a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = c.this.f63867a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        g.b(c.this.f63867a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = c.this.f63867a.getContext();
                c.this.f63867a.getContext();
                context.setResult(-1, intent);
                c.this.f63867a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                c.this.f63867a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.f63867a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.j != null) {
                if (c.this.j != null) {
                    c.this.j.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    c.this.f63867a.showToast(false, c.this.f63867a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    c.this.f63867a.showToast(false, postWriteCallBackData.getErrorString());
                }
                c.this.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        b bVar = new b();
        this.i = bVar;
        this.f63867a = newVcodeView;
        this.f63868b = newWriteModel;
        newWriteModel.d0(bVar);
    }

    @Override // d.b.j0.v3.t.a.a.b
    public void a(boolean z) {
        this.f63867a.setRatio(1.2631578f);
        this.f63867a.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.f63867a.getWebView().loadUrl(str);
    }

    @Override // d.b.j0.v3.t.a.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            String a2 = d.b.i0.a1.a.a(str);
            this.f63869c = a2;
            if (a2 == null || this.f63868b.T() == null) {
                return false;
            }
            NewVcodeView newVcodeView = this.f63867a;
            String str2 = this.f63869c;
            newVcodeView.runJsMethod(str2, "'" + this.f63868b.T().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.f63867a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return k(d.b.i0.a1.a.a(str));
        } else {
            return false;
        }
    }

    @Override // d.b.j0.v3.t.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.j = gVar;
    }

    @Override // d.b.j0.v3.t.a.a.b
    public void d() {
        this.f63867a.showPostThreadLoadingView(false);
        this.f63868b.cancelLoadData();
    }

    @Override // d.b.j0.v3.t.a.a.b
    public void e(boolean z, String str) {
        this.f63871e = z;
        this.f63872f = str;
    }

    public final boolean k(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.f63870d = split[0];
        l(split[1]);
        return true;
    }

    public final void l(String str) {
        if (!l.C()) {
            this.f63867a.getContext().showToast(R.string.neterror);
            this.f63867a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f63867a.showPostThreadLoadingView(true);
            this.f63868b.T().setVcode(str);
            this.f63868b.T().setVcodeType("4");
            this.f63868b.i0();
        } else {
            this.f63867a.getContext().showToast(R.string.neterror);
            this.f63867a.getContext().finish();
        }
    }

    public final void m() {
        NewVcodeView newVcodeView = this.f63867a;
        String str = this.f63870d;
        newVcodeView.runJsMethod(str, "'" + this.f63868b.T().getVcodeUrl() + "'");
    }

    @Override // d.b.j0.v3.t.a.a.b
    public void onDestroy() {
        e.a().removeCallbacks(this.f63874h);
    }

    @Override // d.b.j0.v3.t.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f63867a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(500);
            if (this.f63871e) {
                e.a().postDelayed(this.f63874h, 500L);
            }
        }
    }
}
