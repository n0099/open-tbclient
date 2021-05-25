package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";

    /* renamed from: d  reason: collision with root package name */
    public String f36248d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36247c = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36245a = false;

    /* renamed from: b  reason: collision with root package name */
    public Handler f36246b = new Handler() { // from class: com.tencent.connect.common.AssistActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                f.d("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
        String string5 = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        String str4 = "";
        if ("shareToQQ".equals(string2)) {
            str2 = Constants.VIA_SHARE_TO_QQ;
            str3 = "10";
        } else if (!"shareToQzone".equals(string2)) {
            str = "";
            if (j.a(this, string3)) {
                IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string2);
                if (listnerWithAction != null) {
                    listnerWithAction.onError(new UiError(-6, Constants.MSG_OPEN_BROWSER_ERROR, null));
                }
                d.a().a(string4, string5, str4, str, "3", "1", string, "0", "2", "0");
                finish();
            } else {
                d.a().a(string4, string5, str4, str, "3", "0", string, "0", "2", "0");
            }
            getIntent().removeExtra("shareH5");
        } else {
            str2 = Constants.VIA_SHARE_TO_QZONE;
            str3 = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        }
        str = str3;
        str4 = str2;
        if (j.a(this, string3)) {
        }
        getIntent().removeExtra("shareH5");
    }

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i2);
        sb.append(" | resultCode: ");
        sb.append(i3);
        sb.append("data = null ? ");
        sb.append(intent == null);
        f.c("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(Constants.KEY_ACTION, "action_login");
        }
        setResultData(i2, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(3);
        f.b("openSDK_LOG.AssistActivity", "--onCreate--");
        if (getIntent() == null) {
            f.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        int intExtra = intent == null ? 0 : intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
        this.f36248d = intent == null ? "" : intent.getStringExtra("appid");
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.f36247c = bundle.getBoolean("RESTART_FLAG");
            this.f36245a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.f36247c) {
            f.b("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            f.d("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
        } else if (intent != null) {
            f.c("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
            startActivityForResult(intent, intExtra);
        } else {
            f.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        f.b("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        f.c("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        intent.putExtra(Constants.KEY_ACTION, "action_share");
        setResult(-1, intent);
        if (isFinishing()) {
            return;
        }
        f.c("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
        finish();
    }

    @Override // android.app.Activity
    public void onPause() {
        f.b("openSDK_LOG.AssistActivity", "-->onPause");
        this.f36246b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        f.b("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.f36247c && !isFinishing()) {
            finish();
        }
        if (this.f36245a) {
            this.f36246b.sendMessage(this.f36246b.obtainMessage(0));
            return;
        }
        this.f36245a = true;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        f.b("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.f36245a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        f.b("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        f.b("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void setResultData(int i2, Intent intent) {
        if (intent == null) {
            f.d("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i2 == 11101) {
                d.a().a("", this.f36248d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
            f.b("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    f.c("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    d.a().a(optString, this.f36248d, "2", "1", "7", "0");
                } else {
                    f.d("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    d.a().a("", this.f36248d, "2", "1", "7", "1");
                }
            } else {
                f.d("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            }
        } catch (Exception e2) {
            f.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e2.printStackTrace();
        }
    }
}
