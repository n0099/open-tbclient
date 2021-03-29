package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f32727a;

    /* renamed from: b  reason: collision with root package name */
    public static List<AdTemplate> f32728b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f32727a = System.currentTimeMillis();
        f32728b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f32727a > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            c();
            return false;
        }
        return !f32728b.isEmpty();
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f32728b;
    }

    @MainThread
    public static void c() {
        f32728b.clear();
    }
}
