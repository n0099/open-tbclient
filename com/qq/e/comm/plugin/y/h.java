package com.qq.e.comm.plugin.y;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;
/* loaded from: classes4.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private static final SM f13001a = GDTADManager.getInstance().getSM();

    /* renamed from: b  reason: collision with root package name */
    private static final int f13002b = new Random(System.currentTimeMillis()).nextInt(10000);
    private static final int c = f13001a.getInteger("maxSingleSize", 1024);
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
        d = f13002b < f13001a.getInteger("perfRate", 0);
        e = f13002b < f13001a.getInteger("eventRate", 0);
        f = f13001a.getInteger("eventInstant", 0) == 1;
        g = f13001a.getInteger("maxCount", 30);
        h = f13001a.getInteger("perfInstant", 0) == 1;
        i = f13001a.getInteger("perfPeriod", 600);
        j = f13001a.getInteger("eventPeriod", 600);
        k = f13001a.getInteger("perfBatchCount", 30);
        l = f13001a.getInteger("eventBatchCount", 30);
        m = f13001a.getInteger("perfNetPer", 30);
        n = f13001a.getInteger("eventNetPer", 30);
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
