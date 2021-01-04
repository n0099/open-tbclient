package com.qq.e.comm.plugin.c;

import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, Future<com.qq.e.comm.plugin.s.b>> f12234a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicInteger f12235b = new AtomicInteger();

    /* renamed from: com.qq.e.comm.plugin.c.e$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f12236a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12237b;
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a c;

        AnonymousClass1(l lVar, f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12236a = lVar;
            this.f12237b = fVar;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().incrementAndGet();
            this.f12236a.a(this.f12237b, this.c);
            e.a().decrementAndGet();
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.e$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f12238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12239b;

        AnonymousClass2(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12238a = fVar;
            this.f12239b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().incrementAndGet();
            this.f12238a.C = true;
            if (com.qq.e.comm.plugin.a.d.d.a(com.qq.e.comm.plugin.a.l.a().a(this.f12238a.D.z().d()))) {
                d.b().a(this.f12238a, this.f12239b);
            } else {
                d.c().a(this.f12238a, this.f12239b);
            }
            e.a().decrementAndGet();
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.e$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f12240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12241b;
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a c;

        AnonymousClass3(l lVar, f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12240a = lVar;
            this.f12241b = fVar;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().incrementAndGet();
            this.f12240a.a(this.f12241b, this.c);
            e.a().decrementAndGet();
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.e$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12242a = new int[com.qq.e.comm.plugin.ad.e.values().length];

        static {
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.UNIFIED_BANNER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD2.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f12242a[com.qq.e.comm.plugin.ad.e.EXPRESS2.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    static /* synthetic */ AtomicInteger a() {
        return (AtomicInteger) gdtadv.getobjresult(292, 1, new Object[0]);
    }

    public static void a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        gdtadv.getVresult(293, 1, fVar, aVar);
    }

    private static boolean a(f fVar) {
        return gdtadv.getZresult(294, 1, fVar);
    }

    public static boolean a(com.qq.e.comm.plugin.s.a aVar) {
        return gdtadv.getZresult(295, 1, aVar);
    }

    private static int b() {
        return gdtadv.getIresult(296, 1, new Object[0]);
    }

    public static void b(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        gdtadv.getVresult(297, 1, fVar, aVar);
    }

    private static int c() {
        return gdtadv.getIresult(298, 1, new Object[0]);
    }

    public static void c(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        gdtadv.getVresult(299, 1, fVar, aVar);
    }

    private static int d() {
        return gdtadv.getIresult(300, 1, new Object[0]);
    }

    private static int e() {
        return gdtadv.getIresult(301, 1, new Object[0]);
    }

    private static int f() {
        return gdtadv.getIresult(302, 1, new Object[0]);
    }

    private static int g() {
        return gdtadv.getIresult(303, 1, new Object[0]);
    }

    private static int h() {
        return gdtadv.getIresult(304, 1, new Object[0]);
    }

    private static int i() {
        return gdtadv.getIresult(305, 1, new Object[0]);
    }

    private static int j() {
        return gdtadv.getIresult(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 1, new Object[0]);
    }
}
