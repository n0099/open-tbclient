package com.kwad.sdk.plugin;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.b.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes10.dex */
public interface b extends d {
    void a(int i2);

    void a(Context context);

    void a(Context context, AdTemplate adTemplate, int i2);

    void a(Context context, String str);

    void a(@NonNull SdkConfigData sdkConfigData);

    i b();

    void c();

    void d();

    int e();
}
