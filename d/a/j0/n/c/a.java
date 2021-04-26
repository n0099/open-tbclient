package d.a.j0.n.c;

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
import d.a.c.e.p.j;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final BaseActivity f56869e;

    /* renamed from: f  reason: collision with root package name */
    public b f56870f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f56871g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f56872h;

    /* renamed from: d.a.j0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1359a extends d.a.c.c.g.a {
        public C1359a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f56871g != null) {
                a.this.f56871g.A(false);
            }
            a.this.f56869e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.a.j0.v2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f56871g != null) {
                    a.this.f56871g.z(privacyData);
                }
                if (a.this.f56870f == null || a.this.f56871g == null || a.this.f56871g.t() == null) {
                    return;
                }
                a.this.f56870f.d(a.this.f56871g.t().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f56869e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f56869e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1359a c1359a = new C1359a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f56872h = c1359a;
        this.f56869e = baseActivity;
        baseActivity.registerListener(c1359a);
        this.f56870f = new b(this.f56869e, this);
        this.f56871g = new AccountSafeModel(this.f56869e);
        if (j.z()) {
            g();
        } else {
            this.f56869e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f56870f.a();
    }

    public void e(int i2) {
        b bVar = this.f56870f;
        if (bVar != null) {
            bVar.e(i2);
        }
    }

    public void f() {
        this.f56869e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f56871g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f56870f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void g() {
        AccountSafeModel accountSafeModel = this.f56871g;
        if (accountSafeModel == null || accountSafeModel.w()) {
            return;
        }
        this.f56871g.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f56869e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f56869e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f56871g;
            AntiHelper.p(this.f56869e, accountSafeModel != null ? accountSafeModel.u() : "");
        }
    }
}
