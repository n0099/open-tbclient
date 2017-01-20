package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* loaded from: classes.dex */
class z extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem fW;
    final /* synthetic */ y fX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ShareMediaItem shareMediaItem) {
        this.fX = yVar;
        this.fW = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.fX.fV.a(this.fW, false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.fX.fV.a(this.fW, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.fX.fV.a(this.fW, false);
    }
}
