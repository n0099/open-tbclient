package d.a.n0.c2.b;

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
/* loaded from: classes4.dex */
public class f extends d.a.n0.c2.b.a {

    /* renamed from: i  reason: collision with root package name */
    public ShareStorage.StorageModel f52375i;

    /* loaded from: classes4.dex */
    public class a extends WebAuthListener {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            BaseActivity baseActivity = f.this.f52349b;
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

    @Override // d.a.n0.c2.b.a
    public void j(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f52352e = cVar;
        this.f52375i = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f52373d, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // d.a.n0.c2.b.a
    public void n(View view) {
        super.n(view);
        if (view.getId() == R.id.login_btn) {
            r();
        }
    }

    public void r() {
        if (this.f52375i != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.f52349b, new a(), this.f52375i);
        }
    }
}
