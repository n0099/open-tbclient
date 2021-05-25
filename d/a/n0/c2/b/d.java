package d.a.n0.c2.b;

import android.view.View;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends d.a.n0.c2.b.a {

    /* loaded from: classes4.dex */
    public class a extends OneKeyLoginCallback {
        public a() {
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            d.this.f52349b.closeLoadingDialog();
            BaseActivity baseActivity = d.this.f52349b;
            baseActivity.showToast(String.format(baseActivity.getString(R.string.onekey_login_fail), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
            d.this.f();
        }
    }

    public d(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext, bVar, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
    }

    @Override // d.a.n0.c2.b.a
    public void j(c cVar) {
        this.f52352e = cVar;
    }

    @Override // d.a.n0.c2.b.a
    public void n(View view) {
        super.n(view);
        if (view.getId() == R.id.login_btn) {
            s();
        } else if (view.getId() == R.id.operator_text) {
            t();
        } else if (view.getId() == R.id.agreement_text) {
            r();
        } else if (view.getId() == R.id.privacy_text) {
            u();
        }
    }

    public final void r() {
        BaseActivity baseActivity = this.f52349b;
        new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.onekey_login_dialog_activity_agreement_text), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
    }

    public void s() {
        l();
        PassportSDK passportSDK = PassportSDK.getInstance();
        BaseActivity baseActivity = this.f52349b;
        passportSDK.loadOneKeyLogin(baseActivity, d.a.n0.c2.c.b.h(baseActivity, this.f52352e.f52372c), new a());
    }

    public final void t() {
        c cVar = this.f52352e;
        if (cVar == null) {
            return;
        }
        int a2 = cVar.a();
        if (a2 == 1) {
            BaseActivity baseActivity = this.f52349b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.onekey_login_dialog_activity_operator_1), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
        } else if (a2 == 2) {
            BaseActivity baseActivity2 = this.f52349b;
            new TbWebViewActivityConfig(baseActivity2, baseActivity2.getResources().getString(R.string.onekey_login_dialog_activity_operator_2), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
        } else if (a2 != 3) {
        } else {
            BaseActivity baseActivity3 = this.f52349b;
            new TbWebViewActivityConfig(baseActivity3, baseActivity3.getResources().getString(R.string.onekey_login_dialog_activity_operator_3), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
        }
    }

    public final void u() {
        BaseActivity baseActivity = this.f52349b;
        new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.onekey_login_dialog_activity_privacy_text), "http://privacy.baidu.com/mdetail?id=288", false).start();
    }
}
