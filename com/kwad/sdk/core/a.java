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
    public ConcurrentHashMap<String, DownloadParams> f33411a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, AdTemplate> f33412b;

    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0374a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33413a = new a();
    }

    public a() {
        this.f33411a = new ConcurrentHashMap<>();
        this.f33412b = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C0374a.f33413a;
    }

    public DownloadParams a(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.f33411a.get(str);
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
        this.f33411a.put(str, downloadParams);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public void a(String str, AdTemplate adTemplate) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f33412b.put(str, adTemplate);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public void b(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        this.f33411a.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public AdTemplate c(String str) {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.f33412b.get(str);
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
        this.f33412b.remove(str);
        KsAdSDKImpl.get().getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }
}
