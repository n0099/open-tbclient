package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f33016a;

    /* renamed from: b  reason: collision with root package name */
    public static List<AdTemplate> f33017b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f33016a = System.currentTimeMillis();
        f33017b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f33016a > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            c();
            return false;
        }
        return !f33017b.isEmpty();
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f33017b;
    }

    @MainThread
    public static void c() {
        f33017b.clear();
    }
}
