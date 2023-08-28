package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public ConcurrentHashMap<String, DownloadParams> Tf;
    public ConcurrentHashMap<String, AdTemplate> Tg;

    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0678a {
        public static final a Th = new a((byte) 0);
    }

    public a() {
        this.Tf = new ConcurrentHashMap<>();
        this.Tg = new ConcurrentHashMap<>();
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a rD() {
        return C0678a.Th;
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return;
        }
        this.Tf.put(str, downloadParams);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final void b(String str, AdTemplate adTemplate) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return;
        }
        this.Tg.put(str, adTemplate);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public final DownloadParams bm(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.Tf.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        return null;
    }

    public final void bn(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return;
        }
        this.Tf.remove(str);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final AdTemplate bo(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.Tg.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final void bp(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return;
        }
        this.Tg.remove(str);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }
}
