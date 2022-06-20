package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public ConcurrentHashMap<String, DownloadParams> a;
    public ConcurrentHashMap<String, AdTemplate> b;

    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0301a {
        public static final a a = new a();
    }

    public a() {
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C0301a.a;
    }

    public DownloadParams a(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.a.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
        return null;
    }

    public void a(String str, DownloadParams downloadParams) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.a.put(str, downloadParams);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public void a(String str, AdTemplate adTemplate) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.b.put(str, adTemplate);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public void b(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.a.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public AdTemplate c(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.b.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
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

    public void d(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.b.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }
}
