package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
/* renamed from: am  reason: default package */
/* loaded from: classes.dex */
public abstract class am extends ai {
    protected static final String BLUETOOTH_PACKAGE = "com.android.bluetooth";
    protected static final String EMAIL_PACKAGE = "com.android.email";
    protected static final String IMAGE_CONTENT_TYPE = "image/png";
    protected static final String MAIL_CONTENT_TYPE = "message/rfc822";
    protected static final String MMS_PACKAGE = "com.android.mms";
    protected static final String SMS_BODY = "sms_body";
    protected static final String SMS_MESSAGE_ACTIVITY = "com.android.mms.ui.ComposeMessageActivity";
    protected static final String SMS_PACKAGE = "com.android.sms";
    protected static final String SMS_URI = "smsto:";
    protected static final String TEXT_CONTENT_TYPE = "text/plain";
    protected Activity mActivity;
    protected SocialShareConfig mConfig;

    public am(Activity activity, IBaiduListener iBaiduListener, int i, String str) {
        super(activity, iBaiduListener, i, str);
        this.mActivity = activity;
        this.mConfig = SocialShareConfig.getInstance(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doShare(Uri uri);

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getEmailIntent(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage(EMAIL_PACKAGE);
        intent.setType(MAIL_CONTENT_TYPE);
        intent.putExtra("android.intent.extra.SUBJECT", this.mShareContent.getTitle());
        String emailBody = this.mShareContent.getEmailBody();
        if (Build.VERSION.SDK_INT >= 16) {
            intent.putExtra("android.intent.extra.TEXT", emailBody);
        } else {
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(emailBody));
        }
        if (uri != null) {
            intent.putExtra("android.intent.extra.STREAM", uri);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getOthersIntent(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage(str);
        intent.setType(TEXT_CONTENT_TYPE);
        intent.putExtra("android.intent.extra.SUBJECT", this.mShareContent.getTitle());
        if (str.equalsIgnoreCase(BLUETOOTH_PACKAGE)) {
            intent.putExtra("android.intent.extra.TEXT", this.mShareContent.getLinkUrl());
        } else {
            intent.putExtra("android.intent.extra.TEXT", this.mShareContent.getContent());
        }
        if (uri != null) {
            intent.setType(IMAGE_CONTENT_TYPE);
            intent.putExtra("android.intent.extra.STREAM", uri);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getSmsIntent(Uri uri) {
        StringBuilder sb = new StringBuilder(this.mShareContent.getContent());
        String linkUrl = this.mShareContent.getLinkUrl();
        if (!TextUtils.isEmpty(linkUrl)) {
            sb.append("\r\n").append(linkUrl);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setClassName(MMS_PACKAGE, SMS_MESSAGE_ACTIVITY);
        intent.putExtra(SMS_BODY, sb.toString());
        if (uri != null) {
            intent.setType(IMAGE_CONTENT_TYPE);
            intent.putExtra("android.intent.extra.STREAM", uri);
        } else {
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse(SMS_URI));
        }
        return intent;
    }

    @Override // defpackage.ai
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.mRequestCode) {
            if (-1 == i2) {
                this.mListener.onComplete();
                SocialShareStatisticsManager.getInstance(this.mContext).statistics(this.mMediaType, this.mShareContent);
            } else if (i2 == 0) {
                this.mListener.onCancel();
            }
        }
    }

    @Override // defpackage.ai, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        this.mListener = iBaiduListener;
        this.mShareContent = shareContent;
        Uri imageUri = shareContent.getImageUri();
        if (imageUri != null && !Utils.isUrl(imageUri)) {
            doShare(imageUri);
        } else if (imageUri != null) {
            ImageManager.getInstance().loadImage(this.mContext, imageUri, new h(this, imageUri));
        } else {
            doShare(null);
        }
    }
}
