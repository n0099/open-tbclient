package com.fun.ad.sdk.internal.api.flavor;

import android.content.Context;
/* loaded from: classes4.dex */
public interface CachingAware {
    boolean isCachingAware();

    Context wrap(Context context);
}
