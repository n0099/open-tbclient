package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.File;
/* renamed from: h  reason: default package */
/* loaded from: classes.dex */
class h implements AsyncImageLoader.IAsyncImageLoaderListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f2686a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(am amVar, Uri uri) {
        this.b = amVar;
        this.f2686a = uri;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap == null) {
            this.b.doShare(null);
            return;
        }
        this.b.doShare(Uri.fromFile(new File(ImageManager.getInstance().getCachedFilePath(this.f2686a))));
    }
}
