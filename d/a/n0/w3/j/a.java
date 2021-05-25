package d.a.n0.w3.j;

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
import d.a.c.e.p.l;
import d.a.m0.s.c.i0;
import d.a.n0.e3.q0.g;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f62780a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f62781b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62782c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f62783d;

    /* renamed from: d.a.n0.w3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1711a implements NewWriteModel.g {
        public C1711a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            if (a.this.f62780a == null || a.this.f62781b == null || a.this.f62781b.T() == null) {
                return;
            }
            a.this.f62780a.p(false);
            if (writeData == null) {
                writeData = a.this.f62781b.T();
            }
            WriteData writeData2 = writeData;
            if (z) {
                a.this.f62782c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        g.b(a.this.f62780a.g().getActivity(), a.this.f62780a.g().getResources().getString(R.string.send_success), null, null);
                    } else {
                        g.b(a.this.f62780a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity g2 = a.this.f62780a.g();
                a.this.f62780a.g();
                g2.setResult(-1, intent);
                a.this.f62780a.g().finish();
            } else if (writeData2 != null && i0Var != null && !TextUtils.isEmpty(i0Var.d())) {
                writeData2.setVcodeMD5(i0Var.b());
                writeData2.setVcodeUrl(i0Var.c());
                writeData2.setVcodeExtra(i0Var.a());
                a.this.f62780a.g().setVisible(false);
                if (d.a.m0.a1.a.b(i0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f62780a.g().getActivity(), 12006, writeData2, false, i0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f62780a.g().getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    g.b(a.this.f62780a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity g3 = a.this.f62780a.g();
                    a.this.f62780a.g();
                    g3.setResult(0, null);
                }
                a.this.f62780a.g().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g4 = a.this.f62780a.g();
                a.this.f62780a.g();
                g4.setResult(0, intent2);
                a.this.f62780a.g().finish();
            }
        }
    }

    public a(b bVar, NewWriteModel newWriteModel) {
        C1711a c1711a = new C1711a();
        this.f62783d = c1711a;
        this.f62780a = bVar;
        this.f62781b = newWriteModel;
        newWriteModel.d0(c1711a);
    }

    public void d() {
        b bVar = this.f62780a;
        if (bVar != null) {
            bVar.s(500);
        }
    }

    public void e() {
        b bVar = this.f62780a;
        if (bVar != null) {
            bVar.p(false);
        }
    }

    public boolean f(String str) {
        if (this.f62780a == null || str == null) {
            return false;
        }
        if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
            this.f62780a.g().finish();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
            this.f62780a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.f62780a.h() != this.f62780a.i()) {
                b bVar = this.f62780a;
                bVar.n(bVar.h());
                this.f62780a.t();
            }
            this.f62780a.j().setVisibility(0);
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
            g();
            return true;
        } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
            this.f62780a.g().finish();
            UrlManager.getInstance().dealOneLink(this.f62780a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public final void g() {
        if (this.f62780a == null || this.f62781b == null) {
            return;
        }
        if (!l.D()) {
            this.f62780a.g().showToast(R.string.neterror);
            this.f62780a.g().finish();
            return;
        }
        this.f62780a.p(true);
        this.f62781b.i0();
    }

    public void h(String str) {
        b bVar = this.f62780a;
        if (bVar != null) {
            bVar.q(true);
            this.f62780a.r(false);
            this.f62780a.j().loadUrl(str);
        }
    }
}
