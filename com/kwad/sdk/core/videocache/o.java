package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.ad;
import java.io.File;
/* loaded from: classes3.dex */
public final class o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(Context context) {
        return new File(ad.b(context), "video-cache");
    }
}
