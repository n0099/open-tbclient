package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
/* loaded from: classes2.dex */
public class WbShareTransActivity extends Activity {
    private CopyResourceTask copyResourceTask;
    private View progressBar;
    private FrameLayout rootLayout;
    boolean flag = false;
    private int progressColor = -1;
    private int progressId = -1;
    private Handler handler = new Handler() { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WbShareTransActivity.this.sendCallback(1);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        checkSource();
    }

    private void checkSource() {
        try {
            Bundle extras = getIntent().getExtras();
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

    private void initView() {
        try {
            this.progressColor = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
            this.progressId = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
        } catch (Exception e) {
        }
        this.rootLayout = new FrameLayout(this);
        if (this.progressId != -1) {
            try {
                this.progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(this.progressId, (ViewGroup) null);
            } catch (Exception e2) {
                this.progressBar = new WbSdkProgressBar(this);
            }
        } else {
            this.progressBar = new WbSdkProgressBar(this);
            if (this.progressColor != -1) {
                ((WbSdkProgressBar) this.progressBar).setProgressColor(this.progressColor);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(this.progressBar, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoWeiboComposer(WeiboMultiMessage weiboMultiMessage) {
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
                startActivity(intent2);
            } else if (WbSdk.isWbInstall(this)) {
                startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
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
            setContentView(this.rootLayout);
            if (this.copyResourceTask != null) {
                this.copyResourceTask.cancel(true);
            }
            this.copyResourceTask = new CopyResourceTask(this, new TransResourceCallback() { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.2
                @Override // com.sina.weibo.sdk.share.TransResourceCallback
                public void onTransFinish(TransResourceResult transResourceResult) {
                    WbShareTransActivity.this.rootLayout.setVisibility(4);
                    if (!transResourceResult.transDone) {
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
        }
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        finish();
    }
}
