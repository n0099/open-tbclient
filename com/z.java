package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* loaded from: classes.dex */
class z extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem nO;
    final /* synthetic */ y nP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ShareMediaItem shareMediaItem) {
        this.nP = yVar;
        this.nO = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.nP.nN.a(this.nO, false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.nP.nN.a(this.nO, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.nP.nN.a(this.nO, false);
    }
}
