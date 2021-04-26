package d.a.h0.a.s0.k.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.i2.p;
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.y0.e.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43985e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Long> f43986a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f43987b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f43988c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43989d = false;

    /* renamed from: d.a.h0.a.s0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0763a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f43990e;

        public RunnableC0763a(b.a aVar) {
            this.f43990e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i(this.f43990e);
        }
    }

    public final void b() {
        this.f43986a.clear();
        this.f43987b.clear();
    }

    public synchronized void c() {
        this.f43989d = true;
    }

    public synchronized boolean d(@NonNull String str) {
        return this.f43986a.containsKey(str);
    }

    public synchronized boolean e(@NonNull String str) {
        return this.f43987b.containsKey(str);
    }

    public synchronized boolean f() {
        return this.f43989d;
    }

    public synchronized void g(String str, String str2) {
        if (!this.f43989d) {
            this.f43987b.put(str, str2);
        }
    }

    public synchronized void h(@NonNull String str) {
        if (!this.f43989d && !this.f43986a.containsKey(str)) {
            this.f43986a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized void i(b.a aVar) {
        if (this.f43988c) {
            return;
        }
        this.f43988c = true;
        boolean equals = TextUtils.equals("1", this.f43987b.get("autoPlay"));
        boolean equals2 = TextUtils.equals("1", this.f43987b.get("playMethod"));
        if (f43985e) {
            Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
        }
        if (!equals && !equals2) {
            b();
            return;
        }
        i.q("video");
        HybridUbcFlow o = i.o("video");
        for (Map.Entry<String, Long> entry : this.f43986a.entrySet()) {
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
            ubcFlowEvent.h(entry.getValue().longValue());
            o.A(ubcFlowEvent);
        }
        for (Map.Entry<String, String> entry2 : this.f43987b.entrySet()) {
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
        p.k(new RunnableC0763a(d.e().p().J()), "VideoStaticRecorder");
    }
}
