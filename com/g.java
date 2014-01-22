package com;

import android.graphics.Bitmap;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ ao a;
    private ShareContent b;

    public g(ao aoVar, ShareContent shareContent) {
        this.a = aoVar;
        this.b = shareContent;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        String str;
        String str2;
        byte[] a;
        if (bitmap != null && !bitmap.isRecycled()) {
            a = this.a.a(bitmap);
            this.a.a(this.b, a);
            return;
        }
        str = this.a.h;
        IBaiduListener a2 = ao.a(str);
        str2 = this.a.h;
        ao.b(str2);
        if (a2 != null) {
            a2.onError(new BaiduException("failed to load image uri "));
        }
    }
}
