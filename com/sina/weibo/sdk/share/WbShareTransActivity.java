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
/* loaded from: classes7.dex */
public class WbShareTransActivity extends BaseActivity {
    public CopyResourceTask copyResourceTask;
    public boolean flag = false;
    public Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WbShareTransActivity.this.sendCallback(1);
        }
    };
    public FrameLayout rootLayout;

    private void checkSource(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                finish();
                return;
            }
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            weiboMultiMessage.toObject(extras);
            transPicAndVideoResource(weiboMultiMessage);
        } catch (Exception unused) {
            finish();
        }
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
        } catch (Exception unused) {
            sendCallback(2);
        }
    }

    private void initView() {
        View view;
        int intExtra = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
        int intExtra2 = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
        this.rootLayout = new FrameLayout(this);
        if (intExtra2 != -1) {
            try {
                view = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra2, (ViewGroup) null);
            } catch (Exception unused) {
                view = new WbSdkProgressBar(this);
            }
        } else {
            WbSdkProgressBar wbSdkProgressBar = new WbSdkProgressBar(this);
            if (intExtra != -1) {
                wbSdkProgressBar.setProgressColor(intExtra);
            }
            view = wbSdkProgressBar;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(view, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCallback(int i2) {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(WBConstants.Response.ERRCODE, i2);
            intent.putExtras(bundle);
            setResult(-1, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(0);
            this.handler = null;
        }
        finish();
    }

    private void transPicAndVideoResource(WeiboMultiMessage weiboMultiMessage) {
        setContentView(this.rootLayout);
        if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
            gotoWeiboComposer(weiboMultiMessage);
            return;
        }
        CopyResourceTask copyResourceTask = this.copyResourceTask;
        if (copyResourceTask != null) {
            copyResourceTask.cancel(true);
        }
        CopyResourceTask copyResourceTask2 = new CopyResourceTask(this, new TransResourceCallback() { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.2
            @Override // com.sina.weibo.sdk.share.TransResourceCallback
            public void onTransFinish(StoryObject storyObject) {
            }

            @Override // com.sina.weibo.sdk.share.TransResourceCallback
            public void onTransFinish(TransResourceResult transResourceResult) {
                WbShareTransActivity.this.rootLayout.setVisibility(4);
                if (transResourceResult == null || !transResourceResult.transDone) {
                    WbShareTransActivity.this.sendCallback(2);
                } else {
                    WbShareTransActivity.this.gotoWeiboComposer(transResourceResult.message);
                }
            }
        });
        this.copyResourceTask = copyResourceTask2;
        copyResourceTask2.execute(weiboMultiMessage);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1) != 0) {
            finish();
        } else {
            checkSource(intent);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.i("Share", "startTransActivity.onNewIntent()");
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(0);
            this.handler = null;
        }
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.remove(WBConstants.SHARE_START_FLAG);
    }
}
