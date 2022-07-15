package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.ap;
import java.io.File;
/* loaded from: classes5.dex */
public final class n {
    public static File a(Context context) {
        return new File(ap.b(context), "video-cache");
    }
}
