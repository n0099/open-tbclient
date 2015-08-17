package com;

import android.content.Context;
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
/* loaded from: classes.dex */
public abstract class h extends c {
    protected static final String BAIDUYUN_PACKAGE = "com.android.contacts";
    protected static final String BLUETOOTH_PACKAGE = "com.android.bluetooth";
    protected static final String EMAIL_PACKAGE = "com.android.email";
    protected static final String GTALK_ACTIVITY = "com.google.android.apps.babel.phone.ShareIntentActivity";
    protected static final String GTALK_PACKAGE = "com.google.android.talk";
    protected static final String HUAWEI_MESSAGE_ACTIVITY = "com.hotalk.ui.chat.singleChat.SingleChatActivity";
    protected static final String HUAWEI_MESSAGE_PACKAGE = "com.huawei.message";
    protected static final String IMAGE_CONTENT_TYPE = "image/png";
    protected static final String LENOVO_ACTIVITY = "com.lenovo.ideafriend.mms.android.ui.ComposeMessageActivity";
    protected static final String LENOVO_PACKAGE = "com.lenovo.ideafriend";
    protected static final String LEWA_ACTIVITY = "com.lewa.PIM.mms.ui.ComposeMessageActivity";
    protected static final String LEWA_PACKAGE = "com.lewa.PIM";
    protected static final String MAIL_CONTENT_TYPE = "message/rfc822";
    protected static final String MMS_PACKAGE = "com.android.mms";
    protected static final String SEMC_MESSAGE_ACTIVITY = "com.sonyericsson.conversations.ui.ConversationListActivity";
    protected static final String SEMC_MESSAGE_PACKAGE = "com.sonyericsson.conversations";
    protected static final String SMS_BODY = "sms_body";
    protected static final String SMS_MESSAGE_ACTIVITY = "com.android.mms.ui.ComposeMessageActivity";
    protected static final String SMS_PACKAGE = "com.android.sms";
    protected static final String SMS_URI = "smsto:";
    protected static final String TEXT_CONTENT_TYPE = "text/plain";
    protected SocialShareConfig mConfig;

    public h(Context context, IBaiduListener iBaiduListener, int i, String str) {
        super(context, iBaiduListener, i, str);
        this.mConfig = SocialShareConfig.getInstance(context);
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
        intent.setPackage(MMS_PACKAGE);
        intent.putExtra(SMS_BODY, sb.toString());
        if (uri != null) {
            intent.setType(IMAGE_CONTENT_TYPE);
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
        } else {
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse(SMS_URI));
        }
        if (!Utils.isActivityExist(this.mContext, intent)) {
            intent.setClassName(MMS_PACKAGE, SMS_MESSAGE_ACTIVITY);
            if (!Utils.isActivityExist(this.mContext, intent)) {
                intent.setClassName(SEMC_MESSAGE_PACKAGE, SEMC_MESSAGE_ACTIVITY);
                if (!Utils.isActivityExist(this.mContext, intent)) {
                    intent.setClassName(HUAWEI_MESSAGE_PACKAGE, HUAWEI_MESSAGE_ACTIVITY);
                    if (!Utils.isActivityExist(this.mContext, intent)) {
                        intent.setClassName(GTALK_PACKAGE, GTALK_ACTIVITY);
                        if (!Utils.isActivityExist(this.mContext, intent)) {
                            intent.setClassName(LEWA_PACKAGE, LEWA_ACTIVITY);
                            if (!Utils.isActivityExist(this.mContext, intent)) {
                                intent.setClassName(BAIDUYUN_PACKAGE, SMS_MESSAGE_ACTIVITY);
                                if (!Utils.isActivityExist(this.mContext, intent)) {
                                    intent.setClassName(LENOVO_PACKAGE, LENOVO_ACTIVITY);
                                }
                            }
                        }
                    }
                }
            }
        }
        return intent;
    }

    @Override // com.c
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

    @Override // com.c, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        this.mListener = iBaiduListener;
        this.mShareContent = shareContent;
        Uri imageUri = shareContent.getImageUri();
        if (imageUri != null && !Utils.isUrl(imageUri)) {
            doShare(imageUri);
        } else if (imageUri != null) {
            ImageManager.getInstance().loadImage(this.mContext, imageUri, new i(this, imageUri));
        } else {
            doShare(null);
        }
    }
}
