package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
/* renamed from: j  reason: default package */
/* loaded from: classes.dex */
public class j implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ Uri a;
    final /* synthetic */ String b;
    final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener c;
    final /* synthetic */ ImageManager d;

    public j(ImageManager imageManager, Uri uri, String str, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.d = imageManager;
        this.a = uri;
        this.b = str;
        this.c = iAsyncImageLoaderListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        int i;
        MemoryBitmapCache memoryBitmapCache;
        bm bmVar;
        if (bitmap != null) {
            if (Utils.isUrl(this.a)) {
                bmVar = this.d.b;
                bmVar.a(this.b, bitmap);
            } else {
                int a = bm.a(bitmap);
                i = this.d.c;
                if (a <= i) {
                    memoryBitmapCache = this.d.a;
                    memoryBitmapCache.a(this.b, bitmap);
                }
            }
        }
        this.c.onComplete(bitmap);
    }
}
