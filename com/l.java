package com;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.Weixin;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.cloudsdk.social.share.handler.WeixinShareActivity;
/* loaded from: classes.dex */
public class l implements Weixin.IWXResponseHandler {
    final /* synthetic */ WeixinShareActivity mT;

    public l(WeixinShareActivity weixinShareActivity) {
        this.mT = weixinShareActivity;
    }

    @Override // com.baidu.cloudsdk.social.core.util.Weixin.IWXResponseHandler
    public void onResponse(int i, String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        IBaiduListener B = n.B(str2);
        ShareContent C = n.C(str2);
        if (B == null) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            str4 = WeixinShareActivity.a;
            Log.e(str4, "no listener for this transaction: " + str2);
        } else if (i != 0) {
            if (i == -2) {
                B.onCancel();
            } else {
                B.onError(new BaiduException("send share message to weixin failed, errcode: " + i + ", errmsg: " + str));
            }
        } else {
            B.onComplete();
            if (C != null) {
                SocialShareStatisticsManager.getInstance(this.mT).statistics(MediaType.WEIXIN, C);
                return;
            }
            str3 = WeixinShareActivity.a;
            Log.e(str3, "no sharecontent get so no statis");
        }
    }
}
