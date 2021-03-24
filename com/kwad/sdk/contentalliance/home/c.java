package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f32726a;

    /* renamed from: b  reason: collision with root package name */
    public static List<AdTemplate> f32727b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f32726a = System.currentTimeMillis();
        f32727b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f32726a > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            c();
            return false;
        }
        return !f32727b.isEmpty();
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f32727b;
    }

    @MainThread
    public static void c() {
        f32727b.clear();
    }
}
