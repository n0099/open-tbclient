package d.a.k0.b2.b;

import android.content.Intent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import d.a.c.e.m.h;
import d.a.j0.r.l.a;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52190a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f52191b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.b2.b.b f52192c;

    /* renamed from: d  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f52193d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.b2.b.c f52194e;

    /* renamed from: f  reason: collision with root package name */
    public String f52195f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f52196g = new View$OnClickListenerC1214a();

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC1132a f52197h = new c();

    /* renamed from: d.a.k0.b2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1214a implements View.OnClickListener {
        public View$OnClickListenerC1214a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n(view);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WebAuthListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f52199e;

        public b(SocialType socialType) {
            this.f52199e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            a.this.l();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            a.this.f52191b.closeLoadingDialog();
            BaseActivity baseActivity = a.this.f52191b;
            baseActivity.showToast(String.format(baseActivity.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            a.this.f();
            DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), a.this.f52195f, this.f52199e.name().toLowerCase());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC1132a {
        public c() {
        }

        @Override // d.a.j0.r.l.a.InterfaceC1132a
        public void a(String str, int i2, String str2) {
            a.this.f52191b.closeLoadingDialog();
            a.this.f52191b.showToast(str2);
        }

        @Override // d.a.j0.r.l.a.InterfaceC1132a
        public void b(String str) {
            a.this.l();
        }

        @Override // d.a.j0.r.l.a.InterfaceC1132a
        public void c(AccountData accountData) {
            a.this.f52191b.closeLoadingDialog();
            a.this.e(accountData);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f52202e;

        public d(a aVar, AccountData accountData) {
            this.f52202e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.r.l.c.g(this.f52202e);
            d.a.j0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
        }
    }

    public a(TbPageContext tbPageContext, d.a.k0.b2.b.b bVar, String str) {
        this.f52190a = tbPageContext;
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            this.f52191b = (BaseActivity) tbPageContext.getPageActivity();
        }
        this.f52192c = bVar;
        this.f52195f = str;
        bVar.d(this.f52196g);
    }

    public void c(int i2) {
        this.f52191b.setResult(i2, new Intent());
        this.f52191b.finish();
    }

    public final void d() {
        new LoginActivityConfig(this.f52191b, true, 25061).start();
    }

    public final void e(AccountData accountData) {
        h(accountData);
        d.a.j0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(this.f52191b.getIntent());
        c(-1);
    }

    public void f() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.f52193d;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.f52193d = d.a.j0.r.l.a.b().a(session.username, session.bduss, "", null, this.f52197h);
            return;
        }
        this.f52191b.closeLoadingDialog();
        c(0);
    }

    public final void g() {
        m(SocialType.QQ_SSO);
    }

    public final void h(AccountData accountData) {
        h.a().c(new d(this, accountData));
        d.a.j0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, this.f52190a.getPageActivity());
        d.a.j0.l.a.f(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
    }

    public void i(boolean z) {
        this.f52192c.b(z);
    }

    public abstract void j(d.a.k0.b2.b.c cVar);

    public void k(boolean z) {
        this.f52192c.e(z);
    }

    public void l() {
        if (this.f52191b.getLoadingDialog() == null || !this.f52191b.getLoadingDialog().c()) {
            this.f52191b.showLoadingDialog(this.f52190a.getString(R.string.sapi_logining));
            if (this.f52191b.getLoadingDialog() != null) {
                this.f52191b.getLoadingDialog().f(false);
                this.f52191b.getLoadingDialog().g(false);
            }
        }
    }

    public final void m(SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new b(socialType), socialType);
    }

    public void n(View view) {
        if (view.getId() == R.id.btn_close) {
            this.f52191b.finish();
        } else if (view.getId() == R.id.btn_skip) {
            this.f52191b.finish();
        } else if (view.getId() == R.id.qq_login_btn) {
            g();
        } else if (view.getId() == R.id.wechat_login_btn) {
            o();
        } else if (view.getId() == R.id.weibo_login_btn) {
            p();
        } else if (view.getId() == R.id.yy_login_btn) {
            q();
        } else if (view.getId() == R.id.more_login_btn) {
            d();
        }
    }

    public final void o() {
        m(SocialType.WEIXIN);
    }

    public final void p() {
        m(SocialType.SINA_WEIBO_SSO);
    }

    public final void q() {
        m(SocialType.YY);
    }
}
