package d.b.i0.u3.k;

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
import d.b.b.e.p.l;
import d.b.h0.s.c.f0;
import d.b.i0.c3.q0.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f61558a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f61559b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61560c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f61561d;

    /* renamed from: d.b.i0.u3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1612a implements NewWriteModel.g {
        public C1612a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            if (a.this.f61558a == null || a.this.f61559b == null || a.this.f61559b.T() == null) {
                return;
            }
            a.this.f61558a.p(false);
            if (writeData == null) {
                writeData = a.this.f61559b.T();
            }
            WriteData writeData2 = writeData;
            if (z) {
                a.this.f61560c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        g.b(a.this.f61558a.g().getActivity(), a.this.f61558a.g().getResources().getString(R.string.send_success), null, null);
                    } else {
                        g.b(a.this.f61558a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity g2 = a.this.f61558a.g();
                a.this.f61558a.g();
                g2.setResult(-1, intent);
                a.this.f61558a.g().finish();
            } else if (writeData2 != null && f0Var != null && !TextUtils.isEmpty(f0Var.d())) {
                writeData2.setVcodeMD5(f0Var.b());
                writeData2.setVcodeUrl(f0Var.c());
                writeData2.setVcodeExtra(f0Var.a());
                a.this.f61558a.g().setVisible(false);
                if (d.b.h0.a1.a.b(f0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f61558a.g().getActivity(), 12006, writeData2, false, f0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f61558a.g().getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    g.b(a.this.f61558a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity g3 = a.this.f61558a.g();
                    a.this.f61558a.g();
                    g3.setResult(0, null);
                }
                a.this.f61558a.g().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g4 = a.this.f61558a.g();
                a.this.f61558a.g();
                g4.setResult(0, intent2);
                a.this.f61558a.g().finish();
            }
        }
    }

    public a(b bVar, NewWriteModel newWriteModel) {
        C1612a c1612a = new C1612a();
        this.f61561d = c1612a;
        this.f61558a = bVar;
        this.f61559b = newWriteModel;
        newWriteModel.d0(c1612a);
    }

    public void d() {
        b bVar = this.f61558a;
        if (bVar != null) {
            bVar.s(500);
        }
    }

    public void e() {
        b bVar = this.f61558a;
        if (bVar != null) {
            bVar.p(false);
        }
    }

    public boolean f(String str) {
        if (this.f61558a == null || str == null) {
            return false;
        }
        if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
            this.f61558a.g().finish();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
            this.f61558a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.f61558a.h() != this.f61558a.i()) {
                b bVar = this.f61558a;
                bVar.n(bVar.h());
                this.f61558a.t();
            }
            this.f61558a.j().setVisibility(0);
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
            g();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
            this.f61558a.g().finish();
            UrlManager.getInstance().dealOneLink(this.f61558a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public final void g() {
        if (this.f61558a == null || this.f61559b == null) {
            return;
        }
        if (!l.C()) {
            this.f61558a.g().showToast(R.string.neterror);
            this.f61558a.g().finish();
            return;
        }
        this.f61558a.p(true);
        this.f61559b.i0();
    }

    public void h(String str) {
        b bVar = this.f61558a;
        if (bVar != null) {
            bVar.q(true);
            this.f61558a.r(false);
            this.f61558a.j().loadUrl(str);
        }
    }
}
