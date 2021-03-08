package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f5810a;
    private static List<AdTemplate> b = new ArrayList();

    @MainThread
    public static void a(List<AdTemplate> list) {
        c();
        f5810a = System.currentTimeMillis();
        b.addAll(list);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f5810a <= 120000) {
            return !b.isEmpty();
        }
        c();
        return false;
    }

    @MainThread
    public static List<AdTemplate> b() {
        return b;
    }

    @MainThread
    public static void c() {
        b.clear();
    }
}
