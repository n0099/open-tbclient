package d.b.i0.a2.b;

import android.view.View;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.R;
import com.google.gson.Gson;
/* loaded from: classes3.dex */
public class f extends d.b.i0.a2.b.a {
    public ShareStorage.StorageModel i;

    /* loaded from: classes3.dex */
    public class a extends WebAuthListener {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            BaseActivity baseActivity = f.this.f51902b;
            baseActivity.showToast(String.format(baseActivity.getString(R.string.share_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            f.this.f();
            DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_SHARE, DialogLoginHelper.FULL_SCREEN_TYPE_SHARE);
        }
    }

    public f(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext, bVar, DialogLoginHelper.FULL_SCREEN_TYPE_SHARE);
    }

    @Override // d.b.i0.a2.b.a
    public void j(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f51905e = cVar;
        this.i = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f51925d, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // d.b.i0.a2.b.a
    public void n(View view) {
        super.n(view);
        if (view.getId() == R.id.login_btn) {
            q();
        }
    }

    public void q() {
        if (this.i != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.f51902b, new a(), this.i);
        }
    }
}
