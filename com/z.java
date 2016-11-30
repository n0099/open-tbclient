package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* loaded from: classes.dex */
class z extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem fZ;
    final /* synthetic */ y ga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ShareMediaItem shareMediaItem) {
        this.ga = yVar;
        this.fZ = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.ga.fY.a(this.fZ, false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.ga.fY.a(this.fZ, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.ga.fY.a(this.fZ, false);
    }
}
