package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static long f38457c = 60000;

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f38458d;

    /* renamed from: a  reason: collision with root package name */
    public final com.sdk.base.framework.a.a.c<String, String> f38459a;

    /* renamed from: b  reason: collision with root package name */
    public int f38460b;

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        f38458d = concurrentHashMap;
        concurrentHashMap.put(j.f38480a.toString(), Boolean.TRUE);
        new ConcurrentHashMap(10);
    }

    public d() {
        this(LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_BDMP, 60000L);
    }

    public d(int i, long j) {
        this.f38460b = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_BDMP;
        this.f38460b = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_BDMP;
        f38457c = 60000L;
        this.f38459a = new e(this, LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_BDMP);
    }

    public static long a() {
        return f38457c;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean b(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = f38458d.get(str.toUpperCase())) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String a(String str) {
        if (str != null) {
            return this.f38459a.a((com.sdk.base.framework.a.a.c<String, String>) str);
        }
        return null;
    }

    public final void a(String str, String str2, long j) {
        if (str == null || str2 == null || j < 1) {
            return;
        }
        this.f38459a.a((com.sdk.base.framework.a.a.c<String, String>) str, str2, System.currentTimeMillis() + j);
    }
}
