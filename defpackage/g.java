package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g  reason: default package */
/* loaded from: classes.dex */
public class g implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ ak a;

    private g(ak akVar) {
        this.a = akVar;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        String a;
        if (bitmap != null) {
            ShareContent shareContent = this.a.mShareContent;
            a = this.a.a(bitmap);
            shareContent.setImageUri(Uri.parse(a));
        }
        this.a.c();
    }
}
