package com.google.android.gms.common.internal;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.sina.weibo.sdk.utils.ResourceManager;
@KeepForSdk
/* loaded from: classes8.dex */
public final class ResourceUtils {
    public static final Uri zza = new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).authority("com.google.android.gms").appendPath(ResourceManager.DRAWABLE).build();
}
