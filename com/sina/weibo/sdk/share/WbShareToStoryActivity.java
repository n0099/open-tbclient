package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
import com.sina.weibo.sdk.utils.ImageUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
/* loaded from: classes2.dex */
public class WbShareToStoryActivity extends Activity {
    private String callbackActivity;
    private View progressBar;
    private int progressColor = -1;
    private int progressId = -1;
    private FrameLayout rootLayout;
    private SaveFileTask saveFileTask;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        StoryMessage storyMessage;
        super.onCreate(bundle);
        try {
            if (bundle != null) {
                this.callbackActivity = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
            } else {
                this.callbackActivity = getIntent().getStringExtra(WBConstants.SHARE_START_ACTIVITY);
            }
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(this.callbackActivity)) {
            finish();
            return;
        }
        try {
            storyMessage = (StoryMessage) getIntent().getParcelableExtra(WBConstants.Msg.STORY);
        } catch (Exception e2) {
            storyMessage = null;
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
        setContentView(this.rootLayout);
    }

    private boolean checkInfo(StoryMessage storyMessage) {
        return storyMessage.checkSource() && WbSdk.supportMultiImage(this);
    }

    private void gotoSave(StoryMessage storyMessage) {
        if (this.saveFileTask != null) {
            this.saveFileTask.cancel(true);
        }
        this.saveFileTask = new SaveFileTask();
        this.saveFileTask.execute(storyMessage);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        int i;
        super.onNewIntent(intent);
        try {
            i = intent.getIntExtra("backType", 0);
        } catch (Exception e) {
            i = 0;
        }
        if (i == 0) {
            setCallbackActivity(1);
        } else {
            setCallbackActivity(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class SaveFileTask extends AsyncTask<StoryMessage, Object, StoryObject> {
        private SaveFileTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public StoryObject doInBackground(StoryMessage... storyMessageArr) {
            StoryMessage storyMessage = storyMessageArr[0];
            int i = storyMessage.getVideoUri() == null ? 1 : 0;
            String copyFileToWeiboTem = ImageUtils.copyFileToWeiboTem(WbShareToStoryActivity.this, i == 1 ? storyMessage.getImageUri() : storyMessage.getVideoUri(), i);
            if (TextUtils.isEmpty(copyFileToWeiboTem)) {
                return null;
            }
            StoryObject storyObject = new StoryObject();
            storyObject.sourcePath = copyFileToWeiboTem;
            storyObject.sourceType = i;
            storyObject.appId = WbSdk.getAuthInfo().getAppKey();
            storyObject.appPackage = WbShareToStoryActivity.this.getPackageName();
            return storyObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(StoryObject storyObject) {
            super.onPostExecute((SaveFileTask) storyObject);
            if (storyObject == null) {
                WbShareToStoryActivity.this.setCallbackActivity(2);
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
                intent.putExtra("storyData", storyObject);
                WbShareToStoryActivity.this.startActivity(intent);
            } catch (Exception e) {
                WbShareToStoryActivity.this.setCallbackActivity(2);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.callbackActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallbackActivity(int i) {
        if (this.rootLayout != null) {
            this.rootLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(WBConstants.Response.ERRCODE, i);
            intent.setFlags(131072);
            intent.setClassName(this, this.callbackActivity);
            startActivity(intent);
        } catch (Exception e) {
            LogUtil.v("weibo sdk", e.toString());
        }
        finish();
    }
}
