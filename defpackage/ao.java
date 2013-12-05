package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.Weixin;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.cloudsdk.social.share.handler.WeixinShareActivity;
/* renamed from: ao  reason: default package */
/* loaded from: classes.dex */
public class ao implements Weixin.IWXResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WeixinShareActivity f360a;

    public ao(WeixinShareActivity weixinShareActivity) {
        this.f360a = weixinShareActivity;
    }

    @Override // com.baidu.cloudsdk.social.core.util.Weixin.IWXResponseHandler
    public void onResponse(int i, String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        IBaiduListener a2 = aq.a(str2);
        ShareContent b = aq.b(str2);
        if (a2 == null) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            str4 = WeixinShareActivity.f877a;
            Log.e(str4, "no listener for this transaction: " + str2);
        } else if (i != 0) {
            if (i == -2) {
                a2.onCancel();
            } else {
                a2.onError(new BaiduException("send share message to weixin failed, errcode: " + i + ", errmsg: " + str));
            }
        } else {
            a2.onComplete();
            if (b != null) {
                SocialShareStatisticsManager.getInstance(this.f360a).statistics(MediaType.WEIXIN, b);
                return;
            }
            str3 = WeixinShareActivity.f877a;
            Log.e(str3, "no sharecontent get so no statis");
        }
    }
}
