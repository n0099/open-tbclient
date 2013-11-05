package defpackage;

import android.graphics.Bitmap;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.CompressBitmapTask;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* renamed from: ac  reason: default package */
/* loaded from: classes.dex */
public class ac implements AsyncImageLoader.IAsyncImageLoaderListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultipartRequestParams f262a;
    final /* synthetic */ IBaiduListener b;
    final /* synthetic */ CloudBatchShareHandler c;

    public ac(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, IBaiduListener iBaiduListener) {
        this.c = cloudBatchShareHandler;
        this.f262a = multipartRequestParams;
        this.b = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap != null) {
            new CompressBitmapTask(new c(this)).execute(bitmap);
        } else {
            this.c.a(this.c.getShareUrl(), this.f262a, this.b);
        }
    }
}
