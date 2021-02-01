package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f8715a;

    /* renamed from: b  reason: collision with root package name */
    private static List<AdTemplate> f8716b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f8715a = System.currentTimeMillis();
        f8716b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f8715a <= 120000) {
            return !f8716b.isEmpty();
        }
        c();
        return false;
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f8716b;
    }

    @MainThread
    public static void c() {
        f8716b.clear();
    }
}
