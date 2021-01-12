package com.qq.e.comm.plugin.y;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.GDTLogger;
import yaq.gdtadv;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private Handler f12714a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12715b;
    private m c;
    private q d;
    private Runnable e;
    private Runnable f;
    private Runnable g;

    /* renamed from: com.qq.e.comm.plugin.y.s$10  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass10 extends BroadcastReceiver {
        AnonymousClass10() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            s.f(s.this);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.y.s$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12718a = new int[b.values().length];

        static {
            try {
                f12718a[b.SDK_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12718a[b.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12718a[b.ITEM_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12718a[b.PAGE_SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12718a[b.NETWORK_CHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.qq.e.comm.plugin.y.s$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.y.a f12719a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f12720b;

        AnonymousClass3(com.qq.e.comm.plugin.y.a aVar, n nVar) {
            this.f12719a = aVar;
            this.f12720b = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12719a.a((com.qq.e.comm.plugin.y.a) this.f12720b);
            s.this.a(b.ITEM_ADD);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.y.s$7  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.d(s.this).a();
            s.e(s.this).a();
        }
    }

    /* renamed from: com.qq.e.comm.plugin.y.s$8  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.d(s.this).b();
            s.e(s.this).b();
        }
    }

    /* renamed from: com.qq.e.comm.plugin.y.s$9  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.d(s.this).d();
            s.e(s.this).d();
        }
    }

    @TargetApi(14)
    /* loaded from: classes3.dex */
    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private s f12727a;

        public a(s sVar) {
            this.f12727a = sVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            s.g(this.f12727a);
            s.h(this.f12727a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.f12727a.a(b.PAGE_SWITCH);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes3.dex */
    private enum b {
        SDK_INIT,
        BACKGROUND,
        ITEM_ADD,
        PAGE_SWITCH,
        NETWORK_CHANGE
    }

    /* loaded from: classes3.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private static final s f12730a = new s();
    }

    private s() {
        this.e = new Runnable() { // from class: com.qq.e.comm.plugin.y.s.4
            @Override // java.lang.Runnable
            public void run() {
                s.b(s.this);
            }
        };
        this.f = new Runnable() { // from class: com.qq.e.comm.plugin.y.s.5
            @Override // java.lang.Runnable
            public void run() {
                s.c(s.this);
            }
        };
        this.g = new Runnable() { // from class: com.qq.e.comm.plugin.y.s.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.qq.e.comm.plugin.util.o.a(s.a(s.this))) {
                    return;
                }
                s.this.a(b.BACKGROUND);
            }
        };
        this.f12715b = GDTADManager.getInstance().getAppContext();
        this.c = new m(this.f12715b);
        this.d = new q(this.f12715b);
        HandlerThread handlerThread = new HandlerThread("gdt_stat_service");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            this.f12714a = new Handler(looper);
        } else {
            GDTLogger.e("Create stat handler failed!");
        }
        if (Build.VERSION.SDK_INT >= 14 && (this.f12715b instanceof Application)) {
            ai.a("Stat register activity listener", new Object[0]);
            ((Application) this.f12715b).registerActivityLifecycleCallbacks(new a(this));
        }
        a(this.f12715b);
        a(b.SDK_INIT);
        if (this.f12714a != null) {
            this.f12714a.post(new Runnable() { // from class: com.qq.e.comm.plugin.y.s.1
                @Override // java.lang.Runnable
                public void run() {
                    i.a(s.a(s.this).getApplicationContext()).a();
                }
            });
        }
    }

    static /* synthetic */ Context a(s sVar) {
        return (Context) gdtadv.getobjresult(Opcodes.IFNE, 1, sVar);
    }

    public static s a() {
        return (s) gdtadv.getobjresult(155, 1, new Object[0]);
    }

    private <T extends n> void a(com.qq.e.comm.plugin.y.a<T> aVar, T t) {
        gdtadv.getVresult(156, 0, this, aVar, t);
    }

    private void b() {
        gdtadv.getVresult(157, 0, this);
    }

    static /* synthetic */ void b(s sVar) {
        gdtadv.getVresult(Opcodes.IFLE, 1, sVar);
    }

    private void c() {
        gdtadv.getVresult(Opcodes.IF_ICMPEQ, 0, this);
    }

    static /* synthetic */ void c(s sVar) {
        gdtadv.getVresult(160, 1, sVar);
    }

    static /* synthetic */ m d(s sVar) {
        return (m) gdtadv.getobjresult(161, 1, sVar);
    }

    private void d() {
        gdtadv.getVresult(162, 0, this);
    }

    static /* synthetic */ q e(s sVar) {
        return (q) gdtadv.getobjresult(Opcodes.IF_ICMPGT, 1, sVar);
    }

    private void e() {
        gdtadv.getVresult(164, 0, this);
    }

    private void f() {
        gdtadv.getVresult(Opcodes.IF_ACMPEQ, 0, this);
    }

    static /* synthetic */ void f(s sVar) {
        gdtadv.getVresult(Opcodes.IF_ACMPNE, 1, sVar);
    }

    static /* synthetic */ void g(s sVar) {
        gdtadv.getVresult(167, 1, sVar);
    }

    static /* synthetic */ void h(s sVar) {
        gdtadv.getVresult(168, 1, sVar);
    }

    public void a(Context context) {
        gdtadv.getVresult(Opcodes.RET, 0, this, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        gdtadv.getVresult(Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 0, this, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(o oVar) {
        gdtadv.getVresult(Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 0, this, oVar);
    }

    void a(b bVar) {
        gdtadv.getVresult(172, 0, this, bVar);
    }
}
