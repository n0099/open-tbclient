package d.b.i0.n.c;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.account.safeManage.AccountSafeModel;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.b.e.p.j;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final BaseActivity f56966e;

    /* renamed from: f  reason: collision with root package name */
    public b f56967f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f56968g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.g.a f56969h;

    /* renamed from: d.b.i0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1350a extends d.b.b.c.g.a {
        public C1350a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f56968g != null) {
                a.this.f56968g.A(false);
            }
            a.this.f56966e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.b.i0.u2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f56968g != null) {
                    a.this.f56968g.z(privacyData);
                }
                if (a.this.f56967f == null || a.this.f56968g == null || a.this.f56968g.t() == null) {
                    return;
                }
                a.this.f56967f.d(a.this.f56968g.t().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f56966e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f56966e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1350a c1350a = new C1350a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f56969h = c1350a;
        this.f56966e = baseActivity;
        baseActivity.registerListener(c1350a);
        this.f56967f = new b(this.f56966e, this);
        this.f56968g = new AccountSafeModel(this.f56966e);
        if (j.z()) {
            h();
        } else {
            this.f56966e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f56967f.a();
    }

    public void e(int i) {
        b bVar = this.f56967f;
        if (bVar != null) {
            bVar.e(i);
        }
    }

    public void f() {
        this.f56966e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f56968g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f56967f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void h() {
        AccountSafeModel accountSafeModel = this.f56968g;
        if (accountSafeModel == null || accountSafeModel.w()) {
            return;
        }
        this.f56968g.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f56966e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f56966e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f56968g;
            AntiHelper.p(this.f56966e, accountSafeModel != null ? accountSafeModel.u() : "");
        }
    }
}
