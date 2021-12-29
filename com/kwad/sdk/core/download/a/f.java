package com.kwad.sdk.core.download.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import java.io.File;
/* loaded from: classes3.dex */
public class f {
    public static AdDownloadProxy a(Context context, @NonNull File file, @NonNull com.ksad.download.a aVar, boolean z) {
        com.ksad.download.d.a(context, file, new com.kwad.sdk.core.download.b.a(context));
        com.ksad.download.d.a().a(new com.kwad.sdk.core.download.a());
        com.ksad.download.b.a(aVar);
        return new com.kwad.sdk.core.download.c.a(z);
    }
}
