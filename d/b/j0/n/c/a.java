package d.b.j0.n.c;

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
    public final BaseActivity f58854e;

    /* renamed from: f  reason: collision with root package name */
    public b f58855f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f58856g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f58857h;

    /* renamed from: d.b.j0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1420a extends d.b.c.c.g.a {
        public C1420a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f58856g != null) {
                a.this.f58856g.A(false);
            }
            a.this.f58854e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.b.j0.v2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f58856g != null) {
                    a.this.f58856g.z(privacyData);
                }
                if (a.this.f58855f == null || a.this.f58856g == null || a.this.f58856g.t() == null) {
                    return;
                }
                a.this.f58855f.d(a.this.f58856g.t().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f58854e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f58854e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1420a c1420a = new C1420a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f58857h = c1420a;
        this.f58854e = baseActivity;
        baseActivity.registerListener(c1420a);
        this.f58855f = new b(this.f58854e, this);
        this.f58856g = new AccountSafeModel(this.f58854e);
        if (j.z()) {
            h();
        } else {
            this.f58854e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f58855f.a();
    }

    public void e(int i) {
        b bVar = this.f58855f;
        if (bVar != null) {
            bVar.e(i);
        }
    }

    public void f() {
        this.f58854e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f58856g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f58855f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void h() {
        AccountSafeModel accountSafeModel = this.f58856g;
        if (accountSafeModel == null || accountSafeModel.w()) {
            return;
        }
        this.f58856g.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f58854e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f58854e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f58856g;
            AntiHelper.p(this.f58854e, accountSafeModel != null ? accountSafeModel.u() : "");
        }
    }
}
