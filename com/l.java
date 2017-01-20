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
    final /* synthetic */ WeixinShareActivity cN;

    public l(WeixinShareActivity weixinShareActivity) {
        this.cN = weixinShareActivity;
    }

    @Override // com.baidu.cloudsdk.social.core.util.Weixin.IWXResponseHandler
    public void onResponse(int i, String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        IBaiduListener q = n.q(str2);
        ShareContent r = n.r(str2);
        if (q == null) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            str4 = WeixinShareActivity.a;
            Log.e(str4, "no listener for this transaction: " + str2);
        } else if (i != 0) {
            if (i == -2) {
                q.onCancel();
            } else {
                q.onError(new BaiduException("send share message to weixin failed, errcode: " + i + ", errmsg: " + str));
            }
        } else {
            q.onComplete();
            if (r != null) {
                SocialShareStatisticsManager.getInstance(this.cN).statistics(MediaType.WEIXIN, r);
                return;
            }
            str3 = WeixinShareActivity.a;
            Log.e(str3, "no sharecontent get so no statis");
        }
    }
}
