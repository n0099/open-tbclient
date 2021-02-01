package com.qq.e.comm.plugin.y;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;
/* loaded from: classes15.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private static final SM f12703a = GDTADManager.getInstance().getSM();

    /* renamed from: b  reason: collision with root package name */
    private static final int f12704b = new Random(System.currentTimeMillis()).nextInt(10000);
    private static final int c = f12703a.getInteger("maxSingleSize", 1024);
    private static final boolean d;
    private static final boolean e;
    private static final boolean f;
    private static final int g;
    private static final boolean h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    private static final int n;

    static {
        d = f12704b < f12703a.getInteger("perfRate", 0);
        e = f12704b < f12703a.getInteger("eventRate", 0);
        f = f12703a.getInteger("eventInstant", 0) == 1;
        g = f12703a.getInteger("maxCount", 30);
        h = f12703a.getInteger("perfInstant", 0) == 1;
        i = f12703a.getInteger("perfPeriod", 600);
        j = f12703a.getInteger("eventPeriod", 600);
        k = f12703a.getInteger("perfBatchCount", 30);
        l = f12703a.getInteger("eventBatchCount", 30);
        m = f12703a.getInteger("perfNetPer", 30);
        n = f12703a.getInteger("eventNetPer", 30);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return c;
    }

    static int b() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return e;
    }

    static boolean e() {
        return h;
    }

    static boolean f() {
        return f;
    }

    static int g() {
        return i;
    }

    static int h() {
        return j;
    }

    static int i() {
        return k;
    }

    static int j() {
        return l;
    }

    static boolean k() {
        return (GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() & m) > 0;
    }

    static boolean l() {
        return (GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() & n) > 0;
    }
}
