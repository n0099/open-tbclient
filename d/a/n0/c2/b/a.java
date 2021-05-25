package d.a.n0.c2.b;

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
import d.a.m0.r.l.a;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52348a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f52349b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.c2.b.b f52350c;

    /* renamed from: d  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f52351d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.c2.b.c f52352e;

    /* renamed from: f  reason: collision with root package name */
    public String f52353f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f52354g = new View$OnClickListenerC1231a();

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC1141a f52355h = new c();

    /* renamed from: d.a.n0.c2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1231a implements View.OnClickListener {
        public View$OnClickListenerC1231a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n(view);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WebAuthListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f52357e;

        public b(SocialType socialType) {
            this.f52357e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            a.this.l();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            a.this.f52349b.closeLoadingDialog();
            BaseActivity baseActivity = a.this.f52349b;
            baseActivity.showToast(String.format(baseActivity.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            a.this.f();
            DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), a.this.f52353f, this.f52357e.name().toLowerCase());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC1141a {
        public c() {
        }

        @Override // d.a.m0.r.l.a.InterfaceC1141a
        public void a(String str, int i2, String str2) {
            a.this.f52349b.closeLoadingDialog();
            a.this.f52349b.showToast(str2);
        }

        @Override // d.a.m0.r.l.a.InterfaceC1141a
        public void b(String str) {
            a.this.l();
        }

        @Override // d.a.m0.r.l.a.InterfaceC1141a
        public void c(AccountData accountData) {
            a.this.f52349b.closeLoadingDialog();
            a.this.e(accountData);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f52360e;

        public d(a aVar, AccountData accountData) {
            this.f52360e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.l.c.g(this.f52360e);
            d.a.m0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
        }
    }

    public a(TbPageContext tbPageContext, d.a.n0.c2.b.b bVar, String str) {
        this.f52348a = tbPageContext;
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            this.f52349b = (BaseActivity) tbPageContext.getPageActivity();
        }
        this.f52350c = bVar;
        this.f52353f = str;
        bVar.d(this.f52354g);
    }

    public void c(int i2) {
        this.f52349b.setResult(i2, new Intent());
        this.f52349b.finish();
    }

    public final void d() {
        new LoginActivityConfig(this.f52349b, true, 25061).start();
    }

    public final void e(AccountData accountData) {
        h(accountData);
        d.a.m0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(this.f52349b.getIntent());
        c(-1);
    }

    public void f() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.f52351d;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.f52351d = d.a.m0.r.l.a.b().a(session.username, session.bduss, "", null, this.f52355h);
            return;
        }
        this.f52349b.closeLoadingDialog();
        c(0);
    }

    public final void g() {
        m(SocialType.QQ_SSO);
    }

    public final void h(AccountData accountData) {
        h.a().c(new d(this, accountData));
        d.a.m0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, this.f52348a.getPageActivity());
        d.a.m0.l.a.f(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
    }

    public void i(boolean z) {
        this.f52350c.b(z);
    }

    public abstract void j(d.a.n0.c2.b.c cVar);

    public void k(boolean z) {
        this.f52350c.e(z);
    }

    public void l() {
        if (this.f52349b.getLoadingDialog() == null || !this.f52349b.getLoadingDialog().c()) {
            this.f52349b.showLoadingDialog(this.f52348a.getString(R.string.sapi_logining));
            if (this.f52349b.getLoadingDialog() != null) {
                this.f52349b.getLoadingDialog().f(false);
                this.f52349b.getLoadingDialog().g(false);
            }
        }
    }

    public final void m(SocialType socialType) {
        PassportSDK.getInstance().loadThirdPartyLogin(new b(socialType), socialType);
    }

    public void n(View view) {
        if (view.getId() == R.id.btn_close) {
            this.f52349b.finish();
        } else if (view.getId() == R.id.btn_skip) {
            this.f52349b.finish();
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
