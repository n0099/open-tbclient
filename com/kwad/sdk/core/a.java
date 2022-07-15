package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public ConcurrentHashMap<String, DownloadParams> a;
    public ConcurrentHashMap<String, AdTemplate> b;

    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0536a {
        public static final a a = new a((byte) 0);
    }

    public a() {
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0536a.a;
    }

    public final DownloadParams a(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() == null) {
            return null;
        }
        DownloadParams downloadParams = this.a.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
        return null;
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() == null) {
            return;
        }
        this.a.put(str, downloadParams);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final void a(String str, AdTemplate adTemplate) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() == null) {
            return;
        }
        this.b.put(str, adTemplate);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public final void b(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() == null) {
            return;
        }
        this.a.remove(str);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final AdTemplate c(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() == null) {
            return null;
        }
        AdTemplate adTemplate = this.b.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
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

    public final void d(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a() == null) {
            return;
        }
        this.b.remove(str);
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }
}
