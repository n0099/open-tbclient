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
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final BaseActivity f58433e;

    /* renamed from: f  reason: collision with root package name */
    public b f58434f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f58435g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f58436h;

    /* renamed from: d.b.i0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1397a extends d.b.c.c.g.a {
        public C1397a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f58435g != null) {
                a.this.f58435g.A(false);
            }
            a.this.f58433e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.b.i0.v2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f58435g != null) {
                    a.this.f58435g.z(privacyData);
                }
                if (a.this.f58434f == null || a.this.f58435g == null || a.this.f58435g.t() == null) {
                    return;
                }
                a.this.f58434f.d(a.this.f58435g.t().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f58433e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f58433e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1397a c1397a = new C1397a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f58436h = c1397a;
        this.f58433e = baseActivity;
        baseActivity.registerListener(c1397a);
        this.f58434f = new b(this.f58433e, this);
        this.f58435g = new AccountSafeModel(this.f58433e);
        if (j.z()) {
            h();
        } else {
            this.f58433e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f58434f.a();
    }

    public void e(int i) {
        b bVar = this.f58434f;
        if (bVar != null) {
            bVar.e(i);
        }
    }

    public void f() {
        this.f58433e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f58435g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f58434f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void h() {
        AccountSafeModel accountSafeModel = this.f58435g;
        if (accountSafeModel == null || accountSafeModel.w()) {
            return;
        }
        this.f58435g.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f58433e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f58433e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f58435g;
            AntiHelper.p(this.f58433e, accountSafeModel != null ? accountSafeModel.u() : "");
        }
    }
}
