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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f2735a;
    private Uri b;
    private String c;
    private String d;
    private String e;

    public i(aq aqVar, Uri uri, String str, String str2, String str3) {
        this.f2735a = aqVar;
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
        int a2;
        if (bitmap != null) {
            a2 = this.f2735a.a(bitmap, 150);
            this.f2735a.a(this.c, this.d, this.e, Bitmap.createScaledBitmap(bitmap, 150, a2, true));
            return;
        }
        if (this.b != null) {
            str3 = aq.f362a;
            Log.e(str3, "fail to load image uri from" + this.b.toString());
        }
        str = this.f2735a.h;
        IBaiduListener a3 = aq.a(str);
        str2 = this.f2735a.h;
        aq.b(str2);
        a3.onError(new BaiduException("failed to load image uri "));
    }
}
