package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class d {
    private static long c = AppStatusRules.DEFAULT_GRANULARITY;
    private static final ConcurrentHashMap<String, Boolean> d;

    /* renamed from: a  reason: collision with root package name */
    private final com.sdk.base.framework.a.a.c<String, String> f7618a;
    private int b;

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        d = concurrentHashMap;
        concurrentHashMap.put(i.f7621a.toString(), true);
        new ConcurrentHashMap(10);
    }

    public d() {
        this(BdStatsConstant.MAX_WRITE_LOG_SIZE, AppStatusRules.DEFAULT_GRANULARITY);
    }

    private d(int i, long j) {
        this.b = BdStatsConstant.MAX_WRITE_LOG_SIZE;
        this.b = BdStatsConstant.MAX_WRITE_LOG_SIZE;
        c = AppStatusRules.DEFAULT_GRANULARITY;
        this.f7618a = new e(this, this.b);
    }

    public static long a() {
        return c;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean b(String str) {
        Boolean bool;
        if (!TextUtils.isEmpty(str) && (bool = d.get(str.toUpperCase())) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final String a(String str) {
        if (str != null) {
            return this.f7618a.a((com.sdk.base.framework.a.a.c<String, String>) str);
        }
        return null;
    }

    public final void a(String str, String str2, long j) {
        if (str == null || str2 == null || j < 1) {
            return;
        }
        this.f7618a.a((com.sdk.base.framework.a.a.c<String, String>) str, str2, System.currentTimeMillis() + j);
    }
}
