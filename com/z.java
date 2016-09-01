package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* loaded from: classes.dex */
class z extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem fY;
    final /* synthetic */ y fZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ShareMediaItem shareMediaItem) {
        this.fZ = yVar;
        this.fY = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.fZ.fX.a(this.fY, false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.fZ.fX.a(this.fY, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.fZ.fX.a(this.fY, false);
    }
}
