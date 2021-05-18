package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static f f32787a;

    public static f a(Context context) {
        f fVar = f32787a;
        if (fVar == null) {
            f b2 = b(context);
            f32787a = b2;
            return b2;
        }
        return fVar;
    }

    public static f b(Context context) {
        return new f.a(context).a(DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT).a();
    }
}
