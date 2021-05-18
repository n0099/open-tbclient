package d.a.k0.n.c;

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
    public final BaseActivity f57576e;

    /* renamed from: f  reason: collision with root package name */
    public b f57577f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f57578g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f57579h;

    /* renamed from: d.a.k0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1431a extends d.a.c.c.g.a {
        public C1431a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f57578g != null) {
                a.this.f57578g.A(false);
            }
            a.this.f57576e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.a.k0.v2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f57578g != null) {
                    a.this.f57578g.z(privacyData);
                }
                if (a.this.f57577f == null || a.this.f57578g == null || a.this.f57578g.t() == null) {
                    return;
                }
                a.this.f57577f.d(a.this.f57578g.t().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f57576e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f57576e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1431a c1431a = new C1431a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f57579h = c1431a;
        this.f57576e = baseActivity;
        baseActivity.registerListener(c1431a);
        this.f57577f = new b(this.f57576e, this);
        this.f57578g = new AccountSafeModel(this.f57576e);
        if (j.z()) {
            g();
        } else {
            this.f57576e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f57577f.a();
    }

    public void e(int i2) {
        b bVar = this.f57577f;
        if (bVar != null) {
            bVar.e(i2);
        }
    }

    public void f() {
        this.f57576e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f57578g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f57577f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void g() {
        AccountSafeModel accountSafeModel = this.f57578g;
        if (accountSafeModel == null || accountSafeModel.w()) {
            return;
        }
        this.f57578g.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f57576e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f57576e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f57578g;
            AntiHelper.p(this.f57576e, accountSafeModel != null ? accountSafeModel.u() : "");
        }
    }
}
