package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.CmdObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes3.dex */
public class VersionCheckHandler implements IVersionCheckHandler {
    private static final String TAG = VersionCheckHandler.class.getName();

    @Override // com.sina.weibo.sdk.api.share.IVersionCheckHandler
    public boolean checkRequest(Context context, WeiboAppManager.WeiboInfo weiboInfo, WeiboMessage weiboMessage) {
        if (weiboInfo == null || !weiboInfo.isLegal()) {
            return false;
        }
        LogUtil.d(TAG, "WeiboMessage WeiboInfo package : " + weiboInfo.getPackageName());
        LogUtil.d(TAG, "WeiboMessage WeiboInfo supportApi : " + weiboInfo.getSupportApi());
        if (weiboInfo.getSupportApi() < 10351 && weiboMessage.mediaObject != null && (weiboMessage.mediaObject instanceof VoiceObject)) {
            weiboMessage.mediaObject = null;
        }
        if (weiboInfo.getSupportApi() < 10352 && weiboMessage.mediaObject != null && (weiboMessage.mediaObject instanceof CmdObject)) {
            weiboMessage.mediaObject = null;
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.api.share.IVersionCheckHandler
    public boolean checkRequest(Context context, WeiboAppManager.WeiboInfo weiboInfo, WeiboMultiMessage weiboMultiMessage) {
        if (weiboInfo == null || !weiboInfo.isLegal()) {
            return false;
        }
        LogUtil.d(TAG, "WeiboMultiMessage WeiboInfo package : " + weiboInfo.getPackageName());
        LogUtil.d(TAG, "WeiboMultiMessage WeiboInfo supportApi : " + weiboInfo.getSupportApi());
        if (weiboInfo.getSupportApi() >= 10351) {
            if (weiboInfo.getSupportApi() < 10352 && weiboMultiMessage.mediaObject != null && (weiboMultiMessage.mediaObject instanceof CmdObject)) {
                weiboMultiMessage.mediaObject = null;
            }
            return true;
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.api.share.IVersionCheckHandler
    public boolean checkResponse(Context context, String str, WeiboMessage weiboMessage) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return checkRequest(context, WeiboAppManager.getInstance(context).parseWeiboInfoByAsset(str), weiboMessage);
    }

    @Override // com.sina.weibo.sdk.api.share.IVersionCheckHandler
    public boolean checkResponse(Context context, String str, WeiboMultiMessage weiboMultiMessage) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return checkRequest(context, WeiboAppManager.getInstance(context).parseWeiboInfoByAsset(str), weiboMultiMessage);
    }
}
