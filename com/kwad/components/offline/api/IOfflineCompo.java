package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes7.dex */
public interface IOfflineCompo {

    /* loaded from: classes7.dex */
    public interface Priority {
        public static final int HIGH = -100;
        public static final int HIGHEST = -200;
        public static final int LOW = 100;
        public static final int LOWEST = 200;
        public static final int NORMAL = 0;
    }

    Class getComponentsType();

    void init(Context context, SdkConfig sdkConfig);

    int priority();
}
