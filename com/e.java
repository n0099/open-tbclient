package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ ai a;
    private Uri b;

    public e(ai aiVar, Uri uri) {
        this.a = aiVar;
        this.b = uri;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.mShareContent.setImageUri(Uri.parse(ImageManager.getInstance().getCachedFilePath(this.b)));
        }
        this.a.c();
    }
}
