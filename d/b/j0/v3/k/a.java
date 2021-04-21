package d.b.j0.v3.k;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import d.b.c.e.p.l;
import d.b.i0.s.c.h0;
import d.b.j0.d3.q0.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f63718a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f63719b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63720c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f63721d;

    /* renamed from: d.b.j0.v3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1696a implements NewWriteModel.g {
        public C1696a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            if (a.this.f63718a == null || a.this.f63719b == null || a.this.f63719b.T() == null) {
                return;
            }
            a.this.f63718a.p(false);
            if (writeData == null) {
                writeData = a.this.f63719b.T();
            }
            WriteData writeData2 = writeData;
            if (z) {
                a.this.f63720c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        g.b(a.this.f63718a.g().getActivity(), a.this.f63718a.g().getResources().getString(R.string.send_success), null, null);
                    } else {
                        g.b(a.this.f63718a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity g2 = a.this.f63718a.g();
                a.this.f63718a.g();
                g2.setResult(-1, intent);
                a.this.f63718a.g().finish();
            } else if (writeData2 != null && h0Var != null && !TextUtils.isEmpty(h0Var.d())) {
                writeData2.setVcodeMD5(h0Var.b());
                writeData2.setVcodeUrl(h0Var.c());
                writeData2.setVcodeExtra(h0Var.a());
                a.this.f63718a.g().setVisible(false);
                if (d.b.i0.a1.a.b(h0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f63718a.g().getActivity(), 12006, writeData2, false, h0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f63718a.g().getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    g.b(a.this.f63718a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity g3 = a.this.f63718a.g();
                    a.this.f63718a.g();
                    g3.setResult(0, null);
                }
                a.this.f63718a.g().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g4 = a.this.f63718a.g();
                a.this.f63718a.g();
                g4.setResult(0, intent2);
                a.this.f63718a.g().finish();
            }
        }
    }

    public a(b bVar, NewWriteModel newWriteModel) {
        C1696a c1696a = new C1696a();
        this.f63721d = c1696a;
        this.f63718a = bVar;
        this.f63719b = newWriteModel;
        newWriteModel.d0(c1696a);
    }

    public void d() {
        b bVar = this.f63718a;
        if (bVar != null) {
            bVar.s(500);
        }
    }

    public void e() {
        b bVar = this.f63718a;
        if (bVar != null) {
            bVar.p(false);
        }
    }

    public boolean f(String str) {
        if (this.f63718a == null || str == null) {
            return false;
        }
        if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
            this.f63718a.g().finish();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
            this.f63718a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.f63718a.h() != this.f63718a.i()) {
                b bVar = this.f63718a;
                bVar.n(bVar.h());
                this.f63718a.t();
            }
            this.f63718a.j().setVisibility(0);
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
            g();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
            this.f63718a.g().finish();
            UrlManager.getInstance().dealOneLink(this.f63718a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public final void g() {
        if (this.f63718a == null || this.f63719b == null) {
            return;
        }
        if (!l.C()) {
            this.f63718a.g().showToast(R.string.neterror);
            this.f63718a.g().finish();
            return;
        }
        this.f63718a.p(true);
        this.f63719b.i0();
    }

    public void h(String str) {
        b bVar = this.f63718a;
        if (bVar != null) {
            bVar.q(true);
            this.f63718a.r(false);
            this.f63718a.j().loadUrl(str);
        }
    }
}
