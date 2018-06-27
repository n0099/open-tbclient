package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.ImageUtils;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class WbShareTransActivity extends Activity {
    private CopyResourceTask copyResourceTask;
    private View progressBar;
    private FrameLayout rootLayout;
    private String startActivityName;
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
        try {
            this.startActivityName = getIntent().getStringExtra(WBConstants.SHARE_START_ACTIVITY);
            if (bundle != null) {
                this.startActivityName = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
                this.flag = bundle.getBoolean(WBConstants.SHARE_START_RESULT_FLAG, false);
                return;
            }
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(this.startActivityName)) {
            finish();
        } else {
            checkSource();
        }
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
            intent2.setPackage(intent.getStringExtra(WBConstants.SHARE_START_PACKAGE));
            intent2.setAction(intent.getStringExtra(WBConstants.SHARE_START_ACTION));
            Bundle extras = intent.getExtras();
            weiboMultiMessage.toBundle(extras);
            intent2.putExtras(extras);
            String packageName = getPackageName();
            intent2.putExtra(WBConstants.Base.SDK_VER, WbSdkVersion.WEIBO_SDK_VERSION_CODE);
            intent2.putExtra(WBConstants.Base.APP_PKG, packageName);
            intent2.putExtra(WBConstants.Base.APP_KEY, WbSdk.getAuthInfo().getAppKey());
            intent2.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
            intent2.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(this, packageName)));
            if (!TextUtils.isEmpty(intent.getStringExtra(WBConstants.SHARE_START_GOTO_ACTIVITY))) {
                intent2.setClassName(this, intent.getStringExtra(WBConstants.SHARE_START_GOTO_ACTIVITY));
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
            this.copyResourceTask = new CopyResourceTask();
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
        int i = -1;
        super.onNewIntent(intent);
        try {
            i = intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1);
        } catch (Exception e) {
        }
        if (i != 0) {
            this.handler.removeMessages(0);
            this.handler = null;
            try {
                Bundle extras = intent.getExtras();
                Intent intent2 = new Intent();
                intent2.putExtras(extras);
                intent2.setFlags(131072);
                intent2.setClassName(this, this.startActivityName);
                startActivity(intent2);
            } catch (Exception e2) {
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.remove(WBConstants.SHARE_START_FLAG);
        bundle.putBoolean(WBConstants.SHARE_START_RESULT_FLAG, true);
        bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.startActivityName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CopyResourceTask extends AsyncTask<WeiboMultiMessage, Object, TransResourceResult> {
        private CopyResourceTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public TransResourceResult doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
            WeiboMultiMessage weiboMultiMessage = weiboMultiMessageArr[0];
            TransResourceResult transResourceResult = new TransResourceResult();
            try {
                if (WbSdk.isWbInstall(WbShareTransActivity.this)) {
                    if (WeiboAppManager.queryWbInfoInternal(WbShareTransActivity.this).getSupportVersion() >= 10772) {
                        if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                            weiboMultiMessage.imageObject = null;
                        }
                        if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.multiImageObject != null || weiboMultiMessage.imageObject != null)) {
                            weiboMultiMessage.multiImageObject = null;
                            weiboMultiMessage.imageObject = null;
                        }
                    } else {
                        weiboMultiMessage.multiImageObject = null;
                        weiboMultiMessage.videoSourceObject = null;
                    }
                    if (weiboMultiMessage.multiImageObject != null) {
                        ArrayList<Uri> arrayList = new ArrayList<>();
                        Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                        while (it.hasNext()) {
                            String copyFileToWeiboTem = ImageUtils.copyFileToWeiboTem(WbShareTransActivity.this, it.next(), 1);
                            if (!TextUtils.isEmpty(copyFileToWeiboTem)) {
                                arrayList.add(Uri.fromFile(new File(copyFileToWeiboTem)));
                            }
                        }
                        weiboMultiMessage.multiImageObject.setImageList(arrayList);
                    }
                    if (weiboMultiMessage.videoSourceObject != null) {
                        String copyFileToWeiboTem2 = ImageUtils.copyFileToWeiboTem(WbShareTransActivity.this, weiboMultiMessage.videoSourceObject.videoPath, 0);
                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(copyFileToWeiboTem2));
                        weiboMultiMessage.videoSourceObject.during = ImageUtils.getVideoDuring(copyFileToWeiboTem2);
                    }
                }
                transResourceResult.message = weiboMultiMessage;
                transResourceResult.transDone = true;
            } catch (Exception e) {
                transResourceResult.transDone = false;
            }
            return transResourceResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(TransResourceResult transResourceResult) {
            super.onPostExecute((CopyResourceTask) transResourceResult);
            WbShareTransActivity.this.rootLayout.setVisibility(4);
            if (!transResourceResult.transDone) {
                WbShareTransActivity.this.sendCallback(2);
            } else {
                WbShareTransActivity.this.gotoWeiboComposer(transResourceResult.message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TransResourceResult {
        WeiboMultiMessage message;
        boolean transDone;

        private TransResourceResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCallback(int i) {
        if (this.rootLayout != null) {
            this.rootLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(WBConstants.Response.ERRCODE, i);
            intent.putExtras(bundle);
            intent.setFlags(131072);
            intent.setClassName(this, this.startActivityName);
            startActivity(intent);
        } catch (Exception e) {
        }
        this.handler.removeMessages(0);
        this.handler = null;
        finish();
    }
}
