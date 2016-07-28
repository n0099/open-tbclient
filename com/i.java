package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.File;
/* loaded from: classes.dex */
class i implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ Uri a;
    final /* synthetic */ h cN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Uri uri) {
        this.cN = hVar;
        this.a = uri;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.cN.doShare(null);
            return;
        }
        this.cN.doShare(Uri.fromFile(new File(ImageManager.getInstance().getCachedFilePath(this.a))));
    }
}
