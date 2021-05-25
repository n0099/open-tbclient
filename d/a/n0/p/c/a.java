package d.a.n0.p.c;

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
    public final BaseActivity f57926e;

    /* renamed from: f  reason: collision with root package name */
    public b f57927f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f57928g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f57929h;

    /* renamed from: d.a.n0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1459a extends d.a.c.c.g.a {
        public C1459a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f57928g != null) {
                a.this.f57928g.A(false);
            }
            a.this.f57926e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.a.n0.w2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f57928g != null) {
                    a.this.f57928g.z(privacyData);
                }
                if (a.this.f57927f == null || a.this.f57928g == null || a.this.f57928g.t() == null) {
                    return;
                }
                a.this.f57927f.d(a.this.f57928g.t().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f57926e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f57926e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1459a c1459a = new C1459a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f57929h = c1459a;
        this.f57926e = baseActivity;
        baseActivity.registerListener(c1459a);
        this.f57927f = new b(this.f57926e, this);
        this.f57928g = new AccountSafeModel(this.f57926e);
        if (j.z()) {
            g();
        } else {
            this.f57926e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f57927f.a();
    }

    public void e(int i2) {
        b bVar = this.f57927f;
        if (bVar != null) {
            bVar.e(i2);
        }
    }

    public void f() {
        this.f57926e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f57928g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f57927f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void g() {
        AccountSafeModel accountSafeModel = this.f57928g;
        if (accountSafeModel == null || accountSafeModel.w()) {
            return;
        }
        this.f57928g.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f57926e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f57926e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f57928g;
            AntiHelper.p(this.f57926e, accountSafeModel != null ? accountSafeModel.u() : "");
        }
    }
}
