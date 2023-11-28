package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class TkLoggerReporter {

    /* loaded from: classes10.dex */
    public static final class Holder {
        public static final TkLoggerReporter sInstance = new TkLoggerReporter();
    }

    public TkLoggerReporter() {
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, b bVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(bVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(b.zP().cl(str).i(0.1d).L("ad_tk_download_performance", "download_state").h(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(b.zP().cl(str).i(0.1d).k(0.001d).L("ad_tk_render_performance", "render_state").h(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(b.zP().cl(str).i(0.1d).L("ad_tk_so_download_event", "download_state").h(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(b.zP().cl(str).i(0.1d).L("ad_tk_so_load_performence", "download_state").h(jSONObject));
    }
}
