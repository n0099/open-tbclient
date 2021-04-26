package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
/* loaded from: classes6.dex */
public class WbShareToStoryActivity extends BaseActivity {
    public String callbackActivity;
    public View progressBar;
    public int progressColor = -1;
    public int progressId = -1;
    public FrameLayout rootLayout;
    public SaveFileTask saveFileTask;

    private boolean checkInfo(StoryMessage storyMessage) {
        return storyMessage.checkSource() && WbSdk.supportMultiImage(this);
    }

    private void gotoSave(StoryMessage storyMessage) {
        SaveFileTask saveFileTask = this.saveFileTask;
        if (saveFileTask != null) {
            saveFileTask.cancel(true);
        }
        SaveFileTask saveFileTask2 = new SaveFileTask(this, new TransResourceCallback() { // from class: com.sina.weibo.sdk.share.WbShareToStoryActivity.1
            @Override // com.sina.weibo.sdk.share.TransResourceCallback
            public void onTransFinish(StoryObject storyObject) {
                if (storyObject != null) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
                        intent.setPackage(intent.getStringExtra(WBConstants.SHARE_START_PACKAGE));
                        intent.putExtra("storyData", storyObject);
                        WbShareToStoryActivity.this.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                        WbShareToStoryActivity.this.setCallbackActivity(2);
                        return;
                    }
                }
                WbShareToStoryActivity.this.setCallbackActivity(2);
            }

            @Override // com.sina.weibo.sdk.share.TransResourceCallback
            public void onTransFinish(TransResourceResult transResourceResult) {
            }
        });
        this.saveFileTask = saveFileTask2;
        saveFileTask2.execute(storyMessage);
    }

    private void initView() {
        try {
            this.progressColor = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
            this.progressId = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
        } catch (Exception unused) {
        }
        this.rootLayout = new FrameLayout(this);
        if (this.progressId != -1) {
            try {
                this.progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(this.progressId, (ViewGroup) null);
            } catch (Exception unused2) {
                this.progressBar = new WbSdkProgressBar(this);
            }
        } else {
            WbSdkProgressBar wbSdkProgressBar = new WbSdkProgressBar(this);
            this.progressBar = wbSdkProgressBar;
            int i2 = this.progressColor;
            if (i2 != -1) {
                wbSdkProgressBar.setProgressColor(i2);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(this.progressBar, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
        setContentView(this.rootLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallbackActivity(int i2) {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(WBConstants.Response.ERRCODE, i2);
            setResult(-1, intent);
        } catch (Exception e2) {
            LogUtil.v("weibo sdk", e2.toString());
        }
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        try {
            if (bundle != null) {
                this.callbackActivity = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
            } else {
                this.callbackActivity = intent.getStringExtra(WBConstants.SHARE_START_ACTIVITY);
            }
        } catch (Exception unused) {
        }
        if (intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1) != 0) {
            finish();
        } else if (TextUtils.isEmpty(this.callbackActivity)) {
            finish();
        } else {
            StoryMessage storyMessage = null;
            try {
                storyMessage = (StoryMessage) getIntent().getParcelableExtra(WBConstants.Msg.STORY);
            } catch (Exception unused2) {
            }
            if (storyMessage == null) {
                setCallbackActivity(2);
            } else if (checkInfo(storyMessage)) {
                initView();
                gotoSave(storyMessage);
            } else {
                setCallbackActivity(2);
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        int i2;
        super.onNewIntent(intent);
        try {
            i2 = intent.getIntExtra("backType", 0);
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            setCallbackActivity(1);
        } else {
            setCallbackActivity(0);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.callbackActivity);
    }
}
