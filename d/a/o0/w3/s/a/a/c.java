package d.a.o0.w3.s.a.a;

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
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.n0.s.c.i0;
import d.a.o0.e3.q0.g;
/* loaded from: classes5.dex */
public class c implements d.a.o0.w3.s.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f66779a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f66780b;

    /* renamed from: c  reason: collision with root package name */
    public String f66781c;

    /* renamed from: d  reason: collision with root package name */
    public String f66782d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66785g;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f66787i;
    public NewWriteModel.g j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66783e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f66784f = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f66786h = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f66779a == null) {
                return;
            }
            if (StringUtils.isNull(c.this.f66784f)) {
                c.this.f66779a.showToast(false, c.this.f66779a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                c.this.f66779a.showToast(false, c.this.f66784f);
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
            if (c.this.f66779a == null) {
                return;
            }
            c.this.f66779a.showPostThreadLoadingView(false);
            if (z) {
                c.this.f66785g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    c.this.f66779a.showToast(true, c.this.f66779a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    c.this.f66779a.showToast(true, c.this.f66779a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = c.this.f66779a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        g.b(c.this.f66779a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = c.this.f66779a.getContext();
                c.this.f66779a.getContext();
                context.setResult(-1, intent);
                c.this.f66779a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                c.this.f66779a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.f66779a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.j != null) {
                if (c.this.j != null) {
                    c.this.j.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    c.this.f66779a.showToast(false, c.this.f66779a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    c.this.f66779a.showToast(false, postWriteCallBackData.getErrorString());
                }
                c.this.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        b bVar = new b();
        this.f66787i = bVar;
        this.f66779a = newVcodeView;
        this.f66780b = newWriteModel;
        newWriteModel.h0(bVar);
    }

    @Override // d.a.o0.w3.s.a.a.b
    public void a(boolean z) {
        this.f66779a.setRatio(1.2631578f);
        this.f66779a.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.f66779a.getWebView().loadUrl(str);
    }

    @Override // d.a.o0.w3.s.a.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            String a2 = d.a.n0.a1.a.a(str);
            this.f66781c = a2;
            if (a2 == null || this.f66780b.X() == null) {
                return false;
            }
            NewVcodeView newVcodeView = this.f66779a;
            String str2 = this.f66781c;
            newVcodeView.runJsMethod(str2, "'" + this.f66780b.X().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.f66779a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return k(d.a.n0.a1.a.a(str));
        } else {
            return false;
        }
    }

    @Override // d.a.o0.w3.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        this.j = gVar;
    }

    @Override // d.a.o0.w3.s.a.a.b
    public void d() {
        this.f66779a.showPostThreadLoadingView(false);
        this.f66780b.cancelLoadData();
    }

    @Override // d.a.o0.w3.s.a.a.b
    public void e(boolean z, String str) {
        this.f66783e = z;
        this.f66784f = str;
    }

    public final boolean k(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.f66782d = split[0];
        l(split[1]);
        return true;
    }

    public final void l(String str) {
        if (!l.D()) {
            this.f66779a.getContext().showToast(R.string.neterror);
            this.f66779a.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.f66779a.showPostThreadLoadingView(true);
            this.f66780b.X().setVcode(str);
            this.f66780b.X().setVcodeType("4");
            this.f66780b.m0();
        } else {
            this.f66779a.getContext().showToast(R.string.neterror);
            this.f66779a.getContext().finish();
        }
    }

    public final void m() {
        NewVcodeView newVcodeView = this.f66779a;
        String str = this.f66782d;
        newVcodeView.runJsMethod(str, "'" + this.f66780b.X().getVcodeUrl() + "'");
    }

    @Override // d.a.o0.w3.s.a.a.b
    public void onDestroy() {
        e.a().removeCallbacks(this.f66786h);
    }

    @Override // d.a.o0.w3.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView = this.f66779a;
        if (newVcodeView != null) {
            newVcodeView.showWebViewDelay(500);
            if (this.f66783e) {
                e.a().postDelayed(this.f66786h, 500L);
            }
        }
    }
}
