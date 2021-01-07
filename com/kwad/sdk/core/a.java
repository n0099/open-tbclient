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

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, DownloadParams> f9330a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, AdTemplate> f9331b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1101a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f9332a = new a();
    }

    private a() {
        this.f9330a = new ConcurrentHashMap<>();
        this.f9331b = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C1101a.f9332a;
    }

    public DownloadParams a(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.f9330a.get(str);
        if (downloadParams == null) {
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
        return downloadParams;
    }

    public void a(String str, DownloadParams downloadParams) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f9330a.put(str, downloadParams);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public void a(String str, AdTemplate adTemplate) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f9331b.put(str, adTemplate);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public void b(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f9330a.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public AdTemplate c(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.f9331b.get(str);
        if (adTemplate == null) {
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
        return adTemplate;
    }

    public void d(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f9331b.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }
}
