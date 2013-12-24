package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: bc  reason: default package */
/* loaded from: classes.dex */
public class bc implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ ImageView a;
    final /* synthetic */ ImageButton b;
    final /* synthetic */ ShareDialog c;

    public bc(ShareDialog shareDialog, ImageView imageView, ImageButton imageButton) {
        this.c = shareDialog;
        this.a = imageView;
        this.b = imageButton;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        if (bitmap != null) {
            this.a.setImageBitmap(bitmap);
            this.b.setVisibility(0);
            this.c.f = true;
        }
    }
}
