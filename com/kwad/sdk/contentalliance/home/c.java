package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f33111a;

    /* renamed from: b  reason: collision with root package name */
    public static List<AdTemplate> f33112b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f33111a = System.currentTimeMillis();
        f33112b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f33111a > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            c();
            return false;
        }
        return !f33112b.isEmpty();
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f33112b;
    }

    @MainThread
    public static void c() {
        f33112b.clear();
    }
}
