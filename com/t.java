package com;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RelativeLayout;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.social.share.uiwithlayout.CheckImageView;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class t implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ RelativeLayout a;
    final /* synthetic */ ShareDialog lp;

    public t(ShareDialog shareDialog, RelativeLayout relativeLayout) {
        this.lp = shareDialog;
        this.a = relativeLayout;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        String str;
        CheckImageView checkImageView;
        CheckImageView checkImageView2;
        if (bitmap == null || bitmap.isRecycled()) {
            str = ShareDialog.a;
            Log.e(str, "load image null");
            return;
        }
        checkImageView = this.lp.g;
        checkImageView.setImageBitmap(bitmap);
        checkImageView2 = this.lp.g;
        checkImageView2.setChecked(true);
        this.a.setVisibility(0);
    }
}
