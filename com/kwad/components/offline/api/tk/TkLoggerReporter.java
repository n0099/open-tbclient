package com.kwad.components.offline.api.tk;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.utils.r;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class TkLoggerReporter {

    /* loaded from: classes8.dex */
    public static final class Holder {
        public static final TkLoggerReporter sInstance = new TkLoggerReporter();
    }

    public TkLoggerReporter() {
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    public static double getSamplingRate() {
        return OfflineHostProvider.getApi().tkLoggerSamplingRate();
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject) {
        if (!jSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_RATION)) {
            r.putValue(jSONObject, MapBundleKey.OfflineMapKey.OFFLINE_RATION, getSamplingRate());
        }
        OfflineHostProvider.getApi().loggerReporter().reportEvent(getSamplingRate(), str, BusinessType.TACHIKOMA, str2, jSONObject);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_download_performance", jSONObject);
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_render_performance", jSONObject);
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_so_download_event", jSONObject);
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_so_load_performence", jSONObject);
    }
}
