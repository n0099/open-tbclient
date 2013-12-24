package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: i  reason: default package */
/* loaded from: classes.dex */
public class i implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ aq a;
    private Uri b;
    private String c;
    private String d;
    private String e;

    public i(aq aqVar, Uri uri, String str, String str2, String str3) {
        this.a = aqVar;
        this.b = uri;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        String str;
        String str2;
        String str3;
        int a;
        if (bitmap != null) {
            a = this.a.a(bitmap, 150);
            this.a.a(this.c, this.d, this.e, Bitmap.createScaledBitmap(bitmap, 150, a, true));
            return;
        }
        if (this.b != null) {
            str3 = aq.a;
            Log.e(str3, "fail to load image uri from" + this.b.toString());
        }
        str = this.a.h;
        IBaiduListener a2 = aq.a(str);
        str2 = this.a.h;
        aq.b(str2);
        a2.onError(new BaiduException("failed to load image uri "));
    }
}
