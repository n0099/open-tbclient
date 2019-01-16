package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.FileUtils;
import com.sina.weibo.sdk.utils.ImageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class CopyResourceTask extends AsyncTask<WeiboMultiMessage, Object, TransResourceResult> {
    private TransResourceCallback mCallback;
    private Context mContext;

    public CopyResourceTask(Context context, TransResourceCallback transResourceCallback) {
        this.mContext = context;
        this.mCallback = transResourceCallback;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public TransResourceResult doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        Uri uri;
        WeiboMultiMessage weiboMultiMessage = weiboMultiMessageArr[0];
        TransResourceResult transResourceResult = new TransResourceResult();
        try {
            if (WbSdk.isWbInstall(this.mContext)) {
                if (WeiboAppManager.queryWbInfoInternal(this.mContext).getSupportVersion() >= 10772) {
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
                        Uri next = it.next();
                        if (next != null && FileUtils.isImageFile(this.mContext, next)) {
                            String copyFileToWeiboTem = ShareUtils.copyFileToWeiboTem(this.mContext, next, 1);
                            if (!TextUtils.isEmpty(copyFileToWeiboTem)) {
                                arrayList.add(Uri.fromFile(new File(copyFileToWeiboTem)));
                            }
                        }
                    }
                    weiboMultiMessage.multiImageObject.setImageList(arrayList);
                }
                if (weiboMultiMessage.videoSourceObject != null && (uri = weiboMultiMessage.videoSourceObject.videoPath) != null && FileUtils.isVideoFile(this.mContext, uri)) {
                    String copyFileToWeiboTem2 = ShareUtils.copyFileToWeiboTem(this.mContext, uri, 0);
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
        if (this.mCallback != null) {
            this.mCallback.onTransFinish(transResourceResult);
        }
    }
}
