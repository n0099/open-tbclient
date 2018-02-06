package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes3.dex */
public final class WeiboMultiMessage {
    private static final String TAG = "WeiboMultiMessage";
    public BaseMediaObject BusinessLinkCardPageObject;
    public ImageObject imageObject;
    public BaseMediaObject mediaObject;
    public int msgType;
    public TextObject textObject;
    public static int OneImageType = 1;
    public static int NineImageType = 2;

    public WeiboMultiMessage() {
    }

    public WeiboMultiMessage(Bundle bundle) {
        toBundle(bundle);
    }

    public Bundle toBundle(Bundle bundle) {
        if (this.textObject != null) {
            bundle.putParcelable(WBConstants.Msg.TEXT, this.textObject);
            bundle.putString(WBConstants.Msg.TEXT_EXTRA, this.textObject.toExtraMediaString());
        }
        if (this.imageObject != null) {
            bundle.putParcelable(WBConstants.Msg.IMAGE, this.imageObject);
            bundle.putString(WBConstants.Msg.IMAGE_EXTRA, this.imageObject.toExtraMediaString());
        }
        if (this.mediaObject != null) {
            bundle.putParcelable(WBConstants.Msg.MEDIA, this.mediaObject);
            bundle.putString(WBConstants.Msg.MEDIA_EXTRA, this.mediaObject.toExtraMediaString());
        }
        return bundle;
    }

    public WeiboMultiMessage toObject(Bundle bundle) {
        this.textObject = (TextObject) bundle.getParcelable(WBConstants.Msg.TEXT);
        if (this.textObject != null) {
            this.textObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.TEXT_EXTRA));
        }
        this.imageObject = (ImageObject) bundle.getParcelable(WBConstants.Msg.IMAGE);
        if (this.imageObject != null) {
            this.imageObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.IMAGE_EXTRA));
        }
        this.mediaObject = (BaseMediaObject) bundle.getParcelable(WBConstants.Msg.MEDIA);
        if (this.mediaObject != null) {
            this.mediaObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.MEDIA_EXTRA));
        }
        return this;
    }

    public boolean checkArgs() {
        if (this.textObject != null && !this.textObject.checkArgs()) {
            LogUtil.e(TAG, "checkArgs fail, textObject is invalid");
            return false;
        } else if (this.imageObject != null && !this.imageObject.checkArgs()) {
            LogUtil.e(TAG, "checkArgs fail, imageObject is invalid");
            return false;
        } else if (this.mediaObject != null && !this.mediaObject.checkArgs()) {
            LogUtil.e(TAG, "checkArgs fail, mediaObject is invalid");
            return false;
        } else if (this.textObject == null && this.imageObject == null && this.mediaObject == null) {
            LogUtil.e(TAG, "checkArgs fail, textObject and imageObject and mediaObject is null");
            return false;
        } else {
            return true;
        }
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public int getMsgType() {
        return this.msgType;
    }
}
