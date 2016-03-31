package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.File;
/* loaded from: classes.dex */
class i implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ Uri mP;
    final /* synthetic */ h mQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Uri uri) {
        this.mQ = hVar;
        this.mP = uri;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.mQ.doShare(null);
            return;
        }
        this.mQ.doShare(Uri.fromFile(new File(ImageManager.getInstance().getCachedFilePath(this.mP))));
    }
}
