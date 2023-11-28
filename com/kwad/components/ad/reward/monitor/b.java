package com.kwad.components.ad.reward.monitor;

import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b {
    public static void a(AdTemplate adTemplate, TKRenderFailReason tKRenderFailReason) {
        boolean z;
        String str;
        int i;
        if (e.dJ(adTemplate) == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "ad_sdk_neo_page_native_monitor";
        } else {
            str = "ad_sdk_fullscreen_page_native_monitor";
        }
        if (TKRenderFailReason.SWITCH_CLOSE.equals(tKRenderFailReason)) {
            if (z) {
                i = 102003;
            } else {
                i = 103003;
            }
        } else if (TKRenderFailReason.TK_FILE_LOAD_ERROR.equals(tKRenderFailReason)) {
            if (z) {
                i = 102004;
            } else {
                i = 103004;
            }
        } else {
            i = 102005;
        }
        a(z, str, adTemplate, i);
    }

    public static void a(boolean z, AdTemplate adTemplate) {
        String str;
        int i;
        if (z) {
            str = "ad_sdk_neo_video_cache_monitor";
        } else {
            str = "ad_sdk_fullscreen_video_cache_monitor";
        }
        if (z) {
            i = 102001;
        } else {
            i = 103001;
        }
        a(z, str, adTemplate, i);
    }

    public static void b(boolean z, AdTemplate adTemplate) {
        String str;
        int i;
        if (z) {
            str = "ad_sdk_neo_page_enter_monitor";
        } else {
            str = "ad_sdk_fullscreen_page_enter_monitor";
        }
        if (z) {
            i = 102002;
        } else {
            i = 103002;
        }
        a(z, str, adTemplate, i);
    }

    public static void c(boolean z, int i) {
        String str;
        if (z) {
            str = "ad_sdk_neo_request_monitor";
        } else {
            str = "ad_sdk_fullscreen_request_monitor";
        }
        a(z, str, null, i);
    }

    public static void a(boolean z, String str, AdTemplate adTemplate, int i) {
        long j;
        AdInfo dP;
        if (adTemplate != null && (dP = e.dP(adTemplate)) != null) {
            j = com.kwad.sdk.core.response.b.a.J(dP);
        } else {
            j = 0;
        }
        com.kwad.sdk.commercial.a.a(z, str, new RewardMonitorInfo().setErrorCode(i).setCreativeId(j).setAdTemplate(adTemplate));
    }

    public static void c(boolean z, AdTemplate adTemplate) {
        String str;
        int i;
        if (z) {
            str = "ad_sdk_neo_video_play_monitor";
        } else {
            str = "ad_sdk_fullscreen_video_play_monitor";
        }
        if (z) {
            i = 102007;
        } else {
            i = 103007;
        }
        a(z, str, adTemplate, i);
    }
}
