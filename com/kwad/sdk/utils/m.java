package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class m {
    public static long a = -1;

    public static void a(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = a;
            adTemplate.mOutClickTimeParam = a;
        }
    }

    public static void b(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void c(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long d(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j = adTemplate.mOutClickTimeParam;
        return j > 0 ? j : adTemplate.mVisibleTimeParam;
    }
}
