package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.File;
/* loaded from: classes.dex */
class i implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ Uri cO;
    final /* synthetic */ h cP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Uri uri) {
        this.cP = hVar;
        this.cO = uri;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.cP.doShare(null);
            return;
        }
        this.cP.doShare(Uri.fromFile(new File(ImageManager.getInstance().getCachedFilePath(this.cO))));
    }
}
