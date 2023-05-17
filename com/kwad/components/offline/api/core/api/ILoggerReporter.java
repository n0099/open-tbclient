package com.kwad.components.offline.api.core.api;

import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(double d, String str, BusinessType businessType, String str2, JSONObject jSONObject);
}
