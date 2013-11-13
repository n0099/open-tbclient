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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f2736a;
    final /* synthetic */ String b;
    final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener c;
    final /* synthetic */ ImageManager d;

    public j(ImageManager imageManager, Uri uri, String str, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.d = imageManager;
        this.f2736a = uri;
        this.b = str;
        this.c = iAsyncImageLoaderListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        int i;
        MemoryBitmapCache memoryBitmapCache;
        bm bmVar;
        if (bitmap != null) {
            if (Utils.isUrl(this.f2736a)) {
                bmVar = this.d.b;
                bmVar.a(this.b, bitmap);
            } else {
                int a2 = bm.a(bitmap);
                i = this.d.c;
                if (a2 <= i) {
                    memoryBitmapCache = this.d.f836a;
                    memoryBitmapCache.a(this.b, bitmap);
                }
            }
        }
        this.c.onComplete(bitmap);
    }
}
