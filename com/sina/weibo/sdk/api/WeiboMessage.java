package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes3.dex */
public final class WeiboMessage {
    public BaseMediaObject mediaObject;

    public WeiboMessage() {
    }

    public WeiboMessage(Bundle bundle) {
        toBundle(bundle);
    }

    public Bundle toBundle(Bundle bundle) {
        if (this.mediaObject != null) {
            bundle.putParcelable(WBConstants.Msg.MEDIA, this.mediaObject);
            bundle.putString(WBConstants.Msg.MEDIA_EXTRA, this.mediaObject.toExtraMediaString());
        }
        return bundle;
    }

    public WeiboMessage toObject(Bundle bundle) {
        this.mediaObject = (BaseMediaObject) bundle.getParcelable(WBConstants.Msg.MEDIA);
        if (this.mediaObject != null) {
            this.mediaObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.MEDIA_EXTRA));
        }
        return this;
    }

    public boolean checkArgs() {
        if (this.mediaObject == null) {
            LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is null");
            return false;
        } else if (this.mediaObject != null && !this.mediaObject.checkArgs()) {
            LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is invalid");
            return false;
        } else {
            return true;
        }
    }
}
