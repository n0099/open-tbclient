package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
/* loaded from: classes6.dex */
public interface e<R> {
    boolean a(@Nullable GlideException glideException, Object obj, j<R> jVar, boolean z);

    boolean a(R r, Object obj, j<R> jVar, DataSource dataSource, boolean z);
}
