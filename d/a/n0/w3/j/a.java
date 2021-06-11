package d.a.n0.w3.j;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import d.a.c.e.p.l;
import d.a.m0.s.c.i0;
import d.a.n0.e3.q0.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f66495a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f66496b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66497c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f66498d;

    /* renamed from: d.a.n0.w3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1768a implements NewWriteModel.g {
        public C1768a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            if (a.this.f66495a == null || a.this.f66496b == null || a.this.f66496b.X() == null) {
                return;
            }
            a.this.f66495a.p(false);
            if (writeData == null) {
                writeData = a.this.f66496b.X();
            }
            WriteData writeData2 = writeData;
            if (z) {
                a.this.f66497c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        g.b(a.this.f66495a.g().getActivity(), a.this.f66495a.g().getResources().getString(R.string.send_success), null, null);
                    } else {
                        g.b(a.this.f66495a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity g2 = a.this.f66495a.g();
                a.this.f66495a.g();
                g2.setResult(-1, intent);
                a.this.f66495a.g().finish();
            } else if (writeData2 != null && i0Var != null && !TextUtils.isEmpty(i0Var.d())) {
                writeData2.setVcodeMD5(i0Var.b());
                writeData2.setVcodeUrl(i0Var.c());
                writeData2.setVcodeExtra(i0Var.a());
                a.this.f66495a.g().setVisible(false);
                if (d.a.m0.a1.a.b(i0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f66495a.g().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, false, i0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f66495a.g().getActivity(), writeData2, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    g.b(a.this.f66495a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity g3 = a.this.f66495a.g();
                    a.this.f66495a.g();
                    g3.setResult(0, null);
                }
                a.this.f66495a.g().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g4 = a.this.f66495a.g();
                a.this.f66495a.g();
                g4.setResult(0, intent2);
                a.this.f66495a.g().finish();
            }
        }
    }

    public a(b bVar, NewWriteModel newWriteModel) {
        C1768a c1768a = new C1768a();
        this.f66498d = c1768a;
        this.f66495a = bVar;
        this.f66496b = newWriteModel;
        newWriteModel.h0(c1768a);
    }

    public void d() {
        b bVar = this.f66495a;
        if (bVar != null) {
            bVar.s(500);
        }
    }

    public void e() {
        b bVar = this.f66495a;
        if (bVar != null) {
            bVar.p(false);
        }
    }

    public boolean f(String str) {
        if (this.f66495a == null || str == null) {
            return false;
        }
        if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
            this.f66495a.g().finish();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
            this.f66495a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.f66495a.h() != this.f66495a.i()) {
                b bVar = this.f66495a;
                bVar.n(bVar.h());
                this.f66495a.t();
            }
            this.f66495a.j().setVisibility(0);
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
            g();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
            this.f66495a.g().finish();
            UrlManager.getInstance().dealOneLink(this.f66495a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public final void g() {
        if (this.f66495a == null || this.f66496b == null) {
            return;
        }
        if (!l.D()) {
            this.f66495a.g().showToast(R.string.neterror);
            this.f66495a.g().finish();
            return;
        }
        this.f66495a.p(true);
        this.f66496b.m0();
    }

    public void h(String str) {
        b bVar = this.f66495a;
        if (bVar != null) {
            bVar.q(true);
            this.f66495a.r(false);
            this.f66495a.j().loadUrl(str);
        }
    }
}
