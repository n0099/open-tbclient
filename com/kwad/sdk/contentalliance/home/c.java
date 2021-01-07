package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f9013a;

    /* renamed from: b  reason: collision with root package name */
    private static List<AdTemplate> f9014b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f9013a = System.currentTimeMillis();
        f9014b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f9013a <= 120000) {
            return !f9014b.isEmpty();
        }
        c();
        return false;
    }

    @MainThread
    public static List<AdTemplate> b() {
        return f9014b;
    }

    @MainThread
    public static void c() {
        f9014b.clear();
    }
}
