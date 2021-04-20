package d.b.g0.a.s0.k.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.i2.p;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.y0.e.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46285e = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Long> f46286a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f46287b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f46288c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46289d = false;

    /* renamed from: d.b.g0.a.s0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0804a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f46290e;

        public RunnableC0804a(b.a aVar) {
            this.f46290e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i(this.f46290e);
        }
    }

    public final void b() {
        this.f46286a.clear();
        this.f46287b.clear();
    }

    public synchronized void c() {
        this.f46289d = true;
    }

    public synchronized boolean d(@NonNull String str) {
        return this.f46286a.containsKey(str);
    }

    public synchronized boolean e(@NonNull String str) {
        return this.f46287b.containsKey(str);
    }

    public synchronized boolean f() {
        return this.f46289d;
    }

    public synchronized void g(String str, String str2) {
        if (!this.f46289d) {
            this.f46287b.put(str, str2);
        }
    }

    public synchronized void h(@NonNull String str) {
        if (!this.f46289d && !this.f46286a.containsKey(str)) {
            this.f46286a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized void i(b.a aVar) {
        if (this.f46288c) {
            return;
        }
        this.f46288c = true;
        boolean equals = TextUtils.equals("1", this.f46287b.get("autoPlay"));
        boolean equals2 = TextUtils.equals("1", this.f46287b.get("playMethod"));
        if (f46285e) {
            Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
        }
        if (!equals && !equals2) {
            b();
            return;
        }
        i.q("video");
        HybridUbcFlow o = i.o("video");
        for (Map.Entry<String, Long> entry : this.f46286a.entrySet()) {
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
            ubcFlowEvent.h(entry.getValue().longValue());
            o.A(ubcFlowEvent);
        }
        for (Map.Entry<String, String> entry2 : this.f46287b.entrySet()) {
            o.y(entry2.getKey(), entry2.getValue());
        }
        String g2 = o.g("fmpArrived");
        if (TextUtils.isEmpty(g2)) {
            g2 = "0";
        }
        o.y("fmpArrived", g2);
        long k = aVar.k("launch_time", 0L);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_start");
        ubcFlowEvent2.h(k);
        o.A(ubcFlowEvent2);
        o.y("launchID", aVar.U());
        o.w();
        b();
    }

    public void j() {
        p.k(new RunnableC0804a(d.e().s().J()), "VideoStaticRecorder");
    }
}
