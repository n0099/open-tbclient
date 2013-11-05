package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g  reason: default package */
/* loaded from: classes.dex */
public class g implements AsyncImageLoader.IAsyncImageLoaderListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f2685a;

    private g(ak akVar) {
        this.f2685a = akVar;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        String a2;
        if (bitmap != null) {
            ShareContent shareContent = this.f2685a.mShareContent;
            a2 = this.f2685a.a(bitmap);
            shareContent.setImageUri(Uri.parse(a2));
        }
        this.f2685a.c();
    }
}
