package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.TwitterShareHandler;
/* loaded from: classes.dex */
public class k extends DefaultBaiduListener {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ boolean b;
    final /* synthetic */ TwitterShareHandler ky;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TwitterShareHandler twitterShareHandler, IBaiduListener iBaiduListener, ShareContent shareContent, boolean z) {
        super(iBaiduListener);
        this.ky = twitterShareHandler;
        this.a = shareContent;
        this.b = z;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.ky.share(this.a, this.mListener, this.b);
    }
}
