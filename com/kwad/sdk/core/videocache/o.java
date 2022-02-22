package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.aq;
import java.io.File;
/* loaded from: classes4.dex */
public final class o {
    public static File a(Context context) {
        return new File(aq.b(context), "video-cache");
    }
}
