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
    public final BaseActivity f61617e;

    /* renamed from: f  reason: collision with root package name */
    public b f61618f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f61619g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f61620h;

    /* renamed from: d.a.n0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1515a extends d.a.c.c.g.a {
        public C1515a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.f61619g != null) {
                a.this.f61619g.E(false);
            }
            a.this.f61617e.closeLoadingDialog();
            if (responsedMessage == null) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.a.n0.w2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.f61619g != null) {
                    a.this.f61619g.D(privacyData);
                }
                if (a.this.f61618f == null || a.this.f61619g == null || a.this.f61619g.x() == null) {
                    return;
                }
                a.this.f61618f.d(a.this.f61619g.x().f());
                return;
            }
            if (StringUtils.isNull(responsedMessage.getErrorString())) {
                errorString = a.this.f61617e.getString(R.string.neterror);
            } else {
                errorString = responsedMessage.getErrorString();
            }
            a.this.f61617e.showToast(errorString);
        }
    }

    public a(BaseActivity baseActivity) {
        C1515a c1515a = new C1515a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f61620h = c1515a;
        this.f61617e = baseActivity;
        baseActivity.registerListener(c1515a);
        this.f61618f = new b(this.f61617e, this);
        this.f61619g = new AccountSafeModel(this.f61617e);
        if (j.z()) {
            h();
        } else {
            this.f61617e.showToast(R.string.neterror);
        }
    }

    public View d() {
        return this.f61618f.a();
    }

    public void e(int i2) {
        b bVar = this.f61618f;
        if (bVar != null) {
            bVar.e(i2);
        }
    }

    public void f() {
        this.f61617e.closeLoadingDialog();
        AccountSafeModel accountSafeModel = this.f61619g;
        if (accountSafeModel != null) {
            accountSafeModel.cancelLoadData();
        }
        b bVar = this.f61618f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void h() {
        AccountSafeModel accountSafeModel = this.f61619g;
        if (accountSafeModel == null || accountSafeModel.A()) {
            return;
        }
        this.f61619g.C();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.z()) {
                this.f61617e.showToast(R.string.neterror);
            } else {
                UrlManager.getInstance().dealOneLink(this.f61617e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AccountSafeModel accountSafeModel = this.f61619g;
            AntiHelper.p(this.f61617e, accountSafeModel != null ? accountSafeModel.y() : "");
        }
    }
}
