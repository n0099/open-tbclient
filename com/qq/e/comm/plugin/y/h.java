package com.qq.e.comm.plugin.y;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;
/* loaded from: classes3.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private static final SM f12701a = GDTADManager.getInstance().getSM();

    /* renamed from: b  reason: collision with root package name */
    private static final int f12702b = new Random(System.currentTimeMillis()).nextInt(10000);
    private static final int c = f12701a.getInteger("maxSingleSize", 1024);
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
        d = f12702b < f12701a.getInteger("perfRate", 0);
        e = f12702b < f12701a.getInteger("eventRate", 0);
        f = f12701a.getInteger("eventInstant", 0) == 1;
        g = f12701a.getInteger("maxCount", 30);
        h = f12701a.getInteger("perfInstant", 0) == 1;
        i = f12701a.getInteger("perfPeriod", 600);
        j = f12701a.getInteger("eventPeriod", 600);
        k = f12701a.getInteger("perfBatchCount", 30);
        l = f12701a.getInteger("eventBatchCount", 30);
        m = f12701a.getInteger("perfNetPer", 30);
        n = f12701a.getInteger("eventNetPer", 30);
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
