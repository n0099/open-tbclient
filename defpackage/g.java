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
    final /* synthetic */ ak f2898a;

    private g(ak akVar) {
        this.f2898a = akVar;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        String a2;
        if (bitmap != null) {
            ShareContent shareContent = this.f2898a.mShareContent;
            a2 = this.f2898a.a(bitmap);
            shareContent.setImageUri(Uri.parse(a2));
        }
        this.f2898a.c();
    }
}
