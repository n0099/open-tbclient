package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, DownloadParams> f32054a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, AdTemplate> f32055b;

    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0359a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32056a = new a();
    }

    public a() {
        this.f32054a = new ConcurrentHashMap<>();
        this.f32055b = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C0359a.f32056a;
    }

    public DownloadParams a(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.f32054a.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        return null;
    }

    public void a(String str, DownloadParams downloadParams) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f32054a.put(str, downloadParams);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public void a(String str, AdTemplate adTemplate) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f32055b.put(str, adTemplate);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public void b(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f32054a.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public AdTemplate c(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.f32055b.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void d(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f32055b.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }
}
