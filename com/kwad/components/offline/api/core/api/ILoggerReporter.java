package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes10.dex */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(b bVar);
}
