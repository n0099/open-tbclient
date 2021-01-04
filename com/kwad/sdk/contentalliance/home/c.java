package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f9012a;

    /* renamed from: b  reason: collision with root package name */
    private static List<AdTemplate> f9013b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f9012a = System.currentTimeMillis();
        f9013b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f9012a <= 120000) {
            return !f9013b.isEmpty();
        }
        c();
        return false;
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f9013b;
    }

    @MainThread
    public static void c() {
        f9013b.clear();
    }
}
