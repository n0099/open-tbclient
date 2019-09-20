package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
/* loaded from: classes2.dex */
public class WbShareTransActivity extends BaseActivity {
    private CopyResourceTask copyResourceTask;
    boolean flag = false;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WbShareTransActivity.this.sendCallback(1);
        }
    };
    private FrameLayout rootLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.d("Share", "startShareTransActivity");
        initView();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1) != 0) {
                finish();
            } else {
                checkSource(intent);
            }
        }
    }

    private void checkSource(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                finish();
            } else {
                WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
                weiboMultiMessage.toObject(extras);
                transPicAndVideoResource(weiboMultiMessage);
            }
        } catch (Exception e) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    private void initView() {
        WbSdkProgressBar wbSdkProgressBar;
        View wbSdkProgressBar2;
        int intExtra = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
        int intExtra2 = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
        this.rootLayout = new FrameLayout(this);
        if (intExtra2 != -1) {
            try {
                wbSdkProgressBar2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra2, (ViewGroup) null);
            } catch (Exception e) {
                wbSdkProgressBar2 = new WbSdkProgressBar(this);
            }
            wbSdkProgressBar = wbSdkProgressBar2;
        } else {
            wbSdkProgressBar = new WbSdkProgressBar(this);
            if (intExtra != -1) {
                wbSdkProgressBar.setProgressColor(intExtra);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(wbSdkProgressBar, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoWeiboComposer(WeiboMultiMessage weiboMultiMessage) {
        LogUtil.d("Share", "gotoWeiboComposer");
        Intent intent = getIntent();
        this.flag = true;
        try {
            intent.putExtra(WBConstants.SHARE_START_FLAG, -1);
            Intent intent2 = new Intent(WBConstants.ACTIVITY_WEIBO);
            Bundle extras = intent.getExtras();
            weiboMultiMessage.toBundle(extras);
            intent2.putExtras(extras);
            String packageName = getPackageName();
            intent2.putExtra(WBConstants.Base.SDK_VER, WbSdkVersion.WEIBO_SDK_VERSION_CODE);
            intent2.putExtra(WBConstants.Base.APP_PKG, packageName);
            intent2.putExtra(WBConstants.Base.APP_KEY, WbSdk.getAuthInfo().getAppKey());
            intent2.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
            intent2.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(this, packageName)));
            String stringExtra = intent.getStringExtra(WBConstants.SHARE_START_GOTO_ACTIVITY);
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WeiboSdkWebActivity".equals(stringExtra)) {
                intent2.setClassName(this, "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
                startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
            } else if (WbSdk.isWbInstall(this)) {
                WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this).getWbAppInfo();
                if (wbAppInfo != null) {
                    intent2.setPackage(wbAppInfo.getPackageName());
                    startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                } else {
                    startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                }
            } else {
                sendCallback(2);
            }
        } catch (Exception e) {
            sendCallback(2);
        }
    }

    private void transPicAndVideoResource(WeiboMultiMessage weiboMultiMessage) {
        setContentView(this.rootLayout);
        if (weiboMultiMessage.multiImageObject != null || weiboMultiMessage.videoSourceObject != null) {
            if (this.copyResourceTask != null) {
                this.copyResourceTask.cancel(true);
            }
            this.copyResourceTask = new CopyResourceTask(this, new TransResourceCallback() { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.2
                @Override // com.sina.weibo.sdk.share.TransResourceCallback
                public void onTransFinish(TransResourceResult transResourceResult) {
                    WbShareTransActivity.this.rootLayout.setVisibility(4);
                    if (transResourceResult == null || !transResourceResult.transDone) {
                        WbShareTransActivity.this.sendCallback(2);
                    } else {
                        WbShareTransActivity.this.gotoWeiboComposer(transResourceResult.message);
                    }
                }

                @Override // com.sina.weibo.sdk.share.TransResourceCallback
                public void onTransFinish(StoryObject storyObject) {
                }
            });
            this.copyResourceTask.execute(weiboMultiMessage);
            return;
        }
        gotoWeiboComposer(weiboMultiMessage);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.handler != null) {
            this.handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.i("Share", "startTransActivity.onNewIntent()");
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.remove(WBConstants.SHARE_START_FLAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCallback(int i) {
        if (this.rootLayout != null) {
            this.rootLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            new Bundle().putInt(WBConstants.Response.ERRCODE, i);
            setResult(-1, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        finish();
    }
}
