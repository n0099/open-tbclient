package com.meizu.cloud.pushsdk.common.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.meizu.cloud.pushsdk.common.b.c;
import com.meizu.cloud.pushsdk.common.b.h;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a extends com.meizu.cloud.pushsdk.common.base.a<Context> {
    private static a c;
    private HandlerThread d;
    private Handler e;
    private HashMap<Integer, ArrayList<Object>> f;
    private HashMap<Integer, Object> g;
    private ArrayList<Object> h;

    private a() {
        super("EventCore");
        this.f = new HashMap<>();
        this.g = new HashMap<>();
        this.h = new ArrayList<>();
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public a a(Runnable runnable) {
        this.e.post(runnable);
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context, T] */
    @Override // com.meizu.cloud.pushsdk.common.base.a
    protected synchronized void a() {
        if (this.a == 0) {
            throw new NullPointerException("context must not be null");
        }
        c.b(this.b, "onInit");
        this.a = ((Context) this.a).getApplicationContext();
        this.d = new HandlerThread(this.b);
        this.d.start();
        this.e = new Handler(this.d.getLooper());
    }

    @Override // com.meizu.cloud.pushsdk.common.base.a
    protected synchronized void b() {
        c.b(this.b, "onDestroy");
        if (this.d != null) {
            if (h.a(18)) {
                e();
            } else {
                this.d.quit();
            }
        }
        c = null;
    }

    @TargetApi(18)
    private void e() {
        this.d.quitSafely();
    }
}
