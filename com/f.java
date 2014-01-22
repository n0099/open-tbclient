package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.File;
/* loaded from: classes.dex */
class f implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ Uri a;
    final /* synthetic */ ak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ak akVar, Uri uri) {
        this.b = akVar;
        this.a = uri;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.b.doShare(null);
            return;
        }
        this.b.doShare(Uri.fromFile(new File(ImageManager.getInstance().getCachedFilePath(this.a))));
    }
}
