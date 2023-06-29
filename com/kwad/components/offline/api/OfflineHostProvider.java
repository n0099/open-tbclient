package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.core.IOfflineHostApi;
/* loaded from: classes10.dex */
public class OfflineHostProvider {
    public Context mContext;
    public IOfflineHostApi mOfflineHostApi;

    /* loaded from: classes10.dex */
    public static final class Holder {
        public static final OfflineHostProvider sInstance = new OfflineHostProvider();
    }

    public OfflineHostProvider() {
    }

    public static OfflineHostProvider get() {
        return Holder.sInstance;
    }

    public static IOfflineHostApi getApi() {
        return get().mOfflineHostApi;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void init(Context context, IOfflineHostApi iOfflineHostApi) {
        this.mContext = context;
        this.mOfflineHostApi = iOfflineHostApi;
    }
}
