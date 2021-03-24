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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45892e = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Long> f45893a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f45894b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f45895c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45896d = false;

    /* renamed from: d.b.g0.a.s0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0791a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f45897e;

        public RunnableC0791a(b.a aVar) {
            this.f45897e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i(this.f45897e);
        }
    }

    public final void b() {
        this.f45893a.clear();
        this.f45894b.clear();
    }

    public synchronized void c() {
        this.f45896d = true;
    }

    public synchronized boolean d(@NonNull String str) {
        return this.f45893a.containsKey(str);
    }

    public synchronized boolean e(@NonNull String str) {
        return this.f45894b.containsKey(str);
    }

    public synchronized boolean f() {
        return this.f45896d;
    }

    public synchronized void g(String str, String str2) {
        if (!this.f45896d) {
            this.f45894b.put(str, str2);
        }
    }

    public synchronized void h(@NonNull String str) {
        if (!this.f45896d && !this.f45893a.containsKey(str)) {
            this.f45893a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized void i(b.a aVar) {
        if (this.f45895c) {
            return;
        }
        this.f45895c = true;
        boolean equals = TextUtils.equals("1", this.f45894b.get("autoPlay"));
        boolean equals2 = TextUtils.equals("1", this.f45894b.get("playMethod"));
        if (f45892e) {
            Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
        }
        if (!equals && !equals2) {
            b();
            return;
        }
        i.q("video");
        HybridUbcFlow o = i.o("video");
        for (Map.Entry<String, Long> entry : this.f45893a.entrySet()) {
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
            ubcFlowEvent.h(entry.getValue().longValue());
            o.A(ubcFlowEvent);
        }
        for (Map.Entry<String, String> entry2 : this.f45894b.entrySet()) {
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
        p.k(new RunnableC0791a(d.e().s().J()), "VideoStaticRecorder");
    }
}
