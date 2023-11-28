package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.commercial.a;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
/* loaded from: classes10.dex */
public class ImageLoaderPerfUtil {
    public static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = y.Kq();
        imageLoaderInfo.successCount = y.Kr();
        imageLoaderInfo.failedCount = y.Ks();
        imageLoaderInfo.duration = y.Kp();
        return imageLoaderInfo;
    }

    public static void report() {
        g.execute(new ay() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount != 0) {
                    String str = ImageLoaderPerfUtil.TAG;
                    c.d(str, "ImageLoaderInfo:" + info.toJson().toString());
                    a.q(info);
                    return;
                }
                c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
            }
        });
    }
}
